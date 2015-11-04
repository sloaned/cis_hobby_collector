package com.catalyst.collector.controllers;

import java.util.ArrayList;

import com.catalyst.collector.entities.Collectible;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catalyst.collector.services.CollectionService;

@RestController
public class TestDataController {

	@Autowired
	private CollectionService collectionService;
	
	
	public void setTestDataService(CollectionService collectionService) {
		this.collectionService = collectionService;
	}


	@RequestMapping(value="/collectible/{id}", method=RequestMethod.GET)
	public ResponseEntity<Collectible> getCollectible(@PathVariable Integer id) {
		return new ResponseEntity<>(collectionService.getCollectible(id.intValue()), HttpStatus.OK);
	}

	@RequestMapping(value="/collectibles", method=RequestMethod.GET)
	public ArrayList<Collectible> getCollectible() {
		return collectionService.getCollectibles();
	}

}
