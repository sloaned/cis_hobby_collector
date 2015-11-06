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

import com.catalyst.collector.entities.Age;
import com.catalyst.collector.entities.Collectible;
import org.junit.Before;
import javax.persistence.TypedQuery;
import org.junit.Test;
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
	
	/*
	 * Category Dao Tests
	 */
	@Test
	public void happyPathGetCategory() {
		ArrayList<Category> sample = new ArrayList<Category>();
		TypedQuery<Category> mockTypedQuery = mock(TypedQuery.class);		
		when(mockEm.createQuery(anyString(), eq(Category.class)))
			.thenReturn(mockTypedQuery);
		when(mockTypedQuery.getResultList()).thenReturn(sample);
		collectionsDaoHibernate.setEm(mockEm);
		collectionsDaoHibernate.getCategory();
		
		verify(mockTypedQuery, times(1)).getResultList();		
	}
	@Test
	public void happyPathAddCategory(){
		Category sample = new Category();
		
		target.addCategory(sample);
		
		verify(mockEm, times(1)).persist(sample);
	}
	@Test
	public void happyPathUpdateCategory(){
		Category sample = new Category();
		sample.setId(1);
		target.updateCategory(sample);
		verify(mockEm, times(1)).merge(sample);
	}
	@Test
	public void happyPathGetByCategoryId(){
	
		TypedQuery<Category> mockTypedQuery = mock(TypedQuery.class);		
		when(mockEm.createQuery(anyString(), eq(Category.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedQuery);
		
		target.getByCategoryId(0);
		
		verify(mockTypedQuery, times(1)).setParameter(eq("ID"), eq(0));
	}
	@Test
	public void happyPathDeleteCategory(){
		Category sample = new Category();
		sample.setId(5);
		
		TypedQuery<Category> mockTypedQuery = mock(TypedQuery.class);		
		when(mockEm.createQuery(anyString(), eq(Category.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedQuery);
		when(mockTypedQuery.getSingleResult()).thenReturn(sample);
					
		target.deleteCategory(5);
		verify(mockEm, times(1)).remove(sample);
		verify(mockTypedQuery, times(1)).setParameter(eq("ID"), eq(5));
	}
	
	

	@Test
	public void happyAddAgeToDatabase(){
		Age test = new Age();
		test.setAge_id(1);
		test.setAge("Antique");
		collectionsDaoHibernate.setEm(mockEm);
		boolean result = collectionsDaoHibernate.addAge(test);
		assertTrue(result);
	}

	@Test
	public void sadAddAgeWithNumbersToDatabase(){
		Age test = new Age();
		test.setAge_id(1);
		test.setAge("2");
		collectionsDaoHibernate.setEm(mockEm);
		boolean result = collectionsDaoHibernate.addAge(test);
		assertFalse(result);
	}

	@Test
	public void sadAddAgeWithTooManyCharactersToDatabase(){
		Age test = new Age();
		test.setAge_id(1);
		test.setAge("this is way more than two hundred fifty five characters long so I hope that it fails miserably and does not actually post to the database because we have a maximum of two hundred fifty five characters.this is way more than two hundred fifty five characters long so I hope that it fails miserably and does not actually post to the database because we have a maximum of two hundred fifty five characters.this is way more than two hundred fifty five characters long so I hope that it fails miserably and does not actually post to the database because we have a maximum of two hundred fifty five characters.this is way more than two hundred fifty five characters long so I hope that it fails miserably and does not actually post to the database because we have a maximum of two hundred fifty five characters");
		collectionsDaoHibernate.setEm(mockEm);
		boolean result = collectionsDaoHibernate.addAge(test);
		assertFalse(result);
	}

/*	@Test
	public void happyGetAgeTypesFromDatabase(){
		ArrayList<Age> sample = new ArrayList<Age>();
		TypedQuery<Age> mockTypedQuery = mock(TypedQuery.class);
		when(mockEm.createQuery(anyString(), eq(Category.class)))
			.thenReturn(mockTypedQuery);
		when(mockTypedQuery.getResultList()).thenReturn(sample);
		collectionsDaoHibernate.setEm(mockEm);
		ArrayList<Age> result = collectionsDaoHibernate.getAgeTypes();
		assertEquals(sample, result);
	}*/



}
