package com.catalyst.collector.daos.hibernate;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.catalyst.collector.daos.UserDao;
import com.catalyst.collector.entities.Username;

@Repository
@Transactional
public class UserDaoHibernate implements UserDao{

	@PersistenceContext
	private EntityManager em;
	
	
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public ArrayList<Username> getAllUsers() {
		return (ArrayList<Username>) em.createQuery("SELECT u FROM Username u", Username.class).getResultList();
	}

	@Override
	public Username getUserById(int id) {
		return em.createQuery("SELECT u FROM Username u WHERE u.id = :id", Username.class).setParameter("id",  id).getSingleResult();
	}
	
	@Override
	public Username getUserByName(String Name){
		return em.createQuery("SELECT u FROM Username u WHERE u.username = :name", Username.class).setParameter("name", Name).getSingleResult();
	}
	
	@Override
	public boolean nameInUse(String Name){
		ArrayList<Username> results = (ArrayList<Username>) em.createQuery("SELECT u FROM Username u WHERE u.username = :name", Username.class).setParameter("name", Name).getResultList();
		return(results != null && results.size() != 0);
	}

	@Override
	public boolean addUser(Username user) {
		em.persist(user);
		return true;
	}

	@Override
	public boolean updateUser(Username user) {
		em.merge(user);
		return true;
	}

	@Override
	public boolean deleteUser(int id) {
		Username user = getUserById(id);
		em.remove(user);
		return true;
	}

}
