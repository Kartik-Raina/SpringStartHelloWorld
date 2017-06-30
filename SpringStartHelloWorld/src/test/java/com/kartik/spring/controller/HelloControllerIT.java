package com.kartik.spring.controller;

import java.util.Arrays;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.kartik.spring.SpringStartHelloWorldApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringStartHelloWorldApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerIT {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders httpHeaders = new HttpHeaders();

	@Before
	public void before() {
		httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	}

	@Test
	public void testGetUserByRole() throws JSONException {
		String uri = "http://localhost:" + port + "/user/role?name=Admin";

		HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

		System.out.println("Response: " + response.getBody());
		JSONAssert.assertEquals("[{id:1}]", response.getBody(), false);
	}

}
