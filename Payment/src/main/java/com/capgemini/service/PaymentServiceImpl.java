package com.capgemini.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capgemini.model.CreditCardInfo;
import com.capgemini.model.Order;
import com.capgemini.model.Payment;
import com.capgemini.repository.OrderRepository;
import com.capgemini.repository.PayamentRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PaymentServiceImpl implements PaymentService{

	
	private RestTemplate restTemplate;
    private OrderRepository orderRepository;
    private PayamentRepository paymentRepository;
	
    	@Autowired
	    public PaymentServiceImpl(RestTemplate restTemplate, OrderRepository orderRepository, PayamentRepository paymentRepository) {
	        this.restTemplate = restTemplate;
	        this.orderRepository = orderRepository;
	        this.paymentRepository = paymentRepository;
	    }

	 	@Override
	    public void processPayment(Payment payment) {
	        System.out.println("ProcessPayment called()");
	        payment = paymentRepository.save(payment);
	        String orderCompleteUpdater = "http://order-complete-updater";
	        String orderId = payment.getOrderId();
	        if (orderId == null) {
	            sendErrorMessage("Missing orderId in payment");
	            return;
	        }
	        Order order = orderRepository.findOrderById(orderId);
	        if (order != null && validateCreditCardInfo(payment.getCreditCardInfo())) {
	            if (order.getTotalPrice() != payment.getAmount()) {
	                String errorMessage = "Payment amount: " + payment.getAmount() + " doesn't match with order price: " +
	                        order.getTotalPrice() + ", orderId = " + orderId;
	                sendErrorMessage(errorMessage);
	                return;
	            } else {
	                order.setPaymentId(payment.getId());
	                long deliveryTime = getDeliveryTime();
	                order.setDeliveryTime(deliveryTime);
	                orderRepository.save(order);
	                restTemplate.postForLocation(orderCompleteUpdater + "/api/orders", order);
	            }
	        } else {
	            String errorMessage = order == null ? "Failed to retrieve order for orderId: " + orderId
	                    : "Invalid credit card information for orderId: " + orderId;
	            sendErrorMessage(errorMessage);
	        }
	    }

	    public void processPaymentFallback(Payment payment) {
	        System.out.println("Fallback method is called.");
	    }

	    private boolean validateCreditCardInfo(CreditCardInfo creditCardInfo) {
	        return true;
	    }

	    private long getDeliveryTime() {
	        Random random = new Random();
	        int randomPeriod = 5 + random.nextInt(60 - 5 + 1);
	        return System.currentTimeMillis() + randomPeriod * 60 * 1000;
	    }

	    private void sendErrorMessage(String errorMessage) {
//	        log.warn(errorMessage);
	        String orderCompleteUpdater = "http://order-complete-updater";
	        restTemplate.postForLocation(orderCompleteUpdater + "/api/errors", errorMessage);
	    }

		@Override
		public List<Payment> getAllPayment() {
			// TODO Auto-generated method stub
			return (List<Payment>)paymentRepository.findAll();
		}
}
