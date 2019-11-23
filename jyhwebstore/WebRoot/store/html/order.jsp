<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>My JSP 'order.jsp' starting page</title>
    <!-- meta name="viewport" content="width=device-width, initial-scale=1" /> -->
	<link rel="stylesheet" type="text/css" href="/jyhwebstore/store/css/order.css"/>
	<link rel="stylesheet" type="text/css" href="/jyhwebstore/store/css/bootstrap.css"/>
  </head>
  
  <body>
    <div class="top_bar">
			<div class="clearfix">
				<div class="left">
				<a href="">
				<span class="glyphicon glyphicon-home"></span>
				聚优汇首页</a>
				<a class="" href="">
					<span class="glyphicon glyphicon-map-marker"></span>
					送货地址：   长沙市
				</a>
				</div>
				
				
				<div class="right">
					<a href="">
						<span class="glyphicon glyphicon-list-alt"></span>
						我的订单</a>
					
					<a href="">注册</a>
					<a href="">登录</a>
					
				</div>
			</div>
		</div>
		
			<div class="header">
			<div class="header-bp">
				<div class="logo">
					<a href="index.html" class="hd-logo"><img src="../img/Logo.png" /></a>
					
				</div>

				<div class="header-right">

					<div class="cart-2">
						<a href="">
							<span class="glyphicon glyphicon-shopping-cart"></span>
							<span>购物车</span>

						</a>
					</div>

					<div class="search">
						<div class="hd-search">
							<input type="text" placeholder="请输入要搜索的内容" />
							<a href="" class="button"><span class="glyphicon glyphicon-search"></span>
							</a>
						</div>
						<ul>
							<li><a href="">饮料</a></li>
							<li><a href="">咖啡</a></li>
							<li><a href="">黄油</a></li>
							<li><a href="">湿巾</a></li>
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
				<a href="">聚优汇订单</a>
				<a href="">我的预约</a>
				<a href="">常购清单</a>
				</div>
				
				<div class="menber">
					<p>
						<span class="glyphicon glyphicon-star"></span> 会员资料
					</p>
					<a href="">个人资料</a>
					<a href="">地址管理</a>
				</div>
				
				<div class="judgement">
					<p>
						<span class="glyphicon glyphicon-comment"></span> 我的评论
					</p>
					<a href="">评论商品</a>
					
				</div>
				<div>
				<p>
						<span class="glyphicon glyphicon-heart"></span> 我的关注
					</p>
					<a href="">关注商品</a>
				
					
				</div>
				
				<div>
				<p>
						<span class="glyphicon glyphicon-grain"></span> 我的关注
					</p>
					<a href="">在线退换货</a>
				
					
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
						<img src="../img/bgctop.jpg"/></a>
						<div class="order-title">
							<p class="desc">商品描述</p>
							<div class="buy-btn">再次购买</div>
						</div>
					</div>
					<div class="order-btns">已完成</div>
					<div class="order-btns">订单详情</div>
				</div>
			</div>
			
					</div>
					
					
					<div class="order-pay">
						<div class="order-item-pay">
				
				<div class="order-header">
					<div class="order-left">
					<div class="time">2019-11-20</div>
					<div class="order-num">订单号：11111</div>
					<div class="receiver">收货人:eee</div>
					</div>
					
					
				<div class="order-right">
					<div class="price">总金额：￥34.90</div>
					<div class="state">待付款</div>
				<div class="name">聚优汇</div>
				
				</div>
					
				</div >
				
				<div class="order-list">
					<div class="order-pro">
						<a href="">
						<img src="../img/bgctop.jpg"/></a>
						<div class="order-title">
							<p class="desc">商品描述</p>
							<div class="buy-btn">再次购买</div>
						</div>
					</div>
					<div class="order-btns">立即支付</div>
					<div class="order-btns">订单详情</div>
				</div>
			</div>
					</div>
					
					
					<div class="order-receive">
						<div class="order-item-reveive">
				
				<div class="order-header">
					<div class="order-left">
					<div class="time">2019-11-20</div>
					<div class="order-num">订单号：11111</div>
					<div class="receiver">收货人:ddd</div>
					</div>
					
					
				<div class="order-right">
					<div class="price">总金额：￥34.90</div>
					<div class="state">待收货</div>
				<div class="name">聚优汇</div>
				
				</div>
					
				</div >
				
				<div class="order-list">
					<div class="order-pro">
						<a href="">
						<img src="../img/bgctop.jpg"/></a>
						<div class="order-title">
							<p class="desc">商品描述</p>
							<div class="buy-btn">再次购买</div>
						</div>
					</div>
					<div class="order-btns">确认收货</div>
					<div class="order-btns">订单详情</div>
				</div>
			</div>
					</div>
					
					
					<div class="order-fished">
						<div class="order-item-fished">
				
				<div class="order-header">
					<div class="order-left">
					<div class="time">2019-11-20</div>
					<div class="order-num">订单号：11111</div>
					<div class="receiver">收货人:bbb</div>
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
						<img src="../img/bgctop.jpg"/></a>
						<div class="order-title">
							<p class="desc">商品描述</p>
							<div class="buy-btn">再次购买</div>
						</div>
					</div>
					<div class="order-btns">已完成</div>
					<div class="order-btns">订单详情</div>
				</div>
			</div>
					</div>
					
					
					<div class="order-cancel">
						<div class="order-item-cancel">
				
				<div class="order-header">
					<div class="order-left">
					<div class="time">2019-11-20</div>
					<div class="order-num">订单号：11111</div>
					<div class="receiver">收货人:ccc</div>
					</div>
					
					
				<div class="order-right">
					<div class="price">总金额：￥34.90</div>
					<div class="state">已取消</div>
				<div class="name">聚优汇</div>
				
				</div>
					
				</div >
				
				<div class="order-list">
					<div class="order-pro">
						<a href="">
						<img src="../img/bgctop.jpg"/></a>
						<div class="order-title">
							<p class="desc">商品描述</p>
							<div class="buy-btn">再次购买</div>
						</div>
					</div>
					<div class="order-btns">已取消</div>
					<div class="order-btns">订单详情</div>
				</div>
			</div>
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
						<img src="../img/icon1.png" class="icons">
						<h3 class="content-1">正品保障</h3>
						<p class="sub-content">正品行货 放心选购</p>
					</div>
					<div class="icon">
						<img src="../img/icon2.png" class="icons">
						<h3 class="content-1">满99包邮</h3>
						<p class="sub-content">满99元 免运费</p>
					</div>
					<div class="icon">
						<img src="../img/icon3.png" class="icons">
						<h3 class="content-1">售后无忧</h3>
						<p class="sub-content">7天无理由退货</p>
					</div>
					<div class="icon">
						<img src="../img/icon4.png" class="icons">
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
<script src="../js/jquery.min.js"></script>
<script src="../js/order.js"></script>
