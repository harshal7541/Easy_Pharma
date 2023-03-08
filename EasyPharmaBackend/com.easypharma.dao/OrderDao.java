package com.easypharma.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easypharma.entities.Order;
import com.easypharma.entities.User;

public interface OrderDao  extends JpaRepository<Order, Integer> {
	
	List<Order> findAllByUserOrderByOrderDateDesc(User user);

	Optional<Order> findFirstByOrderByOrderDateDesc();

	List<Order> findAllByOrderByOrderDateDesc();
	
	
}
