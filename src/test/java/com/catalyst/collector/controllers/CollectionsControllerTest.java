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

	
	/*@Before
	public void setup(){

		CollectionsServiceImpl mockCollectionsService = mock(CollectionsServiceImpl.class);
		collectionsController.setCollectionsService(mockCollectionsService);
	}*/
	
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
		Category category = new Category();
		category.setName("Ornaments");
		
		
	}

}
