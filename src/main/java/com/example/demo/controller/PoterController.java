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
import com.example.demo.dto.EmployeeDto;
import com.example.demo.dto.PoterDto;
import com.example.demo.service.PoterService;


@RestController
@RequestMapping("/poter")
public class PoterController {
	@Autowired
	PoterService poterService;
	
	@PostMapping
	public ResponseEntity <PoterDto> savePoter(@RequestBody PoterDto poterDto){		
		poterService.savePoter(poterDto);
		return new ResponseEntity<>(poterDto, HttpStatus.OK);	
	}
	
	@PutMapping("{id}")
	public ResponseEntity<PoterDto> updatePoter(@PathVariable int id ,@RequestBody PoterDto poterDto){
	
		PoterDto respomse = poterService.updatePoter(id,poterDto);
		
		return new ResponseEntity<>(respomse , HttpStatus.OK);	
	}

	@GetMapping("{id}")
	public ResponseEntity<PoterDto> getPoter(@PathVariable int id){
		
		PoterDto response =poterService.getPoter(id);
		
		return new ResponseEntity<>(response,HttpStatus.OK);
		
	}
	
	
}
