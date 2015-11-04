package com.catalyst.collector.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.catalyst.collector.entities.Category;
import com.catalyst.collector.entities.Color;
import com.catalyst.collector.services.CollectionsService;

@RestController
public class CollectionsController {

	@Autowired
	private CollectionsService collectionsService;
	
	
	public void setCollectionsService(CollectionsService collectionsService) {
		this.collectionsService = collectionsService;
	}

	@RequestMapping(value="/category", method=RequestMethod.GET)
	public ArrayList<Category> getCategory(){
		return collectionsService.getCategory();
	}
	
	@RequestMapping(value="/category", method=RequestMethod.POST)
	public void addCategory(@RequestBody Category category){
		collectionsService.addCategory(category);
	}
	
	@RequestMapping(value="/category/{id}", method=RequestMethod.PUT)
	public void updateCategory(@PathVariable Integer id, @RequestBody Category category){
		collectionsService.updateCategory(id, category);
	}
	
	@RequestMapping(value="/category/{id}", method=RequestMethod.DELETE)
	public void deleteCategory(@PathVariable Integer id){
		collectionsService.deleteCategory(id);
	}
	
	@RequestMapping(value="/color", method=RequestMethod.GET)
	public List<Color> getColorList() {
		return collectionsService.getColorList();
	}
	@RequestMapping(value="/color{colorType}", method=RequestMethod.DELETE)
	public boolean removeColor(@PathVariable String colorType) {
		return collectionsService.removeColor(colorType);
	}
	@RequestMapping(value="/color", method=RequestMethod.POST)
	public void addColor(@RequestBody Color c) {
		collectionsService.addColor(c);
	}
	@RequestMapping(value="/color", method=RequestMethod.PUT)
	public boolean updateColor(@PathVariable int id, @RequestParam(value="color",required=true)String color) {
		return collectionsService.updateColor(id, color);
	}
	
	
}
