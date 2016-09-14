package com.bluespacetech.notifications.email.batch;

import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.util.Assert;

import com.bluespacetech.core.exceptions.BusinessException;
import com.bluespacetech.notifications.email.entity.EmailContactGroup;
import com.bluespacetech.notifications.email.service.EmailContactGroupService;
import com.bluespacetech.notifications.email.util.ContactGroupMailMessage;

public class ContactGroupMailMessageItemWriter implements ItemWriter<ContactGroupMailMessage>, InitializingBean {

	Logger logger = Logger.getLogger(ContactGroupMailMessageItemWriter.class);

	private JavaMailSender mailSender;

	private EmailContactGroupService emailContactGroupService;

	/**
	 * A {@link JavaMailSender} to be used to send messages in
	 * {@link #write(List)}.
	 * 
	 * @param mailSender
	 */
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	/**
	 * The handler for failed messages. Defaults to a
	 * {@link DefaultMailErrorHandler}.
	 * 
	 * @param mailErrorHandler
	 *            the mail error handler to set
	 * 
	 *            public void setMailErrorHandler(MailErrorHandler
	 *            mailErrorHandler) { this.mailErrorHandler = mailErrorHandler;
	 *            }
	 */

	/**
	 * @param emailContactGroupService
	 *            the emailContactGroupService to set
	 */
	public void setEmailContactGroupService(EmailContactGroupService emailContactGroupService) {
		this.emailContactGroupService = emailContactGroupService;
	}

	/**
	 * Check mandatory properties (mailSender).
	 * 
	 * @throws IllegalStateException
	 *             if the mandatory properties are not set
	 * 
	 * @see InitializingBean#afterPropertiesSet()
	 */
	@Override
	public void afterPropertiesSet() throws IllegalStateException {
		Assert.state(mailSender != null, "A MailSender must be provided.");
	}

	/**
	 * @param items
	 *            the items to send
	 * @see ItemWriter#write(List)
	 */
	@Override
	public void write(List<? extends ContactGroupMailMessage> items) throws MailException {
		try {
			final MimeMessage[] messages = new MimeMessage[items.size()];
			final List<EmailContactGroup> emailContactGroups = new ArrayList<EmailContactGroup>();
			int count = 0;
			for (final ContactGroupMailMessage contactGroupMailMessage : items) {
				messages[count] = contactGroupMailMessage.getMimeMessage();
				emailContactGroups.add(contactGroupMailMessage.getEmailContactGroup());
				count++;
			}
			emailContactGroupService.createEmailContactGroups(emailContactGroups);
			mailSender.send(messages);
			// throw new Exception();
		} catch (final MailSendException e) {
			logger.error(e.getMessage());
		} catch (final BusinessException e) {
			logger.error(e.getMessage());
		} catch (final Exception e) {
			logger.error(e.getMessage());
		}
	}

}
