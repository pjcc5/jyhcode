<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'registersuccess.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="/jyhwebstore/store/js/jquery-3.4.1.js"></script>
  </head>
  <script type="text/javascript">
  	var errortime=0;
  	var aaa =new Array();
  	aaa[0]="五";
  	aaa[1]="四";
  	aaa[2]="三";
  	aaa[3]="二";
  	aaa[4]="一";
  	function getUrlVal(property){
  	  var urlStr = window.location.search.substring(1);
  	  var re = new RegExp('(^|&)'+ property +'=([^&]*)(&|$)');
  	  var result = urlStr.match(re);
  	  if(result == null){return null};
  	  return result[2];
  	};
  	$(function() {
  	var timer = setInterval(function() {
  		$("#time").html(aaa[++errortime]);
  		if (errortime==4) {
			clearInterval(timer);
			var uname = getUrlVal('id');
			location.href="/jyhwebstore/index.jsp?";
		}
	},1000);
		
	});
  </script>
  <body>
	<div style="margin-top: 200px">
  	<center>
  		<h1 style="color: red;">注册成功!正在检查网络安全环境！<span id="time">五</span></h1>
  		<h3 style="color: red;"></h3>
  	</center>
 	</div>
  </body>
</html>
