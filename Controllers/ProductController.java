package com.easypharma.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easypharma.daos.ProductTypeDao;
import com.easypharma.dtos.ProductDTO;
import com.easypharma.dtos.ProductInDTO;
import com.easypharma.entities.Product;
import com.easypharma.entities.ProductType;
import com.easypharma.models.Response;
import com.easypharma.services.ProductService;

@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@Autowired
	private ProductTypeDao typeDao;

	@PostMapping("")
	public ResponseEntity<?> save(ProductInDTO productDto) {
			Product product = ProductInDTO.toEntity(productDto);
			Optional<ProductType> type = typeDao.findById(productDto.getProductTypeId());
			if(type!=null) {
				product.setProductType(type.orElse(null));
				product = productService.save(product, productDto.getThumbnail());
				return Response.success(product);
			}
			return Response.error(null);	
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		try {
			productService.deleteById(id);
			return Response.success(true);
		}catch(RuntimeException e) {
			e.printStackTrace();
			return Response.error(null);
		}
		
	}

//	@GetMapping("/{id}")
//	public ResponseEntity<?> findProductById(@PathVariable("id") int id) {
//		try {
//			Product product = productService.findProductById(id);
//			if( product != null ) {
//				ProductDTO result = ProductDTO.fromEntity(product);
//				return Response.success(result);
//			}
//			return Response.error(null);
//		}catch(RuntimeException e) {
//			return Response.error(null);
//		}
//		
//	}

	@GetMapping("")
	public ResponseEntity<?> findProductTypeAll() {
		List<Product> list = productService.findAllProduct();
		list.forEach(System.out::println);
		if( list != null) {
			List<ProductDTO> result = new ArrayList<>();
			for (Product product : list)
				result.add(ProductDTO.fromEntity(product));
			return Response.success(result);
		}
		return Response.error(null);
		
	}

//	@GetMapping("/type/{id}")
//	public ResponseEntity<?> findProductByProductTypeId(@PathVariable("id") int id) {
//		List<Product> list = productService.findProductByProductTypeId(id);
//		if( list != null) {
//			List<ProductDTO> result = new ArrayList<>();
//			for (Product product : list)
//				result.add(ProductDTO.fromEntity(product));
//			return Response.success(result);
//		}
//		return Response.error(null);
//		
//	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, ProductInDTO productDto) {
		Optional<ProductType> type = typeDao.findById(productDto.getProductTypeId());
		try {
			productDto.setProductId(id);
			Product product = ProductInDTO.toEntity(productDto);
			product.setProductType(type.orElse(null));
			Product newProd = productService.update(product, productDto.getThumbnail());
			return Response.success(newProd);
		}catch(RuntimeException e) {
			e.printStackTrace();
			return Response.error(null);
		}
		
	}

	@GetMapping("/name/{name}")
	public ResponseEntity<?> findProductByName(@PathVariable("name") String name) {
		List<Product> list = productService.findByProductName(name);
		if(list != null) {
			List<ProductDTO> result = new ArrayList<>();
			for (Product product : list)
				result.add(ProductDTO.fromEntity(product));
			return Response.success(result);
		}
		return Response.error(null);
		
	}
	
	@GetMapping("/productcount")
		public ResponseEntity<?> productCount(){
		Integer count = productService.productCount();
		return Response.success(count);
	}
}