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
</style>
</head>
<body>
	<table border='2'>
		<tr>
			<th>产品编号</th>
			<th>产品名称</th>
			<th>产品口味</th>
			<th>产品类别</th>
			<th>产品规格(g)</th>
			<th>保质期(月)</th>
			<th>生产工厂</th>
			<th>生产工厂法人</th>
			<th>进货价格</th>
			<th>一级代理价格</th>
			<th>二级代理价格</th>
			<th>三级代理价格</th>
			<th>店铺拿货价</th>
			<th>销售价格</th>
			<th>产品备注</th>
		</tr>
		<c:forEach items="${pageInfo.list}" var="goods">
			<tr>
				<td>${goods.goods_num}</td>
				<td>${goods.goods_name}</td>
				<td>${goods.goods_flavor }</td>
				<td>${goods.goods_category}</td>
				<td>${goods.goods_specification}</td>
				<td>${goods.goods_expiration_date}</td>
				<td>${goods.goods_plant}</td>
				<td>${goods.goods_legal_person}</td>
				<td>${goods.goods_mill_price}</td>
				<td>${goods.goods_first_class_agent_price}</td>
				<td>${goods.goods_second_class_agent_price}</td>
				<td>${goods.goods_third_class_agent_price}</td>
				<td>${goods.goods_store_purchase_price}</td>
				<td>${goods.goods_sale_price}</td>
				<td>${goods.goods_remark}</td>
			</tr>
		</c:forEach>
	</table>
		<a
		href="goodsShow?pageNum=${pageInfo.pageNum-1}&pageSize=${pageInfo.pageSize}"
		<c:if test="${pageInfo.pageNum<=1}" > onclick="javascript:return false;" </c:if>
		>上一页</a>
	<a
		href="goodsShow?pageNum=${pageInfo.pageNum+1}&pageSize=${pageInfo.pageSize}"
		<c:if test="${pageInfo.pageNum>= pageInfo.total}"> onclick="javascript:return false;"</c:if>
		>下一页</a><br>
	<a href="index.jsp">回到导航页</a>
</body>
</html>