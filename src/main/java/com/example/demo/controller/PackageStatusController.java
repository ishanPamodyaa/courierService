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

import com.example.demo.dto.PackageHistoryDto;
import com.example.demo.dto.PackageStatusDto;
import com.example.demo.service.PackageStatusService;

@RestController
@RequestMapping("/packageStatus")
public class PackageStatusController {
	
	@Autowired
	PackageStatusService packageStatusService;
	
	@PostMapping
	public ResponseEntity< PackageStatusDto> savePackageStatus(@RequestBody PackageStatusDto packageStatusDto){
		
		PackageStatusDto response = packageStatusService.savePackageStatus(packageStatusDto);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
		
		@GetMapping("{id}")
		public ResponseEntity<PackageStatusDto> getPackageStatus(@PathVariable int id){

			PackageStatusDto response =packageStatusService.getPackageStatus(id);
			return new ResponseEntity<>(response,HttpStatus.OK);
		
	}
		
		@PutMapping("{id}")
		public ResponseEntity<PackageStatusDto> updatePackageStatus(@PathVariable int id, @RequestBody PackageStatusDto packageStatusDto){
			
			PackageStatusDto response = packageStatusService.updatePackageStatus(id,packageStatusDto);
			return new ResponseEntity<PackageStatusDto>(response, HttpStatus.OK);
		}	

}
