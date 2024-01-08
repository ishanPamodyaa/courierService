package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BranchDto;
import com.example.demo.dto.VehicleDto;
import com.example.demo.entity.Branch;
import com.example.demo.entity.Vehicle;
import com.example.demo.repository.VehicleRepository;

@Service
public class VehicleService {
	@Autowired
	VehicleRepository vehicleRepository;
	
	public void saveVehicle(VehicleDto vehicleDto) {
		
		
		Vehicle vehicleObj = new Vehicle();
		
		vehicleObj.type  =vehicleDto.type;
		vehicleObj.licenceDate=vehicleDto.licenceDate;
		vehicleObj.lastOilChange=vehicleDto.lastOilChange;
		vehicleObj.vehivleNo=vehicleDto.vehivleNo;
		
		vehicleRepository.save(vehicleObj);
		
		
	}
	
	

}
