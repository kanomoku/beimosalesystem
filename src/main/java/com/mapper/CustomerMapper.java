package com.mapper;

import java.util.List;

import com.pojo.Customer;

public interface CustomerMapper {

	int insertCustomer(Customer customer);
	
	List<Customer> selectAllCustomer();
}
