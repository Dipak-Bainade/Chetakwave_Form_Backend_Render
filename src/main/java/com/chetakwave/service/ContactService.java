package com.chetakwave.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chetakwave.entity.Contact;
import com.chetakwave.repository.ContactRepository;

@Service
public class ContactService {

	@Autowired
	private ContactRepository repository;
	
	   public Contact saveContact(Contact contact) {
	        return repository.save(contact);
	    }
	
	
}
