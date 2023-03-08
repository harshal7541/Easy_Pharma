package com.easypharma.dtos;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.easypharma.entities.Product;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductDTO {
	private int productId;
	private String productName;
	private String description;
	private double price;
	private int stocks;
	@JsonProperty("productThumbnail")
	private String thumbnail;
	private int productTypeId;
	private Date manufactureDate;
	private Date expiryDate;

	public ProductDTO() {

	}

	public ProductDTO(int productId, String productName, String description, double price, int stocks, String thumbnail,
			int productTypeId, Date manufactureDate, Date expiryDate, String benefits, String use, String safty) {
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

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
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


	public static ProductDTO fromEntity(Product product) {
		ProductDTO dto = new ProductDTO();
		BeanUtils.copyProperties(product, dto);
		dto.setProductTypeId(product.getProductType().getProductTypeId());
		return dto;
	}

}
