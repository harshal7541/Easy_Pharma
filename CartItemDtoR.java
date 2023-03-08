package com.easypharma.dtos;

import com.easypharma.entities.Cart;
import com.easypharma.entities.Product;

public class CartItemDtoR {
	 private Integer cartId;
	    private Integer userId;
	    private Integer quantity;
	    private  Product product;

	    public CartItemDtoR() {
	    }

	    public CartItemDtoR(Cart cart) {
	        this.setCartId(cart.getCartId());
	        this.setUserId(cart.getUser().getUserId());
	        this.setQuantity(cart.getQuantity());
	        this.setProduct(cart.getProduct());
	    }

	    @Override
	    public String toString() {
	        return "CartDto{" +
	                "cartId=" + cartId +
	                ", userId=" + userId +
	                ", quantity=" + quantity +
	                ", productName=" + product.getProductName() +
	                '}';
	    }

	    public Integer getCartId() {
	        return cartId;
	    }

	    public void setCartId(Integer cartId) {
	        this.cartId = cartId;
	    }

	    public Integer getUserId() {
	        return userId;
	    }

	    public void setUserId(Integer userId) {
	        this.userId = userId;
	    }

	    public Integer getQuantity() {
	        return quantity;
	    }

	    public void setQuantity(Integer quantity) {
	        this.quantity = quantity;
	    }
	    public Product getProduct() {
	        return product;
	    }

	    public void setProduct(Product product) {
	        this.product = product;
	    }
}