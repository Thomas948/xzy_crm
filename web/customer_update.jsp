<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
	<title>客户资源管理系统</title>
	<!-- 标签图标设置 -->
	<link rel="icon" href="images/favicon.ico" type="image/ico">
	<!-- SEO（搜索引擎所有关键件） -->
	<meta name="keywords" content="crm,qf">
	<meta name="description" content="这是一个解决中小企业客户资源管理的网站">
	<meta name="author" content="枫桥夜泊1990">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/materialdesignicons.min.css" rel="stylesheet">
	<link href="css/style.min.css" rel="stylesheet">
	<link rel="stylesheet" href="js/jconfirm/jquery-confirm.min.css">
</head>
  
<body>
<div class="lyear-layout-web">
  <div class="lyear-layout-container">
    <!--左侧导航-->
	  <jsp:include page="common/menus.jsp"/>
    <!--End 左侧导航-->
    
    <!--头部信息-->
    <header class="lyear-layout-header">
      
      <nav class="navbar navbar-default">
        <div class="topbar">
          
          <div class="topbar-left">
            <div class="lyear-aside-toggler">
              <span class="lyear-toggler-bar"></span>
              <span class="lyear-toggler-bar"></span>
              <span class="lyear-toggler-bar"></span>
            </div>
            <span class="navbar-page-title"> 客户 - 更新客户 </span>
          </div>

            <jsp:include page="common/header.jsp"/>
          
        </div>
      </nav>
      
    </header>
    <!--End 头部信息-->
    
    <!--页面主要内容-->
    <main class="lyear-layout-content">
      
      <div class="container-fluid">
        
        <!-- 表单 元素 start-->
		<div class="card">
		  <div class="card-body">
			
			<form class="form-horizontal" action="CustomerUpdateServlet" method="post">
			  <!-- 更新客户ID-->
			  <input type="hidden" value="${customer.customerId}" name="customerId"/>
			  <div class="form-group">
				<label class="col-md-3 control-label" for="customerName">客户名称</label>
				<div class="col-md-4">
				  <input class="form-control" type="text" id="customerName" name="customerName" value="${customer.customerName}">
				</div>
			  </div>
			  <div class="form-group">
				<label class="col-md-3 control-label" for="phone">手机</label>
				<div class="col-md-4">
				  <input class="form-control" type="text" id="phone" name="phone"  value="${customer.phone}">
				</div>
			  </div>
			  <div class="form-group">
				<label class="col-md-3 control-label" for="personLiable">负责人</label>
				<div class="col-md-4">
				  <select class="form-control" id="personLiable" name="personLiableId">
					  <c:forEach items="${employees}" var="emp">
					  	<option <c:if test="${emp.employeeId==customer.personLiableId}">selected</c:if> value="${emp.employeeId}">${emp.employeeName}</option>
					  </c:forEach>
				  </select>
				</div>
			  </div>
			  <div class="form-group">
				<label class="col-md-3 control-label" for="founder">创建人</label>
				<div class="col-md-4">
				  <select class="form-control" id="founder" name="founderId">
					  <c:forEach items="${employees}" var="emp">
						  <option <c:if test="${emp.employeeId==customer.founderId}">selected</c:if> value="${emp.employeeId}">${emp.employeeName}</option>
					  </c:forEach>
				  </select>
				</div>
			  </div>
			  <div class="form-group">
				<label class="col-md-3 control-label" for="sources">客户来源</label>
				<div class="col-md-4">
				  <select class="form-control" id="sources" name="sourceId">
					  <c:forEach items="${sources}" var="src">
						  <option <c:if test="${src.sourceId==customer.sourceId}">selected</c:if> value="${src.sourceId}">${src.sourceName}</option>
					  </c:forEach>
				  </select>
				</div>
			  </div>
			  <div class="form-group">
				<label class="col-md-3 control-label" for="industry">客户行业</label>
				<div class="col-md-4">
				  <select class="form-control" id="industry" name="industryId">
					  <c:forEach items="${industries}" var="industry">
						  <option <c:if test="${industry.industryId==customer.industryId}">selected</c:if> value="${industry.industryId}">${industry.industryName}</option>
					  </c:forEach>
				  </select>
				</div>
			  </div>
			  <div class="form-group">
				<label class="col-md-3 control-label" for="levels">客户级别</label>
				<div class="col-md-4">
				  <select class="form-control" id="levels" name="levelId">
					  <c:forEach items="${levels}" var="level">
						  <option <c:if test="${level.levelId==customer.levelId}">selected</c:if> value="${level.levelId}">${level.levelName}</option>
					  </c:forEach>
				  </select>
				</div>
			  </div>
			  
			  <div class="form-group">
				<label class="col-md-3 control-label" for="createTime">创建时间</label>
				<div class="col-md-4">
				  <input class="form-control js-datetimepicker" <%--type="date"--%> id="createTime" name="createTime" value="<fmt:formatDate value='${customer.createTime}'/>"/>
				</div>
			  </div>
			  
			  <div class="form-group">
				<label class="col-md-3 control-label" for="nextContactTime">下次联系时间</label>
				<div class="col-md-4">
				  <input class="form-control js-datetimepicker" <%--type="date"--%> id="nextContactTime" name="nextContactTime" value="<fmt:formatDate value='${customer.nextContactTime}'/>"/>
				</div>
			  </div>
			  <!-- 单选框-->
			  <div class="form-group">
				<label class="col-md-3 control-label">签约状态</label>
				<div class="col-md-4">
				  <label class="lyear-radio radio-inline radio-primary">
					  <input <c:if test="${customer.status==1}">checked</c:if> type="radio" name="e" value="1"><span>已签约</span>
				  </label>
					<label class="lyear-radio radio-inline radio-primary">
					  <input <c:if test="${customer.status==0}">checked</c:if> type="radio" name="e" value="0"><span>未签约</span>
					</label>
				</div>
			  </div>
			  <div class="form-group">
				<div class="col-md-9 col-md-offset-3">
				  <button class="btn btn-info btn-w-md" type="submit">保存</button>
				</div>
			  </div>
			</form>
			
		  </div>
		</div>
		<!-- 表单 元素 end-->
        
      </div>
      
    </main>
    <!--End 页面主要内容-->
  </div>
</div>

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/perfect-scrollbar.min.js"></script>
<!--时间选择插件-->
<script src="js/bootstrap-datetimepicker/moment.min.js"></script>
<script src="js/bootstrap-datetimepicker/bootstrap-datetimepicker.min.js"></script>
<script src="js/bootstrap-datetimepicker/locale/zh-cn.js"></script>
<!--日期选择插件-->
<script src="js/bootstrap-datepicker/bootstrap-datepicker.min.js"></script>
<script src="js/bootstrap-datepicker/locales/bootstrap-datepicker.zh-CN.min.js"></script>
<script type="text/javascript" src="js/main.min.js"></script>
<!--图表插件-->
<script type="text/javascript" src="js/Chart.js"></script>
<script src="js/jconfirm/jquery-confirm.min.js"></script>
</body>
</html>