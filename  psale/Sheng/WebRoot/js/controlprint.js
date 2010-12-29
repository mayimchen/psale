//打印控制的脚本
$(document).ready(function(){
		$("#pint").click(function(){
			$(this).hide();
			window.print();	
		});
});