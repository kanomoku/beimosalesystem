package com.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pojo.PageInfoAll;
import com.service.GoalCompletionService;

@Controller
public class GoalComplementionControler {
	@Resource
	private GoalCompletionService goalCompletionService;
	
	@RequestMapping("posGoalShow")
	public String orderShow(HttpServletRequest req,Model model){
		
		String posYear = req.getParameter("posYear");
		String posMonth = req.getParameter("posMonth");
		String posDay = req.getParameter("posDay");
		String newCustomerGoalStr = req.getParameter("newCustomerGoal");
		String visitCustomerGoalStr = req.getParameter("visitCustomerGoal");
		
		int newCustomerGoal = 1000;
		int visitCustomerGoal = 1000;
		if (newCustomerGoalStr != null && !"".equals(newCustomerGoalStr)) {
			newCustomerGoal = Integer.parseInt(newCustomerGoalStr);
		}
		if (visitCustomerGoalStr != null && !"".equals(visitCustomerGoalStr)) {
			visitCustomerGoal = Integer.parseInt(visitCustomerGoalStr);
		}
		
		Logger logger = Logger.getLogger(GoalComplementionControler.class);
		logger.info("------------------------------------");
		
		String goalMessage = goalCompletionService.getGoalCompletionReport(posYear,posMonth,posDay,newCustomerGoal, visitCustomerGoal);
		model.addAttribute("goalMessage", goalMessage);
		return "goalCompletionReport.jsp";
	}
}
