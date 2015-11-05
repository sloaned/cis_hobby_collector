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
	public void addAge(Age age) {
		collectionsDao.addAge(age);
	}

	@Override
	public ArrayList<Age> getAgeTypes(){
		return collectionsDao.getAgeTypes();
	}

	@Override
	public void updateAge(Age age){
		collectionsDao.updateAge(age);
	}

	@Override
	public void deleteAge(Integer id) {
		collectionsDao.deleteAge(id);
	}
	public ArrayList<Category> getCategory() {

		return collectionsDao.getCategory();
	}


	@Override
	public boolean addCategory(Category category) {
		return collectionsDao.addCategory(category);

	}


	@Override
	public boolean updateCategory(int id, Category category) {
		category.setId(id);
		return collectionsDao.updateCategory(category);
	}

	@Override
	public boolean deleteCategory(int id) {
		return collectionsDao.deleteCategory(id);

	}


	@Override
	public List<Color> getColorList() {
		return collectionsDao.getColorList();
	}
	@Override
	public boolean addColor(Color addedColor) {
		try{
			collectionsDao.addColor(addedColor);
		}
		catch(Exception e){
			return false;
		}
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
	public Color getByColorId(int colorId){
		return collectionsDao.getColor(colorId);

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
