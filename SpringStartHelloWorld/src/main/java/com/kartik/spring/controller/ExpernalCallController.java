package com.kartik.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ExpernalCallController {

	private RestTemplate template = new RestTemplate();
	private String saying;
	
	@RequestMapping("/extcall")
	public String externalCall(){
		String backendServiceUrl = String.format("http://localhost:9090/DemoWebProject/userdata?source=xml");
		String response = template.getForObject(backendServiceUrl, String.class, saying);
		return response;
	}
}
