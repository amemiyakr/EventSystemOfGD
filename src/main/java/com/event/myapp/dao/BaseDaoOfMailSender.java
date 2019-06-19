package com.event.myapp.dao;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class BaseDaoOfMailSender {
	@Autowired
	private JavaMailSender mailSender;

	public void send(SimpleMailMessage mail) {
		mailSender.send(mail);
	}

	public void send(MimeMessage mail) {
		mailSender.send(mail);
	}

	public MimeMessage createMimeMessage() {
		return mailSender.createMimeMessage();
	}
}
