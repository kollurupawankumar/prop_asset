package com.embassy.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;


public class ApplicationDAO<T> {

	@PersistenceContext
	private EntityManager entityManager;

	Class<T> typeParameterClass;

	public T add(T t) {
		entityManager.persist(t);
		entityManager.flush();
		return t;
	}

	public T update(T t) {
		return entityManager.merge(t);
	}

	public T getById(int id) {
		return entityManager.find(typeParameterClass, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return entityManager.createQuery("Select t from " + typeParameterClass.getSimpleName() + " t").getResultList();
	}
	
	public boolean delete(int id){
		entityManager.remove(getById(id));
		return true;
	}

}
