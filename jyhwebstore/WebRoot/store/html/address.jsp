<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'address.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="/jyhwebstore/store/css/bootstrap.css"/>
<link rel="stylesheet" href="/jyhwebstore/store/css/address.css"/>
  </head>
  
  <body>
        <div class="top_bar">
			<div class="clearfix">
				<div class="left">
				<a href="">
				<span class="glyphicon glyphicon-home"></span>
				聚优汇首页</a>
				
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
					<a href="index.html" class="hd-logo"><img src="/jyhwebstore/store/img/Logo.png" /></a>
					
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
			  <div class="address">
			  	<div class="addr-header">
			  		<p class="tit">地址管理</p>
			  		<div class="addr-btn add">+ 添加新地址</div>
			  		<div class="mod-address">
			  			<ul class="addr-bar">
			  				
			  			
			  			</ul>
			  			<div class="addr-btn add-bottom">+ 添加新地址</div>
			  		</div>
			  	</div>
			  </div>
			</div>
			
			<div class="mod">
				<div class="fill-addr">
					<h3>编辑地址</h3>
					
					<div class="user">
					<label>收件人:　</label>
					<input type="text" placeholder="请输入收货人"/>
					</div>
					
					<div class="three-addr">
						<label>收货地址:　</label>
						 <!--省份选择-->
            <select id="prov" onchange="showCity(this)">
                <option>请选择省份</option>
 
            </select>
 
            <!--城市选择-->
            <select id="city" onchange="showCountry(this)">
                <option>请选择城市</option>
            </select>
 
            <!--县区选择-->
            <select id="country" onchange="selecCountry(this)">
                <option>请选择县区</option>
            </select>
						
						
					</div>
					<div class="detail-addr">
						<label>详细地址:　</label>
						<input type="text" placeholder="请输入详细地址"/>
					</div>
					
					<div class="addr-call" onmouseenter="">
						<label>手机号码:　</label>
						<input type="text" placeholder="请输入手机号"/>
						<span>手机号码格式不正确</span>
					</div>
					
					<div class="fill-opera">
					<button class="save" disabled="true">保存</button>
					<button class="cancel">取消</button>
					</div>
				</div>
			</div>
			
			</div>
  </body>
</html>
<script src="/jyhwebstore/store/js/jquery-1.8.3.min.js"></script>
<script src="/jyhwebstore/store/js/city.js"></script>
<script src="/jyhwebstore/store/js/method.js"></script>
<script src="/jyhwebstore/store/js/address.js"></script>