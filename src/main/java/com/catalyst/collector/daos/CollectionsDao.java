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
	 * get List of colors from the database
	 * @return List of colors
     */
	List<Color> getColorList();

	/**
	 * update a color name in the database
	 * @param c Color MUST HAVE id and color SET
	 * @return pass of fail
     */
	boolean updateColor(Color c);

	/**
	 * Get collectible by catalog number
	 * @param catalogNumber a valid catalogNumber refrencing a collectible
	 * @return a collectible with matching catalogNumber or a null Collectible
     */
	public Collectible getCollectible(String catalogNumber);

	/**
	 * add a collectible to the database
	 * @param collectible the Collectible to add
	 * @return pass or fail
     */
	boolean addCollectible(Collectible collectible);

	/**
	 * update a Collectible in the database
	 * @param collectible the collectible to be updated MUST HAVE ID SET
	 * @return pass or fail
     */
	boolean updateCollectible(Collectible collectible);

	/**
	 * Remove a collectible by id
	 * @param id the id of the collectible
	 * @return pass or fail
     */
	boolean removeCollectible(int id);

	/**
	 * Get a list of all Collectibles in the database
	 * @return ArrayList of Collectible
     */
	ArrayList<Collectible> getCollectibles();

	/**
	 * Get a collectible by id
	 * @param id the id of the collectible
	 * @return a collectible with matching id
     */
	Collectible getCollectible(int id);

	/**
	 * gets every category object
	 * @return ArrayList of all categories
	 */
	ArrayList<Category> getCategory();

	/**
	 * Returns a single category which matches the given id number
	 * @param categoryId the id of category
	 * @return a single category object
	 */
	Category getByCategoryId(int categoryId);

	/**
	 * adds a new category to the database
	 * @param category the id of category
	 * @return pass or fail
	 */
	boolean addCategory(Category category);

	/**
	 * updates the given category (which will be identified by the id number)
	 * @param category the id of category
	 * @return pass or fail
	 */
	boolean updateCategory(Category category);

	/**
	 * deletes the category which matches the given id number
	 * @param id the id of category
	 * @return pass or fail
	 */
	boolean deleteCategory(int id);

	/**
	 * get a list of keywords from the database
	 * @return ArrayList of Keyword
     */
    ArrayList<Keyword> getAllKeywords();

	/**
	 * Return a list of keywords starting with letter
	 * @param letter the beging letter to search by
	 * @return ArrayList of Keyword starting with letter letter
     */
    ArrayList<Keyword> getKeywordsByLetter(String letter);

	/**
	 * add a {@link Keyword} to the database
	 * @param keyword MUST NOT SET {@link Keyword#id}
     */
    void addKeyword(Keyword keyword);

	/**
	 * update an exsisting {@link Keyword} in the database
	 * @param keyword MUST SET {@link Keyword#id} and {@link Keyword#keyword}
     */
    void updateKeyword(Keyword keyword);

	/**
	 * Remove an exsisting {@link Keyword} from the database
	 * @param id {@link Keyword#id}
     */
    void removeKeyword(Integer id);


	/**
	 * Gets an ArrayList of age types from the database
	 * @return ArrayList of Age
	 */
	ArrayList<Age> getAgeTypes();

	/**
	 * Adds an age type to the database
	 * @param age MUST NOT HAVE ID SET
	 */
	void addAge(Age age);

	/**
	 * Updates an age type in the database
	 * @param age MUST HAVE ID AND AGE SET
	 */
	void updateAge(Age age);

	/**
	 * Deletes an age type from the database
	 * @param id of age to be deleted
	 */
	void deleteAge(Integer id);

	/**
	 * Return a list of all Conditions
	 * @return ArrayList of Condition
     */
    ArrayList<Condition> getAllConditions();

	/**
	 * Adds a Condition to the database
	 * @param condition MUST NOT HAVE ID SET
     */
    void addCondition(Condition condition);

	/**
	 * Update a condition to the database
	 * @param condition MUST HAVE CONDITION AND ID SET
     */
    void updateCondition(Condition condition);

	/**
	 * Delete a Condition from the database by id
	 * @param id the id of the Condition to remove
     */
    void deleteCondition(Integer id);
}
