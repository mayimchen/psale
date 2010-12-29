<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
		<title>添加新用户</title>
		<link href="css/mycss.css" rel="stylesheet" type="text/css" />
		<link href="css/mycss2.css" rel="stylesheet" type="text/css" />
		<link href="css/wrongmessage.css" rel="stylesheet" type="text/css" />
		<script language="javascript" src="js/jquery-1.4.2.js"></script>
		<script language="javascript" src="js/adduser.js"></script>
		<style type="text/css">
<!--
.STYLE4 {
	font-family: "楷体_GB2312"
}
-->
</style>
	</head>
	<body>
		<h3 align="center">
			添加新用户页面
		</h3>
		<a href="index2.jsp">返回首页</a>
		<hr />
		<div id="adduser">
			<div align="center">
				<form name="form3" method="post" action="adduseraction.action"
					onSubmit="return tijiao();">
					<table cellpadding="0" cellspacing="0" bgcolor="#e7eef8">
						<tr>
							<td colspan="2">
								<div align="center" class="STYLE3 STYLE4">
									添加新用户
								</div>
							</td>
						</tr>
						<tr>
							<td class="STYLE3">
								用户ID
							</td>
							<td>
								<input type="text" name="userid" id="userid">
							</td>
						</tr>
						<tr>
							<td class="STYLE3">
								用户名
							</td>
							<td>
							<input type="text" name="username" id="username" onblur="checkusername(this)">
							</td>
						</tr>
						<tr>
							<td class="STYLE3">
								用户密码
							</td>
							<td>
								<input type="text" name="passwd" id="passwd"
									onblur="checkpasswd(this)">
							</td>
						</tr>
						<tr>
							<td class="STYLE3">
								员工状态
							</td>
							 <td>
					            <select name="existstate" id="existstate">
					              <option value="0">存在</option>
					              <option value="1">不存在</option>
					            </select>
				          </td>
						</tr>
						<tr>
							<td class="STYLE3">
								员工权限
							</td>
							<td>
					            <select name="management" id="management">
					              <option value="0">0</option>
					              <option value="1">1</option>
					              <option value="2">2</option>
					              <option value="3">3</option>
					              <option value="4">4</option>
					            </select>
				          </td>
						</tr>
						<tr>
							<td colspan="2">
								<div align="center">
									<input type="submit" class="STYLE3" value="添加">
								</div>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<div id="useriderror">
			<div id="tip" class="tipgreen">
				<pre class="perclass">用户ID为数字组成</pre>
			</div>
			<div id="bkimg" class="tip-arrow-bottom"></div>
		</div>
		<div id="passwderror">
			<div id="tip2" class="tipgreen">
				<pre class="perclass">密码格式不对哦</pre>
			</div>
			<div id="bkimg2" class="tip-arrow-bottom"></div>
		</div>
		<div id="usernameerror">
			<div id="tip2" class="tipgreen">
				<pre class="perclass">用户名不能为空</pre>
			</div>
			<div id="bkimg2" class="tip-arrow-bottom"></div>
		</div>
		<div id="usermessage">
			<div id="tip2" class="tipgreen">
				<pre class="perclass" id="useridcontent"></pre>
			</div>
			<div id="bkimg2" class="tip-arrow-bottom"></div>
		</div>
		<div id="submitmessage">
			请仔细检查你的输入和提示信息
		</div>
	</body>
</html>