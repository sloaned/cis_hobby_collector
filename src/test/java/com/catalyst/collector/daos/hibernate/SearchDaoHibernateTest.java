package com.catalyst.collector.daos.hibernate;

import com.catalyst.collector.daos.CollectionsDao;
import com.catalyst.collector.daos.SearchDao;
import com.catalyst.collector.entities.Search;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Created by gfisher on 11/16/2015.
 */
public class SearchDaoHibernateTest {
    Search searchBody = new Search();
    SearchDaoHibernate searchDaoHibernate;
    EntityManager em;
    @Before
    public void setUp(){
        searchDaoHibernate = new SearchDaoHibernate();
        searchBody.setCategory("arrowhead");
    }


    @Test
    public void testSearch() throws Exception {
        searchDaoHibernate.search(searchBody);
    }
}