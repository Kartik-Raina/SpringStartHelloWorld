package com.kartik.spring.microservices.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FirstController {

	@RequestMapping(method = RequestMethod.GET, value = "/hola", produces = "text/plain")
	public String hola() throws UnknownHostException {
		String hostname = null;
		hostname = InetAddress.getLocalHost().getHostAddress();
		return "Welcome " + hostname;
	}
}
