<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>聚优汇登录</title>
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" type="text/css" href="../css/bootstrap.css"/>
		<link rel="stylesheet" type="text/css" href="../miancss/base.css"/>
		<link rel="shortcut icon" type="image/x-icon" href="../img/task.png" />
	</head>
	<body class="bodystyle" style="text-align: ;">
		<nav class="nav navbar-default nva-height">
			<!-- 内容 -->
			<div class="container">
				<!-- logo头部-->
				<div class="navbar-header">
					<!-- logo图标 -->
					<a class="navbar-brand" href="">
						<img src="../img/Logo.jpg" class="nav-height-img">
					</a>
				</div>
				<a href="login.jsp" class="navbar-btn navbar-right  btn-xs nav-height-a" >请登录</a>
				<p class="navbar-text hidden-sm hidden-xs navbar-right" >您好，欢迎光临聚优汇！</p>
			</div>
		</nav>
		<!-- login部分 -->
		<div class="login login-style">
			<div class="login-div" style="display: none;" id="logo">
				<img src="../img/bodyp.png" class="login-div-img">
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
<script src="../js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
<script src="../js/jquery-3.4.1.min.js" type="text/javascript" charset="utf-8"></script>
<script src="../js/login_jyh.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	$("#loginUsername").focus(function(){
		$("#div1").fadeIn();
	})
	$("#loginPassword").focus(function(){
		$("#div2").fadeIn();
	})
	$("#loginUsername").blur(function(){
		var number = $("#loginUsername").val();
		if (number.length>3) {
			$("#div1").fadeOut();
		}
	})
	$("#loginPassword").blur(function(){
		var number = $("#loginPassword").val();
		if (number.length>6) {
			$("#div2").fadeOut();
		} else{
			
		}
	})
	
	
	
	

	
</script>