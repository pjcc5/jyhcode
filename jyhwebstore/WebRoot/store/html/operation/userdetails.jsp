<%@page import="db.DbHelp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="shortcut icon" type="image/x-icon" href="/jyhwebstore/store/img/task.png" />
		<meta name="viewport" content="width=device-width,initial-scale=1"/>
		<link rel="stylesheet" type="text/css" href="/jyhwebstore/store/css/bootstrap.css"/>
		<link rel="stylesheet" type="text/css" href="/jyhwebstore/store/css/webstore.css"/>
		<title>用户详情页面</title>
	</head>
	<body style="background: url(/jyhwebstore/store/img/bgc.jpg);">
		<section class="top-lan" style="height: 40px;">
					<div class="row" style="height: 40px;">
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
							<div class="col-md-2	 text-left links ">
							<span id="current" style="color:black;font-weight:bold; font-size:16px;"></span>
							</div>
							<div class="col-md-6  links-right   text-right">
								<span id="goodnight">
									<c:if test="${empty time}">
										你好
									</c:if>
									<c:if test="${not empty time}">
										${time}
									</c:if>
								</span>
								<c:if test="${empty acount}">
								</c:if>
								<c:if test="${not empty acount}">
								<a href="/jyhwebstore/store/html/operation/information.jsp?path=index.jsp" id="log">
									${acount.aname }
									<a href="javascript:out()" id="out">退出</a>
								</a>
								</c:if>
								<span class="quit-father"></span>
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
		<!-- 用户显示的信息 -->
		<form  style="margin-top: 50px;margin-left:600px" id="form_userinform">
			<table align="center" style="font-size: 20px; line-height:90px;">
				<tr>
					<td style="font-size: 20px;">头像：</td>
					<td>
						<!-- <input id="input_picture" type="file" style="height: 30px;"/> -->
						<img style="height: 150px;width: 150px;" src="" id="uimg"/>
					</td>
				</tr>
				<tr>
					<td style="font-size: 20px;">昵称：</td>
					<td>
						<lable id="lable_nickname" type="text" style="height: 30px;width: 400px;"></label>
					</td>
				</tr>
				<tr>
					<td>出生年月日：</td>
					<td >
						<label id="lable_birth"></label>
					</td>
				</tr>
				<tr>
					<td>性别：</td>
					<td style="">
						<label id="lable_sex"></label>
					</td>
				</tr>
				<tr>
					<td>电话：</td>
					<td>
						<lable id="lable_phone" type="text" style="height: 30px;width: 400px;"></label>
					</td>
				</tr>
				<tr>
					<td>邮箱:</td>
					<td>
						<lable id="lable_mail" type="text" style="height: 30px;width: 400px;"></label>
					</td>
				</tr>
				<tr>
					<td>家庭住址：</td>
					<td>
						<lable id="lable_address" type="text" style="height: 30px;width: 400px;"></label>
					</td>
				</tr>
			</table>
			<input type="button" value="修改" id="button_modify" style="width: 70px;height: 40px;margin-left: 150px;"/>
		</form>
		<!--用户信息修改-->
		<form style="margin-top: 50px;margin-left:600px; display: none;" id="form_modify" name="reg_testdate">
			<table align="center" style="font-size: 20px; line-height:90px;">
				<tr>
					<td style="font-size: 20px;">头像：</td>
					<td>
						<img src="" width="150xp" height="150px" id="img" onclick="picselect()"/>
					</td>
					<input id="input_picture" type="file" style="height: 30px;display: none;" onchange="show(this)"/>
				</tr>
				<tr>
					<td style="font-size: 20px;">昵称：</td>
					<td>
						<input id="input_nickname" type="text" style="height: 30px;width: 400px;"/>
					</td>
				</tr>
				<tr>
					<td>出生年月日：</td>
					<td style="font-size: 20px;">
						<select id="birth_year" name="YYYY" onchange="YYYYDD(this.value)" style="height: 30px;width: 100px;font-size: 18px;">
						  <option value="" style="font-size: 18px;">请选择 年</option>
						</select>
						<select id="birth_month" name="MM" onchange="MMDD(this.value)" style="height: 30px;width: 100px;font-size: 18px;">
						  <option  value="" style="font-size: 18px;">选择 月</option>
						</select>
						<select id="birth_day" name="DD" style="height: 30px;width: 100px;font-size: 18px;">
						  <option  value="" style="font-size: 18px;">选择 日</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>性别：</td>
					<td>
						<input id="radio_man" type="radio" name="sex" value="男" />男
						<input id="radio_women" type="radio" name="sex" value="女" />女
					</td>
				</tr>
				<tr>
					<td>电话：</td>
					<td>
						<input id="input_phone" type="text" style="height: 30px;width: 400px;"/>
					</td>
				</tr>
				<tr>
					<td>邮箱:</td>
					<td>
						<input id="input_mail" type="text" style="height: 30px;width: 400px;"/>
					</td>
				</tr>
				<tr>
					<td>家庭住址：</td>
					<td>
						<input id="input_address" type="text" style="height: 30px;width: 400px;"/>
					</td>
				</tr>
			</table>
			<input type="button" value="保存" id="button_save" style="width: 70px;height: 40px;margin-left: 150px;"/>
		</form>
		<script src="/jyhwebstore/store/js/user_birth.js"></script>
		<script src="/jyhwebstore/store/js/jquery-3.4.1.js"></script>
		<script src="/jyhwebstore/store/js/webstore.js" type="text/javascript" charset="utf-8"></script>
		<script src="/jyhwebstore/store/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
	</body>
	<script>
	$("#button_modify").click(function(){
		$("#form_userinform").hide();
		$("#form_modify").show();
	})
	$("#button_save").click(function(){
		$("#form_userinform").show();
		$("#form_modify").hide();
		var nickname = $("#input_nickname").val();
		$("#lable_nickname").html(nickname);
		var telephone = $("#input_phone").val();
		$("#lable_phone").html(telephone);
		var usermail = $("#input_mail").val();
		$("#lable_mail").html(usermail);
		var homeaddress=$("#input_address").val();
		$("#lable_address").html(homeaddress);
		var sex = $("input:radio:checked").val();
		$("#lable_sex").html(sex);
		var user_birth = $("#birth_year").val()+"&nbsp年&nbsp"+$("#birth_month").val()+"月&nbsp"+$("#birth_day").val()+"&nbsp日";
		console.log(user_birth);
		$("#lable_birth").html(user_birth);
		
	})
	function show(obj){
		var fr =new  FileReader();
		var f = obj.files[0];
		fr.readAsDataURL(f);
		fr.onload=function(e){
		var content = e.target.result;
		//预览
		document.getElementById("img").src=content;
		}
	}
	function picselect(){
		document.getElementById("input_picture").click();
	}
</script>
	
</html>
