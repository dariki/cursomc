package com.netcracker.cursomc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.netcracker.cursomc.domain.Payment;

@Repository
public interface PaymentDAO extends JpaRepository<Payment, Integer> {

}
