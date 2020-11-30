package com.mapper;

import java.util.List;

import com.pojo.Store;

public interface StoreMapper {

	int insertStore(Store store);
	
	List<Store> selectAllStore();
}
