package com.capgemini.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.List;
import org.springframework.http.MediaType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.capgemini.model.Restaurant;
import com.capgemini.service.RestaurantService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
class RestaurantMenuControllerTest {

	private MockMvc mockMvc;
	
	
	@Mock
	private RestaurantService rs;
	private Restaurant r;
	private List<Restaurant> RestList;
	
	@InjectMocks
	private RestaurantMenuController rc;
	
	@BeforeEach
	public void setUp() {
		r = new Restaurant( "207"," Ramhotel");
		mockMvc = MockMvcBuilders.standaloneSetup(rc).build();
	}
	
	@Test
	public void addRestaurantControllerTest() throws Exception {
		when(rs.createRestaurant(any())).thenReturn(r);
		mockMvc.perform(post("/api/v1/add/restaurant")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJSONString(r)))
				.andExpect(status().isCreated());
		
		verify(rs, times(1)).createRestaurant(any());
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