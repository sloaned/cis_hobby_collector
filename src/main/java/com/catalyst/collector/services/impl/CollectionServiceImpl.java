package com.catalyst.collector.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.catalyst.collector.entities.Collectible;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.collector.daos.CollectionDao;
import com.catalyst.collector.entities.TestData;
import com.catalyst.collector.services.CollectionService;

@Service
public class CollectionServiceImpl implements CollectionService {

	@Autowired
	CollectionDao collectionDao;
	
	
	public void setCollectionDao(CollectionDao collectionDao) {
		this.collectionDao = collectionDao;
	}


	@Override
	public List<TestData> getTestData() {
		return collectionDao.getTestData();
	}

	@Override
	public ArrayList<Collectible> getCollectibles() {
		return collectionDao.getCollectibles();
	}

	@Override
	public Collectible getCollectible(Integer id) {
		return collectionDao.getCollectible(id);
	}

}
