//用户管理页面控制js
$(document).ready(function(){
				$("#lightbox").hide();
				$("#edituser").hide();
				closeedit();
				$("#save")[0].onclick=savenewuser;
});
//点击编辑后的事件
function edit(s){
	var left=$(window).width()+document.body.scrollLeft;	
	var top=$(window).height()+document.body.scrollTop;
	var dwidth=$("#edituser")[0].width||$("#edituser").width();
	var dheight=$("#edituser")[0].height||$("#edituser").height();
	var realx=(left-dwidth)/2;
	var realy=(top-dheight)/2;
	$("#edituser")[0].style.left=realx+"px";
	$("#edituser")[0].style.top=realy+"px";
	$.getJSON("edituseraction.action",{id:s},function(data){
		$("#userid").val(data.userid);
		$("#username").val(data.username);
		$("#passwd").val(data.passwd);
	});
	$("#lightbox").show();
	$("#edituser").show();
}
//关闭编辑页面
function closeedit(){
	$("#title").children("img").click(function(){
		$("#edituser").hide();
		$("#lightbox").hide();
	});
}
//监听用户修改后并提交信息
function savenewuser(){
		var userid=$("#userid").val();
		var username=encodeURI(encodeURI($("#username").val()));
		//var username=$("#username").val();
		var passwd=$("#passwd").val();
	  $.getJSON("modifyaction.action",{userid:userid,username:username,passwd:passwd},function(data){
		if(data.flag==0){
			alert("false");
		}else{
			window.location.reload();
			$("#edituser").hide();
			$("#lightbox").hide();
		}
	});
		
	/*$.ajax({
		type:"POST",
		url:"modifyaction.action",
		date:"userid="+userid+"&username="+username+"&passwd="+passwd+"",
		dateType:"json",
		error:function(msg){
			alert("浏览器请求失败");
		},
		success:function(msg){
			alert(msg.flag);
			if(msg.flag==0){
			alert("更新失败");
		}else{
			window.location.reload();
			$("#edituser").hide();
			$("#lightbox").hide();
		}
		}
	});*/
}