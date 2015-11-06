package com.catalyst.collector.daos;

import java.util.ArrayList;
import java.util.List;

import com.catalyst.collector.entities.Age;
import com.catalyst.collector.entities.Category;
import com.catalyst.collector.entities.Collectible;
import com.catalyst.collector.entities.Color;
import com.catalyst.collector.entities.Condition;
import com.catalyst.collector.entities.Keyword;

public interface CollectionsDao {
	
	boolean addColor(Color addedColor);
	Color getColor(int colorId);
	boolean removeColor(int id);
	List<Color> getColorList();
	boolean updateColor(Color c);



//nneeed to commit
	ArrayList<Collectible> getCollectibles();
	Collectible getCollectible(int id);

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
	boolean addCategory(Category category);

	/**
	 * updates the given category (which will be identified by the id number)
	 * @param category
	 */
	boolean updateCategory(Category category);

	/**
	 * deletes the category which matches the given id number
	 * @param id
	 */
	boolean deleteCategory(int id);
    ArrayList<Keyword> getAllKeywords();
    void addKeyword(Keyword keyword);
    void updateKeyword(Keyword keyword);
    void removeKeyword(Integer id);
	void addCollectible(Collectible collectible);
	void updateCollectible(Collectible collectible);

	/**
	 * Gets an ArrayList of age types from the database
	 * @return
	 */
	ArrayList<Age> getAgeTypes();

	/**
	 * Adds an age type to the database
	 * @param age
	 */
	void addAge(Age age);

	/**
	 * Updates an age type in the database
	 * @param age
	 */
	void updateAge(Age age);

	/**
	 * Deletes an age type from the database
	 * @param id
	 */
	void deleteAge(Integer id);

    ArrayList<Condition> getAllConditions();
    void addCondition(Condition condition);
    void updateCondition(Condition condition);
    void deleteCondition(Integer id);
}
