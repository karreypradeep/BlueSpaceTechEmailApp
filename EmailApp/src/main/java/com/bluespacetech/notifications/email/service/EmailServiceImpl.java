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
import com.bluespacetech.notifications.email.entity.Email;
import com.bluespacetech.notifications.email.repository.EmailRepository;

/**
 * class for EmailService
 *
 * @author pradeep created date 25-June-2015
 */
@Service
// @Transactional(rollbackFor = { Exception.class, RuntimeException.class,
// BusinessException.class,
// ApplicationException.class })
// @PreAuthorize("hasAuthority('EXCLUDE_ALL')")
public class EmailServiceImpl implements EmailService {

	@Autowired
	private EmailRepository emailRepository;

	@Override
	// @PreAuthorize("hasAuthority('ACC_TYPE_SUPER_ADMIN') or
	// ((hasAuthority('ACC_TYPE_ADMIN') or hasAuthority('ACC_TYPE_EMPLOYEE'))
	// and (hasAuthority('CREATE_PERSON') ))")
	public Email createEmail(final Email email) throws BusinessException {
		final Email newEmail = emailRepository.save(email);
		return newEmail;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bluespacetech.email.service.EmailService#findAll()
	 */
	@Override
	public List<Email> findAll() {
		return emailRepository.findAll();
	}



}
