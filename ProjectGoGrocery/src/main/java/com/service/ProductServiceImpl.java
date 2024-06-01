package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.ProductRepository;
import com.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepo;


	@Override
	public Product addProduct(Product product)
	{
		Product p = new Product();
	p = productRepo.save(product);
	return p;
	}

	@Override
	public Product getProductById(int id)
	{
	return productRepo.findById(id).orElse(null);
	}

	@Override
	public List<Product> getAllProduct()
	{
	return productRepo.findAll();
	}
	
	@Override
	public Product updateProduct(Product product)
	{
		Product existingProduct = productRepo.findById(product.getProductId()).orElse(null);
		existingProduct.setProductCategory(product.getProductCategory());
		existingProduct.setProductName(product.getProductName());
		existingProduct.setProductPrice(product.getProductPrice());
		existingProduct.setDescription(product.getDescription());
		existingProduct.setProductQuantity(product.getProductQuantity());
		

		Product updatedProduct = productRepo.save(existingProduct);
	return updatedProduct;
	}

	@Override
	public Map<String, Object> deleteProduct(int id)
	{
	Map<String, Object> response = new HashMap<>();
	Product p = productRepo.findById(id).orElse(null);

	if(p == null)
	{
	response.put("Not Deleted", "Product Not Deleted Because ID not FOUND");
	}
	else
	{
		productRepo.delete(p);
	response.put("Deleted", "Product Deleted Successfully");
	}
	return response;
	}
}
