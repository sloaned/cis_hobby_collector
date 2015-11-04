package com.catalyst.collector.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catalyst.collector.entities.Category;
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
	
	@RequestMapping(value="/category", method=RequestMethod.PUT)
	public void updateCategory(@RequestBody Category category){
		collectionsService.updateCategory(category);
	}
	
	@RequestMapping(value="/category", method=RequestMethod.DELETE)
	public void deleteCategory(@PathVariable Integer id){
		collectionsService.deleteCategory(id);
	}
	
	
}
