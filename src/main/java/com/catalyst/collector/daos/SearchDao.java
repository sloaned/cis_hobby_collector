package com.catalyst.collector.daos;

import com.catalyst.collector.entities.Collectible;
import com.catalyst.collector.entities.Search;

import java.util.ArrayList;

/**
 * Created by gfisher on 11/16/2015.
 */

public interface SearchDao {
    /**
     * @param searchBody contains strings for each field they want to filter by.
     * @return an Array List of collectibles meeting the search criteria
     */
    ArrayList<Collectible> search(Search searchBody);
}
