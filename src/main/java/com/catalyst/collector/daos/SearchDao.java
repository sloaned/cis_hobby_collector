package com.catalyst.collector.daos;

import com.catalyst.collector.entities.Collectible;
import com.catalyst.collector.entities.Search;

import java.util.ArrayList;

/**
 * Created by gfisher on 11/16/2015.
 */
public interface SearchDao {
    ArrayList<Collectible> search(Search searchBody);
}
