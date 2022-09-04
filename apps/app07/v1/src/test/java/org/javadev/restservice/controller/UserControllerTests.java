package org.javadev.restservice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.javadev.restservice.entity.User;
import org.json.JSONException;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
public class UserControllerTests {
	
	@Test @Order(1)
	void getAllUsersTest() throws JSONException {
		
		String expected = "[{\"id\":1,\"name\":\"Webmakaka1\",\"address\":\"Address1\"},{\"id\":2,\"name\":\"Webmakaka2\",\"address\":\"Address2\"},{\"id\":3,\"name\":\"Webmakaka3\",\"address\":\"Address3\"}]";
		
		TestRestTemplate restTemplate = new TestRestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/users", String.class);
				
		assertEquals(HttpStatus.OK, response.getStatusCode());
		JSONAssert.assertEquals(expected, response.getBody(), false);
		
	}
	
	@Test @Order(2)
	void getgetUserByIdTest() throws JSONException {
		
		String expected = "{\"id\":1,\"name\":\"Webmakaka1\",\"address\":\"Address1\"}";
		
		TestRestTemplate restTemplate = new TestRestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/user/1", String.class);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		JSONAssert.assertEquals(expected, response.getBody(), false);
	}
	
	@Test @Order(3)
	void addUserTest() throws JSONException {
		
		User user = new User(4, "Webmakaka4", "Address4");
		
		String expected = "{\"id\":4,\"name\":\"Webmakaka4\",\"address\":\"Address4\"}";
		
		TestRestTemplate restTemplate = new TestRestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<User> request = new HttpEntity<User>(user, headers);
		
		ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8080/addUser", request, String.class);
		
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		JSONAssert.assertEquals(expected, response.getBody(), false);
	}
	
	@Test @Order(4)
	void updateUserTest() throws JSONException {
		
		User user = new User(3, "Webmakaka5", "Address5");
		
		String expected = "{\"id\":3,\"name\":\"Webmakaka5\",\"address\":\"Address5\"}";
		
		TestRestTemplate restTemplate = new TestRestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<User> request = new HttpEntity<User>(user, headers);
		
		ResponseEntity<String> response = restTemplate.exchange("http://localhost:8080/updateUser", HttpMethod.PUT, request, String.class);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		JSONAssert.assertEquals(expected, response.getBody(), false);
	}
	
		
	@Test @Order(5)
	void deleteUserTest() throws JSONException {
		
		User user = new User(6, "Webmakaka6", "Address6");
		
		String expected = "User deleted!";
		
		TestRestTemplate restTemplate = new TestRestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<User> request = new HttpEntity<User>(user, headers);
		
		ResponseEntity<String> response = restTemplate.exchange("http://localhost:8080//user/3", HttpMethod.DELETE, request, String.class);
		
		String result = response.getBody().toString();
				
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(expected, result);
		
		// restTemplate.delete("http://localhost:8080//user/1");
	}
	
} // The End of Class;
