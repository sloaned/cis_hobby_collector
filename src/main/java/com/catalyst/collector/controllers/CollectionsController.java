package com.catalyst.collector.controllers;

import java.util.ArrayList;

import com.catalyst.collector.entities.Keyword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.catalyst.collector.services.CollectionsService;

@RestController
public class CollectionsController {

	@Autowired
	private CollectionsService collectionsService;
	
	
	public void setCollectionsService(CollectionsService collectionsService) {
		this.collectionsService = collectionsService;
	}

    @RequestMapping(value="/keywords", method = RequestMethod.GET)
    public ArrayList<Keyword> getAllKeywords() {
        return collectionsService.getAllKeywords();
    }

    @RequestMapping(value="/keywords", method = RequestMethod.POST)
    public ResponseEntity<Keyword> addKeyword(@RequestBody Keyword keyword) {
        if (!collectionsService.addKeyword(keyword))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(keyword, HttpStatus.OK);
    }

    @RequestMapping(value="/keyword/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Keyword> updateKeyword(@PathVariable Integer id, @RequestBody Keyword keyword) {
        keyword.setId(id);
        if (!collectionsService.updateKeyword(keyword))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(keyword, HttpStatus.OK);
    }

    @RequestMapping(value="/keyword/{id}", method = RequestMethod.DELETE)
    public void deleteKeyword(@PathVariable Integer id) {
        collectionsService.removeKeyword(id);
    }
}
