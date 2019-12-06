

var data={};

$(function(){

	$.get({
		type:"get",
		url:"/jyhwebstore/address",
		data:{"action":"query"},
		datatype:"json",
		success:function(result){
			if(result!=false){
			var json = JSON.parse(result);
			
			for(var i = 0; i < json.length;i++)
				{	
					var isdefault = json[i].isdefault;
					
					if(isdefault==1){
						var str = `
					<li>
  					<div class="  addr-default isdefault">默认地址</div>`;
  					
  					var str2=`
  					<div class="opera">
  					<div class="addr-edit" onclick="edit(this)" flag="${json[i].addressid}">编辑</div>
  					<div class="set-default default" onclick="defaultAddr(this)" flag="${json[i].addressid}">设为默认地址</div>
  					<div class="delete default" onclick="removeAddr(this)" flag="${json[i].addressid}">删除</div>
  				</div>	
  				</li>
					
					`;
  					}else{
  						var str = `
  						<li>
  	  					<div class="addr-default">默认地址</div>`;
  	  				var str2=`
  					<div class="opera">
  					<div class="addr-edit" onclick="edit(this)" flag="${json[i].addressid}">编辑</div>
  					<div class="set-default " onclick="defaultAddr(this)" flag="${json[i].addressid}">设为默认地址</div>
  					<div class="delete" onclick="removeAddr(this)" flag="${json[i].addressid}">删除</div>
  				</div>	
  				</li>
					`;
  	  					
  					}
					var str1=`
  					<div class="addr-information" >
  					<p class="nickname">收货人：<span>${json[i].recivename}</span> <em>收</em></p>
  					<p class="addressname">
  						<label>收货地址: </label>
  						<span id="addr-prov" prov="${json[i].proval}">${json[i].province}</span>
  						<label> </label>
  						<span id="addr-city" city="${json[i].townval}">${json[i].town}</span>
  						<label> </label>
  					<span id="addr-country" country="${json[i].countyval}">${json[i].county}</span>
  						<label> </label>
  						<em>${json[i].addressdetail}</em>
  					</p>
  					<p class="call" >手机号: <span>${json[i].recivephone}</span></p>
  					</div>`;
					var content=str+str1+str2;
					
					$('.addr-bar').append(content);
					
				}
		}
			
		}
	
	});
})









//设置默认地址

