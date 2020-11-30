package com.service;

import java.util.List;

import com.pojo.PageInfo;
import com.pojo.Store;

public interface StoreService {

	int insertStore(Store store);

	List<Store> showAllStore();
	
	PageInfo showPage(int pageSize, int pageNum);

}
