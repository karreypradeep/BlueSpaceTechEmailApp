package com.bluespacetech.notifications.email;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmailContactGroupRowMapper implements RowMapper<EmailContactGroupVO> {

	private String message;

	private String subject;

	@Override
	public EmailContactGroupVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		final EmailContactGroupVO emailContactGroupVO = new EmailContactGroupVO();
		emailContactGroupVO.setContactFirstName(rs.getString("FIRST_NAME"));
		emailContactGroupVO.setContactLastName(rs.getString("LAST_NAME"));
		emailContactGroupVO.setContactEmail(rs.getString("EMAIL"));
		emailContactGroupVO.setFromAddress(rs.getString("EMAIL"));
		emailContactGroupVO.setMessage(getMessage());
		emailContactGroupVO.setSubject(getSubject());
		emailContactGroupVO.setGroupId(rs.getLong("GROUP_ID"));
		emailContactGroupVO.setContactId(rs.getLong("CONTACT_ID"));
		return emailContactGroupVO;
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

}
