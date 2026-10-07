package com.chetakwave.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chetakwave.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>{

}
