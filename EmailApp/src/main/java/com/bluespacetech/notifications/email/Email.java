/**
 * This document is a part of the source code and related artifacts for bluespacetech. www.bluespacetech.com
 * Copyright © 2015 bluespacetech
 */
package com.bluespacetech.notifications.email;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.bluespacetech.core.model.BaseEntity;

/**
 * @author pradeep created date 13-Jul-2016
 */
@Entity
@Table(name = "EMAIL")
public class Email extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 5269234756986410938L;

	@NotEmpty(message = "Message is mandatory.")
	@Column(name = "TEXT")
	private String message;

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
