package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mapper.CustomerMapper;
import com.pojo.Customer;
import com.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Resource
	private CustomerMapper customerMapper;

/*	
 * 有@Resource 可以不用写set/get
 * public CustomerMapper getCustomerMapper() {
		return customerMapper;
	}
	public void setCustomerMapper(CustomerMapper customerMapper) {
		this.customerMapper = customerMapper;
	}*/

	@Override
	public List<Customer> showAllCustomer() {
		List<Customer> customerList = customerMapper.selectAllCustomer();
		return customerList;
	}

	@Override
	public int insertCustomer(Customer customer) {
		return customerMapper.insertCustomer(customer);
	}

}
