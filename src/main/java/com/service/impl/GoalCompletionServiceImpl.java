package com.service.impl;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mapper.PosMapper;
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

	@Override
	public String getGoalCompletionReport(String posYear, String posMonth,String posDay, int newCustomerTarget, int visitCustomerGoal) {

		Map<String, Object> map = new HashMap<>();
		map.put("posYear", posYear);
		map.put("posMonth", posMonth);
		map.put("posDay", posDay);
		List<Pos> posList = posMapper.selAllByYearMonthDay(map);
		
		String message =getYearMonthDayGoalCompletion(posYear, posMonth, posDay, newCustomerTarget, visitCustomerGoal, posList);
		return message;
	}

	private String getYearMonthDayGoalCompletion(String posYear, String posMonth, String posDay, int newCustomerTarget,
			int visitCustomerGoal, List<Pos> posList) {
		StringBuilder sb1 = new StringBuilder(posYear);
		sb1.append("年");
		if (posMonth != null && !"".equals(posMonth)) {
			sb1.append(posMonth);
			sb1.append("月");
		}
		if (posDay != null && !"".equals(posDay)) {
			sb1.append(posDay);
			sb1.append("日");
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
        sb.append("姓名： <br>");
        sb.append("所在区域：  <br>");
        sb.append("<br>");
        sb.append("填写日期：" + sb1.toString() +" <br>");
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
