package com.capgemini.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.capgemini.model.Restaurant;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class RestuarantRepositoryTest {

	@Autowired
	private RestuarantRepository RestRepo;
	
	
	
	@Test
	public void givenRestaurantshouldReturnId() {
		Restaurant r = new Restaurant("235","shangeethas");//userInput
		RestRepo.save(r);//Data is saved into db
		Restaurant r2 =RestRepo.findById(r.getId()).get();//Fectching the data from database
		assertNotNull(r2); //Check if it is returning the restaurant object
		assertEquals(r.getName(),r2.getName());
	}
	
//	@Test
//	public void getAllmustReturnallRestaurant() {
//		Restaurant  r3 = new Restaurant("235","shangeethas");
//		Restaurant  r4 = new Restaurant("245","adyaranandhabhavan");
//		RestRepo.save(r3);
//		RestRepo.save(r4);
//		List<Restaurant>RestList = (List<Restaurant>) RestRepo.findAll();
//		assertEquals("adyaranandhabhavan",RestList.get(1).getName());
//	}
	
	
}