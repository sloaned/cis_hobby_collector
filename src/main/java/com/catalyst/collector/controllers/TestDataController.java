package com.catalyst.collector.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catalyst.collector.entities.Collections;
import com.catalyst.collector.services.Collections;

@RestController
public class TestDataController {

	@Autowired
	private Collections collectionService;
	
	
	public void setTestDataService(Collections testDataService) {
		this.collectionService = testDataService;
	}


	@RequestMapping(value="testdata", method=RequestMethod.GET)
	public List<Collections> getTestData() {
		return Service.getTestData();
	}
	
	@RequestMapping(value="/color", method=RequestMethod.GET)
	public List<Collections> getColorList() {
		return collectionService.getColorList();
	}
	@RequestMapping(value="/color{colorType}", method=RequestMethod.DELETE)
	public boolean removeColor(@PathVariable String colorType) {
		return collectionService.removeColor(colorType);
	}
	@RequestMapping(value="testdata", method=RequestMethod.GET)
	public List<Collections> getTestData() {
		return Service.getTestData();
	}
	@RequestMapping(value="testdata", method=RequestMethod.GET)
	public List<Collections> getTestData() {
		return Service.getTestData();
	}
	
}
