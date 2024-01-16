package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.common.PackageStatusEnum;
import com.example.demo.dto.PackageHistoryDto;
import com.example.demo.dto.PackageStatusDto;
import com.example.demo.entity.Package;
import com.example.demo.entity.PackageHistory;
import com.example.demo.entity.PackageStatus;
import com.example.demo.repository.PackageRepository;
import com.example.demo.repository.PackageStatusRepository;

import ch.qos.logback.core.net.SyslogOutputStream;

@Service
public class PackageStatusService {
	
	@Autowired
	PackageStatusRepository packageStatusRepository;
	
	
	public PackageStatusService(PackageStatusRepository packageStatusRepository) {
		
	this.packageStatusRepository=packageStatusRepository;
				
		    long packageCount=packageStatusRepository.count();	
		    
	if(packageCount != 0){
		System.out.println("Data Is Hear ");}
		else {
	
			PackageStatusEnum ar[] = PackageStatusEnum.values();
			
			
			for(PackageStatusEnum val: ar) {
				
				System.out.println(val);
				PackageStatus packageStatus = new PackageStatus();
				
				packageStatus.id=val.ordinal();
				packageStatus.discription=val.name();
				packageStatus.type=val;
				packageStatusRepository.save(packageStatus);
						
			}			
		}		
	}   	    	    
	
	
	
	
	
	
	public PackageStatusDto savePackageStatus (PackageStatusDto packageStatusDto) {
		
		PackageStatus packStatus = new PackageStatus();
		
		packStatus.discription=packageStatusDto.discription;
		
		PackageStatus obj = packageStatusRepository.save(packStatus);
		
		packageStatusDto.id= obj.id;
		
		return packageStatusDto;
		
	}

	public PackageStatusDto getPackageStatus(int id) {
		
			Optional<PackageStatus> packageStatusID =packageStatusRepository.findById(id);
			
			if(packageStatusID.isPresent()==false) {
				return null;
			}
			PackageStatus packageStatus = packageStatusID.get();		
			
			PackageStatus entity = packageStatus;
				
				if(entity==null) {
					return null;	
				}
				PackageStatusDto packageStatusyDto = new PackageStatusDto();
				
				packageStatusyDto.discription=entity.discription;
				
			
				return packageStatusyDto;
				}
	
    public PackageStatusDto updatePackageStatus(int id ,PackageStatusDto packageStatusDto ){
		
		Optional<PackageStatus> packageStatusID =packageStatusRepository.findById(id);
		
		if (packageStatusID.isPresent()==false) {
			return null;
		}
		PackageStatus packageStatus =packageStatusID.get();
		
		packageStatus.discription=packageStatusDto.discription;
			
			
		PackageStatus obj = packageStatusRepository.save(packageStatus);
		packageStatusDto.id=obj.id;
		return packageStatusDto ;
	}
	
	public boolean deletePackageStatus(int id) {
		
		 Optional<PackageStatus> packageEntity = packageStatusRepository.findById(id);
		
		 if(packageEntity.isPresent()==true) {			
			 packageStatusRepository.deleteById(id);
			return true; 			 
		 }else		 
		 return false;		
	}
	
		
	
	
	
	

}
