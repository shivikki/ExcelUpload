package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.helper.ExcelHelper;
import com.example.demo.service.ProductService;

@RestController
@CrossOrigin("*")
public class ProductController {

	@Autowired
	private ProductService ps;

   @PostMapping("upload")
   public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file){
	   if(ExcelHelper.checkExcelFormat(file)) {
		   this.ps.save(file);
		   return ResponseEntity.ok(Map.of("msg","Success"));
	   }
	   
	  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Enter correct format") ;
   }
}
