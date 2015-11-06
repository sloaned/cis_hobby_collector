package com.catalyst.collector.services;

import java.util.ArrayList;
import java.util.List;

import com.catalyst.collector.entities.*;

public interface CollectionsService {

	/**
	 * gets every category object
	 * @return ArrayList of all categories
	 */
	ArrayList<Category> getCategory();

	/**
	 * adds a new category to the database
	 * @param category
	 */
	boolean addCategory(Category category);

	/**
	 * updates the given category (which will be identified by the id number)
	 * @param id, category
	 */
	boolean updateCategory(int id, Category category);

	/**
	 * deletes the category which matches the given id number
	 * @param id
	 */
	boolean deleteCategory(int id);
	ArrayList<Collectible> getCollectibles();
	Collectible getCollectible(Integer id);

	Color getByColorId(int colorId);
	List<Color> getColorList();
	boolean addColor(Color addedColor);
	boolean removeColor(int id);
	boolean updateColor(int id, String color);
	Color getColor(int colorId);
    ArrayList<Condition> getAllConditions();
    boolean addCondition(Condition condition);
    boolean updateCondition(Condition condition);
    void deleteCondition(Integer id);
    ArrayList<Keyword> getAllKeywords();
    boolean addKeyword(Keyword keyword);
    boolean updateKeyword(Keyword keyword);
    void removeKeyword(Integer id);
	void addCollectible(Collectible collectible);
	void updateCollectible(Collectible collectible);

	/**
	 * Calls the add Age method in the Dao
	 * @param age
	 */
	void addAge(Age age);

	/**
	 * Calls the get age types method in the Dao
	 * @return
	 */
	ArrayList<Age> getAgeTypes();

	/**
	 * Calls the update age method in the Dao
	 * @param age
	 */
	void updateAge(Age age);

	/**
	 * Calls the delete age method in the Dao
	 * @param id
	 */
	boolean deleteAge(Integer id);

}
