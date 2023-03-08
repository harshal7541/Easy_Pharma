package com.easypharma.services;

import com.easypharma.entities.Address;

public interface AddressService {
	
	Address save(Address address);
	Address getByUserID(int id);
	void deleteById(int id);
	Address update(Address address);

}

