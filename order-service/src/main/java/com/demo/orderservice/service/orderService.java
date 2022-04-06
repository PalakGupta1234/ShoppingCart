package com.demo.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.orderservice.model.Order;
import com.demo.orderservice.model.Payment;
import com.demo.orderservice.model.Transection_Response;
import com.demo.orderservice.repository.OrderRepository;

@Service
public class orderService 
{
	
	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private RestTemplate template;
	
	public Transection_Response placeOrder(Order order)
	{
		repository.save(order);
		Payment paymentReq = new Payment();
		paymentReq.setOrderId(order.getId());
		paymentReq.setTotalAmount(order.getQuantity()*order.getPrice());
		
		Payment paymentRes = template.postForObject("http://localhost:8088/payment/doPay/", paymentReq, Payment.class);
		Transection_Response t_Response = new Transection_Response();
		t_Response.setOrder(order);
		t_Response.setStatus(paymentRes.getPaymentStatus());
		t_Response.setAmount(paymentRes.getTotalAmount());
		t_Response.setTransectionId(paymentRes.getTransectionId());
		return t_Response;
		
		
	}

}
