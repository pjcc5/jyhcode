var msg={};

(function(){
	$.ajax({
		  type:"POST",
		  url:"/jyhwebstore/cartservlet",
		  data:{},
		  dataType:"json",
		  success:function(result){
			 
			  callback(result);

		  }
	})
		  })();



 function callback(result){
	 var total=0;
	 var count=0;
	 var selectcount=0;
	 if(result.length>0){
	msg.shopid=result[0].shopid;
	
    var goodsList = result;
    
    for(var i = 0; i < goodsList.length; i++){
    	
      //拿到每一项  goodsList[i].goodsName
    	
    	var price=goodsList[i].comprice*goodsList[i].count;
    	count=count+goodsList[i].count;
    	console.log("count="+count)
    	var pic=goodsList[i].compic.replace(/50x50/g,"130x130");
    	var selected=goodsList[i].selected;
    	if(selected==1){
    		total=total+goodsList[i].comprice*goodsList[i].count;
    		selectcount=selectcount+goodsList[i].count;
    		console.log("selectcount="+selectcount);
      var str = `
      <div class="goods" data='${goodsList[i].uuid}'>
			<div class="goods-top">
				<input  type="checkbox" class='select-d' checked="checked" data='${goodsList[i].uuid}' choose="${goodsList[i].selected}" data-price="active"/>`;
				
    	}else{
    		var str=`
    		 <div class="goods" data='${goodsList[i].uuid}'>
 			<div class="goods-top">
 				<input  type="checkbox" class='select-d' data='${goodsList[i].uuid}' choose="${goodsList[i].selected}"/>`;
    	}
			var str1=`<p>${goodsList[i].comname}</p>
			</div>
			<div class="goods-mid">
					<div class="desc">
						<a href="" class="goods-desc" title="商品信息" >
						<img src="${pic}"/></a>
						<div>
						<p>颜色: ${goodsList[i].color}</p>
						<p>版本: ${goodsList[i].size}</p>
						</div>
					
					</div>
					<div class="goods-price">
						<span>${goodsList[i].comprice}</span></div>
						
					<div class="count">
						<div class="add">+</div>
						<input type="number" value="${goodsList[i].count}" class='number' data='${goodsList[i].uuid}' choose="${goodsList[i].selected}"/>
						<div class="reduce">
							&minus;</div>
					</div>
					
					<div class="subtotal">${price}</div>
					<div class="op">
						
						<div><span class="glyphicon glyphicon-heart"></span></div>
						<div><span class="glyphicon glyphicon-trash"></span></div>
					</div>
				
			</div>
			<div class="goods-bottom">
				<div class="amount">商品总价:￥${price}</div>
			</div>
		</div>
      
      `;
      //把每次组装好的添加进table
      $('.content').append(str+str1);
      
      
    }
    
    $('.total').html(total+".00");
    $('.all').html("(共"+count+"件)");
    $('.checked').html("已选商品"+selectcount+"件");
    };
 
 
 
 var num=0;


var  windowH=$(window).height();
   var   container=
   $('.container').outerHeight(true)+$('.content').outerHeight(true);
 
     if(container>windowH){
     	$('.nav-pay').removeClass('pay-bottom')
      		$('.nav-pay').removeClass('pay-topr');
      		$('.nav-pay').addClass('pay-bottom');
     }
      $(window).scroll(function(){
      	if(container-$(window).scrollTop()+20<windowH){
      		$('.nav-pay').removeClass('pay-top');
      		$('.nav-pay').removeClass('pay-bottom');
      		$('.nav-pay').addClass('pay-topr');
      		
      	};
      	if(container-$(window).scrollTop()+20>windowH){
      		$('.nav-pay').removeClass('pay-bottom')
      		$('.nav-pay').removeClass('pay-topr');
      		$('.nav-pay').addClass('pay-bottom');
      	}
         if(container-$(window).scrollTop()+20<=0){
         	$('.nav-pay').removeClass('pay-topr');
         	$('.nav-pay').removeClass('pay-bottom');
         	$('.nav-pay').addClass('pay-top');
         }
         
         
      	
      })
      
     
    clickAll();
    
    
   
    };
 
