
package com.easypharma.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="address")
public class Address {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "address_id")
	private int addressId;
	private String street;
	private String city;
	private int pincode;
	private String state;
	@Column(name="house_no")
	private int houseNumber;
	@Column(name="user_id")
	private int userId;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_time",nullable = false,columnDefinition="default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
	private Date timestamp = new Date();
	
	public Address()
	{
		
	}

	public Address(int addressId, String street, String city, int pincode, String state, int houseNumber, int userId,
			Date timestamp) {
		super();
		this.addressId = addressId;
		this.street = street;
		this.city = city;
		this.pincode = pincode;
		this.state = state;
		this.houseNumber = houseNumber;
		this.userId = userId;
		this.timestamp = timestamp;
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

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", street=" + street + ", city=" + city + ", pincode=" + pincode
				+ ", state=" + state + ", houseNumber=" + houseNumber + ", userId=" + userId + ", timestamp="
				+ timestamp + "]";
	}
	
	
	

}
