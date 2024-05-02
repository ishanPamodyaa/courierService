package com.example.demo.service;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
	
	
	public PackageDto commonSaveOrUpdate(PackageDto packageDto ,Package packageEntity ) {

        Optional<Poter> poterEntity =(packageDto.poterDto != null && packageDto.poterDto.id != null) ? poterRepository.findById(packageDto.poterDto.id): Optional.empty();	
        
		Optional<Cstomer> customerReceiverEntity =(packageDto.receiverDto != null && packageDto.receiverDto.id != null) ? customerRepository.findById(packageDto.receiverDto.id): Optional.empty();
		
		Optional<Cstomer> customerSenderEntity =(packageDto.senderDto != null && packageDto.senderDto.id != null) ? customerRepository.findById(packageDto.senderDto.id): Optional.empty();
		
		Optional<Branch> branchStaterEntity =(packageDto.startBranchDto != null && packageDto.startBranchDto.id != null) ? branchRepository.findById(packageDto.startBranchDto.id): Optional.empty();
		
		Optional<Branch> branchEndEntity =(packageDto.endBranchDto != null && packageDto.endBranchDto.id != null) ? branchRepository.findById(packageDto.endBranchDto.id): Optional.empty();
		
		Optional<PackageHistory> packagehistoryEntity =(packageDto.packagehistoryDto != null && packageDto.packagehistoryDto.id != null) ? packageHistoryRepository.findById(packageDto.packagehistoryDto.id): Optional.empty();
		
		Optional<PackageStatus> packageStatusEntity =(packageDto.packageStatusDto != null && packageDto.packageStatusDto.id != null) ?packageStatusRepository.findById(packageDto.packageStatusDto.id): Optional.empty();
			
		packageEntity.date=packageDto.date;
		packageEntity.fee= packageDto.fee;
		packageEntity.weight=packageDto.weight;
		packageEntity.addressToSend=packageDto.addressToSend;	
		
		packageEntity.startBranchHandler=packageDto.startBranchHandler;
		packageEntity.endchBranchHandler=packageDto.endchBranchHandler;
		packageEntity.history=packageDto.history;
		
		
		packageEntity.poter=poterEntity.orElse(null);
		packageEntity.receiver=customerReceiverEntity.orElse(null);
		packageEntity.sender=customerSenderEntity.orElse(null);
		packageEntity.startBranch=branchStaterEntity.orElse(null);
		packageEntity.endBranch=branchEndEntity.orElse(null);
		packageEntity.packageStatus=packageStatusEntity.orElse(null);
		packageEntity.packagehistory=packagehistoryEntity.orElse(null);
				
		Package packageR = packageRepository.save(packageEntity);
		packageDto.id=packageR.id;
		return packageDto;
			
	}
	
	
	
	public PackageDto savePackage(PackageDto packageDto) {
		
		Package packageEntity = new Package();
		 commonSaveOrUpdate(packageDto, packageEntity);
	    
	    
	    return packageDto;
	}
	
	public PackageDto updatePackage(int id , PackageDto packageDto) {
		
		 Optional<Package> packageId =packageRepository.findById(id);
		
		if(packageId.isPresent()==false) {
			return null;
		}
		
		Package packageEntity = packageId.get();
		commonSaveOrUpdate(packageDto, packageEntity);
		
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
	
	
	public boolean deletePackage(int id) {
		
		 Optional<Package> packageEntity = packageRepository.findById(id);
		
		 if(packageEntity.isPresent()==true) {			
			 packageRepository.deleteById(id);
			return true; 			 
		 }else		 
		 return false;		
	}
	
	public List	<Package> findPageAndSortPackage(int page,int size){
		
		Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC,"date"));
		Page <Package> pagedResponse = packageRepository.findAll(pageable);
		
		System.out.println("Total Number Of page :: " + pagedResponse.getTotalPages());
		List<Package> allPackages= pagedResponse.getContent();
		
		return allPackages;
	}
	
	public List	<Package> findPagedPackage(int page,int size){
		
		Pageable pageable = PageRequest.of(page, size);
		Page <Package> pagedResponse = packageRepository.findAll(pageable);
		
		System.out.println("Total Number Of page :: " + pagedResponse.getTotalPages());
		List<Package> allPackages= pagedResponse.getContent();
		
		return allPackages;
	}
		
	}


