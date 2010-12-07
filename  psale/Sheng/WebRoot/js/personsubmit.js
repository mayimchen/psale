//检索用户销售的js控制
	$(document).ready(function(){
		$("#submitmessage").hide();
		$("img").hide();
	});
function checksubmit(){
	var userid=$.trim($("#userid").val());
	var startdate=$.trim($("#startdate").val());
	var enddate=$.trim($("#enddate").val());
	if(userid==0||startdate==0||enddate==0||enddate<startdate){
		$("#submitmessage").show().delay(1000).fadeOut(2000);
		return false;
	}else{
		return true;
	}
}
