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


	public void setcollectionsDao(CollectionsDao collectionsDao) {
		this.collectionsDao = collectionsDao;
	}


	@Override
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

}
