package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.UserDto;
import com.sunbeam.service.UserService;



@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@PostMapping
	public ResponseEntity<?> addUser(@RequestBody UserDto dto){
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(userService.addNewUser(dto));
			
		} catch (RuntimeException e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
		}
		
		
	}
	

}
