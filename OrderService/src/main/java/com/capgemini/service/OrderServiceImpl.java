package com.capgemini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.model.Order;
import com.capgemini.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{

	private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    //creating a order operation
    @Override
    public Order createOrder(Order order) {
        order.setTotalPrice(order.getItems().stream().mapToInt(e -> e.getPrice() * e.getQuantity()).sum());
        return orderRepository.save(order);
    }

	@Override
	public List<Order> getAllOrder() {
		// TODO Auto-generated method stub
		return (List<Order>)orderRepository.findAll();
	}
}
