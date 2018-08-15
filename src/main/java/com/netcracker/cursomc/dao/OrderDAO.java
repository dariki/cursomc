package com.netcracker.cursomc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.netcracker.cursomc.domain.Order;

@Repository
public interface OrderDAO extends JpaRepository<Order, Integer> {

}
