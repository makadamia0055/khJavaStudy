/* 롤링 관련 이벤트 */
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
	
});
//페이지네이션 버튼 이벤트
$(function(){
	$('.box-shop-in .btn-prev').click(function(e){
		e.preventDefault();
		let boxShopIn = $(this).parents('.box-shop-in');
		let curPage = boxShopIn.find('.current-page').first().text();
		let maxPage = boxShopIn.find('.max-page').first().text();
		curPage = +curPage;
		curPage = --curPage == 0 ? maxPage : curPage;
		boxShopIn.find('.current-page').text(curPage);
	});
	$('.box-shop-in .btn-next').click(function(e){
		e.preventDefault();
		let boxShopIn = $(this).parents('.box-shop-in');
		let curPage = boxShopIn.find('.current-page').first().text();
		let maxPage = boxShopIn.find('.max-page').first().text();
		curPage = +curPage;
		curPage = ++curPage > maxPage ? 1 : curPage;
		boxShopIn.find('.current-page').text(curPage);
	});
});
//왼쪽 두번째 뉴스 리스트 버튼 관리
$(function(){

	selectNewsList($('.box-body-left2 .list-press').eq(3))

	$('.box-body-left2 .btn-prev').click(function(e){
		e.preventDefault();
		let obj = $('.box-body-left2 .list-press.selected');
		if(obj.prev().length != 0){
			selectNewsList(obj.prev());
		}
	});
	$('.box-body-left2 .btn-next').click(function(e){
		e.preventDefault();
		let obj = $('.box-body-left2 .list-press.selected');
		if(obj.next().length == 0 || !obj.next().hasClass('list-press'))
			return;
		selectNewsList(obj.next());
	});
});
//왼쪽3번째 컨텐츠 관련 이벤트
$(function(){
	$('.box-body-left3 .box-menu .btn-menu').click(function(e){
		e.preventDefault();
		$('.box-body-left3 .box-menu .item-menu .btn-menu').attr('aria-selected',false);
		$(this).attr('aria-selected',true);
		if($(this).parent().prev().length == 0){
			$('.box-body-left3 .btn-prev').hide();
		}else{
			$('.box-body-left3 .btn-prev').show();
		}
		if($(this).parent().next().length == 0){
			$('.box-body-left3 .btn-next').hide();
		}else{
			$('.box-body-left3 .btn-next').show();
		}
	})
	$('.box-body-left3 .btn-next').click(function(e){
		e.preventDefault();
		let obj = $('.box-body-left3 .box-menu .item-menu .btn-menu').filter('[aria-selected=true]')
		if(obj.parent().next().length != 0)
			obj.parent().next().children().click();
		
		if(obj.hasClass('living')){
			obj.parents('.list-menu').animate({
				marginLeft : '-185px'
			}, 500);
		}
	})
	$('.box-body-left3 .btn-prev').click(function(e){
		e.preventDefault();
		let obj = $('.box-body-left3 .box-menu .item-menu .btn-menu').filter('[aria-selected=true]')
		if(obj.parent().prev().length != 0)
			obj.parent().prev().children().click();
		
		if(obj.hasClass('car')){
			obj.parents('.list-menu').animate({
				marginLeft : '0px'
			}, 500);
		}
	})
});
//메뉴 관련 이벤트
$(function(){
	$('.group-menu .btn-more').click(function(e){
		e.preventDefault();
		$(this).toggleClass('fold');
		$('.container-menu .container-service').toggle();
		$('.group-menu .box-btn-area').toggle();
		setMenuServiceBtn(true);
	});
	$('.group-menu .box-btn-area .btn-set').click(function(e){
		e.preventDefault();
		setMenuServiceBtn();
	})
})