function clickAll(){
	
	$('.main').click(function(event){
		
		
		if(event.target.className=='reduce'){
			  var spanDom = event.target.previousElementSibling;
			  var spanDomVal=parseInt(spanDom.value);
			 
			  spanDomVal--;
			  if(spanDomVal < 1){spanDomVal = 1};
			  if(spanDomVal > 200){spanDomVal = 200};
			  spanDom.value=spanDomVal;
			  
			  var data=spanDom.getAttribute('data');
			  var choose=spanDom.getAttribute('choose');
			  msg.data=data;
			  msg.num=spanDomVal;
			  msg.choose=choose;
			  console.log("msg="+msg.choose);
			  (function(){
					$.ajax({
						  type:"POST",
						  url:"/jyhwebstore/operationcartservlet",
						  data:{"msg":JSON.stringify(msg)},
						  dataType:"json",
						  success:function(result){
							 console.log(result);

						  }
					})
						  })();
			 
			  
			  subtotal(event.target,spanDomVal);
		     sumAll();
		     var num=0;
		     $('.number').each(function(){
		     	
                  
	                  num+=parseInt($(this).val());
	                   $('.all').html('(共'+num+'件)');
                       });
		     
		    
		}
		
		 if(event.target.className == 'add'){
		 	var spanDom = event.target.nextElementSibling;
		 	 var spanDomVal=parseInt(spanDom.value);
		 	 
		 	 
		 	 spanDomVal++;
		 	  if(spanDomVal > 200){spanDomVal = 200};
		 	  if(spanDomVal < 1){spanDomVal = 1};
		 	  spanDom.value=spanDomVal;
		 	  subtotal(event.target,spanDomVal);
		 	 var data=spanDom.getAttribute('data');
		 	 var choose=spanDom.getAttribute('choose');
		 	 msg.choose=choose;
			  msg.data=data;
			  msg.num=spanDomVal;
			  

			  (function(){
					$.ajax({
						  type:"POST",
						  url:"/jyhwebstore/operationcartservlet",
						  data:{"msg":JSON.stringify(msg)},
						  dataType:"json",
						  success:function(result){
							 console.log(result);

						  }
					})
						  })();
		     sumAll();
		      var num=0;
		                 $('.number').each(function(){
		     	
                 
	                  num+=parseInt($(this).val());
	                   $('.all').html('(共'+num+'件)');
                       });
		 }
		 
		 if(event.target.className =='number'){
		 var spanDom=event.target;
		
		 spanDom.onkeyup=function(){	 	
		 	if(parseInt(spanDom.value)>200){
			 
			   spanDom.value=200;
			   
			};
			
			if(spanDom.value<0){
			 
			   spanDom.value=1;
			   
			};
			
			 var choose=spanDom.getAttribute('choose');
			  msg.data=spanDom.getAttribute('data');
			  msg.num=spanDom.value;
			  msg.choose=choose;
			  (function(){
					$.ajax({
						  type:"POST",
						  url:"/jyhwebstore/operationcartservlet",
						  data:{"msg":JSON.stringify(msg)},
						  dataType:"json",
						  success:function(result){
							 console.log(result);

						  }
					})
						  })();
//			
			subtotal(event.target,spanDom.value);
		    sumAll();
		    
		     var num=0;
		                 $('.number').each(function(){
		     	
                 
	                  num+=parseInt($(this).val());
	                   $('.all').html('(共'+num+'件)');
                       });
		 }

		}
			
		
			
			
			
         if(event.target.className=='select'){
         	
		  if(event.target.checked == true){
		  	
		  	$('.select').each(function(){
		  		 $(this).prop('checked', true);
		  	})
        //选中所有的
        $('.select-d').each(function(){
          $(this).prop('checked', true);
          //给当前元素加个标识(自定义的属性)
          $(this).attr('data-price', 'active');
          $(this).attr('choose',1);
          this.parentNode.nextElementSibling.childNodes[5].childNodes[3].setAttribute('choose',1);
        
          
        });
		  	
		    msg.data="";
	          msg.choose=1;
	          msg.num=1;
	          var all="selectall";
	          (function(){
	  			$.ajax({
	  				  type:"POST",
	  				  url:"/jyhwebstore/operationcartservlet",
	  				  data:{"msg":JSON.stringify(msg),"selectall":"selectall"},
	  				  dataType:"json",
	  				  success:function(result){
	  					 console.log(result);

	  				  }
	  			})
	  				  })();
        
        sumAll();
      }else{
      	
      	$('.select').each(function(){
		  		 $(this).prop('checked', false);
		  	})
        //选中所有的
        $('.select-d').each(function(){
          $(this).prop('checked', false);
          //拿掉标识(自定义的属性)
          $(this).attr('data-price', '');
          
          $(this).attr('choose',0);
          this.parentNode.nextElementSibling.childNodes[5].childNodes[3].setAttribute('choose',0);
          
        });
      	
      	 msg.data="";
         msg.choose=0;
         msg.num=1;
         var all="selectall";
         (function(){
 			$.ajax({
 				  type:"POST",
 				  url:"/jyhwebstore/operationcartservlet",
 				  data:{"msg":JSON.stringify(msg),"selectall":"selectall"},
 				  dataType:"json",
 				  success:function(result){
 					 console.log(result);

 				  }
 			})
 				  })();
         sumAll();
      };
     }

          if(event.target.className == 'select-d'){
          	$('.select').each(function(){
          		$(this).prop('checked',false);
          	})
      //要做商品减的业务
      //console.log('点击了单选');
      if(event.target.checked == true){
        //给当前元素加个标识(自定义的属性)
        event.target.setAttribute('data-price', 'active');
        event.target.setAttribute('choose',1);
        event.target.parentNode.nextElementSibling.childNodes[5].childNodes[3].setAttribute('choose',1);
        msg.data=event.target.getAttribute('data');
        msg.choose=1;
        msg.num=event.target.parentNode.nextElementSibling.childNodes[5].childNodes[3].value;
        	
        (function(){
			$.ajax({
				  type:"POST",
				  url:"/jyhwebstore/operationcartservlet",
				  data:{"msg":JSON.stringify(msg)},
				  dataType:"json",
				  success:function(result){
					 console.log(result);

				  }
			})
				  })();
        
        
      }else{
        //拿掉标识(自定义的属性)
    	  var pars= event.target.setAttribute('data-price', '');   
    	  event.target.setAttribute('choose',0);
    	  event.target.parentNode.nextElementSibling.childNodes[5].childNodes[3].setAttribute('choose',0);
    	  
    	  msg.data=event.target.getAttribute('data');
          msg.choose=0;
          msg.num=event.target.parentNode.nextElementSibling.childNodes[5].childNodes[3].value;
          (function(){
  			$.ajax({
  				  type:"POST",
  				  url:"/jyhwebstore/operationcartservlet",
  				  data:{"msg":JSON.stringify(msg)},
  				  dataType:"json",
  				  success:function(result){
  					 console.log(result);

  				  }
  			})
  				  })();
          
      }
      //求总价
      sumAll();
    };
    
    if(event.target.className =="glyphicon glyphicon-trash"){
    
    	
      //要做商品减的业务
      console.log('点击了删除');
    
      //找到tr删除自己
      var tab = event.target.parentNode.parentNode.parentNode.parentNode.parentNode;
    var tr = event.target.parentNode.parentNode.parentNode.parentNode;
    
    var data=tr.getAttribute('data');
	  msg.data=data;
	  msg.num=-1;
	  msg.choose=0;
	  (function(){
			$.ajax({
				  type:"POST",
				  url:"/jyhwebstore/operationcartservlet",
				  data:{"msg":JSON.stringify(msg)},
				  dataType:"json",
				  success:function(result){
					 console.log(result);

				  }
			})
				  })();
	  
        tab.removeChild(tr);
      //$(event.target).html('哈另一个')
      //调用总价
      sumAll();
      
       var num=0;
		                 $('.number').each(function(){
		     	
                 
	                  num+=parseInt($(this).val());
	                   $('.all').html('(共'+num+'件)');
                       });
    };  
    




	})
}

