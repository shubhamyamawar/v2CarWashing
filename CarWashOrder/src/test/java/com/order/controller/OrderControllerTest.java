package com.order.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.order.models.Order;
import com.order.service.OrderServiceImpl;

public class OrderControllerTest {
	
	@Mock
    private OrderController orderController = mock(OrderController.class);
	
	@InjectMocks
    private OrderServiceImpl orderService = mock(OrderServiceImpl.class);
    
//    @BeforeEach
//    public void setUp() {
//        orderService = mock(OrderServiceImpl.class);
//        orderController = new OrderController(orderService);
//    }
    
    @Test
    public void testGetOrderByCustomerName() throws ParseException {
        // Arrange
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		Date date = formatter.parse("2023-09-28");
		final Order order1 = new Order(1, "Pratiksha", "Ferrari roma", 1999, "Suyog", date, "Pending", "shubham@gmail.com");
		final Order order2 = new Order(1, "Rohit", "Ferrari roma", 1999, "Suyog", date, "Pending", "shubham@gmail.com");
		List<Order> arr = new ArrayList<>();
		arr.add(order1);
		arr.add(order2);
        
        // Mock the behavior of orderService
//        when(orderService.getOrderByCustomerName("Suyog")).thenReturn(arr);
        
        // Act
//        List<Order> result = orderController.getOrderByName("Ram");
        
        // Assert
        assertEquals(arr, orderController.getOrderByName("Ram"));
    }
    
//    @Test
//    public void testGetOrderByCustomerNameNoOrdersFound() {
//        // Arrange
//        String customerName = "Bob";
//        
//        // Mock the behavior of orderService when no orders are found
//        when(orderService.getOrderByCustomerName(customerName)).thenReturn(new ArrayList<>());
//        
//        // Act
//        List<Order> result = orderController.getOrderByName(customerName);
//        
//        // Assert
//        assertTrue(result.isEmpty());
//    }
}
