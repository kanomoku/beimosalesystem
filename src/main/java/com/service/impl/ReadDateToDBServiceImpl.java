package com.service.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pojo.Agency;
import com.pojo.Customer;
import com.pojo.Goods;
import com.pojo.Pos;
import com.pojo.Store;
import com.service.AgencyService;
import com.service.CustomerService;
import com.service.GoodsService;
import com.service.PosService;
import com.service.ReadDateToDBService;
import com.service.StoreService;

@Service
public class ReadDateToDBServiceImpl implements ReadDateToDBService {
	@Resource
	private AgencyService agencyServiceImpl;
	@Resource
	private CustomerService customerServiceImpl;
	@Resource
	private GoodsService goodsServiceImpl;
	@Resource
	private StoreService storeServiceImpl;
	@Resource
	private PosService posServiceImpl;

	@Override
	public int saveDateToDB(MultipartFile file) {
		try {
			Workbook workbook = new XSSFWorkbook(file.getInputStream());

			List<Agency> angencyList = getAngencyList(workbook.getSheetAt(0));
			for (int i = 0; i < angencyList.size(); i++) {
				agencyServiceImpl.insertAgency(angencyList.get(i));
			}

			List<Customer> customerList = getCustomerList(workbook.getSheetAt(1));
			for (int i = 0; i < customerList.size(); i++) {
				customerServiceImpl.insertCustomer(customerList.get(i));
			}
			List<Store> storeList = getStoreList(workbook.getSheetAt(2));
			for (int i = 0; i < storeList.size(); i++) {
				storeServiceImpl.insertStore(storeList.get(i));
			}

			List<Goods> goodsList = getGoodsList(workbook.getSheetAt(3));
			for (int i = 0; i < goodsList.size(); i++) {
				goodsServiceImpl.insertGoods(goodsList.get(i));
			}
			List<Pos> posList = getPosList(workbook.getSheetAt(4));
			for (int i = 0; i < posList.size(); i++) {
				posServiceImpl.insertPos(posList.get(i));
			}
		} catch (EncryptedDocumentException e) {
			System.out.print("ReadDateToDBServiceImpl问题");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.print("ReadDateToDBServiceImpl问题");
			e.printStackTrace();
		} catch (ParseException e) {
			System.out.print("ReadDateToDBServiceImpl日期转换格式错误");
			e.printStackTrace();
		}
		return 0;
	}

