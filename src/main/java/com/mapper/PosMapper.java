package com.mapper;

import java.util.List;

import com.pojo.Pos;

public interface PosMapper {

	int insertPos(Pos pos);
	
	List<Pos> selectAllPos();
}
