package com.easypharma.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.easypharma.entities.Order;
import com.easypharma.entities.OrderItem;
import com.easypharma.entities.User;

public interface OrderItemDao extends JpaRepository<OrderItem, Integer> {

	List<OrderItem> findAllByOrder(Order order);

	
	/*
	 * @Query("select o.quantity from OrderItem o where order.orderId='orderid' ")
	 * int getQuantityByOrderId(int orderid);
	 */
	 
	List<OrderItem> findByOrder(Order order);
	
	

}
