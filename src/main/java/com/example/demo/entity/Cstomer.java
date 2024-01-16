package com.example.demo.entity;

import java.util.Set;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Cstomer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;
//	public String ;
	public String firstName;
	public String lastName;
	public String contactNo;
	public String nic;
	
	@OneToMany( mappedBy = "sender",cascade =  CascadeType.ALL,fetch = FetchType.EAGER)
	public Set <Package> packaeS;
	
	@OneToMany( mappedBy = "receiver", cascade =  CascadeType.ALL,fetch = FetchType.EAGER)
	public Set <Package> packaeR;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(nullable = false)
	public Address address;
	
		
	
}
