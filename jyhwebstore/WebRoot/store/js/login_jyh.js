$('#login-div2-div1').slideDown(1000);

$('#logo').fadeIn(2000);

function login(){
	if()
	var frm = document.getElementById("myform");
	frm.method="post";
	frm.action="/jyhwebstore/store/html/login";
	frm.submit();
}

//$("#loginBtn").click(function () {
//	var loginUsername = $('#loginUsername').val();
//	var loginPassword = $("#loginPassword").val();
//	location.href="login?uname="+loginUsername+"&upass="+loginPassword;
//	$("#myform").method="post";
//	$("#myform").action="login";
//	console.log($("#myform").action);
//	$("#myform").submit();
//});

//$(function(){
//	var username = getUrlVal('a');
//	var password =getUrlVal('b');
//	// alert(username);
//	$('#loginUsername').val(username);
//	$("#loginPassword").val(password);
//	
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
