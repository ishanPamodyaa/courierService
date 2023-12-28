package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BranchAddressDto;
import com.example.demo.service.BranchAddressService;

@RestController
@RequestMapping("/BranchAddress")

public class BranchAddressController {
	
	@Autowired
	BranchAddressService branchAddressService;
	
	@PostMapping
	public ResponseEntity<BranchAddressDto> addBranchAddress(@RequestBody BranchAddressDto branchAddressDto){
		
		branchAddressService.addBranchAddress(branchAddressDto);
		return new ResponseEntity<>(branchAddressDto,HttpStatus.OK);
	
	}
	

	
	
	
	
	
	

}
