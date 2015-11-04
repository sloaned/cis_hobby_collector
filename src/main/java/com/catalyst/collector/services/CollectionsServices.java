package com.catalyst.collector.services;

import java.util.List;

import com.catalyst.collector.entities.Color;

public interface CollectionsServices {
	
	public List<CollectionsServices> getCollection();
	
	public List<Color> getColorList();
	public void addColor(Color addedColor);
	public boolean removeColor(String color);
	public boolean updateColor(int id, String color);	
}
