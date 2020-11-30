package com.service;

import java.util.List;

import com.pojo.Goods;

public interface GoodsService {
	
	List<Goods> showAllGoods();
	
	int insertGoods(Goods goods);

}
