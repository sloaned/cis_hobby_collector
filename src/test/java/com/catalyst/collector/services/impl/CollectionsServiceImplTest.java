package com.catalyst.collector.services.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import com.catalyst.collector.entities.Keyword;
import org.junit.Before;
import org.junit.Test;

import com.catalyst.collector.daos.hibernate.CollectionsDaoHibernate;
import com.catalyst.collector.entities.Category;

public class CollectionsServiceImplTest {
    CollectionsServiceImpl collectionsServiceImpl = new CollectionsServiceImpl();
    CollectionsDaoHibernate mockCollectionsDao = mock(CollectionsDaoHibernate.class);

    @Before
    public void setup() {
        collectionsServiceImpl = new CollectionsServiceImpl();
        mockCollectionsDao = mock(CollectionsDaoHibernate.class);
        collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
    }
	
	@Test
	public void testGetCategory() {
		ArrayList<Category> sample = new ArrayList<Category>();
		when(mockCollectionsDao.getCategory()).thenReturn(sample);
		
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
	
		ArrayList<Category> result = collectionsServiceImpl.getCategory();
		
		assertEquals(sample, result);			
	}
	
	@Test
	public void testAddCategory(){
		Category sample = new Category();
		sample.setName("Books");
		when(mockCollectionsDao.addCategory(sample)).thenReturn(true);
		
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		boolean result = collectionsServiceImpl.addCategory(sample);
		assertTrue(result);
	}
	
	@Test
	public void testAddCategoryNullName(){
		Category sample = new Category();
		
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		boolean result = collectionsServiceImpl.addCategory(sample);
		assertFalse(result);
	}
	
	@Test
	public void testAddCategoryBlankName(){
		Category sample = new Category();
		sample.setName("  ");
		
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		boolean result = collectionsServiceImpl.addCategory(sample);
		assertFalse(result);
	}
	
	@Test
	public void testAddCategoryLongName(){
		Category sample = new Category();
		sample.setName("we had everything before us, we had nothing before us, we were all going direct to Heaven, we were all going direct the other way� in short, the period was so far like the present period, that some of its noisiest authorities insisted on its being received, for good or for evil, in the superlative degree of comparison only. There were a king with a large jaw and a queen with a plain face, on the throne of England; there were a king with a large jaw and a queen with a fair face, on the throne of France. In both countries it was clearer than crystal to the lords of the State preserves of loaves and fishes, that things in general were settled for ever.");
		
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		boolean result = collectionsServiceImpl.addCategory(sample);
		assertFalse(result);
	}
	
	@Test
	public void testUpdateCategory(){
		Category sample = new Category();
		sample.setName("Books");
		when(mockCollectionsDao.updateCategory(sample)).thenReturn(true);
		
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		boolean result = collectionsServiceImpl.updateCategory(0, sample);
		assertTrue(result);
	}
	
	@Test
	public void testUpdateCategoryNullName(){
		Category sample = new Category();
		
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		boolean result = collectionsServiceImpl.updateCategory(0, sample);
		assertFalse(result);
	}
	
	@Test
	public void testUpdateCategoryBlankName(){
		Category sample = new Category();
		sample.setName("  ");
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		boolean result = collectionsServiceImpl.updateCategory(0, sample);
		assertFalse(result);
	}
	
	@Test
	public void testUpdateCategoryLongName(){
		Category sample = new Category();
		
		sample.setName("we had everything before us, we had nothing before us, we were all going direct to Heaven, we were all going direct the other way� in short, the period was so far like the present period, that some of its noisiest authorities insisted on its being received, for good or for evil, in the superlative degree of comparison only. There were a king with a large jaw and a queen with a plain face, on the throne of England; there were a king with a large jaw and a queen with a fair face, on the throne of France. In both countries it was clearer than crystal to the lords of the State preserves of loaves and fishes, that things in general were settled for ever.");
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		boolean result = collectionsServiceImpl.updateCategory(0, sample);
		assertFalse(result);
	}
	
	@Test
	public void testDeleteCategory(){
		when(mockCollectionsDao.deleteCategory(0)).thenReturn(true);
		
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		boolean result = collectionsServiceImpl.deleteCategory(0);
		assertTrue(result);
	}

    @Test
    public void testAddAValidKeyword() {
        Keyword keyword = new Keyword();
        keyword.setWord("AValidWord");

        assertTrue(collectionsServiceImpl.addKeyword(keyword));
    }

    @Test
    public void testAddAInvalidKeywordWithEmptyString() {
        Keyword keyword = new Keyword();
        keyword.setWord("");

        assertFalse(collectionsServiceImpl.addKeyword(keyword));
    }

    @Test
    public void testAddAInvalidKeywordWithStringLengthTooLong() {
        Keyword keyword = new Keyword();
        keyword.setWord("asdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfas");

        assertFalse(collectionsServiceImpl.addKeyword(keyword));
    }

    @Test
    public void testAddAInvalidKeywordWithInvalidCharacterInString() {
        Keyword keyword = new Keyword();
        keyword.setWord("asdf#as");

        assertFalse(collectionsServiceImpl.addKeyword(keyword));
    }

    @Test
    public void testGetAllKeywords() throws Exception {
        ArrayList<Keyword> expected = new ArrayList<>();
        when(mockCollectionsDao.getAllKeywords()).thenReturn(expected);
        ArrayList<Keyword> actual = collectionsServiceImpl.getAllKeywords();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetKeywordsByLetter() throws Exception {
        ArrayList<Keyword> expected = new ArrayList<>();
        when(mockCollectionsDao.getKeywordsByLetter('c')).thenReturn(expected);
        ArrayList<Keyword> actual = collectionsServiceImpl.getKeywordsByLetter('c');
        assertEquals(expected, actual);
    }

    @Test
    public void testUpdateAValidKeyword() {
        Keyword keyword = new Keyword();
        keyword.setWord("AValidWord");

        assertTrue(collectionsServiceImpl.updateKeyword(keyword));
    }

    @Test
    public void testUpdateAInvalidKeywordWithNullString() {
        Keyword keyword = new Keyword();
        keyword.setWord(null);

        assertFalse(collectionsServiceImpl.updateKeyword(keyword));
    }

    @Test
    public void testUpdateAInvalidKeywordWithStringLengthTooLong() {
        Keyword keyword = new Keyword();
        keyword.setWord("asdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfasasdfasdfas");

        assertFalse(collectionsServiceImpl.addKeyword(keyword));
    }

    @Test
    public void testUpdateAInvalidKeywordWithInvalidCharacterInString() {
        Keyword keyword = new Keyword();
        keyword.setWord("asdf#as");

        assertFalse(collectionsServiceImpl.addKeyword(keyword));
    }

    @Test
    public void testRemoveKeywordHappyPath() throws Exception {
        collectionsServiceImpl.removeKeyword(3);
        verify(mockCollectionsDao, times(1)).removeKeyword(3);
    }

    @Test
    public void testRemoveKeywordSadPath() throws Exception {
        collectionsServiceImpl.removeKeyword(-1);
        verify(mockCollectionsDao, times(0)).removeKeyword(-1);
    }
}
