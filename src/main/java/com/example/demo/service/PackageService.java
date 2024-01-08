package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CustomerDto;
import com.example.demo.dto.PackageDto;
import com.example.demo.entity.Cstomer;
import com.example.demo.entity.Package;
import com.example.demo.repository.PackageRepository;

@Service
public class PackageService {
	
	@Autowired
	PackageRepository packageRepository;
	
	public PackageDto savePackage(PackageDto packageDto) {
		
		//Package pack = new Package(); 
		Package pack =new Package();
		pack.date=packageDto.date;
		pack.weight=packageDto.weight;
	    pack.addressToSend=packageDto.addressToSend;
		pack.fee=packageDto.fee;
		
		
		Package packL= packageRepository.save(pack);
		
		packageDto.id=packL.id;
		
		return packageDto;
		
	}
	
	
	public PackageDto getPackage(int id) {
		
     Optional<Package> packageId =packageRepository.findById(id);
		
		if(packageId.isPresent()==false) {
			return null;
		}
		Package pack = packageId.get();		
		
			//Branch entity = brId;
			
			if(pack==null) {
				return null;	
			}
			PackageDto packageDto = new PackageDto();
			
			packageDto.date=pack.date;
			packageDto.fee= pack.fee;
			packageDto.weight=pack.weight;
			packageDto.transpoter=pack.transpoter;
			packageDto.startBranchHandler=pack.startBranchHandler;
			packageDto.endchBranchHandler=pack.endchBranchHandler;
			packageDto.addressToSend=pack.addressToSend;
			packageDto.history=pack.history;
			packageDto.id=pack.id;
			
			return packageDto;
		}
	
	public PackageDto updatePackage(int id , PackageDto packageDto) {
		
		 Optional<Package> packageId =packageRepository.findById(id);
		
		if(packageId.isPresent()==false) {
			return null;
		}
		
		Package packageEntity = packageId.get();
		
		packageEntity.date=packageDto.date;
		packageEntity.fee= packageDto.fee;
		packageEntity.weight=packageDto.weight;
		packageEntity.transpoter=packageDto.transpoter;
		packageEntity.startBranchHandler=packageDto.startBranchHandler;
		packageEntity.endchBranchHandler=packageDto.endchBranchHandler;
		packageEntity.addressToSend=packageDto.addressToSend;
		packageEntity.history=packageDto.history;
		//packageDto.id=pack.id;
		
		
		Package packageR = packageRepository.save(packageEntity);
		packageDto.id=packageR.id;
		
		return packageDto;
		
	}
	
		
		
		
	}


