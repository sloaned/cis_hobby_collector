package com.catalyst.collector.daos;

import java.util.ArrayList;
import java.util.List;

import com.catalyst.collector.entities.Age;

import com.catalyst.collector.entities.Collectible;
import com.catalyst.collector.entities.Color;

import com.catalyst.collector.entities.Category;
import com.catalyst.collector.entities.Keyword;

public interface CollectionsDao {
	
	public boolean addColor(Color addedColor); 
	public Color getByColorId(int colorId);
	public boolean removeColor(int id);
	public List<Color> getColorList();
	public boolean updateColor(Color c);




	ArrayList<Collectible> getCollectibles();
	Collectible getCollectible(int id);
<<<<<<< HEAD
	
	
	
	
=======
	void addColor(Color addedColor);
	boolean removeColor(int id);
	List<Color> getColorList();
	void updateColor(Color c);
>>>>>>> 0fd35167437ca4fab58292063ccfa585d0794525
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
}
