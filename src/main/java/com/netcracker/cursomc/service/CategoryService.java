package com.netcracker.cursomc.service;

import java.util.List;
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
		Optional<Category> optionalCategory = categoryDAO.findById(id);
		return optionalCategory.orElse(null);
	}

	public Category insert(Category category) {
		category.setId(null);
		return categoryDAO.save(category);
	}

	public Category update(Category category) {
		return categoryDAO.save(category);
	}

	public void delete(Integer id) {
		categoryDAO.deleteById(id);
	}

	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
