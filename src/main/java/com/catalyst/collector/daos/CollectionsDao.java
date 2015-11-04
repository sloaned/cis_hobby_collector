package com.catalyst.collector.daos;

import java.util.ArrayList;
import java.util.List;

import com.catalyst.collector.entities.Age;
import com.catalyst.collector.entities.TestData;

public interface CollectionsDao {

	public List<TestData> getTestData();
	public void addAge(String age);

	/**
	 * Gets an ArrayList of age types from the database
	 * @return
     */
	ArrayList<Age> getAgeTypes();

	/**
	 * Updates an age type in the database
	 * @param age
     */
	void updateAge(Age age);

	/**
	 * Deletes an age type from the database
	 * @param age
     */
	void deleteAge(Age age);
}
