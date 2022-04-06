package com.example.demo.dto;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product")
public class Product
{
	@Id
	private String id;
	
	@NotNull(message = "Product name should not be null")
	private String  name;
	
	@NotNull(message = "Category of the product should not be null")
	private String category;
	
	@Min(0)
	private double price;
	private String currency;
	
	@Max(100)
	private  double discount;
	private String discountDescription;
	//private List<String> imageURLs;
	private String imageURLs;
	
	
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/*
	 * public List<String> getImageURLs() { return imageURLs; } public void
	 * setImageURLs(List<String> imageURLs) { this.imageURLs = imageURLs; }
	 */
	public String getId() {
		return id;
	}
	public String getImageURLs() {
		return imageURLs;
	}
	public void setImageURLs(String imageURLs) {
		this.imageURLs = imageURLs;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * public Category getCategory() { return category; } public void
	 * setCategory(Category category) { this.category = category; }
	 */
	public double getPrice() {
		return price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public String getDiscountDescription() {
		return discountDescription;
	}
	public void setDiscountDescription(String discountDescription) {
		this.discountDescription = discountDescription;
	}
	
	

}
