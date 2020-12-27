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

<div class="box">
    <div class="img">
        <img style="width:400px;height:300px;" src="/images/9-Dingtalk_20201214165750.jpg" alt="9" />
    </div>
    <ul class="list" style="width:600px;height:300px;" >
        <li><span>功能:</span> <font size="4" color="#FF4500">新用户统计</font></li>
        <li><span>查询:</span>			
        			<form name="form" action="newStore" method="post">
						<input type="text" name="posYear" required="required" style="width: 30px;" /> 年
						<input type="text" name="posMonth" required="required" style="width: 30px;" /> 月
						<input type="text" name="posDay" required="required" style="width: 30px;" /> 日
						及前<input type="text" name="storeTotal" style="width: 30px;" /> 天新增门店数量，及门店名称<br>
						<input type="submit" value="查询" /> 
						<input type="reset" value="重置">
					</form>
		</li>
        <li><span>描述：</span><p>根据输入的项目，查询对应（年，年月，年月日），新用户统计</p></li>
    </ul>
</div>

<div class="box">
    <div class="img">
        <img style="width:600px;height:300px;" src="/images/20-Dingtalk_20201224201939.jpg" alt="20" />
    </div>
    <ul class="list">
        <li><span>功能:</span> <font size="4" color="#FF4500">拿了货的店铺名字模糊查询</font></li>
        <li><span>查询:</span>			
        			<form name="form" action="likeSearch" method="post">
						<input type="text" name="posYear"  style="width: 30px;" /> 年
						<input type="text" name="posMonth"  style="width: 30px;" /> 月
						<input type="text" name="posDay"  style="width: 30px;" /> 日，拿了货的名字有
						<input type="text" name="likeName" required="required" style="width: 50px;" />的店铺<br>
						<input type="submit" value="查询" /> 
						<input type="reset" value="重置">
					</form>
		</li>
        <li><span>描述：</span><p>根据输入的项目，查询对应（年，年月，年月日），拿了货的店铺名字模糊查询</p></li>
    </ul>
</div>

<div class="box">
    <div class="img">
        <img  src="/images/14-Dingtalk_20201214215804.jpg" alt="14" />
    </div>
    <ul class="list">
        <li><span>功能:</span> <font size="4" color="#FF4500">每个门店的最高单笔拿货量(存在并列)</font></li>
        <li><span>查询:</span>			
        			<form name="form" action="maxQuantityPer" method="post">
						<input type="text" name="posYear" required="required" style="width: 30px;" /> 年
						<input type="text" name="posMonth" style="width: 30px;" /> 月
						<input type="text" name="posDay" style="width: 30px;" /> 日,每个门店的最高单笔拿货量<br>
						<input type="submit" value="查询" /> 
						<input type="reset" value="重置">
					</form>
		</li>
        <li><span>描述：</span><p>给定（年，年月，年月日），每个门店的最高单笔拿货量</p></li>
    </ul>
</div>

<div class="box">
    <div class="img">
        <img  src="/images/15-Dingtalk_20201214223407.jpg" alt="15" />
    </div>
    <ul class="list">
        <li><span>功能:</span> <font size="4" color="#FF4500">每个门店的最高单笔拿货量(并列的话取最近一笔)</font></li>
        <li><span>查询:</span>			
        			<form name="form" action="newMaxQuantityPer" method="post">
						<input type="text" name="posYear" required="required" style="width: 30px;" /> 年
						<input type="text" name="posMonth" style="width: 30px;" /> 月
						<input type="text" name="posDay" style="width: 30px;" /> 日,每个门店的最高单笔拿货量<br>
						<input type="submit" value="查询" /> 
						<input type="reset" value="重置">
					</form>
		</li>
        <li><span>描述：</span><p>给定（年，年月，年月日），每个门店的最高单笔拿货量</p></li>
    </ul>
</div>

</body>
<br>
<br>
<a href="index.jsp">回到导航页</a>
</html>