package com.easypharma.services;


import java.util.List;

import com.easypharma.entities.Order;
import com.easypharma.entities.OrderItem;

public interface OrderItemService {
	
	OrderItem saveOrderItem(OrderItem orderItem);
	
	List<OrderItem> findAllByOrder(Order order);

	int getQuantityByOrderId(Order order);
}
