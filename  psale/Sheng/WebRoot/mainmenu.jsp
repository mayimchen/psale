<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
<link href="css/mycss.css" rel="stylesheet" type="text/css" />
<link rel="shortcut icon" href="img/favicon.ico"/>
<script language="javascript" src="js/jquery-1.4.2.js"></script>
<script language="javascript" src="js/mainmenu.js"></script>
</head>
<body>
<div><font color="red">${userid}</font>登陆</div>
<div id="mainmenu">
	<table cellpadding="0" cellspacing="0" bgcolor="#e7eef8" width="350" height="250">
		<tr>
			<td align="center"><a href="delwuliao.jsp">出库</a></td>
		</tr>
		<tr>
			<td align="center"><a href="addwuliao.jsp">入库</a></td>
		</tr>
		<tr>
			<td align="center"><a href="lookwuliaoaction.action">查看库存</a></td>
		</tr>
		<tr>
			<td align="center"><a href="lookoutaction.action">查看所有出库单</a></td>
		</tr>
		<tr>
			<td align="center"><a href="adduser.jsp">添加工作人员</a></td>
		</tr>
		<tr>
			<td align="center"><a href="Lookpersonsubmit.jsp">查看销售人员汇总</a></td>
		</tr>
	</table>
</div>
</body>
</html>