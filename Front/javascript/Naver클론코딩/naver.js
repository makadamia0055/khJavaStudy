$(function(){
	$('.box-body-right2 .btn-next').click(function(e){
		e.preventDefault();
		moveLeft(liRight2, ulRight2, timeRight2);
	});
	
	$('.box-body-right2 .btn-prev').click(function(e){
		e.preventDefault();
		moveRight(liRight2, ulRight2, timeRight2);
	});
	
	
	$('.box-body-right2').hover(function(){
		clearInterval(rollingRight2);
	}, function(){
		rollingRight2 = rollingLeft(rollingObjRigh2.li, rollingObjRigh2.ul, rollingObjRigh2.time, rollingObjRigh2.duration);
	});
	
	$('.box-body-left2 .list-issue').hover(function(){
		clearInterval(rollingLeft2);
	}, function(){
		rollingLeft2 = rollingTop(rollingObjLeft2);
	});
	
	$('.box-body-right4 .box-btn .btn-next').click(function(e){
		e.preventDefault();
		let currentNum = $('.box-body-right4 .box-pagination .box-page em').text();
		if(currentNum==6){
			currentNum = 6;
		}else{
			currentNum++;
		}
		$('.box-body-right4 .box-pagination .box-page em').text(currentNum);
	})
	$('.box-body-right4 .box-btn .btn-prev').click(function(e){
		e.preventDefault();
		let currentNum = $('.box-body-right4 .box-pagination .box-page em').text();
		if(currentNum==1){
			currentNum = 1;
		}else{
			currentNum--;
		}
		$('.box-body-right4 .box-pagination .box-page em').text(currentNum);
	})

	


});

// 왼쪽 두번째 뉴스 리스트 버튼 관리
$(function(){
	selectNewsList($('.box-body-left2 .list-press').eq(3));

	$('.box-body-left2 .btn-prev').click(function(e){
		e.preventDefault();
		let obj = $('.box-body-left2 .list-press.selected');
		if(obj.prev().length!=0){
			selectNewsList(obj.prev());
		}
	})
	$('.box-body-left2 .btn-next').click(function(e){
		e.preventDefault();
		let obj = $('.box-body-left2 .list-press.selected');
		if(obj.next().length==0|| !obj.next().hasClass('list-press')){
			return
		}
		selectNewsList(obj.next());
	})
	
});


// 왼쪽 3번째 컨텐츠 관련 이벤트
$(function(){
	$('.box-body-left3 .box-in .item-menu .btn-menu').click(function(e){
		e.preventDefault();
		$('.box-body-left3 .box-in .item-menu .btn-menu').attr('aria-selected', 'false');
		$(this).attr('aria-selected', 'true');
		left3MoveBox($('.box-body-left3 .box-in .item-menu .btn-menu[aria-selected="true"]'))
	
	})

	$('.box-body-left3 .box-btn .btn-prev').click(function(e){
		e.preventDefault();
		let current = $('.box-body-left3 .box-in .item-menu .btn-menu[aria-selected="true"]');
		// left3Roll(current);
		current.parent().prev().children().click();	
		left3MoveBox($('.box-body-left3 .box-in .item-menu .btn-menu[aria-selected="true"]'))
		if(current.hasClass('car')){
			current.parents('.list-menu').animate({
				marginLeft : '0px'
			}, 500)
		}
	})
	$('.box-body-left3 .box-btn .btn-next').click(function(e){
		e.preventDefault();
		let current = $('.box-body-left3 .box-in .item-menu .btn-menu[aria-selected="true"]');
		// left3Roll(current);
		current.parent().next().children().click();	
		left3MoveBox($('.box-body-left3 .box-in .item-menu .btn-menu[aria-selected="true"]'))
		if(current.hasClass('living')){
			current.parents('.list-menu').animate({
				marginLeft : '-185px'
			}, 500)
		}
	})
})


//메뉴 관련 이벤트
$(function(){
	$('.group-menu .btn-more').click(function(e){
		e.preventDefault();
		$(this).toggleClass('fold');
	})
})



