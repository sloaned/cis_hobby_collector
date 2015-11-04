package com.catalyst.collector.controllers;

import static org.junit.Assert.*;

import org.junit.Test;

import com.catalyst.collector.entities.Category;
import com.catalyst.collector.services.impl.CollectionsServiceImpl;

import junit.framework.Assert;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
public class CollectionsControllerTest {

	private CollectionsController collectionsController = new CollectionsController();
	
	@Test
	public void testGetCategory() {
		ArrayList<Category> sample = new ArrayList<Category>();
		CollectionsServiceImpl mockCollectionsService = mock(CollectionsServiceImpl.class);
		when(mockCollectionsService.getCategory()).thenReturn(sample);
		collectionsController.setCollectionsService(mockCollectionsService);
		
		ArrayList<Category> result = collectionsController.getCategory();
		
		assertEquals(sample, result);
		
		
	}

}
