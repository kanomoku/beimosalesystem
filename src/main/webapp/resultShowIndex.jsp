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
        <img src="/images/1-9D99F89A-7F5A-487f-BB54-240E7D84310A.png" alt="1" />
        <img src="/images/1-5F2E85E5-C518-41ff-A799-BD4C36995F43.png" alt="1" />
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
        <li><span>描述：</span><p>根据输入的项目，可以查询对应（年，年月，年月日） 的数据统计</p></li>
    </ul>
</div>

<div class="box">
    <div class="img">
        <img style="width:1000px;height:400px;" src="/images/58222992-2D8C-4e2e-AAF3-2FAB11117156.png" alt="2" />
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
        <li><span>描述：</span><p>根据输入的项目，查询对应（年，年月，年月日）销售数据的单笔销售数量的排名</p></li>
    </ul>
</div>

<div class="box">
    <div class="img">
        <img style="width:1000px;height:400px;" src="/images/3-Dingtalk_20201214135515.jpg" alt="3" />
    </div>
    <ul class="list">
        <li><span>功能:</span> <font size="4" color="#FF4500">销售数量7天变化增长</font></li>
        <li><span>查询:</span>			
        			<form name="form" action="avg7day" method="post">
						年：<input type="text" name="posYear" required="required" style="width: 30px;" /> 
						月：<input type="text" name="posMonth" style="width: 30px;" /> 
						<input type="submit" value="查询" /> 
						<input type="reset" value="重置">
					</form>
		</li>
        <li><span>描述：</span><p>根据输入的项目，以 7 天（某日期 + 该日期前的 6 天）为一个时间段，查询对应（年，年月）门店  7天拿货总量，7天拿货平均量，7天拿货总量的增量，7天拿货平均量的增量</p></li>
    </ul>
        <div class="img">
        <img src="/images/C447D3F6-1E95-452e-8962-C0516E204F25.png" alt="3" />
    </div>
</div>

<div class="box">
    <div class="img">
        <img src="/images/4-Dingtalk_20201214135858.jpg" alt="4" />
        <img src="/images/4D0D1532-48AB-4836-9588-404D1553376B.png" alt="4" />
    </div>
    <ul class="list">
        <li><span>功能:</span> <font size="4" color="#FF4500">月销售数量增长</font></li>
        <li><span>查询:</span>			
        			<form name="form" action="monthAdd" method="post">
						年：<input type="text" name="posYear" required="required" style="width: 30px;" /> 
						<input type="submit" value="查询" /> 
						<input type="reset" value="重置">
					</form>
		</li>
        <li><span>描述：</span><p>按月分析增长变化情况</p></li>
    </ul>
</div>

<div class="box">
    <div class="img">
        <img style="width:1000px;height:400px;" src="/images/5-Dingtalk_20201214140910.jpg" alt="5" />
    </div>
    <ul class="list">
        <li><span>功能:</span> <font size="4" color="#FF4500">按日期分组拿货店铺</font></li>
        <li><span>查询:</span>			
        			<form name="form" action="groupStore" method="post">
						年：<input type="text" name="posYear" required="required" style="width: 30px;" /> 
						月：<input type="text" name="posMonth" style="width: 30px;" /> 
						日：<input type="text" name="posDay" style="width: 30px;" /> 
						<input type="submit" value="查询" /> 
						<input type="reset" value="重置">
					</form>
		</li>
        <li><span>描述：</span><p>给定（年，年月，年月日），查询铺了多少家店，以及每个店的名字是啥;</p></li>
    </ul>
</div>

<div class="box">
    <div class="img">
        <img style="width:1000px;height:400px;" src="/images/6-Dingtalk_20201214144609.jpg" alt="6" />
    </div>
    <ul class="list">
        <li><span>功能:</span> <font size="4" color="#FF4500">各个门店周内每天的拿货情况</font></li>
        <li><span>查询:</span>			
        			<form name="form" action="everyWeek" method="post">
						年：<input type="text" name="posYear" required="required" style="width: 30px;" /> 
						月：<input type="text" name="posMonth" style="width: 30px;" /> 
						<input type="submit" value="查询" /> 
						<input type="reset" value="重置">
					</form>
		</li>
        <li><span>描述：</span><p>给定（年，年月，年月日），各个名店周内每天的销售情况;</p></li>
    </ul>
</div>

<div class="box">
    <div class="img">
        <img style="width:1000px;height:400px;" src="/images/7-Dingtalk_20201214150331.jpg" alt="7" />
    </div>
    <ul class="list">
        <li><span>功能:</span> <font size="4" color="#FF4500">各个门店周内每天的拿货情况</font></li>
        <li><span>查询:</span>			
        			<form name="form" action="everyMonth" method="post">
						年：<input type="text" name="posYear" required="required" style="width: 30px;" /> 
						月：<input type="text" name="posMonth" style="width: 30px;" /> 
						<input type="submit" value="查询" /> 
						<input type="reset" value="重置">
					</form>
		</li>
        <li><span>描述：</span><p>给定（年，年月），统计每个门店各个月拿了多少货;</p></li>
    </ul>
</div>

<div class="box">
    <div class="img">
        <img  src="/images/8-Dingtalk_20201214153307.jpg" alt="8" />
        <img  src="/images/8-Dingtalk_20201214153327.jpg" alt="8" />
    </div>
    <ul class="list">
        <li><span>功能:</span> <font size="4" color="#FF4500">求拿货量第i多的店名字</font></li>
        <li><span>查询:</span>			
        			<form name="form" action="orderOrder" method="post">
        				想要查看
						<input type="text" name="posYear" required="required" style="width: 30px;" /> 年：
						<input type="text" name="posMonth" style="width: 30px;" /> 月：
						<input type="text" name="posDay" style="width: 30px;" /> 日：
						拿货数第<input type="text" name="orderOrder" style="width: 30px;" /> 名的店铺名称
						<input type="submit" value="查询" /> 
						<input type="reset" value="重置">
					</form>
		</li>
        <li><span>描述：</span><p>给定（年，年月，年月日），求拿货量第i多的店名字;不去重只看店铺拿货排名</p></li>
    </ul>
</div>
</body>

<br>
<br>
<br>
<br>
<a href="index.jsp">回到导航页</a>
</html>