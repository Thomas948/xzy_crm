<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                        <span class="navbar-page-title"> 线索 - 添加线索 </span>
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

                        <form class="form-horizontal" action="ThreadAddServlet" method="post">
                            <div class="form-group">
                                <label class="col-md-3 control-label" for="example-hf-thread">线索名称</label>
                                <div class="col-md-4">
                                    <input class="form-control" type="text" id="example-hf-thread" name="customerName"  placeholder="请输入线索名称..">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label" for="example-hf-phone">手机</label>
                                <div class="col-md-4">
                                    <input class="form-control" type="text" id="example-hf-phone" name="phone"  placeholder="请输入手机号..">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label" for="charge_man">负责人</label>
                                <div class="col-md-4">
                                    <select class="form-control" id="charge_man" name="personLiableId">
                                        <c:forEach items="${employees}" var="emp">
                                            <option value="${emp.employeeId}">${emp.employeeName}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label" for="founder">创建人</label>
                                <div class="col-md-4">
                                    <select class="form-control" id="founder" name="founderId">
                                        <c:forEach items="${employees}" var="emp">
                                            <option value="${emp.employeeId}">${emp.employeeName}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label" for="source">线索来源</label>
                                <div class="col-md-4">
                                    <select class="form-control" id="source" name="sourceId">
                                        <c:forEach items="${sources}" var="src">
                                            <option value="${src.sourceId}">${src.sourceName}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label" for="industry">客户行业</label>
                                <div class="col-md-4">
                                    <select class="form-control" id="industry" name="industryId">
                                        <c:forEach items="${industries}" var="industry">
                                            <option value="${industry.industryId}">${industry.industryName}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label" for="level">客户级别</label>
                                <div class="col-md-4">
                                    <select class="form-control" id="level" name="levelId">
                                        <c:forEach items="${levels}" var="level">
                                            <option value="${level.levelId}">${level.levelName}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-3 control-label" for="next_contact_time">下次联系时间</label>
                                <div class="col-md-4">
                                    <input class="form-control js-datepicker" type="text" data-date-format="yyyy-mm-dd" id="next_contact_time" name="nextContactTime" placeholder="年-月-日">
                                </div>
                            </div>
                            <!-- 单选框-->
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