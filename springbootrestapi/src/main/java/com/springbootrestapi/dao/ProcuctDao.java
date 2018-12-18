package com.springbootrestapi.dao;

import java.util.List;

import com.springbootrestapi.model.Product;

public interface ProcuctDao {
	public List<Product> findAll();
	public Product findById(int id);
	public Product save(Product product);

}
