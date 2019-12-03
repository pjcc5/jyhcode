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
			<table align="center" style="font-size: 20px; line-height:50px;">
				<tr>
					<td style="font-size: 20px;">头像：</td>
					<td>
						<!-- <input id="input_picture" type="file" style="height: 30px;"/> -->
						<img style="height: 150px;width: 150px;" src="${pic}" id="uimg"/>
						
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
			<table align="center" style="font-size: 20px; line-height:50px;">
				<tr>
					<td style="font-size: 20px;">头像：</td>
					<td>
						<img src="${pic}" width="150xp" height="150px" id="img" onclick="picselect()"/>
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
						  <option value="" style="font-size: 18px;">选择 月</option>
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
		<div style="background: #A6E1EC;width: 200px;height: 100px;text-align: center;display: none;font-size: 20px;margin-left: 700px;margin-top: -300px;line-height: 100px;" id="message">
			<span>修改成功！</span>
		</div>
		<script src="/jyhwebstore/store/js/user_birth.js"></script>
		<script src="/jyhwebstore/store/js/jquery-3.4.1.js"></script>
		<script src="/jyhwebstore/store/js/webstore.js" type="text/javascript" charset="utf-8"></script>
		<script src="/jyhwebstore/store/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
	</body>
	<script>
	//显示信息
	myajax();
	function myajax()
	{
		$.get({
			async:false,
			type:"post",
			url:"/jyhwebstore/ShowUserDetails",
			data:"",
			success:function(result){
				var jsons =JSON.parse(result);
				var picture = jsons.pic;
				var uname = jsons.uname;
				var birth = jsons.birth;
				var sex = jsons.sex;
				var phone = jsons.uphone;
				var mail = jsons.mail;
				var address = jsons.setadd;
				var userbirth = birth.split("-");
				$("#lable_nickname").html(uname);
				$("#lable_birth").html(birth);
				$("#lable_sex").html(sex);
				$("#lable_phone").html(phone);
				$("#lable_mail").html(mail);
				$("#lable_address").html(address);
				
				$("#button_modify").click(function(){
					//给单选框赋值
					if(sex!="nulls")
					{
						if(sex=="男")
						{
							$("input[type='radio']").eq(0).attr("checked",true);
						}
						else
						{
							$("input[type='radio']").eq(1).attr("checked",true);
						}
					}	
					//if(picture.substring(picture.length-3)=="nulls" || picture.substring(picture.length-3)!="jpg")
				//	{
						
				//	}
				//	else
				//	{
					//	$("#uimg").attr("src",""+picture);
					//	alert(picture);
					//}
					$("#input_nickname").val(uname);
					$("#input_phone").val(phone);
					$("#input_mail").val(mail);
					$("#input_address").val(address);
					$("#form_userinform").hide();
					$("#form_modify").show();
					//日期下拉框的js赋值==============================================
					var optionyear =document.createElement("option");
					$(optionyear).val(userbirth[0]);
					$(optionyear).text(userbirth[0]);
					$('#birth_year').append(optionyear);
					var optionmonth =document.createElement("option");
					$(optionmonth).val(userbirth[1]);
					$(optionmonth).text(userbirth[1]);
					$('#birth_month').append(optionmonth);
					var optionday =document.createElement("option");
					$(optionday).val(userbirth[2]);
					$(optionday).text(userbirth[2]);
					$('#birth_day').append(optionday);
					//===============================================================
				});
			}
		});
	}
	var content;
	function show(obj){
		var fr =new  FileReader();
		var f = obj.files[0];
		fr.readAsDataURL(f);
		fr.onload=function(e){
		content = e.target.result;
		//预览
		document.getElementById("img").src=content;
		}
	}
	function picselect(){
		document.getElementById("input_picture").click();
	}
	//保存信息
	$("#button_save").click(function(){
		if($("#input_nickname").val()==""||$("input:radio:checked").val()==""||$("#input_phone").val()==""||$("#input_mail").val()==""||$("#input_address").val()==""||$("#birth_year").val()==""||$("#birth_month").val()==""||$("#birth_day").val()=="")
			{
			$("#input_nickname").focus();
			alert("抱歉昵称/出生年月/性别/电话/邮箱/住址不能为空");
			}
		else
			{
				var nickname = $("#input_nickname").val();
				var userbirth = $("#birth_year").val()+"-"+$("#birth_month").val()+"-"+$("#birth_day").val();
				var usersex = $("input:radio:checked").val();
				var userphone = $("#input_phone").val();
				var usermail = $("#input_mail").val();
				var useradd = $("#input_address").val();
				var reg =/^1[3-5678]\d{9}$/;
				var mailreg = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/g;
				if(reg.test(userphone) && mailreg.test(usermail))
				{
					$.get({
						type:"post",
						url:"/jyhwebstore/uploadServlet",
						data:{"nickname":nickname,"userbirth":userbirth,"usersex":usersex,"userphone":userphone,"usermail":usermail,"useraddress":useradd,"picture":content},
						success:function(result){
							var jsons =JSON.parse(result);
							if(jsons.flag==true)
							{
								$("#message").fadeIn(1000);
								$("#message").fadeOut(1500);
								myajax();
								$("#form_modify").hide();
								$("#form_userinform").show();
							}	
							else
							{
								alert("手机号或用户名已存在！");
							}
						}
					});
				}
				else
				{
					if(reg.test(userphone)==false)
					{
						$("#input_phone").focus();
						alert("请检查您的手机号是否正确");
						//alert(userphone);
					}
					else if(!mailreg.test(usermail))
					{
						$("#input_mail").focus();
						alert("请检查您的邮箱是否正确");
					}	
				}
			}
	});
</script>
	
</html>
