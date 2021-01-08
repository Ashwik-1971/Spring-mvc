package com.lti.dao;

import com.lti.dto.Status;

public class RegisterStatus extends Status {
	
	private int registeredCustomerId;

	public int getRegisteredCustomerId() {
		return registeredCustomerId;
	}

	public void setRegisteredCustomerId(int registeredCustomerId) {
		this.registeredCustomerId = registeredCustomerId;
	}
	
	

}
