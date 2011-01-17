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
		$(this).hidediv("useriderror","userid");
		a=1;
		return true;
		}
		else{
			$(this).getpos(l,"useriderror","userid");
			return false;
			}
	}
//检查用户密码安全级别，默认至少六位
function checkpasswd(t){
	var passwd=$.trim($("#passwd").val());
	var l=$(t).offset();
	if(passwd.length<6){
		$(this).getpos(l,"passwderror","passwd");
		 return false;
	}
	else{
		$(this).hidediv("passwderror","passwd");
		b=1;
		return true;
	}	
}

//提交表单操作
function tijiao(){
	if(a==1&&b==1){
		return true;
	}else{
		$("#submitmessage").show().delay(1000).fadeOut(2000);
		return false;
	}
}

