<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'information.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link rel="stylesheet" type="text/css" href="/jyhwebstore/store/css/information.css">
     <link rel="stylesheet" type="text/css" href="/jyhwebstore/store/css/bootstrap.css">
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
			<div class="information">
				<div class="edit-top">
					<div class="edit-left">
				<div class="header-img">
					<label>头像:</label>
					<a href="">
					<img src="/jyhwebstore/store/img/succes.jpg"/></a>
				</div>
				
				<div class="edit-nickname">
					<label>昵称:</label>
					<div class="input">
					<input type="text"/>
					<span>昵称长度不能超过40个字符</span>
					</div>
				</div>
				
				<div class="edit-name">
					<label>真实姓名:</label>
					<input type="text"/>
				</div>
				
				<div class="edit-sex">
					<label>性别:</label>
					<input type="radio" value="0" name="sex"/>
					<span>男</span>
					<input type="radio" value="1" name="sex"/>
					<span>女</span>
				</div>
				
				</div>
				
				</div>
				
				<div class="edit-birth">
					<label>生日:</label>
					<select class="birthyear">
						<option value="2019">2019</option>
						<option value="2018">2018</option>
						<option value="2017">2017</option>
					</select>
					<span id="">年</span>
					<select class="birthmonth">
						<option value="12">12</option>
						<option value="11">11</option>
						<option value="10">10</option>
					</select>
					<span>月</span>
					<select class="birthday">
						<option value="30">30</option>
						<option value="29">29</option>
						<option value="28">28</option>
					</select>
					<span>日</span>
				</div>
				
				<div class="sumit">
					确认保存
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
  </body>
</html>
