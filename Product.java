package com.easypharma.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name = "products")
@Entity
public class Product {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "product_id")
	private int productId;
	@Column(name = "name")
	private String productName;
	private String description;
	private double price;
	private int stocks;
	@Column(name = "product_thumbnail")
	private String thumbnail;
	@Temporal(TemporalType.DATE)
	@Column(name = "manfact_date")
	private Date manufactureDate;
	@Temporal(TemporalType.DATE)
	@Column(name = "expiry_date")
	private Date expiryDate;
//	@JsonIgnore
	private int  quantity;
	
	 @JsonIgnore
	 @ManyToOne
	 @JoinColumn(name = "product_type_id")
	 private ProductType productType;

	
	 
	public Product() {

	}

	public Product(int productId, String productName, String description, double price, int stocks, String thumbnail,
			Date manufactureDate, Date expiryDate ) {
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.stocks = stocks;
		this.thumbnail = thumbnail;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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

	
	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", description=" + description
				+ ", price=" + price + ", stocks=" + stocks + ", thumbnail=" + thumbnail + ", manufactureDate=" + manufactureDate + ", expiryDate=" + expiryDate + "]";
	}

	
}