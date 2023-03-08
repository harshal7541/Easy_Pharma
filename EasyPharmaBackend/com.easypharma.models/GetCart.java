package com.easypharma.models;

import org.springframework.beans.BeanUtils;

import com.easypharma.entities.Product;

public class GetCart {

	private int quantity;
	private int productId;
	private int userId;
	private String thumbnail;
	private String productName;
	private double price;
	
   public GetCart()
   {
	   
   }


public GetCart(int quantity, int productId, int userId, String thumbnail, String name, double price) {
	super();
	this.quantity = quantity;
	this.productId = productId;
	this.userId = userId;
	this.thumbnail = thumbnail;
	this.productName = name;
	this.price = price;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public int getProductId() {
	return productId;
}

public void setProductId(int productId) {
	this.productId = productId;
}

public int getUserId() {
	return userId;
}

public void setUserId(int userId) {
	this.userId = userId;
}

public String getThumbnail() {
	return thumbnail;
}

public void setThumbnail(String thumbnail) {
	this.thumbnail = thumbnail;
}





public String getProductName() {
	return productName;
}


public void setProductName(String productName) {
	this.productName = productName;
}


public double getPrice() {
	return price;
}

public void setPrice(double price) {
	this.price = price;
}

@Override
public String toString() {
	return "GetCart [quantity=" + quantity + ", productId=" + productId + ", userId=" + userId + ", thumbnail="
			+ thumbnail + ", name=" + productName + ", price=" + price + "]";
}


public static GetCart fromEntity(Product product) {
	GetCart cart = new GetCart();
	BeanUtils.copyProperties(product, cart);
	return cart;
}




}