package com.order.service;

import java.util.List;

import com.order.exception.OrderNotFoundException;
import com.order.models.Order;

public interface OrderService  {

	public Order placeOrder(Order order)throws OrderNotFoundException;

	public List<Order> getOrderListByName(String name);

	public List<Order> getOrderByCustomerName(String customerName);

	public void deleteOrderById(int orderId)throws OrderNotFoundException;
	
	 public List<Order> getAllOrder();
	 
	 public Order updatePaymentStatus(Order order);
	 

}
