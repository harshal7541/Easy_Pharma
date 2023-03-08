package com.easypharma.dtos;

import org.springframework.beans.BeanUtils;

import com.easypharma.entities.Address;


public class AddressDTO {
	private int addressId;
	private String street;
	private String city;
	private int pincode;
	private String state;
	private int houseNumber;
	private int userId;
	
	public AddressDTO()
	{
		
	}

	public AddressDTO(int addressId, String street, String city, int pincode, String state, int houseNumber,
			int userId) {
		super();
		this.addressId = addressId;
		this.street = street;
		this.city = city;
		this.pincode = pincode;
		this.state = state;
		this.houseNumber = houseNumber;
		this.userId = userId;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "AddressDTO [addressId=" + addressId + ", street=" + street + ", city=" + city + ", pincode=" + pincode
				+ ", state=" + state + ", houseNumber=" + houseNumber + ", userId=" + userId + "]";
	}
	
	public static Address toEntity(AddressDTO dto) {
	Address address= new Address();
		BeanUtils.copyProperties(dto, address );
		return address;
	}
	
	public static AddressDTO fromEntity(Address address) {
		AddressDTO dto = new AddressDTO();
		BeanUtils.copyProperties(address, dto);
		return dto;
	}

}