// JavaScript Document
var x;
var i=0;
var x=0;
var Today;
// 当前时间信息
var date;
var Month;
var Year ;
$(document).ready(function(){
						   $("#dialog").hide();
		 					$("#comeback").hide();
						   if(i==0){
							   Today = new Date();
							   date= Today.getDate();//获取本月里当天所在的日
							   Month = Today.getMonth();
							   Year= Today.getYear();
							   }
						   start();
						   });
//回到今天的日期
function comeback(){
	Today = new Date();
	date= Today.getDate();//获取本月里当天所在的日
	Month = Today.getMonth();
	Year= Today.getYear();
	$("table").remove();
	start();
	$("#comeback").fadeOut(1000);
	}
//++
function countadd(){
		i++;
		if(i!=0){
			x=1;
			$("#comeback").fadeIn(1000);
			}else{
				x==0;
				$("#comeback").fadeOut(1000);
				}
		Month=Month+1;
		if(Month<=11){
			Today=new Date(Year,Month,date);//年不变
			$("table").remove();
			start();
			}
		else{
			Month=Month-12;
			Year=Year+1;
			Today=new Date(Year,Month,date);//年变，月变
			$("table").remove();
			start();
			}
	}
//--
function countpase(){
	i--;
	if(i!=0){
			x=1;
			$("#comeback").fadeIn(1000);
			}else{
				x==0;
				$("#comeback").fadeOut(1000);
				}
	Month=Month-1;
	if(Month>0){
		Today=new Date(Year,Month,date);//年不变
		$("table").remove();
		start();
		}
	else{
		Month=11;
		Year=Year-1;
		Today=new Date(Year,Month,date);//年变，月变
		$("table").remove();
		start();
		}
	}
/*

核心程序，构造日历
**/
function start(){
	var Weekday = new Array();
	Weekday[0] = "星期日";
	Weekday[1] = "星期一";
	Weekday[2] = "星期二";
	Weekday[3] = "星期三";
	Weekday[4] = "星期四";
	Weekday[5] = "星期五";
	Weekday[6] = "星期六";
	var MonthA = new Array();
	MonthA[0] = "一月";
	MonthA[1] = "二月";
	MonthA[2] = "三月";
	MonthA[3] = "四月";
	MonthA[4] = "五月";
	MonthA[5] = "六月";
	MonthA[6] = "七月";
	MonthA[7] = "八月";
	MonthA[8] = "九月";
	MonthA[9] = "十月";
	MonthA[10] = "十一月";
	MonthA[11] = "十二月";
	var Mdays = new Array();
	Mdays[0] = 31;
	Mdays[1] = 28;
	Mdays[2] = 31;
	Mdays[3] = 30;
	Mdays[4] = 31;
	Mdays[5] = 30;
	Mdays[6] = 31;
	Mdays[7] = 31;
	Mdays[8] = 30;
	Mdays[9] = 31;
	Mdays[10] = 30;
	Mdays[11] = 31;
// 用day来计数，i控制高，j不变控制宽，宽就是7，每个星期有七天
	var day = 1;
	var i, j;
// 得到本年的年份
	if (Year < 2000) {
		Year += 1900;
	}
//获取指点信息
 dow= Today.getDay();//获取当日日期里的当天星期
//闰年的判断
	if ((Year % 400 == 0) || ((Year % 4 == 0) && (Year % 100 !=0)))
		Mdays[1] = 29;
//决定第一天
	var Mfirst = Today;
	Mfirst.setDate(1);
	var dow1 = Mfirst.getDay();//返回值为1，这样就知道每月的第一天
// 为当前月来构造框架
var t1=$("<table cellpadding=0 cellspacing=0 width=350 height=300 id='t1'>" +
		"<div id='t2'><tr background='white'><th colspan=7 align=center><font color='red' size=4><a href='javascript:countpase()'><<</a></font>" + MonthA[Month] + " " + Year + "<font color='red' size=4><a href='javascript:countadd()'>>></a></font></th></tr></div><tr bgcolor='#e7eef8' id='t3'><th>日</th><th>一</th><th>二</th><th>三</th>" +
		"<th>四</th><th>五</th><th>六</th></tr>");
	var mainmenu=$("#mainmenu2")[0];
	t1.appendTo($("#mainmenu2"));
	for (i = 0; i < 6; i++) {
// 构造礼拜一到礼拜天
		var t2=$("<tr>");
		t2.appendTo(t1);
		for (j = 0; j < 7; j++) {
// 确定哪些列是被显示的
			if ((i == 0 && j < dow1) || (day > Mdays[Month])) {
// 使得每个月底是空白行，即不存在的日期不显示
				var t3=$("<td><br></td>");
				t3.appendTo(t2);
			} else {
				if (day == date) {
// 将当前时期高亮
				var t4=$("<td bgcolor=#e7eef8 align='center'><span id='"+day+"' onmouseover='showmessage(event,"+day+")'>"+day+"</span></td>");
				t4.appendTo(t2);
				} else {
// 显示表格里的对应日期
			var t5=$("<td  align='center' ><span id='"+day+"' onmouseover='showmessage(event,"+day+")'>" + day + "</span></td>");
				t5.appendTo(t2);
				}
// 将相应的日期++
				day++;
			}
		}
// 结束表格
		var t6=$("</tr>");
		t2.after(t6);
		if (day > Mdays[Month]) {
			i = 6;
		}
	}
	var t7=$("</table>");
	t1.after(t7);
	}