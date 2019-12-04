<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>${acount.aname }的订单</title>
	<link rel="stylesheet" type="text/css" href="/jyhwebstore/store/css/order.css"/>
	<link rel="stylesheet" type="text/css" href="/jyhwebstore/store/css/bootstrap.css"/>
  </head>
  
  <body>
    <div class="top_bar">
			<div class="clearfix">
				<div class="left">
				<a href="/jyhwebstore/index.jsp">
				<span class="glyphicon glyphicon-home"></span>
				聚优汇首页</a>
				
				</div>
				<a id="current" style="display:inline-block;margin:0 auto;"></a>
				<div class="right">
					<a href="/jyhwebstore/store/html/operation/order.jsp">
						<span class="glyphicon glyphicon-list-alt"></span>
						我的订单</a>
					<c:if test="${empty acount}">
						<a href="/jyhwebstore/store/html/login.jsp?path=index.jsp" id="log">
							登录
						</a>
					</c:if>
						<c:if test="${not empty acount}">
							<a href="javascript:out()" id="out">退出</a>
							<a href="/jyhwebstore/store/html/operation/information.jsp?path=index.jsp" id="log">
							${acount.aname }
						</a>
						</c:if>
					
				</div>
			</div>
		</div>
		
			<div class="header">
			<div class="header-bp">
				<div class="logo">
					<a href="/jyhwebstore/index.jsp" class="hd-logo"><img src="/jyhwebstore/store/img/Logo.png" /></a>
				</div>

				<div class="header-right">

					<div class="cart-2">
						<a href="/jyhwebstore/store/html/operation/cart.jsp">
							<span class="glyphicon glyphicon-shopping-cart"></span>
							<span>购物车</span>
						</a>
					</div>

					<div class="search">
						<div class="hd-search">
							<input type="text" placeholder="请输入要搜索的内容" class="search-input"/>
							<a href="javascript:;" class="button" onclick="gosearch()"><span class="glyphicon glyphicon-search"></span>
							</a>
						</div>
						<ul>
							<li><a href="/jyhwebstore/store/html/search.jsp?content=Apple">Apple</a></li>
							<li><a href="/jyhwebstore/store/html/search.jsp?content=oppo">oppo</a></li>
							<li><a href="/jyhwebstore/store/html/search.jsp?content=vivo">vivo</a></li>
							<li><a href="/jyhwebstore/store/html/search.jsp?content=飞利浦">飞利浦</a></li>
						</ul>
					</div>
				</div>

			</div>
		</div>
		
		<div class="mycontent">
			<div class="body-clearfix">
			<div class="side-nav">
				<div class="side-nav-order">
					
					<p>
						<span class="glyphicon glyphicon-list-alt"></span>  我的交易
					</p>
				<a href="/jyhwebstore/store/html/operation/order.jsp" class="a-active">聚优汇订单</a>
				</div>
				
				<div class="menber">
					<p>
						<span class="glyphicon glyphicon-star"></span> 会员资料
					</p>
					<a href="/jyhwebstore/store/html/operation/userdetails.jsp">个人资料</a>
					<a href="/jyhwebstore/store/html/address.jsp">地址管理</a>
				</div>
				
				
				
				
				
			</div>
			<div class="order">
				<ul id="choose">
					<li class="all now"><p>所有订单<p><span>|</span></li>
					<li class="pay"><p>待付款</p><span>|</span></li>
					<li class="receive"><p>待收货</p><span>|</span></li>
					<li class="fished"><p>已完成</p><span>|</span></li>
					<li class="cancel"><p>已取消</p></li>
				</ul>
				
				
				<div class="order-item">
					<div class="active order-all">
			<!--  
				<div class="order-item-all">
				
				<div class="order-header">
					<div class="order-left">
					<div class="time">2019-11-20</div>
					<div class="order-num">订单号：11111</div>
					<div class="receiver">收货人:aaa</div>
					</div>
					
					
				<div class="order-right">
					<div class="price">总金额：￥34.90</div>
					<div class="state">已完成</div>
				<div class="name">聚优汇</div>
				
				</div>
					
				</div >
				
				<div class="order-list">
					<div class="order-pro">
						<a href="">
						<img src="/jyhwebstore/store/img/bgctop.jpg"/></a>
						<div class="order-title">
							<p class="desc">商品描述</p>
							<div class="buy-btn">再次购买</div>
						</div>
					</div>
					<div class="order-btns">已完成</div>
					<div class="order-btns">订单详情</div>
				</div>
			</div>
			
			-->
			
					</div>
					
					
		<div class="order-pay">
					<!-- 待付款的商品 -->
					</div>
					
					<div class="order-receive">
					<!-- 待收货的商品 -->
					</div>
					
					<div class="order-fished">
					<!-- 已完成的商品 -->
					
					</div>
					
					<div class="order-cancel">
					<!-- 已取消的商品 -->
					</div>
				</div>
				
			
		
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			<div class="turnpagebottom">
			<div class="turnpage">
				<div class="pre"><span class="glyphicon glyphicon-triangle-left"></span></div>
				<div class="num">1</div>
				<div class="next"><span class="glyphicon glyphicon-triangle-right"></span></div>
				<p>共1页</p>
				<div class="in"><span>到第</span>
					<input type="number"/>
				</div>
				<div class="sure">确定</div>
				
			</div>
			</div>
			
		
		
			</div>
			
			</div>
		</div>
		
		
		<section>
			<div class="footer">
				<div class="footer-top">
					<div class="icon">
						<img src="/jyhwebstore/store/img/icon1.png" class="icons">
						<h3 class="content-1">正品保障</h3>
						<p class="sub-content">正品行货 放心选购</p>
					</div>
					<div class="icon">
						<img src="/jyhwebstore/store/img/icon2.png" class="icons">
						<h3 class="content-1">满99包邮</h3>
						<p class="sub-content">满99元 免运费</p>
					</div>
					<div class="icon">
						<img src="/jyhwebstore/store/img/icon3.png" class="icons">
						<h3 class="content-1">售后无忧</h3>
						<p class="sub-content">7天无理由退货</p>
					</div>
					<div class="icon">
						<img src="/jyhwebstore/store/img/icon4.png" class="icons">
						<h3 class="content-1">准时送达</h3>
						<p class="sub-content">收货时间由你做主</p>
					</div>
				</div>
				<div class="footer-bottom">
					<div class="sundry">
						<div class="list-bottom">
							<div class="details">
								<ul>
									<li><a href="" class="">购物流程</a></li>
									<li><a href="">会员制度</a></li>
									<li><a href="">订单查询</a></li>
									<li><a href="">服务协议及隐私说明</a></li>
									<li><a href="">网站地图</a></li>
								</ul>
							</div>

							<div class="details">
								<ul>
									<li><a href="">支付方式</a></li>
									<li><a href="">货到付款</a></li>
									<li><a href="">网上支付</a></li>
									<li><a href="">礼品卡支付</a></li>
									<li><a href="">其它支付</a></li>
								</ul>
							</div>
							<div class="details">
								<ul>
									<li><a href="">配送服务</a></li>
									<li><a href="">配送进度查询</a></li>
									<li><a href="">商品验货与签收</a></li>
								</ul>
							</div>
							<div class="details">
								<ul>
									<li><a href="">相关规则</a></li>
									<li><a href="">平台规则</a></li>
									<li><a href="">退换货政策</a></li>
									<li><a href="">发票制度</a></li>
									<li><a href="">帮助中心</a></li>
								</ul>
							</div>

						</div>


					</div>


					<!--<div class="QR-codes">
						<p class="contact"><span class="glyphicon glyphicon-phone-alt"></span>联系我们</p>
						<img src="images/QR-code.png" alt="">
					</div>-->
				</div>
			</div>
		</section>
	
		<section>
			<div class="statment">
				<p>
					<a href="">湘ICP备16050468号</a>|
					<a href="">经营证照</a>|
					<a href="">互联网药品信息服务资格证(湘)-经营性-2017-0006</a>|
					<a href="">违法和不良信息举报电话：110</a>|
					<a href="">湘B2-20191024</a>|
					<a href="">湘公网安备 31010333002939号</a>|
					<a href="">友情链接</a>|
					<a href="">出版物经营许可证</a>|
					<a href="">增值电信业务经营许可证</a>|
				</p>
				<p>Copyright© 聚优汇网上超市 2007-2019，All Rights Reserved</p>
			</div>
		</section>
		
		
		<div id="top">
					回到顶部
		</div>
	
  </body>
