
var comid=getUrlVal("comid");
var orderid=getUrlVal("orderid");
var msg={};
var comid1="";
var price=0;
var uuid="";
var orderform={};
var sNow = "";
var num="";
var addr="";
if(comid!=null){
	comid1=comid;
	num=getUrlVal("num");
}
$(function(){
	$.get({
		type:"get",
		url:"/jyhwebstore/ordersubmit",
		data:{"msg":comid1,"num":num,"orderid":orderid},
		datatype:"json",
		success:function(result){
		console.log(result);
			var json=JSON.parse(result);
			orderform.goods=json[1];

			for(var i=0;i<json[1].length;i++){
				var js=json[1];
				price=price+(parseInt(js[i].comprice)*parseInt(js[i].count));
				
				if(!js[i].uuid==""){
				uuid=uuid+js[i].uuid;
				if(i<json[1].length-1){
					uuid=uuid+",";
				}
				}
				var str=`
				<div class="box">
				<div class="dib_tit">聚优汇</div>
						<div class="des">
							<img src="${js[i].compic}"/>
							<p class="name">${js[i].comname}</p>
							<p class="color">${js[i].color}</p>
						<p class="size">${js[i].size}</p>
						<p class="exist">有货</p>
						<p class="count">×${js[i].count}</p>
						<p class="price">￥${js[i].comprice}</p>
							
						</div>
			</div>
				`;
				$(".good-list").prepend(str);
			}
			$('#payPrice').children().eq(1).html(price);
			
			for(var i=0;i<json[0].length;i++){
				var re=json[0];
			if(re[i].isdefault==1){
				var str=`
				<li class="consign-itme item-selected" addr="${re[i].addressid}" onclick="defaultAddr(this)" >
				<div class="total_info">
					<i class="sprite_odr  adr_icon"></i>
					
					<span>
						<a href="javascript:;" class="edit-consignee" onclick="edit(this)" addr=${re[i].addressid}>编辑</a>
						<a href="javascript:;"
	class="del-consignee" style="display: none;" onclick="removeAddr(this)" addr=${re[i].addressid}>删除</a>
					</span>
				</div>
				<div class="detail_info">
					<p>
						<span>${re[i].recivename}</span>
						<span>${re[i].recivephone}</span>
					</p>
					<p><span prov="${re[i].proval}">${re[i].province} </span>
						<span city="${re[i].townval}">${re[i].town}</span>
						<span country="${re[i].countyval}">${re[i].county}</span>
					</p>
					<p>${re[i].addressdetail}</p>
				</div>
				<div class="sprite_odr is-choose"></div>
				
			</li>
				`;
				
				var address=`
				
				<p class="adr_name_tel">
				<span class="pat_name">${re[i].recivename}</span>
				<span> </span>
				<span class="pta_name">${re[i].recivephone}</span>
			</p>
			<p class="adr_detail">
				<i class="sprite_odr"></i>
				<span class="area_Name">${re[i].province} ${re[i].town} ${re[i].county} ${re[i].addressdetail}</span>
			</p>
				`;
				
				$(".pay_tli_adr").html(address);
				
			}else{
				var str=`
				<li class="consign-itme " onclick="defaultAddr(this)" addr="${re[i].addressid}">
				<div class="total_info">
					<i class="sprite_odr  adr_icon"></i>
					
					<span>
						<a href="javascript:;" class="edit-consignee" onclick="edit(this)" addr="${re[i].addressid}">编辑</a>
						<a href="javascript:;"
	class="del-consignee"  onclick="removeAddr(this)" addr="${re[i].addressid}">删除</a>
					</span>
				</div>
				<div class="detail_info">
					<p>
						<span>${re[i].recivename}</span>
						<span>${re[i].recivephone}</span>
					</p>
					<p><span prov="${re[i].proval}">${re[i].province} </span>
						<span city="${re[i].townval}">${re[i].town}</span>
						<span country="${re[i].countyval}">${re[i].county}</span>
					</p>
					<p>${re[i].addressdetail}</p>
				</div>
				<div class="sprite_odr"></div>
				
			</li>
				`;
			}
			
			$('#consignee_list').append(str);
			}
			
			
		}
		
		
		
	});
	
	
	
});
	

