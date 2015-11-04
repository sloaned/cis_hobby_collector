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

import com.catalyst.collector.entities.Collections;
import com.catalyst.collector.entities.Color;
import com.catalyst.collector.services.CollectionsServices;

@RestController
public class TestDataController {

	@Autowired
	private CollectionsServices collectionService;
	
	
	public void setTestDataService(CollectionsServices testDataService) {
		this.collectionService = testDataService;
	}


	@RequestMapping(value="/color", method=RequestMethod.GET)
	public List<Color> getColorList() {
		return collectionService.getColorList();
	}
	@RequestMapping(value="/color{colorType}", method=RequestMethod.DELETE)
	public boolean removeColor(@PathVariable String colorType) {
		return collectionService.removeColor(colorType);
	}
	@RequestMapping(value="/color", method=RequestMethod.POST)
	public void addColor(@RequestBody Color c) {
		collectionService.addColor(c);
	}
	@RequestMapping(value="/color", method=RequestMethod.POST)
	public boolean getTestData(@PathVariable int id, @RequestParam(value="color",required=true)String color) {
		return collectionService.updateColor(id, color);
	}
	
}
