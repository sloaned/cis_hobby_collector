package com.catalyst.collector.daos.hibernate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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

	public ArrayList<Age> getAgeTypes(){
		return (ArrayList<Age>) em.createQuery("SELECT t FROM Age t", Age.class).getResultList();
	}

	public void addAge(Age age){
		em.persist(age);
	}

	public Age getAgeById(int id) {
		return em.createQuery("SELECT c FROM Age c WHERE c.id = :id", Age.class).setParameter("id", id).getSingleResult();
	}

	public void updateAge(Age age){
		em.merge(age);
	}

	public void deleteAge(Integer id){
			Age age = em
					.createQuery("SELECT e FROM Age e WHERE e.id = :id", Age.class)
					.setParameter("id", id)
					.getSingleResult();
			em.remove(age);
	}

	@Override
	public boolean addCollectible(Collectible collectible) {
        try {
            System.out.println(collectible.getAge());
            if (collectible.getAge().getAge() != null) {
                Integer id = em.createQuery("SELECT a.id FROM Age a WHERE a.age = :age", Integer.class).setParameter("age", collectible.getAge().getAge()).getSingleResult();
                collectible.getAge().setId(id);
            }
        } catch (NoResultException e) {
            em.persist(collectible.getAge());
        }
        try {
            if (collectible.getCategory().getCategory() != null) {
                Integer id = em.createQuery("SELECT c.id FROM Category c WHERE c.category = :category", Integer.class).setParameter("category", collectible.getCategory().getCategory()).getSingleResult();
                collectible.getCategory().setId(id);
            }
        } catch (NoResultException e) {
            em.persist(collectible.getCategory());
        }
        try {
            if (collectible.getCondition().getCondition() != null) {
                Integer id = em.createQuery("SELECT c.id FROM Condition c WHERE c.condition = :condition", Integer.class).setParameter("condition", collectible.getCondition().getCondition()).getSingleResult();
                collectible.getCondition().setId(id);
            }
        } catch (NoResultException e) {
            em.persist(collectible.getCondition());
        }

        for (Color c : collectible.getColors())
            try {
                if (c.getColor() != null) {
                    Integer id = em.createQuery("SELECT c.id FROM Color c WHERE c.color = :color", Integer.class).setParameter("color", c.getColor()).getSingleResult();
                    c.setId(id);
                }
            } catch (NoResultException e) {
                em.persist(c);
            }
        for (Keyword k: collectible.getKeywords())
            try {
                if (k.getKeyword() != null) {
                    Integer id = em.createQuery("SELECT k.id FROM Keyword k WHERE k.keyword = :keyword", Integer.class).setParameter("keyword", k.getKeyword()).getSingleResult();
                    k.setId(id);
                }
            } catch (NoResultException e) {
                em.persist(k);
            }      
        em.merge(collectible);
        return true;
        
        
	}

    @Override
    public boolean updateCollectible(Collectible collectible) {
        try {
            System.out.println(collectible.getAge());
            if (collectible.getAge().getAge() != null) {
                Integer id = em.createQuery("SELECT a.id FROM Age a WHERE a.age = :age", Integer.class).setParameter("age", collectible.getAge().getAge()).getSingleResult();
                collectible.getAge().setId(id);
            }
        } catch (NoResultException e) {
            em.persist(collectible.getAge());
        }
        try {
            if (collectible.getCategory().getCategory() != null) {
                Integer id = em.createQuery("SELECT c.id FROM Category c WHERE c.category = :category", Integer.class).setParameter("category", collectible.getCategory().getCategory()).getSingleResult();
                collectible.getCategory().setId(id);
            }
        } catch (NoResultException e) {
            em.persist(collectible.getCategory());
        }
        try {
            if (collectible.getCondition().getCondition() != null) {
                Integer id = em.createQuery("SELECT c.id FROM Condition c WHERE c.condition = :condition", Integer.class).setParameter("condition", collectible.getCondition().getCondition()).getSingleResult();
                collectible.getCondition().setId(id);
            }
        } catch (NoResultException e) {
            em.persist(collectible.getCondition());
        }

        for (Color c : collectible.getColors())
            try {
                if (c.getColor() != null) {
                    Integer id = em.createQuery("SELECT c.id FROM Color c WHERE c.color = :color", Integer.class).setParameter("color", c.getColor()).getSingleResult();
                    c.setId(id);
                }
            } catch (NoResultException e) {
                em.persist(c);
            }
        for (Keyword k: collectible.getKeywords())
            try {
                if (k.getKeyword() != null) {
                    Integer id = em.createQuery("SELECT k.id FROM Keyword k WHERE k.keyword = :keyword", Integer.class).setParameter("keyword", k.getKeyword()).getSingleResult();
                    k.setId(id);
                }
            } catch (NoResultException e) {
                em.persist(k);
            }
        em.merge(collectible);
        return true;
    }

	@Override
	public boolean removeCollectible(int id) {
		Collectible c = em.createQuery("SELECT c from Collectible c where c.id = :id", Collectible.class).setParameter("id",id)
				.getSingleResult();

		em.remove(c);
		return true;
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
        em.merge(condition);
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
			em.persist(category);
			return true;
	}


	@Override
	public boolean updateCategory(Category category) {
			em.merge(category);
			return true;
	}

	@Override
	public boolean deleteCategory(int id) {
			Category category = getByCategoryId(id);
			em.remove(category);
			return true;
	}


	@Override
	public boolean addColor(Color addedColor) {
		em.persist(addedColor);
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
		Color color = getColor(id);
		em.remove(color);
		return true;
	}

	@Override
	public List<Color> getColorList() {
		return em.createQuery("SELECT c FROM Color c", Color.class).getResultList();
	}
	@Override
	public boolean updateColor(Color c) {
		em.merge(c);
		return true;
	}
	@Override
	public ArrayList<Collectible> getCollectibles() {
		return (ArrayList<Collectible>) em.createQuery("Select c FROM Collectible c ORDER BY c.id", Collectible.class).getResultList();
	}

	@Override
	public Collectible getCollectible(String catalogNumber) {
		return em.createQuery("SELECT c FROM Collectible c WHERE c.catalogNumber = :id", Collectible.class).setParameter("id", catalogNumber).getSingleResult();
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
		return (ArrayList<Keyword>)em.createQuery("SELECT DISTINCT k FROM Keyword k WHERE k.keyword LIKE :character", Keyword.class)
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
