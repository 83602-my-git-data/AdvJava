package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.UserDao;
import com.app.entities.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
  
	@Autowired
	private UserDao userDao;
	
	@Override
	public Optional<User> addUser(User user) {
	    return Optional.of(userDao.save(user));	 
	}

	@Override
	public Optional<User> loginUser(String email,String password) {
		return Optional.of(userDao.findByEmailAndPassword(email,password));
	}
	
	@Override
	public Optional<List<User>> fetchAllUser() {
		return Optional.of(userDao.findAll());
	}

	@Override
	public Optional<User> getUser(Long userId) {
		return userDao.findById(userId);
	}
}
