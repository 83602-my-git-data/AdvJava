package com.sunbeam.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sunbeam.entities.Student;

public interface StudentDao extends JpaRepository<Student, Long> {
    
    @Query("SELECT s FROM Student s WHERE s.course.name = :courseName")
    List<Student> findByCourseName(@Param("courseName") String courseName);
    
    
}
