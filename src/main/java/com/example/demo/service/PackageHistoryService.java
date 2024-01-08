package com.example.demo.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BranchDto;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.dto.PackageHistoryDto;
import com.example.demo.dto.PoterDto;
import com.example.demo.entity.Branch;
import com.example.demo.entity.Employee;
import com.example.demo.entity.PackageHistory;
import com.example.demo.entity.Poter;
import com.example.demo.repository.PackageHistoryRepository;

@Service
public class PackageHistoryService {
	@Autowired
	PackageHistoryRepository packageHistoryRepository;
	
	public PackageHistoryDto savePackageHistory (PackageHistoryDto packageHistoryDto) {
		
		PackageHistory packHistry = new PackageHistory();
		
		packHistry.packageHistry=packageHistoryDto.packageHistry;
		
		PackageHistory obj =packageHistoryRepository.save(packHistry);
		
		packageHistoryDto.id=obj.id;
		
		return packageHistoryDto;
		
		
		
	}
	
	public PackageHistoryDto getPackageHistory (int id) {
	
			Optional<PackageHistory> packageHistoryID =packageHistoryRepository.findById(id);
			
			if(packageHistoryID.isPresent()==false) {
				return null;
			}
			PackageHistory packageHistory = packageHistoryID.get();		
			
			PackageHistory entity = packageHistory;
				
				if(entity==null) {
					return null;	
				}
				PackageHistoryDto packageHistoryDto = new PackageHistoryDto();
				
				packageHistoryDto.packageHistry=entity.packageHistry;
				
			
				return packageHistoryDto;
				}
	
	
	
     public PackageHistoryDto updatePackageHistory(int id ,PackageHistoryDto packageHistoryDto ){
		
		Optional<PackageHistory> packageHistoryID =packageHistoryRepository.findById(id);
		
		if (packageHistoryID.isPresent()==false) {
			return null;
		}
		PackageHistory packageHistory =packageHistoryID.get();
		
		packageHistory.packageHistry=packageHistoryDto.packageHistry;
			
			
		PackageHistory obj = packageHistoryRepository.save(packageHistory);
		packageHistoryDto.id=obj.id;
		return packageHistoryDto ;
	}

	
}
