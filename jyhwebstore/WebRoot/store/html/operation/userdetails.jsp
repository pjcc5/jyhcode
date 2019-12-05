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
		 <link rel="stylesheet" type="text/css" href="/jyhwebstore/store/css/information.css">
    <link rel="stylesheet" type="text/css" href="/jyhwebstore/store/css/bootstrap.css">
		<title>用户详情页面</title>
	</head>
	<body style="background: url(/jyhwebstore/store/img/bgc.jpg);">
	<div id="loading" style=" display: none; position: fixed;opacity: 0.6;background: white; text-align: center;width: 100%;height: 100%;z-index: 10000;">
		<div style="font-size: 20px; margin-top: 320px;color: #000000;">正在加载中</div>
	</div>
	<div class="top_bar">
			<div class="clearfix">
					<div class="left">
						<a href="/jyhwebstore/index.jsp">
							<span class="glyphicon glyphicon-home"></span>
							聚优汇首页
						</a>
					</div>
					<span id="current" style="display:inline-block;margin:0 auto;"></span>
					<div class="right">
							<a href="/jyhwebstore/store/html/operation/order.jsp">
								<span class="glyphicon glyphicon-list-alt"></span>
								我的订单
							</a>
							<c:if test="${empty acount}">
								<a href="/jyhwebstore/store/html/login.jsp?path=index.jsp" id="log">
									登录
								</a>
							</c:if>
							<c:if test="${not empty acount}">
								<a href="javascript:out()" id="out">退出</a>
									<a href="/jyhwebstore/store/html/operation/information.jsp?path=index.jsp" id="log">
										${acount.aname }
									</a>
							</c:if>
					</div>
				</div>
		</div>
		<div class="header">
				<div class="header-bp">
					<div class="logo">
						<a href="/jyhwebstore/index.jsp" class="hd-logo"><img src="/jyhwebstore/store/img/Logo.png" /></a>
					</div>
					<div class="header-right">
						<div class="cart-2">
							<a href="/jyhwebstore/store/html/operation/cart.jsp">
								<span class="glyphicon glyphicon-shopping-cart"></span>
								<span>购物车</span>
							</a>
						</div>
						<div class="search">
							<div class="hd-search">
								<input type="text" placeholder="请输入要搜索的内容" class="search-input"/>
								<a href="javascript:;" class="button" onclick="gosearch(this)">
									<span class="glyphicon glyphicon-search"></span>
								</a>
							</div>
							<ul>
								<li><a href="/jyhwebstore/store/html/search.jsp?content=Apple">Apple</a></li>
								<li><a href="/jyhwebstore/store/html/search.jsp?content=oppo">oppo</a></li>
								<li><a href="/jyhwebstore/store/html/search.jsp?content=vivo">vivo</a></li>
								<li><a href="/jyhwebstore/store/html/search.jsp?content=飞利浦">飞利浦</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		<!-- 用户显示的信息 -->
		<div class="body-clearfix">
				<div class="side-nav">
						<div class="side-nav-order">
							<p>
								<span class="glyphicon glyphicon-list-alt"></span>  我的交易
							</p>
							<a href="/jyhwebstore/store/html/operation/order.jsp">聚优汇订单</a>
						</div>
						<div class="menber">
							<p>
								<span class="glyphicon glyphicon-star"></span> 会员资料
							</p>
							<a href="/jyhwebstore/store/html/operation/information.jsp" class="active">个人资料</a>
							<a href="/jyhwebstore/store/html/operation/address.jsp">地址管理</a>
						</div>
				</div>
		</div>
		<form  style="margin-top: -580px;margin-left:600px;color:black;" id="form_userinform">
			<table align="center" style="font-size: 20px;  line-height:60px;">
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
						<label id="lable_birth" style="height: 60px;width: 104px;color:black;"></label>
					</td>
				</tr>
				<tr>
					<td>性别：</td>
					<td style="">
						<label id="lable_sex" style="height: 54px;max-width: 25px;color:black;"></label>
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
			<input type="button" class=" regist-btn btn btn-danger" value="修改" id="button_modify" style="width: 70px;height: 40px;margin-left: 150px;"/>
		</form>
		<!--用户信息修改-->
		<form style="margin-top: -580px;margin-left:600px; display: none;" id="form_modify" name="reg_testdate">
			<table align="center" style="font-size: 20px; line-height:60px;">
				<tr>
					<td style="font-size: 20px;">头像：</td>
					<td>
						<img src="" width="150xp" height="150px" id="img" onclick="picselect()" />
					</td>
					<input id="input_picture" type="file" style="height: 30px;display: none;" onchange="show(this)" onchange="verificationPicFile(this)"/>
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
			<input type="button" class=" regist-btn btn btn-danger" value="保存" id="button_save" style="width: 70px;height: 40px;margin-left: 150px;"/>
		</form>
		<div style="background: #A6E1EC;width: 200px;height: 100px;text-align: center;display: none;font-size: 20px;margin-left: 700px;margin-top: -300px;line-height: 100px;" id="message">
			<span>修改成功！</span>
		</div>
		<div style="background: #A6E1EC;width: 300px;height: 100px;text-align: center;display: none;font-size: 18px;margin-left: 700px;margin-top: -300px;line-height: 100px;" id="limitpicmax">
			<span>图片大小不能超过1MB！</span>
		</div>
		<div style="background: #A6E1EC;width: 300px;height: 100px;text-align: center;display: none;font-size: 18px;margin-left: 700px;margin-top: -300px;line-height: 100px;" id="limitpicmin">
			<span>图片大小不能小于0MB！</span>
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
		<script src="/jyhwebstore/store/js/user_birth.js"></script>
		<script src="/jyhwebstore/store/js/jquery-3.4.1.js"></script>
		<script src="/jyhwebstore/store/js/webstore.js" type="text/javascript" charset="utf-8"></script>
		<script src="/jyhwebstore/store/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
	</body>
	<script>
	myajax();
	function myajax()
	{
		$.get({
			async:true,
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
				$("#uimg").attr('src',picture);
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
					$("#uimg").attr('src',picture);
					$("#img").attr('src',picture);
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
		var filemin = 0;
		var filemax = 1024;
		var filesize = f.size/1024;
		//预览
		document.getElementById("img").src=content;
		if(filesize>filemax)
		{
			$("#limitpicmax").fadeIn(1000);
			$("#limitpicmax").fadeOut(2000);
			//alert("文件大小不能超过1MB");
			$("#button_save").attr("disabled","disabled");
			return false;
		}
		else if(filesize<filemin)
		{
			$("#limitpicmin").fadeIn(1000);
			$("#limitpicmin").fadeOut(2000);
			//alert("文件大小不能小于0MB");
			$("#button_save").attr("disabled","disabled");
			return false;
		}
		if(filemin<=filesize && filesize<=filemax)
		{
			$("#button_save").removeAttr("disabled");			
		}
		};
	}
	function picselect(){
		document.getElementById("input_picture").click();
	}
	//保存信息
	$("#button_save").click(function(){
		$("#loading").show();
		//alert($("input:radio:checked").val());
		if($("#input_nickname").val()==""||($("input:radio:checked").val()!="男" && $("input:radio:checked").val()!="女" )||$("#input_phone").val()==""||($("#input_mail").val()=="nulls" || $("#input_mail").val()=="")||($("#input_address").val()=="nulls" || $("#input_address").val()=="")||$("#birth_year").val()==""||$("#birth_month").val()==""||$("#birth_day").val()=="")
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
								$("#loading").hide();
								$("#message").show();
								$("#message").fadeOut(2000);
								myajax();
								$("#form_modify").hide();
								$("#form_userinform").show();
								location.reload();
							}	
							else
							{
								if(jsons.error==false)
								{
									alert("手机号或用户名已存在！");
									
								}
								else
								{
									alert("系统错误！");
									location.href = "/jyhwebstore/store/html/login.jsp?id=systemerror";
								}
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
