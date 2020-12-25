package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GetResultShowSql {
	@RequestMapping("orderTotalHistogram")
	public String show(HttpServletRequest req,Model model){
		String posYear = req.getParameter("posYear");
		String posMonth = req.getParameter("posMonth");
		String posDay = req.getParameter("posDay");
		StringBuilder sb = new StringBuilder();
		sb.append(	"	select derived2.bin  范围,ifnull(derived1.total,0) 销售总数  <br>	"	);
		sb.append(	"	from						<br>	"	);
		sb.append(	"			(select 				<br>	"	);
		sb.append(	"					case		<br>	"	);
		sb.append(	"							when pos_quantity <=32 then '1:  <=1箱'		<br>	"	);
		sb.append(	"							when pos_quantity>32 and pos_quantity<=64 then '2:  1箱< <=2箱'		<br>	"	);
		sb.append(	"							when pos_quantity>64 and pos_quantity<=96 then '3:  2箱<  <=3箱'		<br>	"	);
		sb.append(	"							when pos_quantity>96 and pos_quantity<128 then '4:  3箱< <=4箱'		<br>	"	);
		sb.append(	"							when pos_quantity>128 and pos_quantity<160 then '5:  4箱< <=5箱'		<br>	"	);
		sb.append(	"							else '6:  > 5箱'		<br>	"	);
		sb.append(	"					end bin,		<br>	"	);
		sb.append(	"					count(*) total		<br>	"	);
		sb.append(	"			from pos				<br>	"	);
		sb.append(	"			where pos.pos_year="+posYear+"<br>	"	);
		if (posMonth != null && !"".equals(posMonth)) {
			sb.append("			and pos.pos_month="+getZeroMonthDay(posMonth)+"<br>	"	);
		}
		if (posDay != null && !"".equals(posDay)) {
			sb.append("			and pos.pos_day="+getZeroMonthDay(posDay)+"<br>	"	);
		}
		sb.append(	"			group by bin				<br>	"	);
		sb.append(	"			)derived1				<br>	"	);
		sb.append(	"	right join 						<br>	"	);
		sb.append(	"			(select '1:  <=1箱' bin union				<br>	"	);
		sb.append(	"			select '2:  1箱< <=2箱' bin union				<br>	"	);
		sb.append(	"			select '3:  2箱<  <=3箱' bin union				<br>	"	);
		sb.append(	"			select '4:  3箱< <=4箱' bin union				<br>	"	);
		sb.append(	"			select '5:  4箱< <=5箱' bin union				<br>	"	);
		sb.append(	"			select '6:  > 5箱' bin       				<br>	"	);
		sb.append(	"			)derived2				<br>	"	);
		sb.append(	"	on derived2.bin = derived1.bin						<br>	"	);
		sb.append(	"	order by derived2.bin						<br>	"	);
		
		model.addAttribute("message", sb.toString());
		return "sqlShow.jsp";
	}
	
	@RequestMapping("singleOrderQuantity")
	public String singleOrderQuantity(HttpServletRequest req,Model model){
		
		String posYear = req.getParameter("posYear");
		String posMonth = req.getParameter("posMonth");
		String posDay = req.getParameter("posDay");
		StringBuilder sb = new StringBuilder();
		sb.append(		"	SELECT							<br> " );
		sb.append(		"		t.rank 排名,						<br> " );
		sb.append(		"		pos.pos_store_num 店铺编号,						<br> " );
		sb.append(		"		s.store_name 店铺名称,						<br> " );
		sb.append(		"		pos.pos_quantity 拿货数量,						<br> " );
		sb.append(		"		floor(pos.pos_quantity / 32) 箱,						<br> " );
		sb.append(		"		mod (pos.pos_quantity, 32) 碗,						<br> " );
		sb.append(		"		pos.pos_sale_price 门店拿货单价,						<br> " );
		sb.append(		"		pos.pos_total_price 门店拿货总价,						<br> " );
		sb.append(		"		pos.pos_reduced_price 门店总价优惠钱数,						<br> " );
		sb.append(		"		pos.pos_final_price 门店优惠后总价						<br> " );
		sb.append(		"	FROM							<br> " );
		sb.append(		"		pos						<br> " );
		sb.append(		"	JOIN							<br> " );
		sb.append(		"			(					<br> " );
		sb.append(		"			SELECT					<br> " );
		sb.append(		"				p.pos_quantity11 pos_quantity22,				<br> " );
		sb.append(		"				@rank :=@rank + 1 rank				<br> " );
		sb.append(		"			FROM					<br> " );
		sb.append(		"				(				<br> " );
		sb.append(		"				SELECT DISTINCT				<br> " );
		sb.append(		"					(pos_quantity) pos_quantity11			<br> " );
		sb.append(		"				FROM				<br> " );
		sb.append(		"					pos			<br> " );
		sb.append(		"				WHERE				<br> " );
		sb.append(		"					pos.pos_year = "+posYear+"<br>	" );
		if (posMonth != null && !"".equals(posMonth)) {
			sb.append("			and pos.pos_month="+getZeroMonthDay(posMonth)+"<br>	"	);
		}
		if (posDay != null && !"".equals(posDay)) {
			sb.append("			and pos.pos_day="+getZeroMonthDay(posDay)+"<br>	"	);
		}
		sb.append(		"				ORDER BY				<br> " );
		sb.append(		"					pos_quantity11 DESC			<br> " );
		sb.append(		"				) p,				<br> " );
		sb.append(		"				(SELECT @rank := 0) q				<br> " );
		sb.append(		"			) t 					<br> " );
		sb.append(		"	ON pos.pos_quantity = t.pos_quantity22							<br> " );
		sb.append(		"	join store s							<br> " );
		sb.append(		"	on s.store_num=pos.pos_store_num							<br> " );
		sb.append(		"	ORDER BY							<br> " );
		sb.append(		"		rank ASC						<br> " );
		model.addAttribute("message", sb.toString());
		return "sqlShow.jsp";
	}
	@RequestMapping("avg7day")
	public String avg7day(HttpServletRequest req,Model model){
		
		String posYear = req.getParameter("posYear");
		String posMonth = req.getParameter("posMonth");
		StringBuilder sb = new StringBuilder();
		sb.append(	"	select 									<br> " );
		sb.append(	"			a.visited_on '当天',							<br> " );
		sb.append(	"			ifnull(a.totalQuantity,0) '当天往前7天销售总数',							<br> " );
		sb.append(	"			ifnull(a.avgQuantity,0) '当天往前7天销售平均数',							<br> " );
		sb.append(	"			ifnull(b.visited_on1,date_sub(a.visited_on,interval 1 day)) '前一天',							<br> " );
		sb.append(	"			ifnull(b.totalQuantity1,0) '前天往前7天销售总数',							<br> " );
		sb.append(	"			ifnull(b.avgQuantity1,0) '前天往前7天销售平均数',							<br> " );
		sb.append(	"	    CASE									<br> " );
		sb.append(	"	        WHEN ifnull(b.totalQuantity1,0) >0									<br> " );
		sb.append(	"	            THEN concat(ROUND((ifnull(a.totalQuantity,0) - ifnull(b.totalQuantity1,0))* 100 / ifnull(b.totalQuantity1,0), 2),'%')									<br> " );
		sb.append(	"	        ELSE									<br> " );
		sb.append(	"	            concat(0,'%')									<br> " );
		sb.append(	"	    END AS '7天总量增长率',									<br> " );
		sb.append(	"	    CASE									<br> " );
		sb.append(	"	        WHEN ifnull(b.avgQuantity1,0) >0									<br> " );
		sb.append(	"	            THEN concat(ROUND((ifnull(a.avgQuantity,0) - ifnull(b.avgQuantity1,0))* 100 / ifnull(b.avgQuantity1,0), 2),'%')									<br> " );
		sb.append(	"	        ELSE									<br> " );
		sb.append(	"	            concat(0,'%')									<br> " );
		sb.append(	"	    END AS '7天均值增长率'									<br> " );
		sb.append(	"	from									<br> " );
		sb.append(	"	(									<br> " );
		sb.append(	"		select								<br> " );
		sb.append(	"			c1.visited_on visited_on,							<br> " );
		sb.append(	"			sum(c2.pos_quantity) totalQuantity ,							<br> " );
		sb.append(	"			round(avg(c2.pos_quantity), 2) avgQuantity							<br> " );
		sb.append(	"		from 								<br> " );
		sb.append(	"		(select date(concat(pos_year,pos_month,pos_day)) as visited_on, sum(pos_quantity) as pos_quantity								<br> " );
		sb.append(	"						from pos				<br> " );
		sb.append(	"						where pos_year = "+posYear+"				<br> " );
		if (posMonth != null && !"".equals(posMonth)) {
			sb.append("			                  and pos_month ="+getZeroMonthDay(posMonth)+"<br>	"	);
		}
		sb.append(	"						group by date(concat(pos_year,pos_month,pos_day))) c1 				<br> " );
		sb.append(	"		join 								<br> " );
		sb.append(	"		(select date(concat(pos_year,pos_month,pos_day)) as visited_on, sum(pos_quantity) as pos_quantity								<br> " );
		sb.append(	"						from  pos 				<br> " );
		sb.append(	"						where pos_year = "+posYear+"				<br> " );
		if (posMonth != null && !"".equals(posMonth)) {
			sb.append("			                  and pos_month ="+getZeroMonthDay(posMonth)+"<br>	"	);
		}
		sb.append(	"						group by date(concat(pos_year,pos_month,pos_day))) c2				<br> " );
		sb.append(	"		on timestampdiff(day,c2.visited_on,c1.visited_on) between 0 and 6 								<br> " );
		sb.append(	"		group by c1.visited_on								<br> " );
		sb.append(	"		order by c1.visited_on								<br> " );
		sb.append(	"	) a									<br> " );
		sb.append(	"	left join									<br> " );
		sb.append(	"	(									<br> " );
		sb.append(	"		select								<br> " );
		sb.append(	"			c3.visited_on visited_on1,							<br> " );
		sb.append(	"			sum(c4.pos_quantity) totalQuantity1 ,							<br> " );
		sb.append(	"			round(avg(c4.pos_quantity), 2) avgQuantity1							<br> " );
		sb.append(	"		from 								<br> " );
		sb.append(	"		(select date(concat(pos_year,pos_month,pos_day)) as visited_on, sum(pos_quantity) as pos_quantity								<br> " );
		sb.append(	"						from pos				<br> " );
		sb.append(	"						where pos_year = "+posYear+"				<br> " );
		if (posMonth != null && !"".equals(posMonth)) {
			sb.append("			                  and pos_month ="+getZeroMonthDay(posMonth)+"<br>	"	);
		}
		sb.append(	"						group by date(concat(pos_year,pos_month,pos_day))) c3 				<br> " );
		sb.append(	"		join 								<br> " );
		sb.append(	"		(select date(concat(pos_year,pos_month,pos_day)) as visited_on, sum(pos_quantity) as pos_quantity								<br> " );
		sb.append(	"						from  pos				<br> " );
		sb.append(	"						where pos_year = "+posYear+"				<br> " );
		if (posMonth != null && !"".equals(posMonth)) {
			sb.append("			                  and pos_month ="+getZeroMonthDay(posMonth)+"<br>	"	);
		}
		sb.append(	"						group by date(concat(pos_year,pos_month,pos_day))) c4				<br> " );
		sb.append(	"		on timestampdiff(day,c4.visited_on,c3.visited_on) between 0 and 6 								<br> " );
		sb.append(	"		group by c3.visited_on								<br> " );
		sb.append(	"		order by c3.visited_on								<br> " );
		sb.append(	"	) b									<br> " );
		sb.append(	"	on timestampdiff(day,b.visited_on1,a.visited_on) =1									<br> " );
		sb.append(	"	order by a.visited_on									<br> " );
		model.addAttribute("message", sb.toString());
		return "sqlShow.jsp";
	}
	
	@RequestMapping("monthAdd")
	public String monthAdd(HttpServletRequest req,Model model){
		String posYear = req.getParameter("posYear");
		StringBuilder sb = new StringBuilder();
		sb.append(	"	SELECT		<br> " );
		sb.append(	"		a.visited_on '当月',	<br> " );
		sb.append(	"		ifnull(a.pos_quantity,0) '当月拿货总量',	<br> " );
		sb.append(	"		ifnull(b.visited_on1,a.visited_on-1) '上月',	<br> " );
		sb.append(	"		ifnull(b.pos_quantity1,0) '上月拿货总量',	<br> " );
		sb.append(	"	    CASE		<br> " );
		sb.append(	"	        WHEN ifnull(b.pos_quantity1,0) >0		<br> " );
		sb.append(	"	            THEN concat(ROUND((ifnull(a.pos_quantity,0) - ifnull(b.pos_quantity1,0))* 100 / ifnull(b.pos_quantity1,0), 2),'%')		<br> " );
		sb.append(	"	        ELSE		<br> " );
		sb.append(	"	            concat(0,'%')		<br> " );
		sb.append(	"	    END AS '增长率'		<br> " );
		sb.append(	"	FROM		<br> " );
		sb.append(	"	(select concat(pos_year,pos_month) as visited_on, sum(pos_quantity) as pos_quantity		<br> " );
		sb.append(	"	from pos		<br> " );
		sb.append(	"	where pos_year = "+posYear+"		<br> " );
		sb.append(	"	group by concat(pos_year,pos_month)) a		<br> " );
		sb.append(	"	left join		<br> " );
		sb.append(	"	(select concat(pos_year,pos_month) as visited_on1, sum(pos_quantity) as pos_quantity1		<br> " );
		sb.append(	"	from pos		<br> " );
		sb.append(	"	where pos_year = 2020		<br> " );
		sb.append(	"	group by concat(pos_year,pos_month)) b		<br> " );
		sb.append(	"	on a.visited_on-1 = b.visited_on1		<br> " );
		sb.append(	"	order by a.visited_on		<br> " );
		model.addAttribute("message", sb.toString());
		return "sqlShow.jsp";
	}
	@RequestMapping("groupStore")
	public String groupStore(HttpServletRequest req,Model model){
		String posYear = req.getParameter("posYear");
		String posMonth = req.getParameter("posMonth");
		String posDay = req.getParameter("posDay");
		StringBuilder sb = new StringBuilder();
		sb.append(	"	select		<br> " );
		sb.append(	"		concat(p.pos_year, p.pos_month,p.pos_day) 日期,	<br> " );
		sb.append(	"		count(distinct pos_store_num) as 当天拿货店铺数量,	<br> " );
		sb.append(	"		group_concat(distinct s.store_name) as 当天拿货店铺名字统计	<br> " );
		sb.append(	"	from		<br> " );
		sb.append(	"		pos p,	<br> " );
		sb.append(	"		store s	<br> " );
		sb.append(	"	where		<br> " );
		sb.append(	"		p.pos_store_num = s.store_num	<br> " );
		sb.append(	"	and p.pos_year = "+posYear+"		<br> " );
		if (posMonth != null && !"".equals(posMonth)) {
			sb.append("			and p.pos_month ="+getZeroMonthDay(posMonth)+"<br>	"	);
		}
		if (posDay != null && !"".equals(posDay)) {
			sb.append("			and p.pos_day = "+getZeroMonthDay(posDay)+"<br>	"	);
		}
		sb.append(	"	group by		<br> " );
		sb.append(	"		concat(p.pos_year, p.pos_month,p.pos_day)	<br> " );
		sb.append(	"	order by		<br> " );
		sb.append(	"		concat(p.pos_year, p.pos_month,p.pos_day);	<br> " );
		model.addAttribute("message", sb.toString());
		return "sqlShow.jsp";
	}
	
	@RequestMapping("everyWeek")
	public String everyWeek(HttpServletRequest req,Model model){
		String posYear = req.getParameter("posYear");
		String posMonth = req.getParameter("posMonth");
		StringBuilder sb = new StringBuilder();
		sb.append(	"	select  					<br> " );
		sb.append(	"	s.store_num 店铺番号,					<br> " );
		sb.append(	"	s.store_name 店铺名字,					<br> " );
		sb.append(	"	c.customer_name 门店负责人,					<br> " );
		sb.append(	"	c.customer_telephone 门店负责人电话,					<br> " );
		sb.append(	"	a.agency_name 业务员,					<br> " );
		sb.append(	"	a.agency_telephone 业务员电话,					<br> " );
		sb.append(	"		ifnull(sum(case when dayofweek(date(concat(pos_year,pos_month,pos_day))) = 2 then p.pos_quantity end),0) 周一,				<br> " );
		sb.append(	"		ifnull(sum(case when dayofweek(date(concat(pos_year,pos_month,pos_day))) = 3 then p.pos_quantity end),0) 周二,				<br> " );
		sb.append(	"		ifnull(sum(case when dayofweek(date(concat(pos_year,pos_month,pos_day))) = 4 then p.pos_quantity end),0) 周三,				<br> " );
		sb.append(	"		ifnull(sum(case when dayofweek(date(concat(pos_year,pos_month,pos_day))) = 5 then p.pos_quantity end),0) 周四,				<br> " );
		sb.append(	"		ifnull(sum(case when dayofweek(date(concat(pos_year,pos_month,pos_day))) = 6 then p.pos_quantity end),0) 周五,				<br> " );
		sb.append(	"		ifnull(sum(case when dayofweek(date(concat(pos_year,pos_month,pos_day))) = 7 then p.pos_quantity end),0) 周六,				<br> " );
		sb.append(	"		ifnull(sum(case when dayofweek(date(concat(pos_year,pos_month,pos_day))) = 1 then p.pos_quantity end),0) 周日				<br> " );
		sb.append(	"	from					<br> " );
		sb.append(	"		pos p,				<br> " );
		sb.append(	"		agency a,				<br> " );
		sb.append(	"		customer c,				<br> " );
		sb.append(	"		store s				<br> " );
		sb.append(	"			where p.pos_year="+posYear+"<br>	"	);
		if (posMonth != null && !"".equals(posMonth)) {
			sb.append("			and p.pos_month="+getZeroMonthDay(posMonth)+"<br>	"	);
		}
		sb.append(	"	and p.pos_agency_num = a.agency_num					<br> " );
		sb.append(	"	and p.pos_customer_num = c.customer_num					<br> " );
		sb.append(	"	and p.pos_store_num = s.store_num					<br> " );
		sb.append(	"	GROUP BY s.store_num;					<br> " );
		model.addAttribute("message", sb.toString());
		return "sqlShow.jsp";
	}
	
	@RequestMapping("everyMonth")
	public String everyMonth(HttpServletRequest req,Model model){
		String posYear = req.getParameter("posYear");
		String posMonth = req.getParameter("posMonth");
		StringBuilder sb = new StringBuilder();
		sb.append(	"	SELECT 					<br> " );
		sb.append(	"	s.store_num 店铺编号,					<br> " );
		sb.append(	"	s.store_name 店铺名字,					<br> " );
		sb.append(	"	c.customer_name 门店负责人,					<br> " );
		sb.append(	"	c.customer_telephone 门店负责人电话,					<br> " );
		sb.append(	"	a.agency_name 业务员,					<br> " );
		sb.append(	"	a.agency_telephone 业务员电话,					<br> " );
		sb.append(	"	ifnull(SUM(CASE WHEN p.pos_month='01' THEN p.pos_quantity END),0) AS 1月,					<br> " );
		sb.append(	"	ifnull(SUM(CASE WHEN p.pos_month='02' THEN p.pos_quantity END),0) AS 2月,					<br> " );
		sb.append(	"	ifnull(SUM(CASE WHEN p.pos_month='03' THEN p.pos_quantity END),0) AS 3月,					<br> " );
		sb.append(	"	ifnull(SUM(CASE WHEN p.pos_month='04' THEN p.pos_quantity END),0) AS 4月,					<br> " );
		sb.append(	"	ifnull(SUM(CASE WHEN p.pos_month='05' THEN p.pos_quantity END),0) AS 5月,					<br> " );
		sb.append(	"	ifnull(SUM(CASE WHEN p.pos_month='06' THEN p.pos_quantity END),0) AS 6月,					<br> " );
		sb.append(	"	ifnull(SUM(CASE WHEN p.pos_month='07' THEN p.pos_quantity END),0) AS 7月,					<br> " );
		sb.append(	"	ifnull(SUM(CASE WHEN p.pos_month='08' THEN p.pos_quantity END),0) AS 8月,					<br> " );
		sb.append(	"	ifnull(SUM(CASE WHEN p.pos_month='09' THEN p.pos_quantity END),0) AS 9月,					<br> " );
		sb.append(	"	ifnull(SUM(CASE WHEN p.pos_month='10' THEN p.pos_quantity END),0) AS 10月,					<br> " );
		sb.append(	"	ifnull(SUM(CASE WHEN p.pos_month='11' THEN p.pos_quantity END),0) AS 11月,					<br> " );
		sb.append(	"	ifnull(SUM(CASE WHEN p.pos_month='12' THEN p.pos_quantity END),0) AS 12月					<br> " );
		sb.append(	"	from					<br> " );
		sb.append(	"		pos p,				<br> " );
		sb.append(	"		agency a,				<br> " );
		sb.append(	"		customer c,				<br> " );
		sb.append(	"		store s				<br> " );
		sb.append(	"	where					<br> " );
		sb.append(	"		p.pos_year = "+posYear+"				<br> " );
		if (posMonth != null && !"".equals(posMonth)) {
			sb.append("			and p.pos_month="+getZeroMonthDay(posMonth)+"<br>	"	);
		}
		sb.append(	"	and p.pos_agency_num = a.agency_num					<br> " );
		sb.append(	"	and p.pos_customer_num = c.customer_num					<br> " );
		sb.append(	"	and p.pos_store_num = s.store_num					<br> " );
		sb.append(	"	GROUP BY s.store_num;					<br> " );
		model.addAttribute("message", sb.toString());
		return "sqlShow.jsp";
	}
	
	@RequestMapping("orderOrder")
	public String orderOrder(HttpServletRequest req,Model model){
		String posYear = req.getParameter("posYear");
		String posMonth = req.getParameter("posMonth");
		String posDay = req.getParameter("posDay");
		String orderOrder = req.getParameter("orderOrder");
		StringBuilder sb = new StringBuilder();
		sb.append(	"	SELECT					<br> " );
		sb.append(	"		IFNULL(				<br> " );
		sb.append(	"			(			<br> " );
		sb.append(	"				SELECT		<br> " );
		sb.append(	"					s.store_name	<br> " );
		sb.append(	"				FROM		<br> " );
		sb.append(	"					pos p	<br> " );
		sb.append(	"				RIGHT JOIN store s ON p.pos_store_num = s.store_num		<br> " );
		sb.append(	"			where p.pos_year="+posYear+"<br>	"	);
		if (posMonth != null && !"".equals(posMonth)) {
			sb.append("			and p.pos_month="+getZeroMonthDay(posMonth)+"<br>	"	);
		}
		if (posDay != null && !"".equals(posDay)) {
			sb.append("			and p.pos_day="+getZeroMonthDay(posDay)+"<br>	"	);
		}
		sb.append(	"				ORDER BY		<br> " );
		sb.append(	"					p.pos_quantity DESC	<br> " );
		sb.append(	"				LIMIT 1 OFFSET "+(Integer.valueOf(orderOrder)-1)+"		<br> " );
		sb.append(	"			),			<br> " );
		sb.append(	"			NULL			<br> " );
		sb.append(	"		) AS 单笔拿货排名第"+orderOrder+"名店铺的名字				<br> " );
		model.addAttribute("message", sb.toString());
		return "sqlShow.jsp";
	}
	
	@RequestMapping("newStore")
	public String newStore(HttpServletRequest req,Model model){
		String posYear = req.getParameter("posYear");
		String posMonth = req.getParameter("posMonth");
		String posDay = req.getParameter("posDay");
		String dateStr = posYear+"-"+getZeroMonthDay(posMonth)+"-"+getZeroMonthDay(posDay);
		String storeTotalStr = req.getParameter("storeTotal");
		Integer storeTotal = 0;
		if (storeTotal != null && !"".equals(storeTotalStr)) {
			storeTotal = Integer.valueOf(storeTotalStr);
		}
		StringBuilder sb = new StringBuilder();
		sb.append(	"	SELECT					<br> " );
		sb.append(	"		datedate 日期,				<br> " );
		sb.append(	"		count(pos_store_num) 新增门店的数量,				<br> " );
		sb.append(	"		group_concat(DISTINCT s.store_name) 新增门店的名字				<br> " );
		sb.append(	"	from					<br> " );
		sb.append(	"	(					<br> " );
		sb.append(	"	select date(concat(p.pos_year,p.pos_month,p.pos_day)) datedate,p.pos_store_num,p.pos_visit					<br> " );
		sb.append(	"	from pos p					<br> " );
		sb.append(	"	where p.pos_visit = '新增客户'					<br> " );
		sb.append(	"	and datediff('"+dateStr+"',date(concat(p.pos_year,p.pos_month,p.pos_day)))  BETWEEN 0 and "+storeTotal+"				<br> " );
		sb.append(	"	) a					<br> " );
		sb.append(	"	join store s					<br> " );
		sb.append(	"	on s.store_num = a.pos_store_num					<br> " );
		sb.append(	"	group by datedate					<br> " );
		model.addAttribute("message", sb.toString());
		return "sqlShow.jsp";
	}
	
	@RequestMapping("storeTotalAndPercent")
	public String storeTotalAndPercent(HttpServletRequest req,Model model){
		String posYear = req.getParameter("posYear");
		String posMonth = req.getParameter("posMonth");
		String posDay = req.getParameter("posDay");
		StringBuilder sb = new StringBuilder();
		sb.append(	"	SELECT					<br> " );
		sb.append(	"		p.pos_store_num 店铺番号,				<br> " );
		sb.append(	"		s.store_name 店铺名字,				<br> " );
		sb.append(	"		SUM(pos_quantity) 拿货总数,				<br> " );
		sb.append(	"		count(*) 拿货总回数,				<br> " );
		sb.append(	"		ROUND(AVG(pos_quantity), 2) 平均拿货数,				<br> " );
		sb.append(	"		SUM(IF(p.pos_quantity <= 32, 1, 0)) 一箱以内拿货回数,				<br> " );
		sb.append(	"		SUM(IF( 32 < p.pos_quantity and p.pos_quantity <= 64, 1, 0)) 一箱到两箱拿货回数,				<br> " );
		sb.append(	"		SUM(IF(p.pos_quantity > 64, 1, 0)) 两项以上拿货回数,				<br> " );
		sb.append(	"	  concat(ROUND(SUM(IF(p.pos_quantity  <= 32, 1, 0)) * 100 / count(*), 2),'%') 一箱以内占比,					<br> " );
		sb.append(	"	  concat(ROUND(SUM(IF( 32 < p.pos_quantity and p.pos_quantity <= 64, 1, 0)) * 100 / count(*), 2),'%') 一箱到两箱占比,					<br> " );
		sb.append(	"	  concat(ROUND(SUM(IF(p.pos_quantity > 64, 1, 0)) * 100 / count(*), 2),'%') 两箱以上占比					<br> " );
		sb.append(	"	FROM					<br> " );
		sb.append(	"		pos p,store s				<br> " );
		sb.append(	"	WHERE					<br> " );
		sb.append(	"		p.pos_store_num = s.store_num				<br> " );
		sb.append(	"	AND p.pos_year = "+posYear+"					<br> " );
		if (posMonth != null && !"".equals(posMonth)) {
			sb.append("			and p.pos_month="+getZeroMonthDay(posMonth)+"<br>	"	);
		}
		if (posDay != null && !"".equals(posDay)) {
			sb.append("			and p.pos_day="+getZeroMonthDay(posDay)+"<br>	"	);
		}
		sb.append(	"						<br> " );
		sb.append(	"	GROUP BY					<br> " );
		sb.append(	"		p.pos_store_num				<br> " );
		model.addAttribute("message", sb.toString());
		return "sqlShow.jsp";
	}
	
	@RequestMapping("middleNumber")
	public String middleNumber(HttpServletRequest req,Model model){
		String posYear = req.getParameter("posYear");
		String posMonth = req.getParameter("posMonth");
		StringBuilder sb = new StringBuilder();
		sb.append(	"	SELECT					<br> " );
		sb.append(	"		t.pos_num 销售番号,				<br> " );
		sb.append(	"		t.pos_store_num 门店番号,				<br> " );
		sb.append(	"		s.store_name 门店名字,				<br> " );
		sb.append(	"		t.rank 排序,				<br> " );
		sb.append(	"		t.pos_quantity 单笔拿货中位数,				<br> " );
		sb.append(	"		t.totalcount 拿货回数				<br> " );
		sb.append(	"	from					<br> " );
		sb.append(	"	(select Ranking.pos_num,					<br> " );
		sb.append(	"	        Ranking.pos_store_num,					<br> " );
		sb.append(	"	        Ranking.pos_quantity,					<br> " );
		sb.append(	"					Ranking.rank,	<br> " );
		sb.append(	"					StoreCount.totalcount,	<br> " );
		sb.append(	"					StoreCount.store_num	<br> " );
		sb.append(	"	from					<br> " );
		sb.append(	"	(SELECT 					<br> " );
		sb.append(	"	        p.pos_num,					<br> " );
		sb.append(	"	        p.pos_store_num,					<br> " );
		sb.append(	"	        p.pos_quantity,					<br> " );
		sb.append(	"	        IF(@prev = p.pos_store_num, @Rank:=@Rank + 1, @Rank:=1) AS rank,					<br> " );
		sb.append(	"	        @prev:=p.pos_store_num					<br> " );
		sb.append(	"	    FROM					<br> " );
		sb.append(	"	        pos p, (SELECT @Rank:=0, @prev:=0) AS temp					<br> " );
		sb.append(	"	where p.pos_year = "+posYear+"					<br> " );
		if (posMonth != null && !"".equals(posMonth)) {
			sb.append("			and p.pos_month="+getZeroMonthDay(posMonth)+"<br>	"	);
		}
		sb.append(	"	ORDER BY p.pos_store_num , p.pos_quantity , p.pos_num) Ranking					<br> " );
		sb.append(	"	INNER JOIN					<br> " );
		sb.append(	"	(SELECT 					<br> " );
		sb.append(	"	        COUNT(*) AS totalcount, p2.pos_store_num AS store_num					<br> " );
		sb.append(	"	    FROM					<br> " );
		sb.append(	"	        pos p2					<br> " );
		sb.append(	"		where p2.pos_year = "+posYear+"				<br> " );
		if (posMonth != null && !"".equals(posMonth)) {
			sb.append("			and p2.pos_month="+getZeroMonthDay(posMonth)+"<br>	"	);
		}
		sb.append(	"	    GROUP BY p2.pos_store_num) StoreCount 					<br> " );
		sb.append(	"	ON StoreCount.store_num = Ranking.pos_store_num					<br> " );
		sb.append(	"	where					<br> " );
		sb.append(	"	 Rank = FLOOR((totalcount + 1) / 2)					<br> " );
		sb.append(	"	        OR Rank = FLOOR((totalcount + 2) / 2)) t,					<br> " );
		sb.append(	"	store s					<br> " );
		sb.append(	"	where t.pos_store_num = s.store_num					<br> " );
		model.addAttribute("message", sb.toString());
		return "sqlShow.jsp";
	}
	
	@RequestMapping("usuallyOrder")
	public String usuallyOrder(HttpServletRequest req,Model model){
		String posYear = req.getParameter("posYear");
		String posMonth = req.getParameter("posMonth");
		String posDay = req.getParameter("posDay");
		StringBuilder sb = new StringBuilder();
		sb.append(	"	SELECT							<br> " );
		sb.append(	"		t2.pos_store_num 门店番号,						<br> " );
		sb.append(	"		s.store_name 门店名字,						<br> " );
		sb.append(	"		t3.pos_goods_num 商品编号,						<br> " );
		sb.append(	"		g.goods_name 商品名字,						<br> " );
		sb.append(	"	  t2.freq 拿货回数							<br> " );
		sb.append(	"	from							<br> " );
		sb.append(	"		(						<br> " );
		sb.append(	"			select t1.pos_store_num,max(t1.cnt) freq					<br> " );
		sb.append(	"			from 					<br> " );
		sb.append(	"				(select pos_store_num,pos_goods_num,count(pos_num) cnt from pos where 				<br> " );
		sb.append(	"					pos_year =  "+posYear+"  			<br> " );
		if (posMonth != null && !"".equals(posMonth)) {
			sb.append("			and pos_month="+getZeroMonthDay(posMonth)+"<br>	"	);
		}
		if (posDay != null && !"".equals(posDay)) {
			sb.append("			and pos_day="+getZeroMonthDay(posDay)+"<br>	"	);
		}
		sb.append(	"					group by pos_store_num,pos_goods_num) t1			<br> " );
		sb.append(	"			group by t1.pos_store_num					<br> " );
		sb.append(	"		) t2 						<br> " );
		sb.append(	"		join 						<br> " );
		sb.append(	"		( 						<br> " );
		sb.append(	"			select pos_store_num,pos_goods_num,count(pos_num) cnt from pos 					<br> " );
		sb.append(	"						where pos_year = "+posYear+" 		<br> " );
		if (posMonth != null && !"".equals(posMonth)) {
			sb.append("			and pos_month="+getZeroMonthDay(posMonth)+"<br>	"	);
		}
		if (posDay != null && !"".equals(posDay)) {
			sb.append("			and pos_day="+getZeroMonthDay(posDay)+"<br>	"	);
		}
		sb.append(	"						group by pos_store_num,pos_goods_num 		<br> " );
		sb.append(	"		) t3						<br> " );
		sb.append(	"	  on t2.pos_store_num=t3.pos_store_num and t2.freq=t3.cnt 							<br> " );
		sb.append(	"		join goods g						<br> " );
		sb.append(	"		on g.goods_num=t3.pos_goods_num						<br> " );
		sb.append(	"	  join store s 							<br> " );
		sb.append(	"	  on s.store_num=t2.pos_store_num							<br> " );
		model.addAttribute("message", sb.toString());
		return "sqlShow.jsp";
	}
	
	@RequestMapping("monthOrderCustomer")
	public String monthOrderCustomer(HttpServletRequest req,Model model){
		String posYear = req.getParameter("posYear");
		StringBuilder sb = new StringBuilder();
		sb.append(	"	SELECT							<br> " );
		sb.append(	"		concat(p.pos_year, p.pos_month) 月份,						<br> " );
		sb.append(	"		count(pos_num)  成交笔数,						<br> " );
		sb.append(	"		count(DISTINCT pos_store_num) 门店数量 ,						<br> " );
		sb.append(	"		SUM(p.pos_quantity) 拿货数量						<br> " );
		sb.append(	"	FROM							<br> " );
		sb.append(	"		pos p						<br> " );
		sb.append(	"	where p.pos_year = "+posYear+"							<br> " );
		sb.append(	"	GROUP BY							<br> " );
		sb.append(	"		concat(p.pos_year, p.pos_month)						<br> " );
		model.addAttribute("message", sb.toString());
		return "sqlShow.jsp";
	}
	
	@RequestMapping("maxQuantityPer")
	public String maxQuantityPer(HttpServletRequest req,Model model){
		String posYear = req.getParameter("posYear");
		String posMonth = req.getParameter("posMonth");
		String posDay = req.getParameter("posDay");
		StringBuilder sb = new StringBuilder();
		sb.append(	"	SELECT							<br> " );
		sb.append(	"		p.pos_num 交易番号,						<br> " );
		sb.append(	"		p.pos_store_num 门店番号,						<br> " );
		sb.append(	"		s.store_name 门店名字, 						<br> " );
		sb.append(	"		date(concat(p.pos_year,p.pos_month,p.pos_day)) 拿货日期,						<br> " );
		sb.append(	"		p.pos_quantity 单笔最大拿货量						<br> " );
		sb.append(	"	FROM							<br> " );
		sb.append(	"		pos p,						<br> " );
		sb.append(	"		store s						<br> " );
		sb.append(	"	WHERE (p.pos_store_num,p.pos_quantity) in (							<br> " );
		sb.append(	"		SELECT p1.pos_store_num,max(p1.pos_quantity) 						<br> " );
		sb.append(	"		FROM pos p1 						<br> " );
		sb.append(	"		where p1.pos_year = "+posYear+"<br>	"	);
		if (posMonth != null && !"".equals(posMonth)) {
			sb.append("			and p1.pos_month="+getZeroMonthDay(posMonth)+"<br>	"	);
		}
		if (posDay != null && !"".equals(posDay)) {
			sb.append("			and p1.pos_day="+getZeroMonthDay(posDay)+"<br>	"	);
		}
		sb.append(	"		GROUP BY pos_store_num)						<br> " );
		sb.append(	"	AND s.store_num = p.pos_store_num							<br> " );
		sb.append(	"	ORDER BY							<br> " );
		sb.append(	"		p.pos_store_num						<br> " );
		model.addAttribute("message", sb.toString());
		return "sqlShow.jsp";
	}
	
	@RequestMapping("newMaxQuantityPer")
	public String newMaxQuantityPer(HttpServletRequest req,Model model){
		String posYear = req.getParameter("posYear");
		String posMonth = req.getParameter("posMonth");
		String posDay = req.getParameter("posDay");
		StringBuilder sb = new StringBuilder();
		sb.append(	"	SELECT							<br> " );
		sb.append(	"		p2.pos_num 最近一笔订单编号,						<br> " );
		sb.append(	"		p2.pos_store_num 门店番号,						<br> " );
		sb.append(	"		s.store_name 门店名字,						<br> " );
		sb.append(	"		date(concat(p2.pos_year,p2.pos_month,p2.pos_day)) 拿货日期,						<br> " );
		sb.append(	"		p2.pos_quantity 最大交易数						<br> " );
		sb.append(	"	from							<br> " );
		sb.append(	"	(SELECT							<br> " );
		sb.append(	"	max(p.pos_num) posNum							<br> " );
		sb.append(	"	FROM							<br> " );
		sb.append(	"		pos p						<br> " );
		sb.append(	"	WHERE (p.pos_store_num,p.pos_quantity) in(							<br> " );
		sb.append(	"				SELECT p1.pos_store_num,max(p1.pos_quantity) 				<br> " );
		sb.append(	"				FROM pos p1 				<br> " );
		sb.append(	"		where p1.pos_year = "+posYear+"<br>	"	);
		if (posMonth != null && !"".equals(posMonth)) {
			sb.append("			and p1.pos_month="+getZeroMonthDay(posMonth)+"<br>	"	);
		}
		if (posDay != null && !"".equals(posDay)) {
			sb.append("			and p1.pos_day="+getZeroMonthDay(posDay)+"<br>	"	);
		}
		sb.append(	"				GROUP BY pos_store_num)				<br> " );
		sb.append(	"	GROUP BY							<br> " );
		sb.append(	"		p.pos_store_num						<br> " );
		sb.append(	"	ORDER BY							<br> " );
		sb.append(	"		p.pos_store_num) p1						<br> " );
		sb.append(	"	join pos p2							<br> " );
		sb.append(	"	on p2.pos_num = p1.posNum							<br> " );
		sb.append(	"	join  store s							<br> " );
		sb.append(	"	on s.store_num = p2.pos_store_num							<br> " );
		model.addAttribute("message", sb.toString());
		return "sqlShow.jsp";
	}
	
	@RequestMapping("tasteTotal")
	public String tasteTotal(HttpServletRequest req,Model model){
		String posYear = req.getParameter("posYear");
		String posMonth = req.getParameter("posMonth");
		String posDay = req.getParameter("posDay");
		StringBuilder sb = new StringBuilder();
		sb.append(	"	SELECT															<br> " );
		sb.append(	"		g.goods_num 商品编号,														<br> " );
		sb.append(	"		g.goods_name 商品名字,														<br> " );
		sb.append(	"		g.goods_flavor 口味,														<br> " );
		if (posDay != null && !"".equals(posDay)&&posMonth != null && !"".equals(posMonth)) {
			sb.append(	"		date(concat(pos_year,pos_month,pos_day)) 日期,														<br> " );
		} else if (posMonth != null && !"".equals(posMonth)) {
			sb.append(	"		concat(pos_year,pos_month) 日期,														<br> " );
		} else {
			sb.append(	"		pos_year 日期,														<br> " );
		}
		sb.append(	"		sum(p.pos_quantity) 拿货总量,														<br> " );
		sb.append(	"		floor(sum(p.pos_quantity) / 32) 箱,														<br> " );
		sb.append(	"		MOD (sum(p.pos_quantity), 32) 碗														<br> " );
		sb.append(	"	FROM															<br> " );
		sb.append(	"		pos p,														<br> " );
		sb.append(	"		goods g														<br> " );
		sb.append(	"	WHERE															<br> " );
		sb.append(	"		p.pos_goods_num = g.goods_num														<br> " );
		sb.append(	"	AND p.pos_year = "+posYear+"															<br> " );
		if (posMonth != null && !"".equals(posMonth)) {
			sb.append("			and p.pos_month="+getZeroMonthDay(posMonth)+"<br>	"	);
		}
		if (posDay != null && !"".equals(posDay)) {
			sb.append("			and p.pos_day="+getZeroMonthDay(posDay)+"<br>	"	);
		}
		sb.append(	"	group by g.goods_num															<br> " );
		model.addAttribute("message", sb.toString());
		return "sqlShow.jsp";
	}
	
	@RequestMapping("quantityTotalPerStore")
	public String quantityTotalPerStore(HttpServletRequest req,Model model){
		String posYear = req.getParameter("posYear");
		String posMonth = req.getParameter("posMonth");
		String posDay = req.getParameter("posDay");
		String takeTime = req.getParameter("takeTime");
		StringBuilder sb = new StringBuilder();
		sb.append(	"	SELECT															<br> " );
		sb.append(	"		s.store_num 店铺编号,														<br> " );
		sb.append(	"		s.store_name 店铺名字,														<br> " );
		sb.append(	"		temp.concatdate 日期,														<br> " );
		sb.append(	"		temp.counts 店铺拿货回数,														<br> " );
		sb.append(	"		temp.totalQuantity 店铺拿货总量,														<br> " );
		sb.append(	"		floor(temp.totalQuantity / 32) 箱,														<br> " );
		sb.append(	"		mod (temp.totalQuantity, 32) 碗														<br> " );
		sb.append(	"	FROM															<br> " );
		sb.append(	"		store s,														<br> " );
		sb.append(	"		(														<br> " );
		sb.append(	"			SELECT													<br> " );
		sb.append(	"				p.pos_store_num,												<br> " );
		sb.append(	"				count(*) counts,												<br> " );
		if (posDay != null && !"".equals(posDay)&&posMonth != null && !"".equals(posMonth)) {
			sb.append(	"		date(concat(p.pos_year,p.pos_month,p.pos_day)) concatdate,														<br> " );
		} else if (posMonth != null && !"".equals(posMonth)) {
			sb.append(	"		concat(p.pos_year,p.pos_month) concatdate,														<br> " );
		} else {
			sb.append(	"		p.pos_year concatdate,														<br> " );
		}
		sb.append(	"				SUM(p.pos_quantity) totalQuantity												<br> " );
		sb.append(	"			FROM													<br> " );
		sb.append(	"				pos p												<br> " );
		sb.append(	"			WHERE													<br> " );
		sb.append(	"				p.pos_year = "+posYear+"											<br> " );
		if (posMonth != null && !"".equals(posMonth)) {
			sb.append("			and p.pos_month="+getZeroMonthDay(posMonth)+"<br>	"	);
		}
		if (posDay != null && !"".equals(posDay)) {
			sb.append("			and p.pos_day="+getZeroMonthDay(posDay)+"<br>	"	);
		}
		sb.append(	"			GROUP BY													<br> " );
		sb.append(	"				p.pos_store_num												<br> " );
		sb.append(	"			HAVING													<br> " );
		sb.append(	"				counts >= "+takeTime+"												<br> " );
		sb.append(	"		) temp														<br> " );
		sb.append(	"	WHERE															<br> " );
		sb.append(	"		s.store_num = temp.pos_store_num														<br> " );
		model.addAttribute("message", sb.toString());
		return "sqlShow.jsp";
	}
	
	@RequestMapping("orderAgencyAndCount")
	public String orderAgencyAndCount(HttpServletRequest req,Model model){
		String posYear = req.getParameter("posYear");
		String posMonth = req.getParameter("posMonth");
		String posDay = req.getParameter("posDay");
		StringBuilder sb = new StringBuilder();
		sb.append(	"	SELECT															<br> " );
		sb.append(	"		p.pos_num 订单号,														<br> " );
		if (posDay != null && !"".equals(posDay)&&posMonth != null && !"".equals(posMonth)) {
			sb.append(	"		date(concat(p.pos_year,p.pos_month,p.pos_day)) 日期,														<br> " );
		} else if (posMonth != null && !"".equals(posMonth)) {
			sb.append(	"		concat(p.pos_year,p.pos_month) 日期,														<br> " );
		} else {
			sb.append(	"		p.pos_year 日期,														<br> " );
		}
		sb.append(	"		s.store_name 门店名字,														<br> " );
		sb.append(	"		a.agency_name 业务员名字,														<br> " );
		sb.append(	"		(														<br> " );
		sb.append(	"			SELECT													<br> " );
		sb.append(	"				COUNT( *)												<br> " );
		sb.append(	"			FROM													<br> " );
		sb.append(	"				pos p1												<br> " );
		sb.append(	"			WHERE													<br> " );
		sb.append(	"				p.pos_agency_num = p1.pos_agency_num												<br> " );
		sb.append(	"		and p1.pos_year = "+posYear+"														<br> " );
		if (posMonth != null && !"".equals(posMonth)) {
			sb.append("			and p1.pos_month="+getZeroMonthDay(posMonth)+"<br>	"	);
		}
		if (posDay != null && !"".equals(posDay)) {
			sb.append("			and p1.pos_day="+getZeroMonthDay(posDay)+"<br>	"	);
		}
		sb.append(	"		) 业务员订单笔数														<br> " );
		sb.append(	"	FROM															<br> " );
		sb.append(	"		pos p														<br> " );
		sb.append(	"	JOIN agency a ON a.agency_num = p.pos_agency_num															<br> " );
		sb.append(	"	JOIN store s ON s.store_num = p.pos_store_num															<br> " );
		sb.append(	"	WHERE															<br> " );
		sb.append(	"		p.pos_year = "+posYear+"														<br> " );
		if (posMonth != null && !"".equals(posMonth)) {
			sb.append("			and p.pos_month="+getZeroMonthDay(posMonth)+"<br>	"	);
		}
		if (posDay != null && !"".equals(posDay)) {
			sb.append("			and p.pos_day="+getZeroMonthDay(posDay)+"<br>	"	);
		}
		sb.append(	"	GROUP BY															<br> " );
		sb.append(	"		p.pos_num														<br> " );
		sb.append(	"	ORDER BY															<br> " );
		sb.append(	"		业务员订单笔数  desc,														<br> " );
		sb.append(	"		a.agency_name	asc													<br> " );
		model.addAttribute("message", sb.toString());
		return "sqlShow.jsp";
	}
	
	@RequestMapping("quantityMoreThan")
	public String quantityMoreThan(HttpServletRequest req,Model model){
		String posYear = req.getParameter("posYear");
		String posMonth = req.getParameter("posMonth");
		String posDay = req.getParameter("posDay");
		String moreThanSome = req.getParameter("moreThanSome");
		StringBuilder sb = new StringBuilder();
		sb.append(	"	SELECT DISTINCT															<br> " );
		sb.append(	"		s.store_num 店铺番号,														<br> " );
		sb.append(	"		s.store_name 店铺名字,														<br> " );
		sb.append(	"		c.customer_name 店铺负责人,														<br> " );
		sb.append(	"		c.customer_telephone 店铺负责人电话,														<br> " );
		sb.append(	"	  a.agency_name 店铺对应业务员,															<br> " );
		sb.append(	"	  a.agency_telephone 店铺对应业务员电话,															<br> " );
		if (posDay != null && !"".equals(posDay)&&posMonth != null && !"".equals(posMonth)) {
			sb.append(	"		date(concat(p.pos_year,p.pos_month,p.pos_day)) 日期,														<br> " );
		} else if (posMonth != null && !"".equals(posMonth)) {
			sb.append(	"		concat(p.pos_year,p.pos_month) 日期,														<br> " );
		} else {
			sb.append(	"		p.pos_year 日期,														<br> " );
		}
		sb.append(	"		SUM(p.pos_quantity) 店铺总拿货数,														<br> " );
		sb.append(	"		floor(sum(p.pos_quantity) / 32) 箱,														<br> " );
		sb.append(	"		MOD (sum(p.pos_quantity), 32) 碗														<br> " );
		sb.append(	"	FROM															<br> " );
		sb.append(	"		store s,														<br> " );
		sb.append(	"		pos p,														<br> " );
		sb.append(	"	  customer c,															<br> " );
		sb.append(	"		agency a														<br> " );
		sb.append(	"	WHERE															<br> " );
		sb.append(	"		s.store_num = p.pos_store_num														<br> " );
		sb.append(	"	and s.store_customer_num=c.customer_num															<br> " );
		sb.append(	"	and s.store_agency_num = a.agency_num															<br> " );
		sb.append(	"	AND p.pos_year = "+posYear+"														<br> " );
		if (posMonth != null && !"".equals(posMonth)) {
			sb.append("			and p.pos_month="+getZeroMonthDay(posMonth)+"<br>	"	);
		}
		if (posDay != null && !"".equals(posDay)) {
			sb.append("			and p.pos_day="+getZeroMonthDay(posDay)+"<br>	"	);
		}
		sb.append(	"	GROUP BY															<br> " );
		sb.append(	"		s.store_num														<br> " );
		sb.append(	"	HAVING															<br> " );
		sb.append(	"		店铺总拿货数 > "+moreThanSome+"														<br> " );
		model.addAttribute("message", sb.toString());
		return "sqlShow.jsp";
	}
	
	@RequestMapping("likeSearch")
	public String likeSearch(HttpServletRequest req,Model model){
		String posYear = req.getParameter("posYear");
		String posMonth = req.getParameter("posMonth");
		String posDay = req.getParameter("posDay");
		String likeName = req.getParameter("likeName");
		StringBuilder sb = new StringBuilder();
		sb.append(	"	SELECT DISTINCT															<br> " );
		sb.append(	"		s.*														<br> " );
		sb.append(	"	FROM															<br> " );
		sb.append(	"		store s,														<br> " );
		sb.append(	"		pos p														<br> " );
		sb.append(	"	WHERE															<br> " );
		sb.append(	"		s.store_num = p.pos_store_num														<br> " );
		if (posYear != null && !"".equals(posYear)) {
			sb.append(	"			and p.pos_year="+posYear+"<br>	"	);
		}
		if (posMonth != null && !"".equals(posMonth)) {
			sb.append("			and p.pos_month="+getZeroMonthDay(posMonth)+"<br>	"	);
		}
		if (posDay != null && !"".equals(posDay)) {
			sb.append("			and p.pos_day="+getZeroMonthDay(posDay)+"<br>	"	);
		}
		sb.append(	"																<br> " );
		sb.append(	"	AND s.store_name LIKE '%"+likeName+"%';															<br> " );
		model.addAttribute("message", sb.toString());
		return "sqlShow.jsp";
	}
	
	@RequestMapping("noBuyGoods")
	public String noBuyGoods(HttpServletRequest req,Model model){
		String posYear = req.getParameter("posYear");
		String posMonth = req.getParameter("posMonth");
		String posDay = req.getParameter("posDay");
		StringBuilder sb = new StringBuilder();
		sb.append(	"	SELECT															<br> " );
		sb.append(	"		s.store_num 店铺番号,														<br> " );
		sb.append(	"		s.store_name 店铺名字,														<br> " );
		if (posDay != null && !"".equals(posDay)&&posMonth != null && !"".equals(posMonth)) {
			sb.append(	"		concat_ws('-', "+posYear+","+getZeroMonthDay(posMonth)+","+getZeroMonthDay(posDay)+") 日期,														<br> " );
		} else if (posMonth != null && !"".equals(posMonth)) {
			sb.append(	"		concat_ws('-',"+posYear+","+getZeroMonthDay(posMonth)+") 日期,														<br> " );
		} else {
			sb.append(	"		"+posYear+" 日期,														<br> " );
		}
		sb.append(	"		c.customer_name 店铺负责人,														<br> " );
		sb.append(	"		c.customer_telephone 店铺负责人电话,														<br> " );
		sb.append(	"		a.agency_name 店铺对应业务员,														<br> " );
		sb.append(	"		a.agency_telephone 店铺对应业务员电话														<br> " );
		sb.append(	"	FROM															<br> " );
		sb.append(	"		store s,														<br> " );
		sb.append(	"		customer c,														<br> " );
		sb.append(	"		agency a														<br> " );
		sb.append(	"	WHERE															<br> " );
		sb.append(	"		s.store_num NOT IN (														<br> " );
		sb.append(	"			SELECT DISTINCT													<br> " );
		sb.append(	"				p1.pos_store_num												<br> " );
		sb.append(	"			FROM													<br> " );
		sb.append(	"				pos p1												<br> " );
		sb.append(	"			WHERE													<br> " );
		sb.append(	"				p1.pos_year = "+posYear+"												<br> " );
		if (posMonth != null && !"".equals(posMonth)) {
			sb.append("			and p1.pos_month="+getZeroMonthDay(posMonth)+"<br>	"	);
		}
		if (posDay != null && !"".equals(posDay)) {
			sb.append("			and p1.pos_day="+getZeroMonthDay(posDay)+"<br>	"	);
		}
		sb.append(	"		)														<br> " );
		sb.append(	"	AND s.store_customer_num = c.customer_num															<br> " );
		sb.append(	"	AND s.store_agency_num = a.agency_num															<br> " );
		model.addAttribute("message", sb.toString());
		return "sqlShow.jsp";
	}
	
	@RequestMapping("goodsKindsPerStore")
	public String goodsKindsPerStore(HttpServletRequest req,Model model){
		String posYear = req.getParameter("posYear");
		String posMonth = req.getParameter("posMonth");
		String posDay = req.getParameter("posDay");
		StringBuilder sb = new StringBuilder();
		sb.append(	"	SELECT															<br> " );
		sb.append(	"		s.store_num 店铺番号,														<br> " );
		sb.append(	"		s.store_name 店铺名称,														<br> " );
		sb.append(	"		c.customer_name 店铺负责人,														<br> " );
		sb.append(	"		c.customer_telephone 店铺负责人电话,														<br> " );
		sb.append(	"		a.agency_name 店铺对应业务员,														<br> " );
		sb.append(	"		a.agency_telephone 店铺对应业务员电话,														<br> " );
		if (posDay != null && !"".equals(posDay)&&posMonth != null && !"".equals(posMonth)) {
			sb.append(	"		date(concat(p.pos_year,p.pos_month,p.pos_day)) 日期,														<br> " );
		} else if (posMonth != null && !"".equals(posMonth)) {
			sb.append(	"		concat(p.pos_year,p.pos_month) 日期,														<br> " );
		} else {
			sb.append(	"		p.pos_year 日期,														<br> " );
		}
		sb.append(	"		group_concat(DISTINCT g.goods_name) 口味汇总														<br> " );
		sb.append(	"	FROM															<br> " );
		sb.append(	"		pos p,														<br> " );
		sb.append(	"		goods g,														<br> " );
		sb.append(	"		store s,														<br> " );
		sb.append(	"		customer c,														<br> " );
		sb.append(	"		agency a														<br> " );
		sb.append(	"	WHERE															<br> " );
		sb.append(	"		p.pos_goods_num = g.goods_num														<br> " );
		sb.append(	"	AND p.pos_store_num = s.store_num															<br> " );
		sb.append(	"	AND s.store_customer_num = c.customer_num															<br> " );
		sb.append(	"	AND s.store_agency_num = a.agency_num															<br> " );
		sb.append(	"	AND p.pos_year = "+posYear+"														<br> " );
		if (posMonth != null && !"".equals(posMonth)) {
			sb.append("			and p.pos_month="+getZeroMonthDay(posMonth)+"<br>	"	);
		}
		if (posDay != null && !"".equals(posDay)) {
			sb.append("			and p.pos_day="+getZeroMonthDay(posDay)+"<br>	"	);
		}
		sb.append(	"	GROUP BY															<br> " );
		sb.append(	"		s.store_name														<br> " );
		sb.append(	"		ORDER BY s.store_name 														<br> " );
		model.addAttribute("message", sb.toString());
		return "sqlShow.jsp";
	}
	
	@RequestMapping("buyAButNotBuyB")
	public String buyAButNotBuyB(HttpServletRequest req,Model model){
		String posYear = req.getParameter("posYear");
		String posMonth = req.getParameter("posMonth");
		String posDay = req.getParameter("posDay");
		String likeName1 = req.getParameter("likeName1");
		String likeName2 = req.getParameter("likeName2");
		String likeName3 = req.getParameter("likeName3");
		String likeName4 = req.getParameter("likeName4");
		StringBuilder sb = new StringBuilder();
		sb.append(	"	SELECT															<br> " );
		sb.append(	"		s1.store_num 门店编号,														<br> " );
		sb.append(	"		s1.store_name 门店名字,														<br> " );
		sb.append(	"		c.customer_name 店铺负责人,														<br> " );
		sb.append(	"		c.customer_telephone 店铺负责人电话,														<br> " );
		sb.append(	"		a.agency_name 店铺对应业务员,														<br> " );
		sb.append(	"		a.agency_telephone 店铺对应业务员电话,														<br> " );
		if (posDay != null && !"".equals(posDay)&&posMonth != null && !"".equals(posMonth)) {
			sb.append(	"		date(concat(p1.pos_year,p1.pos_month,p1.pos_day)) 日期,														<br> " );
		} else if (posMonth != null && !"".equals(posMonth)) {
			sb.append(	"		concat(p1.pos_year,p1.pos_month) 日期,														<br> " );
		} else {
			sb.append(	"		p1.pos_year 日期,														<br> " );
		}
		sb.append(	"		(														<br> " );
		sb.append(	"			SELECT													<br> " );
		sb.append(	"				group_concat(DISTINCT g.goods_name)												<br> " );
		sb.append(	"			FROM													<br> " );
		sb.append(	"				goods g												<br> " );
		sb.append(	"			WHERE													<br> " );
		sb.append(	"			g.goods_name LIKE '%"+likeName1+"%'													<br> " );
		if (likeName2 != null && !"".equals(likeName2)) {
			sb.append(	"			OR g.goods_name LIKE '%"+likeName2+"%'													<br> " );
		}
		if (likeName3 != null && !"".equals(likeName3)) {
			sb.append(	"			OR g.goods_name LIKE '%"+likeName3+"%'													<br> " );
		}
		if (likeName4 != null && !"".equals(likeName4)) {
			sb.append(	"			OR g.goods_name LIKE '%"+likeName4+"%'													<br> " );
		}		sb.append(	"		) 没有拿的口味,														<br> " );
		sb.append(	"		g1.goods_name 实际拿的口味														<br> " );
		sb.append(	"	FROM															<br> " );
		sb.append(	"		store s1,														<br> " );
		sb.append(	"		pos p1,														<br> " );
		sb.append(	"		goods g1,														<br> " );
		sb.append(	"		customer c,														<br> " );
		sb.append(	"		agency a														<br> " );
		sb.append(	"	WHERE															<br> " );
		sb.append(	"		p1.pos_store_num = s1.store_num														<br> " );
		sb.append(	"	AND p1.pos_goods_num = g1.goods_num															<br> " );
		sb.append(	"	AND s1.store_customer_num = c.customer_num															<br> " );
		sb.append(	"	AND s1.store_agency_num = a.agency_num															<br> " );
		sb.append(	"	AND p1.pos_year = "+posYear+"															<br> " );
		if (posMonth != null && !"".equals(posMonth)) {
			sb.append("			and p1.pos_month="+getZeroMonthDay(posMonth)+"<br>	"	);
		}
		if (posDay != null && !"".equals(posDay)) {
			sb.append("			and p1.pos_day="+getZeroMonthDay(posDay)+"<br>	"	);
		}
		sb.append(	"	AND s1.store_num NOT IN (															<br> " );
		sb.append(	"		SELECT														<br> " );
		sb.append(	"			p.pos_store_num													<br> " );
		sb.append(	"		FROM														<br> " );
		sb.append(	"			pos p,													<br> " );
		sb.append(	"			goods g													<br> " );
		sb.append(	"		WHERE														<br> " );
		sb.append(	"			p.pos_goods_num = g.goods_num													<br> " );
		sb.append(	"		AND (														<br> " );
		sb.append(	"			g.goods_name LIKE '%"+likeName1+"%'													<br> " );
		if (likeName2 != null && !"".equals(likeName2)) {
			sb.append(	"			OR g.goods_name LIKE '%"+likeName2+"%'													<br> " );
		}
		if (likeName3 != null && !"".equals(likeName3)) {
			sb.append(	"			OR g.goods_name LIKE '%"+likeName3+"%'													<br> " );
		}
		if (likeName4 != null && !"".equals(likeName4)) {
			sb.append(	"			OR g.goods_name LIKE '%"+likeName4+"%'													<br> " );
		}
		sb.append(	"		)														<br> " );
		sb.append(	"		AND p.pos_year = "+posYear+"														<br> " );
		if (posMonth != null && !"".equals(posMonth)) {
			sb.append("			and p.pos_month="+getZeroMonthDay(posMonth)+"<br>	"	);
		}
		if (posDay != null && !"".equals(posDay)) {
			sb.append("			and p.pos_day="+getZeroMonthDay(posDay)+"<br>	"	);
		}
		sb.append(	"	)															<br> " );
		model.addAttribute("message", sb.toString());
		return "sqlShow.jsp";
	}
	
	@RequestMapping("avgJudge")
	public String avgJudge(HttpServletRequest req,Model model){
		String posYear = req.getParameter("posYear");
		String posMonth = req.getParameter("posMonth");
		String posDay = req.getParameter("posDay");
		String count1 = req.getParameter("count1");
		String res1 = req.getParameter("res1");
		String count2 = req.getParameter("count2");
		String count3 = req.getParameter("count3");
		String res2 = req.getParameter("res2");
		String res3 = req.getParameter("res3");
		StringBuilder sb = new StringBuilder();
		sb.append(	"	select s.store_name 店铺名字,															<br> " );
		sb.append(	"	c.customer_name 店铺负责人,															<br> " );
		sb.append(	"	c.customer_telephone 店铺负责人电话,															<br> " );
		sb.append(	"	a.agency_name 店铺对应业务员,															<br> " );
		sb.append(	"	a.agency_telephone 店铺对应业务员电话, 															<br> " );
		if (posDay != null && !"".equals(posDay)&&posMonth != null && !"".equals(posMonth)) {
			sb.append(	"		date(concat(p.pos_year,p.pos_month,p.pos_day)) 日期,														<br> " );
		} else if (posMonth != null && !"".equals(posMonth)) {
			sb.append(	"		concat(p.pos_year,p.pos_month) 日期,														<br> " );
		} else {
			sb.append(	"		p.pos_year 日期,														<br> " );
		}
		sb.append(	"	 ROUND(avg(p.pos_quantity)) 平均拿货量, 															<br> " );
		sb.append(	"	 case 															<br> " );
		sb.append(	"	     when avg(p.pos_quantity)<="+count1+" then '"+res1+"'															<br> " );
		sb.append(	"			 when avg(p.pos_quantity)>"+count2+" and avg(p.pos_quantity)<="+count3+" then '"+res2+"'													<br> " );
		sb.append(	"	     else '"+res3+"'															<br> " );
		sb.append(	"	 end 评价															<br> " );
		sb.append(	"																<br> " );
		sb.append(	"	FROM															<br> " );
		sb.append(	"		pos p,														<br> " );
		sb.append(	"		store s,														<br> " );
		sb.append(	"		customer c,														<br> " );
		sb.append(	"		agency a														<br> " );
		sb.append(	"	WHERE															<br> " );
		sb.append(	"		p.pos_store_num = s.store_num														<br> " );
		sb.append(	"	AND s.store_customer_num = c.customer_num															<br> " );
		sb.append(	"	AND s.store_agency_num = a.agency_num															<br> " );
		sb.append(	"	AND p.pos_year = "+posYear+"														<br> " );
		if (posMonth != null && !"".equals(posMonth)) {
			sb.append("			and p.pos_month="+getZeroMonthDay(posMonth)+"<br>	"	);
		}
		if (posDay != null && !"".equals(posDay)) {
			sb.append("			and p.pos_day="+getZeroMonthDay(posDay)+"<br>	"	);
		}		sb.append(	"	GROUP BY															<br> " );
		sb.append(	"		s.store_num														<br> " );
		model.addAttribute("message", sb.toString());
		return "sqlShow.jsp";
	}
	
	@RequestMapping("activedStore")
	public String activedStore(HttpServletRequest req,Model model){
		String posYear = req.getParameter("posYear");
		String posMonth = req.getParameter("posMonth");
		String posDay = req.getParameter("posDay");
		String posYear1 = req.getParameter("posYear1");
		String posMonth1 = req.getParameter("posMonth1");
		String posDay1 = req.getParameter("posDay1");
		StringBuilder sb = new StringBuilder();
		sb.append(	"	SELECT 															<br> " );
		sb.append(	"	date(concat(p.pos_year,p.pos_month,p.pos_day)) AS 日期, 															<br> " );
		sb.append(	"	COUNT(DISTINCT p.pos_customer_num) AS 活跃用户数,															<br> " );
		sb.append(	"	group_concat(distinct s.store_name) as 活跃店铺名字,															<br> " );
		sb.append(	"	SUM(p.pos_quantity) 拿货数,															<br> " );
		sb.append(	"	floor(sum(p.pos_quantity) / 32) 箱,															<br> " );
		sb.append(	"	mod (sum(p.pos_quantity), 32) 碗															<br> " );
		sb.append(	"	from															<br> " );
		sb.append(	"		pos p,														<br> " );
		sb.append(	"		store s														<br> " );
		sb.append(	"	where															<br> " );
		sb.append(	"	p.pos_store_num = s.store_num															<br> " );
		sb.append(	"	and date(concat(p.pos_year,p.pos_month,p.pos_day)) 															<br> " );
		sb.append(	"	BETWEEN '"+posYear+"-"+getZeroMonthDay(posMonth)+"-"+getZeroMonthDay(posDay)+"'															<br> " );
		sb.append(	"	AND '"+posYear1+"-"+getZeroMonthDay(posMonth1)+"-"+getZeroMonthDay(posDay1)+"'															<br> " );
		sb.append(	"	GROUP BY date(concat(p.pos_year,p.pos_month,p.pos_day))															<br> " );
		model.addAttribute("message", sb.toString());
		return "sqlShow.jsp";
	}
	
	@RequestMapping("storeEarn")
	public String storeEarn(HttpServletRequest req,Model model){

		String posYear = req.getParameter("posYear");
		String posMonth = req.getParameter("posMonth");
		String posDay = req.getParameter("posDay");
		String countPerBin = req.getParameter("countPerBin");
		String storeCost = req.getParameter("storeCost");
		String storeSale = req.getParameter("storeSale");
		String parterCost = req.getParameter("parterCost");
		StringBuilder sb = new StringBuilder();
		sb.append(	"	select															<br> " );
		sb.append(	"		s.store_num 门店番号,														<br> " );
		sb.append(	"		s.store_name 门店名字,														<br> " );
		if (posDay != null && !"".equals(posDay)&&posMonth != null && !"".equals(posMonth)) {
			sb.append(	"		date(concat(p.pos_year,p.pos_month,p.pos_day)) 日期,														<br> " );
		} else if (posMonth != null && !"".equals(posMonth)) {
			sb.append(	"		concat(p.pos_year,p.pos_month) 日期,														<br> " );
		} else {
			sb.append(	"		p.pos_year 日期,														<br> " );
		}		sb.append(	"		sum(p.pos_quantity) 门店拿货数量,														<br> " );
		sb.append(	"		floor(sum(p.pos_quantity) / "+countPerBin+") 箱,														<br> " );
		sb.append(	"		mod (sum(p.pos_quantity), "+countPerBin+") 碗,														<br> " );
		sb.append(	"		sum(p.pos_total_price) 门店拿货总价钱, # 从销售数据Excel 中读取														<br> " );
		sb.append(	"		sum(p.pos_quantity) * ("+storeCost+") 门店拿货总价钱校验,														<br> " );
		sb.append(	"		sum(p.pos_reduced_price) 门店优惠减免的价钱, # 从销售数据Excel 中读取														<br> " );
		sb.append(	"		sum(p.pos_final_price) 门店拿货最终价钱, # 从销售数据Excel 中读取														<br> " );
		sb.append(	"	  sum(p.pos_quantity) * ("+storeCost+") - sum(p.pos_reduced_price) 门店拿货最终价钱校验,#门店拿货总价钱 - 门店优惠减免的价钱															<br> " );
		sb.append(	"		sum(p.pos_quantity) * ("+storeSale+") 门店营业额,														<br> " );
		sb.append(	"	  sum(p.pos_quantity) * ("+storeSale+")- sum(p.pos_quantity) * ("+storeCost+") 门店理论赚, #门店营业额 - 门店拿货总价钱															<br> " );
		sb.append(	"		sum(p.pos_quantity) * ("+storeSale+")- sum(p.pos_final_price) 门店实际赚, # 门店营业额 - 门店拿货最终价钱														<br> " );
		sb.append(	"		sum(p.pos_quantity) * ("+parterCost+" / "+countPerBin+") 合伙人成本,														<br> " );
		sb.append(	"		sum(p.pos_quantity) * ("+storeCost+" -("+parterCost+" / "+countPerBin+")) 理论我赚,														<br> " );
		sb.append(	"		sum(p.pos_final_price) - sum(p.pos_quantity) * ("+parterCost+" / "+countPerBin+") 实际我赚, #门店拿货最终价钱 - 合伙人成本														<br> " );
		sb.append(	"		round(((sum(p.pos_quantity) * ("+storeSale+")- sum(p.pos_quantity) * ("+storeCost+"))/(sum(p.pos_quantity) * ("+storeCost+" -("+parterCost+" / "+countPerBin+")))),2) \"理论 门店赚/我赚 倍数\",														<br> " );
		sb.append(	"		round(((sum(p.pos_quantity) * ("+storeSale+")- sum(p.pos_final_price))/(sum(p.pos_final_price) - sum(p.pos_quantity) * ("+parterCost+" / "+countPerBin+"))),2) \"实际 门店赚/我赚 倍数\",														<br> " );
		sb.append(	"		c.customer_name 门店负责人,														<br> " );
		sb.append(	"		c.customer_telephone 门店负责人电话,														<br> " );
		sb.append(	"		a.agency_name 业务员,														<br> " );
		sb.append(	"		a.agency_telephone 业务员电话														<br> " );
		sb.append(	"	from															<br> " );
		sb.append(	"		pos p,														<br> " );
		sb.append(	"		agency a,														<br> " );
		sb.append(	"		customer c,														<br> " );
		sb.append(	"		store s														<br> " );
		sb.append(	"	where															<br> " );
		sb.append(	"		p.pos_year = "+posYear+"														<br> " );
		if (posMonth != null && !"".equals(posMonth)) {
			sb.append("			and p.pos_month="+getZeroMonthDay(posMonth)+"<br>	"	);
		}
		if (posDay != null && !"".equals(posDay)) {
			sb.append("			and p.pos_day="+getZeroMonthDay(posDay)+"<br>	"	);
		}		sb.append(	"	and p.pos_agency_num = a.agency_num															<br> " );
		sb.append(	"	and p.pos_customer_num = c.customer_num															<br> " );
		sb.append(	"	and p.pos_store_num = s.store_num															<br> " );
		sb.append(	"	group by															<br> " );
		sb.append(	"		p.pos_store_num														<br> " );
		sb.append(	"	order by															<br> " );
		sb.append(	"		sum(p.pos_final_price) - sum(p.pos_quantity) * ("+parterCost+" / "+countPerBin+") desc #实际我赚														<br> " );
		model.addAttribute("message", sb.toString());
		return "sqlShow.jsp";
	
	}
	
	@RequestMapping("qq")
	public String show1(HttpServletRequest req,Model model){
		String posYear = req.getParameter("posYear");
		String posMonth = req.getParameter("posMonth");
		String posDay = req.getParameter("posDay");
		StringBuilder sb = new StringBuilder();
		sb.append(	"			where pos.pos_year="+posYear+"<br>	"	);
		if (posMonth != null && !"".equals(posMonth)) {
			sb.append("			and pos.pos_month="+getZeroMonthDay(posMonth)+"<br>	"	);
		}
		if (posDay != null && !"".equals(posDay)) {
			sb.append("			and pos.pos_day="+getZeroMonthDay(posDay)+"<br>	"	);
		}
		
		model.addAttribute("message", sb.toString());
		return "sqlShow.jsp";
	}
	
	public String getZeroMonthDay(String str) {
		if ("1".equals(str)) {
			return "01";
		} else if ("2".equals(str)) {
			return "03";
		} else if ("3".equals(str)) {
			return "03";
		} else if ("4".equals(str)) {
			return "04";
		} else if ("5".equals(str)) {
			return "05";
		} else if ("6".equals(str)) {
			return "06";
		} else if ("7".equals(str)) {
			return "07";
		} else if ("8".equals(str)) {
			return "08";
		} else if ("9".equals(str)) {
			return "09";
		}
		return str;
	}
}
