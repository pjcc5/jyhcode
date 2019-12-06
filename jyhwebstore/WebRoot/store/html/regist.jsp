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
						<input type="text" class="form-control" maxlength="4"; placeholder="identifying code" id="valdation"/>
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
			<div id="regists_ok" style="width: 400px;height: 200px;background: url(../img/bg1.jpg);margin-top: -300px;margin-left: 590px;text-align: center; font-size: 20px;display: none;">
				<h3 style="margin-top: -200px;">恭喜您注册成功！</h3>
				<button type="button" id="register_ok_btn" value="确定" style="margin-top: 100px;color: black;">确定</button>
			</div>
			<div id="regists_exist" style="width: 400px;height: 200px;background: url(../img/bg1.jpg);margin-top: -300px;margin-left: 590px;text-align: center; font-size: 20px;display: none;">
				<h3 style="margin-top: -200px;">用户名或手机号已存在！</h3>
				<button type="button" id="regists_exist_btn" value="确定" style="margin-top: 100px;color: black;">确定</button>
			</div>
			<div id="regists_validation" style="width: 400px;height: 200px;background: url(../img/bg1.jpg);margin-top: -300px;margin-left: 590px;text-align: center; font-size: 20px;display: none;">
				<h3 style="margin-top: -200px;">验证码错误！</h3>
				<button type="button" id="regists_validation_btn" value="确定" style="margin-top: 100px;color: black;">确定</button>
			</div>
			<div id="regists_check" style="width: 400px;height: 200px;background: url(../img/bg1.jpg);margin-top: -300px;margin-left: 590px;text-align: center; font-size: 20px;display: none;">
				<h3 style="margin-top: -200px;">请检查您的输入是否都正确！</h3>
				<button type="button" id="regists_check_btn" value="确定" style="margin-top: 100px;color: black;">确定</button>
			</div>
			<div id="regists_system" style="width: 400px;height: 200px;background: url(../img/bg1.jpg);margin-top: -300px;margin-left: 590px;text-align: center; font-size: 20px;display: none;">
				<h3 style="margin-top: -200px;">系统错误！</h3>
				<button type="button" id="regists_system_btn" value="确定" style="margin-top: 100px;color: black;">确定</button>
			</div>
		</div>
	</body>
</html>
<script src="/jyhwebstore/store/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="/jyhwebstore/store/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
<script src="/jyhwebstore/store/js/webstore.js" type="text/javascript" charset="utf-8"></script>
<script src="/jyhwebstore/store/js/regist_input_fouces.js" type="text/javascript" charset="utf-8"></script>
<script>
</script>