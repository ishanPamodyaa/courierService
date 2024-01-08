package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Poter {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	public int id;
	public String name;
	public String contactNo;
	public int nic;
	public String liveLocation;
	public String active;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn( nullable = false)
	public Branch branch;	
	
	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn()
	public Vehicle vehicles;

	@OneToMany(mappedBy = "poter", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	public Set <Package> packages;
}
