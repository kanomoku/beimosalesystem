package com.service;

import java.util.List;

import com.pojo.Store;

public interface StoreService {

	int insertStore(Store store);

	List<Store> showAllStore();

}
