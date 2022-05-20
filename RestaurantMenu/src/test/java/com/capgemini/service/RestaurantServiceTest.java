package com.capgemini.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.model.Restaurant;
import com.capgemini.model.User;
import com.capgemini.repository.RestuarantRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class RestaurantServiceTest {

	@Mock
	private RestuarantRepository RestRepo;
	
	@InjectMocks
	private RestaurantServiceImpl RestServImpl;
	
	
	@Test
	public void addRestaurantTest() {
		Restaurant r1 =new Restaurant("627f3d62b2220d6518396e9a","shri Sangeethas");
		Restaurant r2 =new Restaurant("627f3d62b2220d6518396e9b","shri Sangethas");
		
		RestRepo.save(r1);
		RestRepo.save(r2);
		
		List<Restaurant>rList = new ArrayList<>();
		rList.add(r2);
		rList.add(r1);	
		when(RestRepo.findAll()).thenReturn(rList);
		Restaurant rList1 = RestServImpl.createRestaurant(r2);
		assertEquals(rList, rList1);
		verify(RestRepo, times(1)).save(r2);
	}
	
	

}
