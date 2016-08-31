/**
 * This document is a part of the source code and related artifacts for bluespacetech. www.bluespacetech.com
 * Copyright © 2015 bluespacetech
 */
package com.bluespacetech.notifications.email.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bluespacetech.core.exceptions.BusinessException;
import com.bluespacetech.notifications.email.entity.Email;
import com.bluespacetech.notifications.email.service.EmailService;
import com.bluespacetech.notifications.email.valueobjects.EmailVO;

/**
 * @author pradeep created date 30-Jan-2015
 */
@RestController
@RequestMapping("/emails")
@CrossOrigin
public class EmailController {

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private EmailService emailService;

	@Autowired
	@Qualifier("groupEmailJob")
	private Job job;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void job(@RequestBody final EmailVO emailVO) {
		try {
			final Map<String, JobParameter> jobParametersMap = new HashMap<String, JobParameter>();
			Email email = null;
			if (!emailVO.isPersonalizedEmail()) {
				email = emailService.createEmail(emailVO);
			}
			if (emailVO.getGroupId() != null) {
				jobParametersMap.put("groupId", new JobParameter(emailVO.getGroupId()));
				if (email != null) {
					jobParametersMap.put("emailId", new JobParameter(emailVO.getGroupId()));
				}
				jobParametersMap.put("dateAndTime", new JobParameter(new Date()));
				jobParametersMap.put("message", new JobParameter(emailVO.getMessage()));
				jobParametersMap.put("subject", new JobParameter(emailVO.getSubject()));
				jobLauncher.run(job, new JobParameters(jobParametersMap));
			} else if (emailVO.getGroupIdList() != null && !emailVO.getGroupIdList().isEmpty()) {
				for (final Long groupId : emailVO.getGroupIdList()) {
					if (email != null) {
						jobParametersMap.put("emailId", new JobParameter(emailVO.getGroupId()));
					}
					jobParametersMap.put("groupId", new JobParameter(groupId));
					jobParametersMap.put("dateAndTime", new JobParameter(new Date()));
					jobParametersMap.put("message", new JobParameter(emailVO.getMessage()));
					jobParametersMap.put("subject", new JobParameter(emailVO.getSubject()));
					jobLauncher.run(job, new JobParameters(jobParametersMap));
				}
			}
		} catch (final Exception e) {
			throw new RuntimeException(e);

		}
	}

	@ExceptionHandler(BusinessException.class)
	ResponseEntity<String> handleContactNotFoundException(final Exception e) {
		return new ResponseEntity<String>(String.format("{\"reason\":\"%s\"}", e.getMessage()), HttpStatus.NOT_FOUND);
	}
}
