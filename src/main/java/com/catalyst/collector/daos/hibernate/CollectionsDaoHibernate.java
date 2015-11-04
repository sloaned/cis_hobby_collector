package com.catalyst.collector.daos.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.catalyst.collector.entities.Age;
import org.springframework.stereotype.Repository;

import com.catalyst.collector.daos.CollectionsDao;
import com.catalyst.collector.entities.TestData;

@Repository
@Transactional
public class CollectionsDaoHibernate implements CollectionsDao {

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

	public void addAge(Age age){
		em.persist(age);
	}

	public ArrayList<Age> getAgeTypes(){
		return (ArrayList<Age>) em.createQuery("SELECT t FROM Age t", Age.class).getResultList();
	}

	public void updateAge(Age age){
		em.merge(age);
	}

	public void deleteAge(Integer id){
		Age age = em
				.createQuery("SELECT e FROM Age e WHERE e.id = :id", Age.class)
				.setParameter("id", id)
				.getSingleResult();
		em.remove(age);
	}

}
