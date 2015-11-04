package com.catalyst.collector.daos;

import java.util.List;

import com.catalyst.collector.entities.Color;
import java.util.ArrayList;

import com.catalyst.collector.entities.Category;
import com.catalyst.collector.entities.Keyword;

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
