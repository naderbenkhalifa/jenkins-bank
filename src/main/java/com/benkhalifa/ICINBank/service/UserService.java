package com.benkhalifa.ICINBank.service;

import java.util.List;

import com.benkhalifa.ICINBank.model.User;



public interface UserService {
	
	 public User save(User user);
	 public List<User> getAll();
	 public User getUserByPassword(String password);
	 public User getUserByEmail(String email);
	 public User getUserByEmailAndPassword(String email,String password);
	 public void deleteUserById(Long id);
	 public User getUserById(Long id);
	

}
