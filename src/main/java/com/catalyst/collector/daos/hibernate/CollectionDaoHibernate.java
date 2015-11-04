package com.catalyst.collector.daos.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.catalyst.collector.entities.Collectible;
import org.springframework.stereotype.Repository;

import com.catalyst.collector.daos.CollectionDao;
import com.catalyst.collector.entities.TestData;

@Repository
@Transactional
public class CollectionDaoHibernate implements CollectionDao {

	@PersistenceContext
	private EntityManager em;
	
	
	public void setEm(EntityManager em) {
		this.em = em;
	}


	@Override
	public List<TestData> getTestData() {
		return em.createQuery("SELECT t FROM TestData t", TestData.class).
				getResultList();
	}

	@Override
	public ArrayList<Collectible> getCollectibles() {
		return (ArrayList<Collectible>) em.createQuery("Select * from COLLECTIBLE").getResultList();
	}

	@Override
	public Collectible getCollectible(int id) {
		return em.createQuery("SELECT c FROM COLLECTIBLE c WHERE c.id = :id", Collectible.class).setParameter("id", id).getSingleResult();
	}

}
