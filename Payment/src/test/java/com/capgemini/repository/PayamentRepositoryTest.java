package com.capgemini.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.model.Payment;


class PayamentRepositoryTest {

	@Autowired
	private PayamentRepository paymentRepo;

	@Test
	public void givenPayment() {
		Payment p = new Payment("20222",0,40,"627c8a9ed7107501337eee4d", null);
		Payment p2 = new Payment("20222",0,40,"627c8a9ed7107501337eee4d", null);
		paymentRepo.save(p);
		paymentRepo.save(p2);
		List<Payment>pList = (List<Payment>)paymentRepo.findAll();
		
	}
}
