package com.catalyst.collector.daos;

import java.util.ArrayList;
import java.util.List;

import com.catalyst.collector.entities.Age;
import com.catalyst.collector.entities.TestData;

public interface CollectionsDao {

	public List<TestData> getTestData();
	public void addAge(Age age);

	/**
	 * Gets an ArrayList of age types from the database
	 * @return
     */
	ArrayList<Age> getAgeTypes();

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
import java.util.List;

import com.catalyst.collector.entities.Color;
import java.util.ArrayList;

import com.catalyst.collector.entities.Category;

public interface CollectionsDao {

	ArrayList<Collectible> getCollectibles();
	Collectible getCollectible(int id);
	public void addColor(Color addedColor);
	public boolean removeColor(Color c);
	public List<Color> getColorList();
	public void updateColor(Color c);
	/**
	 * gets every category object
	 * @return ArrayList of all categories
	 */
	public ArrayList<Category> getCategory();

	/**
	 * Returns a single category which matches the given id number
	 * @param categoryId
	 * @return a single category object
	 */
	public Category getByCategoryId(int categoryId);

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
    public ArrayList<Keyword> getAllKeywords();
    public void addKeyword(Keyword keyword);
    public void updateKeyword(Keyword keyword);
    public void removeKeyword(Integer id);
}
