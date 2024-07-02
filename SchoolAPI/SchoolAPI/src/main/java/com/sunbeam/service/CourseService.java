package com.sunbeam.service;

import java.util.List;

import com.sunbeam.dto.AddCourceDto;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.UpdateCourse;
import com.sunbeam.entities.Course;

public interface CourseService {
	
	public  ApiResponse addCourse(AddCourceDto dto);
	 public ApiResponse updateCourse(UpdateCourse updateDto, Long id);	
	 public List<Course> getCourse(String name);
	 

}
