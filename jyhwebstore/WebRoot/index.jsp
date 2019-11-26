<%@page import="db.DbHelp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
	<link rel="shortcut icon" type="image/x-icon" href="/jyhwebstore/store/img/task.png" />
	<meta name="viewport" content="width=device-width,initial-scale=1"/>
	<link rel="stylesheet" type="text/css" href="/jyhwebstore/store/css/bootstrap.css"/>
	<link rel="stylesheet" type="text/css" href="/jyhwebstore/store/css/webstore.css"/>
</head>
	<body>
		<!-- 顶部导航栏 -->
		<section class="top-lan">
			<div class="row">
				<div class="col-md-10 col-md-offset-1 col-sm-6 col-xs-12 links text-left">
					<div class="col-md-2">
						<span class="glyphicon glyphicon-map-marker posi"></span>
						<i class="icon iconfont"></i>
						<span>送货地址:</span>
						<em>长沙</em>
						</div>
					
					<div class="col-md-3  text-left links ">
						<span class="glyphicon glyphicon-volume-up posi"></span>
						<a href="">防范金融诈骗提示</a>
					</div>
					
					<div class="col-md-5 col-md-offset-2 links-right   text-right">
						<span id="goodnight">晚上好,请</span>
						<a href="/jyhwebstore/store/html/login.jsp" id="log">登录</a>
						<span class="quit-father"></span>
						<i><a href="regist.html">注册</a></i>
						
						
							<a href="">
								<span class="glyphicon glyphicon-user" ></span>
								会员俱乐部
							</a>
							
						
							<a href="">
								<span class="glyphicon glyphicon-list-alt"></span>
								我的订单
							</a>
							
					</div>
					
					
				</div>
				
				
			</div>
		</section>
	
		
		<!-- 含有搜索框的头部框 -->
		<section>
			<header>
				<div class="logo">
					<a href=""><img src="/jyhwebstore/store/img/Logo.png" class="logo-img"></a>
					<a><img src="/jyhwebstore/store/img/slogan.png" class="slogan" alt=""></a>
				</div>
				
				<div class="search-right">
					<input type="text" class="search-input" id="searchIn1" placeholder="搜索商品">
					<button type="button" class="search-btn" id="searchBtn1"><span class="glyphicon glyphicon-search"></span></button>
					<div>
						<a href="cart.html" class="cart"><span class="glyphicon glyphicon-shopping-cart"></span>购物车<span class="badge hidden">6</span></a>
						
					</div>
					<ul class="search-list">
						<li><a href="">桂格燕麦片</a></li>
						<li><a href="">农夫山泉</a></li>
						<li><a href="">电饭煲</a></li>
						<li><a href="">咖啡</a></li>
						<li><a href="">白糖</a></li>
						<li><a href="">大米5kg</a></li>
						<li><a href="">牛奶整箱</a></li>
					</ul>
				</div>
				<!-- 顶部导航栏 -->
				<div class="nav">
					<div class="all-items">
						<span class="all-item-icon"><span class="glyphicon glyphicon-list" ></span></span>
						全部类目
						<span class="hover-forward"><span class="glyphicon glyphicon-chevron-down"></span></span>
						
						<div class="floatitem"></div>
						<div class="allclassify">sss</div>
					</div>
					<ul class="nav-list">
						
						<!-- <li><a href="">金币签到</a></li>
						<li><a href="">充值</a></li>
						 <li><a href="">领券中心</a></li> -->
					</ul>
					
				</div>
				
			</header>
			<!-- 浮动导航栏 -->
			<div class="mynav">
				<div title="sss" class="logo">
					<a href=""><img src="/jyhwebstore/store/img/Logo.png" class="nav-logo-img"></a>
				</div>
				<div class="nav-search">
					<input type="text" class="search-input" id="searchIn2" placeholder="搜索商品">
					<button type="button" class="nav-search-btn" id="searchBtn2" ><span class="glyphicon glyphicon-search"></span></button>
					<a href="cart.html" class="cart nav-cart"><span class="glyphicon glyphicon-shopping-cart"></span>购物车<span class="badge hidden">6</span></a>
						
			</div>
		</section>
		<!-- 轮播图 -->
		<section>
			<div class="banner">
				    
				    <ul>
				      <li>
				        <a href="#">
				          <img src="/jyhwebstore/store/img/fish.jpg"/>
				        </a>
				      </li>
				      <li>
			          <a href="#">
			            <img src="/jyhwebstore/store/img/pets.jpg"/>
			          </a>
			        </li>
			        <li>
			          <a href="#">
			            <img src="/jyhwebstore/store/img/oil.jpg"/>
			          </a>
			        </li>
			        <li>
			          <a href="#">
			            <img src="/jyhwebstore/store/img/rabish.jpg"/>
			          </a>
			        </li>
				    </ul>
				    <div class="number">
				      <span class="current">蒲烧鳗鱼</span>
				      <span>萌宠大作战</span>
				      <span>粮油品类接</span>
				      <span>垃圾分类</span>
				    </div>
				  </div>

		</section>
		
		<!-- 回到顶部 -->
		<div id="top">
					回到顶部
		</div>
		
		
		<!-- 首页商品 -->
		<section>
			<div class="goods-top">
				<!-- <div class="goods">
					<img src="img/Logo.png" alt="">
					<p>商品名</p>
					<p>描述</p>
					<p>价格</p>
					<p>点赞数</p>
					<button type="button" class="btn btn-danger">加入购物车</button>
				</div>
				<div class="goods">
					<img src="img/Logo.png" alt="">
				</div>
				<div class="goods">
					<img src="img/Logo.png" alt="">
				</div>
				<div class="goods">
					<img src="img/Logo.png" alt="">
				</div> -->
		<c:forEach items="${goods}" var="good" >
					<div class="goods">
					<img src="${good.detailsdrawing}" alt="">
					<p class="goodsname">${json.data[i].goods_name}</p>
					<p>${json.data[i].goods_desc}</p>
					<p>${json.data[i].price}</p>
					<p><span class="glyphicon  glyphicon-star"></span>${json.data[i].star_number}</p>
					<a href='product.html?goods_id=${json.data[i].goods_id}' class="content_a">
						<div class="cover">
							<p class="goodsdecoration">${json.data[i].goods_desc}</p>
							<p class="price">只要${json.data[i].price}元</p>
						</div>
					</a>
					<button type="button" class="btn btn-danger addincart"><span class="
							glyphicon glyphicon-download-alt"></span>　加入购物车</button>
						</div>
					
		</c:forEach>
				
			
		</section>
		<section>
			<div class="more">
				<button type="button" class="btn btn-success loadmore">加载更多...</button>
			</div>
		</section>
		
		
		<!-- <section>
			<div class="insert">ss</div>
		</section> -->
		<!-- 底部 -->
		<section>
			<div class="footer">
				<div class="footer-top">
					<div class="icon">
						<img src="/jyhwebstore/store/img/icon1.png" class="icons">
						<h3 class="content">正品保障</h3>
						<p class="sub-content">正品行货 放心选购</p>
					</div>
					<div class="icon">
						<img src="/jyhwebstore/store/img/icon2.png" class="icons">
						<h3 class="content">满99包邮</h3>
						<p class="sub-content">满99元 免运费</p>
					</div>
					<div class="icon">
						<img src="/jyhwebstore/store/img/icon3.png" class="icons">
						<h3 class="content">售后无忧</h3>
						<p class="sub-content">7天无理由退货</p>
					</div>
					<div class="icon">
						<img src="/jyhwebstore/store/img/icon4.png" class="icons">
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
						<img src="/jyhwebstore/store/img/QR-code.png" alt="">
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
<script src="/jyhwebstore/store/js/jquery.min.js"></script>
<script src="/jyhwebstore/store/js/bootstrap.js"></script>
<script src="/jyhwebstore/store/js/jquery.singlePageNav.min.js"></script>
<script src="/jyhwebstore/store/js/webstore.js"></script>
