package com.niit.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.shopping.dao.ProductDAO;
import com.niit.shopping.model.Product;

import java.util.List;



@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    public Product getProductById (String id) {
        return productDAO.getproductById(id);
    }

    
    public void addProduct(Product product) {
    	productDAO.saveOrUpdate(product);
    }

    public void editProduct(Product product) {
    	productDAO.saveOrUpdate(product);
    }

    public void deleteProduct(String id) {
    	productDAO.delete(id);
    }
}
