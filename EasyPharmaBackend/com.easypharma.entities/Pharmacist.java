package com.easypharma.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pharmacist")
public class Pharmacist {
	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "pharmacist_id")
	private int pharmacistId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	private String email;
	
	private String password;
	
	@Column(name = "mobile_no")
	private String mobileNumber;
	
	@Column(name="license_no")
	private String licenseNumber;
	
	private int pincode;
	
	

	public Pharmacist() {
		super();
	}



	public Pharmacist(int pharmacistId, String firstName, String lastName, String email, String password,
			String mobileNumber, String licenseNumber, int pincode) {
		super();
		this.pharmacistId = pharmacistId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.licenseNumber = licenseNumber;
		this.pincode = pincode;
	}



	public int getPharmacistId() {
		return pharmacistId;
	}



	public void setPharmacistId(int pharmacistId) {
		this.pharmacistId = pharmacistId;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getMobileNumber() {
		return mobileNumber;
	}



	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}



	public String getLicenseNumber() {
		return licenseNumber;
	}



	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}



	public int getPincode() {
		return pincode;
	}



	public void setPincode(int pincode) {
		this.pincode = pincode;
	}



	@Override
	public String toString() {
		return "Pharmacist [pharmacistId=" + pharmacistId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", password=" + password + ", mobileNumber=" + mobileNumber + ", licenseNumber="
				+ licenseNumber + ", pincode=" + pincode + "]";
	}

	

}