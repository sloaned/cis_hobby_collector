package com.catalyst.collector.daos.hibernate;

import com.catalyst.collector.daos.CollectionsDao;
import com.catalyst.collector.daos.SearchDao;
import com.catalyst.collector.entities.Collectible;
import com.catalyst.collector.entities.Search;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by gfisher on 11/16/2015.
 */
public class SearchDaoHibernateTest {
    Search searchBody = new Search();
    SearchDao dao;
    SearchDaoHibernate searchDaoHibernate = new SearchDaoHibernate();
    EntityManager mockEm;
    CriteriaBuilder mockCriteriaBuilder;
    CriteriaQuery<String> mockCriteriaQuery;
    private SearchDaoHibernate target;

    @Before
    public void setup() {
        target = new SearchDaoHibernate();
        mockEm = mock(EntityManager.class);
        mockCriteriaBuilder = mock(CriteriaBuilder.class);
        mockCriteriaQuery = mock(CriteriaQuery.class);
        target.setEm(mockEm);
    }


    @Test
    public void testSearch() throws Exception {
        searchBody.setCategory("coins");
        ArrayList<Collectible> expected = new ArrayList<Collectible>();
        TypedQuery<Collectible> mockTypedQuery = mock(TypedQuery.class);
        when(mockEm.createQuery(anyString(), eq(Collectible.class))).thenReturn(mockTypedQuery);
        when(mockCriteriaBuilder.createQuery(String.class)).thenReturn(mockCriteriaQuery);
        when(mockTypedQuery.getResultList()).thenReturn(expected);
        searchDaoHibernate.setEm(mockEm);
        searchDaoHibernate.setCb(mockCriteriaBuilder);
        ArrayList<Collectible> result = searchDaoHibernate.search(searchBody);
        assertEquals(expected, result);
    }
}