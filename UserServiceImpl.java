package com.easypharma.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easypharma.daos.UserDao;
import com.easypharma.entities.User;

@Transactional
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PasswordEncoder passwordEncode;

	@Override
	public User findUserById(int id) {
		Optional<User> user = userDao.findById(id);
		return user.orElse(null);
	}

	@Override
	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}

	@Override
	public User save(User user) {
		String encPassword = passwordEncode.encode(user.getPassword());
		user.setPassword(encPassword);
		return userDao.save(user);
			
	}

//	@Override
//	public User authenticate(String email, String password) {
//		User user = userDao.findByEmail(email);
//		if (user != null && user.getPassword().equals(password))
//			return user;
//		return null;
//	}
	@Override
	public User authenticate(String email, String password) {
		User user = userDao.findByEmail(email);
		System.out.println(user);
		System.out.println(user.getPassword());
		if (user != null &&  passwordEncode.matches(password,user.getPassword())) {
			System.out.println(passwordEncode.matches(password,user.getPassword()));
			return user;
		}
		return null;
	}


	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public boolean deleteById(int id) {
		if (userDao.existsById(id)) {
			userDao.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Integer userCount() {
		return userDao.userCount();
	}

	@Override
	public User changePassword(String email,String password, String newPassword) {
		  User user = findByEmail(email);
		  System.out.println("servixe:"+user+" pass"+password+" "+newPassword);
	       if ( user != null && passwordEncode.matches (password, user.getPassword())){
	    	   System.out.println("Hello");
	           String encPass =  passwordEncode.encode(newPassword);
	           user.setPassword(encPass);
	           System.out.println("service method :"+user);
	           return userDao.save(user);
	       }
	       return null;
	}



}