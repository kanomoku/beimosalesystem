package com.mapper;

import java.util.List;
import java.util.Map;

import com.pojo.Pos;

public interface PosMapper {

	int insertPos(Pos pos);

	List<Pos> selectAllPos();

	List<Pos> selByPage(Map map);

	List<Pos> selOrderByPage(Map map);

	Long selCount();

	List<Pos> selAllByYearMonthDay(Map map);
}
