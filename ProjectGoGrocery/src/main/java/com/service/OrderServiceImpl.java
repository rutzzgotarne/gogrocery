package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.OrderRepository;
import com.model.Order;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepo;

    @Override
    public Order addOrder(Order order) {
        return orderRepo.save(order);
    }

    @Override
    public Order getOrderById(long id) {
        return orderRepo.findById(id).orElse(null);
    }

    @Override
    public List<Order> getAllOrder() {
        return orderRepo.findAll();
    }
    
    @Override
    public Order updateOrder(Order order) {
        // Check if the order exists in the database
        if (orderRepo.existsById(order.getOrderId())) {
            return orderRepo.save(order);
        } else {
            // Return null or throw an exception indicating that the order doesn't exist
            return null;
        }
    }

    @Override
    public Map<String, Object> deleteOrder(long id) {
        Map<String, Object> response = new HashMap<>();
        if (orderRepo.existsById(id)) {
            orderRepo.deleteById(id);
            response.put("Deleted", "Order Deleted Successfully");
        } else {
            response.put("Not Deleted", "Order Not Deleted Because ID not Found");
        }
        return response;
    }
}



/*
package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.OrderRepository;
import com.model.Order;

@Service
public class OrderServiceImpl implements OrderService {

	

	@Autowired
	OrderRepository orderRepo;


	@Override
	public Order addOrder(Order order)
	{
		Order o = new Order();
	o = orderRepo.save(order);
	return o;
	}

	@Override
	public Order getOrderById(long id)
	{
	return orderRepo.findById(id).orElse(null);
	}

	@Override
	public List<Order> getAllOrder()
	{
	return orderRepo.findAll();
	}
	
	@Override
	public Order updateOrder(Order order)
	{
		Order existingOrder = orderRepo.findById(order.getOrderId()).orElse(null);
		existingOrder.setProducts(order.getProducts());
		existingOrder.setPayment(order.getPayment());

	Order updatedOrder = orderRepo.save(existingOrder);
	return updatedOrder;
	}

	@Override
	public Map<String, Object> deleteOrde(long id)
	{
	Map<String, Object> response = new HashMap<>();
	Order o = orderRepo.findById(id).orElse(null);

	if(o == null)
	{
	response.put("Not Deleted", "Order Not Deleted Because ID not FOUND");
	}
	else
	{
	orderRepo.delete(o);
	response.put("Deleted", "Order Deleted Successfully");
	}
	return response;
	}
}

*/
