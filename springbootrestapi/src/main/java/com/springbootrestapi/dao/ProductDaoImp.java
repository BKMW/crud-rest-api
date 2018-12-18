package com.springbootrestapi.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
	
import com.springbootrestapi.model.Product;

@Repository
public class ProductDaoImp implements ProcuctDao {
	public static List<Product> products=new ArrayList<Product>();
	static {
		products.add(new Product(1,"pc",100));
		products.add(new Product(2,"TV",100));
		products.add(new Product(3,"Game",100));
	}

	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return products;
	}

	public Product findById(int id) {
		// TODO Auto-generated method stub
		for(Product product:products) {
			if(product.getId()==id)
				return product;
		}
		return null;
	}

	public Product save(Product product) {
		// TODO Auto-generated method stub
		//must model has default constructor to can add product 
		products.add(product);
		return product;
	}

}
