package com.sunbeam.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.UserDto;
import com.sunbeam.entities.User;
@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private ModelMapper mapper;

	@Override
	public ApiResponse addNewUser(UserDto dto) {
		User user=mapper.map(dto, User.class);
				userDao.save(user);
		return new ApiResponse("User added successfully");
	}

}
