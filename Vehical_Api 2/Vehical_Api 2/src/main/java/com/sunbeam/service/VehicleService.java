package com.sunbeam.service;

import java.util.List;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.VehicleRequestDto;
import com.sunbeam.entities.Vehicle;

public interface VehicleService {
	public ApiResponse addNewVehicle(VehicleRequestDto dto);
	public List<Vehicle> getVehical(String UName);
	public int  deleteVehical(String UName) ;
	
	
}
