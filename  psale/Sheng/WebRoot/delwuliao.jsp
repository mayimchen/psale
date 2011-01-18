<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
		<title>出库页面</title>
		<link href="css/mycss.css" rel="stylesheet" type="text/css" />
		<link href="css/mycss2.css" rel="stylesheet" type="text/css" />
		<link href="css/wrongmessage.css" rel="stylesheet" type="text/css" />
		<link href="css/circleconer.css" rel="stylesheet" type="text/css" />
		<link rel="shortcut icon" href="img/favicon.ico"/>
		<script language="javascript" src="js/jquery-1.4.2.js">
</script>
		<script language="javascript" src="js/commonplugin.js"></script>
		<script language="javascript" src="js/delwuliao.js">
</script>
	</head>
	<body>
		<h3 align="center">
			出库页面
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

						<div align="center">
							<form onsubmit="return checksubmit();"
								action="delwuliaoaction.action">
								<table cellpadding="0" cellspacing="0" bgcolor="#e7eef8"
									width="600" height="300">
									<tr>
										<td class="STYLE3">
											出库产品编号
										</td>
										<td>
											<input type="text" id="pid" name="pid" />
										</td>
									</tr>
									<tr>
										<td class="STYLE3">
											出库产品名称
										</td>
										<td>
											<input type="text" id="outname" name="outname"
												readonly="readonly" style="background: red" />
										</td>
									</tr>
									<tr>
										<td class="STYLE3">
											出库产品数量
										</td>
										<td>
											<input type="text" id="outnum" name="outnum"
												onblur="checkoutnum(this)" />
										</td>
									</tr>
									<tr>
										<td class="STYLE3">
											出库价格
										</td>
										<td>
											<input type="text" id="outprice" name="outprice"
												onblur="checkoutprice(this)" />
										</td>
									</tr>
									<tr>
										<td class="STYLE3">
											出库人员代码
										</td>
										<td>
											<input type="text" id="outuserid" name="outuserid" />
										</td>
									</tr>
									<tr>
										<td class="STYLE3">
											顾客姓名
										</td>
										<td>
											<input type="text" id="purchaser" name="purchaser"
												onblur="checkpurchaser(this)" />
										</td>
									</tr>
									<tr>
										<td colspan="2" align="center">
											<input type="submit" class="button" value="出库" />
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



		<div id="rmessage"></div>
		<div id="outnameerror">
			<div id="tip" class="tipgreen">
				<pre class="perclass">产品名称不能为空</pre>
			</div>
			<div id="bkimg" class="tip-arrow-bottom"></div>
		</div>
		<div id="outpriceerror">
			<div id="tip" class="tipgreen">
				<pre class="perclass">产品价格不能为空</pre>
			</div>
			<div id="bkimg" class="tip-arrow-bottom"></div>
		</div>
		<div id="outnumerror">
			<div id="tip" class="tipgreen">
				<pre class="perclass">产品数量必须为数字</pre>
			</div>
			<div id="bkimg" class="tip-arrow-bottom"></div>
		</div>
		<div id="outuseriderror">
			<div id="tip" class="tipgreen">
				<pre class="perclass">入库人员代码必须为数字</pre>
			</div>
			<div id="bkimg" class="tip-arrow-bottom"></div>
		</div>
		<div id="purchasererror">
			<div id="tip" class="tipgreen">
				<pre class="perclass">顾客姓名必须填写</pre>
			</div>
			<div id="bkimg" class="tip-arrow-bottom"></div>
		</div>
		<div id="outnamemessage">
			<div id="tip" class="tipgreen">
				<pre class="perclass" id="contentoutname"></pre>
			</div>
			<div id="bkimg" class="tip-arrow-bottom"></div>
		</div>
		<div id="outuseridmessage">
			<div id="tip" class="tipgreen">
				<pre class="perclass" id="contentuserid"></pre>
			</div>
			<div id="bkimg" class="tip-arrow-bottom"></div>
		</div>
		<div id="submitmessage">
			请仔细检查你的输入和提示信息
		</div>
	</body>
</html>