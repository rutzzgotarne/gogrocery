package com.controller;

import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RestController;
import com.model.Order;
import com.service.OrderService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

	@Autowired
	OrderService orderService;

	@PostMapping("/addOrder")
	public ResponseEntity<Order> addOrder(@RequestBody Order order)
	{
		Order o = orderService.addOrder(order);
	return ResponseEntity.status(HttpStatus.CREATED).header("Add", "Order Added").body(o);
	}

	@GetMapping("/getOrder/{id}")
	public ResponseEntity<Order> getOrder(@PathVariable("id") long id)
	{
		Order o = orderService.getOrderById(id);
	return ResponseEntity.status(HttpStatus.OK).header("Get", "Order GET").body(o);
	}

	@GetMapping("/getAllOrder")
	public ResponseEntity<List<Order>> getAll()
	{
	List<Order> o = orderService.getAllOrder();
	return ResponseEntity.status(HttpStatus.OK).header("Get", "ALL Order GET").body(o);
	}

	@PutMapping("/updateOrder")
	public ResponseEntity<Order> updateOrder(@RequestBody Order order)
	{
		Order o = orderService.updateOrder(order);
	return ResponseEntity.status(HttpStatus.OK).header("Update", "Order Updated").body(o);
	}

	@DeleteMapping("/deleteOrder/{id}")
	public ResponseEntity<Map<String, Object>> deleteOrder(@PathVariable long id)
	{
	Map<String, Object> response = orderService.deleteOrder(id);

	return ResponseEntity.ok(response);
	}

}
