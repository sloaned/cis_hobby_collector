package com.catalyst.collector.controllers;

import java.util.ArrayList;
import java.util.List;

import com.catalyst.collector.entities.Age;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.catalyst.collector.entities.TestData;
import com.catalyst.collector.services.CollectionsService;

@RestController
public class CollectionsController {

	@Autowired
	private CollectionsService collectionsService;
	
	
	public void setCollectionsService(CollectionsService collectionsService) {
		this.collectionsService = collectionsService;
	}


	@RequestMapping(value="testdata", method=RequestMethod.GET)
	public List<TestData> getTestData() {
		return collectionsService.getTestData();
	}

	@RequestMapping(value="/agetypes", method=RequestMethod.GET)
	public ArrayList<Age> getAgeTypes(){return collectionsService.getAgeTypes();}

	@RequestMapping(value="/agetypes", method=RequestMethod.POST)
	public void addAge(@RequestBody Age age){
		collectionsService.addAge(age);}

	@RequestMapping(value="/agetypes/{id}", method=RequestMethod.PUT)
	public void updateAge(@PathVariable Integer id, @RequestBody Age age){
		age.setAge_id(id);
		collectionsService.updateAge(age);}

	@RequestMapping(value="/agetypes/{id}", method=RequestMethod.DELETE)
	public void deleteAge(@PathVariable Integer id){
		collectionsService.deleteAge(id);}
}
