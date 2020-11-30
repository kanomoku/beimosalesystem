package com.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mapper.AgencyMapper;
import com.pojo.Agency;
import com.pojo.PageInfo;
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
	
	@Override
	public PageInfo showPage(int pageSize, int pageNum){

		PageInfo pi = new PageInfo();
		pi.setPageNum(pageNum);
		pi.setPageSize(pageSize);
		
		Map<String, Object> map = new HashMap<>();
		map.put("pageStart", pageSize * (pageNum - 1));
		map.put("pageSize", pageSize);
		List<Agency> agencyList = agencyMapper.selByPage(map);
		pi.setList(agencyList);
		
		long count = agencyMapper.selCount();
		pi.setTotal(count % pageSize == 0 ? count / pageSize : count / pageSize + 1);
		return pi;
	}

}
