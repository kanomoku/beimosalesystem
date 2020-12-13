<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
<style>
ul,p{margin:0;padding:0;}
li{list-style:none;}
.box{width:1500px;height:350px;margin:50px auto;}
.box .img{float:left;}
.box .img img{width:700px;height:350px;}
.box .list{float:left;width:500px;margin-left:50px;display:inline;}
.box .list li{line-height:30px;font-size:20px;}
.list li span{font-weight:bold;}

a:hover {color: red;}
font:hover {color: green;}
</style>
</head>
 
<body>
<div class="box">
    <div class="img">
        <img src="/images/089FA8D7-390F-4c2f-809D-5C44D1DBBE35.png" alt="1" />
    </div>
    <ul class="list">
        <li><span>功能:</span> <font size="4" color="#FF4500">订单笔数柱状图</font></li>
        <li><span>查询:</span>			
        			<form name="form" action="orderTotalHistogram" method="post">
						年：<input type="text" name="posYear" required="required" style="width: 30px;" /> 
						月：<input type="text" name="posMonth" style="width: 30px;" /> 
						日：<input type="text" name="posDay" style="width: 30px;" /> 
						<input type="submit" value="查询" /> 
						<input type="reset" value="重置">
					</form>
		</li>
        <li><span>描述：</span><p>根据输入的项目，可以查询对应的年，年月，年月日 的数据统计</p></li>
    </ul>
</div>

<div class="box">
    <div class="img">
        <img src="/images/58222992-2D8C-4e2e-AAF3-2FAB11117156.png" alt="2" />
    </div>
    <ul class="list">
        <li><span>功能:</span> <font size="4" color="#FF4500">订单单笔拿货数量排名（存在并列）</font></li>
        <li><span>查询:</span>			
        			<form name="form" action="singleOrderQuantity" method="post">
						年：<input type="text" name="posYear" required="required" style="width: 30px;" /> 
						月：<input type="text" name="posMonth" style="width: 30px;" /> 
						日：<input type="text" name="posDay" style="width: 30px;" /> 
						<input type="submit" value="查询" /> 
						<input type="reset" value="重置">
					</form>
		</li>
        <li><span>描述：</span><p>根据输入的项目，对应年，年月，年月日，销售数据的单笔销售数量的排名</p></li>
    </ul>
</div>


</body>

<br>
<br>
<br>
<br>
<a href="index.jsp">回到导航页</a>
</html>