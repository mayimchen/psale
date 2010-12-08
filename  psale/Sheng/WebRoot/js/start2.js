// JavaScript Document
$(document).ready(function(){
						   $("#movemessage").hide();
						   $("#mainmenu2").draggable({cursor:"move"});
						   $("#movemessage").draggable({cursor:"move"});
						   $("#movemessage").resizable({alsoResize:"#closetip"});
						   $("#movemessage").resizable({alsoResize:"#movemessage2"});
						   $("#movemessage2").resizable();
						   $("#mainmenu2").resizable({alsoResize:"#t1"});
						   $("#t1").resizable();
						   });
//关闭日历
function closecal(){
	$("#mainmenu2").fadeOut(2000);
	}
//用户移上表格时的事件
function showmessage(objevent,day){
	var divobj=$("#movemessage")[0];
	divobj.style.left=document.body.scrollLeft+objevent.clientX+5+"px";
	divobj.style.top=document.body.scrollTop+objevent.clientY+5+"px";
	divobj.style.display="block";
	//此处可以利用ajax获得后台数据并显示在div里
	$("#movemessage2").html(day+"这里将会显示具体的提示信息和其他任务提示，现在主要测试其是否会自动那个收缩"+"<a href='http://www.baidu.com/' target='_blank'>去百度看看</a>");
	$("#movemessage").show();
	}
//当用户移上到提示div上时的事件
function divmouseover(){
	$("#movemessage2").focus();
	}
//用户离开时的事件
function closemessage(){
	 $("#movemessage").fadeOut(1000);
	}

