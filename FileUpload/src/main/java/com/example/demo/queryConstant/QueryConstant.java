package com.example.demo.queryConstant;

public class QueryConstant {

	public static final String SAVE_PRODUCT="INSERT INTO springjdbc.product_register\r\n"
			+ "(product_id,\r\n"
			+ "product_name,\r\n"
			+ "product_desc,\r\n"
			+ "product_price)\r\n"
			+ "VALUES\r\n"
			+ "(?,?,?,?);";
	
	
	public static final String GET_ALL_PRODUCTS="select * from springjdbc.product_register;";
}
