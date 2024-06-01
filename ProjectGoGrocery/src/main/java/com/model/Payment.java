package com.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="payments")
public class Payment {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="payment_seq")
	@SequenceGenerator(name="payment_seq",sequenceName="payment_sequence")
	private long paymentId;
	private Double amount;
	private String currency;
	private String paymentType;
	private String paymentStatus;
	private Date paymentDate;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id") // Assuming there's a column named order_id in Payment table
	private Order order;

	
	public Payment() {
		super();
	}


	public Payment(long paymentId, Double amount, String currency, String paymentType, String paymentStatus,
			Date paymentDate, Order order) {
		super();
		this.paymentId = paymentId;
		this.amount = amount;
		this.currency = currency;
		this.paymentType = paymentType;
		this.paymentStatus = paymentStatus;
		this.paymentDate = paymentDate;
		this.order = order;
	}


	public long getPaymentId() {
		return paymentId;
	}


	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}


	public Double getAmount() {
		return amount;
	}


	public void setAmount(Double amount) {
		this.amount = amount;
	}


	public String getCurrency() {
		return currency;
	}


	public void setCurrency(String currency) {
		this.currency = currency;
	}


	public String getPaymentType() {
		return paymentType;
	}


	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}


	public String getPaymentStatus() {
		return paymentStatus;
	}


	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}


	public Date getPaymentDate() {
		return paymentDate;
	}


	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}


	public Order getOrder() {
		return order;
	}


	public void setOrder(Order order) {
		this.order = order;
	}
	
	
}
