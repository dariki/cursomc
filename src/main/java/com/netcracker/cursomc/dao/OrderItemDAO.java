package com.netcracker.cursomc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.netcracker.cursomc.domain.OrderItem;

@Repository
public interface OrderItemDAO extends JpaRepository<OrderItem, Integer> {

}
