<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<base href="<%= request.getServletContext().getContextPath()%>/"> 
</head>
<body>
		<div class="header col-md-12 col-xs-12 col-sm-12">
			<img alt="" src="image/logo3.png" style="height: 85px;">
		</div>
		<div class="col-md-2 col-xs-2 col-sm-2">
            <div class="panel-group table-responsive" role="tablist">
                <div class="panel panel-primary leftMenu">
                    <!-- 利用data-target指定要折叠的分组列表 -->
                    <div class="panel-heading" id="collapseListGroupHeading1" data-toggle="collapse" data-target="#collapseListGroup1" role="tab" >
                        <h4 class="panel-title">
                           员工资料管理
                            <span class="glyphicon glyphicon-menu-up right"></span>
                        </h4>
                    </div>
                    <!-- .panel-collapse和.collapse标明折叠元素 .in表示要显示出来 -->
                    <div id="collapseListGroup1" class="panel-collapse collapse" role="tabpanel" aria-labelledby="collapseListGroupHeading1">
                        <ul class="list-group">
                          <li class="list-group-item">
                            <!-- 利用data-target指定URL -->
                           <button class="menu-item-left" data-target="allEmp">
                                <span class="glyphicon glyphicon-triangle-right"></span>职工列表
                            </button> 
                          </li>
                          <li class="list-group-item">
                            <button class="menu-item-left" data-target="SelectDepServlet">
                                <span class="glyphicon glyphicon-triangle-right"></span>添加职工
                            </button>
                          </li>
                        
                        </ul>
                    </div>
                </div><!--panel end-->
                <div class="panel panel-primary leftMenu">
                    <div class="panel-heading" id="collapseListGroupHeading2" data-toggle="collapse" data-target="#collapseListGroup2" role="tab" >
                        <h4 class="panel-title">
                            公司部门管理
                            <span class="glyphicon glyphicon-menu-down right"></span>
                        </h4>
                    </div>
                    <div id="collapseListGroup2" class="panel-collapse collapse" role="tabpanel" aria-labelledby="collapseListGroupHeading2">
                        <ul class="list-group">
                          <li class="list-group-item">
                          	<button class="menu-item-left" data-target="AllDepart">
                                <span class="glyphicon glyphicon-triangle-right"></span>部门列表
                            </button>
                          </li>
                          <li class="list-group-item">
                          	<button class="menu-item-left" data-target="../depart/addDepart.jsp">
                                <span class="glyphicon glyphicon-triangle-right"></span>添加部门
                            </button>
                          </li>
                        </ul>
                    </div>
                </div>  
            	<div class="panel panel-primary leftMenu">
                    <!-- 利用data-target指定要折叠的分组列表 -->
                    <div class="panel-heading" id="collapseListGroupHeading3" data-toggle="collapse" data-target="#collapseListGroup3" role="tab" >
                        <h4 class="panel-title">
                           员工考勤管理
                            <span class="glyphicon glyphicon-menu-up right"></span>
                        </h4>
                    </div>
                    <!-- .panel-collapse和.collapse标明折叠元素 .in表示要显示出来 -->
                    <div id="collapseListGroup3" class="panel-collapse collapse" role="tabpanel" aria-labelledby="collapseListGroupHeading3">
                        <ul class="list-group">
                          <li class="list-group-item">
                            <!-- 利用data-target指定URL -->
                          	<button class="menu-item-left" data-target="todayAttend">
                                <span class="glyphicon glyphicon-triangle-right"></span>今日考勤
                            </button>
                          </li>

                          <li class="list-group-item">
                            <button class="menu-item-left" data-target="../attendace/qiandao.jsp">
                                <span class="glyphicon glyphicon-triangle-right"></span>职工签到
                            </button> 
                          </li>
                        </ul>
                    </div>
                </div>
           		<div class="panel panel-primary leftMenu">
                    <!-- 利用data-target指定要折叠的分组列表 -->
                    <div class="panel-heading" id="collapseListGroupHeading4" data-toggle="collapse" data-target="#collapseListGroup4" role="tab" >
                        <h4 class="panel-title">
                           员工加班管理
                            <span class="glyphicon glyphicon-menu-up right"></span>
                        </h4>
                    </div>
                    <!-- .panel-collapse和.collapse标明折叠元素 .in表示要显示出来 -->
                    <div id="collapseListGroup4" class="panel-collapse collapse" role="tabpanel" aria-labelledby="collapseListGroupHeading4">
                       <ul class="list-group">
                              <li class="list-group-item">
                                <!-- 利用data-target指定URL -->
                                <button class="menu-item-left" data-target="../extrawork/depExtraworkList.jsp">
                                    <span class="glyphicon glyphicon-triangle-right"></span>部门加班查询
                                </button>
                              </li>
                              <li class="list-group-item">
                                <button class="menu-item-left" data-target="../emp/empExtraworkList.jsp">
                                    <span class="glyphicon glyphicon-triangle-right"></span>个人加班查询
                                </button>
                              </li>
                              <li class="list-group-item">
                               <button class="menu-item-left" data-target="../extrawork/addExtrawork.jsp">
                                    <span class="glyphicon glyphicon-triangle-right"></span>新增加班信息
                                </button>
                              </li>
                            </ul>
                    </div>
                </div>
            	<div class="panel panel-primary leftMenu">
                    <!-- 利用data-target指定要折叠的分组列表 -->
                    <div class="panel-heading" id="collapseListGroupHeading5" data-toggle="collapse" data-target="#collapseListGroup5" role="tab" >
                        <h4 class="panel-title">
                          职工薪资管理
                            <span class="glyphicon glyphicon-menu-up right"></span>
                        </h4>
                    </div>
                    <!-- .panel-collapse和.collapse标明折叠元素 .in表示要显示出来 -->
                    <div id="collapseListGroup5" class="panel-collapse collapse" role="tabpanel" aria-labelledby="collapseListGroupHeading5">
                        <ul class="list-group">
                          <li class="list-group-item">
                            <button class="menu-item-left" data-target="AllSal">
                                <span class="glyphicon glyphicon-triangle-right"></span>薪资汇总发放
                            </button>
                          </li>
                        </ul>
                    </div>
                </div>
               <div class="panel panel-primary leftMenu">
                        <!-- 利用data-target指定要折叠的分组列表 -->
                        <div class="panel-heading" id="collapseListGroupHeading6" data-toggle="collapse" data-target="#collapseListGroup6" role="tab" >
             				<h4 class="panel-title">
             假期情况管理
                                <span class="glyphicon glyphicon-menu-up right"></span>
                            </h4>
                        </div>
                        <!-- .panel-collapse和.collapse标明折叠元素 .in表示要显示出来 -->
                        <div id="collapseListGroup6" class="panel-collapse collapse" role="tabpanel" aria-labelledby="collapseListGroupHeading6">
                            <ul class="list-group">
                              <li class="list-group-item">
                                <!-- 利用data-target指定URL -->
                                <button class="menu-item-left" data-target="../attendace/applyHoliday.jsp">
                                    <span class="glyphicon glyphicon-triangle-right"></span>假期申请
                                </button>
                              </li>
                            </ul>
                        </div>
                    </div>
                    <div class="panel panel-primary leftMenu">
                        <!-- 利用data-target指定要折叠的分组列表 -->
                        <div class="panel-heading" id="collapseListGroupHeading7" data-toggle="collapse" data-target="#collapseListGroup7" role="tab" >
                            <h4 class="panel-title">
                               个人页面
                                <span class="glyphicon glyphicon-menu-up right"></span>
                            </h4>
                        </div>
                        <!-- .panel-collapse和.collapse标明折叠元素 .in表示要显示出来 -->
                        <div id="collapseListGroup7" class="panel-collapse collapse  in" role="tabpanel" aria-labelledby="collapseListGroupHeading7">
                            <ul class="list-group">
                              <li class="list-group-item">
                                <!-- 利用data-target指定URL -->
                                <button class="menu-item-left" data-target="userInfo">
                                    <span class="glyphicon glyphicon-triangle-right"></span>个人页面
                                </button>
                              </li>
                            </ul>
                        </div>
                    </div>
                </div>
        </div>
</body>
</html>