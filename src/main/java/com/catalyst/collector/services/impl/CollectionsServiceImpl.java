package com.catalyst.collector.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.collector.daos.CollectionsDao;
import com.catalyst.collector.entities.Category;
import com.catalyst.collector.services.CollectionsService;

@Service
public class CollectionsServiceImpl implements CollectionsService {

	@Autowired
	CollectionsDao testDataDao;
	
	
	public void setTestDataDao(CollectionsDao testDataDao) {
		this.testDataDao = testDataDao;
	}


	@Override
	public ArrayList<Category> getCategory() {
		
		return testDataDao.getCategory();
	}


	@Override
	public void addCategory(Category category) {
		testDataDao.addCategory(category);
		
	}


	@Override
	public void updateCategory(Category category) {
		testDataDao.updateCategory(category);
		
	}


	@Override
	public void deleteCategory(int id) {
		testDataDao.deleteCategory(id);
		
	}

}
