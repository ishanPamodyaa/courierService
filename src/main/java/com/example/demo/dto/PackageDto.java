package com.example.demo.dto;

import com.example.demo.entity.Branch;
import com.example.demo.entity.Cstomer;
import com.example.demo.entity.PackageHistory;
import com.example.demo.entity.PackageStatus;
import com.example.demo.entity.Poter;

public class PackageDto {
	
	public int id ;
	public String date;
	public String weight;
	public String addressToSend;
	public String fee;
	public String transpoter;
	public String startBranchHandler;
	public String endchBranchHandler;
	public String history;
	
	
	 public Poter poter;
	 public Cstomer sender;
	 public Cstomer receiver;
	 public Branch endBranch;
	 public Branch startBranch;
	 public PackageStatus packageStatus;
	 public PackageHistory packagehistory;
	 
	 
	 
	
	//public Package pack;

}
