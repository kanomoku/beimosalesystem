package com.service;

import java.util.List;

import com.pojo.Agency;
import com.pojo.PageInfo;

public interface AgencyService {

	int insertAgency(Agency agency);

	List<Agency> showAllAgency();
	
	PageInfo showPage(int pageSize, int pageNum);

}
