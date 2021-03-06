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
    private CriteriaBuilder cb;
    public void setEm(EntityManager em){
        this.em = em;
    }
    public void setCb(CriteriaBuilder cb) {this.cb = cb;}

    @Override
    public ArrayList<Collectible> search(Search searchBody) {

        List<Predicate> restrictions = new ArrayList<Predicate>();
        cb = em.getCriteriaBuilder();
        CriteriaQuery<Collectible> cq = cb.createQuery(Collectible.class);
        Root<Collectible> collectible = cq.from(Collectible.class);

        String type = searchBody.getCategory();
        String color = searchBody.getColor();
        String condition = searchBody.getCondition();
        String age = searchBody.getAge();
        String description = searchBody.getDescription();
        String name = searchBody.getName();
        String keyword = searchBody.getKeyword();
        Boolean soldStatus = searchBody.isSold();
        String catalogNumber = searchBody.getCatalogNumber();


        if(type != null && type != ""){
            Predicate predicate = cb.like(collectible.<Category>get("category").<String>get("category"), type);
            restrictions.add(predicate);
        }

        if(color != null && color != ""){
            Join<Collectible, Color> path = collectible.join("colors");
            Predicate predicate = cb.and(path.get("color").in(color));
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

        if(keyword != null && keyword != ""){
            Join<Collectible, Keyword> path = collectible.join("keywords");
            Predicate predicate = cb.and(path.get("keyword").in(keyword));
            restrictions.add(predicate);
        }

        if(soldStatus != null) {

            if (soldStatus == true) {
                Predicate predicate = cb.isTrue(collectible.<Boolean>get("sold"));
                restrictions.add(predicate);
            }

            if (soldStatus == false) {
                Predicate predicate = cb.isFalse(collectible.<Boolean>get("sold"));
                restrictions.add(predicate);
            }

        }

        if(catalogNumber != null && catalogNumber != ""){
            Predicate predicate = cb.like(collectible.<String>get("catalogueNumber"), catalogNumber);
            restrictions.add(predicate);
        }

        cq.where(restrictions.toArray(new Predicate[0]));
        cq.select(collectible);
        TypedQuery<Collectible> q = em.createQuery(cq);
        ArrayList<Collectible> collectibles = (ArrayList<Collectible>) q.getResultList();
        return collectibles;
    }
}


