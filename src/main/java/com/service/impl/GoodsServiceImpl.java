package com.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mapper.GoodsMapper;
import com.pojo.Agency;
import com.pojo.Goods;
import com.pojo.PageInfo;
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

	@Override
	public PageInfo showPage(int pageSize, int pageNum) {

		PageInfo pi = new PageInfo();
		pi.setPageNum(pageNum);
		pi.setPageSize(pageSize);

		Map<String, Object> map = new HashMap<>();
		map.put("pageStart", pageSize * (pageNum - 1));
		map.put("pageSize", pageSize);
		List<Goods> goodsList = goodsMapper.selByPage(map);
		pi.setList(goodsList);

		long count = goodsMapper.selCount();
		pi.setTotal(count % pageSize == 0 ? count / pageSize : count / pageSize + 1);
		return pi;
	}
}
