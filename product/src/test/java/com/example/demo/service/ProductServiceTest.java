package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.dto.Product;
import com.example.demo.dto.ProductResponse;
import com.example.demo.exception.CurrencyNotValidException;
import com.example.demo.exception.OfferNotValidException;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.config.ProductConfiguration;

class ProductServiceTest
{
	
	private ProductRepository productRepository;
	private ProductConfiguration productConfiguration;
	
	private ProductService productService;
	
	 @BeforeEach
	    void setUp() {
	        productRepository = mock(ProductRepository.class);
	        productConfiguration = new ProductConfiguration();
	        productConfiguration.setCurrencies(List.of("INR", "USD"));
	        productService = new ProductService(productRepository, productConfiguration);
	    }
	
	

	@Test
	void addProduct()
	{
		 Product product = new Product();
         product.setPrice(0.0);
         product.setDiscount(10);
         // productService.addProduct(product);
         assertThrows(OfferNotValidException.class, () -> productService.addProduct(product));
    }
	
	@Test
	 void addProductCurrencyNotValidException() {
         Product product = new Product();
         product.setPrice(10000.0);
         product.setDiscount(10);
         product.setCurrency("HKD");
         //product.setCurrency("INR");
         assertThrows(CurrencyNotValidException.class, () -> productService.addProduct(product));
     }
		/*
		 * @Test void addProductIntoTheSystem() { Product product = new Product();
		 * product.setName("samsung TV"); product.setPrice(10000.0);
		 * product.setDiscount(10); product.setCurrency("INR");
		 * 
		 * when(productRepository.save(any(Product.class))).thenReturn(product);
		 * 
		 * ProductResponse actualResponse = productService.addProduct(product);
		 * 
		 * ProductResponse expectedResponse = new ProductResponse("success",
		 * product.getName() + "added into the system");
		 * 
		 * assertThat(expectedResponse).isEqualTo(actualResponse);
		 * 
		 * }
		 */

}
