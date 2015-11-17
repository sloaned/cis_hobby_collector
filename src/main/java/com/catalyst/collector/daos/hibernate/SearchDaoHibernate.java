package com.catalyst.collector.daos.hibernate;

import com.catalyst.collector.daos.SearchDao;
import com.catalyst.collector.entities.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gfisher on 11/16/2015.
 */
@Repository
@Transactional
public class SearchDaoHibernate implements SearchDao{

    @PersistenceContext
    private EntityManager em;

    public void setEm(EntityManager em){
        this.em = em;
    }

    @Override
    public ArrayList<Collectible> search(Search searchBody) {

        List<Predicate> restrictions = new ArrayList<Predicate>(); //Greg needs to look this up.

        CriteriaBuilder cb = em.getCriteriaBuilder(); //Greg needs to look this up.
        CriteriaQuery<Collectible> cq = cb.createQuery(Collectible.class);//Greg needs to look this up.
        Root<Collectible> collectible = cq.from(Collectible.class);//Greg needs to look this up.

        String type = searchBody.getCategory();
        String color = searchBody.getColor();
        String condition = searchBody.getCondition();
        String age = searchBody.getAge();
        String description = searchBody.getDescription();
        String name = searchBody.getName();
        String keyword = searchBody.getKeyword();
        boolean soldStatus = searchBody.isSold();
        String catalogNumber = searchBody.getCatalogueNumber();


        if(type != null && type != ""){
            Predicate predicate = cb.like(collectible.<Category>get("category").<String>get("category"), type);
            restrictions.add(predicate);
        }

        if(color != null && color != ""){
            Predicate predicate = cb.like(collectible.<Color>get("color").<String>get("color"), color);
            restrictions.add(predicate);
        }

        if(condition != null && condition != ""){
            Predicate predicate = cb.like(collectible.<Condition>get("condition").<String>get("condition"), condition);
            restrictions.add(predicate);
        }

        if(age != null && age != ""){
            Predicate predicate = cb.like(collectible.<Age>get("age").<String>get("age"), age);
            restrictions.add(predicate);
        }

        if(description != null && description != ""){
            Predicate predicate = cb.like(collectible.<String>get("description"), "%" + description + "%");
            restrictions.add(predicate);
        }

        if(name != null && name != ""){
            Predicate predicate = cb.like(collectible.<String>get("name"),name);
            restrictions.add(predicate);
        }

    /*    if(keyword != null && keyword != ""){
            Join<Collectible, Keyword> path = collectible.join("keyword");
            Predicate predicate = cb.and(path.get("keyword").in(keyword));
            restrictions.add(predicate);
        }
    */
        if(soldStatus){
            Predicate predicate = cb.isTrue(collectible.<Boolean>get("sold"));
            restrictions.add(predicate);
        }
        else{
            Predicate predicate = cb.isFalse(collectible.<Boolean>get("sold"));
            restrictions.add(predicate);
        }

    /*    if(catalogNumber != null && catalogNumber != ""){
            Predicate predicate = cb.like(collectible.<String>get("cataloguenumber"), catalogNumber);
            restrictions.add(predicate);
        }
    */
        cq.where(restrictions.toArray(new Predicate[0]));
        cq.select(collectible);

        TypedQuery<Collectible> q = em.createQuery(cq);
        ArrayList<Collectible> collectibles = (ArrayList<Collectible>) q.getResultList();

        return collectibles;


    }
}


