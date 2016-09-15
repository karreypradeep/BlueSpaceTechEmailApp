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
import com.bluespacetech.notifications.email.entity.EmailServerProperties;
import com.bluespacetech.notifications.email.repository.EmailServerPropertiesRepository;

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
public class EmailServerPropertiesServiceImpl implements EmailServerPropertiesService {

	@Autowired
	private EmailServerPropertiesRepository emailServerPropertiesRepository;

	@Override
	public List<EmailServerProperties> findByEmailServer(EmailServer emailServer) {
		return emailServerPropertiesRepository.findEmailServerPropertiesByEmailServer(emailServer);
	}

	@Override
	public EmailServerProperties createEmailServerProperty(EmailServerProperties emailServerProperties)
			throws BusinessException {
		return emailServerPropertiesRepository.save(emailServerProperties);
	}

	@Override
	public void deleteEmailServerProperty(Long emailServerPropertiesId) throws BusinessException {
		emailServerPropertiesRepository.delete(emailServerPropertiesId);
	}

	@Override
	public EmailServerProperties updateEmailServerProperty(EmailServerProperties emailServerProperties)
			throws BusinessException {
		return emailServerPropertiesRepository.save(emailServerProperties);
	}

}
