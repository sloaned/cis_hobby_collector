package com.catalyst.collector.services;

import java.util.ArrayList;

import com.catalyst.collector.entities.Category;

public interface CollectionsService {
		
	/**
	 * gets every category object
	 * @return ArrayList of all categories
	 */
	public ArrayList<Category> getCategory();
	
	/**
	 * adds a new category to the database
	 * @param category
	 */
	public void addCategory(Category category);
	
	/**
	 * updates the given category (which will be identified by the id number)
	 * @param category
	 */
	public void updateCategory(Category category);
	
	/**
	 * deletes the category which matches the given id number
	 * @param id
	 */
	public void deleteCategory(int id);
}
