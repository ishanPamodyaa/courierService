package com.example.demo.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BranchDto;
import com.example.demo.dto.CustomerDto;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.dto.PoterDto;
import com.example.demo.entity.Branch;
import com.example.demo.entity.Cstomer;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Poter;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	public CustomerDto saveCustomer (CustomerDto customerDto) {
		
		Cstomer cust = new Cstomer();
		
		
		cust.firstName=customerDto.firstName;
		cust.lastName=customerDto.lastName;
		cust.contactNo=customerDto.contactNo;
		cust.nic=customerDto.nic;
		cust.address=customerDto.address;
		
		
		Cstomer custumer = customerRepository.save(cust);
		
		customerDto.id=custumer.id;
		
		return customerDto;
		}
public CustomerDto getCustomer(int id) {
		
		Optional<Cstomer> customerId =customerRepository.findById(id);
		
		if(customerId.isPresent()==false) {
			return null;
		}
		Cstomer customer = customerId.get();		
		
			//Branch entity = brId;
			
			if(customer==null) {
				return null;	
			}
			CustomerDto customerDto = new CustomerDto();
			
			customerDto.firstName=customer.firstName;				
		    customerDto.lastName=customer.lastName;
			customerDto.nic=customer.nic;
			customerDto.contactNo=customer.contactNo;
			customerDto.address=customer.address;
	
			customerDto.id=customer.id;
			
			return customerDto;
		}
	
	public CustomerDto updateCustomer(int id , CustomerDto customerDto) {
		
		Optional<Cstomer> customerID = customerRepository.findById(id);
		
		if(customerID.isPresent()==false) {
			return null;
		}
		
		Cstomer customer = customerID.get();
		
		customer.contactNo=customerDto.contactNo;
		customer.firstName=customerDto.firstName;
		customer.lastName=customerDto.lastName;
		customer.nic=customerDto.nic;
		customer.address=customerDto.address;
		
		Cstomer customerR = customerRepository.save(customer);
		customerDto.id=customerR.id;
		
		return customerDto;
		
	}
	
	
}
