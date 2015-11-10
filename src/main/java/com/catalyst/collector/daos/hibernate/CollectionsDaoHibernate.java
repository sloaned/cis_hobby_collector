package com.catalyst.collector.daos.hibernate;

import java.util.ArrayList;
import java.util.HashSet;
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

		System.out.println("----------------------------------------------------------------------------------------------");
		loadDummyCollectibles();
	}

	private void loadDummyCollectibles() {
		Collectible c = new Collectible();
		c.setAge(new Age());
		c.setCategory(new Category());
		c.setColor(new Color());
		c.setCondition(new Condition());
		c.setKeywords(new HashSet<>());
		c.getKeywords().add(new Keyword());
		c.getKeywords().add(new Keyword());
		c.getKeywords().add(new Keyword());
		ArrayList<String> words = new ArrayList<>();
		words.add("bird");
		words.add("is");
		words.add("word");

		c.setDescription("This is a thing");
		c.setName("someThing");
		c.setCatalogueNumber("aaa-1111111111111");
		c.getAge().setAge("Ancient");
		c.getCategory().setCategory("Penny");
		c.getCondition().setCondition("Mint");
		c.getColor().setColor("Red");
		int i = 0;
		for (Keyword k: c.getKeywords()) {
			k.setKeyword(words.get(i++));
		}
		em.flush();
		em.persist(c);
		em.flush();
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
		if(collectible.getAge().getAge() == null || collectible.getCategory().getCategory() == null
				|| collectible.getColor().getColor() == null|| collectible.getCondition().getCondition() == null)
			em.merge(collectible);
		else
			em.persist(collectible);
		return true;
	}

	@Override
	public boolean updateCollectible(Collectible collectible) {
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
		return (ArrayList<Collectible>) em.createQuery("Select c FROM Collectible c", Collectible.class).getResultList();
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
