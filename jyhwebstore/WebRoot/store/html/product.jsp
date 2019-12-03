<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    
    <title>商品详情</title>
    <link rel="shortcut icon" type="image/x-icon" href="/jyhwebstore/store/img/task.png" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="/jyhwebstore/store/css/product.css" />
		<link rel="stylesheet" href="/jyhwebstore/store/css/bootstrap.min.css">
		
		<style>
		#show{
		width:200px;
		height: 84px;
		position: fixed;
		background:orange;
		text-align:center;
		line-height:84px;
		left: 50%;
		top: 50%;
		margin-left: -100px;
		margin-top: -42px;
		border-radius:8px;
		opacity:0.6;
		z-index:999;
		display: none;
		font-size: 20px;
		font-weight: bold;
		}
		</style>
  </head>
  
  <body>
  
  <div id="show">加入成功</div>
 <nav class="navbar navbar-default">
			<div class="container ">
				<div class="navbar-header">
					<a class="navbar-brand" href="/jyhwebstore/index.jsp">
						<span class="glyphicon glyphicon-home "></span>
						聚优汇首页
					</a>
					
				</div>


				<div class=" navbar-right" id="myNav">
					<ul class="nav navbar-nav">

							
						<li><a id="current"></a></li>
						
						<c:if test="${empty acount}">
							<li class=""><a href="javascript:gologin(this);" >登录</a></li>
						</c:if>
						<c:if test="${not empty acount}">
						<li>	<a href="/jyhwebstore/store/html/operation/information.jsp?path=index.jsp" id="log" style="color:red;">
								${acount.aname }
									
								</a>
								<li>	<a href="javascript:out()" id="out">退出</a></li>
						</li>
						</c:if>
						
						<li><a href="/jyhwebstore/store/html/regist.jsp">注册</a></li>
						<li><a href="/jyhwebstore/store/html/cart.jsp"><span class="glyphicon glyphicon-list-alt"></span> 我的订单</a></li>

					</ul>
				</div>
			</div>

		</nav>

		<section>
			<div class="header-bp">
				<div class="logo">
					<a href="/jyhwebstore/index.jsp" class="hd-logo"><img src="/jyhwebstore/store/img/Logo.png" /></a>
					<a href="/jyhwebstore/index.jsp" class="hd-slogan"><img src="/jyhwebstore/store/img/slogan.png" /></a>
				</div>

				<div class="header-right">

					<div class="cart-2" onclick="gocart(this)">
						
							<span class="glyphicon glyphicon-shopping-cart"></span>
							<span>购物车</span>

						
					</div>

					<div class="search">
						<div class="hd-search">
							<input type="text" placeholder="请输入要搜索的内容" id="searchIn1"/>
							<button href="javascript:;" class="button" id="searchBtn1"><span class="glyphicon glyphicon-search"></span>
							</button>
						</div>
						<ul>
						<li><a href="/jyhwebstore/store/html/search.jsp?content=Apple">Apple</a></li>
						<li><a href="/jyhwebstore/store/html/search.jsp?content=oppo">oppo</a></li>
						<li><a href="/jyhwebstore/store/html/search.jsp?content=vivo">vivo</a></li>
						<li><a href="/jyhwebstore/store/html/search.jsp?content=三星">三星</a></li>
						<li><a href="/jyhwebstore/store/html/search.jsp?content=华为">华为</a></li>
						</ul>
					</div>
				</div>

			</div>
		</section>



		<div class="mod">
			<ul>
				<li><a href="/jyhwebstore/index.jsp">首页</a></li>
				<li><span class="glyphicon glyphicon-menu-right"></span></li>
				<li><a href="javascript:;">手机</a></li>
				<li><span class="glyphicon glyphicon-menu-right"></span></li>
				<li><span class="goodsname"></span></li>
			</ul>

		</div>

		<div class="detail">
			<div class="l">
				<div class="image">
					<!--<img src="images/portfolio-img1.jpg"/>-->
					<div class="slide"></div>
				</div>
				<div class="clearfix">
				
					<ul>
						
					</ul>
				</div>
			</div>

			<div class="detail-information">
				<div class="big"></div>
				<div class="goods">
					<div class="info">
					<!--  	<p class="name">希菲 原肉整切10片1300g牛排套餐 西冷眼肉 手工微腌 生鲜儿童牛肉</p>
			<p class="price"><span>价格</span><span class="price-m">￥129</span></p>
			<p class="desc"><span>销量</span><span class="desc-p">desc</span></p>
			<div class="hot"><span>好评</span><span class="hot-p"><span class="glyphicon glyphicon-heart"></span>100</span>

					</div>-->
				</div>
				<div id="choose">
					<div id="choose-1">
						<div class="dt">选择颜色</div>
						
					</div>
					<div id="choose-2">
						<div class="dt">选择版本</div>
						
				
				</div>
				</div>
				</div>
				<div class="cart">
					<div class="amount">
						<input type="number" value="1" class="number" />
						<div class="add"><span class="glyphicon glyphicon-triangle-top"></span></div>
						<div class="reduce"><span class="glyphicon glyphicon-triangle-bottom"></span></div>
					</div>

					<a href="javascript:addcart()" class="cart-a join">加入购物车</span></a>
					<a href="javascrrpt:;" class="buy join">立即个购买<a/>
				</div>
				

			</div>
		</div>
		
		
		<div class="more">
			<div class="floatle">
				<ul>
					<p>购买了此商品的用户还买了</p>
					
					
					
				</ul>
			</div>
			<div class="center">
				
			</div>
			
		</div>

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