</html>
<script src="/jyhwebstore/store/js/jquery.min.js"></script>
<script src="/jyhwebstore/store/js/webstore.js"></script>
<script src="/jyhwebstore/store/js/order.js"></script>
<script>
//搜索按钮
function gosearch(){
	
	// console.log("点击了搜索");
	var searchText = $('.search-input').val();
	var text =encodeURI(searchText);
	// alert(text);
	window.location.href=`/jyhwebstore/store/html/search.jsp?content=`+searchText;
	
};

$("body").keydown(function(event){
	if(event.keyCode == 13)
		{
			var  content = $(".search-input").val();
			if(content != "")
			{
				gosearch();
			}
		}
			
	
});

var allForm;//所有订单,方便处理

//获得所有该用户的订单
$(function(){
	$.get({
		type:"get",
		url:"/jyhwebstore/order",
		data:"action=getallbyid"+"&aid="+"${acount.aid}",
		success:function(result){
			var json = JSON.parse(result);
			allForm = json;
		//	console.log(json);
			for(var j=0; j<json.length;j++)//遍历所有订单
			{	
				console.log("订单"+j);
				var orderid;
				var ordername;
				var orderprice;
				var orderstatement;
				var orderpay;
				var orderstatmentstr;//显示在页面上的订单状态
				var orderForms = json[j].orderForms;
				for (var i = 0; i < orderForms.length;i++) {
						var aid = orderForms[i].aid;
						var comid=orderForms[i].comid;
						var comname=orderForms[i].comname;
						var orderadd=orderForms[i].orderadd;
						var ordercompany=orderForms[i].ordercompany;
						var year= orderForms[i].orderdate.year-100+2000;
						var day =orderForms[i].orderdate.day;
						var month =orderForms[i].orderdate.month+1;
						var hours =orderForms[i].orderdate.hours;
						var minutes=orderForms[i].orderdate.minutes;
						var seconds = orderForms[i].orderdate.seconds;
						//var time = ""+year+"年"+month+"月"+day+"日"+hours+"时"+minutes+"分"+seconds+"秒";
						var time = year+"年"+month+"月"+day+"日";
		 				orderid = orderForms[i].orderid;
		 				ordername =orderForms[i].ordername;
		 				var orderphone = orderForms[i].orderphone;
		 				 orderprice =orderForms[i].orderprice;
		 				orderstatement =orderForms[i].orderstatement;
		 				orderpay =orderForms[i].orderpay;
		 				console.log(orderForms[i]);
		 				
						}
				if(orderstatement == 1)
					{
						orderstatmentstr = "已完成";
					}
				else if(orderstatement ==2 )
					{
						orderstatmentstr = "未收货";
					}
				else if(orderstatement ==3 )
					{
						orderstatmentstr = "未取消";
					}
				else if(orderstatement ==4 )
					{
						orderstatmentstr = "已取消";
					}
				
				var str=`
 		 		<div class="order-item-all">
 						
 						<div class="order-header">
 							<div class="order-left">
 							<div class="time">`+time+`</div>
 							<div class="order-num">订单号：<span>`+orderid+`</span></div>
 							<div class="receiver">收货人:`+ordername+`</div>
 							</div>
 							
 							
 						<div class="order-right">
 							<div class="price">总金额：`+orderprice+`元</div>
 							<div class="state">`+orderstatmentstr+`</div>
 						
 						</div>
 							
 						</div >
 						 
 						<div class="order-4list">
 							<div class="order-pro">
 								<a href="">
 								<img src="/jyhwebstore/store/img/bgctop.jpg"/></a>
 								<div class="order-title">
 									<p class="desc">`+comname+`<span>等    `+orderForms.length+`件商品</span>`+`</p>
 									
 									<div class="buy-btn" onclick="buyagin(this)">再次购买</div>
 								</div>
 							</div>
 							<div class="order-btns">`+orderstatmentstr+`</div>
 							<div class="order-btns" onclick="goorderdetail(this)">订单详情</div>
 						</div>
 					</div>
 						
 						`;
 						$(".order-all").append(str);
			}
			
			
			shownotpay();
			showgetgoods();	
			getgoodsok();
			getgoodscancel();
			
		}
		
		
	});
	
	
	
});

function goorderdetail(obj){
var orderid= $(obj).parent().siblings().eq(0).children().eq(0).children().eq(1).children().eq(0).html();
location.href="/jyhwebstore/store/html/operation/orderdetail.jsp?orderid="+orderid;

}

function buyagin(obj){

var orderid=$(obj).parent().parent().parent().siblings().eq(0).children().eq(0).children().eq(1).children().eq(0).html();
location.href="/jyhwebstore/store/html/operation/ordersubmit.jsp?orderid="+orderid;
}

</script>
