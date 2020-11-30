package com.mapper;

import java.util.List;
import java.util.Map;

import com.pojo.Agency;

public interface AgencyMapper {

	int insertAgency(Agency agency);

	List<Agency> selectAllAgency();

	List<Agency> selByPage(Map map);

	Long selCount();
}
