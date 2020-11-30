package com.insert.test;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.mapper.AgencyMapper;
import com.mapper.CustomerMapper;
import com.mapper.GoodsMapper;
import com.mapper.PosMapper;
import com.mapper.StoreMapper;
import com.pojo.Agency;
import com.pojo.Customer;
import com.pojo.Goods;
import com.pojo.Pos;
import com.pojo.Store;

public class InsertDataMybatisTest {
	public static void main(String[] args) {
		try {
			InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
			SqlSession sqlSession = sqlSessionFactory.openSession();

			StoreMapper storeMapper = sqlSession.getMapper(StoreMapper.class);
			CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
			GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
			PosMapper posMapper = sqlSession.getMapper(PosMapper.class);
			AgencyMapper agencyMapper = sqlSession.getMapper(AgencyMapper.class);

			Logger logger = Logger.getLogger(InsertDataMybatisTest.class);

			logger.info("--------------------insert agency");
			Agency agency = new Agency();
			agency.setAgency_num(2050501);
			agency.setAgency_username("abc");
			agency.setAgency_password("abc");
			agency.setAgency_name("张紫");
			agency.setAgency_telephone("16688889999");
			agency.setAgency_gender("男");
			agency.setAgency_year("1991");
			agency.setAgency_month("11");
			agency.setAgency_remark("负责人备注");
			agencyMapper.insertAgency(agency);

			logger.info("--------------------insert Customer");
			Customer customer = new Customer();
			customer.setCustomer_num(2050500001001L);
			customer.setCustomer_name("张紫娃");
			customer.setCustomer_telephone("16688889999");
			customer.setCustomer_gender("男");
			customer.setCustomer_year("1991");
			customer.setCustomer_month("11");
			customer.setCustomer_remark("负责人备注");
			customerMapper.insertCustomer(customer);

			logger.info("--------------------insert store");
			Store store = new Store();
			store.setStore_num(2050500001);
			store.setStore_name("六六萝卜干超市");
			store.setStore_province("辽宁省");
			store.setStore_city("大连市");
			store.setStore_block("金州区");
			store.setStore_street("金石滩街道");
			store.setStore_address("金石明珠66号");
			store.setStore_type("个人摊位");
			store.setStore_customer_num(2050500001001L);
			store.setStore_agency_num(2050501L);
			store.setStore_location_area("居民区");
			store.setStore_landmark1("地标建筑1");
			store.setStore_landmark2("地标建筑2");
			store.setStore_landmark3("地标建筑3");
			store.setStore_landmark4("地标建筑4");
			store.setStore_marked_map("高德");
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");// 注意月份是MM
			try {
				store.setStore_cooperation_start_date(simpleDateFormat.parse("2019-09-02"));
				store.setStore_cooperation_end_date(simpleDateFormat.parse("2020-09-02"));
			} catch (ParseException e) {
				System.out.print("日期转换错误");
				e.printStackTrace();
			}
			store.setStore_end_reason("终止原因");
			store.setStore_remark("店铺备注");
			storeMapper.insertStore(store);

			logger.info("--------------------insert goods");
			Goods goods = new Goods();
			goods.setGoods_num(0001);
			goods.setGoods_name("莫可比麻辣萝卜干");
			goods.setGoods_flavor("麻辣口味");
			goods.setGoods_category("酱腌菜");
			goods.setGoods_specification(238);
			goods.setGoods_expiration_date(3);
			goods.setGoods_plant("四川天马山晨达农业");
			goods.setGoods_legal_person("王刚强");
			goods.setGoods_mill_price(new BigDecimal("2.6"));
			goods.setGoods_first_class_agent_price(new BigDecimal("2.9"));
			goods.setGoods_second_class_agent_price(new BigDecimal("3.2"));
			goods.setGoods_third_class_agent_price(new BigDecimal("3.5"));
			goods.setGoods_store_purchase_price(new BigDecimal("4"));
			goods.setGoods_sale_price(new BigDecimal("6.9"));
			goods.setGoods_remark("产品备注");
			goodsMapper.insertGoods(goods);

			logger.info("--------------------insert pos");
			Pos pos = new Pos();
			pos.setPos_num(20201200001L);
			pos.setPos_year("2020");
			pos.setPos_month("11");
			pos.setPos_day("27");
			pos.setPos_store_num(2050500001);
			pos.setPos_store_remark("六六萝卜干超市");
			pos.setPos_customer_num(2050500001001L);
			pos.setPos_customer_remark("张紫娃");
			pos.setPos_goods_num(0001);
			pos.setPos_goods_remark("莫可比麻辣萝卜干");
			pos.setPos_quantity(100);
			pos.setPos_sale_price(new BigDecimal("7"));
			pos.setPos_total_price(new BigDecimal("700"));
			pos.setPos_reduced_price(new BigDecimal("50"));
			pos.setPos_final_price(new BigDecimal("650"));
			pos.setPos_agency_num(2050501L);
			pos.setPos_remark("POS备注");
			posMapper.insertPos(pos);

			sqlSession.commit();
			sqlSession.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
