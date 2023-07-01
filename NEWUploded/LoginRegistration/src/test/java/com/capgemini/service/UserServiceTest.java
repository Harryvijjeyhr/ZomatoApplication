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


import com.capgemini.model.User;
import com.capgemini.repository.UserRepository;
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class UserServiceTest {

	@Mock
	private UserRepository UserRepo;
	
	@InjectMocks
	private UserServiceImpl UserServImpl;
	
	
	@Test
	public void getAllUserTest() {
//		User u1=new User("12","Harryvijjey","password","Prem@gmail.com","ROLE_USER");
//		User u2=new User("13","Hayvijjey","password","Prem@gmail.com","ROLE_USER");
//		User u3=new User("14","Hryvijjey","password","Prem@gmail.com","ROLE_USER");
//		UserRepo.save(u1);
//		UserRepo.save(u2);
//		UserRepo.save(u3);
//		List<User>uList =new ArrayList<>();
//		uList.add(u1);
//		uList.add(u2);
//		uList.add(u3);
//		
//		when(UserRepo.findAll()).thenReturn(uList);
//		List<User> uList1 = UserServImpl.getAllUser();
//		assertEquals(uList, uList1);
//		verify(UserRepo, times(1)).save(u1);
	}

}
