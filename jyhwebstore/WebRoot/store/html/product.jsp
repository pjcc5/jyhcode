<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'peroduct.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="css/product.css" />
		<link rel="stylesheet" href="css/bootstrap.min.css">
  </head>
  
  <body>
   <nav class="navbar navbar-default">
			<div class="container ">
				<div class="navbar-header">
					<a class="navbar-brand" href="index.html">
						<span class="glyphicon glyphicon-home "></span>
						聚优汇首页
					</a>

				</div>


				<div class=" navbar-right" id="myNav">
					<ul class="nav navbar-nav">

						<li class=""><a href="login.html?">登录</a></li>
						<li><a href="regist.html">注册</a></li>
						<li><a href="cart.html"><span class="glyphicon glyphicon-list-alt"></span> 我的订单</a></li>

					</ul>
				</div>
			</div>

		</nav>

		<section>
			<div class="header-bp">
				<div class="logo">
					<a href="index.html" class="hd-logo"><img src="img/Logo.png" /></a>
					<a href="index.html" class="hd-slogan"><img src="img/slogan.png" /></a>
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
		</section>



		<div class="mod">
			<ul>
				<li><a href="index.html">首页</a></li>
				<li><span class="glyphicon glyphicon-menu-right"></span></li>
				<li><a href="javascript:;">商品</a></li>
				<li><span class="glyphicon glyphicon-menu-right"></span></li>
				<li><a href="javascript:;">希菲</a></li>

			</ul>

		</div>

		<div class="detail">
			<div class="l">
				<div class="image">
					<!--<img src="images/portfolio-img1.jpg"/>-->
					<div class="slide"></div>
				</div>
				<div class="clearfix">
					<div class="pre"><a href="javascript:"><span class="glyphicon glyphicon-menu-left"></span></a></div>
					<div class="next"><a href="javascript:"><span class="glyphicon glyphicon-menu-right"></span></a></div>
					<ul>
						<li></li>
						<li></li>
						<li></li>
						<li></li>
						<li></li>
					</ul>
				</div>
			</div>

			<div class="detail-information">
				<div class="big"></div>
				<div class="goods">
					<div class="info">
						<!--<p class="name">希菲 原肉整切10片1300g牛排套餐 西冷眼肉 手工微腌 生鲜儿童牛肉</p>
			<p class="price"><span>价格</span><span class="price-m">￥129</span></p>
			<p class="desc"><span>描述</span><span class="desc-p">desc</span></p>
			<div class="hot"><span>热度</span><span class="hot-p"><span class="glyphicon glyphicon-heart"></span>100</span>-->

					</div>
				</div>
				<div class="send">
					<p>送货至</p>
					<p class="address"><span>上海</span>
						<span>|</span>
						<span>静安区</spam>
							<span>|</span>
							<span>城区</span>
							<span class="glyphicon glyphicon-menu-right"></span></p>
				</div>
				<div class="cart">
					<div class="amount">
						<input type="number" value="1" class="number" />
						<div class="add"><span class="glyphicon glyphicon-triangle-top"></span></div>
						<div class="reduce"><span class="glyphicon glyphicon-triangle-bottom"></span></div>
					</div>

					<a href="javascript:" class="cart-a">加入购物车</span></a>
				</div>

			</div>
		</div>
		
		
		<div class="more">
			<div class="floatle">
				<ul>
					<p>购买了此商品的用户还买了</p>
					<li>
						<img src="img/task.png" alt="">
						<p>商品名称</p>
						<p>商品价格</p>
						<button type="button">查看详情</button>
					</li>
					
					
				</ul>
			</div>
			<div class="center">
				<img src="img/c1.jpg" alt="">
				<img src="img/c2.jpg" alt="">
				<img src="img/c3.jpg" alt="">
				<img src="img/c4.jpg" alt="">
				<img src="img/c5.jpg" alt="">
				<img src="img/c6.jpg" alt="">
				<img src="img/c7.jpg" alt="">
				<img src="img/c8.jpg" alt="">
				<img src="img/c9.jpg" alt="">
			</div>
			
		</div>

<!-- 底部 -->
		<section>
			<div class="footer">
				<div class="footer-top">
					<div class="icon">
						<img src="img/icon1.png" class="icons">
						<h3 class="content">正品保障</h3>
						<p class="sub-content">正品行货 放心选购</p>
					</div>
					<div class="icon">
						<img src="img/icon2.png" class="icons">
						<h3 class="content">满99包邮</h3>
						<p class="sub-content">满99元 免运费</p>
					</div>
					<div class="icon">
						<img src="img/icon3.png" class="icons">
						<h3 class="content">售后无忧</h3>
						<p class="sub-content">7天无理由退货</p>
					</div>
					<div class="icon">
						<img src="img/icon4.png" class="icons">
						<h3 class="content">准时送达</h3>
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
					
					
					<div class="QR-codes">
						<p class="contact"><span class="glyphicon glyphicon-phone-alt"></span>联系我们</p>
						<img src="img/QR-code.png" alt="">
					</div>
				</div>
			</div>
		</section>
		<!-- 底部的申明信息 -->
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
   
  </body>
</html>

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/product.js"></script>