package com.easypharma.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easypharma.entities.ProductType;

public interface ProductTypeDao extends JpaRepository<ProductType, Integer> {
	
}
