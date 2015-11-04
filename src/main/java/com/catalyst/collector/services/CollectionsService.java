package com.catalyst.collector.services;

import java.util.ArrayList;
import java.util.List;

import com.catalyst.collector.entities.Category;
import com.catalyst.collector.entities.Collectible;
import com.catalyst.collector.entities.Color;
import com.catalyst.collector.entities.Keyword;

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
	List<Color> getColorList();
	void addColor(Color addedColor);
	boolean removeColor(String color);
	boolean updateColor(int id, String color);
    ArrayList<Keyword> getAllKeywords();
    boolean addKeyword(Keyword keyword);
    boolean updateKeyword(Keyword keyword);
    void removeKeyword(Integer id);
	void addCollectible(Collectible collectible);
	void updateCollectible(Collectible collectible);
}
