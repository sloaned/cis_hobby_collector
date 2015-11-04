package com.catalyst.collector.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.collector.daos.CollectionsDao;
import com.catalyst.collector.entities.Category;
import com.catalyst.collector.services.CollectionsService;

@Service
public class CollectionsServiceImpl implements CollectionsService {

	@Autowired
	CollectionsDao collectionsDao;
	
	
	public void setcollectionsDao(CollectionsDao collectionsDao) {
		this.collectionsDao = collectionsDao;
	}


	@Override
	public ArrayList<Category> getCategory() {
		
		return collectionsDao.getCategory();
	}


	@Override
	public void addCategory(Category category) {
		collectionsDao.addCategory(category);
		
	}


	@Override
	public void updateCategory(int id, Category category) {
		category.setId(id);
		collectionsDao.updateCategory(category);
		
	}


	@Override
	public void deleteCategory(int id) {
		collectionsDao.deleteCategory(id);
		
	}

}
