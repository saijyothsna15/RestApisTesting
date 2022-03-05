package com.example.demo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.model.Address;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@AutoConfigureMockMvc
@SpringBootTest
public class UserControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	UserService oUserService;
	
	@Value("${user.basepath:/user}")
	private String basePath;
	
//	@Value("${user.api:''}")
//	private String api;
	
	@Test
	public void getUserTest() throws Exception {
		
		Address address = new Address("1-121","street","town","mandal","district","state","country");
		User user = new User(1,"sai",address);
		
		when(oUserService.saveUser(Mockito.any(User.class))).thenReturn(user);
		
		String requestPayload = "{\r\n"
				+ "	\"userName\":\"sai\",\r\n"
				+ "	\"userAddress\": {\r\n"
				+ "		\"doorNo\":\"1-121\",\r\n"
				+ "		\"street\":\"street\",\r\n"
				+ "		\"town\":\"town\",\r\n"
				+ "		\"mandal\":\"mandal\",\r\n"
				+ "		\"district\":\"district\",\r\n"
				+ "		\"state\":\"state\",\r\n"
				+ "		\"country\":\"country\"\r\n"
				+ "	}\r\n"
				+ "}";
		String expectedResponse = "{\r\n"
				+ "    \"userId\": 1,\r\n"
				+ "    \"userName\": \"sai\",\r\n"
				+ "    \"userAddress\": {\r\n"
				+ "        \"doorNo\": \"1-121\",\r\n"
				+ "        \"street\": \"street\",\r\n"
				+ "        \"town\": \"town\",\r\n"
				+ "        \"mandal\": \"mandal\",\r\n"
				+ "        \"district\": \"district\",\r\n"
				+ "        \"state\": \"state\",\r\n"
				+ "        \"country\": \"country\"\r\n"
				+ "    }\r\n"
				+ "}";
		
		MvcResult result = mockMvc.perform(
				   MockMvcRequestBuilders.post(this.basePath)
//				   .accept(MediaType.APPLICATION_JSON_VALUE)
				   .contentType(MediaType.APPLICATION_JSON_VALUE)
				   						 .content(requestPayload)
				).andExpect(status().isOk())
		         .andReturn();
		
		String res = result.getResponse().getContentAsString();
		
		JSONAssert.assertEquals(expectedResponse, res, false);
	}
}
