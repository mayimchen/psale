//添加物料时的js验证
var a=0,b=0,c=0,d=0,e=0;
$(document).ready(function(){
	$("#innameerror").hide();
	$("#innumerror").hide();
	$("#inpriceerror").hide();
	$("#inuseriderror").hide();
	$("#unuseridexit").hide();
	$("#submitmessage").hide();
	//防止传统事件模式的弊端。注册多个事件汇报 迭代太多
	$("#inuserid").blur(function(){
			var s=$(this)[0];
		if(checkuserid(s)){
			checkuseridexit(s);
		}
	});
});
//入库产品名称不能为空
function checkinname(t){
	var inname=$.trim($("#inname").val());
	var l=$(t).offset();
	if(inname.length==0){
		var tt=l.top-35+document.body.scrollLeft;
		var ll=l.left+130+document.body.scrollTop;
		$("#innameerror")[0].style.left=ll+"px";
		$("#innameerror")[0].style.top=tt+"px";
		$("#innameerror").show();
		$("#inname").addClass("username");
		return false;
	}
	else{
		$("#innameerror").hide();
		$("#inname").removeClass("username");
		a=1;
		return true;
	}
}
//检查数据库中是否存在指定的产品名称，暂时先放着，等需要了再写----------------------入库时不需要检查名称的

//如库数量检查，必须为数字
function checkinnum(t){
	var innum=$.trim($("#innum").val());
	var l=$(t).offset();
	var rs=/\d+/;
	if(rs.test(innum)){
		$("#innumerror").hide();
		$("#innum").removeClass("username");
		b=1;
		return true;
	}else{
		var tt=l.top-35+document.body.scrollLeft;
		var ll=l.left+130+document.body.scrollTop;
		$("#innumerror")[0].style.left=ll+"px";
		$("#innumerror")[0].style.top=tt+"px";
		$("#innumerror").show();
		$("#innum").addClass("username");
		return false;
	}
}
//产品价格为数字组成
function checkinprice(t){
	var inprice=$.trim($("#inprice").val());
	var l=$(t).offset();
	var rs=/\d+/;
	if(rs.test(inprice)){
		$("#inpriceerror").hide();
		$("#inprice").removeClass("username");
		c=1;
		return true;
	}else{
		var tt=l.top-35+document.body.scrollLeft;
		var ll=l.left+130+document.body.scrollTop;
		$("#inpriceerror")[0].style.left=ll+"px";
		$("#inpriceerror")[0].style.top=tt+"px";
		$("#inpriceerror").show();
		$("#inprice").addClass("username");
		return false;
	}
}
//入库人员代码必须为数字
function checkuserid(t){
	var inuserid=$.trim($("#inuserid").val());
	var l=$(t).offset();
	var rs=/\d+/;
	if(rs.test(inuserid)){
		$("#inuseriderror").hide();
		$("#inuserid").removeClass("username");
		d=1;
		return true;
	}else{
		var tt=l.top-35+document.body.scrollLeft;
		var ll=l.left+130+document.body.scrollTop;
		$("#inuseriderror")[0].style.left=ll+"px";
		$("#inuseriderror")[0].style.top=tt+"px";
		$("#inuseriderror").show();
		$("#inuserid").addClass("username");
		return false;
	}
}
//检查工号在数据库中是否存在
function checkuseridexit(t){
	var inuserid=$("#inuserid").val();
	var l=$(t).offset();
	if(checkuserid()){
		$.getJSON("Checkaduseraction.action",{inuserid:inuserid},function(date){
			if(date.message==1){
				$("#content").html("<font color='red'>此ID不存在，请检查</font>");
				var tt=l.top-35+document.body.scrollLeft;
				var ll=l.left+130+document.body.scrollTop;
				$("#unuseridexit")[0].style.left=ll+"px";
				$("#unuseridexit")[0].style.top=tt+"px";
				$("#unuseridexit").show();
			}
			else{
				e=1;
				$("#unuseridexit").hide();
			}
		});	
	}	
}
//表单提交时的操作
function checksubmit(){
	if(a==1&&b==1&&c==1&&d==1&&e==1){
		return true;
	}else{
		$("#submitmessage").show().delay(1000).fadeOut(2000);
		return false;
	}
}