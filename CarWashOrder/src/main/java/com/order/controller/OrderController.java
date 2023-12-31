package com.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.exception.OrderNotFoundException;
import com.order.models.Order;
import com.order.repo.OrderRepository;
import com.order.service.OrderServiceImpl;

@RestController
@RequestMapping("/order")
@CrossOrigin("*")
public class OrderController {

	@Autowired
	private OrderServiceImpl orderServiceImpl;

	@Autowired
	private OrderRepository orderRepository;



	public OrderController(OrderServiceImpl orderService) {
	// TODO Auto-generated constructor stub
}

	//	Method to place order
	@PostMapping("/place-order")

	public ResponseEntity<Order> bookWash(@RequestBody Order order) throws OrderNotFoundException {

		Order order1 = orderServiceImpl.placeOrder(order);

		return new ResponseEntity<Order>(order, HttpStatus.CREATED);

	}

	// Method to get orders by customer name
	
	@GetMapping("/get-orders/{name}")
	public List<Order> getOrderByName(@PathVariable String name) {

		return orderServiceImpl.getOrderByCustomerName(name);

	}

	// Method to get all the orders
	@GetMapping("/get-all-orders")
	public ResponseEntity<List<Order>> getOrders() {
		List<Order> order = orderServiceImpl.getAllOrder();
		return new ResponseEntity<List<Order>>(order, HttpStatus.OK);
	}

	// Method to update the payment status
//	@PutMapping("/update-status")
//	public Order updatePaymentStatus(@RequestBody Order order) {
//		return orderRepository.save(order);
//	}
	@PutMapping("/update-status")
 public ResponseEntity<Order> updatePaymentStatus(@RequestBody Order order) {

		return new ResponseEntity<Order>(orderServiceImpl.updatePaymentStatus(order), HttpStatus.OK);

	}

	// Method to test order
	@GetMapping("/test-order")
	public String testOrder() {
		return "Order service running";
	}

//	Deleting washpack by id
	@DeleteMapping("/delete/{orderId}")
	public String deleteById(@PathVariable("orderId") int orderId) throws OrderNotFoundException {
		orderServiceImpl.deleteOrderById(orderId);

		return "deleted";

	}

}