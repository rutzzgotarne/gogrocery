package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CustomerRepository;
import com.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepo;


	@Override
	public Customer addCustomer(Customer customer)
	{
		Customer c = new Customer();
	c = customerRepo.save(customer);
	//sendRegistrationMail(a.getAdminId());
	return c;
	}

	@Override
	public Customer getCustomerById(long id)
	{
	return customerRepo.findById(id).orElse(null);
	}

	@Override
	public List<Customer> getAllCustomer()
	{
	return customerRepo.findAll();
	}
	
	@Override
	public Customer updateCustomer(Customer customer)
	{
	Customer existingCustomer = customerRepo.findById(customer.getCustomerId()).orElse(null);
	existingCustomer.setCustomerName(customer.getCustomerName());
	existingCustomer.setCustContactNo(customer.getCustContactNo());
	existingCustomer.setCustAddress(customer.getCustAddress());
	existingCustomer.setCustEmail(customer.getCustEmail());
	existingCustomer.setCustPassward(customer.getCustPassward());
	

	Customer updatedCustomer = customerRepo.save(existingCustomer);
	return updatedCustomer;
	}

	@Override
	public Map<String, Object> deleteCustomer(long id)
	{
	Map<String, Object> response = new HashMap<>();
	Customer a = customerRepo.findById(id).orElse(null);

	if(a == null)
	{
	response.put("Not Deleted", "Customer Not Deleted Because ID not FOUND");
	}
	else
	{
	customerRepo.delete(a);
	response.put("Deleted", "Customer Deleted Successfully");
	}
	return response;
	}
}
