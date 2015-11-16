package com.catalyst.collector.daos.hibernate;

import com.catalyst.collector.daos.SearchDao;
import com.catalyst.collector.entities.Collectible;
import com.catalyst.collector.entities.Search;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;

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
        String query = "SELECT c FROM Collectible c WHERE";
        String type = searchBody.getCategory();
        String color = searchBody.getColor();
        String condition = searchBody.getCondition();
        String age = searchBody.getAge();
        String description = searchBody.getDescription();
        String name = searchBody.getName();
        String keyword = searchBody.getKeyword();
        boolean soldStatus = searchBody.isSold();
        String catalogNumber = searchBody.getCatalogueNumber();

        if(type != null){

        }

        return (ArrayList<Collectible>)em.createQuery(query);
    }
}
