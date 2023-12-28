package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BranchAddress {
	
  	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)		
	 public int id;
   // public String address;
     public String line1;
     public String line2;
     public String googleAddress;

}
