package com.mapper;

import java.util.List;
import java.util.Map;

import com.pojo.Goods;
import com.pojo.Pos;

public interface PosMapper {

	int insertPos(Pos pos);

	List<Pos> selectAllPos();

	List<Pos> selByPage(Map map);

	Long selCount();
}
