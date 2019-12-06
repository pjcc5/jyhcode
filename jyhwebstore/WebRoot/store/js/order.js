var choose=document.getElementById('choose');
	var now=choose.getElementsByTagName('li');
	var order=document.getElementsByClassName('order-item');
	var active=order[0].children;
	console.log(active.length);
	console.log(now.length);
	var n=0;
	for(var i=0;i<now.length;i++){
		(function(x){
			
			now[x].onclick=function(){
				n=x;
				
			console.log(n);
			for(var i=0;i<now.length;i++){
				now[i].classList.remove('now')
				
				active[i].classList.remove('active');
			}
			
			now[n].classList.add('now');
			active[n].classList.add('active');
		}
		})(i)
		
	}
	
	
	$('#top').click(function(){
  			// $(document).scrollTop(0);
  			// $('#top').fadeOut(1000);
  			$('body,html').animate({'scrollTop':0},500);
  		});

$(window).scroll(function(){
  		var toTop=$(window).scrollTop();
  		if(toTop>=50){
  			
		
		if($(document).scrollTop() < 100)
		{	
			$('#top').fadeOut(1000);
		}else{
			$('#top').fadeIn(1000);
		}
		}
				
  	})
  	
  	
  	
  	function shownotpay(){
	var forms = allForm;
	console.log("这是shownotpay方法");
	for (var i = 0; i < forms.length; i++) {
		var orderid;
		var ordername;
		var orderprice;
		var orderstatement;
		var orderpay;
		var form = forms[i];
		
		var goods=form.orderForms;
		
			var aid = goods[0].aid;
			var comid=goods[0].comid;
			var comname=goods[0].comname;
			var orderadd=goods[0].orderadd;
			var ordercompany=goods[0].ordercompany;
			var year= goods[0].orderdate.year-100+2000;
			var day =goods[0].orderdate.day;
			var month =goods[0].orderdate.month+1;
			var hours =goods[0].orderdate.hours;
			var minutes=goods[0].orderdate.minutes;
			var seconds = goods[0].orderdate.seconds;
			//var time = ""+year+"年"+month+"月"+day+"日"+hours+"时"+minutes+"分"+seconds+"秒";
			var time = year+"年"+month+"月"+day+"日";
		    orderid = goods[0].orderid;
		    ordername =goods[0].ordername;
			var orderphone = goods[0].orderphone;
			orderprice =goods[0].orderprice;
			orderstatement =goods[0].orderstatement;
			orderpay =goods[0].orderpay;
		if(orderpay == 1&&orderstatement==3)
			{
			var str=`
	 		<div class="order-item-all">
					
					<div class="order-header">
						<div class="order-left">
						<div class="time">`+time+`</div>
						<div class="order-num">订单号：<span>`+orderid+`</span></div>
						<div class="receiver">收货人:`+ordername+`</div>
						</div>
						
						
					<div class="order-right">
						<div class="price">总金额：`+orderprice+`元</div>
						<div class="state">未支付</div>
					
					</div>
		
					</div >
					 
					<div class="order-4list">
						<div class="order-pro">
							<a href="">
							<img src="/jyhwebstore/store/img/bgctop.jpg"/></a>
							<div class="order-title">
								<p class="desc">`+comname+`<span>等    `+goods.length+`件商品</span>`+`</p>
								<div class="buy-btn" onclick="buyagin(this)">再次购买</div>
								<div class="cancel-btn" onclick="cancel(this)">取消订单</div>
		 								</div>
		 							</div>
		 							<div class="order-btns" onclick="pay(this)">立即支付</div>
		 							<div class="order-btns" onclick="goorderdetail(this)">订单详情</div>
		 						</div>
		 					</div>
								`;
			$(".order-pay").append(str);
			
			}
		
	}
}
function showgetgoods(){
	//获取收货了的商品
	var forms = allForm;
	for (var i = 0; i < forms.length; i++) {
		var orderid;
		var ordername;
		var orderprice;
		var orderstatement;
		var orderpay;
		var form = forms[i];
		var goods=form.orderForms;
		console.log(goods[0].aid);
			var aid = goods[0].aid;
			var comid=goods[0].comid;
			var comname=goods[0].comname;
			var orderadd=goods[0].orderadd;
			var ordercompany=goods[0].ordercompany;
			var year= goods[0].orderdate.year-100+2000;
			var day =goods[0].orderdate.day;
			var month =goods[0].orderdate.month+1;
			var hours =goods[0].orderdate.hours;
			var minutes=goods[0].orderdate.minutes;
			var seconds = goods[0].orderdate.seconds;
			//var time = ""+year+"年"+month+"月"+day+"日"+hours+"时"+minutes+"分"+seconds+"秒";
			var time = year+"年"+month+"月"+day+"日";
		    orderid = goods[0].orderid;
		    ordername =goods[0].ordername;
			var orderphone = goods[0].orderphone;
			orderprice =goods[0].orderprice;
			orderstatement =goods[0].orderstatement;
			orderpay =goods[0].orderpay;
		if(orderstatement == 2)
			{
			var str=`
	 		<div class="order-item-all">
					
					<div class="order-header">
						<div class="order-left">
						<div class="time">`+time+`</div>
						<div class="order-num">订单号：<span>`+orderid+`</span></div>
						<div class="receiver">收货人:`+ordername+`</div>
						</div>
						
						
					<div class="order-right">
						<div class="price">总金额：`+orderprice+`元</div>
						<div class="state">待收货</div>
					
					</div>
						
					</div >
					 
					<div class="order-4list">
						<div class="order-pro">
							<a href="">
							<img src="/jyhwebstore/store/img/bgctop.jpg"/></a>
							<div class="order-title">
								<p class="desc">`+comname+`<span>等    `+goods.length+`件商品</span>`+`</p>
								<div class="buy-btn" onclick="buyagin(this)">再次购买</div>
								
		 								</div>
		 							</div>
		 							<div class="order-btns">查看物流</div>
		 							<div class="order-btns" onclick="goorderdetail(this)">订单详情</div>
		 						</div>
		 					</div>
								`;
								
			
		
			$(".order-receive").append(str);
			
			}
		
	}
}
function getgoodsok(){
	//获取完成了的商品
	var forms = allForm;
	for (var i = 0; i < forms.length; i++) {
		var orderid;
		var ordername;
		var orderprice;
		var orderstatement;
		var orderpay;
		var form = forms[i];
		var goods=form.orderForms;
		if(goods.length > 0)
			{
			var aid = goods[0].aid;
			var comid=goods[0].comid;
			var comname=goods[0].comname;
			var orderadd=goods[0].orderadd;
			var ordercompany=goods[0].ordercompany;
			var year= goods[0].orderdate.year-100+2000;
			var day =goods[0].orderdate.day;
			var month =goods[0].orderdate.month+1;
			var hours =goods[0].orderdate.hours;
			var minutes=goods[0].orderdate.minutes;
			var seconds = goods[0].orderdate.seconds;
			//var time = ""+year+"年"+month+"月"+day+"日"+hours+"时"+minutes+"分"+seconds+"秒";
			var time = year+"年"+month+"月"+day+"日";
		    orderid = goods[0].orderid;
		    ordername =goods[0].ordername;
			var orderphone = goods[0].orderphone;
			orderprice =goods[0].orderprice;
			orderstatement =goods[0].orderstatement;
			orderpay =goods[0].orderpay;
		if(orderstatement == 1)
			{
			
			var str=`
	 		<div class="order-item-all">
					
					<div class="order-header">
						<div class="order-left">
						<div class="time">`+time+`</div>
						<div class="order-num">订单号：<span>`+orderid+`</span></div>
						<div class="receiver">收货人:`+ordername+`</div>
						</div>
						
						
					<div class="order-right">
						<div class="price">总金额：`+orderprice+`元</div>
						<div class="state">未支付</div>
					
					</div>
						
					</div >
					 
					<div class="order-4list">
						<div class="order-pro">
							<a href="">
							<img src="/jyhwebstore/store/img/bgctop.jpg"/></a>
							<div class="order-title">
								<p class="desc">`+comname+`<span>等    `+goods.length+`件商品</span>`+`</p>
								<div class="buy-btn" onclick="buyagin(this)">再次购买</div>
								<div class="cancel-btn" onclick="deleteform(this)">删除订单</div>
		 								</div>
		 							</div>
		 							<div class="order-btns">已完成</div>
		 							<div class="order-btns" onclick="goorderdetail(this)">订单详情</div>
		 						</div>
		 					</div>
								`;
								
			
		
			$(".order-fished").append(str);
			
			
			
			}
			}
		
	}
}
function getgoodscancel(){
	//获取取消了的商品
	var forms = allForm;
	for (var i = 0; i < forms.length; i++) {
		var orderid;
		var ordername;
		var orderprice;
		var orderstatement;
		var orderpay;
		var form = forms[i];
		var goods=form.orderForms;
		if(goods.length > 0)
			{
			var aid = goods[0].aid;
			var comid=goods[0].comid;
			var comname=goods[0].comname;
			var orderadd=goods[0].orderadd;
			var ordercompany=goods[0].ordercompany;
			var year= goods[0].orderdate.year-100+2000;
			var day =goods[0].orderdate.day;
			var month =goods[0].orderdate.month+1;
			var hours =goods[0].orderdate.hours;
			var minutes=goods[0].orderdate.minutes;
			var seconds = goods[0].orderdate.seconds;
			//var time = ""+year+"年"+month+"月"+day+"日"+hours+"时"+minutes+"分"+seconds+"秒";
			var time = year+"年"+month+"月"+day+"日";
		    orderid = goods[0].orderid;
		    ordername =goods[0].ordername;
			var orderphone = goods[0].orderphone;
			orderprice =goods[0].orderprice;
			orderstatement =goods[0].orderstatement;
			orderpay =goods[0].orderpay;
			
		if(orderstatement == 4)
			{
			var str=`
		 		<div class="order-item-all">
						
						<div class="order-header">
							<div class="order-left">
							<div class="time">`+time+`</div>
							<div class="order-num">订单号：<span>`+orderid+`</span></div>
							<div class="receiver">收货人:`+ordername+`</div>
							</div>
							
							
						<div class="order-right">
							<div class="price">总金额：`+orderprice+`元</div>
							<div class="state">未支付</div>
						
						</div>
							
						</div >
						 
						<div class="order-4list">
							<div class="order-pro">
								<a href="">
								<img src="/jyhwebstore/store/img/bgctop.jpg"/></a>
								<div class="order-title">
									<p class="desc">`+comname+`<span>等    `+goods.length+`件商品</span>`+`</p>
									<div class="buy-btn" onclick="buyagin(this)">再次购买</div>
									<div class="cancel-btn" onclick="deleteform(this)">删除订单</div>
			 								</div>
			 							</div>
			 							<div class="order-btns">已取消</div>
			 							<div class="order-btns" onclick="goorderdetail(this)">订单详情</div>
			 						</div>
			 					</div>
									`;
				$(".order-cancel").append(str);
			}
			
			}
		
	}
}
  	
  	
  	
