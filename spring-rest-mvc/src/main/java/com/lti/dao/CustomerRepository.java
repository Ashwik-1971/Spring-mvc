package com.lti.dao;


import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository extends GenericDao {
	
	public boolean isCustomerPresent(String email) {
		return(Long)
				entityManager.createQuery("select count(c.id) from Customer c where c.email= :email")
				.setParameter("email",email)
				.getSingleResult()==1?true:false;
	}
	
	public int findByEmailAndPassword(String email,String password) {
		return (Integer) entityManager
				.createQuery("select c.id from Customer c where c.email=:email and c.password= :password")
				.setParameter("email", email)
				.setParameter("password", password)
				.getSingleResult();
	}

}
