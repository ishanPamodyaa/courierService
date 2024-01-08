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

import com.example.demo.dto.VehicleDto;
import com.example.demo.entity.Vehicle;
import com.example.demo.service.VehicleService;



@RestController
@RequestMapping("/vehicle")
public class VehicleController {
	
	
	@Autowired
	VehicleService vehicleService;
	
	@PostMapping
	public ResponseEntity <VehicleDto> saveVehicle(@RequestBody VehicleDto vehicleDto){		
		vehicleService.saveVehicle(vehicleDto);
		return new ResponseEntity<>(vehicleDto, HttpStatus.OK);
	}

	

}
