package com.niit.shopping.dao;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.niit.shopping.model.Product;


public interface ProductDAO {


	public List<Product> list();

	public Product get(String id);

	public void saveOrUpdate(Product product);

	public void delete(String id);

	public MultipartFile getImage();
	
	Product getproductById(String id);


}
