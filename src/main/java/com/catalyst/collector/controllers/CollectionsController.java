package com.catalyst.collector.controllers;

import java.util.ArrayList;
import java.util.List;

import com.catalyst.collector.entities.Age;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catalyst.collector.entities.TestData;
import com.catalyst.collector.services.CollectionsService;

@RestController
public class CollectionsController {

	@Autowired
	private CollectionsService testDataService;
	
	
	public void setTestDataService(CollectionsService testDataService) {
		this.testDataService = testDataService;
	}


	@RequestMapping(value="testdata", method=RequestMethod.GET)
	public List<TestData> getTestData() {
		return testDataService.getTestData();
	}

	@RequestMapping(value="agetypes", method=RequestMethod.GET)
	public ArrayList<Age> getAgeTypes(){return testDataService.getAgeTypes();}

	@RequestMapping(value="/agetypes", method=RequestMethod.POST)
	public void addAge(@RequestBody String age){testDataService.addAge(age);}
}