let selectedMenuArr = []; 
function setMenuServiceBtn(flag){
	$('.group-menu .box-btn-area .btn').removeClass('display-none');
	$('.container-service .group-service').removeClass('display-none');

	if(selectedMenuArr.length==0){
		$('.container-menu .list-favority-menu').removeClass('display-none')
	}else{
		$('.container-menu .list-selecte-menu').removeClass('display-none')
	}
		$('.container-menu .list-empty-box').removeClass('display-none');

	if(flag){
		$('.group-menu .box-btn-area .btn-reset').addClass('display-none');
		$('.group-menu .box-btn-area .btn-save').addClass('display-none');
		$('.container-service .group-service').last().addClass('display-none');
		$('.container-menu .list-empty-box').addClass('display-none');
	}else{
		$('.group-menu .box-btn-area .btn-set').addClass('display-none');
		$('.group-menu .box-btn-area .btn-favorite-all').addClass('display-none');
		$('.container-service .group-service').first().addClass('display-none');
		$('.container-menu .list-favority-menu').addClass('display-none');
		
		//리셋버튼
		let tmpMenuArr = selectedMenuArr.slice(); // 깊은복사
		$('.group-menu .box-btn-area .btn-reset').click(function(){ // 초기화 버튼
			selectedMenuArr = [];
			tmpMenuArr=[];
			clearMenuItem();
		});

		$('.group-service input[type=checkbox]').click(function(){
			let tmpValue=$(this).val();
			if($(this).prop('checked')){ // 최대 개수 예외처리
				if(tmpMenuArr.length>=4){
					alert('최대 4개까지 설정할 수 있습니다.')
					$(this).prop('checked', false);

				}else{ // 입력
					if(!tmpMenuArr.includes(tmpValue)){
						tmpMenuArr.push(tmpValue);
						clearMenuItem();
						addMenuItem(tmpMenuArr);

					}
				}
			}else{ // 삭제
				tmpMenuArr = tmpMenuArr.slice(0, tmpMenuArr.indexOf(tmpValue)).concat(tmpMenuArr.slice(tmpMenuArr.indexOf(tmpValue)+1))
				clearMenuItem();
				addMenuItem(tmpMenuArr);
			}

		})
		$('.group-menu .box-btn-area .btn-save').click(function(){
			selectedMenuArr = tmpMenuArr.slice();
			if(selectedMenuArr.length==0){
				alert('선택된 메뉴가 없습니다. 초기설정으로 돌아갑니다.');
				$('.group-menu .list-favority-menu').removeClass('display-none');
				$('.group-menu .list-selecte-menu').addClass('display-none');
				// $('.group-menu .btn-more').click();
			}else{
				$('.group-menu .list-favority-menu').addClass('display-none');
				$('.group-menu .list-selecte-menu').removeClass('display-none');
				$('.container-menu .list-empty-box').addClass('display-none');
				// $('.group-menu .btn-more').click();
				$(selectedMenuArr).each(function(index, item){
					$('.group-menu .list-selecte-menu .item-selected-menu').eq(index).children().first().text(`${item}`);
				})
			}
		})
	}
}


function addMenuItem(arr){ // 텍스트 입력 및 다음 칸으로 셀렉트 넘기는 메소드
	$(arr).each(function(index, item){
		$('.list-empty-box .item-box').eq(index).text(`${item}`).removeClass('select').next().addClass('select');
	})
}
function clearMenuItem(){ // 초기화 메소드
	$('.list-empty-box .item-box').text('').removeClass('select').first().addClass('select');
}


/*
박스에 작업하기
tmp배열과 최종 배열까지
배열이 2개 필요함. 
저장 버튼을 눌렀을 때 tmpArr의 값이 최종 배열의 값으로 옮겨가게.
최종 배열이 비어있으면 기본 메뉴를 출력해줌.
아니면 최종 배열의 값을 적용. select 메뉴에 
초기화를 누르면 최종배열 초기화


*/ 

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
	el.addClass('selected')
	if(el.prev().length == 0){
		$('.box-body-left2 .btn-prev').hide();
	}else{
		$('.box-body-left2 .btn-prev').show();
	}
	if(el.next().length == 0 || !el.next().hasClass('list-press')){
		$('.box-body-left2 .btn-next').hide();
	}else{
		$('.box-body-left2 .btn-next').show();
	}
}