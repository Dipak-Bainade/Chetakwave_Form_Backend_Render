package com.chetakwave.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chetakwave.entity.Contact;
import com.chetakwave.service.ContactService;

@RestController
@CrossOrigin(origins = "*")
public class ContactRestController {
	
	 @Autowired
	 private ContactService contactService;
	
	@PostMapping("/contact")
	public String createContact(@RequestBody Contact c) {
		
		c.setEnquiryDate(LocalDate.now());
		System.out.println(c);

        contactService.saveContact(c);

        return "Contact Saved Successfully";
	}

}
