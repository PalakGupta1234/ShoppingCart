package com.demo.orderservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.orderservice.model.Order;

public interface OrderRepository extends CrudRepository<Order , Integer>
{

}
