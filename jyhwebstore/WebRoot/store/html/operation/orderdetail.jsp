<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>订单详情</title>
	<link rel="stylesheet" type="text/css" href="/jyhwebstore/store/css/order.css"/>
	<link rel="stylesheet" type="text/css" href="/jyhwebstore/store/css/ordersubmit.css"/>
	<link rel="stylesheet" type="text/css" href="/jyhwebstore/store/css/bootstrap.css"/>
	<link rel="stylesheet" type="text/css" href="/jyhwebstore/store/css/orderdetail.css"/>
	<link rel="shortcut icon" type="image/x-icon" href="/jyhwebstore/store/img/task.png" />
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
			<div class="orderdetailes">  
			<!-- 插入的地方 -->
	
			</div>
		</div>
		
		<section>
			<div class="footer">
				
				<div class="footer-bottom">
					<div class="sundry">
						

					</div>


					<div class="QR-codes">
						<p class="contact"><span class="glyphicon glyphicon-phone-alt"></span>联系我们</p>
						<img src="/jyhwebstore/store/img/QR-code.png" alt="">
					</div>
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

//获取地址栏上面的购物车id然后获取所有该购物车的商品
$(function showgoods(){
	var orderid=getUrlVal("out_trade_no");
	if(orderid!=null)
		{
			$.get({
					type:"get",
					url:"/jyhwebstore/order",
					data:"action=getorderfrombyorderid"+"&orderid="+orderid,
					success:function(result){
						var json = JSON.parse(result);
						console.log(json);
						var orderprice = json[0].orderprice;
						var product = json[0].orderdetaildtos;
						for (var i = 0; i < product.length; i++) {
							var comcount = product[i].comcount;
							var comid =product[i].comid;
							var comname= product[i].comname;
							var compic =product[i].compic;
							var detailsdot= product[i].detailsdot;
							var pai = product[i].pai;
							var color =  product[i].color;
							var size = product[i].size;
							var comcount = product[i].comcount;
							var comprice = product[i].comprice;
							var str = `
							<div class="box">
							<div class="dib_tit">聚优汇</div>
									<div class="des">
										<img src=\"`+compic+`\"/>
										<p class="name">`+comname+`</p>
										<p class="color">`+color+`</p>
									<p class="size">`+size+`	
										<span class="exist">有货</span>
										<span class="count">×`+comcount+`</span>
										<span class="price">`+comprice+`元</span>
									</p>
									</div>
						</div>
							`;
							
							
							$(".orderdetailes").append(str);
						}
					}
				})
		}
		if(getUrlVal("out_trade_no")!=null)
			{
				//说明是从支付成功页面转跳过来的
				//获取订单号传到后端进行修改状态
				var orderid=getUrlVal("out_trade_no");
				$.get({
					type:"get",
					url:"/jyhwebstore/order",
					data:{"action":"editstate","orderid":orderid,"orderstatement":"5","orderpay":"2"},
					datatype:"json",
					success:function(result){
						console.log(result);
					},
					
					
					
				});
				
				
			}
		
	
});


</script>
