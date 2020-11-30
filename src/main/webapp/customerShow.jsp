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
	<table border='5'>
		<tr>
			<th>店家负责人编号</th>
			<th>姓名</th>
			<th>电话</th>
			<th>性别</th>
			<th>出生年</th>
			<th>出生月</th>
			<th>负责人备注</th>
		</tr>
		<c:forEach items="${customerList}" var="customer">
			<tr>
				<td>${customer.customer_num}</td>
				<td>${customer.customer_name}</td>
				<td>${customer.customer_telephone}</td>
				<td>${customer.customer_gender}</td>
				<td>${customer.customer_year}</td>
				<td>${customer.customer_month}</td>
				<td>${customer.customer_remark}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="/customerShow">查询客户负责人</a>
</body>
</html>