//更改地址
var flag=false;
	function defaultAddr(obj,event){
	
		msg.oldflag="";
		var oldaddr=$('.item-selected').attr('addr');
			
			if(oldaddr!=null){
				msg.oldflag=oldaddr;
			}
		var newaddr=$(obj).attr('addr');
		$('.consign-itme').each(function(i,n){
			$(n).removeClass("item-selected");
		});
		$(obj).addClass("item-selected");
		
		$('.sprite_odr').each(function(i,n){
			$(n).removeClass("is-choose");
		});
		$(obj).children().eq(2).addClass('is-choose');
		
		$('.del-consignee').each(function(i,n){
			$(n).css({
				'display':'block',
			});
			
		})
		
		$(obj).children().eq(0).children().eq(1).children().eq(1).css({
			'display':'none',
		})
		
		
		msg.newflag=newaddr;
		console.log(newaddr);
		
		$(function(){
			$.get({
				type:"get",
				url:"/jyhwebstore/address",
				data:{"action":"update","msg":JSON.stringify(msg)},
				datatype:"json",
				success:function(result){
					var div=$(obj).children().eq(1);
					
					var name=div.children().eq(0).children().eq(0).html();
					var call=div.children().eq(0).children().eq(1).html();
					var prov=div.children().eq(1).children().eq(0).html();
					var city=div.children().eq(1).children().eq(1).html();
					var country=div.children().eq(1).children().eq(2).html();
					var detailaddr=div.children().eq(2).html();
					
					var address=`
					
					<p class="adr_name_tel">
					<span class="pat_name">${name}</span>
					<span> </span>
					<span class="pta_name">${call}</span>
				</p>
				<p class="adr_detail">
					<i class="sprite_odr"></i>
					<span class="area_Name">${prov} ${city} ${country} ${detailaddr}</span>
				</p>
					`;
					
					$(".pay_tli_adr").html(address);
					
				}
				})
			
		})
		
		
		
		
		}
	
	
	//删除地址
	function removeAddr(obj){
		window.event.stopPropagation();
		$(obj).parent().parent().parent().remove();

		msg.flag=$(obj).attr('addr');
		
		$(function(){
			$.get({
				type:"get",
				url:"/jyhwebstore/address",
				data:{"action":"delete","msg":JSON.stringify(msg)},
				datatype:"json",
				success:function(result){
					
				}
				})
			
		})
		
		
		
	}
	
	
	//编辑地址
	var par;
	function edit(obj){
		window.event.stopPropagation();
		msg.flag=$(obj).attr('addr');
		par=$(obj).parent().parent().siblings();
		$('.mod').css({
			'display':'block',
		})

		
		var nickname=par.eq(0).children().eq(0).children().eq(0).html();
		
		var pro=par.eq(0).children().eq(1).children().eq(0).attr("prov");
		
		var city=par.eq(0).children().eq(1).children().eq(1).attr("city");
		var country=par.eq(0).children().eq(1).children().eq(2).attr("country");
		var detailaddr=par.eq(0).children().eq(2).html();
	
		var  call=par.eq(0).children().eq(0).children().eq(1).html();
		
		prov= parseInt(pro)+1;
		city=parseInt(city)+1;
		country=parseInt(country)+1;
		console.log(prov);
		
		$('.addr-call input').val(call);
		$('.user input').val(nickname);
		$('.detail-addr input').val(detailaddr);
		$('#prov option').eq(prov).prop('selected','selected');
		  var p=document.getElementById("prov");
		  p.onchange();
		$('#city option').eq(city).prop('selected','selected');
		
		  var c=document.getElementById("city");
		  c.onchange();
//		  
//		  
		  $('#country option').eq(country).prop('selected','selected');
		
		  var coun=document.getElementById("country");
		  coun.onchange();
		
		var reg = /^1[3456789]\d{9}$/g;
		if(reg.test(call)){
			$('.save').attr('disabled',false).css({
				'cursor':'pointer',
			});
			$('.addr-call span').css({
				'display':'none',
			})
		}else{
			$('.save').attr('disabled',false).css({
				'cursor':'not-allowed',
			});
			$('.addr-call span').css({
				'display':'inline',
			})
		}
		
	}
	
	
	
