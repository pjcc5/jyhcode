var choose=document.getElementById('choose');
	var now=choose.getElementsByTagName('li');
	var order=document.getElementsByClassName('order-item');
	var active=order[0].children;
	console.log(active.length);
	console.log(now.length);
	var n=0;
	for(var i=0;i<now.length;i++){
		(function(x){
			
			now[x].onclick=function(){
				n=x;
				
			console.log(n);
			for(var i=0;i<now.length;i++){
				now[i].classList.remove('now')
				
				active[i].classList.remove('active');
			}
			
			now[n].classList.add('now');
			active[n].classList.add('active');
		}
		})(i)
		
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