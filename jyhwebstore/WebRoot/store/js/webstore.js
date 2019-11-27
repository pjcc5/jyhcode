  var n = 0;//信号量
  $('.number span').mouseover(bannergo);
  function bannergo(i){
  	  n=$(this).index();
  	  $('.banner>ul>li').eq(n).fadeIn(500).siblings().fadeOut(500);
  	  $('.number span').eq(n).addClass('current').siblings().removeClass('current');
	  }
  // 自动翻页
  // $('.banner').
  // 浮动导航栏
  $(function(){
	  //显示当前位置
	  if(document.getElementById("location"))
	    {
		  if (navigator.geolocation){
			    navigator.geolocation.getCurrentPosition(showPosition,showError);
			  }else{
				 
			  }
		 }
	  
	  
	  
	  
	  
  	$(window).scroll(function(){
  		var toTop=$(window).scrollTop();
  		if(toTop>=50){
  			$('.mynav').stop().slideDown(500);
  		}else{
  			$('.mynav').stop().slideUp(500);	
  		}	
		
		if($(document).scrollTop() < 500)
		{	
			$('#top').fadeOut(1000);
		}else{
			$('#top').fadeIn(1000);
		}
				
  	})
  	$('#top').click(function(){
  			// $(document).scrollTop(0);
  			// $('#top').fadeOut(1000);
  			$('body,html').animate({'scrollTop':0},500);
  		});
  })
  
  //获取商品信息添加到导航栏
//  $(function(){
//	 
//	  $.get('http://www.wjian.top/shop/api_cat.php',{},function(result){
//		  var json =JSON.parse(result);
//		  console.log(json);
//		  if(json.code != 0)
//		  {
//			  console.log(json.message);
//			  return;
//		  }
//		  //遍历数据
//		  var str = ``;
//		  // 加密分类
//		 
//		 
//		  for(var i=0; i<json.data.length ;i++)
//		  {	
//			   var classi = encodeURI(json.data[i].cat_name);
//			   // console.log(json.data[i]);
//			  str+=`
//			  <li><a target="_blank" href="classify.html?cat_id=${json.data[i].cat_id}&&cat_name=${classi}">${json.data[i].cat_name}</a></li>
//			  `;
//		  }
//		  // console.log(str);
//		  $('.nav-list').append(str);
//		  
//		  
//	  });
//  });
//  
//	//请求商品方法
//	var page =1;
//	var pagesize=12;
//	function goodsList(){
//		$.get('http://www.wjian.top/shop/api_goods.php',{
//			page:page,
//			pagesize:pagesize,
//		},function(result){
//			var json =JSON.parse(result);
//			// console.log(json);
//			if(json.code != 0)
//			{
//			  console.log(json.message);
//			  return;
//			}
//			//渲染到页面中
//			console.log(json);
//			var str=``;
//			for(var i =0; i <json.data.length;i++ )
//			{
//				str=`
//				<div class="goods">
//					<img src="${json.data[i].goods_thumb}" alt="">
//					<p class="goodsname">${json.data[i].goods_name}</p>
//					<p>${json.data[i].goods_desc}</p>
//					<p>${json.data[i].price}</p>
//					<p><span class="glyphicon  glyphicon-star"></span>${json.data[i].star_number}</p>
//					<a href='product.html?goods_id=${json.data[i].goods_id}' class="content_a">
//						<div class="cover">
//							<p class="goodsdecoration">${json.data[i].goods_desc}</p>
//							<p class="price">只要${json.data[i].price}元</p>
//						</div>
//					</a>
//					<button type="button" class="btn btn-danger addincart"><span class="
//glyphicon glyphicon-download-alt"></span>　加入购物车</button>
//				</div>
//				
//				`;
//				$('.goods-top').append(str);
//			}
//		})
//	}
//	goodsList();
//	
//	
//	// 点击加载更多
//	$('.loadmore').click(function(){
//		page++;
//		goodsList();
//	});
	
	// 搜索按钮
	$('.search-btn').click(function(){
		// console.log("点击了搜索");
		var searchText = $('.search-input').val();
		var text =encodeURI(searchText);
		// alert(text);
		window.location.href=`search.html?content=${text}`;
	});
	//回车登录
	$('#searchIn1').keydown(function(event){
		if(event.keyCode ==13)
		{
			var searchText = $('#searchIn1').val();
			var text =encodeURI(searchText);
			window.location.href=`search.html?content=${text}`;
		}
		
	});
	$('#searchIn2').keydown(function(event){
		if(event.keyCode ==13)
		{
			var searchText = $('#searchIn2').val();
			var text =encodeURI(searchText);
			window.location.href=`search.html?content=${text}`;
		}
		
	});
// 鼠标移入全部分类显示商品分类
$('.all-items').mouseover(function(){
	$('.allclassify').stop().slideDown(500);
	$('.hover-forward span').removeClass('glyphicon-chevron-down').addClass('glyphicon-chevron-up');
	
});
$('.all-items').mouseleave(function(){
	$('.allclassify').stop().slideUp(500);
	$('.hover-forward span').removeClass('glyphicon-chevron-up').addClass('glyphicon-chevron-down');
});
//切换下一张的方法
function next(){
	n++;
	if(n > 3)
	{
		n=0;
	}
	$('.banner>ul>li').eq(n).fadeIn(500).siblings().fadeOut(500);
	$('.number span').eq(n).addClass('current').siblings().removeClass('current');
	
}
//轮播图自动切换
var timer;
$('.banner').mouseover(function(){
	clearInterval(timer);
});
$('.banner').mouseleave(function(){
	
	console.log(n);
		timer = setInterval(next,2000);
});



//一开始就获取用户名通过localStorage
 $(function(){
	 var username = localStorage.getItem('username');
	 // alert(username);
	 if(username)
	 {
			//存在就切换文字
			$('#goodnight').html('欢迎您:');
			$('#log').html(`${username}<span>　　</span>`);
			$('.quit-father').append(`<a href='javascript:;' class='quit'>退出</a>`);
	}
	$('.quit').click(function(){
		localStorage.removeItem('username');
		location.reload();
	}); 
	})