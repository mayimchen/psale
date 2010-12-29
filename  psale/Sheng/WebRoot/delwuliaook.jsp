<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=GB18030">
<title>销售单</title>
<script language="javascript" src="js/jquery-1.4.2.js"></script>
<script language="javascript" src="js/controlprint.js"></script>
</head>
<body>
	<div align="center">
		<img src="img/print.jpg" style="cursor: pointer" id="pint"/>
		<table border="1" cellpadding="0" cellspacing="0" width="600" bordercolor="#c3d9ff">
			<tr align="center">
				<td colspan="2">xxx公司销售单</td>
			</tr>
			<tr>
				<td>产品名称</td>
				<td>${outname}</td>
			</tr>
			<tr>
				<td>购买数量</td>
				<td>${outnum}</td>
			</tr>
			<tr>
				<td>单价</td>
				<td>${outprice}</td>
			</tr>
			<tr>
				<td>顾客姓名</td>
				<td>${purchaser}</td>
			</tr>
			<tr>
				<td>购买日期</td>
				<td>${outdate}</td>
			</tr>
			<tr>
				<td>销售人员编号</td>
				<td>${outuserid}</td>
			</tr>
		</table>
	</div>
</body>
</html>