/**
 * This document is a part of the source code and related artifacts for bluespacetech. www.bluespacetech.com
 * Copyright © 2015 bluespacetech
 */
package com.bluespacetech.notifications.email;

import java.io.Serializable;


/**
 * @author pradeep created date 13-Jul-2016
 */
public class EmailContactGroupVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 237003043434123667L;

	private Email email;

	private Long contactId;

	private Long groupId;

	private String message;

	private String contactEmail;

	private String contactFirstName;

	private String contactLastName;

	private String subject;

	private String fromAddress;

	/**
	 * @return the email
	 */
	public Email getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(Email email) {
		this.email = email;
	}

	/**
	 * @return the contactId
	 */
	public Long getContactId() {
		return contactId;
	}

	/**
	 * @param contactId
	 *            the contactId to set
	 */
	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	/**
	 * @return the groupId
	 */
	public Long getGroupId() {
		return groupId;
	}

	/**
	 * @param groupId
	 *            the groupId to set
	 */
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the contactEmail
	 */
	public String getContactEmail() {
		return contactEmail;
	}

	/**
	 * @param contactEmail
	 *            the contactEmail to set
	 */
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	/**
	 * @return the contactFirstName
	 */
	public String getContactFirstName() {
		return contactFirstName;
	}

	/**
	 * @param contactFirstName
	 *            the contactFirstName to set
	 */
	public void setContactFirstName(String contactFirstName) {
		this.contactFirstName = contactFirstName;
	}

	/**
	 * @return the contactLastName
	 */
	public String getContactLastName() {
		return contactLastName;
	}

	/**
	 * @param contactLastName
	 *            the contactLastName to set
	 */
	public void setContactLastName(String contactLastName) {
		this.contactLastName = contactLastName;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject
	 *            the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the fromAddress
	 */
	public String getFromAddress() {
		return fromAddress;
	}

	/**
	 * @param fromAddress
	 *            the fromAddress to set
	 */
	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}
}
