$('#login-div2-div1').slideDown(1000);

$('#logo').fadeIn(2000);


function login(){

//	var frm = document.getElementById("myform");
//	frm.method="post";
//	frm.action="/jyhwebstore/store/html/login";
//	frm.submit();
	var uname= $('#loginUsername').val();
	var upass=$('#loginPassword').val();
	var acount={"uname":uname,"upass":upass};
	$.ajax({
		type:"post",
		url:"/jyhwebstore/store/html/login",
		data:{"msg":JSON.stringify(acount)},
		success:function(result){
		var re = JSON.parse(result);
		if(re!=null){
			alert("登录成功");
			location.href="/jyhwebstore/store/html/information.jsp";
		}else{
			alert("登录失败");
		}
		
		}
		
		
	})
	
}



//$("#loginBtn").click(function () {
//	var loginUsername = $('#loginUsername').val();
//	var loginPassword = $("#loginPassword").val();
//	(function() {
//		//发起请求
//		$.post('http://www.wjian.top/shop/api_user.php', {
//			status: 'login',
//			username: loginUsername,
//			password: loginPassword,
//		}, function(result) {
//			var obj = JSON.parse(result);
//			console.log(obj);
//			//验证
//			if (obj.code == 0) {
//				alert("登录成功！");
//				location.href=`index.html`;
//				var na = `${loginUsername}`;
//				localStorage.setItem('username',na);
//				
//				
//			}
//			else if (obj.code == 2003) {
//				alert("用户名不存在！");
//			}
//			else 
//			{
//				console.log(obj.message);
//				alert(obj.message);
//				return;
//			}
//	
//		});
//	})();
//});

//$(function(){
//	var username = getUrlVal('a');
//	var password =getUrlVal('b');
//	// alert(username);
//	$('#loginUsername').val(username);
//	$("#loginPassword").val(password);
//});
//
//function getUrlVal(property){
//  //地址栏
//  var urlStr = window.location.search.substring(1);
//  var re = new RegExp('(^|&)'+ property +'=([^&]*)(&|$)');
//  var result = urlStr.match(re);
//  if(result == null){return null};
//  return result[2];
//};
