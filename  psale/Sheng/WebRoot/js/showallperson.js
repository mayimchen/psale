//给表格设置好css，使其隔行换色
var yanse;
$(document).ready(function(){
	$("#personmana tr:odd").css("background","#e7eef8");	
	$("#personmana tr").mouseover(function(){
		 yanse=$(this).css("background");
		$(this).css("background","grey");
	});
	
	$("#personmana tr").mouseout(function(){
			$(this).css("background",yanse);
	});
	
	$("#personmana a").each(function(index){
				var _this=$(this);
				_this.mouseover(function(){
					_this.css("background","white");
				});
				_this.mouseout(function(){
					_this.css("background",yanse);
				});
	});
});