var catId = getUrlVal('cat_id');
var classi =decodeURI(getUrlVal('cat_name')) ;
// console.log(classi);
// 添加商品分类当前位置
$('.name').html(`${classi}`);
	var Page = 1;
	var Pagesize =12;

function getgoodlist(Pa,Ps){
	$.get('http://www.wjian.top/shop/api_goods.php',{
		  cat_id : catId,
		  page : Pa,
		  pagesize :Ps,
		},function(result){
			
			var json =JSON.parse(result);
			// console.log(json);
			//验证
			if(json.code != 0){
			  console.log(obj.message);
			  alert('商品稍后上架...');
			  return;
			};
			// 显示当前位置分类列表
			// $()
			var str=``;
			for(var i =0; i <json.data.length;i++ )
						{
							str+=`
							<div class="goods">
								<img src="${json.data[i].goods_thumb}" alt="">
								<p class="goodsname">${json.data[i].goods_name}</p>
								<p>${json.data[i].goods_desc}</p>
								<p>${json.data[i].price}</p>
								<p><span class="glyphicon  glyphicon-star"></span>${json.data[i].star_number}</p>
								<a href="" class="content_a">
									<div class="cover">
										<p class="goodsdecoration">${json.data[i].goods_desc}</p>
										<p class="price">只要${json.data[i].price}元</p>
									</div>
								</a>
								<button type="button" class="btn btn-danger addincart"><span class="
			glyphicon glyphicon-download-alt"></span>　加入购物车</button>
							</div>
							`;
							
						}
						$('.goods-top').html(str);
						$(document).scrollTop(0);

}	)

}	




//获得地址栏参数值?  cat_id=55&name=xiaoming
function getUrlVal(property){
  //地址栏
  var urlStr = window.location.search.substring(1);
  var re = new RegExp('(^|&)'+ property +'=([^&]*)(&|$)');
  var result = urlStr.match(re);
  if(result == null){return null};
  return result[2];
};

// 按钮点击
var i = 1;
		$('.prev').click(function(){
			i--;
			if(i < 1)
			{
				i = 1;
			}
			getgoodlist(i,12);
			$('.pagenum').html(i);
			$('.numberspan').val(i);
		});
		$('.next').click(function(){
			
			i++;
			if(i >=200)
			{
				i = 1;
			}
			getgoodlist(i,12);
			$('.pagenum').html(i);
			$('.numberspan').val(i);
			
		});
		$('.go').click(function(){
			
			i = parseInt($('.numberspan').val());
			if(i < 1)
			{
				i=1;
			}
			getgoodlist(i,12);
			$('.pagenum').html(i);
			$('.numberspan').val(i);
		});
//一开始就加载第一页
getgoodlist(1,12);


//一开始就获取用户名通过localStorage
 $(function(){
	 var username = localStorage.getItem('username');
	 // alert(username);
	 if(username)
	 {
			//存在就切换文字
			$('#goodnight').html('欢迎您:');
			$('#log').html(`${username}<span>　</span>`);
			$('.quit-father').append(`<a href='javascript:;' class='quit'>退出</a>`);
	}
	$('.quit').click(function(){
		localStorage.removeItem('username');
		location.reload();
	}); 
	})