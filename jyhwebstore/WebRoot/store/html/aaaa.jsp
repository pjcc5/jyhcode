<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'aaaa.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
    <script type="text/javascript">
  function flush(obj) {
	obj.src = "image?id="+new Date().getTime();
}
  </script>
  <body>
		<center>
	   
			<div style="margin-bottom: 50px;margin-left: 70px">
				<h1>欢迎光临！</h1>
			</div>
	   		<label style="font-size: 20px;">账&nbsp;&nbsp;号：</label>
	   		<input type="text" name="loginName" style="width: 200px;height: 30px;font-size: 18px"/>
	   		<br/>
	   		<label style="font-size: 20px;">密&nbsp;&nbsp;码：</label>
	  	 	<input type="password" name="loginPass" style="margin-top: 20px;width: 200px;height: 30px;font-size: 20px"/>
	  	 	<br/>
	  	 	<label style="font-size: 20px; margin-left: 130px">验&nbsp;&nbsp;证：</label>
	  	 	<input type="text" name="validationg" style=" margin-left:0px; margin-top: 20px;width: 200px;height: 30px;font-size: 20px"/>
	  	 	<img src="image" style="margin-left: 30px" onclick="flush(this)">
	  	 	<br/>
	  	 	<input type="submit" value="登录" style="width: 100px;margin-top: 20px;margin-left: 50px;height: 40px;font-size: 20px"/>
	  </center>
  </body>
</html>
