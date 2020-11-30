package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mapper.GoodsMapper;
import com.pojo.Goods;
import com.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService{
	@Resource
	private GoodsMapper goodsMapper;

/*	
 * 有@Resource 可以不用写set/get
 * public GoodsMapper getGoodsMapper() {
		return goodsMapper;
	}
	public void setGoodsMapper(GoodsMapper goodsMapper) {
		this.goodsMapper = goodsMapper;
	}*/

	@Override
	public List<Goods> showAllGoods() {
		List<Goods> goodsList = goodsMapper.selectAllGoods();
		return goodsList;
	}

	@Override
	public int insertGoods(Goods goods) {
		return goodsMapper.insertGoods(goods);
	}

}
