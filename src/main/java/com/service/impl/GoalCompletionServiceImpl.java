package com.service.impl;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mapper.PosMapper;
import com.mapper.StitchQueriesMapper;
import com.pojo.Pos;
import com.service.AgencyService;
import com.service.CustomerService;
import com.service.GoalCompletionService;
import com.service.GoodsService;
import com.service.PosService;
import com.service.StoreService;

@Service
public class GoalCompletionServiceImpl implements GoalCompletionService {
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
	
	@Resource
	private PosMapper posMapper;
	@Resource
	private StitchQueriesMapper stitchQueriesMapper;

	@Override
	public String getGoalCompletionReport(String posYear, String posMonth,String posDay, int newCustomerTarget, int visitCustomerGoal) {

		Map<String, Object> map = new HashMap<>();
		map.put("posYear", posYear);
		map.put("posMonth", posMonth);
		map.put("posDay", posDay);
		List<Pos> posList = posMapper.selAllByYearMonthDay(map);
		
		Set<String> nameSet = new HashSet();
		Set<String> regionSet = new HashSet();
		List<Map<String,Object>> basicByDateList = stitchQueriesMapper.selectBasicByDate(map);
		for (int i = 0; i < basicByDateList.size(); i++) {
			Map<String,Object> map1 = basicByDateList.get(i);
			regionSet.add((String) map1.get("store_block"));
			nameSet.add((String) map1.get("agency_name"));
		}		
		
        StringBuilder nameSetSb = new StringBuilder();
		Iterator<String> it = nameSet.iterator();  
		while (it.hasNext()) {  
		  String str = it.next();  
			nameSetSb.append(str);
			nameSetSb.append(" ");
		} 
		StringBuilder regionSetSb = new StringBuilder();
		Iterator<String> it1 = regionSet.iterator();  
		while (it1.hasNext()) {  
			String str = it1.next();  
			regionSetSb.append(str);
			regionSetSb.append(" ");
		} 
		
		StringBuilder dateSb = new StringBuilder(posYear);
		dateSb.append("年");
		if (posMonth != null && !"".equals(posMonth)) {
			dateSb.append(posMonth);
			dateSb.append("月");
		}
		if (posDay != null && !"".equals(posDay)) {
			dateSb.append(posDay);
			dateSb.append("日");
		}
		
		List<Pos> newCustomer = new ArrayList();
		List<Pos> visitCustomer = new ArrayList();
		int newCustomerQuantityTotal =0;
		int visitCustomerQuantityTotal =0;
		for (int i = 0; i < posList.size(); i++) {
			Pos pos = posList.get(i);
			if("新客户".equals(pos.getPos_visit())){
				newCustomer.add(pos);
				newCustomerQuantityTotal+=pos.getPos_quantity();
			} else {
				visitCustomer.add(pos);
				visitCustomerQuantityTotal+=pos.getPos_quantity();
			}
		}
        NumberFormat numberFormat = NumberFormat.getInstance();
        // 设置精确到小数点后2位
        numberFormat.setMaximumFractionDigits(2);

        StringBuilder sb = new StringBuilder();
        sb.append("2020年 的目标实时结果报告 <br>");
        sb.append("<br>");
        sb.append("姓名：" +nameSetSb.toString()+" <br>");
        sb.append("所在区域："+regionSetSb.toString()+"<br>");
        sb.append("<br>");
        sb.append("填写日期：" + dateSb.toString() +" <br>");
        sb.append("<br>");
        sb.append("新客户目标数量：" +newCustomerTarget+"<br>");
        sb.append("新客户完成数量：" +newCustomer.size()+"<br>");
        sb.append("新客户完成率："+numberFormat.format((float) newCustomer.size() / (float) newCustomerTarget * 100)+"%"+" <br>");
        sb.append("新客户拿货数量："+"拿货  "+newCustomerQuantityTotal + " 碗，" + "换算  " + newCustomerQuantityTotal/32 +" 箱  " + newCustomerQuantityTotal%32 + " 碗" + " <br>");
        sb.append("<br>");
        sb.append("拜访客户目标数量：" +visitCustomerGoal+"<br>");
        sb.append("拜访客户完成数量：" +visitCustomer.size() + " <br>");
        sb.append("拜访客户完成率：" +numberFormat.format((float) visitCustomer.size() / (float) visitCustomerGoal * 100)+"%"+" <br>");
        sb.append("拜访客户回货数量：" +"回货  "+visitCustomerQuantityTotal + " 碗，"  + "换算  " + visitCustomerQuantityTotal/32 +" 箱 " + visitCustomerQuantityTotal%32 + " 碗" + " <br>");

		return sb.toString();
	}
}
