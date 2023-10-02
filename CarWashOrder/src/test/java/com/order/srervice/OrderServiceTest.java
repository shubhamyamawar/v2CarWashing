package com.order.srervice;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.order.exception.OrderNotFoundException;
import com.order.models.Order;
import com.order.repo.OrderRepository;
import com.order.service.OrderServiceImpl;

public class OrderServiceTest {

	@Mock
	private OrderServiceImpl orderServiceImpl = mock(OrderServiceImpl.class);;
	@InjectMocks
	private OrderRepository orderRepository;

	@Test
	void placeOrder() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		Date date = formatter.parse("2023-09-28");
		final Order order = new Order(1, "Pratiksha", "Ferrari roma", 1999, "Shubham", date, "Pending",
				"shubham@gmail.com");
		when(orderServiceImpl.placeOrder(order)).thenReturn(order);
		assertEquals(order, orderServiceImpl.placeOrder(order));
	}

	@Test
	void getOrderListByName() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		Date date = formatter.parse("2023-09-28");
		final Order order1 = new Order(1, "Pratiksha", "Ferrari roma", 1999, "Shubham", date, "Pending",
				"shubham@gmail.com");
		final Order order2 = new Order(1, "Rohit", "Ferrari roma", 1999, "Suyog", date, "Pending", "shubham@gmail.com");
		ArrayList<Order> arr = new ArrayList<>();
		arr.add(order1);
		arr.add(order2);
		when(orderServiceImpl.getOrderByCustomerName("order")).thenReturn(arr);
		assertEquals(arr, orderServiceImpl.getOrderByCustomerName("order"));
	}

	@Test
	void getOrderByCustomerName() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		Date date = formatter.parse("2023-09-28");
		final Order order1 = new Order(1, "Pratiksha", "Ferrari roma", 1999, "Shubham", date, "Pending",
				"shubham@gmail.com");
		final Order order2 = new Order(1, "Rohit", "Ferrari roma", 1999, "Suyog", date, "Pending", "shubham@gmail.com");
		ArrayList<Order> arr = new ArrayList<>();
		arr.add(order1);
		arr.add(order2);
		when(orderServiceImpl.getOrderByCustomerName("order")).thenReturn(arr);
		assertEquals(arr, orderServiceImpl.getOrderByCustomerName("order"));
	}
	
//	   @Test
//	    public void testDeleteOrderByIdOrderExists() throws OrderNotFoundException {
//	        // Arrange
//	        int orderId = 1;
//	        when(orderRepository.findById(orderId)).thenReturn(Optional.of(new Order()));
//	        assertEquals("Order with ID : " + orderId + " not found", orderServiceImpl.deleteOrderById(orderId));
//	   }
	   
	@Test
	void updateProfile() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		Date date = formatter.parse("2023-09-28");
		final Order order = new Order(1, "Rohit", "Ferrari roma", 1999, "Suyog", date, "Pending", "shubham@gmail.com");
		when(orderServiceImpl.updatePaymentStatus(order)).thenReturn(order);
		assertEquals(order, orderServiceImpl.updatePaymentStatus(order));
	}
}
