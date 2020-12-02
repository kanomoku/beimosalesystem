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
		<table border="1" height="120px" align="left">
			<tr>
				<th>代理商负责人编号</th>
				<th>用户名</th>
				<th>密码</th>
				<th>姓名</th>
				<th>电话</th>
				<th>性别</th>
				<th>出生年</th>
				<th>出生月</th>
				<th>店家负责人备注</th>
			</tr>
			<c:forEach items="${pageInfo.list}" var="agency">
				<tr>
					<td>${agency.agency_num}</td>
					<td>${agency.agency_username}</td>
					<td>${agency.agency_password}</td>
					<td>${agency.agency_name}</td>
					<td>${agency.agency_telephone}</td>
					<td>${agency.agency_gender}</td>
					<td>${agency.agency_year}</td>
					<td>${agency.agency_month}</td>
					<td>${agency.agency_remark}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<a
		href="agencyShow?pageNum=${pageInfo.pageNum-1}&pageSize=${pageInfo.pageSize}"
		<c:if test="${pageInfo.pageNum<=1}" > onclick="javascript:return false;" </c:if>>上一页</a>
	<a
		href="agencyShow?pageNum=${pageInfo.pageNum+1}&pageSize=${pageInfo.pageSize}"
		<c:if test="${pageInfo.pageNum>= pageInfo.total}"> onclick="javascript:return false;"</c:if>>下一页</a>
	<br>
	<a href="index.jsp">回到导航页</a>
</body>
</html>