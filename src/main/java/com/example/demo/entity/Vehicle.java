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
//import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Vehicle {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)	
	public  int id;
	public String vehivleNo;
	public String licenceDate;
	public String type;
	public String lastOilChange;
	
	@OneToOne(mappedBy="vehicles",fetch = FetchType.EAGER , cascade = CascadeType.ALL )
	public Poter poters;
	
	

}
