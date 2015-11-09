package com.catalyst.collector.daos.hibernate;
import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doThrow;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import java.util.*;
import org.junit.Test;
import com.catalyst.collector.daos.CollectionsDao;
import com.catalyst.collector.entities.Age;
import com.catalyst.collector.entities.Collectible;
import org.junit.Before;
import javax.persistence.TypedQuery;
import com.catalyst.collector.entities.*;
import com.catalyst.collector.entities.Category;
import com.catalyst.collector.entities.Color;

public class CollectionsDaoHibernateTest {
	CollectionsDao dao;
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
		collectionsDaoHibernate.setEm(mockEm);
		boolean result = collectionsDaoHibernate.updateCategory(sample);
		assertTrue(result);
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

	@Test(expected=Exception.class)
	public void sadPathAddColorTest_noColor(){
		Color c = new Color();
		doThrow(new Exception()).when(mockEm).persist(c);
		boolean result = collectionsDaoHibernate.addColor(c);
		assertFalse(result);
	}
	@Test(expected=Exception.class)
	public void sadPathAddColorTest_over255Char(){
		Color c = new Color();
		String s = new String();
		for(int i = 0; i<130; i++){
			s = Integer.toString(i);
		}
		c.setColor(s);
		doThrow(new Exception()).when(mockEm).persist(c);
		boolean result = collectionsDaoHibernate.addColor(c);
		assertFalse(result);
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
		target.deleteCategory(5);
		verify(mockEm, times(1)).remove(sample);
		verify(mockTypedQuery, times(1)).setParameter(eq("ID"), eq(5));
	}



    @Test
    public void testGetAllKeywordsHappyPathMakesADBCall() throws Exception {
        ArrayList<Keyword> testList = new ArrayList<>();
        TypedQuery<Keyword> mockTypedQuery = mock(TypedQuery.class);
        when(mockEm.createQuery(anyString(), eq(Keyword.class)))
                .thenReturn(mockTypedQuery);
        when(mockTypedQuery.getResultList()).thenReturn(testList);
        collectionsDaoHibernate.setEm(mockEm);
        ArrayList<Keyword> result = collectionsDaoHibernate.getAllKeywords();
        assertEquals(testList, result);
    }

    @Test
    public void testGetKeywordsByLetterHappyPathMakesADBCall() throws Exception {
        ArrayList<Keyword> testList = new ArrayList<>();
        TypedQuery<Keyword> mockTypedQuery = mock(TypedQuery.class);
        when(mockEm.createQuery(anyString(), eq(Keyword.class)))
                .thenReturn(mockTypedQuery);
        when(mockTypedQuery.setParameter(anyString(), anyChar())).thenReturn(mockTypedQuery);
        when(mockTypedQuery.getResultList()).thenReturn(testList);
        collectionsDaoHibernate.setEm(mockEm);
        ArrayList<Keyword> result = collectionsDaoHibernate.getKeywordsByLetter("c");
        assertEquals(testList, result);
    }

    @Test
    public void testAddKeywordHappyPathMakesADBCall() throws Exception {
        target.addKeyword(null);
        //We have nothing we can assert. So use verify to check how many times a dependency's method was called.
        verify(mockEm, times(1)).persist(null);
    }

    @Test
    public void testUpdateKeywordHappyPathMakesADBCall() throws Exception {
        Keyword expected = new Keyword();
        expected.setId(1);
        target.updateKeyword(expected);
        verify(mockEm, times(1)).merge(expected);
    }

    @Test
    public void testRemoveKeywordHappyPathMakesADBCall() throws Exception {
        Keyword keywordToDelete = new Keyword();
        keywordToDelete.setId(5);
        TypedQuery<Keyword> mockTypedQuery = mock(TypedQuery.class);
        when(mockEm.createQuery(anyString(), eq(Keyword.class))).thenReturn(mockTypedQuery);
        when(mockTypedQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedQuery);
        when(mockTypedQuery.getSingleResult()).thenReturn(keywordToDelete);
        target.removeKeyword(5);
        verify(mockEm, times(1)).remove(keywordToDelete);
        verify(mockTypedQuery, times(1)).setParameter(eq("id"), eq(5));
    }

    @Test
    public void testGetAllConditionsHappyPathMakesADBCall() throws Exception {
        ArrayList<Condition> testList = new ArrayList<>();
        TypedQuery<Condition> mockTypedQuery = mock(TypedQuery.class);
        when(mockEm.createQuery(anyString(), eq(Condition.class)))
                .thenReturn(mockTypedQuery);
        when(mockTypedQuery.getResultList()).thenReturn(testList);
        collectionsDaoHibernate.setEm(mockEm);
        ArrayList<Condition> result = collectionsDaoHibernate.getAllConditions();
        assertEquals(testList, result);
    }

