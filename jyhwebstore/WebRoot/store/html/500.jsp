<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%response.setStatus(HttpServletResponse.SC_OK);%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

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
			location.href="/jyhwebstore/index.jsp?";
		}
	},1000);
	});
  </script>
  <body style="background:#eeeeee;">
  <center>
  <div style="margin-top: 50px">
  		<h1 style="color: white;">页面错误，<span id="time">五</span>秒之后回主页</h1>
  		<h3 style="color: white;"></h3>
 		</div>
     	<img alt="" src="/jyhwebstore/store/img/500.png" style="margin-top: 100px;border:#d8765d;with:60%;height:60%">
  </center>
  </body>
</html>
