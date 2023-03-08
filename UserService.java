package com.easypharma.services;

import java.util.List;

import com.easypharma.entities.User;

public interface UserService {

	User save(User user);
	
	User findUserById(int id);

	List<User> findAll();

	boolean deleteById(int id);

	User findByEmail(String email);

	Integer userCount();

	User authenticate(String email, String password);

	User changePassword(String email, String password, String newPassword);

	
	
	

}
