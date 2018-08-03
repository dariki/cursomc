package com.netcracker.cursomc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.netcracker.cursomc.domain.Category;

@Repository
public interface CategoryDAO extends JpaRepository<Category, Integer> {

}
