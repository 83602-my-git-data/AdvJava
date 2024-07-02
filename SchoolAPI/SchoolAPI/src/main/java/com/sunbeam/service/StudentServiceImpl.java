package com.sunbeam.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.custom_exceptions.ApiException;
import com.sunbeam.dao.CourseDao;
import com.sunbeam.dao.StudentDao;
import com.sunbeam.dto.AddStudentDto;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.StudentDto;
import com.sunbeam.entities.Course;
import com.sunbeam.entities.Student;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{
	
	
	@Autowired 
	StudentDao studentDao;
	
	@Autowired
	CourseDao courseDao;
	
	@Autowired
	ModelMapper mapper;
	
	
	public ApiResponse addStudent(AddStudentDto dto) {
		
	Course course=	courseDao.findById(dto.getId()).orElseThrow(()-> new ApiException("invalid id "));
	
	Student student= mapper.map(dto,Student.class );
	student.setCourse(course);
	
	
	studentDao.save(student);
	
	return new ApiResponse("student added");
	
	
		
	
	}


	@Override
	public List<StudentDto> getStudentByCName(String name) {
		
		
		List <Student> lists =studentDao.findByCourseName(name);
		
		List<StudentDto> listDto = new ArrayList<>();
		
		
		for(Student list : lists)
		{
			StudentDto st = mapper.map(list, StudentDto.class);
			listDto.add(st);
		}
		return listDto;
		
		
//		return studentDao.findByCourseName(name).stream().map((st)->mapper.map(st, StudentDto.class)).collect(Collectors.toList());
	}
	
	

}
