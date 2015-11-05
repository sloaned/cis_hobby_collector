package com.catalyst.collector.daos.hibernate;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.util.*;

import org.junit.Test;


import com.catalyst.collector.daos.CollectionsDao;
import com.catalyst.collector.entities.Category;
import com.catalyst.collector.entities.Color;

public class CollectionsDaoHibernateTest {
	CollectionsDao dao;


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
		boolean result = collectionsDaoHibernate.addCategory(sample);
		assertTrue(result);
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

	@Test
	public void happyPathAddColorTest(){
		Color c = new Color("azul");
		collectionsDaoHibernate.setEm(mockEm);
		boolean result = collectionsDaoHibernate.addColor(c);
		assertTrue(result);
	}
	/*@Test
	public void sadPathAddColorTest_noColor(){
		Color c = new Color();
		collectionsDaoHibernate.setEm(mockEm);
		boolean result = collectionsDaoHibernate.addColor(c);
		assertFalse(result);
	}*/
	/*@Test
	public void sadPathAddColorTest_over255Char(){
		Color c = new Color();
		String s = new String();
		for(int i = 0; i<130; i++){
			s = Integer.toString(i);
		}
		c.setColor(s);
		collectionsDaoHibernate.setEm(mockEm);
		boolean result = collectionsDaoHibernate.addColor(c);
		assertFalse(result);
	}*/

	@Test
	public void happyPathRemoveColorTest(){
		Color c = new Color();
		TypedQuery<Color> mockTypedQuery = mock(TypedQuery.class);		
		when(mockEm.createQuery(anyString(), eq(Color.class)))
			.thenReturn(mockTypedQuery);
		when(mockTypedQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedQuery);
		when(mockTypedQuery.getSingleResult()).thenReturn(c);
		collectionsDaoHibernate.setEm(mockEm);
		Color cat = collectionsDaoHibernate.getColor(0);
		boolean result = collectionsDaoHibernate.removeColor(0);
		assertTrue(result);
	}
		@Test
	public void happyPathGetColorTest(){
		Color c = new Color();
		c.setId(0);
		TypedQuery<Color> mockTypedQuery = mock(TypedQuery.class);		
		when(mockEm.createQuery(anyString(), eq(Color.class)))
			.thenReturn(mockTypedQuery);
		when(mockTypedQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedQuery);
		when(mockTypedQuery.getSingleResult()).thenReturn(c);
		collectionsDaoHibernate.setEm(mockEm);
		Color result = collectionsDaoHibernate.getColor(0);
		assertEquals(c, result);	
		}
	@Test
	public void happyPathUpdateColorTest(){
		Color c = new Color("azul");
		collectionsDaoHibernate.setEm(mockEm);
		boolean result = collectionsDaoHibernate.updateColor(c);
		assertTrue(result);
	}
	/*
	@Test
	public void sadPathUpdateColorTest_noColor(){
		Color c = new Color();
		collectionsDaoHibernate.setEm(mockEm);
		boolean result = collectionsDaoHibernate.updateColor(c);
		assertTrue(result);
	}
	@Test
	public void sadPathUpdateColorTest_over255Char(){
		Color c = new Color();
		String s = new String();
		for(int i = 0; i<130; i++){
			s = Integer.toString(i);
		}
		c.setColor(s);
		collectionsDaoHibernate.setEm(mockEm);
		boolean result = collectionsDaoHibernate.updateColor(c);
		assertTrue(result);
	}
	*/
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
	public void happyPathGetColorListTest(){
		List<Color> colorList = new ArrayList<Color>();
		TypedQuery<Color> mockTypedQuery = mock(TypedQuery.class);		
		when(mockEm.createQuery(anyString(), eq(Color.class)))
			.thenReturn(mockTypedQuery);
		when(mockTypedQuery.getResultList()).thenReturn(colorList);
		collectionsDaoHibernate.setEm(mockEm);
		List<Color> result = collectionsDaoHibernate.getColorList();
		assertEquals(colorList,result);
	}
	
}
