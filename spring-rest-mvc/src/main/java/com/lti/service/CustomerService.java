package com.lti.service;

import com.lti.entity.Customer;
import com.lti.exception.CustomerServiceException;

public interface CustomerService {

	public int register(Customer customer);
	public Customer login(String email,String password)throws CustomerServiceException;
}
