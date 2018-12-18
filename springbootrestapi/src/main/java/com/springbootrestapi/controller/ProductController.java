package com.springbootrestapi.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springbootrestapi.dao.ProcuctDao;
import com.springbootrestapi.model.Product;

@RestController 
public class ProductController {
	@Autowired
	private ProcuctDao productDao; 
	@GetMapping("Products")
	public List<Product> ProducsList(){
		return productDao.findAll();
		
	}
	@GetMapping("Products/{id}")
	public Product getProduct(@PathVariable int id) {
		return productDao.findById(id);
	}
	
	@PostMapping("Products")
	public ResponseEntity<Void> saveProduct(@RequestBody Product product) {
		Product prod =productDao.save(product);
		if(product==null)
			return ResponseEntity.noContent().build();
		
		URI location= ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(prod.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	

}
