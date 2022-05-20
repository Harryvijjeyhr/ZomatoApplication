package com.capgemini.service;

import java.util.List;

import com.capgemini.model.Order;

public interface OrderService {

	//create order operation
	Order createOrder(Order order);
	public List<Order> getAllOrder();
}