    @Test
    public void testAddConditionHappyPathMakesADBCall() throws Exception {
        target.addCondition(null);
        //We have nothing we can assert. So use verify to check how many times a dependency's method was called.
        verify(mockEm, times(1)).persist(null);
    }

    @Test
    public void testUpdateConditionHappyPathMakesADBCall() throws Exception {
        Condition expected = new Condition();
        expected.setId(1);
        target.updateCondition(expected);
        verify(mockEm, times(1)).merge(expected);
    }

    @Test
    public void testDeleteConditionHappyPathMakesADBCall() throws Exception {
        Condition condition = new Condition();
        condition.setId(5);
        TypedQuery<Condition> mockTypedQuery = mock(TypedQuery.class);
        when(mockEm.createQuery(anyString(), eq(Condition.class))).thenReturn(mockTypedQuery);
        when(mockTypedQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedQuery);
        when(mockTypedQuery.getSingleResult()).thenReturn(condition);
        target.deleteCondition(5);
        verify(mockEm, times(1)).remove(condition);
        verify(mockTypedQuery, times(1)).setParameter(eq("id"), eq(5));
    }

	@Test
	public void happyGetAgeArrayList() {
		ArrayList<Age> sample = new ArrayList<Age>();
		TypedQuery<Age> mockTypedQuery = mock(TypedQuery.class);
		when(mockEm.createQuery(anyString(), eq(Age.class)))
				.thenReturn(mockTypedQuery);
		when(mockTypedQuery.getResultList()).thenReturn(sample);
		collectionsDaoHibernate.setEm(mockEm);
		ArrayList<Age> result = collectionsDaoHibernate.getAgeTypes();
		assertEquals(sample, result);
	}

	@Test
	public void happyAddAgeToDatabaseMakesOneCall(){
		Age sample = new Age();
		collectionsDaoHibernate.setEm(mockEm);
		collectionsDaoHibernate.addAge(sample);
		verify(mockEm, times(1)).persist(sample);
	}

	@Test
	public void happyUpdateAgeOneCallOnly(){
		Age age = new Age();
		collectionsDaoHibernate.setEm(mockEm);
		collectionsDaoHibernate.updateAge(age);
		verify(mockEm, times(1)).merge(age);
	}

	@Test
	public void happyDeleteAgeFromDatabaseOnlyOneCall(){
		Age age = new Age();
		collectionsDaoHibernate.setEm(mockEm);
		TypedQuery<Age> mockTypedQuery = mock(TypedQuery.class);
		when(mockEm.createQuery(anyString(), eq(Age.class)))
				.thenReturn(mockTypedQuery);
		when(mockTypedQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedQuery);
		when(mockTypedQuery.getSingleResult()).thenReturn(age);
		collectionsDaoHibernate.deleteAge(1);
		verify(mockEm, times(1)).remove(age);
	}


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
	@Test(expected=Exception.class)
	public void sadPathUpdateColorTest_noColor(){
		Color c = new Color();
		doThrow(new Exception()).when(mockEm).persist(c);
		boolean result = collectionsDaoHibernate.addColor(c);
		assertFalse(result);
	}
	@Test(expected=Exception.class)
	public void sadPathUpdateColorTest_over255Char(){
		Color c = new Color();
		String s = new String();
		for(int i = 0; i<130; i++){
			s = Integer.toString(i);
		}
		c.setColor(s);
		doThrow(new Exception()).when(mockEm).persist(c);
		boolean result = collectionsDaoHibernate.addColor(c);
		assertFalse(result);
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
	@Test
	public void happyPathGetCollectiblesTest(){
		List<Collectible> collectibles = new ArrayList<>();
		TypedQuery<Collectible> mockTypedQuery = mock(TypedQuery.class);
		when(mockEm.createQuery(anyString(), eq(Collectible.class)))
				.thenReturn(mockTypedQuery);
		when(mockTypedQuery.getResultList()).thenReturn(collectibles);
		collectionsDaoHibernate.setEm(mockEm);
		List<Collectible> result = collectionsDaoHibernate.getCollectibles();
		assertEquals(collectibles,result);
	}

	@Test
	public void happyPathGetCollectibleTest(){
		Collectible c = new Collectible();
		c.setId(0);
		TypedQuery<Collectible> mockTypedQuery = mock(TypedQuery.class);
		when(mockEm.createQuery(anyString(), eq(Collectible.class)))
				.thenReturn(mockTypedQuery);
		when(mockTypedQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedQuery);
		when(mockTypedQuery.getSingleResult()).thenReturn(c);
		collectionsDaoHibernate.setEm(mockEm);
		Collectible result = collectionsDaoHibernate.getCollectible(0);
		assertEquals(c, result);
	}
}
