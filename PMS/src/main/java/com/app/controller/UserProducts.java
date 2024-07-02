package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.LoginDTO;
import com.app.entities.User;
import com.app.exceptions.CustomException;
import com.app.service.UserService;

@RestController
@RequestMapping("/user")
public class UserProducts {

	@Autowired
	private UserService userService;

	@GetMapping("/allUser")
	public ResponseEntity<?> allUser() {
		try {
			Optional<List<User>> user = Optional.ofNullable(userService.fetchAllUser().orElseThrow());
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(user);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(false, "Empty Users!!"));
		}

	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<?> findUser(@RequestParam Long userId) {
		try {
			User user = userService.getUser(userId).orElseThrow();
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(user);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(false, "Empty Users!!"));
		}

	}
	
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody User userRequestData){
		try {
		User user = userService.addUser(userRequestData).orElseThrow();
		return ResponseEntity.status(HttpStatus.OK).body(user);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(false,"Invalid Details!!"));
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> signUp(@RequestBody LoginDTO loginDto) {
		try {
			User user = userService.loginUser(loginDto.getEmail(), loginDto.getPassword()).orElseThrow();
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(user);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(false, "Invalid email and Password Details!!"));
		}

	}
}
//http://localhost:8080/swagger-ui/index.html