<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
		<script src="js/jquery-3.2.1.min.js "></script>
        <script src="bootstrap/js/bootstrap.min.js "></script>
        <script type="text/javascript" src="js/date.js"></script>
        <script type="text/javascript" src="bootstrap/js/bootstrap-datetimepicker.min.js"></script>
       	<script type="text/javascript" src="bootstrap/js/bootstrap-datetimepicker.zh-CN.js"></script>
        <link href="css/main.css" rel="stylesheet">
        <script type="text/javascript">
        	var id = '${emp.deptID}';
        	$.getJSON("getAllDepart.do",function(data){
        		$(data).each(function(index,item){
        			console.log(item);
        			if(id==item.id){
	        			$("select[name=department]").append("<option value="+item.id+" selected='selected'>"+item.name+"</option>");
        			}else{
        				$("select[name=department]").append("<option value="+item.id+">"+item.name+"</option>");
        			}
        		});
        	});
        </script>
    </head>

    <body>
        <div class="row">
    	<div class="header col-md-12 col-xs-12 col-sm-12">
    		<img alt="" src="image/logo2.png">
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
            	<div id="ftdiv">
				<form class="form-horizontal" action="addEmp.do" method="post" enctype="application/x-www-form-urlencoded">
					<input type="hidden" value="${emp.id}" name="empid">
				<fieldset>
					<legend>信息详情</legend>
					<div class="form-group has-feedback">
							<label class="control-label col-md-2 col-xs-2 col-sm-2">职工姓名:</label>
							<div class="col-md-4 col-xs-4 col-sm-4">
								<input type="text" name="username" class="form-control" value="${emp.name}" disabled="disabled">
								<span class="glyphicon glyphicon-user form-control-feedback"></span>
							</div>
							 
					</div>
					<div class="form-group">
							<label class="control-label col-md-2 col-xs-2 col-sm-2">性别:</label>
							<div class="col-md-4 col-xs-4 col-sm-4 radio">
							   <c:if test='${emp.gender=="男"}'>
								<label>
									<input type="radio" name="gender" value="男" checked="checked" disabled="disabled">男
								</label>
								<label>
									<input type="radio" name="gender" value="女" disabled="disabled">女
								</label>
							   </c:if>
							   <c:if test='${emp.gender=="女"}'>
								   	<label>
										<input type="radio" name="gender" value="男"  disabled="disabled">男
									</label>
									<label>
										<input type="radio" name="gender" value="女" checked="checked" disabled="disabled">女
									</label>
							   </c:if>
							</div>
					</div>
					<div class="form-group has-feedback">
						  <label class="control-label col-md-2 col-xs-2 col-sm-2">出生日期:</label> 
						  <div class="col-md-4 col-xs-4 col-sm-4 input-append date" id="datetimepicker" data-date-format="yyyy-mm-dd">
						  	<fmt:formatDate value="${emp.birthday}" pattern="yyyy-MM-dd" scope="page" var="date"/>
					        <input class="form-control" size="16" type="text" name="birthday" value="${pageScope.date }" disabled="disabled">
					        <span class="add-on form-control-feedback"><i class="icon-th glyphicon glyphicon-calendar"></i></span>
					    </div>                            
					</div>
					<div class="form-group">
							<label class="control-label col-md-2 col-xs-2 col-sm-2">个人邮箱:</label>
							<div class="col-md-4 col-xs-4 col-sm-4">
								<input type="text" name="email" class="form-control" value="${emp.email }" disabled="disabled">
							</div>
							 
					</div>
					<div class="form-group">
							<label class="control-label col-md-2 col-xs-2 col-sm-2">个人电话:</label>
							<div class="col-md-4 col-xs-4 col-sm-4">
								<input type="text" name="telephone" class="form-control" value="${emp.tel }" disabled="disabled">
							</div>
					</div>
					<div class="form-group">
							<label class="control-label col-md-2 col-xs-2 col-sm-2">所属部门:</label>
							<div class="col-md-4 col-xs-4 col-sm-4">
								<select name="department" class="form-control" disabled="disabled">
									<!-- <option value="0">请选择</option>
									<option value="1" >市场部</option>
									<option value="2">技术部</option>
									<option value="3">人事部</option>
									<option value="4">财务部</option> -->
								</select>
							</div>
							<script type="text/javascript">
								var id = '${emp.deptID}';
								console.log("id:"+id);
								console.log($("option"));
								$("option").each(function(item){
									console.log("item:"+item);
									conosle.log("this:"+$(this).val());
									if(id==$(this).val()){
										$(this).attr("selected","selected");
									}
								});
							</script>
					</div>
					<div class="form-group">
							<label class="control-label col-md-2 col-xs-2 col-sm-2">职       位:</label>
							<div class="col-md-4 col-xs-4 col-sm-4">
								<select id="role" class="form-control" name="role" disabled="disabled">
									<option value="职工">职工</option>
									<option value="经理">经理</option>
									<option value="副经理">副经理</option>
								</select>
							</div>
					</div>
					<div class="form-group">
							<label class="control-label col-md-2 col-xs-2 col-sm-2">薪      资:</label>
							<div class="col-md-4 col-xs-4 col-sm-4">
								<input type="text" name="salary" class="form-control" value="${emp.salary }" disabled="disabled">
							</div>
					</div>
					</fieldset>
					<fieldset>
					<legend>个人简历</legend>
					<div class="form-group">
						<label class="control-label col-md-1 col-xs-1 col-sm-1"></label>
						<div class="col-md-5 col-xs-5 col-sm-5">
							<textarea class="form-control"  rows="5" cols="68" name="info" disabled="disabled">${emp.info }</textarea>
						</div>
					</div>
					</fieldset>
					<div class="form-group col-md-7 col-xs-7 col-sm-7"  style="text-align: center;">
						<!-- <input type="button" class="btn btn-success" value="返回" onclick="javascript:history.back();"/> -->
						<input type="button" class="btn btn-success" value="编辑" onclick="editor(this)">
						<input type="submit" class="btn btn-success" value="提 交" style="display: none;" />
					</div>
				</form>
			  </div>
            </div>
        </div>
        <script>
        function editor(btn){
        	$(btn).css("display","none");
        	$("input[type=submit]").css("display","");
        	$("*[disabled=disabled]").removeAttr("disabled");
        }
        $(function(){
        	$('#datetimepicker').datetimepicker({
    			format: 'yyyy-mm-dd',  
    			autoclose: true,
    			minView:2
    		});
        }); 
	    	var reqMsg = '${msg}';
	    	if((reqMsg!="")&&(reqMsg!=null)){
	    		alert(reqMsg);
	    	}
        </script>
        <script type="text/javascript" src="js/menu.js"></script>
    </body>

</html>