package com.catalyst.collector.services.impl;

import com.catalyst.collector.daos.SearchDao;
import com.catalyst.collector.entities.Collectible;
import com.catalyst.collector.entities.Search;
import com.catalyst.collector.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by gfisher on 11/16/2015.
 */
@Service
public class SearchServiceImpl implements SearchService{

    @Autowired
    SearchDao searchDao;
    public void setSearchDao(SearchDao searchDao){
        this.searchDao = searchDao;
    }

    @Override
    public ArrayList<Collectible> search(Search searchBody) {
        return searchDao.search(searchBody);
    }

}
