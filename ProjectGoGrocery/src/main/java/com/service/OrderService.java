package com.service;

import java.util.List;
import java.util.Map;

import com.model.Order;

public interface OrderService {

	Order addOrder(Order order);

	Order getOrderById(long id);

	List<Order> getAllOrder();

	Order updateOrder(Order order);

	Map<String, Object> deleteOrder(long id);

}
