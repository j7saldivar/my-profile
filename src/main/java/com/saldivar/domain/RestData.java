package com.saldivar.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RestData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(length=50)
	private String firstName;
	
	@Column(length=50)
	private String lastName;
	
	@Column(length=50)
	private String email;
	
	@Column(length=10)
	private String gender;
	
	@Column(length=20)
	private String ipAddress;
	
}
