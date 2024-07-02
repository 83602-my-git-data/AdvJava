package com.sunbeam.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.User;
import com.sunbeam.entities.Vehicle;

public interface VechicleDao extends JpaRepository<Vehicle, Long> {
	List<Vehicle> findByUserUName(String UName);
	int deleteByUserUName(String Uname);
	
	
	

}
