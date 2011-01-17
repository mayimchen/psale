//插件1
	(function($){
		//插件一
		$.fn.getpos=function(l,showdiv,rootdiv){	
		var tt=l.top-35+document.body.scrollLeft;
		var ll=l.left+130+document.body.scrollTop;
		$("#"+showdiv)[0].style.left=ll+"px";
		$("#"+showdiv)[0].style.top=tt+"px";
		$("#"+showdiv).show();
		$("#"+rootdiv).addClass("username");
		}	
		//插件二
		$.fn.hidediv=function(hidediv,rootdiv){
			$("#"+hidediv).hide();
			$("#"+rootdiv).removeClass("username");
		}
		
	})(jQuery);
