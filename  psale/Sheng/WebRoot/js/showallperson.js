//给表格设置好css，使其隔行换色
var yanse;
$(document).ready(function(){
	$("#personmana tr:odd").css("background","#e7eef8");	
	$("#personmana tr").mouseover(function(){
		 yanse=$(this).css("background");
		$(this).css("background","green");
	});
	
	$("#personmana tr").mouseout(function(){
			$(this).css("background",yanse);
	});
});