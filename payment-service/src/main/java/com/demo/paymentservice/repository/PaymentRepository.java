package com.demo.paymentservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.paymentservice.model.Payment;

@Repository
public interface PaymentRepository extends CrudRepository<Payment,Integer>
{

}
