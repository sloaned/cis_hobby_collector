package com.catalyst.collector.daos;

import java.util.ArrayList;
import java.util.List;

import com.catalyst.collector.entities.*;

public interface CollectionsDao {
	/**
	 * Adds a color to the dataBase
	 * @param addedColor The color being added to the db MUST NOT HAVE ID SET
	 * @return true if success false otherwise
     */
	boolean addColor(Color addedColor);

	/**
	 * get a color associated with the given id
	 * @param colorId an id to a color in the database
	 * @return The Color Object
     */
	Color getColor(int colorId);

	/**
	 * Removes a color from the database
	 * @param id the id of the color to remove
	 * @return false if the color could not be removed true otherwise
     */
	boolean removeColor(int id);

	/**
	 * get
	 * @return
     */
	List<Color> getColorList();
	boolean updateColor(Color c);

	public Collectible getCollectible(String catalogNumber);
	boolean addCollectible(Collectible collectible);
	boolean updateCollectible(Collectible collectible);
	boolean removeCollectible(int id);
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
    ArrayList<Keyword> getKeywordsByLetter(String letter);
    void addKeyword(Keyword keyword);
    void updateKeyword(Keyword keyword);
    void removeKeyword(Integer id);


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
