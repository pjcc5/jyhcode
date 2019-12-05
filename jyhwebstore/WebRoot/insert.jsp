<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    <title>后台管理</title>
    <link rel="stylesheet" type="text/css" href="/jyhwebstore/store/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="/jyhwebstore/store/css/main.css"/>
    <script type="text/javascript" src="/jyhwebstore/store/js/modernizr.min.js"></script>
  
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
  	<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="/jyhwebstore/admindex.jsp" class="navbar-brand">后台管理</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on" href="/jyhwebstore/admindex.jsp">首页</a></li>
                <li><a href="/jyhwebstore/index.jsp">网站首页</a></li>
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
                <li><a href="http://www.mycodes.net">管理员</a></li>
                <li><a href="http://www.mycodes.net">修改密码</a></li>
                <li><a href="http://www.mycodes.net">退出</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container clearfix">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>菜单</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <a href="#">商品管理</a>
                    <ul class="sub-menu">
                        <li id="comadm"><a href="/jyhwebstore/ComiAdmiServlet">商品管理</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#">用户管理</a>
                    <ul class="sub-menu">
                        <li><a href="system.jsp">违规管理</a></li>
                        <li><a href="system.jsp">发货管理</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><a href="/jyhwebstore/admindex.jsp">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="/jyhwebstore/ComiAdmiServlet">商品管理</a><span class="crumb-step">&gt;</span><span>新增商品</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
            </div>
        </div>
    </div>
</div>
  </body>
</html>
