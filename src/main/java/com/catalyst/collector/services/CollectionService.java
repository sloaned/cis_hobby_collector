package com.catalyst.collector.services;

import java.util.ArrayList;
import java.util.List;

import com.catalyst.collector.entities.Collectible;
import com.catalyst.collector.entities.TestData;

public interface CollectionService {
	
	public List<TestData> getTestData();

	ArrayList<Collectible> getCollectibles();

	Collectible getCollectible(Integer id);
}
