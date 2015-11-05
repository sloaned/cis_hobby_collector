package com.catalyst.collector.daos.hibernate;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import com.catalyst.collector.entities.Collectible;
import org.junit.Before;
import org.junit.Test;
import javax.persistence.TypedQuery;
import java.util.List;
import com.catalyst.collector.entities.Category;

public class CollectionsDaoHibernateTest {
	CollectionsDaoHibernate collectionsDaoHibernate = new CollectionsDaoHibernate();
	EntityManager mockEm = mock(EntityManager.class);
	private CollectionsDaoHibernate target;

	@Before
	public void setup() {
		target = new CollectionsDaoHibernate();
		mockEm = mock(EntityManager.class);
		target.setEm(mockEm);
	}

	@Test
	public void testGetCollection(){
		ArrayList<Collectible> expected = new ArrayList<Collectible>();
		TypedQuery<Collectible> mockTypedQuery = mock(TypedQuery.class);
		when(mockEm.createQuery(anyString(), eq(Collectible.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.getResultList()).thenReturn(expected);
		collectionsDaoHibernate.setEm(mockEm);
		ArrayList<Collectible> result = collectionsDaoHibernate.getCollectibles();
		assertEquals(expected, result);
	}


	@Test
	public void testGetCategory() {
		ArrayList<Category> sample = new ArrayList<Category>();
		TypedQuery<Category> mockTypedQuery = mock(TypedQuery.class);
		when(mockEm.createQuery(anyString(), eq(Category.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.getResultList()).thenReturn(sample);
		collectionsDaoHibernate.setEm(mockEm);
		ArrayList<Category> result = collectionsDaoHibernate.getCategory();
		assertEquals(sample, result);			
	}
	
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
	
	@Test
	public void testDeleteCategory(){
		//when(mockEm.deleteCategory(0)).thenReturn(true);
		
		collectionsDaoHibernate.setEm(mockEm);
		boolean result = collectionsDaoHibernate.deleteCategory(0);
		assertTrue(result);
	}


}
