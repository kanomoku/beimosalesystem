package com.mapper;

import java.util.List;
import java.util.Map;

import com.pojo.Goods;

public interface GoodsMapper {

	int insertGoods(Goods goods);

	List<Goods> selectAllGoods();

	List<Goods> selByPage(Map map);

	Long selCount();
}
