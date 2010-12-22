//检索用户销售的js控制
var b=0,c=0;
	$(document).ready(function(){
		$("#submitmessage").hide();
		$("img").hide();
		$("#unuseridexit").hide();
		$("#inuseriderror").hide();
		//采用这样的方式方便管理多个事件
		$("#userid").blur(function(){
				var s=$(this)[0];
			if(checkuserid(s)){
				checkuseridexit(s);
			}
		});
	});
function checksubmit(){
	var userid=$.trim($("#userid").val());
	var startdate=$.trim($("#startdate").val());
	var enddate=$.trim($("#enddate").val());
	if(startdate==0||enddate==0||enddate<startdate||b==0||c==0){
		$("#submitmessage").show().delay(1000).fadeOut(2000);
		return false;
	}else{
		return true;
	}
}
//入库人员代码必须为数字
function checkuserid(t){
	var inuserid=$.trim($("#userid").val());
	var l=$(t).offset();
	var rs=/\d+/;
	if(rs.test(inuserid)){
		$("#inuseriderror").hide();
		$("#userid").removeClass("username");
		b=1;
		return true;
	}else{
		var tt=l.top-35+document.body.scrollLeft;
		var ll=l.left+130+document.body.scrollTop;
		$("#inuseriderror")[0].style.left=ll+"px";
		$("#inuseriderror")[0].style.top=tt+"px";
		$("#inuseriderror").show();
		$("#userid").addClass("username");
		return false;
	}
}
//检查工号在数据库中是否存在
function checkuseridexit(t){
	var inuserid=$("#userid").val();
	var l=$(t).offset();
	if(b==1){
		$.getJSON("Checkaduseraction.action",{inuserid:inuserid},function(date){
			if(date.message==1){				
				$("#content").html("<font color='red'>此ID并不存在，你确定是这个吗</font>");
				var tt=l.top-35+document.body.scrollLeft;
				var ll=l.left+130+document.body.scrollTop;
				$("#unuseridexit")[0].style.left=ll+"px";
				$("#unuseridexit")[0].style.top=tt+"px";
				$("#unuseridexit").show();
			}
			else{
				c=1;
				$("#unuseridexit").hide();
			}
		});	
	}	
}
