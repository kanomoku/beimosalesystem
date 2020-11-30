package com.mapper;

import java.util.List;
import java.util.Map;

import com.pojo.Customer;

public interface CustomerMapper {

	int insertCustomer(Customer customer);

	List<Customer> selectAllCustomer();

	List<Customer> selByPage(Map map);

	Long selCount();
}
