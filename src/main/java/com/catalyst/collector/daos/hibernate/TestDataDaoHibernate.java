package com.catalyst.collector.daos.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.catalyst.collector.daos.TestDataDao;
import com.catalyst.collector.entities.Category;
import com.catalyst.collector.entities.TestData;

@Repository
@Transactional
public class TestDataDaoHibernate implements TestDataDao {

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
	public ArrayList<Category> getCategory() {
		return (ArrayList<Category>)em
				.createQuery("SELECT c FROM Category c", Category.class)
				.getResultList();
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
	public Category getByCategoryId(int categoryId) {
		return em
				.createQuery("SELECT c FROM Category c WHERE c.id = :ID", Category.class)
				.setParameter("ID",  categoryId)
				.getSingleResult();
	}

}
