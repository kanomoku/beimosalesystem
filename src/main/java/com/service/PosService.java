package com.service;

import java.util.List;

import com.pojo.Pos;

public interface PosService {

	int insertPos(Pos pos);

	List<Pos> showAllPos();

}
