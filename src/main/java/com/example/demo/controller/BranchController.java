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

//import com.example.demo.dto.BranchAddressDto;
import com.example.demo.dto.BranchDto;
import com.example.demo.dto.EmployeeDto;
//import com.example.demo.service.BranchAddressService;
import com.example.demo.service.BranchService;

@RestController
@RequestMapping("/Branch")

public class BranchController {
	
	@Autowired
	BranchService branchService;
	
	@PostMapping
	public ResponseEntity <BranchDto> saveBranch(@RequestBody BranchDto branchDto){
		
		branchService.saveBranch(branchDto);
		return new ResponseEntity<>(branchDto,HttpStatus.OK);
		}
	
	@GetMapping("{id}")
	public ResponseEntity<BranchDto> getBranch(@PathVariable int id){

		BranchDto response =branchService.getBranch(id);
		return new ResponseEntity<>(response,HttpStatus.OK);
		
		
	}
	
	@PutMapping("{id}")
	public ResponseEntity<BranchDto> updateBranch(@PathVariable int id, @RequestBody BranchDto branchDto){
		
		BranchDto response = branchService.updateBranch(id,branchDto);
		return new ResponseEntity<BranchDto>(response, HttpStatus.OK);
	}
	
}
