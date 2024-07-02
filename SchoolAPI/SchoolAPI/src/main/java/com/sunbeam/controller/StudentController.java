package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.AddStudentDto;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.service.StudentService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/student")
public class StudentController {

	
	@Autowired
	private StudentService studentService;
	
	@PostMapping
	public ResponseEntity<?> addStudent(@RequestBody AddStudentDto dto) {
		
		try {
			return 	ResponseEntity.status(HttpStatus.CREATED).body(studentService.addStudent(dto));
				
				
			}catch (RuntimeException e) {
			
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));		}
			
		
		}
		
	

	@GetMapping("{name}")
	public ResponseEntity<?> getstudentsByCname(@PathVariable String name) {
		
		try {
			return 	ResponseEntity.ok(studentService.getStudentByCName(name));
				
				
			}catch (RuntimeException e) {
			
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));		}
			
		
		}
	
}
