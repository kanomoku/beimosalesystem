package com.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pojo.PageInfo;
import com.service.AgencyService;

@Controller
public class AgencyController {
	@Resource
	private AgencyService agencyServiceImpl;
	@RequestMapping("agencyShow")
	public String show(HttpServletRequest req,Model model){
		
		String pageSizeStr = req.getParameter("pageSize");
		String pageNumStr = req.getParameter("pageNum");
		int pageSize = 2;
		int pageNum = 1;
		if (pageSizeStr != null && !"".equals(pageSizeStr)) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		if (pageNumStr != null && !"".equals(pageNumStr)) {
			pageNum = Integer.parseInt(pageNumStr);
		}
		
		Logger logger = Logger.getLogger(AgencyController.class);
		logger.info("------------------------------------");
		
		
		PageInfo showPage = agencyServiceImpl.showPage(pageSize, pageNum);
		model.addAttribute("pageInfo", showPage);
		return "agencyShow.jsp";
	}
}
