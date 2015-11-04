package com.catalyst.collector.daos.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.catalyst.collector.daos.CollectionsDao;
import com.catalyst.collector.entities.Color;

@Repository
@Transactional
public class CollectionsHibernate implements CollectionsDao {

	@PersistenceContext
	private EntityManager em;
	
	
	public void setEm(EntityManager em) {
		this.em = em;
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
	public void updateColor(Color c){
		em.merge(c);
	}



	
}
