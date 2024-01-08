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
public class PackageStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO  )
	public int id;
	public String discription;
	
	@OneToMany(mappedBy ="packageStatus",cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
	public Set <Package> packStatus;
	
}
