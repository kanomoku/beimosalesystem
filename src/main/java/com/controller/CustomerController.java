package com.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pojo.PageInfo;
import com.service.CustomerService;

@Controller
public class CustomerController {
	@Resource
	private CustomerService customerServiceImpl;
	@RequestMapping("customerShow")
	public String show(HttpServletRequest req,Model model){
		
		String pageSizeStr = req.getParameter("pageSize");
		String pageNumStr = req.getParameter("pageNum");
		int pageSize = 25;
		int pageNum = 1;
		if (pageSizeStr != null && !"".equals(pageSizeStr)) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		if (pageNumStr != null && !"".equals(pageNumStr)) {
			pageNum = Integer.parseInt(pageNumStr);
		}
		
		Logger logger = Logger.getLogger(CustomerController.class);
		logger.info("------------------------------------");
		
		
		PageInfo showPage = customerServiceImpl.showPage(pageSize, pageNum);
		model.addAttribute("pageInfo", showPage);
		return "customerShow.jsp";
	}
}
