package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ProductRepository;
import com.example.demo.service.config.ProductConfiguration;

import com.example.demo.dto.Product;
import com.example.demo.dto.ProductResponse;
import com.example.demo.exception.CurrencyNotValidException;
import com.example.demo.exception.OfferNotValidException;

import lombok.extern.slf4j.Slf4j;

@Service
public class ProductService {
	private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

	private ProductRepository productRepository;
	private ProductConfiguration productConfiguration;

	public ProductService(ProductRepository productRepository, ProductConfiguration productConfiguration) {

		this.productRepository = productRepository;
		this.productConfiguration = productConfiguration;
	}

	public ProductResponse addProduct(Product product) {
		// log.info("adding product");
		if (product.getPrice() == 0 && product.getDiscount() > 0) {
			throw new OfferNotValidException("No discount is allowed at 0 product price");
		}

		if (!productConfiguration.getCurrencies().contains(product.getCurrency().toUpperCase())) {
			throw new CurrencyNotValidException(
					"Invalid Currency. Valid currencies- " + productConfiguration.getCurrencies());
		}

		Product savedProduct = productRepository.save(product);

		return new ProductResponse("success", savedProduct.getName() + "added into the system");
	}

	public List<Product> listAllProducts() {

		return productRepository.findAll();
	}

	public List<Product> productCategoryList(String category) {
		return productRepository.findByCategory(category);
		/*
		 * List<Product> productsByCategory =
		 * productRepository.findByCategory(category); if (productsByCategory.isEmpty())
		 * { throw new ProductNotFoundException("No product found for the category-" +
		 * category); } return productsByCategory;
		 */

	}

	public Product productById(String id) {
		return productRepository.findById(id).get();

	}

	public String updateProduct(Product product) {

		productRepository.save(product);
		return "product updated";
	}

	public String deleteProductById(String id) {
		productRepository.deleteById(id);
		return "Product Deleted";
	}

}
