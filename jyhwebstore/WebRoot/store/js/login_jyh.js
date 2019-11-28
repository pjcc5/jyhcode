$('#login-div2-div1').slideDown(1000);

$('#logo').fadeIn(2000);

function login(){
	var uname= $('#loginUsername').val();
	var upass=$('#loginPassword').val();
	var acount={"uname":uname,"upass":upass};
	var path;
	path=getUrlVal('path');
	console.log(path);
	if(path==null){
		path="/jyhwebstore/index.jsp";
	}
//	getUrlVal(1);
	if(uname==null||uname==""||uname.length<3||uname.indexOf(" ")!=-1){
		alert("账号输入格式错误");
		return;
	}else{
		if(upass==null||upass==""||upass.length<6||upass.indexOf(" ")!=-1)
			{
			alert("密码输入格式错误");
			return;
			}else{
				$.ajax({
					type:"post",
					url:"/jyhwebstore/store/html/login",
					data:{"msg":JSON.stringify(acount)},
					success:function(result){
					var re = JSON.parse(result);
					if(re!=null){
						var show=$("#show").html("登录成功").fadeIn(500);
						$("#show").fadeOut(2500);
						setTimeout(function(){
							location.href=path;
						}, 3000);
//						
					}else{
						alert("账号或密码不正确，请重新输入");
					}
					
					}
					
					
				})
			}
	}
	
	
	
	
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
function getUrlVal(property){
  //地址栏
  var urlStr = window.location.search.substring(1);
  var re = new RegExp('(^|&)'+ property +'=([^&]*)(&|$)');
  var result = urlStr.match(re);
  if(result == null){return null};
  return result[2];
};
