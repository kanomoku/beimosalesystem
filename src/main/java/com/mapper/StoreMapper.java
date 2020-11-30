package com.mapper;

import java.util.List;
import java.util.Map;

import com.pojo.Store;

public interface StoreMapper {

	int insertStore(Store store);

	List<Store> selectAllStore();

	List<Store> selByPage(Map map);

	Long selCount();
}
