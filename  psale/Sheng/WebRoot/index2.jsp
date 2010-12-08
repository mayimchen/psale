<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
<link  href="base/jquery.ui.all.css" rel="stylesheet" />
<link  rel="stylesheet" href="css/mainpage.css"/>
<link  rel="stylesheet"  href="css/calender.css"/>
<script language="javascript" src="js/jquery-1.4.2.js"></script>
<script language="javascript" src="js/jquery.ui.core.js"></script>
<script language="javascript" src="js/jquery.ui.widget.js"></script>
<script language="javascript" src="js/jquery.ui.mouse.js"></script>
<script language="javascript" src="js/jquery.ui.draggable.js"></script>
<script language="javascript" src="js/jquery.ui.resizable.js"></script>
<script language="javascript"  src="js/calender2.js"></script>
<script language="javascript" src="js/start2.js"></script>
<script language="javascript" src="js/start.js"></script>
</head>
<body>
<div id="mainmenu" class="tts" style="visibility:visible;display:block;">
	<div id="login"><a href="#">登陆</a></div>
    <div id="close"><a href="#">关闭</a></div>
    <div id="tip"><a href="#">菜单</a></div>
    <div id="copyright"><font size="3" color="red"><a href="#">author:zqiangzhang@gmail.com</a></font></div>
</div>
<div id="menu">
<div align="center"><a href="#">测试一</a></div>
<div align="center"><a href="#">测试一</a></div>
<div align="center"><a href="#">测试一</a></div>
<div align="center"><a href="#">测试一</a></div>
<div align="center"><a href="#">测试一</a></div>
<div align="center"><a href="#">测试一</a></div>
<div align="center"><a href="#">测试一</a></div>
</div>
<div id="rlogin">
	登陆效果
</div>
<div id="zhezhao">
	
</div>
<div id="mainmenu2">
<div><a href="javascript:closecal()">关闭</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     <a href="javascript:comeback()" id="comeback">回到今天</a></div>
</div>
<div id="movemessage" onmouseover="divmouseover()">
  <div align="center" id="closetip"><a href="javascript:closemessage()" class="STYLE2">关闭</a></div>
  <div id="movemessage2"></div>
  </div>
</body>
</html>
