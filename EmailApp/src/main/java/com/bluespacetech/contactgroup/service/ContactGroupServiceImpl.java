/**
 * This document is a part of the source code and related artifacts for bluespacetech. www.bluespacetech.com
 * Copyright © 2016 bluespacetech
 */
package com.bluespacetech.contactgroup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluespacetech.contactgroup.entity.ContactGroup;
import com.bluespacetech.contactgroup.entity.ContactGroupPK;
import com.bluespacetech.contactgroup.repository.ContactGroupRepository;
import com.bluespacetech.contactgroup.repository.ContactGroupRepositoryCustom;
import com.bluespacetech.core.exceptions.ApplicationException;
import com.bluespacetech.core.exceptions.BusinessException;

/**
 * Class for ContactGroupService
 *
 * @author Sandeep created date 25-June-2015
 */
@Service
@Transactional(rollbackFor = { Exception.class, RuntimeException.class, BusinessException.class,
		ApplicationException.class })
@PreAuthorize("hasAuthority('EXCLUDE_ALL')")
public class ContactGroupServiceImpl implements ContactGroupService {

	@Autowired
	private ContactGroupRepository contactGroupRepository;

	@Autowired
	private ContactGroupRepositoryCustom contactGroupRepositoryCustom;

	@Override
	@PreAuthorize("hasAuthority('ACC_TYPE_SUPER_ADMIN') or (hasAuthority('ACC_TYPE_ADMIN') and hasAuthority('ACCESS_CONTACT'))")
	public ContactGroup getContactGroupById(ContactGroupPK contactGroupPK) {
		return contactGroupRepository.findOne(contactGroupPK);
	}

	@Override
	@PreAuthorize("hasAuthority('ACC_TYPE_SUPER_ADMIN') or (hasAuthority('ACC_TYPE_ADMIN') and hasAuthority('CREATE_CONTACT'))")
	public ContactGroup createContactGroup(ContactGroup contactGroup) throws BusinessException {
		return contactGroupRepository.save(contactGroup);
	}

	@Override
	@PreAuthorize("hasAuthority('ACC_TYPE_SUPER_ADMIN') or (hasAuthority('ACC_TYPE_ADMIN') and hasAuthority('DELETE_CONTACT'))")
	public void deleteContactGroup(ContactGroupPK contactGroupPK) throws BusinessException {
		contactGroupRepository.delete(contactGroupPK);
	}

	@Override
	@PreAuthorize("hasAuthority('ACC_TYPE_SUPER_ADMIN') or (hasAuthority('ACC_TYPE_ADMIN') and hasAuthority('ACCESS_CONTACT'))")
	public List<ContactGroup> findAll() {
		return contactGroupRepository.findAll();
	}

	@Override
	@PreAuthorize("hasAuthority('ACC_TYPE_SUPER_ADMIN') or (hasAuthority('ACC_TYPE_ADMIN') and hasAuthority('UPDATE_CONTACT'))")
	public ContactGroup updateContactGroup(ContactGroup contactGroup) throws BusinessException {
		return contactGroupRepository.save(contactGroup);
	}

	@Override
	@PreAuthorize("hasAuthority('ACC_TYPE_SUPER_ADMIN') or (hasAuthority('ACC_TYPE_ADMIN') and hasAuthority('ACCESS_CONTACT'))")
	public ContactGroup unsubscribeContactGroup(Long contactId, Long groupId) throws BusinessException {
		final ContactGroup contactGroup = contactGroupRepositoryCustom.getContactGroupByContactIdAndGroupId(contactId,
				groupId);
		contactGroup.setUnSubscribed(true);
		return updateContactGroup(contactGroup);
	}


}
