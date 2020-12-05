<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
a {
	color: croci;
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


<a href="/agencyShow">查询代理商负责人</a>
<br>
<br>
<a href="/goodsShow">查询产品信息</a>
<br>
<br>
<a href="/storeShow">查询门店信息</a> <a href="/customerShow">查询客户负责人</a>
<br>
<br>
<a href="/posShow">查询销售记录</a>
<br>
<br>
<a href="readDateToDBService.jsp">存Excel文件到DB</a>
<br>
<br>

<form action="posOrderShow" method="post">
	年：<input type="text" name="posYear"/>
	月：<input type="text" name="posMonth"/>
	日：<input type="text" name="posDay"/>
	<input type="submit" value="查询对应日期销售数量-降序显示"/>
</form>
<br>

</html>