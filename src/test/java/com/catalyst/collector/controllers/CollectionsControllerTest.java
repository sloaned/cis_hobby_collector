package com.catalyst.collector.controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.collector.entities.Category;
import com.catalyst.collector.services.impl.CollectionsServiceImpl;


import static org.mockito.Mockito.*;

import java.util.ArrayList;
public class CollectionsControllerTest {

	private CollectionsController collectionsController;
	CollectionsServiceImpl mockCollectionsService = mock(CollectionsServiceImpl.class);
	
	@Before
	public void setup(){
		collectionsController = new CollectionsController();
		collectionsController.setCollectionsService(mockCollectionsService);
	}
	
	/*
	 * Category Controller tests
	 */
	@Test
	public void HappyPathGetCategory() {
		ArrayList<Category> sample = new ArrayList<Category>();
		when(mockCollectionsService.getCategory()).thenReturn(sample);
			
		ArrayList<Category> result = collectionsController.getCategory();
		
		assertEquals(sample, result);			
	}
	@Test
	public void HappyPathAddCategory(){
		Category sample = new Category();
		when(mockCollectionsService.addCategory(sample)).thenReturn(true);
		
		boolean result = collectionsController.addCategory(sample);
		assertTrue(result);
	}
	@Test
	public void HappyPathUpdateCategory(){
		Category sample = new Category();
		when(mockCollectionsService.updateCategory(0, sample)).thenReturn(true);
		
		boolean result = collectionsController.updateCategory(0, sample);
		assertTrue(result);
	}
	@Test
	public void HappyPathDeleteCategory(){
		when(mockCollectionsService.deleteCategory(0)).thenReturn(true);
		
		boolean result = collectionsController.deleteCategory(0);
		assertTrue(result);
	}
	

}
