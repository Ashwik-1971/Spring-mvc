package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

//@Component
@Repository //recommended for classes which interacts with Data Base
public class GenericDao {

	@PersistenceContext
	protected EntityManager entityManager;
	
	public Object save(Object obj) {
		Object updatedObj=entityManager.merge(obj);
		return updatedObj;
	}

  	public <E> E fetch(Class<E> clazz,Object pk) {
  		E e=entityManager.find(clazz,pk);
  		return e;
}
}
