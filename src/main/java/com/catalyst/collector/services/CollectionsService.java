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
	 * @param category category
	 * @return pass or fail
	 */
	boolean addCategory(Category category);

	/**
	 * updates the given category (which will be identified by the id number)
	 * @param id category
	 * @param category category
	 * @return pass or fail
	 */
	boolean updateCategory(int id, Category category);

	/**
	 * deletes the category which matches the given id number
	 * @param id d
	 * @return pass or fail
	 */
	boolean deleteCategory(int id);

	/**
	 * Return a list of All Color in the database
	 * @return List of Color
     */
	List<Color> getColorList();

	/**
	 * Add a color to the database
	 * @param addedColor MUST NOT HAVE ID SET
	 * @return pass or fail
     */
	boolean addColor(Color addedColor);

	/**
	 * remove a color from the database
	 * @param id the id of the color to remove
	 * @return pass or fail
     */
	boolean removeColor(int id);

	/**
	 * Update a color name in the database
	 * @param color MUST HAVE NAME AND ID SET
	 * @return pass or fail
     */
	boolean updateColor(Color color);

	/**
	 * Get a color by id from the database
	 * @param colorId the id if the color
	 * @return Color
     */
	Color getColor(int colorId);

	/**
	 * Returns a list of all {@link Condition} in the dataBase
	 * @return ArrayList of {@link Condition}
     */
    ArrayList<Condition> getAllConditions();

	/**
	 * Add a {@link Condition} to the database
	 * @param condition the condition to add
	 * @return pass or fail
     */
    boolean addCondition(Condition condition);

	/**
	 * update a {@link Condition} in the database
	 * @param condition MUST SET {@link Condition#id} and {@link Condition#condition}
	 * @return pass or fail
     */
    boolean updateCondition(Condition condition);

	/**
	 * Deletea a {@link Condition} from the Database
	 * @param id of the Condition
     */
    void deleteCondition(Integer id);
    
    ArrayList<Keyword> getAllKeywords();

	/**
	 * Gets a list of all {@link Keyword} that start with letter
	 * @param letter  First letter to match by
	 * @return ArrayList of {@link Keyword}
     */
    ArrayList<Keyword> getKeywordsByLetter(String letter);

	/**
	 * adds a {@link Keyword} to the {@link com.catalyst.collector.daos.CollectionsDao}
	 * @param keyword the {@link Keyword} to be added
	 * @return pass or fail
	 */
    boolean addKeyword(Keyword keyword);

	/**
	 * Update an exsisting {@link Keyword} in the database
	 * @param keyword MUST SET {@link Keyword#id} and {@link Keyword#keyword}
	 * @return pass or fail
     */
    boolean updateKeyword(Keyword keyword);

	/**
	 * remove a {@link Keyword} from the {@link com.catalyst.collector.daos.CollectionsDao}
	 * @param id {@link Keyword#id}
     */
    void removeKeyword(Integer id);

	/**
	 * Get a list of all {@link Collectible}
	 * @return ArrayList of {@link Collectible}
     */
	ArrayList<Collectible> getCollectibles();

	/**
	 * get a collectible by {@link Collectible#id}
	 * @param id the {@link Collectible#id} to macth
	 * @return {@link Collectible}
     */
	Collectible getCollectible(Integer id);

	/**
	 * Remove a {@link Collectible} from the {@link com.catalyst.collector.daos.CollectionsDao}
	 * @param id the {@link Collectible#id} to be removed
	 * @return pass or fail
     */
	boolean removeCollectible(int id);

	/**
	 * adds a {@link Collectible} to the {@link com.catalyst.collector.daos.CollectionsDao}
	 * @param collectible the {@link Collectible} to be added
	 * @return pass or fail
     */
	boolean addCollectible(Collectible collectible);

	/**
	 * update an exsisting {@link Collectible} in the {@link com.catalyst.collector.daos.CollectionsDao}
	 * @param collectible the {@link Collectible} to be added
     */
	void updateCollectible(Collectible collectible);

	/**
	 * Calls the add Age method in the {@link com.catalyst.collector.daos.CollectionsDao}
	 * @param age MUST NOT SET {@link Age#id}
	 */
	void addAge(Age age);

	/**
	 * Calls the get age types method in the {@link com.catalyst.collector.daos.CollectionsDao}
	 * @return ArrayList of {@link Age}
	 */
	ArrayList<Age> getAgeTypes();

	/**
	 * Calls the update age method in the {@link com.catalyst.collector.daos.CollectionsDao}
	 * @param age MUST SET {@link Age#id} and {@link Age#age}
	 */
	void updateAge(Age age);

	/**
	 * Calls the delete age method in the Dao
	 * @param id {@link Age#id} of Age in the database
	 * @return pass or fail
	 */
	boolean deleteAge(Integer id);

}
