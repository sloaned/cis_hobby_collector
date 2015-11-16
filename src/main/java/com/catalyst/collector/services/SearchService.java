package com.catalyst.collector.services;

import com.catalyst.collector.entities.Collectible;
import com.catalyst.collector.entities.Search;

import java.util.ArrayList;

/**
 * Created by gfisher on 11/16/2015.
 */
public interface SearchService {
    ArrayList<Collectible> search(Search searchBody);
}
