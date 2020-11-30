package com.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mapper.StoreMapper;
import com.pojo.PageInfo;
import com.pojo.Store;
import com.service.StoreService;

@Service
public class StoreServiceImpl implements StoreService{
	@Resource
	private StoreMapper storeMapper;

/*	
 * 有@Resource 可以不用写set/get
 * public StoreMapper getStoreMapper() {
		return storeMapper;
	}
	public void setStoreMapper(StoreMapper storeMapper) {
		this.storeMapper = storeMapper;
	}*/

	@Override
	public List<Store> showAllStore() {
		List<Store> storeList = storeMapper.selectAllStore();
		return storeList;
	}

	@Override
	public int insertStore(Store store) {
		return storeMapper.insertStore(store);
	}

	@Override
	public PageInfo showPage(int pageSize, int pageNum){

		PageInfo pi = new PageInfo();
		pi.setPageNum(pageNum);
		pi.setPageSize(pageSize);
		
		Map<String, Object> map = new HashMap<>();
		map.put("pageStart", pageSize * (pageNum - 1));
		map.put("pageSize", pageSize);
		List<Store> storeList = storeMapper.selByPage(map);
		pi.setList(storeList);
		
		long count = storeMapper.selCount();
		pi.setTotal(count % pageSize == 0 ? count / pageSize : count / pageSize + 1);
		return pi;
	}
}
