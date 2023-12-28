package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.example.demo.dto.BranchAddressDto;
import com.example.demo.dto.BranchDto;
//import com.example.demo.service.BranchAddressService;
import com.example.demo.service.BranchService;

@RestController
@RequestMapping("/Branch")

public class BranchController {
	
	@Autowired
	BranchService branchService;
	
	@PostMapping
	public ResponseEntity <BranchDto> addBranch(@RequestBody BranchDto branchDto){
		
		branchService.saveBranch(branchDto);
		return new ResponseEntity<>(branchDto,HttpStatus.OK);
	}
}
