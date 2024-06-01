package com.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="customers")
public class Customer {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="customer_seq")
	@SequenceGenerator(name="customer_seq",sequenceName="customer_sequence")
	private long customerId;
	private String customerName;
	private long custContactNo;
	private String custAddress;
	private String custEmail;
	private String custPassward;
	
	@OneToMany(fetch=FetchType.EAGER,cascade = CascadeType.PERSIST)
	private List<Order> order;

	public Customer() {
		super();
	}

	public Customer(long customerId, String customerName, long custContactNo, String custAddress, String custEmail,
			String custPassward, List<Order> order) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.custContactNo = custContactNo;
		this.custAddress = custAddress;
		this.custEmail = custEmail;
		this.custPassward = custPassward;
		this.order = order;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getCustContactNo() {
		return custContactNo;
	}

	public void setCustContactNo(long custContactNo) {
		this.custContactNo = custContactNo;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getCustPassward() {
		return custPassward;
	}

	public void setCustPassward(String custPassward) {
		this.custPassward = custPassward;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	
	
}