// $(function(){
// 	$('.container-menu .btn-more').click(function(e){
// 		e.preventDefault();
// 		if(!$(this).hasClass('selected')){
// 			$(this).css({'color':'#0ecd5a'}).text('접기').toggleClass('selected');
// 			$('.group-menu .icon-more').css('background-position', '-420px -402px')
// 		}else{
// 			$(this).css({'color':'#000'}).text('더보기').toggleClass('selected');
// 		}
// 	})
// })

// function left3Roll(el){
// 	let rolled = $('.box-body-left3 .list-menu').css('margin-left')=='0px'?false:true;
// 	if($(el).attr('aria-selected')&&el.hasClass('living')&&!rolled){
// 		$('.box-body-left3 .list-menu').animate({'margin-left':'-185px'}, 1000);
// 	}
// 	if($(el).attr('aria-selected')&&el.hasClass('car')&&rolled){
// 		$('.box-body-left3 .list-menu').animate({'margin-left':'0px'}, 1000);
// 	}
// }



let liRight2 = '.box-body-right2 .item-stock';
let ulRight2 = '.box-body-right2 .list-stock';
let timeRight2 = 1000;
let durationRight2 = 2000;

let rollingObjRigh2 = {
	li : '.box-body-right2 .item-stock',
 	ul : '.box-body-right2 .list-stock',
	time : 1000,
	duration : 2000
}
let rollingObjLeft2 = {
	liSelector : '.box-body-left2 .item-issue',
	ulSelector : '.box-body-left2 .list-issue',
	duration : 2000,
	animationTime : 1000
}
let rollingRight2 = rollingLeft(rollingObjRigh2.li, rollingObjRigh2.ul, rollingObjRigh2.time, rollingObjRigh2.duration);
let rollingLeft2 = rollingTop(rollingObjLeft2);

function moveLeft(liSelector, ulSelector, time){
	let width = $(liSelector).first().innerWidth();
	if(!$(liSelector).first().is(':animated')){
		$(liSelector).first().animate({
			marginLeft : `-${width}px`
		},time, function(){
			$(this).detach().appendTo(ulSelector).removeAttr('style');
		});
	}
}
function moveRight(liSelector, ulSelector, time){
	let width = $(liSelector).first().innerWidth();
	if(!$(liSelector).first().is(':animated')){
		$(liSelector)
			.last()
			.detach()
			.prependTo(ulSelector)
			.css('marginLeft',`-${width}px`)
			.animate({
				marginLeft : 0
			}, time);
	}
}
function rollingLeft(liSelector, ulSelector, animationTime, duration){
	return setInterval(moveLeft,duration,liSelector, ulSelector, animationTime);
}
function moveTop(liSelector, ulSelector, animationTime){
	let height = $(liSelector).first().innerHeight();
	if(!$(liSelector).first().is(':animated')){
		$(liSelector).first().animate({
				marginTop : `-${height}px`
			}, animationTime, function(){
				$(this).detach().appendTo(ulSelector).removeAttr('style');
			});
	}
}
function rollingTop(rollingObj){
	return setInterval(moveTop,rollingObj.duration,rollingObj.liSelector, 
		rollingObj.ulSelector, rollingObj.animationTime);
}


function selectNewsList(el){
	$('.box-body-left2 .list-press').removeClass('selected').hide();
	el.show();
	el.addClass('selected');
	if(el.prev().length==0){
		$('.box-body-left2 .btn-prev').hide();
	}else{
		$('.box-body-left2 .btn-prev').show();

	}
	if(el.next().length==0 || !el.next().hasClass('list-press')){
		$('.box-body-left2 .btn-next').hide();
	}else{
		$('.box-body-left2 .btn-next').show();
	}
}

function left3MoveBox(el){
	if($(el).parent().index()==0){
		$('.box-body-left3 .box-btn .btn-prev').hide();
	}else{
		$('.box-body-left3 .box-btn .btn-prev').show();
	}
	if($(el).parent().index()==9){
		$('.box-body-left3 .box-btn .btn-next').hide();
	}else{
		$('.box-body-left3 .box-btn .btn-next').show();
	}
}