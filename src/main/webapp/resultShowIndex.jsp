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
font:hover {
	color: green;
}

td {
	white-space: nowrap;
}
</style>
</head>


<img src ="/images/089FA8D7-390F-4c2f-809D-5C44D1DBBE35.png" />
<br>
<font size="5" color="#FF4500">订单笔数柱状图</font>
<form name="form" action="orderTotalHistogram" method="post" >
	年：<input type="text" name="posYear" required="required" style="width:30px;"/>
	月：<input type="text" name="posMonth" style="width:30px;"/>
	日：<input type="text" name="posDay" style="width:30px;"/>
	<input type="submit" value="查询"/> 
	<input type="reset" value="重置">
</form>
<br>
<br>
<br>
<br>
<br>
<br>
<a href="index.jsp">回到导航页</a>
</html>