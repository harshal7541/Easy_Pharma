package com.easypharma.daos;



import org.springframework.data.jpa.repository.JpaRepository;

import com.easypharma.entities.Address;




public interface AddressDao  extends JpaRepository<Address, Integer>{

	
	Address getByUserId(int id);
}
