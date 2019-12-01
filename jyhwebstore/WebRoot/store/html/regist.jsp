<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<link rel="shortcut icon" type="image/x-icon" href="/jyhwebstore/store/img/task.png" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" type="text/css" href="/jyhwebstore/store/css/bootstrap.css" />
		<link rel="stylesheet" type="text/css" href="/jyhwebstore/store/miancss/base.css" />
		<link rel="stylesheet" type="text/css" href="/jyhwebstore/store/css/regist_jyh.css" />
		
		<title>聚优汇注册</title>
	</head> 
	<script type="text/javascript">
	 function flush(obj) {
			obj.src = "/jyhwebstore/image?id="+new Date().getTime();
		}
	</script>
	<body class="bodystyle" style="background: url(/jyhwebstore/store/img/bgc.jpg);">
		<nav class="nav navbar-default nva-height" style="opacity: 0.7;">
			<!-- 内容 -->
			<div class="container">
				<!-- logo头部-->
				<div class="navbar-header">
					<!-- logo图标 -->
					<a class="navbar-brand" href="/jyhwebstore/index.jsp">
						<img src="/jyhwebstore/store/img/Logo.jpg" class="nav-height-img">
					</a>
				</div>
				<c:if test="${empty acount}">
						<a href="javascript:gologin(this)" class="navbar-btn navbar-right  btn-xs nav-height-a" id="log">
							登录
						</a>
						</c:if>
						<c:if test="${not empty acount}">
							<a href="javascript:out()"  class="navbar-btn navbar-right  btn-xs nav-height-a" id="out">退出</a>
							<a href="/jyhwebstore/store/html/operation/information.jsp?path=index.jsp" class="navbar-btn navbar-right  btn-xs nav-height-a"  id="log">
								${acount.aname}
							</a>
						</c:if>
						
						
				<p id="current" style="line-height:80px;font-size:20px; display:inline-block; margin-left: 30%"></p>
				<p class="navbar-text hidden-sm hidden-xs navbar-right">您好，欢迎光临聚优汇！</p>
			</div>
		</nav>
		<div class="">
			<div class="">
				<h4 class="gegist-tittle" id="jyh_regist" style="display: none;">聚优汇注册</h4>
			</div>
			<div class="">
				<ul class="regist" style="display: none;">
					<li>
						<!-- 用户输入用户名 -->
						<div class="regist-li-div1">
							<span>用户名</span>
							<input type="text" class="form-control" maxlength="20" placeholder="UserName" id="useinput" name="rname"/>
							<div class="">
								3-20字符，可由英文、数字或者符号来组成
							</div>
							<div id="">
								请输入正确的用户名，用户名应为3-20位字符
							</div>
							<div id="">
								您输入的用户名不能为空，请设置您的用户名
							</div>
						</div>
						<div class="" style="display: none;" id="imgdiv1">
							<img src="/jyhwebstore/store/img/right.png" style=" width: 25px;height: 25px; float: right; margin-right: 500px; margin-top: -50px;">
						</div>
					</li>
					<!-- 手机号 -->
					<li>
						<div class="regist-li-div2">
							<span>手机号</span>
							<input type="text" id="phone" maxlength="11" class="form-control" placeholder="Cell-phone number" name="rphone"/>
							<div class="">
								请填写正确的手机号码，以便接收订单通知，找回密码等
							</div>
							<div id="yz_phone">
								您输入的手机号有误或已被注册，请输入正确的手机号！
							</div>
						</div>
						<div class="" style="display: none;" id="imgdiv2">
							<img src="/jyhwebstore/store/img/right.png" style="width: 25px;height: 25px; float: right; margin-right: 500px; margin-top: -50px;">
						</div>
					</li>
					<!-- 验证码 -->
					<lable style=" font-weight:bold; font-size: 10px;color: red;line-height: 1px;float: right;margin-right: 430px; margin-top:30px">看不清点击图片换一张</lable>
					<li class="regist-YZM">
						<span>验证码</span>
						<input type="text" class="form-control" placeholder="identifying code" id="valdation"/>
					<img src="/jyhwebstore/image" style="float: right;margin-right: 550px; width: 130px;height: 43px; margin-top: -60px;" onclick="flush(this)">
					</li>
					<!-- 密码 -->
					<li>
						<div class="regist-li-div3">
							<span>密码</span>
							<input type="password" maxlength="20" class="form-control" placeholder="Password" id="password" name="rpass"/>
							<div>
								密码应为6-20个字符,不包含空格符号<br>必须包含数字,字母或字符至少两种
							</div>
							<div>
								密码应为6-20位，不包含空格符号<br>必须包含数字,字母或字符至少两种
							</div>
							<div id="">
								您输入的密码不能为空,请设置您的密码
							</div>
						</div>
						<div class="" style="display: none;" id="imgdiv3">
							<img src="/jyhwebstore/store/img/right.png" style="width: 25px;height: 25px; float: right; margin-right: 500px; margin-top: -50px;">
						</div>
					</li>
					<!-- 二次密码 -->
					<li>
						<div class="regist-li-div4">
							<span>确认密码</span>
							<input type="password" maxlength="20" class="form-control" placeholder="Confirm password" />
							<div class="">
								请再次确认密码
							</div>
							<div id="">
								两次密码不相同
							</div>
						</div>
						<div class="" style="display: none;" id="imgdiv4">
							<img src="/jyhwebstore/store/img/right.png" style="width: 25px;height: 25px; float: right; margin-right: 500px; margin-top: -50px;">
						</div>
					</li>
					<!-- 用户协议 -->
					<li class="regist-YHXY">
						<input type="checkbox" id="check" class="form-control" placeholder="用户协议" />
						<span>请同意聚优汇<a href=" #">《服务协议及隐私声明》</a></span>
					</li>
					<!-- 注册 -->
					<li>
						<input type="button" id="regists" value="注册" class=" regist-btn btn btn-danger"/>
					</li>
				</ul>
			</div>
		</div>
		<div class="successes" id="success" >
			<div id="success-container" class="success-container" >
				<span id="success-container-success" style="margin-left: -40px;">
					恭喜老板注册成功！请点击确定，跳转登录界面
				</span>
				<span id="success-container-exist" style="float: left; margin-left: -50px;margin-top: 20px;background: url(/jyhwebstore/store/img/bg1.jpg);">抱歉，手机号或者用户名已被占用！</span>
				<span id="success-container-failed" style="float: left; margin-left: -55px;">老板您注册失败了哟！请检查您的输入是否正确！</span>
				<span id="success-container-error" style="float: left; margin-left: -55px;">系统未知错误！</span>
			</div>
			<div id="success-btn" class="success-btn">
				<button id="success-btn-1" type="button" style="color: blue; margin-bottom: -50px;"> 确定</button>
				<button id="success-btn-2" type="button" style="color: red;margin-bottom: -80px;">确定</button>
				<button type="button" id="success-btn-3" style="margin-bottom: -80px;" >确定</button>
				<button type="button" id="success-btn-4" style="margin-bottom: -80px;" >确定</button>
			</div>
		</div>
	</body>
</html>
<script src="/jyhwebstore/store/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="/jyhwebstore/store/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
<script src="/jyhwebstore/store/js/webstore.js" type="text/javascript" charset="utf-8"></script>
<script src="/jyhwebstore/store/js/regist_input_fouces.js" type="text/javascript" charset="utf-8"></script>
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
//		      this.oflower.style.top = this.top+"px";
		     this.oflower.style.top = this.top+"px";
		    this.oflower.style.width = 70+"px";
		   this.oflower.style.height = 70+"px";
		     this.oflower.src = arr[Math.floor(Math.random()*4)];
		     $(this.oflower).animate({top:this.windowH+'px',left:this.left+this.windowH+"px"},5000);
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
		    		$(that).animate({top:that.windowH+'px',left:that.windowW+"px"},5000);
//		    		that.top += that.step;
		    		if(that.top >= 1000 )  
		    			{
		    				that.die();
		    			}
		    		if(that.left >= that.windowW-100)
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