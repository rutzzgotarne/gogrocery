package com.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.model.Product;
import com.service.ProductService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

	@Autowired
	ProductService productService;

	@PostMapping("/addProduct")
	public ResponseEntity<Product> addProduct(@RequestBody Product product)
	{
		Product p = productService.addProduct(product);
	return ResponseEntity.status(HttpStatus.CREATED).header("Add", "Product Added").body(p);
	}

	@GetMapping("/getProduct/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable("id") int id)
	{
		Product p = productService.getProductById(id);
	return ResponseEntity.status(HttpStatus.OK).header("Get", "Product GET").body(p);
	}

	@GetMapping("/getAllProduct")
	public ResponseEntity<List<Product>> getAll()
	{
	List<Product> p = productService.getAllProduct();
	return ResponseEntity.status(HttpStatus.OK).header("Get", "ALL Product GET").body(p);
	}

	@PutMapping("/updateProduct")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product)
	{
		Product p = productService.updateProduct(product);
	return ResponseEntity.status(HttpStatus.OK).header("Update", "Product Updated").body(p);
	}

	@DeleteMapping("/deleteProduct/{id}")
	public ResponseEntity<Map<String, Object>> deleteProduct(@PathVariable int id)
	{
	Map<String, Object> response = productService.deleteProduct(id);

	return ResponseEntity.ok(response);
	}

}
