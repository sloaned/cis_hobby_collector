package com.catalyst.collector.services.impl;

import com.catalyst.collector.daos.hibernate.SearchDaoHibernate;
import com.catalyst.collector.daos.hibernate.UserDaoHibernate;
import com.catalyst.collector.entities.Collectible;
import com.catalyst.collector.entities.Search;
import com.catalyst.collector.entities.Username;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by gfisher on 11/17/2015.
 */
public class SearchServiceImplTest {

        SearchServiceImpl searchServiceImpl;
        SearchDaoHibernate mockSearchDao;
        Search search;

        @Before
        public void setup() {
            searchServiceImpl = new SearchServiceImpl();
            mockSearchDao = mock(SearchDaoHibernate.class);
            searchServiceImpl.setSearchDao(mockSearchDao);
            search = new Search();
        }

        @Test
        public void happySearchWithNoCriteria(){
            ArrayList<Collectible> sample = new ArrayList<Collectible>();
            when(mockSearchDao.search(search)).thenReturn(sample);
            assertEquals(searchServiceImpl.search(search), sample);
        }

        @Test
        public void happySearchWithCriteria(){
            search.setCategory("arrowhead");
            ArrayList<Collectible> sample = new ArrayList<Collectible>();
            when(mockSearchDao.search(search)).thenReturn(sample);
            assertEquals(searchServiceImpl.search(search), sample);
        }

}