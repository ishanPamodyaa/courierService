package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PoterDto;
import com.example.demo.service.PoterService;


@RestController
@RequestMapping("/poter")
public class PoterController {
	@Autowired
	PoterService poterService;
	
	@PutMapping("{id}")
	public ResponseEntity<PoterDto> addPpoter(@PathVariable int id ,@RequestBody PoterDto poterDto){
	
		PoterDto respomse = poterService.addPoterToBranch(id,poterDto);
		
		return new ResponseEntity<>(respomse , HttpStatus.OK);
		
	}

}
