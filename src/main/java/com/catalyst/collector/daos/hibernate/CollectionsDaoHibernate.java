package com.catalyst.collector.daos.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.catalyst.collector.entities.*;
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
    public ArrayList<Condition> getAllConditions() {
        return (ArrayList<Condition>) em.createQuery("SELECT c FROM Condition c", Condition.class).getResultList();
    }

    @Override
    public void addCondition(Condition condition) {
        em.persist(condition);
    }

    @Override
    public void updateCondition(Condition condition) {
        em.persist(condition);
    }

    @Override
    public void deleteCondition(Integer id) {
        Condition condition = em.createQuery("SELECT c FROM Condition c WHERE c.id = :id", Condition.class).setParameter("id", id).getSingleResult();
        em.remove(condition);
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
