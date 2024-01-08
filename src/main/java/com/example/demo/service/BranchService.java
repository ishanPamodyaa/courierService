package com.example.demo.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BranchDto;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.dto.PoterDto;
import com.example.demo.entity.Branch;
import com.example.demo.entity.BranchAddress;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Poter;
import com.example.demo.repository.BranchRepository;

@Service
public class BranchService {
	
	@Autowired
	BranchRepository branchRepository ;
	
	public BranchDto saveBranch(BranchDto branchDto) {
		Branch objBranch = new Branch();
		
		objBranch.name=branchDto.name;
		objBranch.city=branchDto.city;
		objBranch.contactNo=branchDto.contactNo;
		objBranch.branchAddress=branchDto.branchAddress;
		
		Branch branch = branchRepository.save(objBranch);
		
		branchDto.id = branch.id;
		return branchDto;				
	}
	
	public BranchDto getBranch(int id) {
		
		Optional<Branch> brnch =branchRepository.findById(id);
		
		if(brnch.isPresent()==false) {
			return null;
		}
		  Branch brId = brnch.get();		
		
			Branch entity = brId;
			
			if(entity==null) {
				return null;	
			}
			BranchDto brnchDto = new BranchDto();
			
			brnchDto.branchAddress=entity.branchAddress;
			brnchDto.city=entity.city;
			brnchDto.contactNo=entity.contactNo;
			brnchDto.name=entity.name;
			
			Set<EmployeeDto> employeeData =new HashSet<>();
			for(Employee emp:entity.employees) {
				
				EmployeeDto empDto = new EmployeeDto();
				
				empDto.active=emp.active;
				empDto.contactNo=emp.contactNo;
				empDto.id=emp.id;
				empDto.liveLocation=emp.liveLocation;
				empDto.nic=emp.nic;
				empDto.role=emp.role;
				
				employeeData.add(empDto);
				
			}
			
			Set<PoterDto> poterData =new HashSet<>();
			for(Poter pot:entity.poters) {
				
				PoterDto potDto = new PoterDto();
				
				potDto.active=pot.active;
				potDto.contactNo=pot.contactNo;
				potDto.id=pot.id;
				potDto.liveLocation=pot.liveLocation;
				potDto.name=pot.name;
				potDto.nic=pot.nic;
				
				poterData.add(potDto);
				
			}
			
			brnchDto.poter=poterData;
			
			brnchDto.employee=employeeData;
			return brnchDto;
		}
	
	public BranchDto updateBranch(int id , BranchDto branchDto) {
		
		Optional<Branch> branchID = branchRepository.findById(id);
		
		if(branchID.isPresent()==false) {
			return null;
		}
		
		Branch branchObj = branchID.get();
		
		branchObj.city=branchDto.city;
		branchObj.contactNo=branchDto.contactNo;
		branchObj.name=branchDto.name;
		branchObj.branchAddress=branchDto.branchAddress;
		
		Branch branch = branchRepository.save(branchObj);
		branchDto.id=branch.id;
		
		return branchDto;
		
	}
}
