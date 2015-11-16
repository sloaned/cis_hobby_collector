package com.catalyst.collector.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catalyst.collector.entities.Username;
import com.catalyst.collector.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public ArrayList<Username> getAllUsers(){
		return userService.getAllUsers();
	}	
	
	@RequestMapping(value="/users", method=RequestMethod.POST)
	public void addUser(@RequestBody Username user){
		userService.addUser(user);
	}
	
	@RequestMapping(value="/user/{id}", method=RequestMethod.GET)
	public Username getUserById(@PathVariable Integer id){
		return userService.getUserById(id);
	}
	
	@RequestMapping(value="/users/{username}", method=RequestMethod.GET)
	public boolean nameInUse(@PathVariable String username){
		return userService.nameInUse(username);
	}
	
	@RequestMapping(value="/user/name/{username}", method=RequestMethod.GET)
	public Username getUserByName(@PathVariable String username){
		return userService.getUserByName(username);
	}
	
	@RequestMapping(value="/user/{id}", method=RequestMethod.PUT)
	public void updateUser(@PathVariable Integer id, @RequestBody Username user){
		user.setId(id);
		userService.updateUser(user);
	}
	
	@RequestMapping(value="/user/{id}", method=RequestMethod.DELETE)
	public void deleteUser(@PathVariable Integer id){
		userService.deleteUser(id);
	}
	
}
