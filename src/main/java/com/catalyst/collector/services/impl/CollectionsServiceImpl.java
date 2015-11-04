package com.catalyst.collector.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.collector.daos.CollectionsDao;
import com.catalyst.collector.entities.Collections;
import com.catalyst.collector.entities.Color;
import com.catalyst.collector.services.CollectionsServices;

@Service
public class CollectionsServiceImpl implements CollectionsServices {

	@Autowired
	CollectionsDao collectionDao;
	
	
	public void setCollectionDao(CollectionsDao testDataDao) {
		this.collectionDao = testDataDao;
	}
	
	
	@Override
	public List<Color> getColorList() {
		return collectionDao.getColorList();
	}
	@Override
	public void addColor(Color addedColor) {
		collectionDao.addColor(addedColor);
	}
	@Override
	public boolean removeColor(String color) {
		
		Color removedColor =getColor(color);
		collectionDao.removeColor(removedColor);
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
		collectionDao.updateColor(c);
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
	public List<CollectionsServices> getCollection() {
		// TODO Auto-generated method stub
		return null;
	}
}
