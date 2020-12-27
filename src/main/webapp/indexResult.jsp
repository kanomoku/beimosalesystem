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



<div class="box">
    <div class="img">
        <img style="width:1000px;height:400px;" src="/images/10-Dingtalk_20201214201749.jpg" alt="10" />
    </div>
    <ul class="list">
        <li><span>功能:</span> <font size="4" color="#FF4500">拿货回数以及占比</font></li>
        <li><span>查询:</span>			
        			<form name="form" action="storeTotalAndPercent" method="post">
						<input type="text" name="posYear" required="required" style="width: 30px;" /> 年
						<input type="text" name="posMonth"  style="width: 30px;" /> 月
						<input type="text" name="posDay"  style="width: 30px;" /> 日,不同门店的拿货回数以及占比
						<input type="submit" value="查询" /> 
						<input type="reset" value="重置">
					</form>
		</li>
        <li><span>描述：</span><p>根据输入的项目，查询对应（年，年月，年月日），不同门店的拿货回数以及占比</p></li>
    </ul>
</div>

<div class="box">
    <div class="img">
        <img style="width:600px;height:400px;" src="/images/11-Dingtalk_20201214204345.jpg" alt="11" />
    </div>
    <ul class="list">
        <li><span>功能:</span> <font size="4" color="#FF4500">拿货数量的中位数</font></li>
        <li><span>查询:</span>			
        			<form name="form" action="middleNumber" method="post">
						<input type="text" name="posYear" required="required" style="width: 30px;" /> 年
						<input type="text" name="posMonth"  style="width: 30px;" /> 月， 不同门店的单笔拿货数量的中位数.
						<input type="submit" value="查询" /> 
						<input type="reset" value="重置">
					</form>
		</li>
        <li><span>描述：</span><p>根据输入的项目，查询对应（年，年月），不同门店的单笔拿货数量中位数</p></li>
    </ul>
</div>

<div class="box">
    <div class="img">
        <img style="width:600px;height:300px;" src="/images/12-Dingtalk_20201214205634.jpg" alt="12" />
    </div>
    <ul class="list">
        <li><span>功能:</span> <font size="4" color="#FF4500">每个门店最经常订购的商品</font></li>
        <li><span>查询:</span>			
        			<form name="form" action="usuallyOrder" method="post">
						<input type="text" name="posYear" required="required" style="width: 30px;" /> 年
						<input type="text" name="posMonth"  style="width: 30px;" /> 月
						<input type="text" name="posDay"  style="width: 30px;" /> 日，每个门店最经常订购的商品.
						<input type="submit" value="查询" /> 
						<input type="reset" value="重置">
					</form>
		</li>
        <li><span>描述：</span><p>根据输入的项目，查询对应（年，年月，年月日），每个门店最经常订购的商品</p></li>
    </ul>
</div>

<div class="box">
    <div class="img">
        <img style="width:600px;height:300px;" src="/images/17-Dingtalk_20201224120528.jpg" alt="17" />
    </div>
    <ul class="list">
        <li><span>功能:</span> <font size="4" color="#FF4500">拿货N回以上的店铺</font></li>
        <li><span>查询:</span>			
        			<form name="form" action="quantityTotalPerStore" method="post">
						<input type="text" name="posYear" required="required" style="width: 30px;" /> 年
						<input type="text" name="posMonth"  style="width: 30px;" /> 月
						<input type="text" name="posDay"  style="width: 30px;" /> 日，拿货
						<input type="text" name="takeTime" required="required" style="width: 30px;" />回及以上的店铺名字,拿货回数, 拿货总数.<br>
						<input type="submit" value="查询" /> 
						<input type="reset" value="重置">
					</form>
		</li>
        <li><span>描述：</span><p>根据输入的项目，查询对应（年，年月，年月日），拿货N回以上的店铺 拿货回数  拿货总数</p></li>
    </ul>
</div>

