package com.easypharma.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easypharma.dtos.UserDTO;
import com.easypharma.entities.User;
import com.easypharma.models.ChangePassword;
import com.easypharma.models.Credentials;
import com.easypharma.models.Response;
import com.easypharma.services.UserService;

@CrossOrigin
@RestController
@RequestMapping("")
public class UserControllerImpl {

	@Autowired
	private UserService userService;
	//find user in database authenticate identity of that user if password matches with database password then 
	//and only then give  access.
	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(Credentials cred) {
		try {
			User user = userService.authenticate(cred.getEmail(), cred.getPassword());
			if(user!=null) {
				UserDTO userDto = UserDTO.fromEntity(user);
				return Response.success(userDto);
			}
			return Response.error(null);
		}catch(RuntimeException e) {
			System.out.println(e.getMessage());
			return Response.error(null);
		}

	}

	@PostMapping("/user")
	public ResponseEntity<?> saveUser(UserDTO userdto) {
		User user = UserDTO.toEntity(userdto);
		if(user!=null) {
			User saveduser = userService.save(user);
			userdto = UserDTO.fromEntity(saveduser);
			return Response.success(userdto);
		}	
		return Response.error(null);
	}

	@GetMapping("/users")
	public ResponseEntity<?> findAll() {
		try {
			List<User> list = userService.findAll();
			List<UserDTO> result = new ArrayList<>();
			if(list!=null) {
				for (User user : list)
					result.add(UserDTO.fromEntity(user));
				return Response.success(result);
			}else {
				return Response.error(null);
			}
			
		}catch(RuntimeException e) {
			e.printStackTrace();
			return Response.error(null);
		}
		
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") int id) {
		try {
			userService.deleteById(id);
			return Response.success(true);
		}catch(RuntimeException e) {
			e.printStackTrace();
			return Response.error(null);
		}
	}
	//find user by email and send data back to front end
	@GetMapping("/user/{email}")
	public ResponseEntity<?> findUser(@PathVariable("email") String email) {
		try {
			User user = userService.findByEmail(email);
			if(user!=null) {
				UserDTO userDto = UserDTO.fromEntity(user);
				return Response.success(userDto);
			}
			return Response.error(null);
			
		}catch(RuntimeException e) {
			System.out.println(e.getMessage());
			return Response.error(null);
		}
		
	}
	@PostMapping("/reset-password/{email}")
	public ResponseEntity<?> changePassword(@PathVariable("email") String email,  ChangePassword password) {			
			User user = userService.changePassword(email, password.getPassword(), password.getNewPassword());
			if( user != null)
				return Response.success(user);
			return Response.error(null);
	}
	@GetMapping("/usercount")
	public ResponseEntity<?> countUser(){
		Integer count = userService.userCount();
		return Response.success(count);
	}
	
	
}