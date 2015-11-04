package com.catalyst.collector.controllers;

import java.util.ArrayList;
import java.util.List;
import com.catalyst.collector.entities.Collectible;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.catalyst.collector.entities.Category;
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
	public void addCategory(@RequestBody Category category){
		collectionsService.addCategory(category);
	}

	@RequestMapping(value="/category/{id}", method=RequestMethod.PUT)
	public void updateCategory(@PathVariable Integer id, @RequestBody Category category){
		collectionsService.updateCategory(id, category);
	}

	@RequestMapping(value="/category/{id}", method=RequestMethod.DELETE)
	public void deleteCategory(@PathVariable Integer id){
		collectionsService.deleteCategory(id);
	}

	@RequestMapping(value="/color", method=RequestMethod.GET)
	public List<Color> getColorList() {
		return collectionsService.getColorList();
	}
	@RequestMapping(value="/color{colorType}", method=RequestMethod.DELETE)
	public boolean removeColor(@PathVariable String colorType) {
		return collectionsService.removeColor(colorType);
	}
	@RequestMapping(value="/color", method=RequestMethod.POST)
	public void addColor(@RequestBody Color c) {
		collectionsService.addColor(c);
	}
	@RequestMapping(value="/color", method=RequestMethod.PUT)
	public boolean updateColor(@PathVariable int id, @RequestParam(value="color",required=true)String color) {
		return collectionsService.updateColor(id, color);
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
