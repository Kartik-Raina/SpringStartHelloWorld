package com.kartik.spring.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kartik.spring.main.MailSender;

@RestController
public class MailController {

	@Resource
	private MailSender mailSender;

	@RequestMapping("/mail")
	public String sendMain() {
		mailSender.send("abc@example.com", "Some subject", "the content");
		return "Mail sent";

	}
}
