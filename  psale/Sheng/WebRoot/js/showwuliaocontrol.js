//给表格设置好css，使其隔行换色
var yanse;
$(document).ready(function(){
	$("#lightbox").hide();
	$("#editwuliao").hide();
	$("#save")[0].onclick=saveproduct;
	$("#swuliao tr:odd").css("background","#e7eef8");	
	$("#swuliao tr").mouseover(function(){
		 yanse=$(this).css("background");
		$(this).css("background","grey");
	});
	$("#swuliao tr").mouseout(function(){
			$(this).css("background",yanse);
	});
	//点击关闭按钮
	$("#editwuliaotitle").click(function(){
			$("#editwuliao").hide();
			$("#lightbox").hide();
	});
});
/*
用户点击编辑后的事件
**/
function edit(s){
	var left=$(window).width()+document.body.scrollLeft;	
	var top=$(window).height()+document.body.scrollTop;
	var dwidth=$("#editwuliao")[0].width||$("#editwuliao").width();
	var dheight=$("#editwuliao")[0].height||$("#editwuliao").height();
	var realx=(left-dwidth)/2;
	var realy=(top-dheight)/2;
	$("#editwuliao")[0].style.left=realx+"px";
	$("#editwuliao")[0].style.top=realy+"px";
	$.getJSON("editproductaction.action",{flag:s},function(data){
		$("#id").val(data.id);
		$("#inname").val(data.inname);
		$("#innum").val(data.innum);
		$("#inprice").val(data.inprice);
		$("#inuserid").val(data.inuserid);
		$("#indate").val(data.indate);
		$("#detail").val(data.detail);
	});
	$("#lightbox").show();
	$("#editwuliao").show();
}
/*
用户修改过信息之后，点击保存按钮时执行的操作
**/
function saveproduct(){
		var id=$("#id").val();
		var inname=encodeURI(encodeURI($("#inname").val()));
		var innum=$("#innum").val();
		var inprice=$("#inprice").val();
		var inuserid=$("#inuserid").val();
		var indate=$("#indate").val();
		var detail=encodeURI(encodeURI($("#detail").val()));
		$.getJSON("modifyproductaction.action",{pid:id,inname:inname,innum:innum,inprice:inprice,inuserid:inuserid,indate:indate,detail:detail},function(data){
			if(data.flag==0){
				alert("false");
			}else{
				window.location.reload();
				$("#editwuliao").hide();
				$("#lightbox").hide();
			}
		});
}

