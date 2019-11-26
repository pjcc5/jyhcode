 function goodsList(page, callback){
    var page = page ? page : 1;
    //页面打开就可以看到商品
    $.get('http://www.wjian.top/shop/api_goods.php',{
      'pagesize':6,
      'page':page,
    }, function(result){
      var result = JSON.parse(result);
      //验证
      if(result.code != 0){
        console.log('数据请求失败');
        return;
      };
      //调用
      callback(result);
    }); 
  };
  var num=0
  goodsList(1, function(result){
    var goodsList = result.data;
    console.log(goodsList)
    //得到数据了之后，在这里操作数据
    //组装DOM结构
    for(var i = 0; i < goodsList.length; i++){
    	var desc=goodsList[i].goods_desc;
      //拿到每一项  goodsList[i].goodsName
      var str = `
      <div class="goods">
			<div class="goods-top">
				<input  type="checkbox" class='select-d'/>
				<p>${goodsList[i].goods_name}</p>
			</div>
			<div class="goods-mid">
				
					<div class="desc">
						
						
						<a href="" class="goods-desc" title="商品信息" >
						<img src="${goodsList[i].goods_thumb}"/>
						<p>${goodsList[i].goods_desc}</p></a>
					
					</div>
					<div class="goods-price">
						<span>${goodsList[i].price}</span></div>
						
					<div class="count">
						<div class="add">+</div>
						<input type="number" value="1" class='number'/>
						<div class="reduce">
							&minus;</div>
							
					
					</div>
					
					<div class="subtotal">${goodsList[i].price}</div>
					<div class="op">
						
						<div><span class="glyphicon glyphicon-heart"></span></div>
						<div><span class="glyphicon glyphicon-trash"></span></div>
					</div>
				
			</div>
			
			
			
			<div class="goods-bottom">
				<div class="amount">商品总价:￥${goodsList[i].price}</div>
			</div>
		</div>
      
      `;
      //把每次组装好的添加进table
      $('.content').append(str);
    };
 
 
 
 var num=0;
$('.number').each(function(){
    
	num++;
	$('.all').html('(共'+num+'件)');
});

var  windowH=$(window).height();
   var   container=
   $('.container').outerHeight(true)+$('.content').outerHeight(true);
     console.log(container);
     console.log(windowH);
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
  });
  
function clickAll(){
	
	$('.main').click(function(event){
		
		
		if(event.target.className=='reduce'){
			  var spanDom = event.target.previousElementSibling;
			  var spanDomVal=parseInt(spanDom.value);
			  console.log(spanDomVal);
			  spanDomVal--;
			  if(spanDomVal < 1){spanDomVal = 1};
			  if(spanDomVal > 200){spanDomVal = 200};
			  spanDom.value=spanDomVal;
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
			
			console.log(event.target.className);
         if(event.target.className=='select'){
         	console.log(event.target.className);
         	
		  if(event.target.checked == true){
		  	
		  	$('.select').each(function(){
		  		 $(this).prop('checked', true);
		  	})
        //选中所有的
        $('.select-d').each(function(){
          $(this).prop('checked', true);
          //给当前元素加个标识(自定义的属性)
          $(this).attr('data-price', 'active');        
        });
        
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
        });
         sumAll();
      };
     }
         console.log(event.target.className);
          if(event.target.className == 'select-d'){
          	$('.select').each(function(){
          		$(this).prop('checked',false);
          	})
      //要做商品减的业务
      //console.log('点击了单选');
      if(event.target.checked == true){
        //给当前元素加个标识(自定义的属性)
        event.target.setAttribute('data-price', 'active');
      }else{
        //拿掉标识(自定义的属性)
        event.target.setAttribute('data-price', '');       
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
  console.log(sum.innerHTML);
  console.log(count);
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
  console.log(s);
  $('.checked').html('已选商品'+s+'件');
  //设置总价
$('.total').html( sum + '.00');




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
	
	
	
	$(function(){
		 var username = localStorage.getItem('username');
		 // alert(username);
		 if(username)
		 {
				//存在就切换文字
				$('#myNav ul').prepend('<li><a href="javascript:;">欢迎您:</a></li>');
				$('.login_title').html(`${username}<span>　　</span>`).css("color",'red');
				// $('#myNav ul').append(`<li><a href='javascript:;' target="_blank" class='quit'>退出</a></li>`);
		}
		
		})