package com.bluespacetech.notifications.email.batch;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.mail.SimpleMailMessage;

import com.bluespacetech.notifications.email.entity.EmailContactGroup;
import com.bluespacetech.notifications.email.util.ContactGroupMailMessage;
import com.bluespacetech.notifications.email.valueobjects.EmailContactGroupVO;


public class EmailGroupContactItemProcessor implements ItemProcessor<EmailContactGroupVO, ContactGroupMailMessage> {

	private static final Logger log = LoggerFactory.getLogger(EmailGroupContactItemProcessor.class);

	@Override
	public ContactGroupMailMessage process(final EmailContactGroupVO emailContactGroupVO) throws Exception {
		final ContactGroupMailMessage contactGroupMailMessage = new ContactGroupMailMessage();
		final SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(emailContactGroupVO.getContactEmail());
		simpleMailMessage.setFrom(emailContactGroupVO.getFromAddress());
		simpleMailMessage.setSubject(emailContactGroupVO.getSubject());
		simpleMailMessage.setSentDate(new Date());
		simpleMailMessage.setText(emailContactGroupVO.getMessage());
		final EmailContactGroup emailContactGroup = new EmailContactGroup();
		emailContactGroup.setContactId(emailContactGroupVO.getContactId());
		emailContactGroup.setGroupId(emailContactGroupVO.getGroupId());
		emailContactGroup.setMessage(emailContactGroupVO.getMessage());
		contactGroupMailMessage.setEmailContactGroup(emailContactGroup);
		contactGroupMailMessage.setSimpleMailMessage(simpleMailMessage);
		return contactGroupMailMessage;
	}
}