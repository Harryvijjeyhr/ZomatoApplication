package com.capgemini.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.capgemini.model.User;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class UserRepositoryTest {
	
	@Autowired
	private UserRepository UserRepo;

	@Test
	public void givenUserShouldReturnId() {
		User u = new User(12,"Harry","password","premvijjey14@gmail.com","ROLE_USER");
		UserRepo.save(u);
		User u2 = UserRepo.findById(u.getId()).get();
		assertNotNull(u2);
		assertEquals(u.getName(),u2.getName());
	}
	
	@Test
	public void getAllmustReturnallRestaurant() {
		User  u3 = new User(2,"vijjey","password","prem14@gmail.com","ROLE_USER");
		User  u4 = new User(32,"Prem","password","vijjey14@gmail.com","ROLE_USER");
		UserRepo.save(u3);
		UserRepo.save(u4);
		List<User>RestList = (List<User>) UserRepo.findAll();
		assertEquals("prem",RestList.get(1).getName());
	}

}
