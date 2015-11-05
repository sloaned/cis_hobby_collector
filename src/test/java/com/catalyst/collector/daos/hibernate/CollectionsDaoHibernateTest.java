package com.catalyst.collector.daos.hibernate;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doThrow;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Test;

import com.catalyst.collector.entities.*;

public class CollectionsDaoHibernateTest {

	CollectionsDaoHibernate collectionsDaoHibernate = new CollectionsDaoHibernate();
	EntityManager mockEm = mock(EntityManager.class);
	

	@Test
	public void testGetCategory() {
		ArrayList<Category> sample = new ArrayList<Category>();
		TypedQuery<Category> mockTypedQuery = mock(TypedQuery.class);		
		when(mockEm.createQuery(anyString(), eq(Category.class)))
			.thenReturn(mockTypedQuery);
		when(mockTypedQuery.getResultList()).thenReturn(sample);
		
		collectionsDaoHibernate.setEm(mockEm);
		ArrayList<Category> result = collectionsDaoHibernate.getCategory();
		
		assertEquals(sample, result);			
	}
	
	@Test
	public void testAddCategory(){
		Category sample = new Category();
		
		collectionsDaoHibernate.setEm(mockEm);
		//boolean result = 
		collectionsDaoHibernate.addCategory(sample);
		//assertTrue(result);
		verify(mockEm, times(1)).persist(sample);
	}

	@Test(expected=Exception.class)
	public void testAddCategoryNoName(){
		Category sample = new Category();
		doThrow(new Exception()).when(mockEm).persist(sample);
		boolean result = collectionsDaoHibernate.addCategory(sample);
		assertFalse(result);
		//when(mockEm.persist(sample)).thenThrow(new Exception());
	}
	
	@Test
	public void testUpdateCategory(){
		Category sample = new Category();
		
		collectionsDaoHibernate.setEm(mockEm);
		boolean result = collectionsDaoHibernate.updateCategory(sample);
		assertTrue(result);
	}
	
	@Test
	public void TestGetByCategoryId(){
		Category sample = new Category();
		sample.setId(0);
		TypedQuery<Category> mockTypedQuery = mock(TypedQuery.class);		
		when(mockEm.createQuery(anyString(), eq(Category.class)))
			.thenReturn(mockTypedQuery);
		when(mockTypedQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedQuery);
		when(mockTypedQuery.getSingleResult()).thenReturn(sample);
		
		collectionsDaoHibernate.setEm(mockEm);
		Category result = collectionsDaoHibernate.getByCategoryId(0);
		assertEquals(sample, result);
	}
	
	@Test
	public void testDeleteCategory(){
		Category sample = new Category();
		TypedQuery<Category> mockTypedQuery = mock(TypedQuery.class);		
		when(mockEm.createQuery(anyString(), eq(Category.class)))
			.thenReturn(mockTypedQuery);
		when(mockTypedQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedQuery);

		when(mockTypedQuery.getSingleResult()).thenReturn(sample);
		
		collectionsDaoHibernate.setEm(mockEm);
		Category cat = collectionsDaoHibernate.getByCategoryId(0);
		boolean result = collectionsDaoHibernate.deleteCategory(0);
		assertTrue(result);
	}


    @Test(expected=Exception.class)
    public void testGetAllKeywordsDoesntMakeADBCall() {
        ArrayList<Keyword> sample = new ArrayList<Keyword>();
        TypedQuery<Keyword> mockTypedQuery = mock(TypedQuery.class);
        when(mockEm.createQuery(anyString(), eq(Keyword.class)))
                .thenReturn(mockTypedQuery);
        when(mockTypedQuery.getResultList()).thenReturn(sample);

        collectionsDaoHibernate.setEm(mockEm);
        ArrayList<Keyword> result = collectionsDaoHibernate.getAllKeywords();

        assertEquals(sample, result);
    }

    @Test(expected=Exception.class)
    public void testAddKeywordDoesntMakeADBCall() {
        Keyword sample = new Keyword();
        doThrow(new Exception()).when(mockEm).persist(sample);
        boolean result = collectionsDaoHibernate.addKeyword(sample);
        assertTrue(result);
    }

    @Test(expected=Exception.class)
    public void testUpdateKeywordDoesntMakeADBCall() {
        Keyword sample = new Keyword();
        doThrow(new Exception()).when(mockEm).merge(sample);
        collectionsDaoHibernate.setEm(mockEm);
        boolean result = collectionsDaoHibernate.updateKeyword(sample);
        assertTrue(result);
    }

    @Test(expected=Exception.class)
    public void testRemoveKeywordDoesntMakeDBCall() throws Exception {
        Keyword sample = new Keyword();
        doThrow(new Exception()).when(mockEm).remove(sample);
        collectionsDaoHibernate.setEm(mockEm);
        boolean result = collectionsDaoHibernate.updateKeyword(sample);
        assertTrue(result);
    }
}
