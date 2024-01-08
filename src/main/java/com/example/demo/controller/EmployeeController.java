package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	@PostMapping
	public ResponseEntity <EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){		
		EmployeeDto response=employeeService.saveEmployee(employeeDto);
		return new ResponseEntity<>(response, HttpStatus.OK);	
	}
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto> grtEmployee(@PathVariable int id){
		
		EmployeeDto response =employeeService.getEmployee(id);
		return new ResponseEntity<>(response,HttpStatus.OK);
		
	}
	
	@PutMapping("{id}")
	public ResponseEntity <EmployeeDto> upateEmployee(@PathVariable int id,@RequestBody EmployeeDto employeeDto){					
		EmployeeDto response =employeeService.updateEmployee(id,employeeDto);	
		return new ResponseEntity<>(response, HttpStatus.OK);		
	}
	


}
