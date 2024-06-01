package com.service;

import java.util.List;
import java.util.Map;

import com.model.Customer;

public interface CustomerService {

	Customer addCustomer(Customer customer);

	Customer getCustomerById(long id);

	List<Customer> getAllCustomer();

	Customer updateCustomer(Customer customer);

	Map<String, Object> deleteCustomer(long id);

}