<div class="box">
    <div class="img">
        <img style="width:600px;height:300px;" src="/images/18-Dingtalk_20201224145629.jpg" alt="18" />
    </div>
    <ul class="list">
        <li><span>功能:</span> <font size="4" color="#FF4500">每笔订单业务员是谁，以及业务员的订单总数</font></li>
        <li><span>查询:</span>			
        			<form name="form" action="orderAgencyAndCount" method="post">
						<input type="text" name="posYear" required="required" style="width: 30px;" /> 年
						<input type="text" name="posMonth"  style="width: 30px;" /> 月
						<input type="text" name="posDay"  style="width: 30px;" /> 日.<br>
						<input type="submit" value="查询" /> 
						<input type="reset" value="重置">
					</form>
		</li>
        <li><span>描述：</span><p>根据输入的项目，查询对应（年，年月，年月日），每笔订单业务员是谁，以及业务员的订单总数</p></li>
    </ul>
</div>

<div class="box">
    <div class="img">
        <img style="width:600px;height:300px;" src="/images/19-Dingtalk_20201224185108.jpg" alt="19" />
    </div>
    <ul class="list">
        <li><span>功能:</span> <font size="4" color="#FF4500">拿货总量超过N碗的店铺</font></li>
        <li><span>查询:</span>			
        			<form name="form" action="quantityMoreThan" method="post">
						<input type="text" name="posYear" required="required" style="width: 30px;" /> 年
						<input type="text" name="posMonth"  style="width: 30px;" /> 月
						<input type="text" name="posDay"  style="width: 30px;" /> 日，拿货超过
						<input type="text" name="moreThanSome" required="required" style="width: 30px;" />碗的店铺<br>
						<input type="submit" value="查询" /> 
						<input type="reset" value="重置">
					</form>
		</li>
        <li><span>描述：</span><p>根据输入的项目，查询对应（年，年月，年月日），拿货超过N碗的店铺</p></li>
    </ul>
</div>



<div class="box">
    <div class="img">
        <img style="width:600px;height:300px;" src="/images/21-Dingtalk_20201224204500.jpg" alt="21" />
    </div>
    <ul class="list">
        <li><span>功能:</span> <font size="4" color="#FF4500">没有拿货的店铺</font></li>
        <li><span>查询:</span>			
        			<form name="form" action="noBuyGoods" method="post">
						<input type="text" name="posYear" required="required" style="width: 30px;" /> 年
						<input type="text" name="posMonth"  style="width: 30px;" /> 月
						<input type="text" name="posDay"  style="width: 30px;" /> 日，没有拿货的店铺<br>
						<input type="submit" value="查询" /> 
						<input type="reset" value="重置">
					</form>
		</li>
        <li><span>描述：</span><p>根据输入的项目，查询对应（年，年月，年月日），没有拿货的店铺</p></li>
    </ul>
</div>





<div class="box">
    <div class="img">
        <img style="width:1000px;height:300px;" src="/images/23-Dingtalk_20201225140150.jpg" alt="23" />
    </div>
    <ul class="list">
        <li><span>功能:</span> <font size="4" color="#FF4500">平均拿货评价</font></li>
        <li><span>查询:</span>			
        			<form name="form" action="avgJudge" method="post">
						<input type="text" name="posYear"  required="required" style="width: 30px;" /> 年
						<input type="text" name="posMonth"  style="width: 30px;" /> 月
						<input type="text" name="posDay"  style="width: 30px;" /> 日 <br>如果<br>
						0 <= 拿货数量 <= <input type="text" name="count1" value="10" required="required"  style="width: 50px;" />是
						<input type="text" name="res1"  value="不好" style="width: 50px;" /> <br>
						
						<input type="text" name="count2"  value="10" style="width: 50px;" />  
						<  拿货数量 <= <input type="text" name="count3" value="20" style="width: 50px;" /> 是
						<input type="text" name="res2" value="一般" style="width: 50px;" /> <br>
						其他情况 ：<input type="text" name="res3" value="很好" style="width: 50px;" /> <br>
						
						
						<input type="submit" value="查询" /> 
						<input type="reset" value="重置">
					</form>
		</li>
        <li><span>描述：</span><p>根据输入的项目，查询对应（年，年月，年月日），平均拿货评价</p></li>
    </ul>
</div>


</body>
<br>
<br>
<br>
<br>
<a href="index.jsp">回到导航页</a>
</html>