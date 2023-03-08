package com.easypharma.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.easypharma.entities.User;

public interface UserDao extends JpaRepository<User, Integer> {
	User findByEmail(String email);
	
	@Query("select count(u.userId) from User u where role = 'user'")
	Integer userCount();
}
