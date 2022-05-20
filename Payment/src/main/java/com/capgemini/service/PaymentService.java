package com.capgemini.service;

import java.util.List;

import com.capgemini.model.Order;
import com.capgemini.model.Payment;

public interface PaymentService {

	void processPayment(Payment payment);
	public List<Payment> getAllPayment();
}
