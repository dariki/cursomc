package com.netcracker.cursomc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.netcracker.cursomc.domain.Category;
import com.netcracker.cursomc.domain.Product;

@Repository
public interface ProductDAO extends JpaRepository<Product, Integer> {

}
