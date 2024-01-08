package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BranchDto;
import com.example.demo.dto.CustomerDto;
import com.example.demo.dto.PackageDto;
import com.example.demo.service.CustomerService;
import com.example.demo.service.PackageService;

@RequestMapping("/customer")
@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping
	public ResponseEntity <CustomerDto> saveCustomer(@RequestBody CustomerDto customerDto){
		
	  CustomerDto response =customerService.saveCustomer(customerDto);
		
		return new ResponseEntity<>(response,HttpStatus.OK);
		
	}
	@GetMapping("{id}")
	public ResponseEntity<CustomerDto> getCustomer(@PathVariable int id){

		CustomerDto response =customerService.getCustomer(id);
		return new ResponseEntity<>(response,HttpStatus.OK);
		
		
	}
	
	@PutMapping("{id}")
	public ResponseEntity<CustomerDto> updateCustomer(@PathVariable int id, @RequestBody CustomerDto customerDto){
		
		CustomerDto response = customerService.updateCustomer(id,customerDto);
		return new ResponseEntity<CustomerDto>(response, HttpStatus.OK);
	}
	
	

}
