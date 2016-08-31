package com.bluespacetech.notifications.email.batch;

import java.util.Date;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.mail.SimpleMailMessage;

import com.bluespacetech.notifications.email.entity.EmailContactGroup;
import com.bluespacetech.notifications.email.util.ContactGroupMailMessage;
import com.bluespacetech.notifications.email.util.EmailUtils;
import com.bluespacetech.notifications.email.valueobjects.EmailContactGroupVO;


public class EmailGroupContactItemProcessor implements ItemProcessor<EmailContactGroupVO, ContactGroupMailMessage> {

	// private static final Logger log =
	// LoggerFactory.getLogger(EmailGroupContactItemProcessor.class);

	private String emailRequestURL;

	@Override
	public ContactGroupMailMessage process(final EmailContactGroupVO emailContactGroupVO) throws Exception {
		final StringBuffer emailMessage = new StringBuffer(emailContactGroupVO.getMessage());
		final String unscribeLink = EmailUtils.generateUnscribeLink(emailContactGroupVO, emailRequestURL);
		emailMessage.append(System.lineSeparator());
		emailMessage.append(unscribeLink);

		final ContactGroupMailMessage contactGroupMailMessage = new ContactGroupMailMessage();
		final SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(emailContactGroupVO.getContactEmail());
		simpleMailMessage.setFrom(emailContactGroupVO.getFromAddress());
		simpleMailMessage.setSubject(emailContactGroupVO.getSubject());
		simpleMailMessage.setSentDate(new Date());
		simpleMailMessage.setText(emailMessage.toString());


		final EmailContactGroup emailContactGroup = new EmailContactGroup();
		emailContactGroup.setContactId(emailContactGroupVO.getContactId());
		emailContactGroup.setGroupId(emailContactGroupVO.getGroupId());
		if (emailContactGroupVO.getEmailId() != null) {
			emailContactGroup.setEmailId(emailContactGroupVO.getEmailId());
		} else {
			emailContactGroup.setMessage(emailMessage.toString());
			emailContactGroup.setSubject(emailContactGroupVO.getSubject());
		}

		contactGroupMailMessage.setEmailContactGroup(emailContactGroup);
		contactGroupMailMessage.setSimpleMailMessage(simpleMailMessage);
		return contactGroupMailMessage;
	}

	/**
	 * @return the emailRequestURL
	 */
	public String getEmailRequestURL() {
		return emailRequestURL;
	}

	/**
	 * @param emailRequestURL
	 *            the emailRequestURL to set
	 */
	public void setEmailRequestURL(String emailRequestURL) {
		this.emailRequestURL = emailRequestURL;
	}

}