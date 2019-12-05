// 动画效果
$("#jyh_regist").slideDown(2000);
// $("#useinput").slideDown(1000);

$('.regist').slideDown(2000);

// 输入框聚焦
var flagname = false;
var flagph = false;
// var flagyzm=false;
var flagpas = false;
var flagnextpas = false;
// 用户名
$('input:eq(0)').focus(function() {
	$('span:eq(0)').fadeIn(250);
	$('.regist-li-div1 div:eq(0)').slideDown(300);
	$('.regist-li-div1 div:eq(1)').hide();
	$('.regist-li-div1 div:eq(2)').hide();
	$('#imgdiv1').hide();
});
// 手机号
$('input:eq(1)').focus(function() {
	$('span:eq(1)').fadeIn(250);
	$('.regist-li-div2 div:eq(0)').slideDown(100);
	$('.regist-li-div2 div:eq(1)').hide();
	$('#imgdiv2').hide();
});
// 验证码
$('input:eq(2)').focus(function() {
	$('span:eq(2)').fadeIn();

});

// 密码
$('input:eq(3)').focus(function() {
	$('span:eq(3)').fadeIn();
	$('.regist-li-div3 div:eq(0)').slideDown();
	$('.regist-li-div3 div:eq(1)').hide();
	$('.regist-li-div3 div:eq(2)').hide();
	$('#imgdiv3').hide();
});

// 确认密码
$('input:eq(4)').focus(function() {
	$('span:eq(4)').fadeIn();
	$('.regist-li-div4 div:eq(0)').slideDown();
	$('.regist-li-div4 div:eq(1)').hide();
	$('#imgdiv4').hide();
});

// 输入框失去焦点
// 用户名
$('input:eq(0)').blur(function() {
	$('span:eq(0)').fadeOut(200);
	$('.regist-li-div1 div:eq(0)').slideUp(200);
	var number = $('input:eq(0)').val();
	var reg = /^[a-zA-Z0-9_-]{3,16}$/;
	if (reg.test(number)) {
		flagname = true;
	} else {
		if (number.length == 0) {
			$('.regist-li-div1 div:eq(1)').hide();
			$('.regist-li-div1 div:eq(2)').slideDown(200);
		} else {
			$('.regist-li-div1 div:eq(1)').slideDown(200);
		}

		if (number.length < 3) {
			flagname = false;
		}
	}

	if (flagname == true) {
		$('#imgdiv1').fadeIn();
	}
});
// 手机号
$('input:eq(1)').blur(function() {
	var number = $('input:eq(1)').val();
	var reg = /^1[3-5678]\d{9}$/;
	if (reg.test(number)) {
		flagph = true;
	} else {
		if (number.length < 11) {
			flagph = false;
		}
		$('.regist-li-div2 div:eq(1)').show(200);
	}

	if (flagph == true) {
		$('#imgdiv2').fadeIn();
	}

	$('span:eq(1)').fadeOut(200);
	$('.regist-li-div2 div:eq(0)').slideUp(200);
});


function flush(obj) {
	obj.src = "/jyhwebstore/image?id="+new Date().getTime();
};


