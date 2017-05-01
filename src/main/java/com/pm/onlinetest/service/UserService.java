package com.pm.onlinetest.service;

import java.util.List;

import com.pm.onlinetest.domain.User;

 
public interface UserService {

	public void save(User user);
	public void delete(User user);
	public List<User> findAll();
	public User findByUsername(String username);
	public User findByUserId(Integer userId);
	public List<User> findByAuthority(String authority);
 }
