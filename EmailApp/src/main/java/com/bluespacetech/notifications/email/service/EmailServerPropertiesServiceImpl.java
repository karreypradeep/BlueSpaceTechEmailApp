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
import com.bluespacetech.notifications.email.entity.EmailServerProperties;
import com.bluespacetech.notifications.email.repository.EmailServerPropertiesRepository;

/**
 * class for EmailServerService
 *
 * @author pradeep created date 25-June-2015
 */
@Service
@Transactional(rollbackFor = { Exception.class, RuntimeException.class, BusinessException.class,
		ApplicationException.class })
@PreAuthorize("hasAuthority('EXCLUDE_ALL')")
public class EmailServerPropertiesServiceImpl implements EmailServerPropertiesService {

	@Autowired
	private EmailServerPropertiesRepository emailServerPropertiesRepository;

	@Override
	@PreAuthorize("hasAuthority('ACC_TYPE_SUPER_ADMIN') or (hasAuthority('ACC_TYPE_ADMIN') and hasAuthority('ACCESS_EMAIL_SERVER_PROPERTIES'))")
	public List<EmailServerProperties> findByEmailServer(EmailServer emailServer) {
		return emailServerPropertiesRepository.findEmailServerPropertiesByEmailServer(emailServer);
	}

	@Override
	@PreAuthorize("hasAuthority('ACC_TYPE_SUPER_ADMIN') or (hasAuthority('ACC_TYPE_ADMIN') and hasAuthority('CREATE_EMAIL_SERVER_PROPERTIES'))")
	public EmailServerProperties createEmailServerProperty(EmailServerProperties emailServerProperties)
			throws BusinessException {
		return emailServerPropertiesRepository.save(emailServerProperties);
	}

	@Override
	@PreAuthorize("hasAuthority('ACC_TYPE_SUPER_ADMIN') or (hasAuthority('ACC_TYPE_ADMIN') and hasAuthority('DELETE_EMAIL_SERVER_PROPERTIES'))")
	public void deleteEmailServerProperty(Long emailServerPropertiesId) throws BusinessException {
		emailServerPropertiesRepository.delete(emailServerPropertiesId);
	}

	@Override
	@PreAuthorize("hasAuthority('ACC_TYPE_SUPER_ADMIN') or (hasAuthority('ACC_TYPE_ADMIN') and hasAuthority('UPDATE_EMAIL_SERVER_PROPERTIES'))")
	public EmailServerProperties updateEmailServerProperty(EmailServerProperties emailServerProperties)
			throws BusinessException {
		return emailServerPropertiesRepository.save(emailServerProperties);
	}

}
