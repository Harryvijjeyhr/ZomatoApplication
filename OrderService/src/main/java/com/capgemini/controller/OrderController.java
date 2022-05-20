package com.capgemini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.model.Order;
import com.capgemini.service.OrderService;

//Annotation
@RestController
@RequestMapping("/api/r1")
public class OrderController {

	 OrderService orderService;

	    @Autowired
	    public OrderController(OrderService orderService) {
	        this.orderService = orderService;
	    }

	    //Creating a new order -by using POST method
	    @RequestMapping(value = "/restaurants/{rid}/orders", method = RequestMethod.POST)
	    @ResponseStatus(value = HttpStatus.CREATED)
	    public Order createOder(@RequestBody Order order) {
	        return orderService.createOrder(order);
	    }
	    @GetMapping("/test")
		public String test() {
			return "test";
		}
	    
	    @GetMapping("/Orders")
	    public ResponseEntity<List<Order>> getAllOrder(){
	    	return new ResponseEntity<List<Order>>((List<Order>)orderService.getAllOrder(),HttpStatus.OK);
	    }
}
