<%--
  Created by IntelliJ IDEA.
  User: 刘子杰
  Date: 2019/6/27
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <div id="ftdiv">
            <!-- <form class="form-horizontal" action="addEmp.do" method="post" enctype="multipart/form-data"> -->
            <form class="form-horizontal" action="AddEmpServlet" method="post"
                  enctype="application/x-www-form-urlencoded">
                <fieldset>
                    <legend>注册新员工</legend>
                    <div class="form-group has-feedback">
                        <label class="control-label col-md-2 col-xs-2 col-sm-2">职工姓名:</label>
                        <div class="col-md-4 col-xs-4 col-sm-4">
                            <input type="text" name="username" class="form-control">
                            <span class="glyphicon glyphicon-user form-control-feedback"></span>
                        </div>

                    </div>
                    <div class="form-group has-feedback">
                        <label class="control-label col-md-2 col-xs-2 col-sm-2">职工密码:</label>
                        <div class="col-md-4 col-xs-4 col-sm-4">
                            <input type="text" name="password" class="form-control">

                        </div>

                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-2 col-xs-2 col-sm-2">性别:</label>
                        <div class="col-md-4 col-xs-4 col-sm-4 radio">
                            <label> <input type="radio" name="gender" value="男">男
                            </label> <label> <input type="radio" name="gender" value="女">女
                        </label>
                        </div>
                    </div>
                    <div class="form-group has-feedback">
                        <label class="control-label col-md-2 col-xs-2 col-sm-2">出生日期:</label>
                        <div class="col-md-4 col-xs-4 col-sm-4 input-append date"
                             id="datetimepicker" data-date-format="yyyy-mm-dd">
                            <input class="form-control" size="16" type="text"
                                   name="birthday"> <span
                                class="add-on form-control-feedback"><i
                                class="icon-th glyphicon glyphicon-calendar"></i></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-2 col-xs-2 col-sm-2">个人邮箱:</label>
                        <div class="col-md-4 col-xs-4 col-sm-4">
                            <input type="text" name="email" class="form-control">
                        </div>

                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-2 col-xs-2 col-sm-2">个人电话:</label>
                        <div class="col-md-4 col-xs-4 col-sm-4">
                            <input type="text" name="telephone" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-2 col-xs-2 col-sm-2">所属部门:</label>
                        <div class="col-md-4 col-xs-4 col-sm-4">
                            <select name="department" class="form-control">
                                <c:forEach items="${depList}" var="dep">
                                    <option value="${dep.id}-${dep.name}">${dep.name}</option>
                                </c:forEach>


                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-2 col-xs-2 col-sm-2">职
                            位:</label>
                        <div class="col-md-4 col-xs-4 col-sm-4">
                            <select class="form-control" name="role">
                                <option value="1">职工</option>
                                <option value="2">经理</option>
                                <option value="2">副经理</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-2 col-xs-2 col-sm-2">薪
                            资:</label>
                        <div class="col-md-4 col-xs-4 col-sm-4">
                            <input type="text" name="salary" class="form-control">
                        </div>
                    </div>
                    <!-- <div class="form-group">
                        <label class="control-label col-md-2 col-xs-2 col-sm-2">头     像:</label>
                        <div class="col-md-4 col-xs-4 col-sm-4">
                            <input type="file" name="icon">
                        </div>
                </div> -->
                </fieldset>
                <fieldset>
                    <legend>个人简历</legend>
                    <div class="form-group">
                        <label class="control-label col-md-1 col-xs-1 col-sm-1"></label>
                        <div class="col-md-5 col-xs-5 col-sm-5">
                            <textarea class="form-control" rows="5" cols="68" name="info"></textarea>
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
</body>

</html>

