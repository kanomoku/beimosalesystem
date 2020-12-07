<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style type="text/css">
a {
	color: green;
	text-decoration: none;
	font-size: 20px;
	font-weight: bold
}

a:hover {
	color: red;
}

td {
	white-space: nowrap;
}
</style>
</head>
<body>
	<div style="overflow: auto; width: 100%;">
		<table border="1" height="55px" align="left">
			<tr>
				<th>POS编号</th>
				<th>POS年</th>
				<th>POS月</th>
				<th>POS日</th>
				<th>店铺编号</th>
				<th>当笔交易店铺诉求</th>
				<th>店家负责人编号</th>
				<th>当笔交易负责人诉求</th>
				<th>产品编号</th>
				<th>当笔交易产品诉求</th>
				<th>销售数量</th>
				<th>销售价格</th>
				<th>销售总价</th>
				<th>优惠活动</th>
				<th>优惠后价格</th>
				<th>代理商负责人编号</th>
				<th>POS备注</th>
				<th>拜访</th>
			</tr>
			<c:forEach items="${pageInfoAll.list}" var="pos">
				<tr>
					<td>${pos.pos_num}</td>
					<td>${pos.pos_year}</td>
					<td>${pos.pos_month}</td>
					<td>${pos.pos_day}</td>
					<td>${pos.pos_store_num}</td>
					<td>${pos.pos_store_remark}</td>
					<td>${pos.pos_customer_num}</td>
					<td>${pos.pos_customer_remark}</td>
					<td>${pos.pos_goods_num}</td>
					<td>${pos.pos_goods_remark}</td>
					<td>${pos.pos_quantity}</td>
					<td>${pos.pos_sale_price}</td>
					<td>${pos.pos_total_price}</td>
					<td>${pos.pos_reduced_price}</td>
					<td>${pos.pos_final_price}</td>
					<td>${pos.pos_agency_num}</td>
					<td>${pos.pos_remark}</td>
					<td>${pos.pos_visit}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<a
		href="posOrderShow?pageNum=${pageInfoAll.pageNum-1}&pageSize=${pageInfoAll.pageSize}&posYear=${pageInfoAll.posYear}&posMonth=${pageInfoAll.posMonth}&posDay=${pageInfoAll.posDay}"
		<c:if test="${pageInfoAll.pageNum<=1}" > onclick="javascript:return false;" </c:if>>上一页</a>
	<a
		href="posOrderShow?pageNum=${pageInfoAll.pageNum+1}&pageSize=${pageInfoAll.pageSize}&posYear=${pageInfoAll.posYear}&posMonth=${pageInfoAll.posMonth}&posDay=${pageInfoAll.posDay}"
		<c:if test="${pageInfoAll.pageNum>= pageInfoAll.total}"> onclick="javascript:return false;"</c:if>>下一页</a>
	<br>
	<a href="index.jsp">回到导航页</a>
</body>
</html>