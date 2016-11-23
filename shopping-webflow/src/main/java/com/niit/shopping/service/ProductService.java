package com.niit.shopping.service;



import java.util.List;

import com.niit.shopping.model.Product;


public interface ProductService {

    

    Product getProductById(String id);

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(String id);
}
