<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>没有销售信息</title>
<link href="css/circleconer.css" rel="stylesheet" type="text/css" />
<link href="css/mycss.css" rel="stylesheet" type="text/css" />
<link rel="shortcut icon" href="img/favicon.ico"/>
</head>
<body>
<h3 align="center"> 
			销售汇总显示页面 
		</h3>
		<hr />
	<div class="circlecorner3">
		<div class="circlecontent3">
		<font color="red">${userid}</font>在这段时间内并没有销售记录
		<br/>
		<br/>
	<input type="button" value="重新检索" class="button" onclick="window.location='Lookpersonsubmit.jsp'"></input><br/>
		<br/>
	<input type="button" value="返回首页" class="button" onclick="window.location='index2.jsp'"/></input><br/>
		</div>
	</div>
</body>
</html>