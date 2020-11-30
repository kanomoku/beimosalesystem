package com.search.test;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pojo.PageInfo;
import com.service.impl.CustomerServiceImpl;

public class pageTest {
	public static void main(String[] args) {

		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`");
		String[] beanDefinitionNames = ac.getBeanDefinitionNames();
		for (String string : beanDefinitionNames) {
			System.out.println(string);
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`");

		Logger logger = Logger.getLogger(pageTest.class);

		logger.info("--------------------search goods");
		CustomerServiceImpl customerServiceImpl = ac.getBean("customerServiceImpl", CustomerServiceImpl.class);
		PageInfo showPage = customerServiceImpl.showPage(2, 1);
		System.out.print(showPage.toString());
	}
}
