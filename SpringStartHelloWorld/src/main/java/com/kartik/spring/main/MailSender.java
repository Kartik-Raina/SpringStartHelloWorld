package com.kartik.spring.main;

public interface MailSender {

	void send(String to, String subject, String body);
}
