package com.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mapper.CustomerMapper;
import com.pojo.Customer;
import com.pojo.PageInfo;
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
	
	@Override
	public PageInfo showPage(int pageSize, int pageNum){

		PageInfo pi = new PageInfo();
		pi.setPageNum(pageNum);
		pi.setPageSize(pageSize);
		
		Map<String, Object> map = new HashMap<>();
		map.put("pageStart", pageSize * (pageNum - 1));
		map.put("pageSize", pageSize);
		List<Customer> customerList = customerMapper.selByPage(map);
		pi.setList(customerList);
		
		long count = customerMapper.selCount();
		pi.setTotal(count % pageSize == 0 ? count / pageSize : count / pageSize + 1);
		return pi;
	}

}
