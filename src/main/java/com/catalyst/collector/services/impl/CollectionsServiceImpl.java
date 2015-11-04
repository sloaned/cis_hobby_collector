package com.catalyst.collector.services.impl;

import java.util.ArrayList;

import com.catalyst.collector.entities.Keyword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.collector.daos.CollectionsDao;
import com.catalyst.collector.services.CollectionsService;

@Service
public class CollectionsServiceImpl implements CollectionsService {

	@Autowired
    CollectionsDao collectionsDao;


	public void setCollectionsDao(CollectionsDao collectionsDao) {
		this.collectionsDao = collectionsDao;
	}


    @Override
    public ArrayList<Keyword> getAllKeywords() {
        return collectionsDao.getAllKeywords();
    }

    @Override
    public boolean addKeyword(Keyword keyword) {
        if (keyword.getWord().length() < 1 || keyword.getWord().length() > 255)
            return false;

        collectionsDao.addKeyword(keyword);
        return true;
    }

    @Override
    public boolean updateKeyword(Keyword keyword) {
        if (keyword.getWord() == null || keyword.getWord().equals("") || keyword.getWord().length() > 255)
            return false;
        collectionsDao.updateKeyword(keyword);
        return true;
    }

    @Override
    public void removeKeyword(Integer id) {
        collectionsDao.removeKeyword(id);
    }
}
