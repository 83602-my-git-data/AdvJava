package com.sunbeam.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Course;

public interface CourseDao  extends JpaRepository<Course, Long>{

	public List<Course> findByName(String name);
}
