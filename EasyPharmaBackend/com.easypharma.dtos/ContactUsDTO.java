package com.easypharma.dtos;



import org.springframework.beans.BeanUtils;

import com.easypharma.entities.ContactUs;

public class ContactUsDTO {
	private int id;
	private String name;
	private String email;
	private String subject;
	private String message;
	
	public ContactUsDTO() {
	}

	public ContactUsDTO(int id, String name, String email, String subject, String message) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ContactUs [id=" + id + ", name=" + name + ", email=" + email + ", subject=" + subject
				+ ", message=" + message + "]";
	}
	
	public static ContactUsDTO fromEntity(ContactUs contactus) {
		ContactUsDTO contactdto = new ContactUsDTO();
		BeanUtils.copyProperties(contactus, contactdto);
		return contactdto;
	}
	
	public static ContactUs toEntity(ContactUsDTO contactdto) {
		ContactUs contactus = new ContactUs();
		BeanUtils.copyProperties(contactdto, contactus);
		return contactus;
	}
}