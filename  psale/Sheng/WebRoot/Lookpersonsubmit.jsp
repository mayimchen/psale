<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
		<title>销售人员销售汇总</title>
		<link href="css/mycss.css" rel="stylesheet" type="text/css" />
		<link href="css/mycss2.css" rel="stylesheet" type="text/css" />
		<link href="css/wrongmessage.css" rel="stylesheet" type="text/css" />
		<link href="css/circleconer.css" rel="stylesheet" type="text/css" />
		<link rel="shortcut icon" href="img/favicon.ico"/>
		<script language="javascript" src="js/jquery-1.4.2.js"></script>
		<script language="javascript" src="js/calendar.js"></script>
		<script language="javascript" src="js/personsubmit.js"></script>
	</head>
	<body>
	<h3 align="center">查看销售汇总</h3>
	<a href="index2.jsp">返回首页</a>
	<hr/>
		<div align="center" class="circlecorner2">
		<div align="center" class="circlecontent2">
		<form onsubmit="return checksubmit();" action="lookpersonaction.action">
			<table border="0"  cellpadding="1" cellspacing="1" width="400" height="200">
				<tr>
					<td class="STYLE3">
						用户ID
					</td>
					<td>
						<input type="text" name="userid" id="userid"/>
					</td>
				</tr>
				<tr>
					<td class="STYLE3">
						检索开始日期
					</td>
					<td>
						<input type="text" name="startdate" id="startdate"  onclick="showcalendar(event, this)"/>
					</td>
				</tr>
				<tr>
					<td class="STYLE3">
						检索结束日期
					</td>
					<td>
						<input type="text" name="enddate" id="enddate"  onclick="showcalendar(event, this)"/>
						<span id="errordate"></span>
					</td>
				</tr>
				<tr>
					<td colspan="2" >
						<div align="center">
							<input type="submit"  class="button" value="检索" />
						</div>
					</td>
				</tr>
			</table>
		</form>
		</div>
		</div>
		<div id="submitmessage">
			请仔细检查你的输入和提示信息
		</div>
		<div id="unuseridexit">
			<div id="tip" class="tipgreen">
				<pre class="perclass" id="content"></pre>
			</div>
			<div id="bkimg" class="tip-arrow-bottom"></div>
		</div>
			<div id="inuseriderror">
		<div id="tip" class="tipgreen">
				<pre class="perclass">入库人员代码必须为数字</pre>
			</div>
			<div id="bkimg" class="tip-arrow-bottom"></div>
		</div>
		<div id="personsubmitmessage">
			<img alt="提示信息" src="img/img-loading.gif">
		</div>
	</body>
</html>