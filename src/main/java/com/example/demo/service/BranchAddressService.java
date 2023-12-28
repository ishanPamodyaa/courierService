package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BranchAddressDto;
import com.example.demo.entity.BranchAddress;
import com.example.demo.repository.BranchAddressRepo;

@Service
public class BranchAddressService {
	
	@Autowired
	BranchAddressRepo branchAddressRepo;
	
	public void addBranchAddress(BranchAddressDto branchAddressDto) {
		
		BranchAddress bAdd = new BranchAddress();
		
		//bAdd.address=branchAddressDto.address;
		bAdd.line1=branchAddressDto.line1;
		bAdd.line2=branchAddressDto.line2;
		bAdd.googleAddress=branchAddressDto.googleAddress;
		
		branchAddressRepo.save(bAdd);
		
		
		
	}
	
	
	

}
