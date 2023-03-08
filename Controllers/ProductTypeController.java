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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easypharma.dtos.ProductTypeDTO;
import com.easypharma.dtos.ProductTypeInDTO;
import com.easypharma.entities.ProductType;
import com.easypharma.models.Response;
import com.easypharma.services.ProductTypeService;

@CrossOrigin
@RestController
@RequestMapping("/type")
public class ProductTypeController {
	@Autowired
	ProductTypeService productTypeService;

//	@GetMapping("/{id}")
//	public ResponseEntity<?> findProductTypeById(@PathVariable("id") int id) {
//		ProductType productType = productTypeService.findProductTypeById(id);
//		ProductTypeDTO result = ProductTypeDTO.fromEntity(productType);
//		return Response.success(productType);
//	}
	
	//find all type of product and send as response
	@GetMapping("")
	public ResponseEntity<?> findProductTypeAll() {
		List<ProductType> list = productTypeService.findProductTypeAll();
	if(list!=null) {
		List<ProductTypeDTO> result = new ArrayList<>();
		for (ProductType productType : list)
			result.add(ProductTypeDTO.fromEntity(productType));
		System.out.println(result.toString());
		return Response.success(result);
	}
	return Response.error(null);
		
	}

	@PostMapping("")
	public ResponseEntity<?> save(ProductTypeInDTO productTypeDto) {
		try {
			ProductType productType = ProductTypeInDTO.toEntity(productTypeDto);
			if(productType!=null) {
				productType = productTypeService.saveProductType(productType, productTypeDto.getTypeThumbnail());
				return Response.success(productType);
			}
			return Response.error(null);
		}catch(RuntimeException e) {
			e.printStackTrace();
			return Response.error(null);
		}
		
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProductTypeById(@PathVariable("id") int id) {
		try {
			boolean productType = productTypeService.deleteProductTypeById(id);
			return Response.success(productType);
		}catch(RuntimeException e) {
			e.printStackTrace();
			return Response.error(null);
		}
	}

}
