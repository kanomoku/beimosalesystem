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
        <img style="width:400px;height:200px;" src="/images/13-Dingtalk_20201214212633.jpg" alt="13" />
    </div>
    <ul class="list">
        <li><span>功能:</span> <font size="4" color="#FF4500">按月统计订单数与顾客数</font></li>
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

<div class="box">
    <div class="img">
        <img style="width:400px;height:300px;" src="/images/9-Dingtalk_20201214165750.jpg" alt="9" />
    </div>
    <ul class="list">
        <li><span>功能:</span> <font size="4" color="#FF4500">新用户统计</font></li>
        <li><span>查询:</span>			
        			<form name="form" action="newStore" method="post">
						<input type="text" name="posYear" required="required" style="width: 30px;" /> 年
						<input type="text" name="posMonth" required="required" style="width: 30px;" /> 月
						<input type="text" name="posDay" required="required" style="width: 30px;" /> 日
						及前<input type="text" name="storeTotal" style="width: 30px;" /> 天新增门店数量，及门店名称
						<input type="submit" value="查询" /> 
						<input type="reset" value="重置">
					</form>
		</li>
        <li><span>描述：</span><p>根据输入的项目，查询对应（年，年月，年月日），新用户统计</p></li>
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
        <img style="width:600px;height:300px;" src="/images/16-Dingtalk_20201223130746.jpg" alt="16" />
    </div>
    <ul class="list">
        <li><span>功能:</span> <font size="4" color="#FF4500">各个口味萝卜干卖出去的数量统计</font></li>
        <li><span>查询:</span>			
        			<form name="form" action="tasteTotal" method="post">
						<input type="text" name="posYear" required="required" style="width: 30px;" /> 年
						<input type="text" name="posMonth"  style="width: 30px;" /> 月
						<input type="text" name="posDay"  style="width: 30px;" /> 日，各个口味萝卜干卖出去的数量统计.<br>
						<input type="submit" value="查询" /> 
						<input type="reset" value="重置">
					</form>
		</li>
        <li><span>描述：</span><p>根据输入的项目，查询对应（年，年月，年月日），各个口味萝卜干卖出去的数量统计</p></li>
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
        <img style="width:800px;height:300px;" src="/images/22-Dingtalk_20201225130411.jpg" alt="22" />
    </div>
    <ul class="list">
        <li><span>功能:</span> <font size="4" color="#FF4500">店铺拿货种类统计</font></li>
        <li><span>查询:</span>			
        			<form name="form" action="goodsKindsPerStore" method="post">
						<input type="text" name="posYear" required="required" style="width: 30px;" /> 年
						<input type="text" name="posMonth"  style="width: 30px;" /> 月
						<input type="text" name="posDay"  style="width: 30px;" /> 日，店铺拿货种类统计<br>
						<input type="submit" value="查询" /> 
						<input type="reset" value="重置">
					</form>
		</li>
        <li><span>描述：</span><p>根据输入的项目，查询对应（年，年月，年月日），店铺拿货种类统计</p></li>
    </ul>
</div>

<div class="box">
    <div class="img">
        <img style="width:1000px;height:300px;" src="/images/23-Dingtalk_20201225140150.jpg" alt="23" />
    </div>
    <ul class="list">
        <li><span>功能:</span> <font size="4" color="#FF4500">没有拿指定口味的店汇总</font></li>
        <li><span>查询:</span>			
        			<form name="form" action="buyAButNotBuyB" method="post">
						<input type="text" name="posYear"  required="required" style="width: 30px;" /> 年
						<input type="text" name="posMonth"  style="width: 30px;" /> 月
						<input type="text" name="posDay"  style="width: 30px;" /> 日 <br>没有拿
						<input type="text" name="likeName1" required="required" style="width: 50px;" />和
						<input type="text" name="likeName2"  style="width: 50px;" />和
						<input type="text" name="likeName3"  style="width: 50px;" />和
						<input type="text" name="likeName4"  style="width: 50px;" />的店铺<br>
						<input type="submit" value="查询" /> 
						<input type="reset" value="重置">
					</form>
		</li>
        <li><span>描述：</span><p>根据输入的项目，查询对应（年，年月，年月日），拿了货的店铺名字模糊查询</p></li>
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
<br>
<br>
<a href="index.jsp">回到导航页</a>
</html>