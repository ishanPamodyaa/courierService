package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.PoterDto;
import com.example.demo.entity.Branch;
import com.example.demo.entity.Poter;
import com.example.demo.repository.BranchRepository;
import com.example.demo.repository.PoterRepository;


@Service
public class PoterService {
	@Autowired
	BranchRepository branchRepository;
	
	@Autowired
	PoterRepository poterRepository;
	
	
	
	
	
	public PoterDto addPoterToBranch(int id,PoterDto poterDto) {
	
		Optional< Branch> branchID = branchRepository.findById(id);
	
	if (branchID.isPresent()==false) {
		return null;
	}	
	
	Branch bId=branchID.get();
	
	if (poterDto != null) {
		
		Poter pot = new Poter();
		
		pot.name=poterDto.name;
		pot.active=	poterDto.active;
		pot.contactNo=poterDto.contactNo;
		pot.liveLocation=poterDto.liveLocation;
		pot.nic=poterDto.nic;
		pot.branch=bId;
		
		poterRepository.save(pot);
		
	}
	else {return null;}
		
		return poterDto;
	}
	

}
