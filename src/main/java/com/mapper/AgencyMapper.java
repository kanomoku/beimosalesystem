package com.mapper;

import java.util.List;

import com.pojo.Agency;

public interface AgencyMapper {

	int insertAgency(Agency agency);
	
	List<Agency> selectAllAgency();
}
