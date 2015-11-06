package com.catalyst.collector.services.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.collector.daos.hibernate.CollectionsDaoHibernate;
import com.catalyst.collector.entities.Category;

public class CollectionsServiceImplTest {

	private CollectionsServiceImpl collectionsServiceImpl;
	CollectionsDaoHibernate mockCollectionsDao = mock(CollectionsDaoHibernate.class);
	@Before
	public void setup(){
		collectionsServiceImpl = new CollectionsServiceImpl();
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
	}
	@Test
	public void HappyPathGetCategory() {
		ArrayList<Category> sample = new ArrayList<Category>();
		when(mockCollectionsDao.getCategory()).thenReturn(sample);
			
		ArrayList<Category> result = collectionsServiceImpl.getCategory();
		
		assertEquals(sample, result);			
	}
	
	@Test
	public void HappyPathAddCategory(){
		Category sample = new Category();
		sample.setName("Books");
		when(mockCollectionsDao.addCategory(sample)).thenReturn(true);
		
		boolean result = collectionsServiceImpl.addCategory(sample);
		assertTrue(result);
	}
	
	@Test
	public void SadPathAddCategoryNameIsNull(){
		Category sample = new Category();
		
		boolean result = collectionsServiceImpl.addCategory(sample);
		assertFalse(result);
	}
	
	@Test
	public void SadPathAddCategoryNameIsBlank(){
		Category sample = new Category();
		sample.setName("  ");
		
		boolean result = collectionsServiceImpl.addCategory(sample);
		assertFalse(result);
	}
	
	@Test
	public void SadPathAddCategoryNameIsTooLong(){
		Category sample = new Category();
		sample.setName("we had everything before us, we had nothing before us, we were all going direct to Heaven, we were all going direct the other way— in short, the period was so far like the present period, that some of its noisiest authorities insisted on its being received, for good or for evil, in the superlative degree of comparison only. There were a king with a large jaw and a queen with a plain face, on the throne of England; there were a king with a large jaw and a queen with a fair face, on the throne of France. In both countries it was clearer than crystal to the lords of the State preserves of loaves and fishes, that things in general were settled for ever.");
		
		boolean result = collectionsServiceImpl.addCategory(sample);
		assertFalse(result);
	}
	
	@Test
	public void HappyPathUpdateCategory(){
		Category sample = new Category();
		sample.setName("Books");
		when(mockCollectionsDao.updateCategory(sample)).thenReturn(true);
		
		boolean result = collectionsServiceImpl.updateCategory(0, sample);
		assertTrue(result);
	}
	
	@Test
	public void SadPathUpdateCategoryNameIsNull(){
		Category sample = new Category();
		
		boolean result = collectionsServiceImpl.updateCategory(0, sample);
		assertFalse(result);
	}
	
	@Test
	public void SadPathUpdateCategoryNameIsBlank(){
		Category sample = new Category();
		sample.setName("  ");
		boolean result = collectionsServiceImpl.updateCategory(0, sample);
		assertFalse(result);
	}
	
	@Test
	public void SadPathUpdateCategoryNameIsTooLong(){
		Category sample = new Category();
		
		sample.setName("we had everything before us, we had nothing before us, we were all going direct to Heaven, we were all going direct the other way— in short, the period was so far like the present period, that some of its noisiest authorities insisted on its being received, for good or for evil, in the superlative degree of comparison only. There were a king with a large jaw and a queen with a plain face, on the throne of England; there were a king with a large jaw and a queen with a fair face, on the throne of France. In both countries it was clearer than crystal to the lords of the State preserves of loaves and fishes, that things in general were settled for ever.");
		boolean result = collectionsServiceImpl.updateCategory(0, sample);
		assertFalse(result);
	}
	
	@Test
	public void HappyPathDeleteCategory(){
		when(mockCollectionsDao.deleteCategory(0)).thenReturn(true);
		
		boolean result = collectionsServiceImpl.deleteCategory(0);
		assertTrue(result);
	}

}
