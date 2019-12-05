<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>后台管理</title>
    <link rel="stylesheet" type="text/css" href="/jyhwebstore/store/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="/jyhwebstore/store/css/main.css"/>
    
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
                <li><a href="#">管理员</a></li>
                <li><a href="#">修改密码</a></li>
                <li><a href="#">退出</a></li>
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
                        <li id="user_illegal"><a href="/jyhwebstore/system.jsp">违规管理</a></li>
                        <li id="com_send"><a href="/jyhwebstore/system.jsp">发货管理</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><a href="/jyhwebstore/admindex.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">商品管理</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="#" method="post">
                    <table class="search-tab">
                        <tr>
                            <th width="70">搜索商品:</th>
                            <td><input class="common-text" placeholder="搜索商品" name="keywords" value="" id="" type="text"></td>
                            <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
            <form name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="insert.jsp">新增商品</a>
                        <a id="batchDel" href="javascript:void(0)">批量删除</a>
                        <a id="updateOrd" href="javascript:void(0)">更新排序</a>
                    </div>
					<div class="result-content">
					    <table class="result-tab" width="100%" style="text-align: center;">
							<thead>
								<tr>
									<th >编号</th>
									<th>商品ID</th>
									<th>商品名称</th>
									<th>商品价格</th>
									<th>商品颜色</th>
									<th>商品品牌</th>
									<th>商品尺寸</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="commo" varStatus="i">
									<tr>
										<td>${i.count}</td>
										<td>${commo.comid}</td>
										<td>${commo.comname}</td>
										<td>${commo.comprice}</td>
										<td>${commo.color}</td>
										<td>${commo.pai}</td>
										<td>${commo.size}</td>
										<td><button id="deletecom" onclick="deleteStudent('${commo.comid }')">删除</button>
										<button id="updatecom" onclick="updateStudent('${commo.comid }')">修改</button></td>
									</tr>
								</c:forEach>	
							</tbody>
					    </table>
					</div>
                </div>
            </form>
        </div>
					<center style="margin-top:20px">
						<a  style="margin-left:10px;"   href="/jyhwebstore/ComiAdmiServlet?pageNo=1&pageSize=${pageSize}">首页</a>
						<a  style="margin-left:40px;" href="/jyhwebstore/ComiAdmiServlet?pageNo=${pageNo-1}&pageSize=${pageSize }">上一页</a>
						<span style="margin-left:40px;">第${pageNo}页</span>
						<a  style="margin-left:40px;" href="/jyhwebstore/ComiAdmiServlet?pageNo=${pageNo+1}&pageSize=${pageSize }">下一页</a>
						<a  style="margin-left:40px;" href="/jyhwebstore/ComiAdmiServlet?pageNo=${maxPageNo}&pageSize=${pageSize }">尾页</a>
					</center>
    </div>
</div>
			
  </body>
</html>
<script src="/jyhwebstore/store/js/jquery-1.8.3.min.js" type="text/javascript" charset="utf-8"></script>
<script src="/jyhwebstore/store/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script type="/jyhwebstore/store/js/javascript" src="js/libs/modernizr.min.js"></script>
