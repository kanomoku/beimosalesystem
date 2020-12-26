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
.box{width:2050px;height:350px;margin:90px auto;}
.box .img{float:left;}
.box .img img{width:500px;height:350px;}
.box .list{float:left;width:500px;margin-left:10px;display:inline;}
.box .list li{line-height:30px;font-size:20px;}
.list li span{font-weight:bold;}

a:hover {color: red;}
font:hover {color: green;}

</style>
</head>
 
<body>
<div class="box">
    <div class="img">
        <img style="width:600px;height:300px;" src="/images/24-Dingtalk_20201225161647.jpg" alt="24" />
    </div>
    <ul class="list">
        <li><span>功能:</span> <font size="4" color="#FF4500">活跃店铺数</font></li>
        <li><span>查询:</span>			
        			<form name="form" action="activedStore" method="post">
						从<input type="text" name="posYear"  required="required" style="width: 30px;" /> 年
						<input type="text" name="posMonth"  required="required" style="width: 30px;" /> 月
						<input type="text" name="posDay" required="required" style="width: 30px;" /> 日 <br>
						到<input type="text" name="posYear1"  required="required" style="width: 30px;" /> 年
						<input type="text" name="posMonth1"  required="required" style="width: 30px;" /> 月
						<input type="text" name="posDay1" required="required" style="width: 30px;" /> 日 
						<br>的活跃店铺数<br>
						<input type="submit" value="查询" /> 
						<input type="reset" value="重置">
					</form>
		</li>
        <li><span>描述：</span><p>根据输入的项目，查询对应（年月日-年月日），活跃店铺数</p></li>
    </ul>
</div>

</body>
<br>
<br>
<a href="index.jsp">回到导航页</a>
</html>