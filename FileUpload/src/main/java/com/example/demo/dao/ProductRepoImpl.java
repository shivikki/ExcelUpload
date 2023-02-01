package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.catalina.mapper.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.demo.dto.Product;
import com.example.demo.queryConstant.QueryConstant;

@Repository
public class ProductRepoImpl implements ProductRepo {

	private static final Logger LOG = LoggerFactory.getLogger(ProductRepoImpl.class);

	// private DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplateNamed;

	public Product save(Product p) {
		List<Product> productList = new ArrayList<>();
		int result = 0;
		try {
			//List<Map<String, Object>> prodData = jdbcTemplate.queryForList(QueryConstant.SAVE_PRODUCT);

			// update function returns int value ie no. of rows affected
			result = jdbcTemplate.update(QueryConstant.SAVE_PRODUCT, p.getProductId(), p.getProductName(), 
					p.getProductDesc(),p.getPrice());

			LOG.info("Number of record inserted " + result);

		} catch (Exception e) {
			LOG.error("Exception in ProductRepoImpl class + save() m/d" + e);
		}

		return p;
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> prodList=new ArrayList<>();
		try {
			List<Map<String, Object>> listData = jdbcTemplate.queryForList(QueryConstant.GET_ALL_PRODUCTS);


			listData.forEach((list) ->{
				Product prod;
				prod = (Product) mapProductList(list);
				prodList.add(prod);
			});
		} catch (Exception e) {
			LOG.error("Exception in ProductRepoImpl class + getAllProducts() m/d" + e);
		}
		return prodList;
	}

	public Object mapProductList(Map<String, Object> list) {
		Product prod=new Product();
		prod.setProductId((int) list.get("product_id")); // "id" col name in db
		prod.setProductName((String) list.get("product_name"));
		prod.setProductDesc((String) list.get("product_desc"));
	    prod.setPrice((int) list.get("product_price"));
		return prod;
	}
}