var callnumber,prov1,city1,country1,name1,detailaddr;
	
	
	$('.addr-call input').keyup(function(){
		var call=$('.addr-call input').val();
		var reg = /^1[3456789]\d{9}$/g;
		if(reg.test(call)){
			$('.addr-call span').css({
				'display':'none',
			})
			callnumber=true;
			
		}else{
			$('.addr-call span').css({
				'display':'inline',
			})
			callnumber=false;
		}
		console.log("callnumber="+callnumber+",prov1="+prov1+",city1="+city1+",country1="+country1+",name1="+name1+",detailaddr="+detailaddr);
		if(callnumber&&prov1&&city1&&country1&&name1&&detailaddr){
			$('.save').attr('disabled',false).css({
				'cursor':'pointer',
			});
			
		}else{
			$('.save').attr('disabled',true).css({
				'cursor':'not-allowed',
			});
			
		}
		
	});
	
	$('.user input').keyup(function(){
		var username=$('.user input').val();
		
	if(username.indexOf(" ",0)==-1&&username.length>=1){
		name1=true;
	}else{
		name1=false;
	}
		console.log("name="+name1);
		if(callnumber&&prov1&&city1&&country1&&name1&&detailaddr){
			
			$('.save').attr('disabled',false).css({
				'cursor':'pointer',
			});
			
		}else{
			
			$('.save').attr('disabled',true).css({
				'cursor':'not-allowed',
			});
			
		}
		
		
	})
	
	
		$("#prov").click(function(){
			var index=$(this).find("option:selected").html();
			var idname=$(this).attr('id');
		
			if(index!="请选择省份"&&idname=="prov"){
				prov1=true;
				city1=false;
				country1=false;
				
			}else{
				prov1=false;
				city1=false;
				country1=false;
			}
			
			
			if(callnumber&&prov1&&city1&&country1&&name1&&detailaddr){
			$('.save').attr('disabled',false).css({
				'cursor':'pointer',
			});
			
		}else{
			$('.save').attr('disabled',true).css({
				'cursor':'not-allowed',
			});
			
		}
		})
		
		$("#city").click(function(){
			var index=$(this).find("option:selected").html();
			var idname=$(this).attr('id');
		
			
			if(index!="请选择城市"&&idname=="city"){
				
				city1=true;
				country1=false;
				
			}else{
				city1=false;
				country1=false;
			}
			
			if(callnumber&&prov1&&city1&&country1&&name1&&detailaddr){
			$('.save').attr('disabled',false).css({
				'cursor':'pointer',
			});
			
		}else{
			$('.save').attr('disabled',true).css({
				'cursor':'not-allowed',
			});
			
		}
		})
		
		$("#country").click(function(){
			var index=$(this).find("option:selected").html();
			var idname=$(this).attr('id');
		
			
			if(index!="请选择县区"&&idname=="country"){
				
				country1=true;
				
			}else{
				country1=false;
			}
			if(callnumber&&prov1&&city1&&country1&&name1&&detailaddr){
			$('.save').attr('disabled',false).css({
				'cursor':'pointer',
			});
			
		}else{
			$('.save').attr('disabled',true).css({
				'cursor':'not-allowed',
			});
			
		}
		})
	
	
	
	$('.detail-addr input').keyup(function(){
		var addr=$('.detail-addr input').val();
		
		if(addr.indexOf(" ",0)!=0&&addr.length>=1){
			detailaddr=true;
			console.log("detailaddr="+detailaddr);
			
		}else{
			detailaddr=false;
		}
		if(callnumber&&prov1&&city1&&country1&&name1&&detailaddr){
			$('.save').attr('disabled',false).css({
				'cursor':'pointer',
			});
			
		}else{
			$('.save').attr('disabled',true).css({
				'cursor':'not-allowed',
			});
			
		}
	})
	
	
	
	$('.cancel').click(function(){
		$('.mod').css({
			'display':'none',
		})
		
		
	});
	
	//地址保存
	$(".save").click(function(){
//		
	    var detailaddr=$('.detail-addr input').val();
		var call=$('.addr-call input').val();
		var username=$('.user input').val();
		var prov= $('#prov option:selected');
		var city=$('#city option:selected');
		var country=$('#country option:selected');	
		
		var prov_val=prov.val();
		msg.proval=prov_val
		var prov_html=prov.html();
		msg.provhtml=prov_html
		var city_val=city.val();
		msg.cityval=city_val
		var city_html=city.html();
		msg.cityhtml=city_html
		var country_val=country.val();
		msg.countryval=country_val
		var country_html=country.html();
		msg.countryhtml=country_html;
		msg.detailaddr=detailaddr;
		msg.call=call;
		msg.username=username;
		if(flag){
			$.get({
				type:"get",
				url:"/jyhwebstore/address",
				data:{"action":"insert","msg":JSON.stringify(msg)},
				datatype:"json",
				success:function(result){
					console.log(result);
					var str=`
					<li class="consign-itme" onclick="defaultAddr(this)" addr=${result}>
								<div class="total_info">
								<i class="sprite_odr  adr_icon"></i>
									<span>
										<a href="javascript:;" class="edit-consignee" onclick="edit(this)" addr=${result}>编辑</a>
										<a href="javascript:;"
		class="del-consignee"  onclick="removeAddr(this)" addr=${result}>删除</a>
									</span>
								</div>
								<div class="detail_info">
									<p>
										<span>${username}</span>
										<span>${call}</span>
									</p>
									<p><span prov=${prov_val}>${prov_html} </span>
										<span city=${city_val}>${city_html}</span>
										<span country=${country_val}>${country_html}</span>
									</p>
									<p>${detailaddr}</p>
								</div>
								<div class="sprite_odr"></div>
								
							</li>
					`;
					
					$('#consignee_list').append(str);
					
				}
				});
			
			
			
			
			
			
			flag=false;
		}else{
			par.eq(0).children().eq(0).children().eq(0).html(username);
			par.eq(0).children().eq(1).children().eq(0).attr("prov",prov.val()).html(prov.html());
			par.eq(0).children().eq(1).children().eq(1).attr("city",city.val()).html(city.html());
			par.eq(0).children().eq(1).children().eq(2).attr("country",country.val()).html(country.html());
			par.eq(0).children().eq(2).html(detailaddr);
			par.eq(0).children().eq(0).children().eq(1).html(call);
			
			$.get({
				type:"get",
				url:"/jyhwebstore/address",
				data:{"action":"updateaddr","msg":JSON.stringify(msg)},
				datatype:"json",
				success:function(result){
					
var address=`
					
					<p class="adr_name_tel">
					<span class="pat_name">${nickname}</span>
					<span> </span>
					<span class="pta_name">${call}</span>
				</p>
				<p class="adr_detail">
					<i class="sprite_odr"></i>
					<span class="area_Name">${prov_html} ${city_html} ${country_html} ${detailaddr}</span>
				</p>
					`;
					
					$(".pay_tli_adr").html(address);
				}
				});
			
		}
		$('.mod').css({
			'display':'none',
		})
})
	
	
	
	//新建地址
	function add(obj){
		flag=true;
		$(".mod").css({
			'display':'block',
		});
		
	 var detailaddr=$('.detail-addr input').val("");
		var call=$('.addr-call input').val("");
		var username=$('.user input').val("");
		var prov= $('#prov option:first').prop("selected",'selected');
		var city=$('#city option:first').prop("selected",'selected');
		var country=$('#country option:first').prop("selected",'selected');	
		
	}
	
	var submitorderflag=true;
	//提交订单
	function submitorder(obj){
		
		if(submitorderflag){
			console.log("sakdalsj");
			submitorderflag=false;
		orderform.name=$('.pat_name').html();
		orderform.call=$('.pat_name').siblings().eq(1).html();
		orderform.address=$('.area_Name').html();
		orderform.price=price;
		GetDateNow();
		orderform.ordernum=sNow;
    if(orderform.name!=null){
		
		$.ajax({
			type:"post",
			url:"/jyhwebstore/ordersubmit",
			data:{"uuid":uuid,"orderform":JSON.stringify(orderform)},
			datatype:"json",
			success:function(result){
				console.log("=================================");
				location.href="/jyhwebstore/pay/index.jsp?price="+price+"&coumid="+comid+"&order="+sNow;
				
			}
		});
    }else{
    	 var show=$("#show").fadeIn();
			$("#show").fadeOut(3000);
			setTimeout(function(){submitorderflag=true;},3100);
    }
		
		
		}	
		
	}
	
	function GetDateNow() {
		var vNow = new Date();
		
		sNow += String(vNow.getFullYear());
		sNow += String(vNow.getMonth() + 1);
		sNow += String(vNow.getDate());
		sNow += String(vNow.getHours());
		sNow += String(vNow.getMinutes());
		sNow += String(vNow.getSeconds());
		sNow += String(vNow.getMilliseconds());
	
		
	}
	
	 
	function getUrlVal(property){
		  //地址栏
		  var urlStr = window.location.search.substring(1);
		  var re = new RegExp('(^|&)'+ property +'=([^&]*)(&|$)');
		  var result = urlStr.match(re);
		  if(result == null){return null};
		  return result[2];
		};
	
		
		
		
