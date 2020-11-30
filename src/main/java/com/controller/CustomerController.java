package com.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pojo.Customer;
import com.service.CustomerService;

@Controller
public class CustomerController {
	@Resource
	private CustomerService customerServiceImpl;
	@RequestMapping("customerShow")
	public String show(Model model){
		List<Customer> customerlist = customerServiceImpl.showAllCustomer();
		model.addAttribute("customerList", customerlist);
		return "customerShow.jsp";
	}
}
