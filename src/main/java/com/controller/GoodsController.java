package com.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pojo.Goods;
import com.service.GoodsService;

@Controller
public class GoodsController {
	@Resource
	private GoodsService goodsServiceImpl;
	@RequestMapping("show")
	public String show(Model model){
		List<Goods> goodslist = goodsServiceImpl.showAllGoods();
		model.addAttribute("list", goodslist);
		return "index.jsp";
	}
}
