package com.easypharma.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.easypharma.daos.OrderDao;
import com.easypharma.dtos.out.OrderDetailsDto;
import com.easypharma.dtos.out.OrderDto;
import com.easypharma.entities.Order;
import com.easypharma.entities.User;
import com.easypharma.models.Response;
import com.easypharma.services.OrderItemService;
import com.easypharma.services.OrderServiceImpl;
import com.easypharma.services.UserService;

@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderServiceImpl orderService;
	@Autowired
	private OrderDao dao;

	@Autowired
	private OrderItemService orderItemService;

	@Autowired
	private UserService userService;

	@PostMapping("/add")
	public ResponseEntity<?> placeOrder(@RequestParam("userId") String userId) {
		try {
			int userid = Integer.parseInt(userId);
			User user = userService.findUserById(userid);
			orderService.placeOrder(user);
			Optional<Order> order = dao.findFirstByOrderByOrderDateDesc();
			OrderDetailsDto result = OrderDetailsDto.fromEntity(order.orElse(null));
			return Response.success(result);
		} catch (RuntimeException e) {
			return Response.error(e);
		}
	}

	@GetMapping("/allorders")
	public ResponseEntity<?> getAllOrders(@RequestParam("email") String email) {
		User user = userService.findByEmail(email);
		if (user != null) {
			List<Order> orderDtoList = orderService.listOrders(user);
			List<OrderDto> list = new ArrayList<>();
			for (Order order : orderDtoList) {
				int quantity = orderItemService.getQuantityByOrderId(order);
				OrderDto orderDTo = OrderDto.fromEntity(order);
				orderDTo.setQuantity(quantity);
				System.out.println("Hie : " + orderDTo.getQuantity());
				list.add(orderDTo);
			}
			return Response.success(list);
		}
		return Response.error(null);
	}

	@GetMapping("/admin/allorders")
	public ResponseEntity<?> getAllOrdersforAdmin() {
		List<Order> orderDtoList = orderService.listAllOrders();
		if (orderDtoList != null) {
			Stream<OrderDto> result = orderDtoList.stream().map(order -> OrderDto.fromEntity(order));
			return Response.success(result);
		}
		return Response.error(null);
	}

//	@GetMapping("/{id}")
//	public ResponseEntity<?> getOrderDetails(@PathVariable("id") Integer id) {
//		try {
//			Order order = orderService.getOrder(id);
//			OrderDto orderdto = OrderDto.fromEntity(order);
//			return Response.success(orderdto);
//		} catch (RuntimeException e) {
//			return Response.error(e);
//		}
//
//	}
}