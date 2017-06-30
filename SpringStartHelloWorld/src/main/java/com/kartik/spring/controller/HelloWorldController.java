package com.kartik.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kartik.spring.repository.UserRepository;

@RestController
public class HelloWorldController {

	@Autowired
	UserRepository repo;
	private ObjectMapper objectMapper = new ObjectMapper();

	@RequestMapping("/hello")
	public String hello() {
		return "Hello World";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/user/role")
	public ResponseEntity getUserByRole(@RequestParam(name = "name") String roleName) throws JsonProcessingException {
		return new ResponseEntity(
				objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(repo.findByRole(roleName)),
				HttpStatus.OK);
	}
}
