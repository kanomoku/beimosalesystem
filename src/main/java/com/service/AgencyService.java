package com.service;

import java.util.List;

import com.pojo.Agency;

public interface AgencyService {

	int insertAgency(Agency agency);

	List<Agency> showAllAgency();

}
