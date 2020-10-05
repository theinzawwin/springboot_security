package com.springboot.best.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import com.springboot.best.model.Item;

public class ItemCustomCriteriaRepositoryImpl implements ItemCustomCriteriaRepository {

	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public List<Item> findItemList() {
		// TODO Auto-generated method stub
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<Item> query = cb.createQuery(Item.class); 
      //  Root<Item> item = query.from(Item.class);
        List<Item> itemList= entityManager.createQuery(query).getResultList();
		return itemList;
	}

	@Override
	public List<Item> findItemListByQuery() {
		// TODO Auto-generated method stub
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
	//	CriteriaQuery<Item> query = cb.createQuery(Item.class); 
      //  Root<Item> item = query.from(Item.class);
        TypedQuery<Item> iquery=entityManager.createQuery("select i from Item i", Item.class);
		return iquery.getResultList();
		
	}

	@Override
	public Item findItemById(Long id) {
		// TODO Auto-generated method stub
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		
		CriteriaQuery<Item> q = cb.createQuery(Item.class);
		  Root<Item> c = q.from(Item.class);
		  ParameterExpression<Long> p = cb.parameter(Long.class);
		  q.select(c).where(cb.equal(c.get("id"), p));
		  TypedQuery<Item> query = entityManager.createQuery(q);
		  query.setParameter(p, id);
		  Item i = query.getSingleResult();
		return i;
	}

}
