package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CustomerDto;
import com.example.demo.dto.PackageDto;
import com.example.demo.dto.PackageHistoryDto;
import com.example.demo.dto.PackageStatusDto;
import com.example.demo.entity.Branch;
import com.example.demo.entity.Cstomer;
import com.example.demo.entity.Package;
import com.example.demo.entity.PackageHistory;
import com.example.demo.entity.PackageStatus;
import com.example.demo.entity.Poter;
import com.example.demo.repository.BranchAddressRepo;
import com.example.demo.repository.BranchRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.PackageHistoryRepository;
import com.example.demo.repository.PackageRepository;
import com.example.demo.repository.PackageStatusRepository;
import com.example.demo.repository.PoterRepository;

import ch.qos.logback.core.net.SyslogOutputStream;

@Service
public class PackageService {
	
	@Autowired
	PackageRepository packageRepository;
	@Autowired
	BranchRepository branchRepository;
	@Autowired
	PoterRepository poterRepository;
	@Autowired
	BranchAddressRepo branchAddressRepo;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	PackageHistoryRepository packageHistoryRepository;
	@Autowired
	PackageStatusRepository packageStatusRepository; 
	
	
	
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
	
	
	public PackageService(PackageRepository packageRepository) {
		
	this.packageRepository=packageRepository;
				
		    long packageCount=packageRepository.count();	
		    
	if(packageCount != 0){
		System.out.println("Data Is Hear ");}
		else {
			System.out.println("Data Is not Hear ");	
		}
		
		
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
		
		Optional<Poter> poterEntity =poterRepository.findById(packageDto.poterDto.id);
		if(poterEntity.isPresent()==false) {return null; }
		
		Optional<Cstomer> customerReceiverEntity =customerRepository.findById(packageDto.receiverDto.id);
		if(customerReceiverEntity.isPresent()==false) {return null; }
		
		Optional<Cstomer> customerSenderEntity =customerRepository.findById(packageDto.senderDto.id);
		if(customerSenderEntity.isPresent()==false) {return null; }
		
		Optional<Branch> branchStaterEntity =branchRepository.findById(packageDto.startBranchDto.id);
		if(branchStaterEntity.isPresent()==false) {return null; }
		
		Optional<Branch> branchEndEntity =branchRepository.findById(packageDto.endBranchDto.id);
		//if(branchEndEntity.isPresent()==false) {return null; }
		
		Optional<PackageHistory> packagehistoryEntity =packageHistoryRepository.findById(packageDto.packagehistoryDto.id);
		
		
		Optional<PackageStatus> packageStatusEntity =packageStatusRepository.findById(packageDto.packageStatusDto.id);
	//	if(packageStatusEntity.isPresent()==false) {return null; }
		
		packageEntity.date=packageDto.date;
		packageEntity.fee= packageDto.fee;
		packageEntity.weight=packageDto.weight;
		//packageEntity.transpoter=packageDto.transpoter;
		packageEntity.startBranchHandler=packageDto.startBranchHandler;
		packageEntity.endchBranchHandler=packageDto.endchBranchHandler;
		packageEntity.addressToSend=packageDto.addressToSend;
		packageEntity.history=packageDto.history;
		
		packageEntity.poter=poterEntity.get();
		packageEntity.receiver=customerReceiverEntity.get();
		packageEntity.sender=customerSenderEntity.get();
		packageEntity.startBranch=branchStaterEntity.get();
		packageEntity.endBranch=branchEndEntity.get();
		packageEntity.packageStatus=packageStatusEntity.get();
		packageEntity.packagehistory=packagehistoryEntity.get();
		
		
		//packageDto.id=pack.id;
		
		
		Package packageR = packageRepository.save(packageEntity);
		packageDto.id=packageR.id;
		
		return packageDto;
		
	}
	
	
	
	public boolean deletePackage(int id) {
		
		 Optional<Package> packageEntity = packageRepository.findById(id);
		
		 if(packageEntity.isPresent()==true) {			
			 packageRepository.deleteById(id);
			return true; 			 
		 }else		 
		 return false;		
	}
	
		
		
		
	}


