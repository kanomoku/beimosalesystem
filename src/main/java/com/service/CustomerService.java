package com.service;

import java.util.List;

import com.pojo.Customer;

public interface CustomerService {

	int insertCustomer(Customer customer);

	List<Customer> showAllCustomer();

}