	private static List<Store> getStoreList(Sheet sheet) throws ParseException {
		List<Store> list = new ArrayList();
		for (int i = 3; i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);
			String[] str = new String[row.getLastCellNum()];
			for (int j = 0; j < row.getLastCellNum(); j++) {
				Cell cell = row.getCell(j);
				cell.setCellType(CellType.STRING);
				str[j] = cell.getStringCellValue().trim();
			}
			Store store = new Store();
			store.setStore_num(Integer.valueOf(str[0]));
			store.setStore_name(str[1]);
			store.setStore_province(str[2]);
			store.setStore_city(str[3]);
			store.setStore_block(str[4]);
			store.setStore_street(str[5]);
			store.setStore_address(str[6]);
			store.setStore_type(str[7]);
			store.setStore_customer_num(Long.valueOf(str[8]));
			store.setStore_agency_num(Long.valueOf(str[9]));
			store.setStore_location_area(str[10]);
			store.setStore_landmark1(str[11]);
			store.setStore_landmark2(str[12]);
			store.setStore_landmark3(str[13]);
			store.setStore_landmark4(str[14]);
			store.setStore_marked_map(str[15]);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			store.setStore_cooperation_start_date(simpleDateFormat.parse(str[16]));
			store.setStore_cooperation_end_date(simpleDateFormat.parse(str[17]));
			store.setStore_end_reason(str[18]);
			store.setStore_remark(str[19]);
			list.add(store);
		}
		return list;
	}

	private static List<Customer> getCustomerList(Sheet sheet) throws ParseException {
		List<Customer> list = new ArrayList();
		for (int i = 3; i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);
			String[] str = new String[row.getLastCellNum()];
			for (int j = 0; j < row.getLastCellNum(); j++) {
				Cell cell = row.getCell(j);
				cell.setCellType(CellType.STRING);
				str[j] = cell.getStringCellValue().trim();
			}
			Customer customer = new Customer();
			customer.setCustomer_num(Long.valueOf(str[0]));
			customer.setCustomer_name(str[1]);
			customer.setCustomer_telephone(str[2]);
			customer.setCustomer_gender(str[3]);
			customer.setCustomer_year(str[4]);
			customer.setCustomer_month(str[5]);
			customer.setCustomer_remark(str[6]);
			list.add(customer);
		}
		return list;
	}

	private static List<Goods> getGoodsList(Sheet sheet) throws ParseException {
		List<Goods> list = new ArrayList();
		for (int i = 3; i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);
			String[] str = new String[row.getLastCellNum()];
			for (int j = 0; j < row.getLastCellNum(); j++) {
				Cell cell = row.getCell(j);
				cell.setCellType(CellType.STRING);
				str[j] = cell.getStringCellValue().trim();
			}
			Goods goods = new Goods();
			goods.setGoods_num(Integer.valueOf(str[0]));
			goods.setGoods_name(str[1]);
			goods.setGoods_flavor(str[2]);
			goods.setGoods_category(str[3]);
			goods.setGoods_specification(Integer.valueOf(str[4]));
			goods.setGoods_expiration_date(Integer.valueOf(str[5]));
			goods.setGoods_plant(str[6]);
			goods.setGoods_legal_person(str[7]);
			goods.setGoods_mill_price(new BigDecimal(str[8]));
			goods.setGoods_first_class_agent_price(new BigDecimal(str[9]));
			goods.setGoods_second_class_agent_price(new BigDecimal(str[10]));
			goods.setGoods_third_class_agent_price(new BigDecimal(str[11]));
			goods.setGoods_store_purchase_price(new BigDecimal(str[12]));
			goods.setGoods_sale_price(new BigDecimal(str[13]));
			goods.setGoods_remark(str[14]);
			list.add(goods);
		}
		return list;
	}

	private static List<Pos> getPosList(Sheet sheet) throws ParseException {
		List<Pos> list = new ArrayList();
		for (int i = 3; i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);
			String[] str = new String[row.getLastCellNum()];
			for (int j = 0; j < row.getLastCellNum(); j++) {
//				System.out.print(j+" ");
				Cell cell = row.getCell(j);
				cell.setCellType(CellType.STRING);
				str[j] = cell.getStringCellValue().trim();
			}
//			System.out.println();
			Pos pos = new Pos();
			pos.setPos_num(Long.valueOf(str[0]));
			pos.setPos_year(str[1]);
			pos.setPos_month(str[2]);
			pos.setPos_day(str[3]);
			pos.setPos_store_num(Integer.valueOf(str[4]));
			pos.setPos_store_remark(str[6]);
			pos.setPos_customer_num(Long.valueOf(str[7]));
			pos.setPos_customer_remark(str[10]);
			pos.setPos_goods_num(Integer.valueOf(str[11]));
			pos.setPos_goods_remark(str[13]);
			pos.setPos_quantity(Integer.valueOf(str[14]));
			pos.setPos_sale_price(new BigDecimal(str[15]));
			pos.setPos_total_price(new BigDecimal(str[16]));
			if (str[17] == null || "".equals(str[17])) {
				pos.setPos_reduced_price(new BigDecimal(0));
			} else {
				pos.setPos_reduced_price(new BigDecimal(str[17]));
			}
			pos.setPos_final_price(new BigDecimal(str[18]));
			pos.setPos_agency_num(Long.valueOf(str[19]));
			pos.setPos_remark(str[22]);
			pos.setPos_visit(str[23]);
			list.add(pos);
		}
		return list;
	}

	private static List<Agency> getAngencyList(Sheet sheet) throws ParseException {
		List<Agency> list = new ArrayList();
		for (int i = 3; i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);
			String[] str = new String[row.getLastCellNum()];
			for (int j = 0; j < row.getLastCellNum(); j++) {
				Cell cell = row.getCell(j);
				cell.setCellType(CellType.STRING);
				str[j] = cell.getStringCellValue().trim();
			}
			Agency angency = new Agency();
			angency.setAgency_num(Long.valueOf(str[0]));
			angency.setAgency_username(str[1]);
			angency.setAgency_password(str[2]);
			angency.setAgency_name(str[3]);
			angency.setAgency_telephone(str[4]);
			angency.setAgency_gender(str[5]);
			angency.setAgency_year(str[6]);
			angency.setAgency_month(str[7]);
			angency.setAgency_remark(str[8]);
			list.add(angency);
		}
		return list;
	}
}
