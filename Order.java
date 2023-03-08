package com.easypharma.entities;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.easypharma.dtos.PlaceOrderDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "order_amount")
    private Double orderAmount;

    @Column(name = " order_date")
    private Date orderDate;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<OrderItem> orderItems;

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @OneToOne(targetEntity = Address.class, fetch = FetchType.EAGER,cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(nullable = false, name = "address_id")
    private Address address;
    
    public Order() {
    }

    public Order(PlaceOrderDTO orderDto, User user){
        this.user = user;
        this.orderDate = new Date();
		/*
		 * LocalDate currentLocalDate = LocalDate.now();
		 * 
		 * // Getting system timezone ZoneId systemTimeZone = ZoneId.systemDefault();
		 * 
		 * // converting LocalDateTime to ZonedDateTime with the system timezone
		 * ZonedDateTime zonedDateTime = currentLocalDate.atStartOfDay(systemTimeZone);
		 * 
		 * // converting ZonedDateTime to Date using Date.from() and
		 * ZonedDateTime.toInstant() Date utilDate =
		 * Date.from(zonedDateTime.toInstant()); this.orderDate = utilDate; // Date in =
		 * new Date(); // LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(),
		 * ZoneId.of("Asia/Kolkata")); // this.orderDate =
		 * Date.from(ldt.atZone(ZoneId.of("Asia/Kolkata")).toInstant());
		 */        
        this.orderAmount = orderDto.getTotalPrice();
        this.address=orderDto.getAddress();
    }
    

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

   
    public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderAmount=" + orderAmount + ", orderDate=" + orderDate
				+ ", orderItems=" + orderItems + ", user=" + user + "]";
	}
    
}
