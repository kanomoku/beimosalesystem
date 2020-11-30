package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mapper.StoreMapper;
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

}
