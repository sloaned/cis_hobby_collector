package com.catalyst.collector.services.impl;

import com.catalyst.collector.daos.SearchDao;
import com.catalyst.collector.entities.Search;
import com.catalyst.collector.services.SearchService;

/**
 * Created by gfisher on 11/16/2015.
 */
public class SearchServiceImpl implements SearchService{

    SearchDao searchDao;
    public void setSearchDao(SearchDao searchDao){
        this.searchDao = searchDao;
    }

    @Override
    public void search(Search searchBody) {
        searchDao.search(searchBody);
    }
}
