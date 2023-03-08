package com.easypharma.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easypharma.daos.OrderItemDao;
import com.easypharma.entities.Order;
import com.easypharma.entities.OrderItem;

@Transactional
@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	private OrderItemDao orderItemDao;

	@Override
	public OrderItem saveOrderItem(OrderItem orderItem) {
		return orderItemDao.save(orderItem);
	}

	@Override
	public List<OrderItem> findAllByOrder(Order order) {
		return orderItemDao.findAllByOrder(order);

	}

	@Override
	public int getQuantityByOrderId(Order order) {
		int quantity = 0;
		List<OrderItem> orderItemList = orderItemDao.findByOrder(order);
		for (OrderItem orderItem : orderItemList) {
			quantity += orderItem.getQuantity();
		}
		return quantity;
	}

}