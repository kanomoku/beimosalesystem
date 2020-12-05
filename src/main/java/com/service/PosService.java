package com.service;

import java.util.List;

import com.pojo.PageInfo;
import com.pojo.PageInfoAll;
import com.pojo.Pos;

public interface PosService {

	int insertPos(Pos pos);

	List<Pos> showAllPos();
	
	PageInfo showPage(int pageSize, int pageNum);

	PageInfoAll showOrderPage(String posYear, String posMonth, String posDay, int pageSize, int pageNum);

}
