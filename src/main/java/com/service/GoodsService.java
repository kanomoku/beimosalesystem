package com.service;

import java.util.List;

import com.pojo.Goods;
import com.pojo.PageInfo;

public interface GoodsService {
	
	List<Goods> showAllGoods();
	
	int insertGoods(Goods goods);
	
	PageInfo showPage(int pageSize, int pageNum);

}
