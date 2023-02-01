package com.example.demo.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.Product;

public interface ProductService {

	public void save(MultipartFile f);
	
	public List<Product> getAllProducts();
}
