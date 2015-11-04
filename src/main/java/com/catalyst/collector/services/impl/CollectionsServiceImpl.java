package com.catalyst.collector.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.catalyst.collector.entities.Age;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.collector.daos.CollectionsDao;
import com.catalyst.collector.entities.TestData;
import com.catalyst.collector.services.CollectionsService;

@Service
public class CollectionsServiceImpl implements CollectionsService {

	@Autowired
	CollectionsDao collectionsDao;
	
	
	public void setCollectionsDao(CollectionsDao collectionsDao) {
		this.collectionsDao = collectionsDao;
	}


	@Override
	public List<TestData> getTestData() {
		return collectionsDao.getTestData();
	}

	@Override
	public void addAge(Age age) {
		collectionsDao.addAge(age);
	}

	@Override
	public ArrayList<Age> getAgeTypes(){
		return collectionsDao.getAgeTypes();
	}

	@Override
	public void updateAge(Age age){
		collectionsDao.updateAge(age);
	}

	@Override
	public void deleteAge(Integer id){
		collectionsDao.deleteAge(id);
	}

}
