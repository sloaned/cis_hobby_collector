package com.catalyst.collector.services;

import java.util.ArrayList;
import java.util.List;

import com.catalyst.collector.entities.Keyword;
import com.catalyst.collector.entities.TestData;

public interface TestDataService {
	
	public List<TestData> getTestData();
    public ArrayList<Keyword> getAllKeywords();
}
