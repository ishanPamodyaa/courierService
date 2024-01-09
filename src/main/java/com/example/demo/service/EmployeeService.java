package com.example.demo.service;


import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BranchDto;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Branch;
import com.example.demo.entity.Employee;
import com.example.demo.repository.BranchRepository;
import com.example.demo.repository.EmployeeRepository;
//import com.example.demo.repository.employeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository ; 
	
	@Autowired
	BranchRepository branchRepository;
	
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		//int id =employeeDto.branch_id;
		
		
		Optional<Branch> branchID =branchRepository.findById(employeeDto.branchDto.id);
		if (branchID.isPresent()==false) {
			return null;
		}
		Branch bID=branchID.get();
		
		if(employeeDto!=null) {
			
			Employee emp = new Employee();
			
			emp.role=employeeDto.role;
			emp.active=employeeDto.active;
			emp.contactNo=employeeDto.contactNo;
			emp.liveLocation=employeeDto.liveLocation;
			emp.nic=employeeDto.nic;
			emp.branch=bID;
		 
			
			Employee empObj =employeeRepository.save(emp);
			employeeDto.id=empObj.id;
			return employeeDto;	
		}
		else {return null;}
		
	}
		

	
	public EmployeeDto updateEmployee(int id ,EmployeeDto employeeDto ){
		
		Optional<Employee> employeeID =employeeRepository.findById(id);
		
		if (employeeID.isPresent()==false) {
			return null;
		}
		Employee bID=employeeID.get();
		
			bID.role=employeeDto.role;
			bID.active=employeeDto.active;
			bID.contactNo=employeeDto.contactNo;
			bID.liveLocation=employeeDto.liveLocation;
			bID.nic=employeeDto.nic;
		
			
		Employee empObj = employeeRepository.save(bID);
		employeeDto.id=empObj.id;
		return employeeDto ;
	}
		
		public EmployeeDto getEmployee(int id) {
			
		Optional<Employee> emp =employeeRepository.findById(id);
		
		if(emp.isPresent()==false) {
			return null;
		}
		  Employee empId = emp.get();		
			return EmployeeDto.fromEntity(empId);
			
		}
		

	    
	
	

}
