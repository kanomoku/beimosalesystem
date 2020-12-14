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
