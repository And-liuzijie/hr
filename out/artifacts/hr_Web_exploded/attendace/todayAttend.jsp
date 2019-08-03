<%--
  Created by IntelliJ IDEA.
  User: 刘子杰
  Date: 2019/7/4
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<<!DOCTYPE html>
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
<div class="row">
    <jsp:include page="/header.jsp"></jsp:include>


    <div id="content" class="col-md-10 col-xs-10 col-sm-10"
         style="padding-top: 0; margin: 0;">
        <div style="padding-top: 20px;">

                <%--<label class="control-label">请选择部门：</label>--%>
                <%--<select name="departId"--%>
                        <%--class="form-control" onchange="this.form.submit();">--%>
                    <%--<option>市场部</option>--%>
                    <%--<option>人事部</option>--%>
                    <%--<option>财务部</option>--%>
                <%--</select> <label class="control-label">请选择状态：</label>--%>
                <select	name="attendType" class="form-control"
                           >
                    <option>在职</option>
                </select>

            <table
                    class="table table-condensed table-hover table-bordered  table-striped"
                    style="margin-top: 20px;">
                <thead>
                <tr>
                    <th>职工编号</th>
                    <th>职工姓名</th>
                    <th>所属部门</th>
                    <th>日期</th>
                    <th>状态</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="ta" items="${attList}">
                <tr>
                    <td>${ta.empId}</td>
                    <td>${ta.employee.name}</td>
                    <td>${ta.employee.depName}</td>
                    <td>${ta.attendTime}</td>
                    <td>在职</td>
                </tr>
                </c:forEach>
                </tbody>
                <tfoot>
                <tr>
                    <td colspan="5" style="text-align:right;">
                        <ul class="pagination">
                            <li><a href="#" aria-label="Previous"> <span
                                    aria-hidden="true">&laquo;</span>
                            </a></li>
                            <li><a href="#">1</a></li>
                            <li><a href="#">2</a></li>
                            <li><a href="#">3</a></li>
                            <li><a href="#">4</a></li>
                            <li><a href="#">5</a></li>
                            <li><a href="#" aria-label="Next"> <span
                                    aria-hidden="true">&raquo;</span>
                            </a></li>
                        </ul>
                    </td>
                </tr>
                </tfoot>
            </table>
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
