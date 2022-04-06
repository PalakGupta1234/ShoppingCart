package com.demo.paymentservice.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.paymentservice.model.Payment;
import com.demo.paymentservice.repository.PaymentRepository;

@Service
public class PaymentService 
{
	@Autowired
	private PaymentRepository paymentRepository;

	public Payment doPay(Payment payment) {
		payment.setPaymentStatus(paymentStatus());
		payment.setTransectionId(UUID.randomUUID().toString());
		return paymentRepository.save(payment);
	}

	private String paymentStatus() {
		
		return new Random().nextBoolean()?"success":"failure";
	}

}
