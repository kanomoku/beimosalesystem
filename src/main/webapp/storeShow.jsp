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
				<th>店铺编号</th>
				<th>店铺名称</th>
				<th>省</th>
				<th>市</th>
				<th>区</th>
				<th>街道</th>
				<th>店铺地址</th>
				<th>店铺类型</th>
				<th>店家负责人编号</th>
				<th>代理商负责人编号</th>
				<th>所处建筑区域</th>
				<th>地标建筑1</th>
				<th>地标建筑2</th>
				<th>地表建筑3</th>
				<th>地标建筑4</th>
				<th>标记地图</th>
				<th>合作开始日</th>
				<th>合作终止日</th>
				<th>终止原因</th>
				<th>店铺备注</th>
			</tr>
			<c:forEach items="${pageInfo.list}" var="store">
				<tr>
					<td>${store.store_num}</td>
					<td>${store.store_name}</td>
					<td>${store.store_province}</td>
					<td>${store.store_city}</td>
					<td>${store.store_block}</td>
					<td>${store.store_street}</td>
					<td>${store.store_address}</td>
					<td>${store.store_type}</td>
					<td>${store.store_customer_num}</td>
					<td>${store.store_agency_num}</td>
					<td>${store.store_location_area}</td>
					<td>${store.store_landmark1}</td>
					<td>${store.store_landmark2}</td>
					<td>${store.store_landmark3}</td>
					<td>${store.store_landmark4}</td>
					<td>${store.store_marked_map}</td>
					<td>${store.store_cooperation_start_date}</td>
					<td>${store.store_cooperation_end_date}</td>
					<td>${store.store_end_reason}</td>
					<td>${store.store_remark}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<a
		href="storeShow?pageNum=${pageInfo.pageNum-1}&pageSize=${pageInfo.pageSize}"
		<c:if test="${pageInfo.pageNum<=1}" > onclick="javascript:return false;" </c:if>>上一页</a>
	<a
		href="storeShow?pageNum=${pageInfo.pageNum+1}&pageSize=${pageInfo.pageSize}"
		<c:if test="${pageInfo.pageNum>= pageInfo.total}"> onclick="javascript:return false;"</c:if>>下一页</a>
	<br>
	<a href="index.jsp">回到导航页</a>
</body>
</html>