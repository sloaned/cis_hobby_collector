package com.catalyst.collector.services.impl;

import java.util.ArrayList;

import java.util.List;
import com.catalyst.collector.entities.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.catalyst.collector.daos.CollectionsDao;
import com.catalyst.collector.entities.Color;
import com.catalyst.collector.entities.Category;
import com.catalyst.collector.entities.Keyword;
import com.catalyst.collector.entities.Collectible;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.catalyst.collector.daos.CollectionsDao;
import java.util.List;

import com.catalyst.collector.entities.Age;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.collector.daos.CollectionsDao;
import com.catalyst.collector.services.CollectionsService;

@Service
public class CollectionsServiceImpl implements CollectionsService {

	@Autowired
	CollectionsDao collectionsDao;


	public void setcollectionsDao(CollectionsDao collectionsDao) {}


	public void setCollectionsDao(CollectionsDao collectionsDao) {
		this.collectionsDao = collectionsDao;
	}



	@Override
	public ArrayList<Age> getAgeTypes(){
		return collectionsDao.getAgeTypes();
	}

	@Override
	public boolean addAge(Age age) {
		String ageString = age.getAge();
		if(ageString.length() <= 255 && !ageString.matches(".*\\d.*")) { //Maximum of 255 characters for an age, no digits allowed
			collectionsDao.addAge(age);
			return true;
		}
		return false;
	}


	@Override
	public boolean updateAge(Age age){
		String ageString = age.getAge();
		if(ageString.length() <= 255 && !ageString.matches(".*\\d.*")) { //Maximum of 255 characters for an age, no digits allowed
			collectionsDao.updateAge(age);
			return true;
		}
		return false;

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
	public void addCategory(Category category) {
		collectionsDao.addCategory(category);

	}


	@Override
	public void updateCategory(int id, Category category) {
		category.setId(id);
		collectionsDao.updateCategory(category);
	}




	@Override
	public List<Color> getColorList() {
		return collectionsDao.getColorList();
	}
	@Override
	public void addColor(Color addedColor) {
		collectionsDao.addColor(addedColor);
	}
	@Override
	public boolean removeColor(String color) {
		//to do: try catch implementation
		//to-do take object color, not string
		Color removedColor =getColor(color);
		collectionsDao.removeColor(removedColor);
		return true;
	}
	public Color getColor(String color){
		List<Color> colors = getColorList();
		for(Color c: colors){
			if(c.getColor().equals(color)){
				return c;
			}
		}
		return null;

	}
	@Override
	public boolean updateColor(int id, String color){
		try{
		Color c = getColor(id);
		c.setColor(color);
		collectionsDao.updateColor(c);
		}
		catch(Exception e){
			return false;
			}
		return true;
	}
	public Color getColor(int id){
		List<Color> colors = getColorList();
		for(Color c: colors){
			if(c.getId() == id){
				return c;
			}
		}
		return null;

	}


	@Override
	public void deleteCategory(int id) {
		collectionsDao.deleteCategory(id);

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

	@Override
	public ArrayList<Collectible> getCollectibles() {
		return collectionsDao.getCollectibles();
	}

	@Override
	public Collectible getCollectible(Integer id) {
		return collectionsDao.getCollectible(id);
	}

}
