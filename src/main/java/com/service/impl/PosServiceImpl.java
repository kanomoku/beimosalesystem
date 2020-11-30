package com.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mapper.PosMapper;
import com.pojo.PageInfo;
import com.pojo.Pos;
import com.service.PosService;

@Service
public class PosServiceImpl implements PosService{
	@Resource
	private PosMapper posMapper;

/*	
 * 有@Resource 可以不用写set/get
 * public PosMapper getPosMapper() {
		return posMapper;
	}
	public void setPosMapper(PosMapper posMapper) {
		this.posMapper = posMapper;
	}*/

	@Override
	public List<Pos> showAllPos() {
		List<Pos> posList = posMapper.selectAllPos();
		return posList;
	}

	@Override
	public int insertPos(Pos pos) {
		return posMapper.insertPos(pos);
	}

	@Override
	public PageInfo showPage(int pageSize, int pageNum){

		PageInfo pi = new PageInfo();
		pi.setPageNum(pageNum);
		pi.setPageSize(pageSize);
		
		Map<String, Object> map = new HashMap<>();
		map.put("pageStart", pageSize * (pageNum - 1));
		map.put("pageSize", pageSize);
		List<Pos> posList = posMapper.selByPage(map);
		pi.setList(posList);
		
		long count = posMapper.selCount();
		pi.setTotal(count % pageSize == 0 ? count / pageSize : count / pageSize + 1);
		return pi;
	}
}