function subtotal(that, count){
  //拿到单价
  var price = that.parentNode.previousElementSibling.firstElementChild.innerHTML;
  //拿到小计元素
  var subtotalDom = that.parentNode.nextElementSibling;
  //设置
  var sum=subtotalDom.parentNode.nextElementSibling.firstElementChild;

subtotalDom.innerHTML = price * count + '.00';
sum.innerHTML='商品总价:￥'+price * count + '.00';
};

function sumAll(){
 var sum = 0;
 var s=0;
  //拿到所的   active
  $('[data-price="active"]').each(function(){
    sum += parseInt($(this).parent().siblings('.goods-mid').children('.subtotal').html());
    s+=parseInt($(this).parent().siblings('.goods-mid').find('.number').val());
  });

  $('.checked').html('已选商品'+s+'件');
  //设置总价
$('.total').html( sum + '.00');




}


$('.check-out').click(function(){
	location.href="/jyhwebstore/store/html/ordersubmit.jsp";
})

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
  	
  	
  


$(function(){
	// 查找有没有登录
	var username = localStorage.getItem('username');
	if(username)
	{
		$('.login').html(`${username}`).css('color','red');
		$('.quit-father').append(`<a href='javascript:;' class='quit'>退出</a>`);
	}
})
// 点击退出
$('.quit').click(function(){
		localStorage.removeItem('username');
		location.reload();
	}); 