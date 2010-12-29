<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
		<title>显示所有库存</title>
		<link href="css/mycss.css" rel="stylesheet" type="text/css" />
		<script language="javascript" src="js/jquery-1.4.2.js"></script>
		<script language="javascript" src="js/showallwuliao.js"></script>
	</head>
	<body>
	<h3 align="center">以下是所有库存显示页面</h3>
	<a href="index2.jsp">返回首页</a>
	<hr/>
		<div align="center">
		<table border="1" cellpadding="0" cellspacing="0" width="600" bordercolor="#c3d9ff">
			<tr bordercolor="#c3d9ff">
				<td>
					编号
				</td>
				<td>
					名称
				</td>
				<td>
					数量
				</td>
				<td>
					价格
				</td>
				<td>
					开单工号
				</td>
				<td>
					日期
				</td>
				<td>
					备注信息
				</td>
			</tr>
			<s:iterator value="wuliaolist" status="ls">
				<tr bordercolor="#c3d9ff">
					<td>
						<s:property value="pid" />
					</td>
					<td>
						<s:property value="inname" />
					</td>
					<td>
						<s:property value="innum" />
					</td>
					<td>
						<s:property value="inprice" />
					</td>
					<td>
						<s:property value="inuserid" />
					</td>
					<td>
						<s:property value="indate" />
					</td>
					<td>
						<s:property value="productsdetail" />
					</td>
				</tr>
			</s:iterator>
		</table>
		</div>
	</body>
</html>