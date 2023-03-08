package com.easypharma.services;

import java.util.Iterator;
import java.util.List;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easypharma.daos.AddressDao;
import com.easypharma.daos.OrderDao;
import com.easypharma.daos.OrderItemDao;
import com.easypharma.dtos.CartDto;
import com.easypharma.dtos.CartItemDtoR;
import com.easypharma.dtos.PlaceOrderDTO;
import com.easypharma.entities.Order;
import com.easypharma.entities.OrderItem;
import com.easypharma.entities.User;
@Service
@Transactional
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private OrderItemDao orderItemDao;
	
	@Autowired
	private AddressDao addressDao;
	
	@Autowired
	private CartServiceImpl cartService;
	

    @Autowired
    OrderItemService orderItemService;

    public Order saveOrder(PlaceOrderDTO orderDto, User user){
        Order order = getOrderFromDto(orderDto, user);
        return orderDao.save(order);
    }

    private Order getOrderFromDto(PlaceOrderDTO orderDto, User user) {
        Order order = new Order(orderDto, user);
        return order;
    }
    	
    public List<Order> listOrders(User user) {
 
        List<Order> orderList = orderDao.findAllByUserOrderByOrderDateDesc(user);
        return orderList;
    }
    
    public List<Order> listAllOrders() {
        List<Order> orderList = orderDao.findAllByOrderByOrderDateDesc();
        return orderList;
    }
//    public Order getOrder(int orderId) throws RuntimeException {
//        Optional<Order> order = orderDao.findById(orderId);
//        if (order.isPresent()) {
//            return order.get();
//        }
//        throw new RuntimeException("Order not found");
//    }

    public void placeOrder(User user) {
        CartDto cartDto = cartService.listCartItems(user);
        System.out.println("place order items :"+cartDto);

        PlaceOrderDTO placeOrderDto = new PlaceOrderDTO();
        placeOrderDto.setUser(user);
        placeOrderDto.setTotalPrice(cartDto.getTotalCost());
        //Changes Updated
        placeOrderDto.setAddress(addressDao.getByUserId(user.getUserId()));

        Order newOrder = saveOrder(placeOrderDto, user);
        List<CartItemDtoR> cartItemDtoList = cartDto.getcartItems();
        for (CartItemDtoR cartItemDto : cartItemDtoList) {
            OrderItem orderItem = new OrderItem(
            		cartItemDto.getCartId(),
            		cartItemDto.getQuantity(),
            		cartItemDto.getProduct().getPrice(),
                    newOrder,
                    cartItemDto.getProduct());
            orderItemService.saveOrderItem(orderItem);
        }
        cartService.deleteUserCartItems(user);
    }
	
}
