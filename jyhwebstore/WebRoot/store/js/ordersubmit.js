


var msg={};
$(function(){
	$.get({
		type:"get",
		url:"/jyhwebstore/ordersubmit",
		data:{},
		datatype:"json",
		success:function(result){
		
			var re=JSON.parse(result);
			re = re[0];
			
			for(var i=0;i<re.length;i++){
			if(re[0].isdefault==1){
				var str=`
				<li class="consign-itme item-selected" onclick="defaultAddr(this)">
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
						<span>${re[0].recivename}</span>
						<span>${re[0].recivephone}</span>
					</p>
					<p><span prov="${re[0].proval}">${re[0].province} </span>
						<span city="${re[0].townval}">${re[0].town}</span>
						<span country="${re[0].countyval}">${re[0].county}</span>
					</p>
					<p>${re[0].addressdetail}</p>
				</div>
				<div class="sprite_odr is-choose"></div>
				
			</li>
				`;
				
			}else{
				var str=`
				<li class="consign-itme " onclick="defaultAddr(this)">
				<div class="total_info">
					<i class="sprite_odr  adr_icon"></i>
					
					<span>
						<a href="javascript:;" class="edit-consignee" onclick="edit(this)">编辑</a>
						<a href="javascript:;"
	class="del-consignee"  onclick="removeAddr(this)">删除</a>
					</span>
				</div>
				<div class="detail_info">
					<p>
						<span>${re[0].recivename}</span>
						<span>${re[0].recivephone}</span>
					</p>
					<p><span prov="{re[0].proval}">${re[0].province} </span>
						<span city="${re[0].townval}">${re[0].town}</span>
						<span country="${re[0].countyval}">${re[0].county}</span>
					</p>
					<p>${re[0].addressdetail}</p>
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
	






















var flag=false;
	function defaultAddr(obj){
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
		}
	
	
	var par;
	function edit(obj){
		par=$(obj).parent().parent().siblings();
		$('.mod').css({
			'display':'block',
		})
		console.log(par);
		
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
	
	
	
	$('.addr-call input').keyup(function(){
		var call=$('.addr-call input').val();
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
	});
	
	
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
		if(flag){
			var prov_val=prov.val();
			var prov_html=prov.html();
			
			var city_val=city.val();
			var city_html=city.html();
			
			var country_val=country.val();
			var country_html=country.html();
			
			var str=`
			<li class="consign-itme" onclick="defaultAddr(this)">
						<div class="total_info">
						<i class="sprite_odr  adr_icon"></i>
							<span>
								<a href="javascript:;" class="edit-consignee" onclick="edit(this)">编辑</a>
								<a href="javascript:;"
class="del-consignee"  onclick="removeAddr(this)">删除</a>
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
			flag=false;
		}else{
			par.eq(0).children().eq(0).children().eq(0).html(username);
			par.eq(0).children().eq(1).children().eq(0).attr("prov",prov.val()).html(prov.html());
			par.eq(0).children().eq(1).children().eq(1).attr("city",city.val()).html(city.html());
			par.eq(0).children().eq(1).children().eq(2).attr("country",country.val()).html(country.html());
			par.eq(0).children().eq(2).html(detailaddr);
			par.eq(0).children().eq(0).children().eq(1).html(call);
			
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
		var prov= $('#prov option:first').attr("selected",'selected');
		var city=$('#city option:first').attr("selected",'selected');
		var country=$('#country option:first').attr("selected",'selected');	
		country.siblings()
	}
