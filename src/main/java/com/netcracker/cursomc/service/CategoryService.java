package com.netcracker.cursomc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcracker.cursomc.dao.CategoryDAO;
import com.netcracker.cursomc.domain.Category;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	public Category find(Integer id) {
		
		Optional<Category> category = categoryDAO.findById(id);		
		return category.get();
	}

}
