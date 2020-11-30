package com.service;

import java.util.List;

import com.pojo.Customer;
import com.pojo.PageInfo;

public interface CustomerService {

	int insertCustomer(Customer customer);

	List<Customer> showAllCustomer();

	PageInfo showPage(int pageSize, int pageNum);

}
