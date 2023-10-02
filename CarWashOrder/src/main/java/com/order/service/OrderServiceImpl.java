package com.order.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.order.exception.OrderNotFoundException;
import com.order.models.Order;
import com.order.repo.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private RestTemplate restTemplate;

	private final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Override
	public Order placeOrder(Order order)throws OrderNotFoundException {

		Random random = new Random();
		order.setId(random.nextInt(99999999));
		order.setPaymentStatus("pending");
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		order.setDate(date);
		return orderRepository.save(order);

	}

	@Override
	public List<Order> getOrderListByName(String name)throws OrderNotFoundException {
		List<Order> orderList = orderRepository.findAll().stream()
				.filter(a -> a.getCustomerName().equalsIgnoreCase(name)).collect(Collectors.toList());
		if (orderList == null) {
			throw new OrderNotFoundException("Sorry, No order found with the provided name");
		}

		return orderList;
	}

//	@Override
//	public Order getOrderByCustomerName(String customerName) {
//		Order order = orderRepository.findAll().stream().filter(a -> a.getCustomerName().equalsIgnoreCase(customerName))
//				.findAny().orElseThrow(null);
//		return order;
//	}
	@Override
	public List<Order> getOrderByCustomerName(String name) {

		List<Order> order=orderRepository.findAllByCustomerName(name);

		if(order.isEmpty()) {

			throw new OrderNotFoundException("Not Found");
		}

		return order;

	}

	@Override

	public void deleteOrderById(int orderId) throws OrderNotFoundException {

		if (orderRepository.findById(orderId).isPresent()) {
			orderRepository.deleteById(orderId);

		} else {

			throw new OrderNotFoundException("Order with ID : " + orderId + " not found");

		}

	}

	@Override
	public List<Order> getAllOrder() {
		return orderRepository.findAll();
	}


@Override
public Order updatePaymentStatus(Order order) {

	orderRepository.findById(order.getId()).orElseThrow(()->new OrderNotFoundException("Not Found"));

	return orderRepository.save(order);

}
}
