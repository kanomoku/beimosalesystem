package com.mapper;

import java.util.List;

import com.pojo.Goods;

public interface GoodsMapper {

	int insertGoods(Goods goods);
	
	List<Goods> selectAllGoods();
}
