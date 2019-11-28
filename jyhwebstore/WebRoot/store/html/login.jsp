<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>聚优汇登录</title>
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" type="text/css" href="/jyhwebstore/store/css/bootstrap.css"/>
		<link rel="stylesheet" type="text/css" href="/jyhwebstore/store/miancss/base.css"/>
		<link rel="shortcut icon" type="image/x-icon" href="/jyhwebstore/store/img/task.png" />
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
	<body class="bodystyle" style="text-align: ;">
	<div id="show"" >
	登录成功
	</div>
		<nav class="nav navbar-default nva-height">
			<!-- 内容 -->
			<div class="container">
				<!-- logo头部-->
				<div class="navbar-header">
					<!-- logo图标 -->
					<a class="navbar-brand" href="/jyhwebstore/index.jsp">
						<img src="/jyhwebstore/store/img/Logo.jpg" class="nav-height-img">
					</a>
				</div>
				<a href="/jyhwebstore/store/html/login.jsp" class="navbar-btn navbar-right  btn-xs nav-height-a" >请登录</a>
				<p class="navbar-text hidden-sm hidden-xs navbar-right" >您好，欢迎光临聚优汇！</p>
			</div>
		</nav>
		<!-- login部分 -->
		<div class="login login-style">
			<div class="login-div" style="display: none;" id="logo">
				<img src="/jyhwebstore/store/img/bodyp.png" class="login-div-img">
			</div>
			<div class="login-div2">			
				<div class="login-div2-div1" id="login-div2-div1" style="display: none;">
					<label class="login-div2-div1-lable">聚优汇登录</label>
					<a href="regist.jsp" class="login-div2-div1-regist">注册新账号</a>
					<form id="myform">
					<input type="text" class="form-control" placeholder="用户名" id="loginUsername"
					name="uname"/>
					<input type="password" class="form-control" placeholder="密码" id="loginPassword" name="upass"/>
					<input type="checkbox" class="login-div2-div1-checkedbox"style="margin-top: 20px;" value="记住密码" />
					<p class="login-div2-div1-p">自动登录</p>
					<a href="#" class="login-div2-div1-a">忘记密码？</a>
					<input type="button" value="登录" class="btn btn-danger login-login" id="loginBtn" onclick="login()"/>
					</form>
				</div>
				<div id="div1" style="float: right;margin-top: 40px;margin-right: -110px; color: red;display: none;">
					请填写用户名
				</div>
				<div id="div2" style="float: right;margin-top: 110px;margin-right: -105px;color: red;display: none;">
					请填写密码
				</div>
			</div>
		</div>
	</body>
</html>

<script src="/jyhwebstore/store/js/jquery-3.4.1.min.js" type="text/javascript" charset="utf-8"></script>
<script src="/jyhwebstore/store/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
<script src="/jyhwebstore/store/js/login_jyh.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
 
 

	$("#loginUsername").focus(function(){
	$("#div1").html("请输入用户名");
		$("#div1").fadeIn();
	})
	$("#loginPassword").focus(function(){
	$("#div2").html("请输入密码");
		$("#div2").fadeIn();
	})
	
	
	$("#loginUsername").keyup(function(){
		var number = $("#loginUsername").val();
		if (number.length>=3) {
		if(number.indexOf(" ")==-1){
		$("#div1").html("用户名格式正确");
		}else{
		$("#div1").html("用户名不能有空格");
		}
		
		}else{
		    $("#div1").html("用户名应不小于3位");
		}
		
	})
	
	
	$("#loginPassword").keyup(function(){
		var number = $("#loginPassword").val();
		if (number.length>=6) {
		
			if(number.indexOf(" ")==-1){
		$("#div2").html("密码格式正确");
		}else{
		$("#div2").html("密码不能有空格");
		}
		} else{
			$("#div2").html("长度不能小于6位");
		}
		
		
	})
</script>
