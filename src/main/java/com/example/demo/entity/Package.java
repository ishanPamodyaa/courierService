package com.example.demo.entity;

import org.springframework.data.domain.AfterDomainEventPublication;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Package {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id ;
	public String date;
	public String weight;
	public String addressToSend;
	public String fee;
	
	public String transpoter;
	public String startBranchHandler;
	public String endchBranchHandler;
	public String history;
		
   @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
   @JoinColumn(nullable =true )
   public Poter poter;
   
   @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
   @JoinColumn(nullable =true )
   public Cstomer sender;
      
   @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
   @JoinColumn(nullable =true )
   public Cstomer receiver;
   
   @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
   @JoinColumn(nullable =true )
   public Branch endBranch;
   
   @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
   @JoinColumn(nullable =true )
   public Branch startBranch;
   
   @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
   @JoinColumn(nullable = true )
   public PackageStatus packageStatus;

   @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
   @JoinColumn(nullable = true)
   public PackageHistory packagehistory;
   
}
