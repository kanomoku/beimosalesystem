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
.box{width:3000px;height:400px;margin:90px auto;}
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
        <img style="width:1000px;height:400px;" src="/images/3-Dingtalk_20201214135515.jpg" alt="3" />
    </div>
    <ul class="list" style="width:860px;height:400px;">
        <li><span>功能:</span> <font size="4" color="#FF4500">销售额  7天增长情况</font></li>
        <li><span>查询:</span>			
        			<form name="form" action="avg7day" method="post">
						年：<input type="text" name="posYear" required="required" style="width: 30px;" /> 
						月：<input type="text" name="posMonth" style="width: 30px;" /> 
						<input type="submit" value="查询" /> 
						<input type="reset" value="重置">
					</form>
		</li>
        <li><span>描述：</span><p>根据输入的（年，年月），以 7 天（某日期 + 该日期前的 6 天）为一个时间段，查询门店对应的<br>  
        						7天销售额总数，<br>7天销售额平均数，<br>7天总销售额增长率，<br>7天均销售额增长率。</p></li>
    </ul>
        <div class="img">
        <img style="width:1000px;height:400px;" src="/images/3-2-Dingtalk_20201227112521.jpg" alt="3-2" />
    </div>
</div>

<div class="box">
    <div class="img">
        <img style="width:1000px;height:400px;" src="/images/3-Dingtalk_20201214135515.jpg" alt="27" />
    </div>
    <ul class="list" style="width:860px;height:400px;">
        <li><span>功能:</span> <font size="4" color="#FF4500">销售额,订单数,拿货门店数  7天增长情况</font></li>
        <li><span>查询:</span>			
        			<form name="form" action="avgAll7day" method="post">
						年：<input type="text" name="posYear" required="required" style="width: 30px;" /> 
						月：<input type="text" name="posMonth" style="width: 30px;" /> 
						<input type="submit" value="查询" /> 
						<input type="reset" value="重置">
					</form>
		</li>
        <li><span>描述：</span><p>根据输入的（年，年月），以 7 天（某日期 + 该日期前的 6 天）为一个时间段，查询门店对应的<br>  
        						7天销售额总数，7天销售额平均数，7天总销售额增长率，7天均销售额增长率。<br>
        						7天订单总数，7天订单平均数，7天总订单数增长率，7天均订单数增长率。<br>
        						7天拿货店铺总数，7天拿货店铺平均数，7天总拿货门店数增长率，7天平均拿货门店数增长率。<br></p></li>
    </ul>
        <div class="img">
        <img style="width:1000px;height:400px;" src="/images/28-Dingtalk_20201226205901.jpg" alt="28" />
    </div>
</div>

</body>
<br>
<br>
<br>
<br>
<br>
<a href="index.jsp">回到导航页</a>
</html>