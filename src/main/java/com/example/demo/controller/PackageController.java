package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CustomerDto;
import com.example.demo.dto.PackageDto;
import com.example.demo.service.PackageService;

@RestController
@RequestMapping("/package")

public class PackageController {
	
	@Autowired
	PackageService packaeService;
	
	@PostMapping
	public ResponseEntity <PackageDto> savePackage(@RequestBody PackageDto packageDto){
		
	  PackageDto response =packaeService.savePackage(packageDto);
		
		return new ResponseEntity<>(response,HttpStatus.OK);
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<PackageDto> getPackage(@PathVariable int id){

		PackageDto response =packaeService.getPackage(id);
		return new ResponseEntity<>(response,HttpStatus.OK);
		
		
	}
	
	@PutMapping("{id}")
	public ResponseEntity<PackageDto> updatePackage(@PathVariable int id, @RequestBody PackageDto packageDto){
		
		PackageDto response = packaeService.updatePackage(id,packageDto);
		return new ResponseEntity<PackageDto>(response, HttpStatus.OK);
	}
	
	
	@DeleteMapping("{id}")
	public ResponseEntity <String> deletePackage(@PathVariable int id){
		
		boolean done=packaeService.deletePackage(id);
		
		if(done==true) {
			return ResponseEntity.ok("Data Delete Successful = ID " + id );
		}else
			return ResponseEntity.status(404).body("Data Delete Not Successfuul(or Not Found) = ID " + id);
	
		
	}
	
	
	
	
	

}
