<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
    <head>
    	<base href="/hr/">
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
        <title>表格</title>
        <link rel="shortcut icon" href="img/favicon.ico">
        <!-- Bootstrap3.3.5 CSS -->
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!-- datatime -->
		<link href="bootstrap/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
		<link href="css/main.css" rel="stylesheet">
		<script src="js/jquery-3.2.1.min.js "></script>
        <script src="bootstrap/js/bootstrap.min.js "></script>
        <script type="text/javascript" src="js/date.js"></script>
        <script type="text/javascript" src="bootstrap/js/bootstrap-datetimepicker.min.js"></script>
       	<script type="text/javascript" src="bootstrap/js/bootstrap-datetimepicker.zh-CN.js"></script>
	   <style>
			thead, tbody, th, tr, td{
				text-align: center;
			}
			table > tbody > tr > td{
				vertical-align: middle;
			}
	   </style>
    </head>
    <body>
        <div class="row">
    	<div class="header col-md-12 col-xs-12 col-sm-12">
    		<img alt="" src="image/logo2.png" style="height: 85px;">
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
                        <div id="collapseListGroup1" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="collapseListGroupHeading1">
                            <ul class="list-group">
                              <li class="list-group-item">
                                <!-- 利用data-target指定URL -->
                                <button class="menu-item-left" data-target="searchEmpByCondition.do">
                                    <span class="glyphicon glyphicon-triangle-right"></span>职工列表
                                </button>
                              </li>
                              <li class="list-group-item">
                                <button class="menu-item-left" data-target="emp/addEmp.jsp">
                                    <span class="glyphicon glyphicon-triangle-right"></span>添加职工
                                </button>
                              </li>
                             <!--  <li class="list-group-item">
                                <button class="menu-item-left">
                                    <span class="glyphicon glyphicon-triangle-right"></span>查询职工
                                </button>
                              </li> -->
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
                                <button class="menu-item-left"  data-target="departList.do">
                                    <span class="glyphicon glyphicon-triangle-right"></span>部门列表
                                </button>
                              </li>
                              <li class="list-group-item">
                                <button class="menu-item-left"  data-target="depart/addDepart.jsp">
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
                                <button class="menu-item-left" data-target="attendace/todayAttend.jsp">
                                    <span class="glyphicon glyphicon-triangle-right"></span>今日考勤
                                </button>
                              </li>
                              <li class="list-group-item">
                                <button class="menu-item-left" data-target="attendace/searchAttend.jsp">
                                    <span class="glyphicon glyphicon-triangle-right"></span>考勤查询
                                </button>
                              </li>
                              <li class="list-group-item">
                                <button class="menu-item-left" data-target="attendace/qiandao.jsp">
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
                                <button class="menu-item-left" data-target="extrawork/extraworkList.jsp">
                                    <span class="glyphicon glyphicon-triangle-right"></span>部门加班查询
                                </button>
                              </li>
                              <li class="list-group-item">
                                <button class="menu-item-left" data-target="extrawork/extraworkList.jsp">
                                    <span class="glyphicon glyphicon-triangle-right"></span>个人加班查询
                                </button>
                              </li>
                              <li class="list-group-item">
                                <button class="menu-item-left" data-target="extrawork/addExtrawork.jsp">
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
                                <!-- 利用data-target指定URL -->
                                <button class="menu-item-left" data-target="salary.jsp">
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
                                <button class="menu-item-left" data-target="attendace/applyHoliday.jsp">
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
                        <div id="collapseListGroup7" class="panel-collapse collapse" role="tabpanel" aria-labelledby="collapseListGroupHeading7">
                            <ul class="list-group">
                              <li class="list-group-item">
                                <!-- 利用data-target指定URL -->
                                <button class="menu-item-left" data-target="personal/personalPage.jsp">
                                    <span class="glyphicon glyphicon-triangle-right"></span>个人页面
                                </button>
                              </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div id="content" class="col-md-10 col-xs-10 col-sm-10" style="padding-top: 0;margin: 0;">
		<div  style="margin-top: 30px;">
			<form class="form-inline" action="searchEmpByCondition.do">
					<input type="search" name="deptName" class="form-control" value="${param.deptName }" placeholder="请输入部门名称">
					<input type="search" name="username" class="form-control" value="${param.username }" placeholder="请输入职工姓名">
					<input type="search" name="empId" class="form-control" value="${param.empId }" placeholder="请输入职工编号">
					<input type="search" name="downSalary" class="form-control" value="${param.downSalary }" placeholder="请输入职工最低薪资">
					<input type="search" name="upSalary" class="form-control" value="${param.upSalary}" placeholder="请输入职工最高薪资">
					<button type="submit" class="btn btn-primary">Search</button>
			</form>
		<div style="margin-top: 20px;">
			<table class="table_list table-condensed table-hover table-bordered  table-striped" >
				<thead>
					<tr>
						<th>编号</th>
						<th>姓名</th>
						<th>性别</th>
						<th>出生日期</th>
						<th>所属部门</th>
						<th>职位</th>
						<th>基本薪资</th>
						<th>电话</th>
						<th>详细信息</th>
					</tr>	
				</thead>
				<%-- <tbody>
					<c:forEach items="${emps}" var="emp">
						<tr>
							<td>${emp.id }</td>
							<td>${emp.name }</td>
							<td>${emp.gender }</td>
							<td><fmt:formatDate value="${emp.birthday}" pattern="yyyy-MM-dd"/></td>
							<td>${emp.deptID}</td>
							<td>${emp.impRole }</td>
							<td>${emp.salary }</td>
							<td>${emp.tel }</td>
							<td><a class="btn btn-primary btn-sm" href="viewEmp.do?id=${emp.id}">查看</a></td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="9" style="text-align: right;"> 
							<ul class="pagination">
								<c:if test="${param.currentPage-1>0}">
								    <li>
								      <a href="GetEmpServlet.do?currentPage=${param.currentPage-1 }&pageSize=7" aria-label="Previous">
								        <span aria-hidden="true">&laquo;</span>
								      </a>
								    </li>
							    </c:if>
							    <c:forEach begin="1" end="${pageCount }" step="1" var="page">
								    <li><a id="${page}" href="GetEmpServlet.do?currentPage=${page}&pageSize=7">${page }</a></li>
							    </c:forEach>
							     <c:if test="${param.currentPage+1 <= pageCount }">
								    <li>
								      <a href="GetEmpServlet.do?currentPage=${param.currentPage+1 }&pageSize=7" aria-label="Next">
								        <span aria-hidden="true">&raquo;</span>
								      </a>
								    </li>
							     </c:if>
							  </ul>
							  <script type="text/javascript">
							  	$("a[id="+${param.currentPage}+"]").addClass("active");
							  </script>
      					</td>
					</tr>
				</tfoot> --%>
				<tbody>
					<c:forEach items="${pageInfo.pageInfos}" var="emp">
						<tr>
							<td>${emp.id }</td>
							<td>${emp.name }</td>
							<td>${emp.gender }</td>
							<td><fmt:formatDate value="${emp.birthday}" pattern="yyyy-MM-dd"/></td>
							<td>${emp.department.name}</td>
							<td>${emp.impRole }</td>
							<td>${emp.salary }</td>
							<td>${emp.tel }</td>
							<td><a class="btn btn-primary btn-sm" href="viewEmp.do?id=${emp.id}">查看</a></td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="9" style="text-align: right;"> 
							<ul class="pagination">
								<c:if test="${param.currentPage-1>0}">
								    <li>
								      <a href="searchEmpByCondition.do?${condition}&currentPage=${param.currentPage-1 }&pageSize=7" aria-label="Previous">
								        <span aria-hidden="true">&laquo;</span>
								      </a>
								    </li>
							    </c:if>
							    <c:forEach begin="1" end="${pageInfo.pageCount }" step="1" var="page">
								    <li><a id="${page}" href="searchEmpByCondition.do?${condition}&currentPage=${page}&pageSize=7">${page }</a></li>
							    </c:forEach>
							     <c:if test="${param.currentPage+1 <= pageInfo.pageCount }">
								    <li>
								      <a href="searchEmpByCondition.do?${condition}&currentPage=${param.currentPage+1 }&pageSize=7" aria-label="Next">
								        <span aria-hidden="true">&raquo;</span>
								      </a>
								    </li>
							     </c:if>
							  </ul>
							  <script type="text/javascript">
							  	$("a[id="+${param.currentPage}+"]").addClass("active");
							  </script>
      					</td>
					</tr>
				</tfoot>
			</table>
</div>
</div>
        	</div>
        <script type="text/javascript" src="js/menu.js"></script>
        <script>
	        $(function(){
	        	$('#datetimepicker').datetimepicker({
	    			format: 'yyyy-mm-dd',  
	    			autoclose: true,
	    			minView:2
	    		});
	        });
        </script>
    </body>
</html>