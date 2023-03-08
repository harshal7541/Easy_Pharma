package com.easypharma.dtos;

import org.springframework.beans.BeanUtils;

import com.easypharma.entities.Pharmacist;

public class PharmacistDTO {
	
	
	private int pharmacistId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String mobileNumber;
	private String licenseNumber;
	private int pincode;
	
	
	
	
	
	
	public PharmacistDTO() {
		super();
	}

	public PharmacistDTO(int pharmacistId, String firstName, String lastName, String email, String password,
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
		return "PharmacistDTO [pharmacistId=" + pharmacistId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", password=" + password + ", mobileNumber=" + mobileNumber + ", licenseNumber="
				+ licenseNumber + ", pincode=" + pincode + "]";
	}

	public static PharmacistDTO fromEntity(Pharmacist pharmacist) {
		PharmacistDTO dto=new PharmacistDTO();
		BeanUtils.copyProperties(pharmacist, dto);
		return dto;
	}

	public static Pharmacist toEntity(PharmacistDTO dto) {
		Pharmacist pharmacist = new Pharmacist();
		BeanUtils.copyProperties(dto, pharmacist);
		return pharmacist;
	}
}
