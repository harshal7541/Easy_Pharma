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

import com.easypharma.dtos.PharmacistDTO;
import com.easypharma.entities.Pharmacist;
import com.easypharma.models.ChangePassword;
import com.easypharma.models.Credentials;
import com.easypharma.models.Response;
import com.easypharma.services.PharmacistService;

@CrossOrigin
@RestController
@RequestMapping("")
public class PharmacistControllerImpl {
	
	@Autowired
	private PharmacistService pharmacistService;

	@PostMapping("/loginpharma")
	public ResponseEntity<?> authenticatePharmacist(Credentials cred) {
		try {
			Pharmacist pharmacist = pharmacistService.authenticate(cred.getEmail(), cred.getPassword());
			if(pharmacist!=null) {
				PharmacistDTO pharmacistDto = PharmacistDTO.fromEntity(pharmacist);
				return Response.success(pharmacistDto);
			}
			return Response.error(null);
		}catch(RuntimeException e) {
			System.out.println(e.getMessage());
			return Response.error(null);
		}

	}

	@PostMapping("/registerpharma")
	public ResponseEntity<?> savePharmacist(PharmacistDTO pharmacistDto) {
		Pharmacist pharmacist = PharmacistDTO.toEntity(pharmacistDto);
		if(pharmacist!=null) {
			Pharmacist savedpharmacist = pharmacistService.save(pharmacist);
			pharmacistDto = PharmacistDTO.fromEntity(savedpharmacist);
			return Response.success(pharmacistDto);
		}	
		return Response.error(null);
	}
	
	
    @GetMapping("/pharmacists")
	public ResponseEntity<?> findAll() {
		try {
			List<Pharmacist> list = pharmacistService.findAll();
			List<PharmacistDTO> result = new ArrayList<>();
			if(list!=null) {
				for (Pharmacist pharmacist : list)
					result.add(PharmacistDTO.fromEntity(pharmacist));
				return Response.success(result);
			}else {
				return Response.error(null);
			}
			
		}catch(RuntimeException e) {
			e.printStackTrace();
			return Response.error(null);
		}
		
	}

	@DeleteMapping("/pharmacist/{id}")
	public ResponseEntity<?> deletePharmacist(@PathVariable("id") int id) {
		try {
			pharmacistService.deleteById(id);
			return Response.success(true);
		}catch(RuntimeException e) {
			e.printStackTrace();
			return Response.error(null);
		}
	}
	
	@GetMapping("/pharmacist/{email}")
	public ResponseEntity<?> findPharmacist(@PathVariable("email") String email) {
		try {
			Pharmacist pharmacist = pharmacistService.findByEmail(email);
			if(pharmacist!=null) {
				PharmacistDTO pharmacistDTO = PharmacistDTO.fromEntity(pharmacist);
				return Response.success(pharmacistDTO);
			}
			return Response.error(null);
			
		}catch(RuntimeException e) {
			System.out.println(e.getMessage());
			return Response.error(null);
		}
	}
	
	
	@PostMapping("/resetpharma-password/{email}")
	public ResponseEntity<?> changePassword(@PathVariable("email") String email,  ChangePassword password) {			
			Pharmacist pharmacist = pharmacistService.changePassword(email, password.getPassword(), password.getNewPassword());
			if( pharmacist != null)
				return Response.success(pharmacist);
			return Response.error(null);
	}
	
	@GetMapping("/pharmacistcount")
	public ResponseEntity<?> countPharmacist(){
		Integer count = pharmacistService.pharmacistCount();
		return Response.success(count);
	}

}