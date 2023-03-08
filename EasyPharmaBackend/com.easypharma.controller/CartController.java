package com.easypharma.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.easypharma.daos.CartDao;
import com.easypharma.dtos.AddToCartDto;
import com.easypharma.dtos.CartDto;
import com.easypharma.dtos.CartItemDtoR;
import com.easypharma.dtos.out.CartDtoOut;
import com.easypharma.entities.Cart;
import com.easypharma.entities.Product;
import com.easypharma.entities.User;
import com.easypharma.models.GetCart;
import com.easypharma.models.Response;
import com.easypharma.services.CartServiceImpl;
import com.easypharma.services.ProductService;
import com.easypharma.services.UserService;

@CrossOrigin
@RestController
@RequestMapping("/cartitem")
public class CartController {

	@Autowired
	private CartServiceImpl cartService;

	@Autowired
	private ProductService productService;

	@Autowired
	private UserService userService;

	@PostMapping("/{email}")
	public ResponseEntity<?> addToCart(AddToCartDto addToCartDto, @PathVariable("email") String email) {
		User user = userService.findByEmail(email);
		if (user != null) {
			Product product = productService.findProductById(addToCartDto.getProductId());
			cartService.addToCart(addToCartDto, product, user);
			return Response.success(true);
		}
		return Response.error(null);
	}

	@GetMapping("/{email}")
	public ResponseEntity<?> getCartItems(@PathVariable("email") String email) {
		User user = userService.findByEmail(email);
		if (user != null) {
			CartDto cartDto = cartService.listCartItems(user);
			List<CartItemDtoR> list = new ArrayList<>();
			for (CartItemDtoR obj : cartDto.getcartItems()) {
				list.add(obj);
			}
			Stream<CartDtoOut> result = list.stream().map(cartitem -> CartDtoOut.fromEntity(cartitem));
			return Response.success(result);
		}
		return Response.error(null);
	}

	@GetMapping("/countitem/{email}")
	public ResponseEntity<?> getCartItemsCount(@PathVariable("email") String email) {
		User user = userService.findByEmail(email);
		if (user == null)
			throw new RuntimeException("User is empty");
		Integer count = cartService.cartItemCount(user);
//			System.out.println("Count of Cart items:"+count);
		return Response.success(count);
	}

	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteByCartIdAndProductId(@RequestParam("cartItemId") String cartItemId,
			@RequestParam("email") String email) {
		int id = Integer.parseInt(cartItemId);
		User user = userService.findByEmail(email);
		if (user != null) {
			cartService.deleteCartItem(id, user.getUserId());
			return Response.success(true);
		}
		return Response.error(null);
	}

	@DeleteMapping("/{email}")
	public ResponseEntity<?> deleteByUserId(@PathVariable("email") String email) {
		User user = userService.findByEmail(email);
		cartService.deleteUserCartItems(user);
		return Response.success(true);
	}
}