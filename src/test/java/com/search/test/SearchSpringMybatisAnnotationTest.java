package com.search.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pojo.Agency;
import com.pojo.Customer;
import com.pojo.Goods;
import com.pojo.Pos;
import com.pojo.Store;
import com.service.impl.AgencyServiceImpl;
import com.service.impl.CustomerServiceImpl;
import com.service.impl.GoodsServiceImpl;
import com.service.impl.PosServiceImpl;
import com.service.impl.StoreServiceImpl;

public class SearchSpringMybatisAnnotationTest {
	public static void main(String[] args) {

		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContextSpringMybatisAnnotation.xml");
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`");
		String[] beanDefinitionNames = ac.getBeanDefinitionNames();
		for (String string : beanDefinitionNames) {
			System.out.println(string);
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`");

		Logger logger = Logger.getLogger(SearchSpringMybatisAnnotationTest.class);

		logger.info("--------------------search goods");
		GoodsServiceImpl goodsServiceImpl = ac.getBean("goodsServiceImpl", GoodsServiceImpl.class);
		List<Goods> goods = goodsServiceImpl.showAllGoods();
		for (int i = 0; i < goods.size(); i++) {
			System.out.print(goods.get(i));
		}
		
		logger.info("--------------------search Agency");
		AgencyServiceImpl agencyServiceImpl = ac.getBean("agencyServiceImpl", AgencyServiceImpl.class);
		List<Agency> agencyList = agencyServiceImpl.showAllAgency();
		for (int i = 0; i < agencyList.size(); i++) {
			System.out.print(agencyList.get(i));
		}
		
		logger.info("--------------------search Customer");
		CustomerServiceImpl customerServiceImpl = ac.getBean("customerServiceImpl", CustomerServiceImpl.class);
		List<Customer> customerList = customerServiceImpl.showAllCustomer();
		for (int i = 0; i < customerList.size(); i++) {
			System.out.print(customerList.get(i));
		}
		
		logger.info("--------------------search Store");
		StoreServiceImpl storeServiceImpl = ac.getBean("storeServiceImpl", StoreServiceImpl.class);
		List<Store> storeList = storeServiceImpl.showAllStore();
		for (int i = 0; i < storeList.size(); i++) {
			System.out.print(storeList.get(i));
		}
		
		logger.info("--------------------search Pos");
		PosServiceImpl posServiceImpl = ac.getBean("posServiceImpl", PosServiceImpl.class);
		List<Pos> posList = posServiceImpl.showAllPos();
		for (int i = 0; i < posList.size(); i++) {
			System.out.print(posList.get(i));
		}

	}

}
