package com.catalyst.collector.services;

import java.util.ArrayList;

import com.catalyst.collector.entities.Username;

public interface UserService {
	
	ArrayList<Username> getAllUsers();
	
	Username getUserById(int id);
	
	boolean addUser(Username user);
	
	boolean updateUser(Username user);
	
	boolean deleteUser(int id);
}
