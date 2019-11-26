(function(){
var goodsId = getUrlVal('goods_id');
  //发起请求
  // alert(goodsId);
  $.get('http://www.wjian.top/shop/api_goods.php', {
    goods_id : goodsId,
  }, function(result){
    var obj = JSON.parse(result);
    // console.log(obj)
    var goods = obj.data[0];
	$('.product-name').html(`${obj.data[0].goods_name}`);
    var str = `
     <p class="name">${goods.goods_name}</p>
			<p class="price"><span>价格</span><span class="price-m">￥${goods.price}</span></p>
			<p class="desc"><span>描述</span><span class="desc-p">${goods.goods_desc}</span></p>
			<div class="hot"><span>热度</span><span class="hot-p"><span class="glyphicon glyphicon-heart"></span>${goods.star_number}</span>
    `;
    var img=`<img src="${goods.goods_thumb}"/>`;
    $('.info').html(str);
    $('.image').append(img);
    console.log(`${goods.goods_thumb}`);
    $('.big').css({
    	background:`url(${goods.goods_thumb}) no-repeat`,
    	'background-size':	'1000px 1000px' 
    })
//  //页面有数据按钮才能点击
//  addCart();
  });
})();





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
})()

//获得地址栏参数值?  cat_id=55&name=xiaoming
function getUrlVal(property){
  //地址栏
  var urlStr = window.location.search.substring(1);
  var re = new RegExp('(^|&)'+ property +'=([^&]*)(&|$)');
  var result = urlStr.match(re);
  if(result == null){return null};
  return result[2];
};

var page =parseInt(Math.random()*50);
var pagesize=43;
function goodsList(){
		$.get('http://www.wjian.top/shop/api_goods.php',{
			page:page,
			pagesize:pagesize,
		},function(result){
			var json =JSON.parse(result);
			console.log(json);
			if(json.code != 0)
			{
			  console.log(json.message);
			  return;
			}
			//渲染到页面中
			// console.log(json);
			var str=``;
			for(var i =0; i <json.data.length;i++ )
			{
				str=`
				<li>
					<img src="${json.data[i].goods_thumb}" class="photo" alt="">
					<p>${json.data[i].goods_name}</p>
					<p>${json.data[i].price}</p>
					<a href="product.html?goods_id=${json.data[i].goods_id}" target="_blank">查看详情</a>
				</li>
				`;
				$('.floatle ul').append(str);
			}
			
		})
	}
	
goodsList(page,pagesize);

//搜索
$('.search-btn').click(function(){
		// console.log("点击了搜索");
		var searchText = $('.search-input').val();
		var text =encodeURI(searchText);
		// alert(text);
		window.location.href=`search.html?content=${text}`;
	});
	
	
	$(function(){
		 var username = localStorage.getItem('username');
		 // alert(username);
		 if(username)
		 {
				//存在就切换文字
				$('#myNav ul').prepend('<li><a href="javascript:;">欢迎您:</a></li>');
				$('.login_title').html(`${username}<span>　　</span>`).css("color",'red');
				$('#myNav ul').append(`<li><a href='javascript:;' target="_blank" class='quit'>退出</a></li>`);
		}
		$('.quit').click(function(){
			localStorage.removeItem('username');
			location.reload();
		}); 
		})