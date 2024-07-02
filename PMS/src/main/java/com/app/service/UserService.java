package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.entities.User;

public interface UserService {
   
	Optional<User> addUser(User user);
	Optional<User> loginUser(String email, String password);
	Optional<List<User>> fetchAllUser();
	Optional<User> getUser(Long userId);
}
