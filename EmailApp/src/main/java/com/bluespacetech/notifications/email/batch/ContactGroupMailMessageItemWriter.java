package com.bluespacetech.notifications.email.batch;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSendException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.util.Assert;

import com.bluespacetech.core.exceptions.BusinessException;
import com.bluespacetech.notifications.email.entity.EmailContactGroup;
import com.bluespacetech.notifications.email.service.EmailContactGroupService;
import com.bluespacetech.notifications.email.util.ContactGroupMailMessage;

public class ContactGroupMailMessageItemWriter implements ItemWriter<ContactGroupMailMessage>, InitializingBean {

	private MailSender mailSender;

	private EmailContactGroupService emailContactGroupService;
	// private MailSender mailSender;

	// private MailErrorHandler mailErrorHandler = new
	// DefaultMailErrorHandler();

	/**
	 * A {@link MailSender} to be used to send messages in {@link #write(List)}.
	 * 
	 * @param mailSender
	 */
	public void setMailSender(MailSender mailSender) {
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
			final SimpleMailMessage[] messages = new SimpleMailMessage[items.size()];
			final List<EmailContactGroup> emailContactGroups = new ArrayList<EmailContactGroup>();
			int count = 0;
			for (final ContactGroupMailMessage contactGroupMailMessage : items) {
				messages[count] = contactGroupMailMessage.getSimpleMailMessage();
				emailContactGroups.add(contactGroupMailMessage.getEmailContactGroup());
				count++;
			}
			emailContactGroupService.createEmailContactGroups(emailContactGroups);
			mailSender.send(messages);
		} catch (final MailSendException e) {
			System.out.println(e);
			/*
			 * final Map<Object, Exception> failedMessages =
			 * e.getFailedMessages(); for (final Entry<Object, Exception> entry
			 * : failedMessages.entrySet()) {
			 * mailErrorHandler.handle((SimpleMailMessage) entry.getKey(),
			 * entry.getValue()); }
			 */
		} catch (final BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
