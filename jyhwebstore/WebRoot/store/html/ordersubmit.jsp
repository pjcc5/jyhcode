<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'submitorder.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="/jyhwebstore/store/css/ordersubmit.css"/>
  </head>
  
  <body>
    <div class="order_header">
			<h1>
				<a class="logo" href="/jyhwebstore/index.jsp"></a>
				<a class="logo_txt" href="javascript:;"></a>
			</h1>
		</div>
		
		<div id="content">
			<div class="same_module_rel">
				<div class="mod_rel_head">
					<span class="mr_tit">收货信息</span>
					<a class="mr_ctrlbtn" href="javascript:;" onclick="add(this)">新建地址</a>
				</div>
				
				
				<div class="consign_rel_cont">
				<ul id="consignee_list">
					<!--  <li class="consign-itme item-selected" onclick="defaultAddr(this)">
						<div class="total_info">
							<i class="sprite_odr  adr_icon"></i>
							
							<span>
								<a href="javascript:;" class="edit-consignee" onclick="edit(this)">编辑</a>
								<a href="javascript:;"
class="del-consignee" style="display: none;" onclick="removeAddr(this)">删除</a>
							</span>
						</div>
						<div class="detail_info">
							<p>
								<span>谭</span>
								<span>18890573466</span>
							</p>
							<p><span prov="5">湖南 </span>
								<span city="1">长沙</span>
								<span country="1">岳麓区</span>
							</p>
							<p>麓谷街道 长丰五期</p>
						</div>
						<div class="sprite_odr is-choose"></div>
						
					</li>
					-->
				</ul>
			</div>
			</div>
			
			<div class="same_module_rel">
				<div class="mod_rel_head">
				<span class="mr_tit">支付方式</span>
				<span class="odr_tips">
					您的订单中包含不支持货到付款商品，请选择在线支付。
					<i class="sprite_odr"></i>
				</span>
				</div>
				<div class="paymethd">
					<a class="payment-item item-selected" href="javascript:;">
						在线支付
						<i class="sprite_odr"></i>
					</a>
				</div>
			</div>
			
			
			<div class="same_module_rel">
				<div class=" mod_rel_head">
					<span class="mr_tit">配送清单</span>
					<a href="" class="mr_ctrlbtn">返回购物车修改</a>
				</div>
				
				<div class="good-list">
					<div class="box">
						<div class="dib_tit">聚优汇</div>
						<div class="dib_con">
							<ul>
								<li class="des">
									<img src="/jyhwebstore/store/img/bgctop.jpg"/>
									<p>name</p>
								</li>
								<li class="exist">有货</li>
								<li class="count">×1</li>
								<li class="price">￥19.90</li>
							</ul>
						</div>
					</div>
					
					<div class="add_remak">
						<p class="rmk_tit">添加备注</p>
						<div class="rmk_con">
							<input class="fl" maxlength="45" id="remarkText" onkeyup="" placeholder="限45个字（定制类商品，请将购买需求在备注中做详细说明）" type="text">
							<span class="fl">提示：请勿填写有关支付、收货、发票方面的信息</span>
						</div>
					</div>
				</div>
			</div>
			
			
			<div class="same_module_rel">
				<div class="mod_rel_head">
					<span class="mr_tit">发票信息</span>
				</div>
				
				<div class="invoce_rel_cont">
					<p>
						<span>商品明细（电子普通发票）- 个人</span>
						<i id="invoiceEdit" onclick="" class="sprite_odr"></i>
					</p>
				</div>
			</div>
			
			<div class="pay_tools_inner">
				<div class="pay_tli_adr">
					
						<p class="adr_name_tel">
							<span class="pat_name">sad</span>
							<span class="pta_name">18890573466</span>
						</p>
						<p class="adr_detail">
							<i class="sprite_odr"></i>
							<span class="area_Name">湖南 长沙市 岳麓区 麓谷街道长丰 五期</span>
						</p>
					
				</div>

				
				<a class="pay_btn_smbit" href="javascript:;" onclick="">提交订单</a>
				
				<div class="pay_tli_count">
					<p class="ptc_tips">需支付</p>
					<p id="payPrice" class="ptc_count"><em>¥</em><b>54.72</b></p>
				</div>
			</div>
			
		</div>
		
		<div class="footer">
			<div class="bordertop_solid">
				<div class="sitemap2">
					<ul>
                <li><a href="http://www.miibeian.gov.cn/" target="_blank" rel="nofollow">沪ICP备16050468号</a></li>
                <li class="gray ml5 mr5">|</li>
                <li><a href="http://d7.yihaodianimg.com/N09/M07/BD/7B/ChEi11kJnKaAJQMrAAK-LnhML4o60600.jpg" target="_blank">营业执照</a></li>
            </ul>
				</div>
				<div class="copyright">Copyright© 聚优汇网上超市 2007-2019， All Rights Reserved</div>
			</div>
		</div>
		
		<div class="mod">
				<div class="fill-addr">
					<h3>编辑地址</h3>
					<div class="user">
					<label>收件人:　</label>
					<input type="text" placeholder="请输入收货人"/>
					</div>
					
					<div class="three-addr">
						<label>收货地址:　</label>
						
            <select id="prov" onchange="showCity(this)">
                <option>请选择省份</option>
 
            </select>
 
            <!--城市选择-->
            <select id="city" onchange="showCountry(this)">
                <option>请选择城市</option>
            </select>
 
            <!--县区选择-->
            <select id="country" onchange="selecCountry(this)">
                <option>请选择县区</option>
            </select>
						
						
					</div>
					<div class="detail-addr">
						<label>详细地址:　</label>
						<input type="text" placeholder="请输入详细地址"/>
					</div>
					
					<div class="addr-call" onmouseenter="">
						<label>手机号码:　</label>
						<input type="text" placeholder="请输入手机号"/>
						<span>手机号码格式不正确</span>
					</div>
					
					<div class="fill-opera">
					<button class="save" disabled="true">保存</button>
					<button class="cancel">取消</button>
					</div>
				</div>
			</div>
  </body>
</html>

<script src="/jyhwebstore/store/js/jquery.min.js"></script>
<script src="/jyhwebstore/store/js/city.js"></script>
<script src="/jyhwebstore/store/js/method.js"></script>
<script src="/jyhwebstore/store/js/ordersubmit.js"></script>
