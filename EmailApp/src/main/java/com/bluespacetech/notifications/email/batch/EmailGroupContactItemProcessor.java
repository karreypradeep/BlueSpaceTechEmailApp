package com.bluespacetech.notifications.email.batch;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.mail.SimpleMailMessage;

import com.bluespacetech.notifications.email.valueobjects.EmailContactGroupVO;


public class EmailGroupContactItemProcessor implements ItemProcessor<EmailContactGroupVO, SimpleMailMessage> {

	private static final Logger log = LoggerFactory.getLogger(EmailGroupContactItemProcessor.class);

	@Override
	public SimpleMailMessage process(final EmailContactGroupVO emailContactGroupVO) throws Exception {
		final SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(emailContactGroupVO.getContactEmail());
		message.setFrom(emailContactGroupVO.getFromAddress());
		message.setSubject(emailContactGroupVO.getSubject());
		message.setSentDate(new Date());
		message.setText(emailContactGroupVO.getMessage());
		return message;
	}
}