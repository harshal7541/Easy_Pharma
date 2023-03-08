package com.easypharma.dtos.out;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import com.easypharma.dtos.CartDto;
import com.easypharma.dtos.CartItemDtoR;
import com.easypharma.entities.Cart;

public class CartDtoOut {
	private int cartId;
	private int userId;
	private int productId;
	private String productName;
	private double price;
	private String thumbnail;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date expiryDate;
	private int quantity;
	
	public CartDtoOut() {
		// TODO Auto-generated constructor stub
	}

	public CartDtoOut(int cartId, int userId, int productId, String productName, double price,
			String thumbnail, Date expiryDate) {
		super();
		this.cartId = cartId;
		this.userId = userId;
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.thumbnail = thumbnail;
		this.expiryDate = expiryDate;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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


	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}


	public Date getExpiryDate() {
		return expiryDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public static CartDtoOut fromEntity(CartItemDtoR cart) {
		CartDtoOut dto=new CartDtoOut();
		BeanUtils.copyProperties(cart, dto);
		dto.setProductName(cart.getProduct().getProductName());
		dto.setProductId(cart.getProduct().getProductId());
		dto.setThumbnail(cart.getProduct().getThumbnail());
		dto.setPrice(cart.getProduct().getPrice());
		dto.setExpiryDate(cart.getProduct().getExpiryDate());
		dto.setQuantity(cart.getQuantity());
		return dto;
		
	}
	public static Cart toEntity(CartDtoOut dto) {
		Cart cart = new Cart();
		BeanUtils.copyProperties(dto, cart);
		return cart;
	}
}