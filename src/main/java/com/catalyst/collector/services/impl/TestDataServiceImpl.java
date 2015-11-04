package com.catalyst.collector.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.catalyst.collector.entities.Keyword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.collector.daos.TestDataDao;
import com.catalyst.collector.entities.TestData;
import com.catalyst.collector.services.TestDataService;

@Service
public class TestDataServiceImpl implements TestDataService {

	@Autowired
	TestDataDao testDataDao;


	public void setTestDataDao(TestDataDao testDataDao) {
		this.testDataDao = testDataDao;
	}


    @Override
    public ArrayList<Keyword> getAllKeywords() {
        return testDataDao.getAllKeywords();
    }

    @Override
    public boolean addKeyword(Keyword keyword) {
        if (keyword.getWord().length() < 1 || keyword.getWord().length() > 255)
            return false;

        testDataDao.addKeyword(keyword);
        return true;
    }

    @Override
    public Keyword getKeyword(Integer id) {
        return testDataDao.getKeyword(id);
    }

    @Override
    public void removeKeyword(Integer id) {
        testDataDao.removeKeyword(id);
    }
}
