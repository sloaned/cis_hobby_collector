package com.catalyst.collector.daos.hibernate;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

import com.catalyst.collector.entities.Collectible;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class CollectionsDaoHibernateTest {
	private CollectionsDaoHibernate target;

	private EntityManager mockEm;

	@Before
	public void setup() {
		target = new CollectionsDaoHibernate();
		mockEm = mock(EntityManager.class);
		target.setEm(mockEm);
	}

	@Test
	public void testGetCollection(){
		List<Collectible> expected = new ArrayList<>();

		TypedQuery<Collectible> mockTypedQuery = mock(TypedQuery.class);

		when(mockEm.createQuery(anyString(), eq(Collectible.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.getResultList()).thenReturn(expected);

		target.getCollectibles();

		verify(mockTypedQuery, times(1)).getResultList();
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
