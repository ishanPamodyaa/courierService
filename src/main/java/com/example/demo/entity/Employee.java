package com.example.demo.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)	
    public int id;
	public String role;
	public String vehicleNo;
	public int contactNo;
	public int nic;
	public String liveLocation;
	public String active;
	//public Set<Branch> branchIn;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
	public Branch branch;
 

}
