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
        <img style="width:1000px;height:300px;" src="/images/25-Dingtalk_20201225202704.jpg" alt="25" />
    </div>
    <ul class="list">
        <li><span>功能:</span> <font size="4" color="#FF4500">店铺收益</font></li>
        <li><span>查询:</span>			
        			<form name="form" action="storeEarn" method="post">
						规格：<input type="text" name="countPerBin"  value="32" style="width: 30px;" /> 碗 /每箱<br>
						门店拿货价：<input type="text" name="storeCost"  value="4.5" style="width: 30px;" /> 元 .
						门店零售价：<input type="text" name="storeSale"  value="6.9" style="width: 30px;" /> 元 <br>
						合伙人成本：<input type="text" name="parterCost"  value="90" style="width: 30px;" /> 元 <br>
						从<input type="text" name="posYear"  required="required" style="width: 30px;" /> 年
						<input type="text" name="posMonth"   style="width: 30px;" /> 月
						<input type="text" name="posDay"  style="width: 30px;" /> 日起，  店铺的收益<br>
						<input type="submit" value="查询" /> 
						<input type="reset" value="重置">
					</form>
		</li>
        <li><span>描述：</span><p>根据输入的项目，查询对应（年，年月，年月日），店铺收益</p></li>
    </ul>
</div>

<div class="box">
    <div class="img">
        <img style="width:1000px;height:300px;" src="/images/26-Dingtalk_20201225232326.jpg" alt="26" />
    </div>
    <ul class="list">
        <li><span>功能:</span> <font size="4" color="#FF4500">业务员收益</font></li>
        <li><span>查询:</span>			
        			<form name="form" action="salerEarn" method="post">
						规格：<input type="text" name="countPerBin"  value="32" style="width: 30px;" /> 碗 /每箱<br>
						门店拿货价：<input type="text" name="storeCost"  value="4.5" style="width: 30px;" /> 元 .
						门店零售价：<input type="text" name="storeSale"  value="6.9" style="width: 30px;" /> 元 <br>
						合伙人成本：<input type="text" name="parterCost"  value="90" style="width: 30px;" /> 元 <br>
						从<input type="text" name="posYear"  required="required" style="width: 30px;" /> 年
						<input type="text" name="posMonth"   style="width: 30px;" /> 月
						<input type="text" name="posDay"  style="width: 30px;" /> 日起，  业务员收益<br>
						<input type="submit" value="查询" /> 
						<input type="reset" value="重置">
					</form>
		</li>
        <li><span>描述：</span><p>根据输入的项目，查询对应（年，年月，年月日），业务员收益</p></li>
    </ul>
</div>
</body>
<br>
<br>
<a href="index.jsp">回到导航页</a>
</html>