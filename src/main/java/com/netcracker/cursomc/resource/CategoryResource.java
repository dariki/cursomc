package com.netcracker.cursomc.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.netcracker.cursomc.domain.Category;
import com.netcracker.cursomc.domain.MainDomain;
import com.netcracker.cursomc.service.CategoryService;
import com.netcracker.cursomc.service.exception.StandardError;

@RestController
@RequestMapping(value = "/category")
public class CategoryResource {
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id, HttpServletRequest request){
		
		Category category = categoryService.find(id);

		ResponseEntity<?> responseEntityCategory = ResponseEntity.badRequest().build();

		if(category != null) {
			 responseEntityCategory = ResponseEntity.ok(category);
		} else {
			responseEntityCategory = StandardError.getInstance(HttpStatus.NOT_FOUND);
		}
 
		return responseEntityCategory;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll(HttpServletRequest request){
		
		List<Category> categoryList = categoryService.findAll();

		ResponseEntity<?> responseEntityCategory = ResponseEntity.badRequest().build();

		responseEntityCategory = ResponseEntity.ok(categoryList);
 
		return responseEntityCategory;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Category category){
		category = categoryService.insert(category);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(category.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Category category){
		
		ResponseEntity<?> responseEntity = ResponseEntity.badRequest().build();
		
		if(id != null && id > 0) {
			category.setId(id);
			category = categoryService.update(category);
			responseEntity = ResponseEntity.noContent().build();
		} else {
			MainDomain mainDomain = new MainDomain();
			responseEntity = new ResponseEntity<MainDomain>(mainDomain, HttpStatus.NOT_FOUND);
		}
		
		return responseEntity;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE) 	
	public ResponseEntity<?> delete(@PathVariable Integer id){
		
		ResponseEntity<?> responseEntity = ResponseEntity.badRequest().build();
		
		if(id != null) {
			categoryService.delete(id);
		}
		return responseEntity;
	}
}
