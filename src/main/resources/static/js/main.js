//首页下滑
$(document).ready(function() {
	// nav-li hover e
	var num;
	$('.nav-main>li[id]').hover(function() {
		/*图标向上旋转*/
		$(this).children().removeClass().addClass('hover-up');
		/*下拉框出现*/
		var Obj = $(this).attr('id');
		num = Obj.substring(3, Obj.length);
		$('#box-' + num).slideDown(300);
	}, function() {
		/*图标向下旋转*/
		$(this).children().removeClass().addClass('hover-down');
		/*下拉框消失*/
		$('#box-' + num).hide();
	});
	// hidden-box hover e
	$('.hidden-box').hover(function() {
		/*保持图标向上*/
		$('#li-' + num).children().removeClass().addClass('hover-up');
		$(this).show();
	}, function() {
		$(this).slideUp(200);
		$('#li-' + num).children().removeClass().addClass('hover-down');
	});
});

//业绩展示滚动	
marqueeStart();
//js无缝滚动代码
function marquee() {
	var obj = document.getElementById("marquee1");
	var obj1 = document.getElementById("marquee1_1");
	var obj2 = document.getElementById("marquee1_2");
	if (obj2.offsetWidth - obj.scrollLeft <= 0) {
		obj.scrollLeft -= obj1.offsetWidth;
	} else {
		obj.scrollLeft++;
	}
}

function marqueeStart() {
	var obj = document.getElementById("marquee1");
	var obj1 = document.getElementById("marquee1_1");
	var obj2 = document.getElementById("marquee1_2");
	obj2.innerHTML = obj1.innerHTML;
	var marqueeVar = window.setInterval("marquee()", 20);
	obj.onmouseover = function() {
		window.clearInterval(marqueeVar);
	}
	obj.onmouseout = function() {
		marqueeVar = window.setInterval("marquee()", 20);
	}
}

//二级页面轮播
$(function() {
	$("#carousel").carousel({
		interval: 5000
	});
});

//jQuery time
var parent, ink, d, x, y;
$(".nav-left ul li a").click(function(e) {
	parent = $(this).parent();
	//create .ink element if it doesn't exist
	if (parent.find(".ink").length == 0)
		parent.prepend("<span class='ink'></span>");

	ink = parent.find(".ink");
	//incase of quick double clicks stop the previous animation
	ink.removeClass("animate");

	//set size of .ink
	if (!ink.height() && !ink.width()) {
		//use parent's width or height whichever is larger for the diameter to make a circle which can cover the entire element.
		d = Math.max(parent.outerWidth(), parent.outerHeight());
		ink.css({
			height: d,
			width: d
		});
	}

	//get click coordinates
	//logic = click coordinates relative to page - parent's position relative to page - half of self height/width to make it controllable from the center;
	x = e.pageX - parent.offset().left - ink.width() / 2;
	y = e.pageY - parent.offset().top - ink.height() / 2;

	//set the position and add class .animate
	ink.css({
		top: y + 'px',
		left: x + 'px'
	}).addClass("animate");
})
