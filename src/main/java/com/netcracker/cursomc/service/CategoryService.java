package com.netcracker.cursomc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.netcracker.cursomc.dao.CategoryDAO;
import com.netcracker.cursomc.domain.Category;

@Service
public class CategoryService extends MainService {
	
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

	public boolean delete(Integer id) {
		boolean returnDelete = false;
		try {
			categoryDAO.deleteById(id);
			returnDelete = true;
		} catch (EmptyResultDataAccessException emptyException) {
			returnDelete = false;
		}
		return returnDelete;
	}
}
