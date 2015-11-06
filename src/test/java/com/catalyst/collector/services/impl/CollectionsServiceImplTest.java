package com.catalyst.collector.services.impl;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import com.catalyst.collector.entities.Age;
import org.junit.Test;
import com.catalyst.collector.daos.hibernate.CollectionsDaoHibernate;
import com.catalyst.collector.entities.Category;

public class CollectionsServiceImplTest {

	CollectionsServiceImpl collectionsServiceImpl = new CollectionsServiceImpl();
	CollectionsDaoHibernate mockCollectionsDao = mock(CollectionsDaoHibernate.class);
	
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
	public void happyPathDeleteCategory(){
		when(mockCollectionsDao.deleteCategory(0)).thenReturn(true);
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		boolean result = collectionsServiceImpl.deleteCategory(0);
		assertTrue(result);
	}

	@Test
	public void happyPathGetAgeTypes(){
		ArrayList<Age> sample = new ArrayList<Age>();
		when(mockCollectionsDao.getAgeTypes()).thenReturn(sample);
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		ArrayList<Age> result = collectionsServiceImpl.getAgeTypes();
		assertEquals(sample, result);
	}

	@Test
	public void happyPathAddAge(){
		Age age = new Age();
		age.setAge_id(1);
		age.setAge("Antique");
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		collectionsServiceImpl.addAge(age);
		verify(mockCollectionsDao, times(1)).addAge(age);
	}

	@Test
	public void sadPathAddAgeWithOnlyANumber(){
		Age age = new Age();
		age.setAge_id(1);
		age.setAge("2");
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		collectionsServiceImpl.addAge(age);
		verify(mockCollectionsDao, times(0)).addAge(age);
	}

	@Test
	public void sadPathAddAgeWithNumbersInWords(){
		Age age = new Age();
		age.setAge_id(1);
		age.setAge("These are 3 Words");
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		collectionsServiceImpl.addAge(age);
		verify(mockCollectionsDao, times(0)).addAge(age);
	}

	@Test
	public void sadPathAddNullAge(){
		Age age = new Age();
		age.setAge_id(1);
		age.setAge(null);
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		collectionsServiceImpl.addAge(age);
		verify(mockCollectionsDao, times(0)).addAge(age);
	}

	@Test
	public void sadPathAddEmptyStringAge(){
		Age age = new Age();
		age.setAge_id(1);
		age.setAge("");
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		collectionsServiceImpl.addAge(age);
		verify(mockCollectionsDao, times(0)).addAge(age);
	}

	@Test
	public void sadPathAddWhiteSpaceOnlyStringAge(){
		Age age = new Age();
		age.setAge_id(1);
		age.setAge("     ");
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		collectionsServiceImpl.addAge(age);
		verify(mockCollectionsDao, times(0)).addAge(age);
	}

	@Test
	public void sadPathAddAgeWithTooManyCharacters(){
		Age age = new Age();
		age.setAge_id(1);
		age.setAge("this is way more than two hundred fifty five characters long so I hope that it fails miserably and does not actually post to the database because we have a maximum of two hundred fifty five characters.this is way more than two hundred fifty five characters long so I hope that it fails miserably and does not actually post to the database because we have a maximum of two hundred fifty five characters.this is way more than two hundred fifty five characters long so I hope that it fails miserably and does not actually post to the database because we have a maximum of two hundred fifty five characters.this is way more than two hundred fifty five characters long so I hope that it fails miserably and does not actually post to the database because we have a maximum of two hundred fifty five characters");
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		collectionsServiceImpl.addAge(age);
		verify(mockCollectionsDao, times(0)).addAge(age);
	}

	@Test
	public void happyPathUpdateAge(){
		Age age = new Age();
		age.setAge_id(1);
		age.setAge("A good age");
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		collectionsServiceImpl.updateAge(age);
		verify(mockCollectionsDao, times(1)).updateAge(age);
	}


	@Test
	public void sadPathUpdateAgeWithOnlyANumber(){
		Age age = new Age();
		age.setAge_id(1);
		age.setAge("2");
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		collectionsServiceImpl.updateAge(age);
		verify(mockCollectionsDao, times(0)).updateAge(age);
	}

	@Test
	public void sadPathUpdateAgeWithNumbersInWords(){
		Age age = new Age();
		age.setAge_id(1);
		age.setAge("These are 3 Words");
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		collectionsServiceImpl.updateAge(age);
		verify(mockCollectionsDao, times(0)).updateAge(age);
	}

	@Test
	public void sadPathUpdateNullAge(){
		Age age = new Age();
		age.setAge_id(1);
		age.setAge(null);
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		collectionsServiceImpl.updateAge(age);
		verify(mockCollectionsDao, times(0)).updateAge(age);
	}

	@Test
	public void sadPathUpdateEmptyStringAge(){
		Age age = new Age();
		age.setAge_id(1);
		age.setAge("");
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		collectionsServiceImpl.updateAge(age);
		verify(mockCollectionsDao, times(0)).updateAge(age);
	}

	@Test
	public void sadPathUpdateWhiteSpaceOnlyStringAge(){
		Age age = new Age();
		age.setAge_id(1);
		age.setAge("     ");
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		collectionsServiceImpl.updateAge(age);
		verify(mockCollectionsDao, times(0)).updateAge(age);
	}

	@Test
	public void sadPathUpdateAgeWithTooManyCharacters(){
		Age age = new Age();
		age.setAge_id(1);
		age.setAge("this is way more than two hundred fifty five characters long so I hope that it fails miserably and does not actually post to the database because we have a maximum of two hundred fifty five characters.this is way more than two hundred fifty five characters long so I hope that it fails miserably and does not actually post to the database because we have a maximum of two hundred fifty five characters.this is way more than two hundred fifty five characters long so I hope that it fails miserably and does not actually post to the database because we have a maximum of two hundred fifty five characters.this is way more than two hundred fifty five characters long so I hope that it fails miserably and does not actually post to the database because we have a maximum of two hundred fifty five characters");
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		collectionsServiceImpl.updateAge(age);
		verify(mockCollectionsDao, times(0)).updateAge(age);
	}

	@Test
	public void happyPathDeleteAge(){
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		collectionsServiceImpl.deleteAge(1);
		verify(mockCollectionsDao, times(1)).deleteAge(1);
	}

	@Test
	public void sadPathDeleteAgeThatDoesNotExist(){
		collectionsServiceImpl.setCollectionsDao(mockCollectionsDao);
		collectionsServiceImpl.deleteAge(0);
		verify(mockCollectionsDao, times(0)).deleteAge(0);
	}

}
