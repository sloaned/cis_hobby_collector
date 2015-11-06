package com.catalyst.collector.services.impl;

import java.util.ArrayList;

import java.util.List;

import com.catalyst.collector.entities.*;
import com.catalyst.collector.services.CollectionValidation;
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
	public ArrayList<Age> getAgeTypes(){
		return collectionsDao.getAgeTypes();
	}

	@Override
	public void addAge(Age age) {
		String ageString = age.getAge();
		if(CollectionValidation.isAgeValid(ageString)) { //Maximum of 255 characters for an age, no digits allowed
			collectionsDao.addAge(age);
		}
	}


	@Override
	public void updateAge(Age age){
		String ageString = age.getAge();
		if(CollectionValidation.isAgeValid(ageString)) { //Maximum of 255 characters for an age, no digits allowed
			collectionsDao.updateAge(age);
		}

	}

	@Override
	public boolean deleteAge(Integer id) {
		if(id > 0) {
			collectionsDao.deleteAge(id);
			return true;
		}
		return false;
	}


	public ArrayList<Category> getCategory() {

		return collectionsDao.getCategory();
	}


	@Override
	public boolean addCategory(Category category) {
		if(CollectionValidation.isCategoryValid(category.getCategory()))
			return collectionsDao.addCategory(category);
		return false;
	}


	@Override
	public boolean updateCategory(int id, Category category) {
		category.setId(id);
		if(CollectionValidation.isCategoryValid(category.getCategory()))
			return collectionsDao.addCategory(category);
		return false;
	}

	@Override
	public boolean deleteCategory(int id) {
		if(id > 0)
		{
			return collectionsDao.deleteCategory(id);
		}
		return false;
	}

	@Override
	public List<Color> getColorList() {
		return collectionsDao.getColorList();
	}
	@Override
	public boolean addColor(Color addedColor) {
		 if (CollectionValidation.isColorValid(addedColor.getColor()))
			 return collectionsDao.addColor(addedColor);
		return false;
		}
	@Override
	public boolean removeColor(int id) {
		try{
		collectionsDao.removeColor(id);
		}
		catch(Exception e){
			return false;
		}
		return true;
	}

	@Override
	public boolean updateColor(Color c){
		if (CollectionValidation.isColorValid(c.getColor()))
			return collectionsDao.addColor(c);
		return false;
	}
	public Color getColor(int id){
		return collectionsDao.getColor(id);

	}

    @Override
    public ArrayList<Keyword> getAllKeywords() {
        return collectionsDao.getAllKeywords();
    }

    @Override
    public ArrayList<Keyword> getKeywordsByLetter(char letter){
    	return collectionsDao.getKeywordsByLetter(letter);
    }

    @Override
    public boolean addKeyword(Keyword keyword) {
        if (CollectionValidation.isKeywordValid(keyword.getKeyword())){
			collectionsDao.addKeyword(keyword);
			return true;
		}
            return false;

    }

    @Override
    public boolean updateKeyword(Keyword keyword) {
		if (CollectionValidation.isKeywordValid(keyword.getKeyword())){
			collectionsDao.addKeyword(keyword);
			return true;
		}
		return false;
    }

    @Override
    public void removeKeyword(Integer id) {
        collectionsDao.removeKeyword(id);
    }

	@Override
	public boolean addCollectible(Collectible collectible) {
		CollectionValidation cv = new CollectionValidation(collectible);
		if(cv.isCollectibleValid()) {
			collectionsDao.addCollectible(collectible);
			return true;
		}
		return false;
	}

	@Override
	public void updateCollectible(Collectible collectible) {
		CollectionValidation cv = new CollectionValidation(collectible);
		if(cv.isCollectibleValid())
			collectionsDao.addCollectible(collectible);

	}

    @Override
    public ArrayList<Condition> getAllConditions() {
        return collectionsDao.getAllConditions();
    }

    @Override
    public boolean addCondition(Condition condition) {
        if (CollectionValidation.isConditionValid(condition.getCondition())) {
			collectionsDao.addCondition(condition);
			return true;
		}
        return false;
    }

    @Override
    public boolean updateCondition(Condition condition) {
		if (CollectionValidation.isConditionValid(condition.getCondition())) {
			collectionsDao.addCondition(condition);
			return true;
		}
		return false;
    }

    @Override
    public void deleteCondition(Integer id) {
        collectionsDao.deleteCondition(id);
    }

    @Override
	public ArrayList<Collectible> getCollectibles() {
		return collectionsDao.getCollectibles();
	}

	@Override
	public Collectible getCollectible(Integer id) {
		return collectionsDao.getCollectible(id);
	}

	@Override
	public boolean removeCollectible(int id) {
		return collectionsDao.removeCollectible(id);
	}

}
