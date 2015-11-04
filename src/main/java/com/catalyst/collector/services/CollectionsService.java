package com.catalyst.collector.services;

import java.util.ArrayList;
import java.util.List;

import com.catalyst.collector.entities.Age;
import com.catalyst.collector.entities.TestData;

public interface CollectionsService {
	
	public List<TestData> getTestData();

	/**
	 * Calls the add Age method in the Dao
	 * @param age
     */
	public void addAge(String age);

	/**
	 * Calls the get age types method in the Dao
	 * @return
     */
	ArrayList<Age> getAgeTypes();

	/**
	 * Calls the update age method in the Dao
	 * @param age
     */
	void updateAge(Age age);

	/**
	 * Calls the delete age method in the Dao
	 * @param age
     */
	void deleteAge(Age age);
}
