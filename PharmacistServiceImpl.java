package com.easypharma.services;
  
  import java.util.List;
  
  import org.springframework.beans.factory.annotation.Autowired; 
  import org.springframework.security.crypto.password.PasswordEncoder; 
  import org.springframework.stereotype.Service;
  import org.springframework.transaction.annotation.Transactional;

import com.easypharma.daos.PharmacistDao;
import com.easypharma.entities.Pharmacist;
  
	@Transactional

	@Service
	public class PharmacistServiceImpl implements PharmacistService {

		@Autowired
		private PharmacistDao pharmacistdao;

		@Autowired
		private PasswordEncoder passwordEncode;

		@Override
		public Pharmacist save(Pharmacist pharmacist) {
			String encPassword = passwordEncode.encode(pharmacist.getPassword());
			pharmacist.setPassword(encPassword);
			return pharmacistdao.save(pharmacist);

		}

		@Override
		public List<Pharmacist> findAll() {
			return pharmacistdao.findAll();
		}
  
	@Override
	public boolean deleteById(int id) {
		if (pharmacistdao.existsById(id)) {
			pharmacistdao.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Pharmacist authenticate(String email, String password) {
		Pharmacist pharmacist = pharmacistdao.findByEmail(email);
		System.out.println(pharmacist);
		System.out.println(passwordEncode.matches(password, pharmacist.getPassword()));
		if (pharmacist != null && passwordEncode.matches(password, pharmacist.getPassword())) {
			System.out.println(passwordEncode.matches(password, pharmacist.getPassword()));
			return pharmacist;

		}
		return null;
	}
	
	@Override
	public Pharmacist findByEmail(String email) {
		return pharmacistdao.findByEmail(email);
	}

	@Override
	public Pharmacist changePassword(String email,String password, String newPassword) {
		Pharmacist pharmacist = findByEmail(email);
		  System.out.println("servixe:"+pharmacist+" pass "+password+" "+newPassword);
	       if ( pharmacist!= null && passwordEncode.matches (password,pharmacist.getPassword())){
	    	   System.out.println("Hello");
	           String encPass =  passwordEncode.encode(newPassword);
	          pharmacist.setPassword(encPass);
	           System.out.println("service method :"+pharmacist);
	           return pharmacistdao.save(pharmacist);
	       }
	       return null;
	}
	
	@Override
	public Integer pharmacistCount() {
		return pharmacistdao.pharmacistCount();
	}

}