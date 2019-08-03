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
    <style>
        <!--
        thead, tbody, th, tr, td {
            text-align: center;
        }
        -->
    </style>
</head>

<body>
<div class="row">
    <jsp:include page="/header.jsp"></jsp:include>
    <div id="content" class="col-md-10 col-xs-10 col-sm-10"
         style="padding-top: 0; margin: 0;">



        <div style="margin-top: 30px;">
            <form class="form-inline" action="EmpExtraWork" method="get">
                    <input type="search" name="empId" class="form-control"
                      placeholder="请输入姓名">  <%-- <label class="control-label">开始时间：</label>--%>
                <%--<span class="form-group has-feedback input-append date"--%>
                      <%--id="datetimepicker1" data-date-format='yyyy-mm-dd'> <input--%>
                        <%--class="form-control" name="beginTime" size="16" type="text">--%>
						<%--<span class="add-on form-control-feedback"><i--%>
                                <%--class="icon-th glyphicon glyphicon-calendar"></i></span>--%>
					<%--</span> <label class="control-label">结束时间：</label> <span--%>
                    <%--class="form-group has-feedback input-append date"--%>
                    <%--id="datetimepicker2" data-date-format='yyyy-mm-dd'> <input--%>
                    <%--class="form-control" name="endTime" size="16" type="text">--%>
						<span class="add-on form-control-feedback"><i
                                class="icon-th glyphicon glyphicon-calendar"></i></span>
					</span>
                <button type="submit" class="btn btn-primary">Search</button>
            </form>
            <div class="table-responsive" style="margin-top: 20px;">
                <table
                        class="table_list table-condensed table-hover table-bordered  table-striped">
                    <caption>加班信息列表</caption>
                    <thead>
                    <tr>
                        <th>职工编号</th>
                        <th>职工姓名</th>
                        <th>所属部门</th>
                        <th>加班日期</th>
                        <th>加班原因</th>
                        <%--<th>^_^</th>--%>
                        <%--<th>^_^</th>--%>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="extraWork" items="${extraworkList}">
                        <tr>
                            <td>${extraWork.empid}</td>
                            <td>${extraWork.employee.name}</td>
                            <td>${extraWork.employee.depName}</td>
                            <td>${extraWork.starttime}</td>
                            <td>${extraWork.reason}</td>

                        </tr>
                    </c:forEach>


                    </tbody>
                    <tfoot>
                    <tr>
                        <td colspan="8" style="text-align: right;">
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
        $('#datetimepicker1').datetimepicker({
            format : 'yyyy-mm-dd',
            autoclose : true,
            minView : 2
        });
        $('#datetimepicker2').datetimepicker({
            format : 'yyyy-mm-dd',
            autoclose : true,
            minView : 2
        });
        var d = new Date();
        $("span>input[type='text']").val(d.toDefineString());
    });
</script>
</body>

</html>
