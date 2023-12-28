package com.example.demo.dto;

import java.util.HashSet;
import java.util.Set;

import com.example.demo.entity.Branch;
import com.example.demo.entity.Employee;

public class EmployeeDto {
	    
	    public int id;
		public String role;
		public String vehicleNo;
		public int contactNo;
		public int nic;
		public String liveLocation;
		public String active;
		public Set <BranchDto> branch;
	
		public static EmployeeDto fromEntity(Employee entity) {
			
			if(entity==null) {
				return null;
			}
			
			
			EmployeeDto empDto = new EmployeeDto();
			
			empDto.active=entity.active;
			empDto.contactNo =entity.contactNo;
			empDto.liveLocation=entity.liveLocation;
			empDto.nic=entity.nic;
			empDto.role=entity.role;
			
			
		
			Set<BranchDto> branchF = new HashSet<>();
			if(entity.branch != null) {
		
				Branch branch = entity.branch;
				
				BranchDto bDto = new  BranchDto();
				
				bDto.branchAddress=branch.branchAddress;
				bDto.city = branch.city;
				bDto.contactNo=branch.contactNo;
				bDto.name=branch.name;
				bDto.id=branch.id;
				
			
			  branchF.add(bDto);
		
			}
			
			empDto.branch=branchF;
			return empDto;
			
		}
		
	
	

}
