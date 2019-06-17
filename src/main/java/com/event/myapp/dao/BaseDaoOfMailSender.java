package com.event.myapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class BaseDaoOfMailSender {
	@Autowired
	private JavaMailSender mailSender;

	public void send(SimpleMailMessage mail) {
		mailSender.send(mail);
	}
}
