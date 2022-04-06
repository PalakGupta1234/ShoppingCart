package com.example.demo.controller;


import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/*import org.slf4j.Logger;
import org.slf4j.LoggerFactory;*/
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Product;
import com.example.demo.dto.ProductResponse;
import com.example.demo.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/v1")

public class ProductController 
{
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	private ProductService productService;
	
	public ProductController(ProductService productService) 
	{
		
		this.productService = productService;
	}



	@PostMapping("/addProduct")
	/*
	 * ResponseEntity<Product> addProduct(@RequestBody @Valid Product product) {
	 * String status = productService.addProduct(product);
	 * logger.info("Product added status - {}" , status);
	 * 
	 * return ResponseEntity.status(HttpStatus.CREATED).body(product); }
	 */
	
	ResponseEntity<ProductResponse> addProduct(@RequestBody @Valid Product product) {

        ProductResponse productResponse = productService.addProduct(product);

        return ResponseEntity.status(HttpStatus.CREATED).body(productResponse);
    }
	
	@GetMapping("/productList")
	List<Product> productList()
	{
		//logger.info("Listing Product");
		List<Product> productList = productService.listAllProducts();
		//logger.info("All the product returned - {} " , productList);
		return productList;
	}
	
	@GetMapping("/productList/{category}")
	List<Product> productCategoryList(@PathVariable String category)
	{
		return productService.productCategoryList(category);
	}
	
	@GetMapping("/product/{id}")
	Product productById(@PathVariable String id)
	{
		return productService.productById(id);
	}
	
	@PutMapping("/productUpdate")
	String updateProduct(@RequestBody Product product)
	{
		return productService.updateProduct(product);
	}
	
	@DeleteMapping("/product/{id}")
	String deleteProductById(@PathVariable String id)
	{
		return productService.deleteProductById(id);
	}
	

}
