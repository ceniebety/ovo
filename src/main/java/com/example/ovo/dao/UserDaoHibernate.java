package com.example.ovo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.example.ovo.model.User;

@Repository
public class UserDaoHibernate implements UserDao{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		entityManager.persist(user);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		entityManager.merge(user);
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stube
		entityManager.remove(id);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("FROM User").getResultList();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	

}
