package com.order.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


import com.order.models.Order;

public interface OrderRepository extends MongoRepository<Order, Integer>{

	 public List<Order> findAll();
	 
	 public List<Order> findAllByCustomerName(String name);
	 

}
