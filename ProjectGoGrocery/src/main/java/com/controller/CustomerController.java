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
import com.model.Customer;
import com.service.CustomerService;

@RestController
@CrossOrigin(origins ="http://localhost:4200") 
public class CustomerController {
	
	@Autowired
	CustomerService customerService;

	@PostMapping("/addCustomer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer)
	{
		Customer c = customerService.addCustomer(customer);
	return ResponseEntity.status(HttpStatus.CREATED).header("Add", "Customer Added").body(c);
	}

	@GetMapping("/getCustomer/{id}")
	public ResponseEntity<Customer> getAdmin(@PathVariable("id") long id)
	{
		Customer c = customerService.getCustomerById(id);
	return ResponseEntity.status(HttpStatus.OK).header("Get", "Customer GET").body(c);
	}

	@GetMapping("/getAllCustomer")
	public ResponseEntity<List<Customer>> getAll()
	{
	List<Customer> c = customerService.getAllCustomer();
	return ResponseEntity.status(HttpStatus.OK).header("Get", "ALL Customer GET").body(c);
	}

	@PutMapping("/updateCustomer/{id}")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer)
	{
		Customer c = customerService.updateCustomer(customer);
	return ResponseEntity.status(HttpStatus.OK).header("Update", "Customer Updated").body(c);
	}

	@DeleteMapping("/deleteCustomer/{id}")
	public ResponseEntity<Map<String, Object>> deleteCustomer(@PathVariable long id)
	{
	Map<String, Object> response = customerService.deleteCustomer(id);

	return ResponseEntity.ok(response);
	}

}
