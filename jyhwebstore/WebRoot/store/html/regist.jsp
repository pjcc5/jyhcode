<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
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
					<a class="navbar-brand" href="">
						<img src="/jyhwebstore/store/img/Logo.jpg" class="nav-height-img">
					</a>
				</div>
				<a href="login.jsp" class="navbar-btn navbar-right  btn-xs nav-height-a">请登录</a>
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
				<span id="success-container-exist" style="float: left; margin-left: -50px;margin-top: 20px;background: url(/jyhwebstore/store/img/bg1.jpg);">抱歉，手机号已经被注册！</span>
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
<script src="/jyhwebstore/store/js/regist_input_fouces.js" type="text/javascript" charset="utf-8"></script>
