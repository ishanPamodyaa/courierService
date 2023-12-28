package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BranchDto;
import com.example.demo.entity.Branch;
import com.example.demo.entity.BranchAddress;
import com.example.demo.repository.BranchRepository;

@Service
public class BranchService {
	
	@Autowired
	BranchRepository branchRepository ;
	
	public void saveBranch(BranchDto branchDto) {
		Branch objBranch = new Branch();
		
		objBranch.name=branchDto.name;
		objBranch.city=branchDto.city;
		objBranch.contactNo=branchDto.contactNo;
		objBranch.branchAddress=branchDto.branchAddress;
		
		branchRepository.save(objBranch);
		
		
	}
}
