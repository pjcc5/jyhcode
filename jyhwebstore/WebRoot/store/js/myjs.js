// JavaScript Document
$(function(){
	$(window).scroll(function(){
		var toTop=$(window).scrollTop();
		if(toTop>=30){
			$('.mynav').stop().animate({top:'0',opacity:1});
		}else{
			$('.mynav').stop().animate({top:'-80px',opacity:0});	
		}	
	})	
	$('.mynav').singlePageNav();
	
	//$('.navbar-collapse a').click(function(){
	//	$('.navbar-collapse').collapse('hide');	
	//})
	
	// new WOW().init();
//	document.title = 3
})