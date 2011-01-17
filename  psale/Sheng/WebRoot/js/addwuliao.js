//添加物料时的js验证
var a=0,b=0,c=0,d=0,e=0,f=0,g=0;
$(document).ready(function(){
	$("#innameerror").hide();
	$("#innumerror").hide();
	$("#inpriceerror").hide();
	$("#inuseriderror").hide();
	$("#unuseridexit").hide();
	$("#submitmessage").hide();
	$("#piderror").hide();
	$("#pidexisterror").hide();
	//防止传统事件模式的弊端。注册多个事件会报 迭代太多
	$("#pid").blur(function(){
		var s=$(this)[0];
		if(checkpid(s)){
			checkpidexit(s);
		}
	});
	$("#inuserid").blur(function(){
			var s=$(this)[0];
		if(checkuserid(s)){
			checkuseridexit(s);
		}
	});
});
//入库产品编号不能为空而且不能不存在
function checkpid(t){
	var pid=$.trim($("#pid").val());
	var l=$(t).offset();
	if(pid.length==0){
		$(this).getpos(l,"piderror","pid");
		return false;
	}
	else{
		$(this).hidediv("piderror","pid");
		f=1;
		return true;
	}
}

//检查产品编号是否存在
function checkpidexit(t){
	var l=$(t).offset();
	var pid=$.trim($("#pid").val());
	if(checkpid()){
		$.getJSON("checkpidexistaction.action",{pid:pid},function(data){
			if(data.message==0){
				$("#pidexistmessage").html("<font color='red'>此产品ID已存在，你确定是这个吗？</font>");
				var tt=l.top-35+document.body.scrollLeft;
				var ll=l.left+130+document.body.scrollTop;
				$("#pidexisterror")[0].style.left=ll+"px";
				$("#pidexisterror")[0].style.top=tt+"px";
				$("#pidexisterror").show();
				return false;
			}else{
				g=1;
				$("#pidexisterror").hide();
				return true;
			}
		});
	}
}

//入库产品名称不能为空
function checkinname(t){
	var inname=$.trim($("#inname").val());
	var l=$(t).offset();
	if(inname.length==0){
		$(this).getpos(l,"innameerror","inname");
		return false;
	}
	else{
		$(this).hidediv("innameerror","inname");
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
		$(this).hidediv("innumerror","innum");
		b=1;
		return true;
	}else{
		$(this).getpos(l,"innumerror","innum");
		return false;
	}
}
//产品价格为数字组成
function checkinprice(t){
	var inprice=$.trim($("#inprice").val());
	var l=$(t).offset();
	var rs=/\d+/;
	if(rs.test(inprice)){
		$(this).hidediv("inpriceerror","inprice");
		c=1;
		return true;
	}else{
		$(this).getpos(l,"inpriceerror","inprice");
		return false;
	}
}
//入库人员代码必须为数字
function checkuserid(t){
	var inuserid=$.trim($("#inuserid").val());
	var l=$(t).offset();
	var rs=/\d+/;
	if(rs.test(inuserid)){
		$(this).hidediv("inuseriderror","inuserid");
		d=1;
		return true;
	}else{
		$(this).getpos(l,"inuseriderror","inuserid");
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
	if(a==1&&b==1&&c==1&&d==1&&e==1&&f==1&&g==1){
		return true;
	}else{
		$("#submitmessage").show().delay(1000).fadeOut(2000);
		return false;
	}
}