package com.easypharma.services;

import org.springframework.web.multipart.MultipartFile;

import com.easypharma.entities.Product;

import java.util.List;

public interface ProductService {
	List<Product> findAllProduct();
	Product findProductById(int id);
	void deleteById(int id);
    Product save(Product product ,  MultipartFile thumbnail);
	Product update(Product p, MultipartFile thumbnail);
	List<Product> findByProductName(String name);
	Integer productCount();
	//List<Product> findProductByProductTypeId(int id);
}
