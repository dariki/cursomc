package com.netcracker.cursomc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.netcracker.cursomc.domain.Customer;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Integer> {

}
