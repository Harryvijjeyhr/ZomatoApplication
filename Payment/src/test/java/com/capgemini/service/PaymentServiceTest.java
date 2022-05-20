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

import com.capgemini.model.Payment;

import com.capgemini.repository.PayamentRepository;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
class PaymentServiceTest {

	
	@Mock
	private PayamentRepository PayRepo;
	
	@InjectMocks
	private PaymentServiceImpl PayServImpl;
	@Test
	
	public void addRestaurantTest() {
		Payment p =new Payment("20222",0,40,"627c8a9ed7107501337eee4d", null);
		Payment p2 =new Payment("20223",0,40,"627c8a9ed7107501337eee43", null);
		PayRepo.save(p);
		PayRepo.save(p2);
		List<Payment>rList = new ArrayList<>();
		rList.add(p2);
		rList.add(p);	
		when(PayRepo.findAll()).thenReturn(rList);
		List<Payment> rList1 = PayServImpl.getAllPayment();
		assertEquals(rList, rList1);
		
	}
	

}
