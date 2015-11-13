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
		return userDao.getUserById(id);
	}

	@Override
	public boolean addUser(Username user) {
		return userDao.addUser(user);
	}

	@Override
	public boolean updateUser(Username user) {
		return userDao.updateUser(user);
	}

	@Override
	public boolean deleteUser(int id) {
		return userDao.deleteUser(id);
	}

}
