// JavaScript Document
var a=0,b=0;
// 检查登陆时的输入
$(function(){
		   $("#useriderror").hide();
		   $("#passwderror").hide();
		   $("#submitmessage").hide();
		   })
//检查id是否合法
function checkuserid(t){
	var userid=$("#userid").val();
	var l=$(t).offset();
	rs=/[0-9]+/;
	if(rs.test(userid)){
		$("#useriderror").hide();
		$("#userid").removeClass("username");
		a=1;
		return true;
		}
		else{
			var tt=l.top-35+document.body.scrollLeft;
			var ll=l.left+130+document.body.scrollTop;
			$("#useriderror")[0].style.left=ll+"px";
			$("#useriderror")[0].style.top=tt+"px";
			$("#useriderror").show();
			$("#userid").addClass("username");
			 return false;
			}
	}
//检查用户密码安全级别，默认至少六位
function checkpasswd(t){
	var passwd=$.trim($("#passwd").val());
	var l=$(t).offset();
	if(passwd.length<6){
		var tt=l.top-35+document.body.scrollLeft;
		var ll=l.left+130+document.body.scrollTop;
		$("#passwderror")[0].style.left=ll+"px";
		$("#passwderror")[0].style.top=tt+"px";
		$("#passwderror").show();
		$("#passwd").addClass("username");
		 return false;
	}
	else{
		$("#passwderror").hide();
		$("#passwd").removeClass("username");
		b=1;
		return true;
	}	
}
//提交表單操作
function tijiao(){
	if(a==1&&b==1){
		return true;
	}else{
		$("#submitmessage").show().delay(1000).fadeOut(2000);
		return false;
	}
}