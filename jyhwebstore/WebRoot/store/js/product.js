


var pic=new Array();
var comid= getUrlVal('comid');
console.log(comid);

(function(){
	
  $.ajax({
	  type:"POST",
	  url:"/jyhwebstore/product",
	  data:{'msg':comid},
	  dataType:"json",
	  success:function(result){
		console.log(result);
		
		  var str = `
			<p class="name">${result.comname}</p>
			<p class="price"><span>价格</span><span class="price-m">￥${result.comprice}</span></p>
			<p class="desc"><span>销量</span><span class="desc-p">${result.detailssale}</span></p>
			<div class="hot"><span>好评</span><span class="hot-p"><span class="glyphicon glyphicon-heart"></span>${result.detailsdot}</span>
              </div>
	    `;
	    
	    
	  
	    for(var i=0;i<result.color.length;i++){
	    	 var color;
	    	  console.log(result.color[i]);
	    	  if(i==0){
	    	   color="<div class=dd><div class=\"item selected\" data-value="+result.color[i]+" title="+result.color[i]+" onclick=\"changeColor(this)\">"
	+" <p><span class=\"glyphicon glyphicon-ok\"></span></p>"
	   		+"	<div>"
	   				+"<i>"+result.color[i]+"</i>"
	   			+"</div></div></div>";
	    	  }else{
	    		  color="<div class=dd><div class=\"item \" data-value="+result.color[i]+" title="+result.color[i]+"  onclick=\"changeColor(this)\">"
	    			+" <p><span class=\"glyphicon glyphicon-ok\"></span></p>"
	    			   		+"	<div>"
	    			   				+"<i>"+result.color[i]+"</i>"
	    			   			+"</div></div></div>";
	    	  }
	    	   $('#choose-1').append(color);
	   	    
	    }
	    
	    
	    for(var i=0;i<result.size.length;i++){
	    	var size;
	    	if(i==0){
	    	 size="<div class=dd><div class=\"item selected\" data-value="+result.size[i]+" title="+result.size[i]+" onclick=\"changeSize(this)\">"
	+" <p><span class=\"glyphicon glyphicon-ok\"></span></p>"
	   		+"	<div>"
	   				+"<i>"+result.size[i]+"</i>"
	   			+"</div></div></div>";}else{
	   				size="<div class=dd><div class=item data-value="+result.size[i]+" title="+result.size[i]+" onclick=\"changeSize(this)\">"
	   				+" <p><span class=\"glyphicon glyphicon-ok\"></span></p>"
	   				   		+"	<div>"
	   				   				+"<i>"+result.size[i]+"</i>"
	   				   			+"</div></div></div>";
	   			}
	    	
	    	 $('#choose-2').append(size);
	    }
	    
	    for(var i=0;i<result.picurl.length;i++){
	    	var url;
	    	if(i==0){
	    	url="<li class=select  onmouseenter=\"imgchange(this)\"><img src=\""+result.picurl[i]+"\"/></li>"
	    	}else{
	    		url="<li   onmouseenter=\"imgchange(this)\"><img src=\""+result.picurl[i]+"\"/></li>"
	    	}
	    	pic[i]=result.picurl[i];
	    	
	    	var photo="<img src=\""+result.picurl[i].replace(/50x50/g,"800x800")+"\"/>";
	    	$('.clearfix ul').append(url);
	    	$('.center').append(photo);
	    }
//	    var img=`<img src="${result.detailsdrawing}"/>`;
	    $('.info').html(str);
//	    $('.image').append(img);
	  var url= result.picurl[0].replace(/50x50/g,"1000x1000");
	    $('.big').css({
	    	background:'url('+url+') no-repeat',
	    	'background-size':	'1000px 1000px' 
	    })
	    var url1= result.picurl[0].replace(/50x50/g,"360x360");
	    var img="<image src=\""+url1+"\"/>";

		  $('.image').append(img);
	  }
	
	 
  })
  })();
  
//   
function imgchange(obj){
	$('.clearfix ul>li').each(function(i,n){
		$(n).removeClass('select');
	});
	$(obj).addClass('select');
	
	var url=$(obj).children().eq(0).attr('src');
	
	 var url1= url.replace(/50x50/g,"360x360");
	    var img="<image src=\""+url1+"\"/>";

		  $('.image>img').attr('src',url1);

		  var url2= url.replace(/50x50/g,"1000x1000");
		    $('.big').css({
		    	background:'url('+url2+') no-repeat',
		    	
		    })
}


