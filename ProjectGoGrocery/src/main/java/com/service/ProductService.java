package com.service;

import java.util.List;
import java.util.Map;

import com.model.Product;

public interface ProductService {

	Product addProduct(Product product);

	Product getProductById(int id);

	List<Product> getAllProduct();

	Product updateProduct(Product product);

	Map<String, Object> deleteProduct(int id);



	

}
