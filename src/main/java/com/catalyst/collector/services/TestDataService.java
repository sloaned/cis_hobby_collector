package com.catalyst.collector.services;

import java.util.ArrayList;
import java.util.List;

import com.catalyst.collector.entities.Category;
import com.catalyst.collector.entities.TestData;

public interface TestDataService {
	
	public List<TestData> getTestData();
	
	public ArrayList<Category> getCategory();
	
	public void addCategory(Category category);
	
	public void updateCategory(Category category);
	
	public void deleteCategory(int id);
}
