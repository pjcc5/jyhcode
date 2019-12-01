<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'cart.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style>
	    
	</style>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="/jyhwebstore/store/css/bootstrap.css"/>
<link rel="stylesheet" href="/jyhwebstore/store/css/cart.css"/>
  </head>
  
  <body>
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
  	        
            <li class=""></span> <a href="login.html" class='login'><span class="glyphicon glyphicon-user"></span>登录</a></li>
            <li><a href="javascript:;" class="quit"><span class="quit-father"></span></a></li>
			<li><a href="regist.html">注册</a></li>
            <li><a href=""><span class="glyphicon glyphicon-list-alt"></span> 我的订单</a></li>
  	      	
  	      </ul>
            </div>     
		</div>

	</nav>
	<div class="main">
	<div class="content">
		<div class="cart-header" >
			<a href="">
			<img src="/jyhwebstore/store/img/Logo.png"/>
			<p>购物车</p></a>
			 <div class="input-group  sear " >
  	        <input type="text" class="form-control" placeholder="请输入关键词"/>
  	        
  	        <div class="input-group-btn">
  	          <button class=" btn btn-primary">
  	            <span class="glyphicon glyphicon-search"></span> 	                     
  	          </button>
  	          </div>
  	          
  	      
  	      </div> 
		</div>
		
		
		
	<div class="list-header">
			<ul >
				<li class="selectall"><input type="checkbox" class="select"/>全选</li>
				<li class="desc">商品信息</li>
				<li class="price">单价(元)</li>
				<li class="account">数量</li>
				<li class="">小计(元)</li>
				<li class="op">操作</li></ul>
		</div>
		
		</div>
		
		<div class="nav-pay ">
			<div class="pay">
			<div class="pays-left">
				<input type="checkbox" class="select"/>
				<span class=""> 全选</span>
				<span class="all">(共0件)</span>
				<span>|</span>
				<span class="del-all">批量删除</span>
			</div>
			
			<div class="pay-right">
				<span class="checked">已选商品0件</span>
				<span>预览</span>
				<span>|</span>
				<span>合计:￥</span>
				<span class="total">0.00</span>
				<div class="check-out">去结算<div>
			</div>
			</div>
		</div>
		</div>
		</div>
		</div>
		<!--<div class="a"></div>-->
		
		
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
<script src="/jyhwebstore/store/js/bootstrap.js"></script>
<script src="/jyhwebstore/store/js/cart.js"></script>
