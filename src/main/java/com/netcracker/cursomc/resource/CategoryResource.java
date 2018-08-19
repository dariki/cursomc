package com.netcracker.cursomc.resource;

import java.net.URI;

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

@RestController
@RequestMapping(value = "/category")
public class CategoryResource extends MainResource {
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id, HttpServletRequest request){
		
		Category category = categoryService.find(id);

		ResponseEntity<?> responseEntityCategory = ResponseEntity.ok(category);

		if(categoryService.isErro()) {
			MainDomain mainDomain = new MainDomain();
			responseEntityCategory = new ResponseEntity<MainDomain>(mainDomain, HttpStatus.NOT_FOUND);//ResponseEntity.ok(new ErrorDomain(id));
		}
 
		return responseEntityCategory;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Category category){
		category = categoryService.insert(category);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(category.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
		
	

}
