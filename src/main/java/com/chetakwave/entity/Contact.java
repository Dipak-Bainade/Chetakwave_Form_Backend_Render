package com.chetakwave.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="contact_enquiries")
@Data
public class Contact {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String fullName;
	
	private String email;
	
	private String phoneNumber;
	
	private String serviceRequired;
	
	@Column(length=2000)
	private String projectDetails;
	
	private LocalDate enquiryDate;
	

}
