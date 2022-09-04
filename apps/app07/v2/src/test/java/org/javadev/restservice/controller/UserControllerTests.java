package org.javadev.restservice.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
@AutoConfigureMockMvc()
public class UserControllerTests {

	@Autowired
	private MockMvc mvc;

	@Test @Order(1)
	public void getAllUsersTest() throws Exception {
		mvc.perform(get("/users"))
				.andExpect(status().isOk());
	}

	@Test @Order(2)
	public void getgetUserByIdTest() throws Exception {
		mvc.perform(get("/user/1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name").value("Webmakaka1"))
				.andExpect(jsonPath("$.address").value("Address1"));
	}

	@Test @Order(3)
	public void addUserTest() throws Exception {
		MvcResult result =  mvc.perform(post("/addUser").contentType(MediaType.APPLICATION_JSON)
				.content("{\"id\":4,\"name\":\"Webmakaka4\",\"address\":\"Address4\"}"))
            	.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isCreated())
				.andReturn();
		//String content = result.getResponse().getContentAsString();
	}

	@Test @Order(4)
	public void updateUserTest() throws Exception {
		MvcResult result =  mvc.perform(put("/updateUser").contentType(MediaType.APPLICATION_JSON)
						.content("{\"id\":3,\"name\":\"Webmakaka5\",\"address\":\"Address5\"}"))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk())
				.andReturn();
		//String content = result.getResponse().getContentAsString();
	}

	@Test @Order(5)
	public void deleteUserTest() throws Exception {
		MvcResult result =  mvc.perform(delete("/user/3"))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk())
				.andReturn();
		//String content = result.getResponse().getContentAsString();
	}

} // The End of Class;
