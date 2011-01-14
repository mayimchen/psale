// JavaScript Document
var i = 0;
$(document).ready(function() {
	$("#sysmessage").hide();
	$("#menu").hide();
	$("#logoutdiv").hide();
	$("#saveandbackdiv").hide();
	$("#login,#aboutsys,#tip,#copyright,#menu a").mouseover(function() {
		$(this).css("background", "red");
	});
	$("#login,#aboutsys,#tip,#copyright,#menu a").mouseout(function() {
		$(this).css("background", "none");
	});
	
	$("#logout").mouseover(function(){
		$(this).css("background", "red");
	});
	
	$("#logout").mouseout(function(){
		$(this).css("background", "none");
	});
	
	$("#systitle img").click(function() {
		$("#sysmessage").animate( {
			left : "0px",
			top : "0px",
			opacity : "hide"
		}, 1000);
	});
	//点击关于本系统的效果
		$("#aboutsyslink").click(function() {
			var winx = $(window).width();
			var winy = $(window).height();
			var scrollleft = $(window).scrollLeft();
			var scrolltop = $(window).scrollTop();
			var x = parseFloat($("#sysmessage").css("width"));
			var y = parseFloat($("#sysmessage").css("height"));
			var realx = (winx + scrollleft - x) / 2;
			var realy = (winy + scrolltop - y) / 2;
			$("#sysmessage").animate( {
				left : realx + "px",
				top : realy + "px",
				opacity : "show"
			}, 1000);
		});

		$("#tip").click(function() {
			i++;
			if (i % 2 == 0) {
				$("#menu").hide();
			} else {
				var ls = $(this).offset();
				var tt = document.body.scrollTop + ls.top;
				var ll = document.body.scrollLeft + ls.left;
				$("#menu")[0].style.left = ll / 2 -20+ "px";
				$("#menu")[0].style.top = tt - 290+ "px";
				$("#menu").show();
			}
		});
		
		$("#menutitle").click(function() {
				i++;	
				$("#menu").hide();
		});
		//将关于本系统的介绍栏可以移动,限制容器为window时可以避免出现超出范围时出现滚动条
		$("#sysmessage").draggable({ 
							containment:"window",
							scroll: false ,
							cursor:"move",
							opacity: 0.7
							});
		
		$("#menu").draggable({ 
							containment:"window",
							scroll: false ,
							cursor:"move",
							});
		
		$("#logout").click(function(){
			$("#logoutdiv").show();
			$.getJSON("Logoutaction.action",function(data){
				if(data.i==1){
					$("#logoutmessage").html("<font color='red'>您已经成功注销</font>");
					$("#logoutdiv").fadeOut(3000);
				}
				if(data.i==0){
					$("#logoutmessage").html("<font color='red'>您好像并没有登录</font>");
					$("#logoutdiv").fadeOut(3000);
				}
			});
		});
	    /*备份数据*/
		$("#saveandback").click(function(){	
			$("#saveandbackdiv").show();
			$.getJSON("saveandbackaction",function(data){
			if(data.i==1){
		$("#saveandbackmessage").html("<font color='red'>已经成功将数据库备份到<font color='green'>C</font>盘下，请及时做好备份转移</font>");
		$("#saveandbackdiv").fadeOut(3000);
			}else{
				$("#saveandbackmessage").html("<font color='red'>保存时出了些问题，请检查是否已保存过</font>");
				$("#saveandbackdiv").fadeOut(3000);
			}
		});
		});
	
	});