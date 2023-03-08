package com.easypharma.services;

import java.util.List;

import com.easypharma.entities.ContactUs;

public interface ContactUsService {
	
	ContactUs save(ContactUs contactus);
	List<ContactUs> findAll();
	boolean deleteById(int id);

}
