package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mapper.AgencyMapper;
import com.pojo.Agency;
import com.service.AgencyService;

@Service
public class AgencyServiceImpl implements AgencyService{
	@Resource
	private AgencyMapper agencyMapper;

	
/*	
 * 有@Resource 可以不用写set/get
 * public AgencyMapper getAgencyMapper() {
		return agencyMapper;
	}
	public void setAgencyMapper(AgencyMapper agencyMapper) {
		this.agencyMapper = agencyMapper;
	}*/

	@Override
	public List<Agency> showAllAgency() {
		List<Agency> agencyList = agencyMapper.selectAllAgency();
		return agencyList;
	}

	@Override
	public int insertAgency(Agency Agency) {
		return agencyMapper.insertAgency(Agency);
	}

}
