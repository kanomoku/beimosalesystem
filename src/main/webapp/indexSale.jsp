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
趋势--7天采样--7天销售数量--7天销售均值--增长情况<br>
趋势--7天采样--7天销售数量--7天订单数--7天拿货门店数--增长情况<br>
趋势--月总拿货量--增长情况<br>
<br>
统计--每个月份--订单数--门店数--拿货总数<br>
统计--每日--活跃店铺数--店铺名汇总--拿货总数<br>
<br>
评价--每个门店--拿货总量--拿货回数--平均拿货量--均值评价<br>
统计--每个门店--年内每月--拿货总数<br>
统计--每个门店--周内每天--拿货总数<br>
统计--某年/某月--周内每天--拿货总数<br>
统计--年内每月--周内每天--拿货总数<br>
<br>
统计--每笔订单业务员--业务员的订单总数<br>
<br>
分布--订单单笔拿货数量分布--(单笔1-5箱去统计)<br>
<br>
排名--订单单笔拿货数量排名(存在并列)<br>




<div class="box">
    <div class="img">
        <img style="width:1000px;height:400px;" src="/images/3-Dingtalk_20201214135515.jpg" alt="3" />
    </div>
    <ul class="list" style="width:860px;height:400px;">
        <li><span>功能:</span> <font size="4" color="#FF4500">趋势--7天采样--7天销售数量--7天销售均值--增长情况</font></li>
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
        <li><span>功能:</span> <font size="4" color="#FF4500">趋势--7天采样--7天销售数量--7天订单数--7天拿货门店数--增长情况</font></li>
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

<div class="box">
    <div class="img">
        <img style="width:600px;height:200px;" src="/images/4-Dingtalk_20201214135858.jpg" alt="4" />
    </div>
    <ul class="list" style="width:400px;height:400px;">
        <li><span>功能:</span> <font size="4" color="#FF4500">趋势--月总拿货量--增长情况</font></li>
        <li><span>查询:</span>			
        			<form name="form" action="monthAdd" method="post">
						年：<input type="text" name="posYear" required="required" style="width: 30px;" /> 
						<input type="submit" value="查询" /> 
						<input type="reset" value="重置">
					</form>
		</li>
        <li><span>描述：</span><p>按月分析增长变化情况</p></li>
    </ul>
    <div class="img">
        <img style="width:1000px;height:400px;" src="/images/4-2-Dingtalk_20201227121219.jpg" alt="4-2" />
    </div>
</div>

<div class="box">
    <div class="img">
        <img style="width:800px;height:300px;" src="/images/23-Dingtalk_20201230231435.jpg" alt="23" />
    </div>
    <ul class="list" style="width:800px;height:300px;">
        <li><span>功能:</span> <font size="4" color="#FF4500">评价--每个门店--拿货总量--拿货回数--平均拿货量--均值评价</font></li>
        <li><span>查询:</span>			
        			<form name="form" action="avgJudge" method="post">
						<input type="text" name="posYear"  required="required" style="width: 30px;" /> 年
						<input type="text" name="posMonth"  style="width: 30px;" /> 月
						<input type="text" name="posDay"  style="width: 30px;" /> 日 ： 如果<br>
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

<div class="box">
    <div class="img">
        <img style="width:1000px;height:400px;" src="/images/7-Dingtalk_20201214150331.jpg" alt="7" />
    </div>
    <ul class="list">
        <li><span>功能:</span> <font size="4" color="#FF4500">统计--每个门店--年内每月--拿货总数</font></li>
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
        <img style="width:1000px;height:400px;" src="/images/6-Dingtalk_20201214144609.jpg" alt="6" />
    </div>
    <ul class="list">
        <li><span>功能:</span> <font size="4" color="#FF4500">统计--每个门店--周内每天--拿货总数</font></li>
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
        <img style="width:600px;height:200px;" src="/images/29-Dingtalk_20201227141247.jpg" alt="29" />
    </div>
    <ul class="list" style="width:450px;height:400px;">
        <li><span>功能:</span> <font size="4" color="#FF4500">统计--某年/某月--周内每天--拿货总数</font></li>
        <li><span>查询:</span>			
        			<form name="form" action="weekendDisplay" method="post">
						年：<input type="text" name="posYear" required="required" style="width: 30px;" /> 
						月：<input type="text" name="posMonth" style="width: 30px;" /> 
						<input type="submit" value="查询" /> 
						<input type="reset" value="重置">
					</form>
		</li>
        <li><span>描述：</span><p>每年或者每个月的 销售数量  星期分布</p></li>
    </ul>
    <div class="img">
        <img style="width:700px;height:400px;" src="/images/29-2Dingtalk_20201227141923.jpg" alt="29-2" />
    </div>
