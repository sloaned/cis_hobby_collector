package com.catalyst.collector.daos;

import java.util.ArrayList;

import com.catalyst.collector.entities.Username;

/*
 * Created by D.Sloane
 * 11/13/2015
 */
public interface UserDao {

	/**
	 * @return ArrayList containing all Username (User) objects
	 */
	ArrayList<Username> getAllUsers();
	
	/**
	 * gets Username object identified by its id number
	 * @param id
	 * @return single Username object
	 */
	Username getUserById(int id);
	
	/**
	 * gets Username object identified by its username
	 * @param name
	 * @return single Username object
	 */
	Username getUserByName(String name);
	
	/**
	 * adds a user to the database
	 * @param user
	 * @return true if successful
	 */
	boolean addUser(Username user);
	
	/**
	 * updates an existing user
	 * @param user
	 * @return true if successful
	 */
	boolean updateUser(Username user);
	
	/**
	 * deletes a user identified by an id number
	 * @param id
	 * @return true if successful
	 */
	boolean deleteUser(int id);
	
	/**
	 * checks whether a user with a given username exists
	 * @param Name
	 * @return true if the username exists in the database, false if not
	 */
	boolean nameInUse(String Name);
}
