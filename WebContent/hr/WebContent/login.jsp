<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<title>Briup HR系统</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	
	<link href="bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="css/login.css" rel="stylesheet">
	</head>
<body>
<div class="container">
  <div class="loginBox row">
  		<h2 class="text-center">Briup HR系统登录</h2>
		<form id="hrlogin" name="hrlogin" action="login.do" method="post" class="form-horizontal">
		  <div class="form-group ">
		    <label for="nick_name" class="col-sm-2 col-md-2 control-label">用户名</label>
		    <div class="col-sm-10 col-md-10">
		      <input type="text" class="form-control" name="userId" placeholder="职工编号" value="">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="user_password" class="col-sm-2 col-md-2 control-label">密码</label>
		    <div class="col-sm-10 col-md-10">
		      <input type="password" class="form-control" name="password" placeholder="密码">
		    </div>
		  </div>
	  	  <div class="form-group">
	  	  	<div class="col-sm-offset-4 col-sm-10" style="color: #990033;"></div>
		  </div>
		  <div class="form-group">
		    <div class="col-sm-offset-4 col-sm-10 col-md-10">
		    	<input type="hidden" name="url" value="/admin"/>
		      	<button class="btn btn-info" data-loading-text="正在登录..." type="submit">登 录</button>
		      	    <button class="btn btn-info" type="reset">清 空</button>
		    </div>
		  </div>
  		</form>
	</div>
</div>
<!--.content-->
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
