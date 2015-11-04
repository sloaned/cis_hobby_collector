package com.catalyst.collector.daos.hibernate;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.catalyst.collector.entities.Keyword;
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
        return (ArrayList<Keyword>)em.createQuery("SELECT UNIQUE k From Keyword k", Keyword.class).getResultList();
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
        Keyword keyword = em.createQuery("SELECT k FROM Task k WHERE k.id = :id", Keyword.class).setParameter("id", id).getSingleResult();
        em.remove(keyword);
    }

}
