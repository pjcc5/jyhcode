<%@page import="db.DbHelp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
<head>
	<title>商品搜索:</title>
	<link rel="shortcut icon" type="image/x-icon" href="/jyhwebstore/store/img/task.png" />
	<meta name="viewport" content="width=device-width,initial-scale=1"/>
	<link rel="stylesheet" type="text/css" href="/jyhwebstore/store/css/bootstrap.css"/>
	<link rel="stylesheet" type="text/css" href="/jyhwebstore/store/css/webstore.css"/>
</head>
	<body>
		<!-- 顶部导航栏 -->
		<section class="top-lan">
			<div class="row">
				<div class="col-md-11 col-md-offset-1 col-sm-6 col-xs-12 links text-left">
					<div class="col-md-2" id="location">
						<span class="glyphicon glyphicon-map-marker posi"></span>
						<i class="icon iconfont"></i>
						<span>送货地址:</span>
						<em>长沙</em>
						</div>
					<div class="col-md-2  text-left links ">
						<span class="glyphicon glyphicon-volume-up posi"></span>
						<a href="">防范金融诈骗提示</a>
					</div>
					<!-- 显示时间 -->
					<div class="col-md-3	 text-left links ">
					<span id="current" style="color:black;font-weight:bold; font-size:16px;"></span>
					</div>
					
					
					<div class="col-md-5 links-right   text-right">
						<span id="goodnight">
							<c:if test="${empty time}">
								你好
							</c:if>
							<c:if test="${not empty time}">
								${time}
							</c:if>
							
						</span>

						
						<c:if test="${empty acount}">
						<a href="javascript:gologin(this)" id="log">
							登录
						</a>
						</c:if>
						<c:if test="${not empty acount}">
							<a href="/jyhwebstore/store/html/operation/information.jsp?path=index.jsp" id="log">
							${acount.aname }
							<a href="javascript:out()" id="out">退出</a>
						</a>
						</c:if>
						
						

						<span class="quit-father"></span>
						<i><a href="/jyhwebstore/store/html/regist.jsp">注册</a></i>
						
						
							<a href="">
								<span class="glyphicon glyphicon-user" ></span>
								会员俱乐部
							</a>
							
						
							<a href="/jyhwebstore/store/html/operation/order.jsp?path=index.jsp">
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
					<a href="/jyhwebstore/index.jsp"><img src="/jyhwebstore/store/img/Logo.png" class="logo-img"></a>
					<a><img src="/jyhwebstore/store/img/slogan.png" class="slogan" alt=""></a>
				</div>
				
				<div class="search-right">
					<input type="text" class="search-input" id="searchIn1" placeholder="搜索手机">
					<button type="button" class="search-btn" id="searchBtn1"><span class="glyphicon glyphicon-search"></span></button>
					<div>
						<a href="cart.html" class="cart"><span class="glyphicon glyphicon-shopping-cart"></span>购物车<span class="badge hidden">6</span></a>
						
					</div>
					<ul class="search-list">
						<li><a href="/jyhwebstore/store/html/search.jsp?content=Apple">Apple</a></li>
						<li><a href="/jyhwebstore/store/html/search.jsp?content=oppo">oppo</a></li>
						<li><a href="/jyhwebstore/store/html/search.jsp?content=vivo">vivo</a></li>
						<li><a href="/jyhwebstore/store/html/search.jsp?content=飞利浦">飞利浦</a></li>
						<li><a href="/jyhwebstore/store/html/search.jsp?content=三星">三星</a></li>
						<li><a href="/jyhwebstore/store/html/search.jsp?content=华为">华为</a></li>
						<li><a href="/jyhwebstore/store/html/search.jsp?content=诺基亚">诺基亚</a></li>
					</ul>
				</div>
				
			</header>
			<!-- 浮动导航栏 -->
			<div class="mynav">
				<div title="sss" class="logo">
					<a href=""><img src="/jyhwebstore/store/img/Logo.png" class="nav-logo-img"></a>
				</div>
				<div class="nav-search">
					<input type="text" class="search-input" id="searchIn2" placeholder="搜索手机">
					<button type="button" class="nav-search-btn" id="searchBtn2" ><span class="glyphicon glyphicon-search"></span></button>
					<a href="cart.html" class="cart nav-cart"><span class="glyphicon glyphicon-shopping-cart"></span>购物车<span class="badge hidden">6</span></a>
						
			</div>
		</section>
		
		
		<!-- 回到顶部 -->
		<div id="top">
					回到顶部
		</div>
		
		
		<!-- 首页手机 -->
		<section>
		
			<div class="goods-top">
				<!-- <div class="goods">
					<img src="img/Logo.png" alt="">
					<p>手机名</p>
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
					
					<div class="goods">
					<img src="${igd.compic}" alt="">
					<p class="goodsname">${igd.comname}</p>
					<p class="pai">${igd.pai}</p>
					<p class="comprice">${igd.comprice}</p>
					<p><span class="glyphicon  glyphicon-star"></span>${igd.detailsdot}</p>
					<a href='javascript:;' class="content_a" onclick="goproduct(this)">
						<div class="cover">
							<p class="goodsdecoration">${igd.comname}</p>
							<p class="price">只要${igd.comprice}元</p>
						</div>
					</a>
					<input type="hidden" value="`+comid+`" id="${igd.comid}" />
					<button type="button" class="btn btn-danger addincart"><span class="
							glyphicon glyphicon-download-alt"></span>　加入购物车</button>
					<button type="button" class="btn btn-danger addincart"><span class="
							glyphicon glyphicon-usd"></span>　立即购买</button>
							
						</div>
						
		</section>
		<div id="none" style="display:none;width:600px;heigth:300px;background:red;font-size:50px;font-weight:bold;position:fixed;top:15%;left:35%;">抱歉,没有找到任何结果!</div>
		<section>
			<div class="more" style="margin-left: 45%;">
			<button type="button" class="btn btn-primary first"  onclick="gofirstpage(this)" id="1">首页</button>
			<button type="button" class="btn btn-success prev"  onclick="prevpage(this)"><span class="glyphicon glyphicon-chevron-left"></span></button>
			<input type="number" max="100" min="1" value="1" id="pagenum"/>
			<button type="button" class="btn btn-success next"  onclick="nextpage(this)"><span class="glyphicon glyphicon-chevron-right"></span></button>
			<button type="button" class="btn btn-danger last"  onclick="golastpage(this)" id="">尾页</button>
			
			</div>
		</section>
		
		
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
									<li><a href="">手机验货与签收</a></li>
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
<script>
//获取地址栏信息
function getUrlVal(property){
	  //地址栏
	  var urlStr = window.location.search.substring(1);
	  var re = new RegExp('(^|&)'+ property +'=([^&]*)(&|$)');
	  var result = urlStr.match(re);
	  if(result == null){return null};
	  return result[2];
	};



	function searchgoods(page)
	{	
		
		$.get({
			type:"get",
			url:"/jyhwebstore/search",
			data:"page="+page+"&content="+getUrlVal("content"),
			success:function(result){
				getMaxpage();
				$(".goods-top").empty();
				var json = JSON.parse(result);
				if(json.length == 0)
				{
					$("#none").slideDown(500);
				}
					
				
				for(var i=0;i < json.length ;i++)
					{
					var compic =json[i].compic;
					var comname=json[i].comname;
					var pai =json[i].pai;
					var comprice =json[i].comprice;
					var detailsdot =json[i].detailsdot;
					var comid = json[i].comid;
					var str=`
							<div class="goods" onmouseover="bordershadow(this)" onmouseout="clearshadow(this)">
							<img src=\"`+compic+`
							" alt="">
							<p class="goodsname">`+comname+`</p>
							<p class="pai">`+pai+`
							</p>
							<p class="comprice">`+comprice+`</p>
							<p><span class="glyphicon  glyphicon-star"></span>`+detailsdot+`
							</p>
							<a href='javascript:;' class="content_a" onclick="goproduct(this)">
								<div class="cover">
									<p class="goodsdecoration">`+comname+`
									</p>
									<p class="price">只要`+comprice+`
									元</p>
								</div>
							</a>
							<input type="hidden" id="`+comid+`" value="comid" />
							<button type="button" class="btn btn-danger addincart" onclick="goproduct(this)"><span class="
									glyphicon glyphicon-download-alt" ></span>　加入购物车</button>
							<button type="button" class="btn btn-danger addincart" onclick="goproduct(this)"><span class="
									glyphicon glyphicon-usd"></span>　立即购买</button>
									
								</div>
							
					`;
					$(".goods-top").append(str);
					
					}
			},
		});
		
		
		
		
	}
	//获得最大页数
	function getMaxpage(){
		$.get({
			type:"get",
			url:"/jyhwebstore/getmax",
			data:"content="+getUrlVal("content"),
			success:function(result){
				//设置尾页id为最大页数
				$(".last").attr("id",result);
			}
		});
		
	}
	$(function(){
		searchgoods(1);
	})
	
	//首页函数
	function gofirstpage(obj){
		$("#pagenum").val(1);
		searchgoods(1);
	}
	
	//上一页函数
	function prevpage(obj){
		var page = $("#pagenum").val()-1;
		if(page <= 1)
		{
			page=1;
		}
		$("#pagenum").val(page);
		searchgoods(page);
	}
	//下一页函数
	function nextpage(obj){
		var page = parseInt($("#pagenum").val())+1;
		var maxpage = $(".last").attr("id");
		if(page >maxpage)
		{
			page = maxpage;
		}
		$("#pagenum").val(page);
		searchgoods(page);
	}
	//尾页函数
	function golastpage(obj){
		var lastpage = parseInt($(obj).attr("id"));
		$("#pagenum").val(lastpage);
		searchgoods(lastpage);
	}
	
	
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
//		      this.oflower.style.top = this.top+"px";
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
//		    		that.top += that.step;
		    		if(that.top > 1000 )  
		    			{
		    				that.die();
		    			}
		    		if(that.left > 1000)
		    			{
		    			that.die();
		    			}
//		           that.oflower.style.top = that.top + 'px';
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
