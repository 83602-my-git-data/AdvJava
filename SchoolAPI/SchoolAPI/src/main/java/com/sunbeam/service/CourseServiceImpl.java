package com.sunbeam.service;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.custom_exceptions.ApiException;
import com.sunbeam.dao.CourseDao;
import com.sunbeam.dto.AddCourceDto;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.UpdateCourse;
import com.sunbeam.entities.Course;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courseDao;
	
	@Autowired
	 private ModelMapper mapper ;
	
	
	
	@Override
	public ApiResponse addCourse(AddCourceDto dto) {
		
	Course c=	mapper.map(dto, Course.class);
		
		courseDao.save(c);
		
		return new ApiResponse(" course added ");
	}



	  public ApiResponse updateCourse(UpdateCourse updateDto, Long id) {
	        String message;
	        Course course = courseDao.findById(id)
	                .orElseThrow(() -> new ApiException("Course not found with id: " + id));

	       
	        if (updateDto.getStartDate() != null) {
	            course.setStartDate(updateDto.getStartDate());
	        }
	        if (updateDto.getEndDate() != null) {
	            course.setEndDate(updateDto.getEndDate());
	        }
	        if (updateDto.getFee() > 0) {
	            course.setFee(updateDto.getFee());
	        }
	        

	        
	        courseDao.save(course);
	        message = "Course updated successfully";
	        return new ApiResponse(message);
	    }
	  
	  
	  
	  public List<Course> getCourse(String name){
		  
		  return courseDao.findByName(name);
		  
		  
	  }
	  
	  
	}

	
	

