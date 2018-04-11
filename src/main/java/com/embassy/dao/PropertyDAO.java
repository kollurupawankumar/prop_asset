package com.embassy.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.embassy.dao.entity.Property;


@Transactional
@Repository
public class PropertyDAO {

	
	@PersistenceContext
	private EntityManager entityManager;


	public Property add(Property t) {
		entityManager.persist(t);
		entityManager.flush();
		return t;
	}

	public Property update(Property t) {
		return entityManager.merge(t);
	}

	public Property getById(int id) {
		return entityManager.find(Property.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Property> findAll() {
		return entityManager.createQuery("Select t from Property t").getResultList();
	}
	
	public boolean delete(int id){
		entityManager.remove(getById(id));
		return true;
	}
}
