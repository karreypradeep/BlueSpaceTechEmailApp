package com.bluespacetech.notifications.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;

public class EmailWorker {

	private JavaMailSender  javaMailSender;
	
	@Autowired
	public EmailWorker(JavaMailSender javaMailSender){
		this.javaMailSender = javaMailSender;
	}

	@Async
	void sendEmail(final EmailVO email){
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(email.getToAddress().toArray(new String[email.getToAddress().size()]));
		mail.setFrom(email.getFromAddress());
		mail.setSubject(email.getSubject());
		mail.setText(email.getMessage());
		javaMailSender.send(mail);
	}

}
