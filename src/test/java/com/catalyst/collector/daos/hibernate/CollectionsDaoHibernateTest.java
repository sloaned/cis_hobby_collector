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

import com.catalyst.collector.entities.*;

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
		//boolean result = 
		collectionsDaoHibernate.addCategory(sample);
		//assertTrue(result);
		verify(mockEm, times(1)).persist(sample);
	}

	@Test(expected=Exception.class)
	public void testAddCategoryNoName(){
		Category sample = new Category();
		doThrow(new Exception()).when(mockEm).persist(sample);
		collectionsDaoHibernate.setEm(mockEm);
		boolean result = collectionsDaoHibernate.addCategory(sample);
		assertFalse(result);
	}

	@Test(expected=Exception.class)
	public void testUpdateCategoryTooLong(){
		Category sample = new Category();
		sample.setName("I am far too long to be a valid name. Well over 255 characters. I'm just going to keep typing until I reach that amount of characters. Wow this is taking a while. How do typists do this every day without getting blisters? Boy I could go for some pizza right now. Okay this has got to be 256 characters by now, right? I will assume that it is because I'm mocking the results anyway.");
		doThrow(new Exception()).when(mockEm).merge(sample);
		collectionsDaoHibernate.setEm(mockEm);
		boolean result = collectionsDaoHibernate.updateCategory(sample);
		assertFalse(result);
	}
	
	@Test
	public void testUpdateCategory(){
		Category sample = new Category();
		sample.setName("Books");
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
	
	@Test
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
	
	@Test(expected=Exception.class)
	public void testDeleteCategoryInvalidId(){
		Category sample = new Category();
		TypedQuery<Category> mockTypedQuery = mock(TypedQuery.class);
		when(mockEm.createQuery(anyString(), eq(Category.class)))
			.thenReturn(mockTypedQuery);
		when(mockTypedQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedQuery);
		doThrow(new Exception()).when(mockEm).remove(sample);

		collectionsDaoHibernate.setEm(mockEm);
		Category cat = collectionsDaoHibernate.getByCategoryId(0);
		boolean result = collectionsDaoHibernate.deleteCategory(0);
		assertFalse(result);
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





    @Test(expected=Exception.class)
    public void testGetAllKeywordsDoesntMakeADBCall() {
        ArrayList<Keyword> sample = new ArrayList<Keyword>();
        TypedQuery<Keyword> mockTypedQuery = mock(TypedQuery.class);
        when(mockEm.createQuery(anyString(), eq(Keyword.class)))
                .thenReturn(mockTypedQuery);
        when(mockTypedQuery.getResultList()).thenReturn(sample);

        collectionsDaoHibernate.setEm(mockEm);
        ArrayList<Keyword> result = collectionsDaoHibernate.getAllKeywords();

        assertEquals(sample, result);
    }

    @Test(expected=Exception.class)
    public void testAddKeywordDoesntMakeADBCall() {
        Keyword sample = new Keyword();
        doThrow(new Exception()).when(mockEm).persist(sample);
        boolean result = collectionsDaoHibernate.addKeyword(sample);
        assertTrue(result);
    }

    @Test(expected=Exception.class)
    public void testUpdateKeywordDoesntMakeADBCall() {
        Keyword sample = new Keyword();
        doThrow(new Exception()).when(mockEm).merge(sample);
        collectionsDaoHibernate.setEm(mockEm);
        boolean result = collectionsDaoHibernate.updateKeyword(sample);
        assertTrue(result);
    }

    @Test(expected=Exception.class)
    public void testRemoveKeywordDoesntMakeDBCall() throws Exception {
        Keyword sample = new Keyword();
        doThrow(new Exception()).when(mockEm).remove(sample);
        collectionsDaoHibernate.setEm(mockEm);
        boolean result = collectionsDaoHibernate.updateKeyword(sample);
        assertTrue(result);
    }
}
