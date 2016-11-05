package com.bluespacetech.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluespacetech.core.exceptions.BusinessException;
import com.bluespacetech.security.model.UserGroup;
import com.bluespacetech.security.model.UserGroupUserRole;
import com.bluespacetech.security.repository.UserGroupRepository;
import com.bluespacetech.security.repository.UserGroupRepositoryCustom;
import com.bluespacetech.security.searchcriterias.UserGroupSearchCriteria;

@Service
@Transactional
@PreAuthorize("hasAuthority('EXCLUDE_ALL')")
public class UserGroupServiceImpl implements UserGroupService {

	@Autowired
	UserGroupRepository userGroupRepository;

	@Autowired
	UserGroupRepositoryCustom userGroupRepositoryCustom;

	@Override
	@PreAuthorize("hasAuthority('ACC_TYPE_SUPER_ADMIN') or (hasAuthority('ACC_TYPE_ADMIN') and hasAuthority('ACCESS_USER_GROUP'))")
	public UserGroup findUserGroupByGroupName(final String groupName) {
		return userGroupRepository.findUserGroupByGroupName(groupName);
	}

	@Override
	@PreAuthorize("hasAuthority('ACC_TYPE_SUPER_ADMIN') or (hasAuthority('ACC_TYPE_ADMIN') and hasAuthority('ACCESS_USER_GROUP'))")
	public List<UserGroup> findByDescriptionLike(final String description) {
		return userGroupRepository.findByDescriptionLike(description);
	}

	@Override
	@PreAuthorize("hasAuthority('ACC_TYPE_SUPER_ADMIN') or (hasAuthority('ACC_TYPE_ADMIN') and hasAuthority('ACCESS_USER_GROUP'))")
	public List<UserGroup> getAllUserGroups() {
		return userGroupRepository.findAll();
	}

	@Override
	@PreAuthorize("hasAuthority('ACC_TYPE_SUPER_ADMIN') or (hasAuthority('ACC_TYPE_ADMIN') and hasAuthority('ACCESS_USER_GROUP'))")
	public UserGroup getUserGroupById(final Long userGroupId) {
		return userGroupRepository.findOne(userGroupId);
	}

	@Override
	@PreAuthorize("hasAuthority('ACC_TYPE_SUPER_ADMIN') or (hasAuthority('ACC_TYPE_ADMIN') and hasAuthority('CREATE_USER_GROUP'))")
	public UserGroup createUserGroup(final UserGroup userGroup) throws BusinessException {
		for(final UserGroupUserRole userGroupUserRole :userGroup.getUserGroupUserRoles()){
			userGroupUserRole.setUserGroup(userGroup);
		}
		return userGroupRepository.save(userGroup);
	}

	@Override
	@PreAuthorize("hasAuthority('ACC_TYPE_SUPER_ADMIN') or (hasAuthority('ACC_TYPE_ADMIN') and hasAuthority('UPDATE_USER_GROUP'))")
	public UserGroup updateUserGroup(final UserGroup userGroup) throws BusinessException {
		for(final UserGroupUserRole userGroupUserRole :userGroup.getUserGroupUserRoles()){
			userGroupUserRole.setUserGroup(userGroup);
		}
		return userGroupRepository.save(userGroup);
	}

	@Override
	@PreAuthorize("hasAuthority('ACC_TYPE_SUPER_ADMIN') or (hasAuthority('ACC_TYPE_ADMIN') and hasAuthority('DELETE_USER_GROUP'))")
	public void deleteUserGroup(final Long userGroupId) {
		userGroupRepository.delete(userGroupId);
	}

	@Override
	@PreAuthorize("hasAuthority('ACC_TYPE_SUPER_ADMIN') or (hasAuthority('ACC_TYPE_ADMIN') and hasAuthority('ACCESS_USER_GROUP'))")
	public List<UserGroup> findByGroupNameLike(final String groupName) {
		return userGroupRepository.findByGroupNameLike(groupName);
	}

	@Override
	@PreAuthorize("hasAuthority('ACC_TYPE_SUPER_ADMIN') or (hasAuthority('ACC_TYPE_ADMIN') and hasAuthority('ACCESS_USER_GROUP'))")
	public List<UserGroup> findUserGroupsBySearchCriteria(
			final UserGroupSearchCriteria sectionSearchCriteria) {
		return userGroupRepositoryCustom.findUserGroupsBySearchCriteria(sectionSearchCriteria);
	}

	@Override
	@PreAuthorize("hasAuthority('ACC_TYPE_SUPER_ADMIN') or (hasAuthority('ACC_TYPE_ADMIN') and hasAuthority('ACCESS_USER_GROUP'))")
	public List<UserGroup> getUserGroupByIds(final List<Long> userGroupIds) {
		return userGroupRepository.findAll(userGroupIds);
	}

}