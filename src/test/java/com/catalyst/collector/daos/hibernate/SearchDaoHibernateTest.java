package com.catalyst.collector.daos.hibernate;

import com.catalyst.collector.daos.CollectionsDao;
import com.catalyst.collector.daos.SearchDao;
import com.catalyst.collector.entities.Search;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.Entity;
import javax.persistence.EntityManager;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Created by gfisher on 11/16/2015.
 */
public class SearchDaoHibernateTest {
    Search searchBody = new Search();
    SearchDao dao;
    SearchDaoHibernate searchDaoHibernate = new SearchDaoHibernate();
    EntityManager mockEm;
    private SearchDaoHibernate target;

    @Before
    public void setup() {
        target = new SearchDaoHibernate();
        mockEm = mock(EntityManager.class);
        target.setEm(mockEm);
    }


    @Test
    public void testSearch() throws Exception {
        searchBody.setAge("antique");
        searchDaoHibernate.setEm(mockEm);
        searchDaoHibernate.search(searchBody);
    }
}