function defaultAddr(obj){
		var addr_default=$(obj).parent().siblings().eq(0);
		
		$('.addr-default').each(function(i,n){
			$(n).removeClass('isdefault');
		});	
		addr_default.addClass('isdefault');
		
		data.oldflag="";
		var oldflag=$('.default').attr('flag');
		if(oldflag!=null){
			console.log("oldflag!=null");
			data.oldflag=oldflag;
		}
		$('.set-default').each(function(i,n){
			$(n).removeClass('default');
		});
		
		$(obj).addClass('default');
		data.newflag=$(obj).attr("flag");
		
		$('.delete').each(function(i,n){
			$(n).removeClass('default');
		});
		
		$(obj).siblings().eq(1).addClass('default');
		$.get({
			type:"get",
			url:"/jyhwebstore/address",
			data:{"action":"update","msg":JSON.stringify(data)},
			datatype:"json",
			success:function(result){
			}
			});
		
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
		
	if(username.indexOf(" ",0)==-1&&username.length>=1&&username.length<=6){
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
		
		if(addr.indexOf(" ",0)!=0&&addr.length>=1&&addr.length<=6){
			detailaddr=true;
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
		callnumber=false;prov1=false;city1=false;country1=false;name1=false;detailaddr=false;
		$('.save').attr('disabled',true).css({
			'cursor':'not-allowed',
		});
		$('.mod').css({
			'display':'none',
		})
		
		
	});
	
	var flag=false;
	
	$('.addr-btn').click(function(){
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
		
	});
	
	var par;
	
	
	function edit(obj){
		callnumber=true;prov1=true;city1=true;country1=true;name1=true;detailaddr=true;
		$(".mod").css({
			'display':'block',
		})
		data.flag=$(obj).attr('flag');
       console.log(data.flag);
		par=$(obj).parent().siblings();
           
     

		var nickname=par.children().eq(0).children().eq(0).html();
		var prov=par.children().eq(1).children().eq(1).attr('prov');
		var city=par.children().eq(1).children().eq(3).attr('city');
		var country=par.children().eq(1).children().eq(5).attr('country');
		var detailname=par.children().eq(1).children().eq(7).html();
		var call=par.children().eq(2).children().eq(0).html();
		
		prov= parseInt(prov)+1;
		city=parseInt(city)+1;
		country=parseInt(country)+1;

		
		
		$('.addr-call input').val(call);
		$('.user input').val(nickname);
		$('.detail-addr input').val(detailname);
		$('#prov option').eq(prov).prop('selected','selected');
		  var p=document.getElementById("prov");
		  p.onchange();
		$('#city option').eq(city).prop('selected','selected');
		
		  var c=document.getElementById("city");
		  c.onchange();	  
		  $('#country option').eq(country).prop('selected','selected');
		
		  var coun=document.getElementById("country");
		  coun.onchange();
		
		var reg = /^1[3456789]\d{9}$/g;
		if(reg.test(call)){
			
			$('.addr-call span').css({
				'display':'none',
			})
		}else{
			
			$('.addr-call span').css({
				'display':'inline',
			})
		}
	}
	

	$(".save").click(function(){
		$('.save').attr('disabled',true).css({
			'cursor':'not-allowed',
		});
	    var detailaddr=$('.detail-addr input').val();
	    data.detailaddr=detailaddr;
		var call=$('.addr-call input').val();
		data.call=call;
		var username=$('.user input').val();
		data.username=username;
		var prov= $('#prov option:selected');
		var city=$('#city option:selected');
		var country=$('#country option:selected');	
		
		var prov_val=prov.val();
		data.proval=prov_val
		var prov_html=prov.html();
		data.provhtml=prov_html
		var city_val=city.val();
		data.cityval=city_val
		var city_html=city.html();
		data.cityhtml=city_html
		var country_val=country.val();
		data.countryval=country_val
		var country_html=country.html();
		data.countryhtml=country_html;
		
		if(flag){
			callnumber=false;prov1=false;city1=false;country1=false;name1=false;detailaddr=false;
			$.get({
				type:"get",
				url:"/jyhwebstore/address",
				data:{"action":"insert","msg":JSON.stringify(data)},
				datatype:"json",
				success:function(result){
					
					
					var str=`
					<li>
					  					<div class="addr-default ">默认地址</div>
					  					<div class="addr-information">
					  					<p class="nickname">收货人：<span>${username}</span> <em>收</em></p>
					  					<p class="addressname">
					  						<label>收货地址: </label>
					  						<span id="addr-prov" prov=${prov_val}>${prov_html}</span>
					  						<label> </label>
					  						<span id="addr-city" city=${city_val}>${city_html} </span>
					  						<label> </label>
					  					<span id="addr-country" country=${country_val}>${country_html}</span>
					  						<label> </label>
					  						<em>${detailaddr}</em>
					  					</p>
					  					<p class="call" >手机号: <span    >${call}</span></p>
					  					</div>
					  				<div class="opera">
					  					<div class="addr-edit" onclick="edit(this)" flag="${result}">编辑</div>
					  					<div class="set-default" onclick="defaultAddr(this)" flag="${result}">设为默认地址</div>
					  					<div class="delete" onclick="removeAddr(this)" flag="${result}">删除</div>
					  				</div>	
					  				</li>
					
					`;
					
					$('.addr-bar').append(str);
					
				}
				});
		
			
			
		
			
			flag=false;
		}else{
	
			callnumber=false;prov1=false;city1=false;country1=false;name1=false;detailaddr=false;
		par.children().eq(0).children().eq(0).html(username);
		par.children().eq(1).children().eq(7).html(detailaddr);
		par.children().eq(2).children().eq(0).html(call);
		par.children().eq(1).children().eq(1).attr('prov',prov.val()).html(prov.html());
		par.children().eq(1).children().eq(3).attr('city',city.val()).html(city.html());
		par.children().eq(1).children().eq(5).attr('country',country.val()).html(country.html());
		
		$.get({
			type:"get",
			url:"/jyhwebstore/address",
			data:{"action":"updateaddr","msg":JSON.stringify(data)},
			datatype:"json",
			success:function(result){
			}
			});
		
		}
		
		$('.mod').css({
			'display':'none',
		})
		
	});
		
		
		function removeAddr(obj){
			data.flag=$(obj).attr("flag");
			$(obj).parent().parent().remove();
			$.get({
				type:"get",
				url:"/jyhwebstore/address",
				data:{"action":"delete","msg":JSON.stringify(data)},
				datatype:"json",
				success:function(result){
				}
				});
			
			}
		
		
			
		
