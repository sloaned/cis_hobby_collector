package com.catalyst.collector.services;

import java.util.ArrayList;
import java.util.List;

import com.catalyst.collector.entities.Category;
import com.catalyst.collector.entities.Color;

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
	 * @param id, category
	 */
	public void updateCategory(int id, Category category);

	/**
	 * deletes the category which matches the given id number
	 * @param id
	 */
	public void deleteCategory(int id);


	public List<Color> getColorList();
	public void addColor(Color addedColor);
	public boolean removeColor(String color);
	public boolean updateColor(int id, String color);
    public ArrayList<Keyword> getAllKeywords();
    public boolean addKeyword(Keyword keyword);
    public boolean updateKeyword(Keyword keyword);
    public void removeKeyword(Integer id);
}