//function changeColor(obj){
//	$('#choose-1 .dd .item').each(function(i,n){
//		$(n).removeClass('selected');
//	});
////	console.log($('#choose-1 .dd .item'));
//	$(obj).addClass('selected');
//}
//
//function changeSize(obj){
//	$('#choose-2 .dd .item').each(function(i,n){
//		$(n).removeClass('selected');
//	});
////	console.log($('#choose-2 .dd .item'));
//	$(obj).addClass('selected');
//}



(function(){
	$('.image').mousemove(function(event){
		
	 var x = event.clientX - $('.image').offset().left - $('.slide').outerWidth()/2;
      var y = event.clientY - $('.image').offset().top - $('.slide').outerHeight()/2 + $(document).scrollTop();
      
      
         if(x <= 20){x = 20};
      if(y <= 20){y = 20};
      if(x >= $('.image').width() - $('.slide').outerWidth()){
        x = $('.image').width() - $('.slide').outerWidth()+20;
      }
      if(y >= $('.image').height() - $('.slide').outerHeight()){
        y = $('.image').height() - $('.slide').outerHeight()+20;
      }
      
       $('.slide').css({
        left : x,
        top : y,
      });
      
      console.log(x,y);
      
        var bili = (1000 - $('.big').width()) / ($('.image').width() - $('.slide').outerWidth());
      // console.log(bili);
      //console.log($('.big').css('backgroundSize'))
      var str = (-x+20)*bili+ 'px ' + (-y+20)*bili + 'px';
      $('.big').css('backgroundPosition', str);
      
	});
	
	$('.image').hover(function(){
    $('.slide, .big').show();
  }, function(){
    $('.slide, .big').hide();   
  });
  
  var sum=1;
  $('.add').click(function(){
  	sum++;
  	if(sum>10){sum=10};
  	$('.number').val(sum);
  });
  
  $('.reduce').click(function(){
  	sum--;
  	if(sum<=0){sum=1};
  	$('.number').val(sum);
  })
  
  $('.number').keyup(function(){
  	$('.number').val(1);
  })
})();




//获得地址栏参数值?  cat_id=55&name=xiaoming
function getUrlVal(property){
  //地址栏
  var urlStr = window.location.search.substring(1);
  var re = new RegExp('(^|&)'+ property +'=([^&]*)(&|$)');
  var result = urlStr.match(re);
  if(result == null){return null};
  return result[2];
};

var page =1;
var pagesize=43;


(function(){
	
	$.ajax({
		  type:"POST",
		  url:"/jyhwebstore/advServlet",
		  data:{'msg':comid},
		  dataType:"json",
		  success:function(result){
			 console.log(result[0].comname);
			 var str1;
			 var ur;
				for(var i =0; i <10;i++ )
				{
					ur=result[i].compic.replace(/50x50/g,"100x100");
					str1="<li><img src=\""+ur+"\"class=photo alt=\"\"><p>"+result[i].comname+"</p><p>￥"+result[i].comprice+"</p><a href=product.jsp?comid="+result[i].comid+">查看详情</a></li>"
					;
					console.log(str1);
//					str1="<li><img src=\""+ur+"\" class=photo alt=""><p>"+result[i].comname+"</p>";
					console.log(ur);
//							"<p>￥"+result[i].comprice+"</p>"+
//							"<a href=product.html?comid="+result[i].comid+">查看详情</a></li>";
					$('.floatle ul').append(str1);
		  }
		  }
	})
	
})();

//function goodsList(){
//		$.get('http://www.wjian.top/shop/api_goods.php',{
//			page:page,
//			pagesize:pagesize,
//		},function(result){
//			var json =JSON.parse(result);
//			console.log(json);
//			if(json.code != 0)
//			{
//			  console.log(json.message);
//			  return;
//			}
//			//渲染到页面中
//			// console.log(json);
//			var str=``;
//			for(var i =0; i <json.data.length;i++ )
//			{
//				str=`
//				<li>
//					<img src="${json.data[i].goods_thumb}" class="photo" alt="">
//					<p>${json.data[i].goods_name}</p>
//					<p>${json.data[i].price}</p>
//					<a href="product.html?goods_id=${json.data[i].goods_id}">查看详情</a>
//				</li>
//				`;
//				$('.floatle ul').append(str);
//			}
//		})
//	}
//goodsList(page,pagesize);

