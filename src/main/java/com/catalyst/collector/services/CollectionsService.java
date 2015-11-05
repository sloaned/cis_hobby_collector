package com.catalyst.collector.services;

import java.util.ArrayList;
import java.util.List;

import com.catalyst.collector.entities.*;

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

	ArrayList<Collectible> getCollectibles();

	Collectible getCollectible(Integer id);


	public List<Color> getColorList();
	public void addColor(Color addedColor);
	public boolean removeColor(String color);
	public boolean updateColor(int id, String color);
    ArrayList<Keyword> getAllKeywords();
    boolean addKeyword(Keyword keyword);
    boolean updateKeyword(Keyword keyword);
    void removeKeyword(Integer id);
    ArrayList<Condition> getAllConditions();
    boolean addCondition(Condition condition);
    boolean updateCondition(Condition condition);
}
