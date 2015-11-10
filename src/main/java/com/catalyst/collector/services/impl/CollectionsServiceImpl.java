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
	@Autowired
	private CollectionValidation collectionValidation;

	public void setCollectionValidation(CollectionValidation collectionValidation) {
		this.collectionValidation = collectionValidation;
	}

	@Override
	public ArrayList<Age> getAgeTypes(){
		return collectionsDao.getAgeTypes();
	}

	@Override
	public void addAge(Age age) {
		if(collectionValidation.isAgeValid(age)) { //Maximum of 255 characters for an age, no digits allowed
			collectionsDao.addAge(age);
		}
	}

	@Override
	public void updateAge(Age age){
		if(collectionValidation.isAgeValid(age)) { //Maximum of 255 characters for an age, no digits allowed
            if (age.getAge() == null || (age.getId() == null || age.getId() < 1))
                return;
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
		if(collectionValidation.isCategoryValid(category))
		{
			return collectionsDao.addCategory(category);
		}
		return false;
	}

	@Override
	public boolean updateCategory(int id, Category category) {

		if(collectionValidation.isCategoryValid(category))
		{
			return collectionsDao.updateCategory(category);
		}
		return false;
	}

	@Override
	public boolean deleteCategory(int id) {
		if(id<1)
		{
			return false;
		}
		return collectionsDao.deleteCategory(id);
	}

	@Override
	public List<Color> getColorList() {
		return collectionsDao.getColorList();
	}
	@Override
	public boolean addColor(Color addedColor) {
		 if (collectionValidation.isColorValid(addedColor))
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
		if (collectionValidation.isColorValid(c))
			return collectionsDao.updateColor(c);
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
    public ArrayList<Keyword> getKeywordsByLetter(String letter){
    	return collectionsDao.getKeywordsByLetter(letter);
    }

    @Override
    public boolean addKeyword(Keyword keyword) {
        if (collectionValidation.isKeywordValid(keyword)){
			collectionsDao.addKeyword(keyword);
			return true;
		}
            return false;

    }

    @Override
    public boolean updateKeyword(Keyword keyword) {
		if (collectionValidation.isKeywordValid(keyword)){
            if (keyword.getKeyword() == null || keyword.getId() == null || keyword.getId() < 1){
                return false;
			}
			collectionsDao.updateKeyword(keyword);
			return true;
		}
		return false;
    }

    @Override
    public void removeKeyword(Integer id) {
        if (id < 0)
            return;
        collectionsDao.removeKeyword(id);
    }

	@Override
	public boolean addCollectible(Collectible collectible) {
		collectionValidation.setCollectible(collectible);
		if(collectionValidation.isCollectibleValid()) {
			collectionsDao.addCollectible(collectible);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateCollectible(Collectible collectible) {
		collectionValidation.setCollectible(collectible);
		if(collectionValidation.isCollectibleValid()) {
            collectionsDao.addCollectible(collectible);
            return true;
        }
        return false;
	}

    @Override
    public ArrayList<Condition> getAllConditions() {
        return collectionsDao.getAllConditions();
    }

    @Override
    public boolean addCondition(Condition condition) {
        if (collectionValidation.isConditionValid(condition)) {
			collectionsDao.addCondition(condition);
			return true;
		}
        return false;
    }

    @Override
    public boolean updateCondition(Condition condition) {
		if (collectionValidation.isConditionValid(condition)) {
            if (condition.getCondition() == null || (condition.getId() == null || condition.getId() < 1))
                return false;
			collectionsDao.updateCondition(condition);
			return true;
		}
		return false;
    }

    @Override
    public void deleteCondition(Integer id) {
        if (id < 0)
            return;
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
