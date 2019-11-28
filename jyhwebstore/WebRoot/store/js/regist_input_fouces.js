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



console.log(flagname);
console.log(flagnextpas);

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
	var reg = /^1[3456789]\d{9}$/g;
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
					$('#success').slideDown().children('#success-container').children('#success-container-success').slideDown(350).siblings().hide();
					$('#success').children('#success-btn').children('#success-btn-1').show().siblings().hide();
				}
				else if(json.flag==false)
				{
					$('#success').slideDown().children('#success-container').children('#success-container-exist').show().siblings().hide();
					$('#success').children('#success-btn').children('#success-btn-2').show().siblings().hide();
				}
				if(json.error==false)
				{
					$('#success').slideDown().children('#success-container').children('#success-container-error').show().siblings().hide();
					$('#success').children('#success-btn').children('#success-btn-4').show().siblings().hide();
				}
			}
		});
	}else
		{
		$('#success').slideDown().children('#success-container').children('#success-container-failed').show().siblings().hide();
		$('#success').children('#success-btn').children('#success-btn-3').show().siblings().hide();
		}
});

//用户名存在的情况
$('#success-btn-2').click(function() {
	$("#success").slideUp(350);
	$('input:eq(0)').focus();
})

//输入有误的时候
$('#success-btn-3').click(function() {
	$("#success").slideUp(350);
	location.href="regist.jsp?id=#";
})

//注册成功
$('#success-btn-1').click(function(){
	var userNames = $("#useinput").val();
	location.href="login.jsp?id="+userNames;
})
//未知错误
$("#success-btn-4").click(function(){
	location.href="regist.jsp?id="+new Date().getTime();
})
