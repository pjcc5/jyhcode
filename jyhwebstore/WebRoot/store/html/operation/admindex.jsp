<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    
    <title>后台管理</title>
    <link rel="shortcut icon" type="image/x-icon" href="/jyhwebstore/store/img/task.png" />
    <link rel="stylesheet" type="text/css" href="/jyhwebstore/store/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="/jyhwebstore/store/css/main.css"/>
    <script type="text/javascript" src="/jyhwebstore/store/js/modernizr.min.js"></script>
  </head>
  
  <body>
  	<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="/jyhwebstore/store/html/operation/index.jsp" class="navbar-brand">后台管理</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on" href="/jyhwebstore/store/html/operation/admindex.jsp">首页</a></li>
                <li><a href="/jyhwebstore/index.jsp">网站首页</a></li>
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
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
            <div class="crumb-list"><span>欢迎使用聚优汇后台管理系统。</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>快捷操作</h1>
            </div>
            <div class="result-content">
                <div class="short-wrap">
                    <a href="insert.jsp">上架商品</a>
                    <a href="#">违规管理</a>
                    <a href="#">发货管理</a>
                </div>
            </div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>系统基本信息</h1>
            </div>
            <div class="result-content">
                <ul class="sys-info-list">
                    <li>
                        <label class="res-lab">操作系统</label><span class="res-info">windows10</span>
                    </li>
                    <li>
                        <label class="res-lab">运行环境</label><span class="res-info">tomact8.0</span>
                    </li>
                    <li>
                        <label class="res-lab">聚优汇设计-版本</label><span class="res-info">v-0.1</span>
                    </li>
                    <li>
                        <label class="res-lab">上传附件限制</label><span class="res-info">1M</span>
                    </li>
                    <li>
                        <label class="res-lab">北京时间</label><span class="res-info">2019年12月5日</span>
                    </li>
                    <li>
                        <label class="res-lab">服务器域名/IP</label><span class="res-info">localhost [ 127.0.0.1 ]</span>
                    </li>
                    <li>
                        <label class="res-lab">Host</label><span class="res-info">127.0.0.1</span>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
  </body>
</html>

