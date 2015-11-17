package com.catalyst.collector.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.collector.daos.UserDao;
import com.catalyst.collector.entities.Username;
import com.catalyst.collector.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao){
		this.userDao = userDao;
	}
	
	@Override
	public ArrayList<Username> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public Username getUserById(int id) {
		if(id < 1)
		{
			return null;
		}
		return userDao.getUserById(id);
	}
	
	@Override
	public Username getUserByName(String name){
		return userDao.getUserByName(name);
	}

	@Override
	public boolean addUser(Username user) {
		if(user.getUsername() == null || user.getUsername() == "" || user.getPassword() == null || user.getPassword() == "")
		{
			return false;
		}
		return userDao.addUser(user);
	}

	@Override
	public boolean updateUser(Username user) {
		if(user.getUsername() == null || user.getUsername() == "" || user.getPassword() == null || user.getPassword() == "" || user.getId() == null || user.getId() < 1)
		{
			return false;
		}
		return userDao.updateUser(user);
	}

	@Override
	public boolean deleteUser(int id) {
		if(id < 1)
		{
			return false;
		}
		return userDao.deleteUser(id);
	}
	
	@Override
	public boolean nameInUse(String Name){
		return userDao.nameInUse(Name);
	}

}
