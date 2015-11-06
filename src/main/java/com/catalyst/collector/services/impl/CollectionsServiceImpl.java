package com.catalyst.collector.services.impl;

import java.util.ArrayList;

import java.util.List;

import com.catalyst.collector.entities.*;
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
		if(ageString != null && ageString.length() <= 255 && !ageString.matches(".*\\d.*") && !ageString.trim().equals("")) { //Maximum of 255 characters for an age, no digits allowed
			collectionsDao.addAge(age);
		}
	}


	@Override
	public void updateAge(Age age){
		String ageString = age.getAge();
		if(ageString != null && ageString.length() <= 255 && !ageString.matches(".*\\d.*") && !ageString.trim().equals("")) { //Maximum of 255 characters for an age, no digits allowed
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
		if(category.getCategory() == null || ((category.getCategory()).trim()).equals("")|| category.getCategory().matches(".*\\d.*"))
		{
			return false;
		}
		if((category.getCategory()).length() > 255)
		{
			return false;
		}
		return collectionsDao.addCategory(category);

	}


	@Override
	public boolean updateCategory(int id, Category category) {

		category.setId(id);
		if(category.getCategory() == null || ((category.getCategory()).trim()).equals("")  || category.getCategory().matches(".*\\d.*"))
		{
			return false;
		}
		if((category.getCategory()).length() > 255 || category.getId()<1)
		{
			return false;
		}
		return collectionsDao.updateCategory(category);
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
		 if (addedColor.getColor() == null || addedColor.getColor().trim().equals("") || addedColor.getColor().length() > 255){
	            return false;
		 }
		collectionsDao.addColor(addedColor);
		return true;
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
		 if (c.getColor() == null || c.getColor().trim().equals("") || c.getColor().length() > 255){
	            return false;
		 }
		collectionsDao.updateColor(c);
		return true;
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
        if (!keyword.isValid())
            return false;

        collectionsDao.addKeyword(keyword);
        return true;
    }

    @Override
    public boolean updateKeyword(Keyword keyword) {
        if (!keyword.isValid())
            return false;
        collectionsDao.updateKeyword(keyword);
        return true;
    }

    @Override
    public void removeKeyword(Integer id) {
        if (id < 0)
            return;
        collectionsDao.removeKeyword(id);
    }

	@Override
	public boolean addCollectible(Collectible collectible) {
		collectionsDao.addCollectible(collectible);
		return true;
	}

	@Override
	public void updateCollectible(Collectible collectible) {
		collectionsDao.updateCollectible(collectible);
	}

    @Override
    public ArrayList<Condition> getAllConditions() {
        return collectionsDao.getAllConditions();
    }

    @Override
    public boolean addCondition(Condition condition) {
        if (condition.getCondition() == null || condition.getCondition().equals("") || condition.getCondition().length() > 255)
            return false;
        collectionsDao.addCondition(condition);
        return true;
    }

    @Override
    public boolean updateCondition(Condition condition) {
        if (condition.getCondition() == null || condition.getCondition().equals("") || condition.getCondition().length() > 255)
            return false;
        collectionsDao.updateCondition(condition);
        return true;
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
