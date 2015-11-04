package com.catalyst.collector.controllers;

import java.util.ArrayList;
import java.util.List;

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
	
	
	public void setcollectionsService(CollectionsService collectionsService) {
		this.collectionsService = collectionsService;
	}

	@RequestMapping(value="/collections", method=RequestMethod.GET)
	public ArrayList<Category> getCategory(){
		return collectionsService.getCategory();
	}
	
	@RequestMapping(value="/collections", method=RequestMethod.POST)
	public void addCategory(@RequestBody Category category){
		collectionsService.addCategory(category);
	}
	
	@RequestMapping(value="/collections", method=RequestMethod.PUT)
	public void updateCategory(@RequestBody Category category){
		collectionsService.updateCategory(category);
	}
	
	@RequestMapping(value="/collections", method=RequestMethod.DELETE)
	public void deleteCategory(@PathVariable Integer id){
		collectionsService.deleteCategory(id);
	}
	
	
}
