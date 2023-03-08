package com.easypharma.dtos.out;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.easypharma.daos.CartDao;
import com.easypharma.entities.Order;
import com.easypharma.entities.OrderItem;
import com.easypharma.entities.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
public class OrderDto {
	private int orderId;
	private double  orderAmount;
	@JsonFormat(pattern = "E, dd MMM yyyy HH:mm:ss")
	private Date orderDate;
	private int userId;
	private String	firstName ;
	private String lastName;
	private String email;
	private String mobileNumber;
	private String street;
	private String city;
	private int pincode;
	private String state;
	private int houseNumber;
	private List<Product> productList;
	private int quantity;
	

	public OrderDto() {
	}
	public OrderDto(int orderId, double orderAmount, Date orderDate, int userId, String firstName, String lastName,
			String email, String mobileNumber, String street, String city, int pincode, String state, int houseNumber) {
		this.orderId = orderId;
		this.orderAmount = orderAmount;
		this.orderDate = orderDate;
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.street = street;
		this.city = city;
		this.pincode = pincode;
		this.state = state;
		this.houseNumber = houseNumber;
	}
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public double getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}


	public List<Product> getProduct() {
		return productList;
	}
	public void setProduct(List<Product> productlist) {
		this.productList = productlist;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public static OrderDto fromEntity(Order order) {
		OrderDto dto=new OrderDto();
		BeanUtils.copyProperties(order, dto);
		dto.setUserId(order.getUser().getUserId());
		dto.setFirstName(order.getUser().getFirstName());
		dto.setLastName(order.getUser().getLastName());
		dto.setEmail(order.getUser().getEmail());
		dto.setMobileNumber(order.getUser().getMobileNumber());
		dto.setHouseNumber(order.getAddress().getHouseNumber());
		dto.setStreet(order.getAddress().getStreet());
		dto.setCity(order.getAddress().getCity());
		dto.setPincode(order.getAddress().getPincode());
		dto.setState(order.getAddress().getState());
		List<Product> productlist=new ArrayList<Product>();
		List<OrderItem> list = order.getOrderItems();
		for(OrderItem item: list) {
			item.getProduct().getProductName();
			item.getProduct().setQuantity(item.getQuantity());
			productlist.add(item.getProduct());
		}
		dto.setProduct(productlist);
		return dto;
	}


	
}