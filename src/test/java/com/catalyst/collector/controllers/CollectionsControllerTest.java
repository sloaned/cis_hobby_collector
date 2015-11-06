package com.catalyst.collector.controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.collector.entities.Category;
import com.catalyst.collector.services.impl.CollectionsServiceImpl;


import static org.mockito.Mockito.*;

import java.util.ArrayList;
public class CollectionsControllerTest {

	CollectionsController collectionsController = new CollectionsController();
	CollectionsServiceImpl mockCollectionsService = mock(CollectionsServiceImpl.class);

	
	@Test
	public void testGetCategory() {
		ArrayList<Category> sample = new ArrayList<Category>();
		when(mockCollectionsService.getCategory()).thenReturn(sample);
		collectionsController.setCollectionsService(mockCollectionsService);
		ArrayList<Category> result = collectionsController.getCategory();
		assertEquals(sample, result);
	}

	@Test
	public void testAddCategory(){
		Category sample = new Category();
		when(mockCollectionsService.addCategory(sample)).thenReturn(true);
		collectionsController.setCollectionsService(mockCollectionsService);
		boolean result = collectionsController.addCategory(sample);
		assertTrue(result);
	}

	@Test
	public void testUpdateCategory(){
		Category sample = new Category();
		when(mockCollectionsService.updateCategory(0, sample)).thenReturn(true);
		collectionsController.setCollectionsService(mockCollectionsService);
		boolean result = collectionsController.updateCategory(0, sample);
		assertTrue(result);
	}

	@Test
	public void testDeleteCategory(){
		when(mockCollectionsService.deleteCategory(0)).thenReturn(true);
		collectionsController.setCollectionsService(mockCollectionsService);
		boolean result = collectionsController.deleteCategory(0);
		assertTrue(result);
	}

}
