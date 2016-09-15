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
import com.bluespacetech.notifications.email.entity.EmailServer;
import com.bluespacetech.notifications.email.repository.EmailServerRepository;

/**
 * class for EmailServerService
 *
 * @author pradeep created date 25-June-2015
 */
@Service
// @Transactional(rollbackFor = { Exception.class, RuntimeException.class,
// BusinessException.class,
// ApplicationException.class })
// @PreAuthorize("hasAuthority('EXCLUDE_ALL')")
public class EmailServerServiceImpl implements EmailServerService {

	@Autowired
	private EmailServerRepository emailServerRepository;

	@Override
	// @PreAuthorize("hasAuthority('ACC_TYPE_SUPER_ADMIN') or
	// ((hasAuthority('ACC_TYPE_ADMIN') or hasAuthority('ACC_TYPE_EMPLOYEE'))
	// and (hasAuthority('CREATE_PERSON') ))")
	public EmailServer createEmailServer(final EmailServer emailServer) throws BusinessException {
		final EmailServer newEmailServer = emailServerRepository.save(emailServer);
		return newEmailServer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bluespacetech.emailServer.service.EmailServerService#findAll()
	 */
	@Override
	public List<EmailServer> findAll() {
		return emailServerRepository.findAll();
	}

	@Override
	public void deleteEmailServer(Long emailServerId) throws BusinessException {
		emailServerRepository.delete(emailServerId);
	}

	@Override
	public EmailServer updateEmailServer(EmailServer emailServer) throws BusinessException {
		final EmailServer newEmailServer = emailServerRepository.save(emailServer);
		return newEmailServer;
	}

	@Override
	public EmailServer findEmailServerByName(String emailServerName) throws BusinessException {
		return emailServerRepository.findByName(emailServerName);
	}


}
