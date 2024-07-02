package com.sunbeam.service;

import java.util.List;

import com.sunbeam.dto.AddStudentDto;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.StudentDto;
import com.sunbeam.entities.Student;

public interface StudentService {
	public ApiResponse addStudent(AddStudentDto dto);
	
	public List<StudentDto> getStudentByCName(String name);
	

}
