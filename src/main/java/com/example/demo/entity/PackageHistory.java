package com.example.demo.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class PackageHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	public String packageHistry;
	
	@OneToMany(mappedBy="packagehistory",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public Set <Package> packHistory;
	
	

}
