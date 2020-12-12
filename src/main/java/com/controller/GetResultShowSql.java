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
			sb.append("			and pos.pos_month="+posMonth+"<br>	"	);
		}
		if (posDay != null && !"".equals(posDay)) {
			sb.append("			and pos.pos_day="+posDay+"<br>	"	);
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
}
