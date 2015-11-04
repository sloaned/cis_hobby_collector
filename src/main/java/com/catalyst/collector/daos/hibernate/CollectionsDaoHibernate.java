package com.catalyst.collector.daos.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.catalyst.collector.entities.Keyword;
import org.springframework.stereotype.Repository;

import com.catalyst.collector.daos.CollectionsDao;

import com.catalyst.collector.entities.Category;
import com.catalyst.collector.entities.Color;

@Repository
@Transactional
public class CollectionsDaoHibernate implements CollectionsDao {

	@PersistenceContext
	private EntityManager em;
	
	
	public void setEm(EntityManager em) {
		this.em = em;
	}

    @Override
    public ArrayList<Keyword> getAllKeywords() {
        return (ArrayList<Keyword>)em.createQuery("SELECT DISTINCT k From Keyword k", Keyword.class).getResultList();
    }

    @Override
    public void addKeyword(Keyword keyword) {
        em.persist(keyword);
    }

    public void updateKeyword(Keyword keyword) {
        em.merge(keyword);
    }

    @Override
    public void removeKeyword(Integer id) {
        Keyword keyword = em.createQuery("SELECT k FROM Keyword k WHERE k.id = :id", Keyword.class).setParameter("id", id).getSingleResult();
        em.remove(keyword);
    }

	@Override
	public ArrayList<Category> getCategory() {
		return (ArrayList<Category>)em
				.createQuery("SELECT c FROM Category c", Category.class)
				.getResultList();
	}

	@Override
	public Category getByCategoryId(int categoryId) {
		return em
				.createQuery("SELECT c FROM Category c WHERE c.categoryId = :ID", Category.class)
				.setParameter("ID",  categoryId)
				.getSingleResult();
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
	public void updateColor(Color c){
		em.merge(c);
	}

}
