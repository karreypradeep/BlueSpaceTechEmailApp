package com.bluespacetech.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluespacetech.core.exceptions.BusinessException;
import com.bluespacetech.core.utility.ViewUtil;
import com.bluespacetech.security.model.AccessControl;
import com.bluespacetech.security.model.UserAccount;
import com.bluespacetech.security.model.UserAccountUserGroup;
import com.bluespacetech.security.repository.UserAccountRepository;
import com.bluespacetech.security.repository.UserAccountRepositoryCustom;
import com.bluespacetech.security.searchcriterias.UserAccountSearchCriteria;

@Service
@Transactional
@PreAuthorize("hasAuthority('EXCLUDE_ALL')")
public class BlueSpaceTechUserAccountServiceImpl implements BlueSpaceTechUserAccountService {

	@Autowired
	UserAccountRepository userAccountRepository;

	@Autowired
	UserAccountRepositoryCustom userAccountRepositoryCustom;

	@Override
	@PreAuthorize("permitAll")
	public UserAccount findUserAccountByUsername(final String username) {
		return userAccountRepository.findUserAccountByUsername(username);
	}

	@Override
	@PreAuthorize("hasAuthority('ACC_TYPE_SUPER_ADMIN') or (hasAuthority('ACC_TYPE_ADMIN') and hasAuthority('ACCESS_USER_ACCOUNT'))")
	public List<UserAccount> getAllUserAccounts() {
		return userAccountRepository.findAll();
	}

	@Override
	@PreAuthorize("hasAuthority('ACC_TYPE_SUPER_ADMIN') or (hasAuthority('ACC_TYPE_ADMIN') and hasAuthority('ACCESS_USER_ACCOUNT'))")
	public UserAccount getUserAccountById(final Long userAccountId) {
		return userAccountRepository.findOne(userAccountId);
	}

	@Override
	@PreAuthorize("hasAuthority('ACC_TYPE_SUPER_ADMIN') or (hasAuthority('ACC_TYPE_ADMIN') and hasAuthority('ACCESS_USER_ACCOUNT'))")
	public List<UserAccount> getUserAccountByIds(final List<Long> userAccountIds) {
		return userAccountRepository.findAll(userAccountIds);
	}

	@Override
	@PreAuthorize("hasAuthority('ACC_TYPE_SUPER_ADMIN') or (hasAuthority('ACC_TYPE_ADMIN') and hasAuthority('CREATE_USER_ACCOUNT'))")
	public UserAccount createUserAccount(final UserAccount userAccount)
			throws BusinessException {
		final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		final String hashedPassword = passwordEncoder.encode("admin@123");
		userAccount.setPassword(hashedPassword);

		for (final UserAccountUserGroup userAccountUserGroup : userAccount.getUserAccountUserGroups()) {
			userAccountUserGroup.setUserAccount(userAccount);
		}

		for (final AccessControl accessControl : userAccount.getAccessControls()) {
			accessControl.setUserAccount(userAccount);
		}

		return userAccountRepository.save(userAccount);
	}

	@Override
	@PreAuthorize("hasAuthority('ACC_TYPE_SUPER_ADMIN') or (hasAuthority('ACC_TYPE_ADMIN') and hasAuthority('UPDATE_USER_ACCOUNT'))")
	public UserAccount updateUserAccount(final UserAccount userAccount)
			throws BusinessException {
		for (final UserAccountUserGroup userAccountUserGroup : userAccount.getUserAccountUserGroups()) {
			userAccountUserGroup.setUserAccount(userAccount);
		}

		for (final AccessControl accessControl : userAccount.getAccessControls()) {
			accessControl.setUserAccount(userAccount);
		}

		return userAccountRepository.save(userAccount);
	}

	@Override
	@PreAuthorize("hasAuthority('ACC_TYPE_SUPER_ADMIN') or (hasAuthority('ACC_TYPE_ADMIN') and hasAuthority('DELETE_USER_ACCOUNT'))")
	public void deleteUserAccount(final Long userAccountId) {
		userAccountRepository.delete(userAccountId);
	}

	@Override
	@PreAuthorize("hasAuthority('ACC_TYPE_SUPER_ADMIN') or (hasAuthority('ACC_TYPE_ADMIN') and hasAuthority('ACCESS_USER_ACCOUNT'))")
	public List<UserAccount> findUserAccountsBySearchCriteria(
			final UserAccountSearchCriteria userAccountSearchCriteria) {
		return userAccountRepositoryCustom.findUserAccountsBySearchCriteria(userAccountSearchCriteria);
	}

	@Override
	@PreAuthorize("hasAuthority('ACC_TYPE_SUPER_ADMIN') or (hasAuthority('ACC_TYPE_ADMIN') or hasAuthority('ACC_TYPE_EMPLOYEE'))")
	public void changePasswordUserAccount(final String oldPassword,final String newPassword,
			final String confirmPassword) throws BusinessException {

		if(!newPassword.equals(confirmPassword)){
			throw new BusinessException(
					"New Password and Confirm Password do not match.");
		}

		if(newPassword.equals(oldPassword)){
			throw new BusinessException(
					"New Password and Old Password cannot be same.");
		}

		final String userName = ViewUtil.getPrincipal();
		final UserAccount  userAccount = userAccountRepository.findUserAccountByUsername(userName);
		final PasswordEncoder encoder = new BCryptPasswordEncoder();
		final boolean oldPasspordMatched = encoder.matches(oldPassword, userAccount.getPassword());
		if(!oldPasspordMatched){
			throw new BusinessException(
					"Current Password is not correct.");
		}
		userAccount.setPassword(encoder.encode(newPassword));
		this.updateUserAccount(userAccount);
	}

}