<script src="/jyhwebstore/store/js/jquery-3.4.1.js"></script>
<script src="/jyhwebstore/store/js/bootstrap.min.js"></script>
<script src="/jyhwebstore/store/js/jquery-transform_2d.js"></script>
<script src="/jyhwebstore/store/js/webstore.js"></script>
<script src="/jyhwebstore/store/js/product.js"></script>
<script>
var arr=new Array();
arr[0]="/jyhwebstore/store/img/雪花1.png";
arr[1]="/jyhwebstore/store/img/雪花2.png";
arr[2]="/jyhwebstore/store/img/雪花3.png";
arr[3]="/jyhwebstore/store/img/雪花4.png";
$(function(){
setInterval(function(){
	  new SnowFlower();
	}, 400);
})
function SnowFlower(){
	
	this.oflower=null;
	this.windowH = document.documentElement.clientHeight;
	this.windowW = document.documentElement.clientWidth;
	this.top = -100;
	this.left=parseInt(Math.random() * (this.windowW-500));
	this.timer =null;
	this.step=10;
	this.init = function(){
	      //创建元素添加到页面
	      this.oflower = document.createElement('img');
	     
	      this.oflower.className = 'flower';
	      //设置左右随机位置
	     this.oflower.style.position="fixed";
	      this.oflower.style.left = this.left + 'px';
//	      this.oflower.style.top = this.top+"px";
	     this.oflower.style.top = this.top+"px";
	    this.oflower.style.width = 70+"px";
	   this.oflower.style.height = 70+"px";
	     this.oflower.src = arr[Math.floor(Math.random()*4)];
	     $(this.oflower).animate({top:this.windowH+'px',left:this.left+this.windowH+"px"},10000);
	     var that = this;
	    $(this.oflower).mouseenter(function(){
	    	
	    	setTimeout(function(){
	    		that.die();
	    	},100);
	    });
	      //添加到页面
	      document.body.appendChild(this.oflower);
	    };
	    
	    this.go = function(){
	    	var that = this;
	    	
	    	this.timer = setInterval(function(){
	    		$(that).animate({top:that.windowH+'px',left:this.left+that.windowH+"px"},10000);
//	    		that.top += that.step;
	    		if(that.top > 1000 )  
	    			{
	    				that.die();
	    			}
	    		if(that.left > 1000)
	    			{
	    			that.die();
	    			}
//	           that.oflower.style.top = that.top + 'px';
	    	},600)
	    }
	    
	    this.die = function(){
	    	clearInterval(this.timer);
	    	document.body.removeChild(this.oflower);
	    }
	   //调用初始化方法
	    this.init();
	    //调用行走方法
	    this.go();
}
</script>

