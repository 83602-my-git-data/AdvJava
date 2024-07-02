package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.AddCourceDto;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.service.CourseService;
import com.sunbeam.service.CourseServiceImpl;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@PostMapping
	public ResponseEntity<?> AddCourse(@RequestBody AddCourceDto dto) {
		
		try {
		return 	ResponseEntity.status(HttpStatus.CREATED).body(courseService.addCourse(dto));
			
			
		}catch (RuntimeException e) {
		
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));		}
		
	
	}
	
	
	@PutMapping("{id}")
	public ResponseEntity<?> UpdateCourse(@RequestBody com.sunbeam.dto.UpdateCourse dto , @PathVariable Long id) {
		
		try {
		return 	ResponseEntity.ok(courseService.updateCourse(dto,id));
			
			
		}catch (RuntimeException e) { 
		
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));		}
		
	
	}
	
	
	@GetMapping("{name}")
public ResponseEntity<?> UpdateCourse( @PathVariable String name) {
		
		try {
		return 	ResponseEntity.ok(courseService.getCourse(name));
			
			
		}catch (RuntimeException e) { 
		
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));		}
		
	
	}
	
	
	
	

}
