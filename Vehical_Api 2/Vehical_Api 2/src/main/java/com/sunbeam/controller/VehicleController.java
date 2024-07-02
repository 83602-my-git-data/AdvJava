package com.sunbeam.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.VehicleRequestDto;
import com.sunbeam.service.VehicleService;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
	@Autowired
	private VehicleService vehicleService;
	@PostMapping
	public ResponseEntity<?> addVehicle(@RequestBody  @Valid  VehicleRequestDto dto){
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(vehicleService.addNewVehicle(dto));
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Failed to add vehicle"));
		}
		
		
		
	}
	
	@GetMapping("/{UName}")
	public ResponseEntity<?> getVehicle(@PathVariable  @Valid  String UName){
		
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(vehicleService.getVehical(UName));
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Failed to add vehicle"));
		}
		
		
		
	}
	

	@DeleteMapping("/{UName}")
	public ResponseEntity<?> deleteVehicle(@PathVariable @Valid String UName){
		
		try {
			return ResponseEntity.ok(vehicleService.deleteVehical(UName));
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Failed to add vehicle"));
		}
		
		
		
	}
	
	

	
}
