package com.bluespacetech.notifications.email.util;

import java.io.Serializable;

import org.springframework.mail.SimpleMailMessage;

import com.bluespacetech.notifications.email.entity.EmailContactGroup;

public class ContactGroupMailMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6064992838049760633L;

	private EmailContactGroup emailContactGroup;

	private SimpleMailMessage simpleMailMessage;

	/**
	 * @return the emailContactGroup
	 */
	public EmailContactGroup getEmailContactGroup() {
		return emailContactGroup;
	}

	/**
	 * @param emailContactGroup
	 *            the emailContactGroup to set
	 */
	public void setEmailContactGroup(EmailContactGroup emailContactGroup) {
		this.emailContactGroup = emailContactGroup;
	}

	/**
	 * @return the simpleMailMessage
	 */
	public SimpleMailMessage getSimpleMailMessage() {
		return simpleMailMessage;
	}

	/**
	 * @param simpleMailMessage
	 *            the simpleMailMessage to set
	 */
	public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
		this.simpleMailMessage = simpleMailMessage;
	}

}
