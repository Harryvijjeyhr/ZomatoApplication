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
		User r = new User(21,"harry","password","prem@gmail.com","ROLE_USER");
		User r2 = new User(21,"harry","password","prem@gmail.com","ROLE_USER");
		UserRepo.save(r);
		UserRepo.save(r2);
		List<User>UserList = (List<User>) UserRepo.findAll();
//		assertEquals("prem@gmail.com",UserRepo.findByEmail().find());
	}

}

//assertEquals(r.getName(),r2.getName());
