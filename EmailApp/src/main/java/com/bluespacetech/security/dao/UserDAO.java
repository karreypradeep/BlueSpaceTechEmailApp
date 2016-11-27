package com.bluespacetech.security.dao;

import java.io.Serializable;
import java.util.Collection;

public class UserDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8695248104044241700L;

	private String loggedInUserName;

	private Collection<String> roles;

	/**
	 * @return the loggedInUserName
	 */
	public String getLoggedInUserName() {
		return loggedInUserName;
	}

	/**
	 * @param loggedInUserName
	 *            the loggedInUserName to set
	 */
	public void setLoggedInUserName(String loggedInUserName) {
		this.loggedInUserName = loggedInUserName;
	}

	/**
	 * @return the roles
	 */
	public Collection<String> getRoles() {
		return roles;
	}

	/**
	 * @param roles
	 *            the roles to set
	 */
	public void setRoles(Collection<String> roles) {
		this.roles = roles;
	}

}
