//给表格设置好css，使其隔行换色
var yanse;
$(document).ready(function(){
	$("#reporttip").hide();
	$("tr:odd").css("background","#e7eef8");	
	$("tr").mouseover(function(){
		 yanse=$(this).css("background");
		$(this).css("background","grey");
	});
	$("tr").mouseout(function(){
			$(this).css("background",yanse);
	});
	
	//用于导出pdf时的脚本控制
	$("#pdf").click(function(){
	    var x=$(window).width();
		var y=$(window).height();
		var scrollleft=$(window).scrollLeft();
		var scrolltop=$(window).scrollTop();
		var sx=parseFloat($("#reporttip").css("width"));
		var sy=parseFloat($("#reporttip").css("height"));
		var realx=(x+scrollleft-sx)/2;
		var realy=(y+scrolltop-sy)/2;
		$("#reporttip").css("left",realx);
		$("#reporttip").css("top",realy);
		$("#reporttip").fadeIn(1000).delay(5000).fadeOut(1000);
	});
});

