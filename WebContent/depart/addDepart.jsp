<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>表格</title>
<base href="<%= request.getServletContext().getContextPath()%>/">
<link rel="shortcut icon" href="img/favicon.ico">
<!-- Bootstrap3.3.5 CSS -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- datatime -->
<link href="bootstrap/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet">
<link href="css/main.css" rel="stylesheet">
</head>

<body>
<c:if test="${! empty msg}">
	<script type="text/javascript">
        alert('${msg}');
	</script>
</c:if>


	<div class="row">
	    
	    <jsp:include page="/header.jsp"></jsp:include>
	    
		<div id="content" class="col-md-10 col-xs-10 col-sm-10"
			style="padding-top: 0; margin: 0;">


			<div id="addDepart">
				<form class="form-horizontal" action="addDep" method="post">
					<fieldset>
						<legend>添加部门</legend>
						<div class="form-group has-feedback">
							<label class="control-label col-md-2 col-xs-2 col-sm-2">部门编号:</label>
							<div class="col-md-4 col-xs-4 col-sm-4">
								<input type="text" name="departId" class="form-control">
								<span class="glyphicon glyphicon-user form-control-feedback"></span>
							</div>

						</div>c
						<div class="form-group has-feedback">
							<label class="control-label col-md-2 col-xs-2 col-sm-2">部门名称:</label>
							<div class="col-md-4 col-xs-4 col-sm-4">
								<input type="text" name="departname" class="form-control">
								<span class="glyphicon glyphicon-user form-control-feedback"></span>
							</div>

						</div>
						<div class="form-group">
							<label class="control-label col-md-2 col-xs-2 col-sm-2">部门描述：</label>
							<div class="col-md-4 col-xs-4 col-sm-4">
								<textarea rows="5" cols="68" name="info"></textarea>
							</div>
						</div>
					</fieldset>
					<div class="form-group col-md-7 col-xs-7 col-sm-7"
						style="text-align: center;">
						<input type="submit" class="btn btn-success" value="提 交" />
					</div>
				</form>
			</div>
		</div>
	</div>
	<script src="js/jquery-3.2.1.min.js "></script>
	<script src="bootstrap/js/bootstrap.min.js "></script>
	<script type="text/javascript" src="js/date.js"></script>
	<script type="text/javascript"
		src="bootstrap/js/bootstrap-datetimepicker.min.js"></script>
	<script type="text/javascript"
		src="bootstrap/js/bootstrap-datetimepicker.zh-CN.js"></script>
	<script type="text/javascript" src="js/menu.js"></script>
	<script>
		$(function() {
			$('#datetimepicker').datetimepicker();
		});
	</script>
</body>

</html>

    