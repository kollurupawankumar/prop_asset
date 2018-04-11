package com.embassy.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.embassy.dao.entity.Asset;
import com.embassy.dao.entity.Asset;


@Transactional
@Repository
public class AssetDAO {
	
	@PersistenceContext
	private EntityManager entityManager;


	public Asset add(Asset t) {
		entityManager.persist(t);
		entityManager.flush();
		return t;
	}

	public Asset update(Asset t) {
		return entityManager.merge(t);
	}

	public Asset getById(int id) {
		return entityManager.find(Asset.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Asset> findAll() {
		return entityManager.createQuery("Select t from Asset t").getResultList();
	}
	
	public boolean delete(int id){
		entityManager.remove(getById(id));
		return true;
	}

}
