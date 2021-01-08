package com.lti.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lti.dao.CustomerRepository;
import com.lti.entity.Customer;
import com.lti.exception.CustomerServiceException;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	public int register(Customer customer) {
		Customer updatedCustomer =(Customer) customerRepository.save(customer);
		return updatedCustomer.getId();
	}


	public Customer login(String email, String password) throws CustomerServiceException {
		try {
			if(!customerRepository.isCustomerPresent(email))
				throw new CustomerServiceException("Customer not registered");
			int id=customerRepository.findByEmailAndPassword(email, password);
			Customer customer=customerRepository.fetch(Customer.class,id);
			return customer;
		}
		catch(EmptyResultDataAccessException e) {
			throw new CustomerServiceException("Incorrect email/password");
		}
	}

}
