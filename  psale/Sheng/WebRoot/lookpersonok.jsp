<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
		<title>销售汇总显示页面</title>
		<link href="css/mycss.css" rel="stylesheet" type="text/css" />
		<link href="css/circleconer.css" rel="stylesheet" type="text/css" />
		<link rel="shortcut icon" href="img/favicon.ico"/>
		<script language="javascript" src="js/jquery-1.4.2.js">
</script>
		<script language="javascript" src="js/showallwuliao.js">
</script>

	</head>
	<body>
		<h3 align="center">
			销售汇总显示页面
		</h3>
		<a href="index2.jsp">返回首页</a>
		<hr />
		<div align="center">
			<div id="contain" class="contain2">
				<div class="containtop">
					<div class="tleft"></div>
					<div class="tright"></div>
				</div>
				<div class="containrcenter">
					<div class="containcenter">
						<div align="center">
							<table border="0" style="border: 1px solid #c3d9ff;"
								cellpadding="1" cellspacing="1" width="800">
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
										售出价格
									</td>
									<td>
										开单工号
									</td>
									<td>
										售出日期
									</td>
									<td>
										顾客姓名
									</td>
									<td>
										毛利
									</td>
								</tr>
								<s:iterator value="ls" status="ls">
									<tr bordercolor="#c3d9ff">
										<td>
											<s:property value="pid" />
										</td>
										<td>
											<s:property value="outname" />
										</td>
										<td>
											<s:property value="outnum" />
										</td>
										<td>
											<s:property value="outprice" />
										</td>
										<td>
											<s:property value="outuserid" />
										</td>
										<td>
											<s:property value="outdate" />
										</td>
										<td>
											<s:property value="purchaser" />
										</td>
										<td>
											<s:property value="maori" />
										</td>
									</tr>
								</s:iterator>
							</table>
							<br />
							<table border="0" style="border: 1px solid #c3d9ff;"
								cellpadding="1" cellspacing="1" width="800">
								<tr>
									<td>
										总销售额
									</td>
									<td id="sumsale">
										${sumsale}
									</td>
								</tr>
								<tr>
									<td>
										总毛利
									</td>
									<td id="summaori">
										${summaori}
									</td>
								</tr>
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
		<a href="lookpersonaction.action?userid=${userid}&startdate=${startdate}&enddate=${enddate}&pageNo=${pageNo-1}">&lt;&lt;上一页</a>
			目前是第
			<font color="red">${pageNo}</font>页,共
			<font color="red">${sumpage}</font>页
			<a href="lookpersonaction.action?userid=${userid}&startdate=${startdate}&enddate=${enddate}&pageNo=${pageNo+1}">下一页&gt;&gt;</a>
		</div>
	</body>
</html>