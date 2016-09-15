/**
 * This document is a part of the source code and related artifacts for
 * bluespacetech.
 * www.bluespacetech.com
 * Copyright © 2016 bluespacetech
 *
 */
package com.bluespacetech.notifications.email.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluespacetech.core.exceptions.BusinessException;
import com.bluespacetech.notifications.email.entity.EmailContactGroup;
import com.bluespacetech.notifications.email.repository.EmailContactGroupRepository;

/**
 * class for EmailContactGroupService
 *
 * @author pradeep created date 25-June-2015
 */
@Service
// @Transactional(rollbackFor = { Exception.class, RuntimeException.class,
// BusinessException.class,
// ApplicationException.class })
// @PreAuthorize("hasAuthority('EXCLUDE_ALL')")
public class EmailContactGroupServiceImpl implements EmailContactGroupService {

	@Autowired
	private EmailContactGroupRepository emailContactGroupRepository;

	@Override
	// @PreAuthorize("hasAuthority('ACC_TYPE_SUPER_ADMIN') or
	// ((hasAuthority('ACC_TYPE_ADMIN') or hasAuthority('ACC_TYPE_EMPLOYEE'))
	// and (hasAuthority('CREATE_PERSON') ))")
	public EmailContactGroup createEmailContactGroup(final EmailContactGroup emailContactGroup)
			throws BusinessException {
		final EmailContactGroup newEmailContactGroup = emailContactGroupRepository.save(emailContactGroup);
		return newEmailContactGroup;
	}

	@Override
	// @PreAuthorize("hasAuthority('ACC_TYPE_SUPER_ADMIN') or
	// ((hasAuthority('ACC_TYPE_ADMIN') or hasAuthority('ACC_TYPE_EMPLOYEE'))
	// and (hasAuthority('CREATE_PERSON') ))")
	public List<EmailContactGroup> createEmailContactGroups(final List<EmailContactGroup> emailContactGroups)
			throws BusinessException {
		final List<EmailContactGroup> result = emailContactGroupRepository.save(emailContactGroups);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bluespacetech.emailContactGroup.service.EmailContactGroupService#
	 * findAll()
	 */
	@Override
	public List<EmailContactGroup> findAll() {
		return emailContactGroupRepository.findAll();
	}

	@Override
	public EmailContactGroup findByContactIdAndGroupIdAndRandomNumber(Long contactId, Long groupId, Long randomNumber) {
		return emailContactGroupRepository.findByContactIdAndGroupIdAndRandomNumber(contactId, groupId, randomNumber);
	}

	@Override
	public EmailContactGroup updateEmailContactGroup(EmailContactGroup emailContactGroup) throws BusinessException {
		final EmailContactGroup newEmailContactGroup = emailContactGroupRepository.save(emailContactGroup);
		return newEmailContactGroup;
	}

}
