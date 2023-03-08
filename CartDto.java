package com.easypharma.dtos;

import java.util.List;

public class CartDto {
	 private List<CartItemDtoR> cartItems;
	    private double totalCost;

	    public CartDto(List<CartItemDtoR> cartItemDtoList, double totalCost) {
	        this.cartItems = cartItemDtoList;
	        this.totalCost = totalCost;
	    }

	    public List<CartItemDtoR> getcartItems() {
	        return cartItems;
	    }

	    public void setCartItems(List<CartItemDtoR> cartItemDtoList) {
	        this.cartItems = cartItemDtoList;
	    }

	    public double getTotalCost() {
	        return totalCost;
	    }

	    public void setTotalCost(int totalCost) {
	        this.totalCost = totalCost;
	    }

		@Override
		public String toString() {
			return "CartDto [cartItems=" + cartItems + ", totalCost=" + totalCost + "]";
		}
	    
}