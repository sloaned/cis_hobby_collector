package com.catalyst.collector.services.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;

import com.catalyst.collector.daos.hibernate.CollectionsDaoHibernate;
import com.catalyst.collector.entities.Category;

public class CollectionsServiceImplTest {

	CollectionsServiceImpl collectionsServiceImpl = new CollectionsServiceImpl();
	CollectionsDaoHibernate mockCollectionsDao = mock(CollectionsDaoHibernate.class);
	
	@Test
	public void testGetCategory() {
		ArrayList<Category> sample = new ArrayList<Category>();
		when(mockCollectionsDao.getCategory()).thenReturn(sample);
		
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
	
		ArrayList<Category> result = collectionsServiceImpl.getCategory();
		
		assertEquals(sample, result);			
	}
	
	@Test
	public void testAddCategory(){
		Category sample = new Category();
		when(mockCollectionsDao.addCategory(sample)).thenReturn(true);
		
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		boolean result = collectionsServiceImpl.addCategory(sample);
		assertTrue(result);
	}
	
	@Test
	public void testUpdateCategory(){
		Category sample = new Category();
		when(mockCollectionsDao.updateCategory(sample)).thenReturn(true);
		
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		boolean result = collectionsServiceImpl.updateCategory(0, sample);
		assertTrue(result);
	}
	
	@Test
	public void testDeleteCategory(){
		when(mockCollectionsDao.deleteCategory(0)).thenReturn(true);
		
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		boolean result = collectionsServiceImpl.deleteCategory(0);
		assertTrue(result);
	}

}
