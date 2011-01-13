<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
		<title>人员管理</title>
		<link href="css/mycss.css" rel="stylesheet" type="text/css" />
		<link href="css/circleconer.css" rel="stylesheet" type="text/css" />
		<link rel="shortcut icon" href="img/favicon.ico"/>
		<script language="javascript" src="js/jquery-1.4.2.js">
</script>
		<script language="javascript" src="js/showallperson.js">
</script>
		<script language="javascript" src="js/showusercontrol.js">
</script>
	</head>
	<body>
		<h3 align="center">
			人员管理
		</h3>
		<a href="index2.jsp">返回首页</a>
		<hr />
		<div align="center">
			<div id="contain" class="contain">
				<div class="containtop">
					<div class="tleft"></div>
					<div class="tright"></div>
				</div>
				<div class="containrcenter">

					<div class="containcenter">
						<div align="center" id="personmana">
							<table border="0" style="border: 1px solid #c3d9ff;"
								cellpadding="1" cellspacing="2" width="600">
								<tr background="img/back.png" height="30">
									<td>
										用户ID
									</td>
									<td>
										用户名
									</td>
									<td>
										用户密码
									</td>
									<td>
										员工状态
									</td>
									<td>
										员工权限
									</td>
									<td>
										编辑
									</td>
								</tr>
								<s:iterator value="ls" status="ls">
									<tr>
										<td id="<s:property value='userid'/>">
											<s:property value="userid" />
										</td>
										<td>
											<s:property value="username" />
										</td>
										<td>
											<s:property value="passwd" />
										</td>
										<td>
											<s:property value="existstate" />
										</td>
										<td>
											<s:property value="management" />
										</td>
										<td>
											<a href="javascript:edit(<s:property value="userid"/>)">编辑</a>
										</td>
									</tr>
								</s:iterator>
							</table>
						</div>

					</div>

				</div>
				<div class="containbottom">
					<div class="bleft"></div>
					<div class="bright"></div>
				</div>
			</div>
		</div>
		<div id="page" align="center">
			<a href="lookalluseraction.action?pageNo=${pageNo-1}">&lt;&lt;上一页</a>
			目前是第
			<font color="red">${pageNo}</font>页,共
			<font color="red">${sumpage}</font>页
			<a href="lookalluseraction.action?pageNo=${pageNo+1}">下一页&gt;&gt;</a>
		</div>

		<div id="lightbox"></div>
		<div id="edituser">
			<div id="title">
				<img src="img/close.gif" />
			</div>
			<div id="contentt">
				<table width="400" height="280" border="0" style="border: 1px solid #c3d9ff;"
								cellpadding="1" cellspacing="0">
					<tr>
						<td class="STYLE3">
							用户ID
						</td>
						<td>
							<input type="text" id="userid" readonly="readonly"
								style="background: red" />
						</td>
					</tr>
					<tr>
						<td class="STYLE3">
							用户名
						</td>
						<td>
							<input type="text" id="username" />
						</td>
					</tr>
					<tr>
						<td class="STYLE3">
							用户密码
						</td>
						<td>
							<input type="text" id="passwd" />
						</td>
					</tr>
					<tr>
						<td class="STYLE3">
							员工状态
						</td>
						<td>
							<select name="existstate" id="existstate">
								<option value="0">
									存在
								</option>
								<option value="1">
									不存在
								</option>
							</select>
						</td>
					</tr>
					<tr>
						<td class="STYLE3">
							员工权限
						</td>
						<td>
							<select name="management" id="management">
								<option value="0">
									读权限
								</option>
								<option value="1">
									读写权限
								</option>
								<option value="2">
									读写改权限
								</option>
								<option value="3">
									读写改删权限
								</option>
								<option value="4">
									admin
								</option>
							</select>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="button" id="save" class="button" value="保存" />
						</td>
					</tr>
				</table>
			</div>
		</div>
	</body>
</html>