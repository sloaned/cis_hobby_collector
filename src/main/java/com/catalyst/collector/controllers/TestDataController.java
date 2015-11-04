package com.catalyst.collector.controllers;

import java.util.ArrayList;
import java.util.List;

import com.catalyst.collector.entities.Keyword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.QueryLookupStrategy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.catalyst.collector.entities.TestData;
import com.catalyst.collector.services.TestDataService;

@RestController
public class TestDataController {

	@Autowired
	private TestDataService testDataService;
	
	
	public void setTestDataService(TestDataService testDataService) {
		this.testDataService = testDataService;
	}

    @RequestMapping(value="/keywords", method = RequestMethod.GET)
    public ArrayList<Keyword> getAllKeywords() {
        return testDataService.getAllKeywords();
    }

    @RequestMapping(value="/keywords", method = RequestMethod.POST)
    public ResponseEntity<Keyword> addKeyword(@RequestBody Keyword keyword) {
        if (!testDataService.addKeyword(keyword))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(keyword, HttpStatus.OK);
    }

    @RequestMapping(value="/keyword/{id}", method = RequestMethod.PUT)
    public Keyword getKeyword(@PathVariable Integer id) {
        return testDataService.getKeyword(id);
    }
}
