package com.example.demo.dto;

import java.util.Set;

import com.example.demo.entity.Branch;
import com.example.demo.entity.BranchAddress;

public class BranchDto {
	public	Integer id;
	public String name;
	public	String city;
	public	int contactNo;
	public BranchAddress branchAddress;
	
	public Set <EmployeeDto> employee;
	public Set<PoterDto> poter;
	
	


}
