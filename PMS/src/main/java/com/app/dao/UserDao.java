package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.User;

public interface UserDao extends JpaRepository<User, Long>{
   
	User findByEmailAndPassword(String em,String pass);
}
