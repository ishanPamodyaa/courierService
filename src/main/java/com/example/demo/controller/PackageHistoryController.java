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
import com.example.demo.dto.PackageHistoryDto;
import com.example.demo.service.PackageHistoryService;

@RestController
@RequestMapping("/packageHistory")
public class PackageHistoryController {
	
	@Autowired
	PackageHistoryService packageHistoryService;
	
	@PostMapping
	public ResponseEntity<PackageHistoryDto> savePackageHistory(@RequestBody PackageHistoryDto packageHistoryDto){

		PackageHistoryDto response = packageHistoryService.savePackageHistory(packageHistoryDto);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
	@GetMapping("{id}")
	public ResponseEntity<PackageHistoryDto> getBranch(@PathVariable int id){

		PackageHistoryDto response =packageHistoryService.getPackageHistory(id);
		return new ResponseEntity<>(response,HttpStatus.OK);
		
		
	}
	
	@PutMapping("{id}")
	public ResponseEntity<PackageHistoryDto> updateBranch(@PathVariable int id, @RequestBody PackageHistoryDto packageHistoryDto){
		
		PackageHistoryDto response = packageHistoryService.updatePackageHistory(id,packageHistoryDto);
		return new ResponseEntity<PackageHistoryDto>(response, HttpStatus.OK);
	}
	
	
	
	
	

}
