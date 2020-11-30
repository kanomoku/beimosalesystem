package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mapper.PosMapper;
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

}
