package com.catalyst.collector.daos.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.catalyst.collector.entities.Keyword;
import org.springframework.stereotype.Repository;

import com.catalyst.collector.daos.TestDataDao;
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
    public ArrayList<Keyword> getAllKeywords() {
        return (ArrayList<Keyword>)em.createQuery("SELECT UNIQUE k From Keyword k", Keyword.class).getResultList();
    }

    @Override
    public void addKeyword(Keyword keyword) {
        em.persist(keyword);
    }

    @Override
    public Keyword getKeyword(Integer id) {
        return em.createQuery("SELECT k FROM Keyword k WHERE k.id = :id", Keyword.class).setParameter("id", id).getSingleResult();
    }

    @Override
    public void removeKeyword(Integer id) {
        em.remove(getKeyword(id));
    }

}
