package com.easypharma.dtos;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import com.easypharma.entities.Product;

public class ProductInDTO {
	
	private int productId;
	private String productName;
	private String description;
	private double price;
	private int stocks;
	private MultipartFile thumbnail;
	private int productTypeId;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date manufactureDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date expiryDate;
	
	public ProductInDTO() {
	
	}

	public ProductInDTO(int productId, String productName, String description, double price, int stocks,
			MultipartFile thumbnail, int productTypeId, Date manufactureDate, Date expiryDate) {
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.stocks = stocks;
		this.thumbnail = thumbnail;
		this.productTypeId = productTypeId;
		this.manufactureDate = manufactureDate;
		this.expiryDate = expiryDate;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStocks() {
		return stocks;
	}

	public void setStocks(int stocks) {
		this.stocks = stocks;
	}

	public MultipartFile getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(MultipartFile thumbnail) {
		this.thumbnail = thumbnail;
	}

	public int getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(int productTypeId) {
		this.productTypeId = productTypeId;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Override
	public String toString() {
		return "ProductInDTO [productId=" + productId + ", productName=" + productName + ", description=" + description
				+ ", price=" + price + ", stocks=" + stocks + ", thumbnail=" + thumbnail + ", productTypeId="
				+ productTypeId + ", manufactureDate=" + manufactureDate + ", expiryDate=" + expiryDate + "]";
	}
	public static Product toEntity(ProductInDTO dto) {
		Product product = new Product();
		BeanUtils.copyProperties(dto, product, "thumbnail");
		return product;
	}

}
