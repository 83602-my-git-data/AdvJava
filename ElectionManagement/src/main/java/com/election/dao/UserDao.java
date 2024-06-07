package com.election.dao;

import com.election.pojos.User;

public interface UserDao { 
     User findByEmail(String email) throws Exception; 
    User findById(int id) throws Exception; 
    public int save(User user) throws Exception; 
    public int updateStatus(int userId, boolean voted) throws Exception; 
    public int updatePassword(int userId, String newPassword) throws Exception; 
    public int deleteById(int id) throws Exception; 
    public int update(User user) throws Exception;
}
