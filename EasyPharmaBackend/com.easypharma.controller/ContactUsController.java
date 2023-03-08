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

import com.easypharma.dtos.ContactUsDTO;
import com.easypharma.entities.ContactUs;
import com.easypharma.models.Response;
import com.easypharma.services.ContactUsService;

@CrossOrigin
@RestController
@RequestMapping("")
public class ContactUsController {

	@Autowired
	private ContactUsService contactService;
	//save or add information in database
	@PostMapping("/contactus")
	public ResponseEntity<?> saveFeedback(ContactUsDTO contactdto) {
		try {
			ContactUs contactus = ContactUsDTO.toEntity(contactdto);
			ContactUs feedback = contactService.save(contactus);
			contactdto = ContactUsDTO.fromEntity(feedback);
			return Response.success(contactdto);
		} catch (RuntimeException e) {
			return Response.error(null);
		}
	}
	//get data from database to display on front end
	@GetMapping("/contactus")
	public ResponseEntity<?> getAll() {
		try {
			List<ContactUs> list = contactService.findAll();
			List<ContactUsDTO> result = new ArrayList<>();
			for (ContactUs contactus : list)
				result.add(ContactUsDTO.fromEntity(contactus));
			return Response.success(result);
		} catch (RuntimeException e) {
			return Response.error(null);
		}
	}
	//delete contacted message from database 
	@DeleteMapping("/contactus/{id}")
	public ResponseEntity<?> deletefeedback(@PathVariable("id") int id) {
		try {
			contactService.deleteById(id);
			return Response.success(true);
		} catch (RuntimeException e) {
			return Response.error(null);
		}
	}
}