// 验证码
$('input:eq(2)').blur(function() {
	$('span:eq(2)').fadeOut();
});
// 密码
$('input:eq(3)').blur(function() {
	$('span:eq(3)').fadeOut();
	$('.regist-li-div3 div:eq(0)').slideUp();
	var number = $('input:eq(3)').val();

	var reg = /(?!.*\s)(?!^[\u4e00-\u9fa5]+$)(?!^[0-9]+$)(?!^[A-z]+$)(?!^[^A-z0-9]+$)^.{6,20}$/;
	if (reg.test(number)) {
		$('.regist-li-div3 div:eq(1)').hide(200);
		flagpas = true;
	} else {
		if (number.length < 6) {
			$('.regist-li-div3 div:eq(1)').slideDown(200);
			$('#imgdiv3').hide();
			flagpas = false;
		}
		if (number.length == 0) {
			$('.regist-li-div3 div:eq(1)').hide();
			$('.regist-li-div3 div:eq(2)').slideDown(200);
			flagpas = false;
		} else {
			$('.regist-li-div3 div:eq(1)').slideDown(200);
		}

	}
	var nextpass = $('input:eq(4)').val();
	if (nextpass != number) {
		$('.regist-li-div4 div:eq(1)').slideDown(200);
		flagnextpas = false;
		$('#imgdiv3').hide();
		$('#imgdiv4').hide();
	}
	if (nextpass == number && nextpass!=0 && number!=0) {
		$('.regist-li-div4 div:eq(1)').hide();
		flagnextpas = true;
		$('#imgdiv4').fadeIn();
	}

	if (flagpas == true) {
		$('#imgdiv3').fadeIn();
	}
});
// 确认密码
$('input:eq(4)').blur(function() {
	$('span:eq(4)').fadeOut();
	$('.regist-li-div4 div:eq(0)').slideUp();
	var number = $("input:eq(4)").val();
	var fistpassword = $("input:eq(3)").val();

	// 判断第二次输入密码的同时判断第一次输入密码
	if (fistpassword.length == 0) {
		$('.regist-li-div3 div:eq(1)').hide();
		$('.regist-li-div3 div:eq(2)').slideDown(200);
	}
	//判断两次密码是否相同
	if (number != fistpassword && number.length != 0) {
		$('.regist-li-div4 div:eq(0)').hide();
		$('.regist-li-div4 div:eq(1)').slideDown(200);
		flagnextpas = false;

		$('#imgdiv4').hide();
	}
	if (number.length == 0) {
		$('.regist-li-div4 div:eq(0)').slideDown(200);
		$('#imgdiv4').hide();
		flagnextpas = false;
	}
	if (number == fistpassword && number.length != 0) {
		$('.regist-li-div4 div:eq(0)').hide();
		flagnextpas = true;
	}

	if (flagpas == true && flagnextpas == true) {
		$('#imgdiv4').fadeIn();
	}

});

// 按钮禁用和启动
$("#regists").attr("disabled", "false");

$('.regist-YHXY').click(function() {
	
//	alert($("#check").Boolean);
	if ($("#check").prop('checked') == true) {
		$("#regists").removeAttr("disabled");
	} else {
		$("#regists").attr("disabled", "false");
	}
});

// 验证正则表达式
$('#regists').click(function() {
	if (flagname && flagph && flagpas && flagnextpas) {
		var userName = $("#useinput").val();
		var userPassword = $('#password').val();
		var phone = $('#phone').val();
		var vald = $("#valdation").val();
		console.log(userName+":"+userPassword+":"+phone);
		//发起请求
		$.get({
			type:"post",
			url:"/jyhwebstore/Register",
			data:{"rname":userName,"rpass":userPassword,"rphone":phone,"valdation":vald},
			success:function(result){
				var json = JSON.parse(result);
				if(json.flag==true)
				{
					//alert("恭喜您注册成功！");
					$("#regists_ok").slideDown(1000);
					$("#regists").attr("disabled", "false");
				}
				if(json.flag==false)
				{
					alert("抱歉用户名或手机号存在！");
					//$("#regists_exist").slideDown(1000);
				}
				if(json.error==false)
				{
					//alert("系统错误");
					$("#regists_system").slideDown(1000);
				}
				if(json.valde==false)
				{
					///alert("验证码错误");
					$("#regists_validation").slideDown(500);
				}
			}
		});
	}else
		{
			alert("请检查输入");
			//$("#regists_check").slideDown(1000);
		}
});


$("#register_ok_btn").click(function(){
	alert("我正在去验证页面");
	window.location.href="/jyhwebstore/store/html/success/registersuccess.jsp?success";
});

//验证码
$("#regists_validation_btn").click(function(){
	$("#regists_validation").slideUp(1000);
});
//系统错误则刷新界面
$("#regists_system_btn").click(function(){
	var	path = location.pathname;
 	location.href = "/jyhwebstore/store/html/regist.jsp?id="+path;
});


//去登录页面
function gologin(obj){
	var	path = location.pathname;
 	location.href = "/jyhwebstore/store/html/login.jsp?path="+path;
}
//点击Enter键直接注册(同意协议的情况下)
$('body').keydown(function(event){
	if(event.keyCode ==13)
	{	
		if($("#check").prop("checked")){
			$("#regists").click();
		}
	}
   });
