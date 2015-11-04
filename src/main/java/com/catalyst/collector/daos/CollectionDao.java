package com.catalyst.collector.daos;

import java.util.ArrayList;
import java.util.List;

import com.catalyst.collector.entities.Collectible;
import com.catalyst.collector.entities.TestData;

public interface CollectionDao {

	public List<TestData> getTestData();

	ArrayList<Collectible> getCollectibles();

	Collectible getCollectible(int id);
}
