package com.easypharma.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.easypharma.entities.ContactUs;

@Repository
public interface ContactUsDao extends JpaRepository<ContactUs, Integer> {

}
