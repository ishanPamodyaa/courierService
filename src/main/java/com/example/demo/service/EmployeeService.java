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
	
	public void saveEmployee(EmployeeDto employeeDto) {
		
		Employee emp =new Employee();

		emp.role=employeeDto.role;
		emp.active=employeeDto.active;
		emp.contactNo=employeeDto.contactNo;
		emp.liveLocation=employeeDto.liveLocation;
		emp.nic=employeeDto.nic;
		
				
		employeeRepository.save(emp);
	}
	
	
	public EmployeeDto addEmployeeToBranch(int id ,EmployeeDto employeeDto ){
		
		Optional<Branch> branchID =branchRepository.findById(id);
		
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
			
			employeeRepository.save(emp);}
		else {return null;}
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
