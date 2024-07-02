package com.sunbeam.service;

import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.sunbeam.custom_exceptions.ApiException;
import com.sunbeam.custom_exceptions.ResourceNotFoundException;
import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.VechicleDao;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.UserDto;
import com.sunbeam.dto.VehicleRequestDto;
import com.sunbeam.entities.User;
import com.sunbeam.entities.Vehicle;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private VechicleDao vechicleDao;
	@Autowired
	private ModelMapper mapper;

	@Override
	public ApiResponse addNewVehicle(VehicleRequestDto dto) {
		System.out.println(dto);
		User user = userDao.findById(dto.getUid()).orElseThrow(()->new ApiException("User Not Found"));
		Vehicle vehicle = mapper.map(dto, Vehicle.class);
		vehicle.setUser(user);
		vechicleDao.save(vehicle);
		return new ApiResponse("Vehicle added successfully");
	}
	
	
	
	public List<Vehicle> getVehical(String UName){
		
		return vechicleDao.findByUserUName(UName);
		
	
	}
	
	public int  deleteVehical(String UName) {
	
		return vechicleDao.deleteByUserUName(UName);
	}

}
