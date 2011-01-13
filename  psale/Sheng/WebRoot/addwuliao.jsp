<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
		<title>添加物料页面</title>
		<link href="css/mycss.css" rel="stylesheet" type="text/css" />
		<link href="css/mycss2.css" rel="stylesheet" type="text/css" />
		<link href="css/wrongmessage.css" rel="stylesheet" type="text/css" />
		<link href="css/circleconer.css" rel="stylesheet" type="text/css" />
		<link rel="shortcut icon" href="img/favicon.ico"/>
		<script language="javascript" src="js/jquery-1.4.2.js">
</script>
		<script language="javascript" src="js/addwuliao.js">
</script>
	</head>
	<body>
		<h3 align="center">
			入库页面
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
						<div id="addwuliao" align="center">
							<form onsubmit="return checksubmit();"
								action="addwuliaoaction.action">
								<table cellpadding="0" cellspacing="0" bgcolor="#e7eef8"
									width="600" height="300">
									<tr>
										<td class="STYLE3">
											入库产品编号
										</td>
										<td>
											<input type="text" id="pid" name="pid" />
										</td>
									</tr>

									<tr>
										<td class="STYLE3">
											入库产品名称
										</td>

										<td>
											<input type="text" id="inname" name="inname"
												onblur="checkinname(this)" />
										</td>
									</tr>
									<tr>
										<td class="STYLE3">
											入库产品数量
										</td>
										<td>
											<input type="text" id="innum" name="innum"
												onblur="checkinnum(this)" />

										</td>
									</tr>
									<tr>
										<td class="STYLE3">
											入库产品价格
										</td>
										<td>
											<input type="text" id="inprice" name="inprice"
												onblur="checkinprice(this)" />
										</td>
									</tr>
									<tr>
										<td class="STYLE3">
											入库人员代码
										</td>
										<td>
											<input type="text" id="inuserid" name="inuserid" />
										</td>
									</tr>
									<tr>
										<td class="STYLE3">
											入库产品信息
										</td>
										<td>
											<input type="text" id="detail" name="detail" />
										</td>
									</tr>
									<tr>
										<td colspan="2" align="center">
											<input type="submit" class="button" value="入库" />
										</td>
									</tr>
								</table>
							</form>
						</div>
					</div>

				</div>
				<div class="containbottom">
					<div class="bleft"></div>
					<div class="bright"></div>
				</div>
			</div>

		</div>

		<div id="piderror">
			<div id="tip" class="tipgreen">
				<pre class="perclass">产品编号不能为空</pre>
			</div>
			<div id="bkimg" class="tip-arrow-bottom"></div>
		</div>
		<div id="pidexisterror">
			<div id="tip" class="tipgreen">
				<pre class="perclass" id="pidexistmessage"></pre>
			</div>
			<div id="bkimg" class="tip-arrow-bottom"></div>
		</div>
		<div id="innameerror">
			<div id="tip" class="tipgreen">
				<pre class="perclass">产品名称不能为空</pre>
			</div>
			<div id="bkimg" class="tip-arrow-bottom"></div>
		</div>
		<div id="inpriceerror">
			<div id="tip" class="tipgreen">
				<pre class="perclass">产品价格不能为空</pre>
			</div>
			<div id="bkimg" class="tip-arrow-bottom"></div>
		</div>
		<div id="innumerror">
			<div id="tip" class="tipgreen">
				<pre class="perclass">产品数量必须为数字</pre>
			</div>
			<div id="bkimg" class="tip-arrow-bottom"></div>
		</div>
		<div id="inuseriderror">
			<div id="tip" class="tipgreen">
				<pre class="perclass">入库人员代码必须为数字</pre>
			</div>
			<div id="bkimg" class="tip-arrow-bottom"></div>
		</div>
		<div id="unuseridexit">
			<div id="tip" class="tipgreen">
				<pre class="perclass" id="content"></pre>
			</div>
			<div id="bkimg" class="tip-arrow-bottom"></div>
		</div>
		<div id="submitmessage">
			请仔细检查你的输入和提示信息
		</div>
	</body>
</html>