package com.catalyst.collector.daos.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;


import org.hibernate.Session;

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



	public boolean addAge(Age age){
		String ageString = age.getAge();
		if(ageString.length() < 256 && !ageString.matches(".*\\d.*")) {
			em.persist(age);
			return true;
		}
		return false;

	}

	public ArrayList<Age> getAgeTypes(){
		return (ArrayList<Age>) em.createQuery("SELECT t FROM Age t", Age.class).getResultList();
	}

	public boolean updateAge(Age age){
		String ageString = age.getAge();
		if(ageString.length() < 256 && !ageString.matches(".*\\d.*")) {
			em.merge(age);
			return true;
		}
		return false;
	}

	public boolean deleteAge(Integer id){
		if(id > 0) {
			Age age = em
					.createQuery("SELECT e FROM Age e WHERE e.id = :id", Age.class)
					.setParameter("id", id)
					.getSingleResult();
			em.remove(age);
			return true;
		}
		return false;
	}

	@Override
	public void addCollectible(Collectible collectible) {
		em.persist(collectible);
	}

	@Override
	public void updateCollectible(Collectible collectible) {
		em.merge(collectible);
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
	public boolean addCategory(Category category) {
		try{
			em.persist(category);
			return true;
		}catch(Exception e){
			return false;
		}
	}


	@Override
	public boolean updateCategory(Category category) {
		try{
			em.merge(category);
			return true;
		}catch(Exception e){
			return false;
		}

	}


	@Override
	public boolean deleteCategory(int id) {
		try{
			Category category = getByCategoryId(id);
			em.remove(category);
			return true;
		}catch(Exception e){
			return false;
		}

	}


	@Override
	public boolean addColor(Color addedColor) {
		try{
		em.persist(addedColor);
		}
		catch(Exception e){
			return false;
		}
		return true;
	}
	@Override

	public Color getColor(int colorId) {
		return em
				.createQuery("SELECT c FROM Color c WHERE c.id = :ID", Color.class)
				.setParameter("ID",  colorId)
				.getSingleResult();
	}
	@Override

	public boolean removeColor(int id) {
		try{
		Color color = getColor(id);
		em.remove(color);
		}
		catch(Exception e){
			return false;
		}
		return true;
	}

	public Color getByColorId(int colorId){
		return em
				.createQuery("SELECT c FROM Color c WHERE c.idd = :ID", Color.class)
				.setParameter("ID",  colorId)
				.getSingleResult();
	}
	@Override
	public List<Color> getColorList() {
		return em.createQuery("SELECT c FROM Color c", Color.class).getResultList();
	}
	@Override
	public boolean updateColor(Color c) {
		try{
		em.merge(c);
		}
		catch(Exception e){
			return false;
		}
		return true;
	}
	@Override
	public ArrayList<Collectible> getCollectibles() {
		return (ArrayList<Collectible>) em.createQuery("Select c FROM Collectible c", Collectible.class).getResultList();
	}

	@Override
	public Collectible getCollectible(int id) {
		return em.createQuery("SELECT c FROM Collectible c WHERE c.id = :id", Collectible.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public ArrayList<Keyword> getAllKeywords() {
		return (ArrayList<Keyword>)em.createQuery("SELECT DISTINCT k From Keyword k", Keyword.class).getResultList();
	}
	
	@Override
	public ArrayList<Keyword> getKeywordsByLetter(String letter){
		return (ArrayList<Keyword>)em.createQuery("SELECT DISTINCT k FROM Keyword k WHERE k.word LIKE :character", Keyword.class)
				.setParameter("character",  letter+"%")
				.getResultList();
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

}
