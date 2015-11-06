package com.catalyst.collector.controllers;

import java.util.ArrayList;
import java.util.List;

import com.catalyst.collector.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.catalyst.collector.entities.Category;
import com.catalyst.collector.entities.Collectible;
import com.catalyst.collector.entities.Color;
import com.catalyst.collector.entities.Keyword;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.catalyst.collector.services.CollectionsService;

@RestController
public class CollectionsController {

	@Autowired
	private CollectionsService collectionsService;
	
	
	public void setCollectionsService(CollectionsService collectionsService) {
		this.collectionsService = collectionsService;
	}

	@RequestMapping(value="/collectible/{id}", method=RequestMethod.GET)
	public ResponseEntity<Collectible> getCollectible(@PathVariable Integer id) {
		return new ResponseEntity<>(collectionsService.getCollectible(id.intValue()), HttpStatus.OK);
	}

	@RequestMapping(value="/collectibles", method=RequestMethod.GET)
	public ArrayList<Collectible> getCollectible() {
		return collectionsService.getCollectibles();
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
	
	@RequestMapping(value="/collectible", method=RequestMethod.POST)
	public void addCollectible(@RequestBody Collectible collectible){
		collectionsService.addCollectible(collectible);
	}

	@RequestMapping(value="/collectible", method=RequestMethod.PUT)
	public void updateCollectible(@RequestBody Collectible collectible){
		collectionsService.updateCollectible(collectible);
	}

	@RequestMapping(value="/category", method=RequestMethod.GET)
	public ArrayList<Category> getCategory(){
		return collectionsService.getCategory();
	}

	@RequestMapping(value="/category", method=RequestMethod.POST)
	public boolean addCategory(@RequestBody Category category){
		return collectionsService.addCategory(category);
	}

	@RequestMapping(value="/category/{id}", method=RequestMethod.PUT)
	public boolean updateCategory(@PathVariable Integer id, @RequestBody Category category){
		return collectionsService.updateCategory(id, category);
	}

	@RequestMapping(value="/category/{id}", method=RequestMethod.DELETE)
	public boolean deleteCategory(@PathVariable Integer id){
		return collectionsService.deleteCategory(id);
	}

	@RequestMapping(value="/color", method=RequestMethod.GET)
	public List<Color> getColorList() {
		return collectionsService.getColorList();
	}
	@RequestMapping(value="/color/{id}", method=RequestMethod.DELETE)
	public boolean removeColor(@PathVariable Integer id) {
		return collectionsService.removeColor(id);
	}
	@RequestMapping(value="/color", method=RequestMethod.POST)
	public void addColor(@RequestBody Color c) {
		collectionsService.addColor(c);
	}
	@RequestMapping(value="/color/{id}", method=RequestMethod.PUT)
	public boolean updateColor(@PathVariable Integer id, @RequestBody String color) {
		return collectionsService.updateColor(id, color);
	}
	@RequestMapping(value="/color/{id}", method=RequestMethod.GET)
	public Color getColor(@PathVariable Integer id){
		return collectionsService.getColor(id);
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

    @RequestMapping(value="/conditions", method = RequestMethod.GET)
    public ArrayList<Condition> getAllConditions() {
        return collectionsService.getAllConditions();
    }

    @RequestMapping(value = "/conditions", method = RequestMethod.POST)
    public ResponseEntity<Condition> addCondition(@RequestBody Condition condition) {
        if (!collectionsService.addCondition(condition))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        return new ResponseEntity<Condition>(condition, HttpStatus.OK);
    }

    @RequestMapping(value = "/condition/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Condition> updateCondition(@PathVariable Integer id, @RequestBody Condition condition) {
        condition.setId(id);
        if (!collectionsService.updateCondition(condition))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(condition, HttpStatus.OK);
    }

    @RequestMapping(value = "/condition/{id}", method = RequestMethod.DELETE)
    public void deleteCondition(@PathVariable Integer id) {
        collectionsService.deleteCondition(id);
    }
}
