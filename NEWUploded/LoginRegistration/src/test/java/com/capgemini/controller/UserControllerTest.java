package com.capgemini.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.http.MediaType;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.capgemini.exception.PasswordValidationException;
import com.capgemini.exception.UserAlreadyExitsException;
import com.capgemini.model.User;
import com.capgemini.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
@ExtendWith(MockitoExtension.class)
class UserControllerTest {

	private MockMvc mockmvc;
	
	@Mock
	private UserService UserServ;
	private User User;
	
	@InjectMocks
	private UserController uc;
	
//	@BeforeEach
//	public void setUp() {
//		User = new User(12,"harryvijjey","password","prem@gmail.com","ROLE_USER");
//		mockmvc = MockMvcBuilders.standaloneSetup(uc).build(); 
//	}
	
	@Test
	public void userRegisterTest() throws Exception {
		when(UserServ.Register(any())).thenReturn(User);
		mockmvc.perform(post("/api/r1/registration")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJSONString(User)))
				.andExpect(status().isCreated());
		
		verify(UserServ, times(1)).Register(any());
	}
	
	public static String asJSONString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	

}
