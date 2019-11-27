$('#login-div2-div1').slideDown(1000);

$('#logo').fadeIn(2000);

<<<<<<< HEAD
function login(){
	if()
	var frm = document.getElementById("myform");
	frm.method="post";
	frm.action="/jyhwebstore/store/html/login";
	frm.submit();
}
=======
>>>>>>> branch 'master' of https://github.com/pjcc5/jyhcode.git










$("#loginBtn").click(function () {
	var loginUsername = $('#loginUsername').val();
	var loginPassword = $("#loginPassword").val();
	(function() {
		//发起请求
		$.post('http://www.wjian.top/shop/api_user.php', {
			status: 'login',
			username: loginUsername,
			password: loginPassword,
		}, function(result) {
			var obj = JSON.parse(result);
			console.log(obj);
			//验证
			if (obj.code == 0) {
				alert("登录成功！");
				location.href=`index.html`;
				var na = `${loginUsername}`;
				localStorage.setItem('username',na);
				
				
			}
			else if (obj.code == 2003) {
				alert("用户名不存在！");
			}
			else 
			{
				console.log(obj.message);
				alert(obj.message);
				return;
			}
	
		});
	})();
});

$(function(){
	var username = getUrlVal('a');
	var password =getUrlVal('b');
	// alert(username);
	$('#loginUsername').val(username);
	$("#loginPassword").val(password);
});

function getUrlVal(property){
  //地址栏
  var urlStr = window.location.search.substring(1);
  var re = new RegExp('(^|&)'+ property +'=([^&]*)(&|$)');
  var result = urlStr.match(re);
  if(result == null){return null};
  return result[2];
};
