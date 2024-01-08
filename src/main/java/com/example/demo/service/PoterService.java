package com.example.demo.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BranchDto;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.dto.PoterDto;
import com.example.demo.entity.Branch;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Poter;
import com.example.demo.repository.BranchRepository;
import com.example.demo.repository.PoterRepository;


@Service
public class PoterService {
	@Autowired
	BranchRepository branchRepository;	
	@Autowired
	PoterRepository poterRepository;	
	public PoterDto savePoter(PoterDto poterDto) {	
		Optional<Branch> branchID =branchRepository.findById(poterDto.branch.id);
		if (branchID.isPresent()==false) {
			return null;
		}
		Branch bID=branchID.get();	
		if(poterDto!=null) {
			
			Poter pot = new Poter();			
			pot.active=poterDto.active;
			pot.contactNo=poterDto.contactNo;
			pot.liveLocation=poterDto.liveLocation;
			pot.nic=poterDto.nic;
			pot.name=poterDto.name;
			pot.vehicles=poterDto.vehicle;
			pot.branch=bID;
			
			Poter potObj =poterRepository.save(pot);
			poterDto.id=potObj.id;
			return poterDto;	
		}
		else {return null;}
		
	}
	
	
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
	
public PoterDto getPoter(int id) {
		
		Optional<Poter> poter =poterRepository.findById(id);
		
		if(poter.isPresent()==false) {
			return null;
		}
		  Poter pot = poter.get();		
		
			Poter entity = pot;
			
			if(entity==null) {
				return null;	
			}				
				PoterDto potDto = new PoterDto();
				
				potDto.active=entity.active;
				potDto.contactNo=entity.contactNo;
				potDto.id=entity.id;
				potDto.liveLocation=entity.liveLocation;
				potDto.name=entity.name;
				potDto.nic=entity.nic;
				
				if(entity.branch != null) {
			
					Branch branch = entity.branch;
					
					BranchDto bDto = new  BranchDto();
					
					bDto.branchAddress=branch.branchAddress;
					bDto.city = branch.city;
					bDto.contactNo=branch.contactNo;
					bDto.name=branch.name;
					bDto.id=branch.id;
					
				
					potDto.branch=bDto;
			
				}				
			return potDto;
		}

public PoterDto updatePoter(int id,PoterDto poterDto) {
	Optional<Poter> poterID = poterRepository.findById(id);
	
	
	if(poterID.isPresent()==false) {
		return null;		
	}
	
	Poter poter = poterID.get();
	
	poter.active=poterDto.active;
	poter.contactNo=poterDto.contactNo;
	poter.liveLocation=poterDto.liveLocation;
	poter.name=poterDto.name;
	poter.nic=poterDto.nic;
	
	
	
	
	Poter pot =poterRepository.save(poter);
	
	poterDto.id=poter.id;
	return poterDto;
	
}



}
