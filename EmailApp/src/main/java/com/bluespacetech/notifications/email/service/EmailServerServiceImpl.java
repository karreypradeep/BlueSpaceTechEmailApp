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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluespacetech.core.exceptions.ApplicationException;
import com.bluespacetech.core.exceptions.BusinessException;
import com.bluespacetech.notifications.email.entity.EmailServer;
import com.bluespacetech.notifications.email.repository.EmailServerRepository;

/**
 * class for EmailServerService
 *
 * @author pradeep created date 25-June-2015
 */
@Service
@Transactional(rollbackFor = { Exception.class, RuntimeException.class, BusinessException.class,
		ApplicationException.class })
@PreAuthorize("hasAuthority('EXCLUDE_ALL')")
public class EmailServerServiceImpl implements EmailServerService {

	@Autowired
	private EmailServerRepository emailServerRepository;

	@Override
	@PreAuthorize("hasAuthority('ACC_TYPE_SUPER_ADMIN') or (hasAuthority('ACC_TYPE_ADMIN') and hasAuthority('CREATE_EMAIL_SERVER'))")
	public EmailServer createEmailServer(final EmailServer emailServer) throws BusinessException {
		final EmailServer newEmailServer = emailServerRepository.save(emailServer);
		return newEmailServer;
	}

	@Override
	@PreAuthorize("hasAuthority('ACC_TYPE_SUPER_ADMIN') or (hasAuthority('ACC_TYPE_ADMIN') and hasAuthority('ACCESS_EMAIL_SERVER'))")
	public List<EmailServer> findAll() {
		return emailServerRepository.findAll();
	}

	@Override
	@PreAuthorize("hasAuthority('ACC_TYPE_SUPER_ADMIN') or (hasAuthority('ACC_TYPE_ADMIN') and hasAuthority('DELETE_EMAIL_SERVER'))")
	public void deleteEmailServer(Long emailServerId) throws BusinessException {
		emailServerRepository.delete(emailServerId);
	}

	@Override
	@PreAuthorize("hasAuthority('ACC_TYPE_SUPER_ADMIN') or (hasAuthority('ACC_TYPE_ADMIN') and hasAuthority('UPDATE_EMAIL_SERVER'))")
	public EmailServer updateEmailServer(EmailServer emailServer) throws BusinessException {
		final EmailServer newEmailServer = emailServerRepository.save(emailServer);
		return newEmailServer;
	}

	@Override
	@PreAuthorize("hasAuthority('ACC_TYPE_SUPER_ADMIN') or (hasAuthority('ACC_TYPE_ADMIN') and hasAuthority('ACCESS_EMAIL_SERVER'))")
	public EmailServer findEmailServerByName(String emailServerName) throws BusinessException {
		return emailServerRepository.findByName(emailServerName);
	}

	@Override
	@PreAuthorize("hasAuthority('ACC_TYPE_SUPER_ADMIN') or (hasAuthority('ACC_TYPE_ADMIN') and hasAuthority('ACCESS_EMAIL_SERVER'))")
	public EmailServer getEmailServerById(Long id) throws BusinessException {
		return emailServerRepository.findOne(id);
	}


}
