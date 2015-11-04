package com.catalyst.collector.daos.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.catalyst.collector.entities.Age;
import com.catalyst.collector.entities.Category;
import com.catalyst.collector.entities.Collectible;
import com.catalyst.collector.entities.Color;
import org.springframework.stereotype.Repository;

import com.catalyst.collector.daos.CollectionsDao;

@Repository
@Transactional
public class CollectionsDaoHibernate implements CollectionsDao {

	@PersistenceContext
	private EntityManager em;
	
	
	public void setEm(EntityManager em) {
		this.em = em;
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


	@Override
	public void addCategory(Category category) {
		em.persist(category);

	}


	@Override
	public void updateCategory(Category category) {
		em.merge(category);

	}


	@Override
	public void deleteCategory(int id) {
		Category category = getByCategoryId(id);
		em.remove(category);

	}


	@Override
	public void addColor(Color addedColor) {
		em.persist(addedColor);
	}
	@Override
	public boolean removeColor(Color c) {
		em.remove(c);
		return true;
	}
	@Override
	public List<Color> getColorList() {
		return em.createQuery("SELECT c FROM Color c", Color.class).getResultList();
	}
	@Override
	public void updateColor(Color c) {
		em.merge(c);
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
