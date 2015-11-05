package com.catalyst.collector.daos.hibernate;

import static org.junit.Assert.*;
<<<<<<< HEAD
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;
=======
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import javax.persistence.EntityManager;
>>>>>>> c50baf5f95c2296682e4b1b85484ae912aaab233

import com.catalyst.collector.entities.Collectible;
import org.junit.Before;
import org.junit.Test;

<<<<<<< HEAD
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
=======
import com.catalyst.collector.entities.Category;
>>>>>>> c50baf5f95c2296682e4b1b85484ae912aaab233

public class CollectionsDaoHibernateTest {
	private CollectionsDaoHibernate target;

	private EntityManager mockEm;

	@Before
	public void setup() {
		target = new CollectionsDaoHibernate();
		mockEm = mock(EntityManager.class);
		target.setEm(mockEm);
	}

	@Test
	public void testGetCollection(){
		List<Collectible> expected = new ArrayList<>();

		TypedQuery<Collectible> mockTypedQuery = mock(TypedQuery.class);

		when(mockEm.createQuery(anyString(), eq(Collectible.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.getResultList()).thenReturn(expected);

		target.getCollectibles();

		verify(mockTypedQuery, times(1)).getResultList();
	}

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