</div>

<div class="box">
    <div class="img">
        <img style="width:500px;height:200px;" src="/images/30-Dingtalk_20201227143144.jpg" alt="30" />
    </div>
    <ul class="list" style="width:450px;height:400px;">
        <li><span>功能:</span> <font size="4" color="#FF4500">统计--年内每月--周内每天--拿货总数</font></li>
        <li><span>查询:</span>			
        			<form name="form" action="monthPerYearWeekendDisplay" method="post">
						年：<input type="text" name="posYear" required="required" style="width: 30px;" /> 
						<input type="submit" value="查询" /> 
						<input type="reset" value="重置">
					</form>
		</li>
        <li><span>描述：</span><p>销售数量 年内每个月   星期分布</p></li>
    </ul>
</div>

<div class="box">
    <div class="img">
        <img style="width:400px;height:200px;" src="/images/13-Dingtalk_20201214212633.jpg" alt="13" />
    </div>
    <ul class="list">
        <li><span>功能:</span> <font size="4" color="#FF4500">统计--每个月份--订单数--门店数--拿货总数</font></li>
        <li><span>查询:</span>			
        			<form name="form" action="monthOrderCustomer" method="post">
						年：<input type="text" name="posYear" required="required" style="width: 30px;" /> 
						<input type="submit" value="查询" /> 
						<input type="reset" value="重置">
					</form>
		</li>
        <li><span>描述：</span><p>按按月统计订单数与顾客数</p></li>
    </ul>
</div>






<div class="box">
    <div class="img">
        <img src="/images/1-Dingtalk_20201227201208.jpg" alt="1" />
    </div>
    <ul class="list">
        <li><span>功能:</span> <font size="4" color="#FF4500">分布--订单单笔拿货数量分布--(单笔1-5箱去统计)</font></li>
        <li><span>查询:</span>			
        			<form name="form" action="orderTotalHistogram" method="post">
						年：<input type="text" name="posYear" required="required" style="width: 30px;" /> 
						月：<input type="text" name="posMonth" style="width: 30px;" /> 
						日：<input type="text" name="posDay" style="width: 30px;" /> 
						<input type="submit" value="查询" /> 
						<input type="reset" value="重置">
					</form>
		</li>
        <li><span>描述：</span><p>根据输入的项目，可以查询对应（年，年月，年月日） 的订单单笔拿货数量分布柱状图</p></li>
    </ul>
    <div class="img">
        <img src="/images/1-5F2E85E5-C518-41ff-A799-BD4C36995F43.png" alt="1" />
    </div>
</div>

<div class="box">
    <div class="img">
        <img style="width:1000px;height:400px;" src="/images/5-Dingtalk_20201227210905.jpg" alt="2" />
    </div>
    <ul class="list">
        <li><span>功能:</span> <font size="4" color="#FF4500">排名--订单单笔拿货数量排名(存在并列)</font></li>
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
        <img style="width:600px;height:300px;" src="/images/18-Dingtalk_20201224145629.jpg" alt="18" />
    </div>
    <ul class="list">
        <li><span>功能:</span> <font size="4" color="#FF4500">统计--每笔订单业务员--业务员的订单总数</font></li>
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
        <img style="width:600px;height:300px;" src="/images/24-Dingtalk_20201225161647.jpg" alt="24" />
    </div>
    <ul class="list">
        <li><span>功能:</span> <font size="4" color="#FF4500">统计--每日--活跃店铺数--店铺名汇总--拿货总数</font></li>
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
<br>
<br>
<br>
<a href="index.jsp">回到导航页</a>
</html>