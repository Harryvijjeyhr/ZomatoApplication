package com.capgemini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpStatus;

import com.capgemini.model.Payment;
import com.capgemini.service.PaymentService;

@RestController
@RequestMapping("/api/r1")
public class PaymentController {

	 private PaymentService paymentService;

	 	
	    @Autowired
	    public PaymentController(PaymentService paymentService) {
	        this.paymentService = paymentService;
	    }

	    @RequestMapping(value = "/payments", method = RequestMethod.POST)
	    @ResponseStatus(HttpStatus.CREATED)
	    public void pay(@RequestBody Payment payment) {
	        paymentService.processPayment(payment);
	    }
}
