package com.example.demo.dao;

import java.util.List;

import com.example.demo.dto.Product;


public interface ProductRepo {
	public Product save(Product p);
	
	public List<Product> getAllProducts();
}
