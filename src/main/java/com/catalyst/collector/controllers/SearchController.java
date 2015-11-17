package com.catalyst.collector.controllers;

import com.catalyst.collector.entities.Collectible;
import com.catalyst.collector.entities.Condition;
import com.catalyst.collector.entities.Search;
import com.catalyst.collector.services.CollectionsService;
import com.catalyst.collector.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Created by gfisher on 11/16/2015.
 */
@RestController
public class SearchController {

    @Autowired
    private SearchService searchService;

    public void setSearchService(SearchService searchService) {
        this.searchService = searchService;
    }

    @RequestMapping(value="/collectibles/{search}", method = RequestMethod.GET)
    public ArrayList<Collectible> search(@RequestParam Search search) {
        return searchService.search(search);
    }

}
