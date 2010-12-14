// JavaScript Document
var i=0;
$(document).ready(function(){
						    $("#login").mouseover(function(){
												 $(this).css("background","red");
														  });
						    $("#login").mouseout(function(){
												 $(this).css("background","none");
														  });
							/**$("#login").click(function(){
									   var winx=$(window).width();
									   var winy=$(window).height();
									   var scrollleft=$(window).scrollLeft();
									   var scrolltop=$(window).scrollTop();
									   var x=parseFloat($("#rlogin").css("width"));
									   var y=parseFloat($("#rlogin").css("height"));
									   var realx=(winx+scrollleft-x)/2;
									   var realy=(winy+scrolltop-y)/2;
									   $("#rlogin")[0].style.left=realx+"px";
									   $("#rlogin")[0].style.top=realy+"px";
									   $("#rlogin").load("index.jsp #apDiv2");
									   $("#rlogin").fadeIn(2000);
									   
									   $("#zhazhao").css("display","block");
									   $("#zhezhao").fadeIn(2000);
													   });*/
							$("#close").mouseover(function(){
												 $(this).css("background","red");
														  });
						    $("#close").mouseout(function(){
												 $(this).css("background","none");
														  });
							$("#tip").mouseover(function(){
												 $(this).css("background","red");
									
														  });
						    $("#tip").mouseout(function(){
												 $(this).css("background","none");
														  });
							$("#copyright").mouseover(function(){
												 $(this).css("background","red");
									
														  });
						    $("#copyright").mouseout(function(){
												 $(this).css("background","none");
														  });
							$("#tip").click(function(){
								i++;
								if(i%2==0){
									$("#menu").hide();
									}
								else{
								var ls=$(this).offset();
								var tt=document.body.scrollTop+ls.top;
								var ll=document.body.scrollLeft+ls.left;
								$("#menu")[0].style.left=ll/2+"px";
								$("#menu")[0].style.top=tt-120+"px";
								$("#menu").show();
									}
													 });
							$("#menu a").mouseover(function(){
												$(this).css("background","red"); 
														  });
							$("#menu a").mouseout(function(){
												$(this).css("background","none");		
														 });
							$("#menu").hide();
							$("#rlogin").hide();
						   });