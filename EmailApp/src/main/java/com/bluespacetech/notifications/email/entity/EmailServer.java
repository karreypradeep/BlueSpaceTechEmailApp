/**
 * This document is a part of the source code and related artifacts for bluespacetech. www.bluespacetech.com
 * Copyright © 2015 bluespacetech
 */
package com.bluespacetech.notifications.email.entity;

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
@Table(name = "EMAIL_SERVER")
public class EmailServer extends BaseEntity implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 4111075785941540894L;

	@NotEmpty(message = "Name is mandatory.")
	@Column(name = "NAME", unique = true)
	private String name;

	@NotEmpty(message = "Protocol is mandatory.")
	@Column(name = "PROTOCOL")
	private String protocol;

	@NotEmpty(message = "Host is mandatory.")
	@Column(name = "HOST")
	private String host;

	@NotEmpty(message = "Port is mandatory.")
	@Column(name = "PORT")
	private String port;

	@NotEmpty(message = "Number of emails per session is mandatory.")
	@Column(name = "MAILS_PER_SESSION")
	private Integer mailsPerSession;

	@NotEmpty(message = "Host is mandatory.")
	@Column(name = "FROM_ADDRESS")
	private String fromAddress;

	@NotEmpty(message = "Host is mandatory.")
	@Column(name = "USERNAME")
	private String username;

	@NotEmpty(message = "Host is mandatory.")
	@Column(name = "PASSWORD")
	private String password;

	/**
	 * @return the protocol
	 */
	public String getProtocol() {
		return protocol;
	}

	/**
	 * @param protocol
	 *            the protocol to set
	 */
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	/**
	 * @return the host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * @param host
	 *            the host to set
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * @return the port
	 */
	public String getPort() {
		return port;
	}

	/**
	 * @param port
	 *            the port to set
	 */
	public void setPort(String port) {
		this.port = port;
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

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the mailsPerSession
	 */
	public Integer getMailsPerSession() {
		return mailsPerSession;
	}

	/**
	 * @param mailsPerSession
	 *            the mailsPerSession to set
	 */
	public void setMailsPerSession(Integer mailsPerSession) {
		this.mailsPerSession = mailsPerSession;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
