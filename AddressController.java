package com.easypharma.controllers;

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

import com.easypharma.dtos.AddressDTO;
import com.easypharma.dtos.ProductDTO;
import com.easypharma.dtos.ProductInDTO;
import com.easypharma.dtos.UserDTO;
import com.easypharma.entities.Address;
import com.easypharma.entities.Product;
import com.easypharma.entities.User;
import com.easypharma.models.Response;
import com.easypharma.services.AddressService;

@CrossOrigin
@RestController
@RequestMapping("address")
public class AddressController {
	@Autowired
	private AddressService addressService;

	//To save address in database 
	@PostMapping("")
	public ResponseEntity<?> save(AddressDTO addressDto) {
		try {
			Address address = AddressDTO.toEntity(addressDto);
			address = addressService.save(address);
			return Response.success(address);
		} catch (RuntimeException e) {
			return Response.error(null);
		}
	}
	//Delete the address from database
//	@DeleteMapping("/delete/{id}")
//	public ResponseEntity<?> delete(@PathVariable("id") int id) {
//		try {
//			addressService.deleteById(id);
//			return Response.success(true);
//		} catch (RuntimeException e) {
//			return Response.error(null);
//		}
//	}
//	//get address from database 
	@GetMapping("/{id}")
	public ResponseEntity<?> findAddressById(@PathVariable("id") int id) {
		try {
			Address address = addressService.getByUserID(id);
			AddressDTO result = AddressDTO.fromEntity(address);
			return Response.success(result);
		} catch (RuntimeException e) {
			return Response.error(null);
		}
	}
	//update address 
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, AddressDTO addressDto) {
		try {
			addressDto.setAddressId(id);
			Address address = AddressDTO.toEntity(addressDto);
			Address newAddress = addressService.update(address);
			return Response.success(newAddress);
		} catch (RuntimeException e) {
			return Response.error(null);
		}

	}

}
