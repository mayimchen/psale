<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>我的仓库管理平台</title>
<link  href="base/jquery.ui.all.css" rel="stylesheet" />
<link  rel="stylesheet" href="css/mainpage.css"/>
<script language="javascript" src="js/jquery-1.4.2.js"></script>
	<script language="javascript" src="js/jquery.ui.core.js"></script>
	<script language="javascript" src="js/jquery.ui.widget.js"></script>
	<script language="javascript" src="js/jquery.ui.mouse.js"></script>
	<script language="javascript" src="js/jquery.ui.draggable.js"></script>
	<script language="javascript" src="js/start.js"></script>
</head>
<body>
<div id="mainmenu" class="tts" style="visibility:visible;display:block;">
	<div id="login"><a href="index.jsp">登陆</a></div>
    <div id="aboutsys"><a href="#" id="aboutsyslink">关于本系统</a></div>
    <div id="tip"><a href="#">菜单</a></div>
    <div id="copyright"><font size="3" color="red"><a href="#">author:zqiangzhang@gmail.com</a></font></div>
</div>
<div id="menu">
	<div id="menutitle"><img src="img/close.gif"/></div>
	<table width="580" height="250">
	<tr>
		<td><div align="center"><a href="delwuliao.jsp">出库</a></div></td>
		<td><div align="center"><a href="addwuliao.jsp">入库</a></div></td>
	</tr>
	<tr>
		<td><div align="center"><a href="lookwuliaoaction.action">查看库存</a></div></td>
		<td><div align="center"><a href="lookallproducts.action">产品管理</a></div></td>
	</tr>
	<tr>
		<td><div align="center"><a href="lookalluseraction.action">人员管理</a></div></td>
		<td><div align="center"><a href="#">待添加功能</a></div></td>
	</tr>
	<tr>
		
		<td><div align="center"><a href="#">待添加功能</a></div></td>
		<td><div align="center"><a href="#">待添加功能</a></div></td>
	</tr>
	<tr>
		<td><div align="center"><a href="lookallwuliaobf.action">查看所有入库单</a></div></td>
		<td><div align="center"><a href="adduser.jsp">添加工作人员</a></div></td>
	</tr>
	<tr>
		
		<td><div align="center"><a href="lookoutaction.action">查看所有出库单</a></div></td>
		<td><div align="center"><a href="Lookpersonsubmit.jsp">查看销售人员汇总</a></div></td>
	</tr>
	</table>
</div>
<div id="sysmessage">
	<div id="systitle"><img src="img/close.gif"/></div>
	<div id="syscontent">
		这里显示系统的具体信息
	</div>
</div>
</body>
</html>
