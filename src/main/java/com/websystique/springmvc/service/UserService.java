package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.User;



public interface UserService {
	
	User findById(long id);
	
	User findByName(String name);
	
	void saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUserById(long id);

	List<User> findAllUsers();

	List<User> findAllEmployees();
	
	void deleteAllUsers();
	
	public boolean isUserExist(User user);
	
}
