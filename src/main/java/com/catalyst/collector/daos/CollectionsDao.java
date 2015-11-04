package com.catalyst.collector.daos;

import java.util.List;

import com.catalyst.collector.entities.Color;

public interface CollectionsDao {

	
	public void addColor(Color addedColor); 
	public boolean removeColor(Color c);
	public List<Color> getColorList();
	public void updateColor(Color c);
}
