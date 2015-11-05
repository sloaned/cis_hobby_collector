package com.catalyst.collector.daos;

import java.util.List;

import com.catalyst.collector.entities.*;

import java.util.ArrayList;

public interface CollectionsDao {

	ArrayList<Collectible> getCollectibles();
	Collectible getCollectible(int id);
	void addColor(Color addedColor);
	boolean removeColor(Color c);
	List<Color> getColorList();
	void updateColor(Color c);
	/**
	 * gets every category object
	 * @return ArrayList of all categories
	 */
	ArrayList<Category> getCategory();

	/**
	 * Returns a single category which matches the given id number
	 * @param categoryId
	 * @return a single category object
	 */
	Category getByCategoryId(int categoryId);

	/**
	 * adds a new category to the database
	 * @param category
	 */
	void addCategory(Category category);

	/**
	 * updates the given category (which will be identified by the id number)
	 * @param category
	 */
	void updateCategory(Category category);

	/**
	 * deletes the category which matches the given id number
	 * @param id
	 */
	void deleteCategory(int id);
    ArrayList<Keyword> getAllKeywords();
    void addKeyword(Keyword keyword);
    void updateKeyword(Keyword keyword);
    void removeKeyword(Integer id);
    ArrayList<Condition> getAllConditions();
    void addCondition(Condition condition);
    void updateCondition(Condition condition);
    void deleteCondition(Integer id);
}
