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
	public boolean addCategory(Category category);

	/**
	 * updates the given category (which will be identified by the id number)
	 * @param id, category
	 */
	public boolean updateCategory(int id, Category category);

	/**
	 * deletes the category which matches the given id number
	 * @param id
	 */
	public boolean deleteCategory(int id);

	ArrayList<Collectible> getCollectibles();

	Collectible getCollectible(Integer id);

	public Color getByColorId(int colorId);
	public List<Color> getColorList();
	public boolean addColor(Color addedColor);
	public boolean removeColor(int id);
	public boolean updateColor(int id, String color);
	public Color getColor(int colorId);
    ArrayList<Condition> getAllConditions();
    boolean addCondition(Condition condition);
    boolean updateCondition(Condition condition);
    void deleteCondition(Integer id);
    public ArrayList<Keyword> getAllKeywords();
    public boolean addKeyword(Keyword keyword);
    public boolean updateKeyword(Keyword keyword);
    public void removeKeyword(Integer id);


	/**
	 * Calls the add Age method in the Dao
	 * @param age
	 */
	public void addAge(Age age);

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
	void deleteAge(Integer id);



}
