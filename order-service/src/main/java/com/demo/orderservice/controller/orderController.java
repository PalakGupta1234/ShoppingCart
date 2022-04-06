package com.demo.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.orderservice.model.Order;
import com.demo.orderservice.model.Transection_Response;
import com.demo.orderservice.service.orderService;

@RestController
@RequestMapping("/order/")
public class orderController
{
	@Autowired
	private orderService service;
	
	@PostMapping("/placeOrder")
	public Transection_Response placeOrder(@RequestBody Order order)
	{
		return service.placeOrder(order);
	}

}
