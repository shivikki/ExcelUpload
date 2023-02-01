package com.example.demo.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.ProductRepo;
import com.example.demo.dto.Product;
import com.example.demo.helper.ExcelHelper;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo productRepo;

	public void save(MultipartFile f) {
		try {
			List<Product> products = ExcelHelper.convertExcelToList(f.getInputStream());
			products.forEach((p) -> {
				productRepo.save(p);
			});
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public List<Product> getAllProducts() {
		List<Product> prodList = new ArrayList<>();
		prodList = productRepo.getAllProducts();
		return prodList;
	}
}
