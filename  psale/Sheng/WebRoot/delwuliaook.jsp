<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=GB18030">
		<title>销售单</title>
		<link href="css/circleconer.css" rel="stylesheet" type="text/css" />
		<link rel="shortcut icon" href="img/favicon.ico"/>
		<script language="javascript" src="js/jquery-1.4.2.js">
</script>
		<script language="javascript" src="js/controlprint.js">
</script>
	</head>
	<body>
		<div align="center">
			<img src="img/print.jpg" style="cursor: pointer" id="pint" />
			<div id="contain" class="contain">
				<div class="containtop">
					<div class="tleft"></div>
					<div class="tright"></div>
				</div>
				<div class="containrcenter">
					<div class="containcenter">
						<table border="0" style="border: 1px solid #c3d9ff;"
							cellpadding="1" cellspacing="1" width="600" height="300">
							<tr align="center">
								<td colspan="2">
									xxx公司销售单
								</td>
							</tr>
							<tr>
								<td>
									产品名称
								</td>
								<td align="center">
									${outname}
								</td>
							</tr>
							<tr>
								<td>
									购买数量
								</td>
								<td align="center">
									${outnum}
								</td>
							</tr>
							<tr>
								<td>
									单价
								</td>
								<td align="center">
									${outprice}
								</td>
							</tr>
							<tr>
								<td>
									顾客姓名
								</td>
								<td align="center">
									${purchaser}
								</td>
							</tr>
							<tr>
								<td>
									购买日期
								</td>
								<td align="center">
									${outdate}
								</td>
							</tr>
							<tr>
								<td>
									销售人员编号
								</td>
								<td align="center">
									${outuserid}
								</td>
							</tr>
						</table>
					</div>
				</div>
				<div class="containbottom">
					<div class="bleft"></div>
					<div class="bright"></div>
				</div>
			</div>
		</div>
	</body>
</html>