<%--
  Created by IntelliJ IDEA.
  User: 刘子杰
  Date: 2019/7/3
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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


        <div>
            <form action="ApplyHoliday" class="form-horizontal" style="margin-top: 20px;">
                <div class="form-group has-feedback">
                    <label class="control-label col-md-2 col-xs-2 col-sm-2">请假类型：</label>
                    <div class="col-md-4 col-xs-4 col-sm-4">
                        <select name="departId" class="form-control"
                                >
                            <option>事假</option>
                            <option>病假</option>
                            <option>婚假</option>
                            <option>产假</option>
                        </select>
                    </div>
                </div>
                <div class="form-group has-feedback">
                    <label class="control-label col-md-2 col-xs-2 col-sm-2">开始时间：</label>
                    <div class="col-md-4 col-xs-4 col-sm-4 input-append date"
                         id="datetimepicker1" data-date-format="yyyy-mm-dd">
                        <input class="form-control" size="16" type="text" name="startTime"> <span
                            class="add-on form-control-feedback"><i
                            class="icon-th glyphicon glyphicon-calendar"></i></span>
                    </div>
                </div>
                <div class="form-group has-feedback">
                    <label class="control-label col-md-2 col-xs-2 col-sm-2">结束时间：</label>
                    <div class="col-md-4 col-xs-4 col-sm-4 input-append date"
                         id="datetimepicker2" data-date-format="yyyy-mm-dd">
                        <input class="form-control" size="16" type="text" name="endTime"> <span
                            class="add-on form-control-feedback"><i
                            class="icon-th glyphicon glyphicon-calendar"></i></span>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-2 col-xs-2 col-sm-2">具体原因：</label>
                    <div class="col-md-4 col-xs-4 col-sm-4">
                        <textarea class="form-control" rows="5" cols="68" name="reason"></textarea>
                    </div>
                </div>
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
        $("span>input[type='text']").val(d.toDefineString());			});
</script>
</body>
</html>
