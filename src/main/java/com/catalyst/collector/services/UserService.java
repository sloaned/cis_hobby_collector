package com.catalyst.collector.services;

import java.util.ArrayList;

import com.catalyst.collector.entities.Username;

public interface UserService {
	
	ArrayList<Username> getAllUsers();
	
	Username getUserById(int id);
	
	ArrayList<Username> getUserByName(String name);
	
	boolean addUser(Username user);
	
	boolean updateUser(Username user);
	
	boolean deleteUser(int id);
}
