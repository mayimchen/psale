//删除物料时的js验证
var a=0,b=0,c=0,d=0,e=0,f=0;
$(document).ready(function(){
	$("#outnameerror").hide();
	$("#outnumerror").hide();
	$("#outpriceerror").hide();
	$("#outuseriderror").hide();
	$("#outnummessage").hide();
	$("#outnamemessage").hide();
	$("#outuseridmessage").hide();
	$("#submitmessage").hide();
	//阻止传统的方式出现问题，即两个函数注册在一个事件上出现的问题
	$("#outname").blur(function(){
		var s=$(this)[0];
		if(checkoutname(s)){
			checkoutnameexit(s);
		}
	});
	$("#outuserid").blur(function(){
		var t=$(this)[0];
		if(checkuserid(t)){
			checkuseridexit(t);
		}
	});
});
//出库产品名称不能为空
function checkoutname(t){
	var outname=$.trim($("#outname").val());
	var l=$(t).offset();
	if(outname.length==0){
		var tt=l.top-35+document.body.scrollLeft;
		var ll=l.left+130+document.body.scrollTop;
		$("#outnameerror")[0].style.left=ll+"px";
		$("#outnameerror")[0].style.top=tt+"px";
		$("#outnameerror").show();
		$("#outname").addClass("username");
		return false;
	}
	else{
		$("#outnameerror").hide();
		$("#outname").removeClass("username");
		a=1;
		return true;
	}
}
//检查产品名称是否存在
function checkoutnameexit(t){
	var outname=$.trim($("#outname").val());
	var l=$(t).offset();
	if(checkoutname()){
		$.getJSON("Checkoutnameaction.action",{outname:outname},function(date){
			if(date.message==1){
				$("#contentoutname").html("<font color='red'>不存在这样的产品，你确定是这个吗?</font>");
				var tt=l.top-35+document.body.scrollLeft;
				var ll=l.left+130+document.body.scrollTop;
				$("#outnamemessage")[0].style.left=ll+"px";
				$("#outnamemessage")[0].style.top=tt+"px";
				$("#outnamemessage").show();
			}else{
				$("#outnamemessage").hide();
				b=1;
			}
		});
	}
}
//出库数量检查，必须为数字
function checkoutnum(t){
	var outnum=$.trim($("#outnum").val());
	var l=$(t).offset();
	var rs=/\d+/;
	if(rs.test(outnum)){
		$("#outnumerror").hide();
		$("#outnum").removeClass("username");
		c=1;
		return true;
	}else{
		var tt=l.top-35+document.body.scrollLeft;
		var ll=l.left+130+document.body.scrollTop;
		$("#outnumerror")[0].style.left=ll+"px";
		$("#outnumerror")[0].style.top=tt+"px";
		$("#outnumerror").show();
		$("#outnum").addClass("username");
		return false;
	}
}
//产品价格为数字组成
function checkoutprice(t){
	var outprice=$.trim($("#outprice").val());
	var l=$(t).offset();
	var rs=/\d+/;
	if(rs.test(outprice)){
		$("#outpriceerror").hide();
		$("#outprice").removeClass("username");
		d=1;
		return true;
	}else{
		var tt=l.top-35+document.body.scrollLeft;
		var ll=l.left+130+document.body.scrollTop;
		$("#outpriceerror")[0].style.left=ll+"px";
		$("#outpriceerror")[0].style.top=tt+"px";
		$("#outpriceerror").show();
		$("#outprice").addClass("username");
		return false;
	}
}
//入库人员代码必须为数字
function checkuserid(t){
	var outuserid=$.trim($("#outuserid").val());
	var l=$(t).offset();
	var rs=/\d+/;
	if(rs.test(outuserid)){
		$("#outuseriderror").hide();
		$("#outuserid").removeClass("username");
		e=1;
		return true;
	}else{
		var tt=l.top-35+document.body.scrollLeft;
		var ll=l.left+130+document.body.scrollTop;
		$("#outuseriderror")[0].style.left=ll+"px";
		$("#outuseriderror")[0].style.top=tt+"px";
		$("#outuseriderror").show();
		$("#outuserid").addClass("username");
		return false;
	}
}
//入库人员代码是否存在也得检查
function checkuseridexit(t){
	var inuserid=$("#outuserid").val();
	var l=$(t).offset();
	if(checkuserid()){
		$.getJSON("Checkaduseraction.action",{inuserid:inuserid},function(date){
			if(date.message==1){
				$("#contentuserid").html("<font color='red'>此ID并不存在，你确定是这个吗？</font>");
				var tt=l.top-35+document.body.scrollLeft;
				var ll=l.left+130+document.body.scrollTop;
				$("#outuseridmessage")[0].style.left=ll+"px";
				$("#outuseridmessage")[0].style.top=tt+"px";
				$("#outuseridmessage").show();
			}else{
				$("#outuseridmessage").hide();
				f=1;
			}
		});	
	}	
}
//当用户出库时检查指定的产品的数量，暂不使用
function checkrnum(t){
	var outname=$.trim($("#outname").val());
	
	//如果还没有输入产品名称
	if(outname.length==0){
		//给予其相应的提示信息
		$("#outnummessage").show(200).delay(1000).hide();
	}
	else{
		$("#outnummessage").hide();
	}
}
//表单提交时的操作
function checksubmit(){
	if(a==1&&b==1&&c==1&&d==1&&e==1&&f==1){
		return true;
	}else{
		$("#submitmessage").show().delay(1000).fadeOut(2000);
		return false;
	}
}