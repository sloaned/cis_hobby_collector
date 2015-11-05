package com.catalyst.collector.daos.hibernate;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import javax.persistence.EntityManager;

import org.junit.Test;

import com.catalyst.collector.entities.Category;

public class CollectionsDaoHibernateTest {

	CollectionsDaoHibernate collectionsDaoHibernate = new CollectionsDaoHibernate();
	EntityManager mockEm = mock(EntityManager.class);
	

/*	@Test
	public void testGetCategory() {
		ArrayList<Category> sample = new ArrayList<Category>();
		when(mockEm.createQuery("SELECT c FROM Category c", Category.class)
				.getResultList()).thenReturn(sample);
		
		collectionsDaoHibernate.setEm(mockEm);
	
		ArrayList<Category> result = collectionsDaoHibernate.getCategory();
		
		assertEquals(sample, result);			
	}*/
	
	@Test
	public void testAddCategory(){
		Category sample = new Category();
		//when(mockEm.persist(sample)).thenReturn();
		
		collectionsDaoHibernate.setEm(mockEm);
		boolean result = collectionsDaoHibernate.addCategory(sample);
		assertTrue(result);
	}
	
	@Test
	public void testUpdateCategory(){
		Category sample = new Category();
		//when(mockEm.merge(sample)).thenReturn(true);
		
		collectionsDaoHibernate.setEm(mockEm);
		boolean result = collectionsDaoHibernate.updateCategory(sample);
		assertTrue(result);
	}
	
/*	@Test
	public void testDeleteCategory(){
		//when(mockEm.deleteCategory(0)).thenReturn(true);
		
		collectionsDaoHibernate.setEm(mockEm);
		boolean result = collectionsDaoHibernate.deleteCategory(0);
		assertTrue(result);
	}*/


}
