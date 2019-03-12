package com.bags.dao;

import com.bags.model.Customer;
import com.bags.model.User;

public interface CustomerDao {
	void registerCustomer(Customer customer);
	boolean isEmailUnique(String email); // input from the user [email is unique]
	User getById(String email);
}
