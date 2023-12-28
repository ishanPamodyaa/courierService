package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;

import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Branch {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public	int id;
	public String name;
	public	String city;
	public	int contactNo;
	
	@OneToMany( mappedBy = "branch", cascade = CascadeType.ALL,fetch = FetchType.EAGER , orphanRemoval = true)
	public List <Employee> employees;
	
	@OneToMany( mappedBy = "branch", cascade = CascadeType.ALL,fetch = FetchType.EAGER , orphanRemoval = true)
	public List<Poter> poters;
	
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER , orphanRemoval = false )
	public BranchAddress branchAddress;
	
	

}
