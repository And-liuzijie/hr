<%@ page contentType="text/html; charset=GBK" language="java"%>
<html>
	<head><meta http-equiv="Content-Type" content="text/html; charset=GBK"/>
		<title><s:text name="mainmanage.title"/></title>
		<link href="images/style.css" rel="stylesheet" type="text/css"/>
		<link href="images/mainstyle.css" rel="stylesheet" type="text/css"/>
		<link href="images/departListstyle.css" rel="stylesheet" type="text/css"/>
		<link href="images/impdetail.css" rel="stylesheet" type="text/css"/>
		<script language="JavaScript" src="images/manage.js"></script>
		<script language="JavaScript">
		function mymouseout(id,styleclass)
		{
			document.getElementById(id).className=styleclass;
		}
		</script>
		<s:head/>
	</head>
	<body>
	<div id="container">
		
		<div id="tophead">
			<s:include value="Top.jsp"/>
		</div>
		<div id="leftcontent">
			<s:include value="LeftTree2.jsp"/>
		</div>
		<div id="maincontent">
		<div style="width:600px;margin-left:20px;text-align:center;">
			<div id="infohead"><s:property value="imp.impName"/>的详细信息</div>
		<div id="pic">
			<div style="width:200px;height:175px;">
				<img id="personpic" src="<s:property value="imp.impPic"/>" onload="changePic('personpic');">
			</div>
			
			<span><s:property value="imp.impName"/>的头像</span>
		</div>
		
		<div id="info">
			<table>
				<tr class="evenrow">
					<td>职工编号：</td>
					<td><s:property value="imp.impId"/></td>
				</tr>
				<tr class="oddrow">
					<td>职工姓名：</td>
					<td><s:property value="imp.impName"/></td>
				</tr>
				<tr class="evenrow">
					<td>职工性别：</td>
					<td><s:property value="imp.impGender"/></td>
				</tr>
				<tr class="oddrow">
					<td>出生日期：</td>
					<td><s:property value="imp.impBirth"/></td>
				</tr>
				<tr class="evenrow">
					<td>个人邮箱：</td>
					<td><s:property value="imp.impEmail"/></td>
				</tr>
				<tr class="oddrow">
				 	<td>个人电话：</td>
					<td><s:property value="imp.impTel"/></td>
				</tr>
				<tr class="evenrow">
					<td>所属部门：</td>
					<td><s:property value="imp.departName"/></td>
				</tr>
				<tr class="oddrow">
					<td>职  位：</td>
					<td><s:property value="imp.impRoll"/></td>
				</tr>
				<tr class="evenrow">
					<td>薪  资：</td>
					<td><s:property value="imp.impSalary"/></td>
				</tr>
			</table>
		</div>
		<div style="clear:both;"></div>
		<div id="jianli">
			<fieldset>
				<legend>个人简历</legend>
				
				<p><s:property value="imp.impBio"/></p>
			</fieldset>
		</div>
		</div>
		</div>
	</div>
	</body>
</html>