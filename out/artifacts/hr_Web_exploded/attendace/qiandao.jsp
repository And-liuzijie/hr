<%--
  Created by IntelliJ IDEA.
  User: 刘子杰
  Date: 2019/7/1
  Time: 9:03
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
    <link href="bootstrap/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
    <link href="css/main.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/sign.css"/>
</head>

<body>
<div class="row">
    <jsp:include page="/header.jsp"></jsp:include>
    <div id="content" class="col-md-10 col-xs-10 col-sm-10" style="padding-top: 0;margin: 0;">
        <div style="margin-top: 20px;">
            <div style="width:300px;height:300px;" id="calendar"></div>
        </div>
    </div>
</div>
<script src="js/jquery-3.2.1.min.js "></script>
<script src="bootstrap/js/bootstrap.min.js "></script>
<script type="text/javascript" src="js/date.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript" src="js/menu.js"></script>
<script type="text/javascript" src="js/qiandao.js"></script>
<script type="text/javascript">
    $(function(){
        $.ajax({
            url:"getData",
            type:"post",
            contentType:"application/json",
            success:function (data) {
                var signList=data;
                console.log(signList);


                //ajax 获取日历json数据
                var signList =JSON.parse(data);
                calUtil.init(signList);

            }

        });
        //ajax获取日历json数据
//        var signList=[{"signDay":"10","status":"1"},{"signDay":"11","status":"1"},
//            {"signDay":"12","status":"1"},{"signDay":"13","status":"2"}];
//        calUtil.init(signList);
    });
</script>
</body>

</html>