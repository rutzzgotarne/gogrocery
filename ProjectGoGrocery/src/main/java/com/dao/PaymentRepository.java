package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
