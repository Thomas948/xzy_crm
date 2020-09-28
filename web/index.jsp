<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <%--<script src="${pageContext.request.contextPath}/js/highcharts.js"></script>
    <script src="${pageContext.request.contextPath}/js/exporting.js"></script>
    <script src="${pageContext.request.contextPath}/js/drilldown.js"></script>--%>
    <script src="https://code.highcharts.com.cn/highcharts/highcharts.js"></script>
    <script src="https://code.highcharts.com.cn/highcharts/modules/exporting.js"></script>
    <script src="https://code.highcharts.com.cn/highcharts/modules/drilldown.js"></script>
    <script src="https://img.hcharts.cn/highcharts-plugins/highcharts-zh_CN.js"></script>
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
            <span class="navbar-page-title"> 菜单 </span>
          </div>

          <jsp:include page="common/header.jsp"/>

        </div>
      </nav>

    </header>
    <!--End 头部信息-->

    <!--页面主要内容-->
    <main class="lyear-layout-content">

      <div class="container-fluid">

        <div class="row">
          <div class="col-sm-6 col-lg-3">
            <div class="card bg-primary">
              <div class="card-body clearfix">
                <div class="pull-right">
                  <p class="h6 text-white m-t-0">本月收入</p>
                  <p id="incomeMonth" class="h3 text-white m-b-0"></p>
                </div>
                <div class="pull-left"> <span class="img-avatar img-avatar-48 bg-translucent"><i class="mdi mdi-currency-cny fa-1-5x"></i></span> </div>
              </div>
            </div>
          </div>

          <div class="col-sm-6 col-lg-3">
            <div class="card bg-danger">
              <div class="card-body clearfix">
                <div class="pull-right">
                  <p class="h6 text-white m-t-0">去年收入</p>
                  <p id="incomeLastYear" class="h3 text-white m-b-0"></p>
                </div>
                <div class="pull-left"> <span class="img-avatar img-avatar-48 bg-translucent"><i class="mdi mdi-account fa-1-5x"></i></span> </div>
              </div>
            </div>
          </div>

          <div class="col-sm-6 col-lg-3">
            <div class="card bg-success">
              <div class="card-body clearfix">
                <div class="pull-right">
                  <p class="h6 text-white m-t-0">去年用户新增</p>
                  <p id="customerIncrementLastYear" class="h3 text-white m-b-0"></p>
                </div>
                <div class="pull-left"> <span class="img-avatar img-avatar-48 bg-translucent"><i class="mdi mdi-arrow-down-bold fa-1-5x"></i></span> </div>
              </div>
            </div>
          </div>

          <div class="col-sm-6 col-lg-3">
            <div class="card bg-purple">
              <div class="card-body clearfix">
                <div class="pull-right">
                  <p class="h6 text-white m-t-0">用户量</p>
                  <p id="customerCount" class="h3 text-white m-b-0"></p>
                </div>
                <div class="pull-left"> <span class="img-avatar img-avatar-48 bg-translucent"><i class="mdi mdi-comment-outline fa-1-5x"></i></span> </div>
              </div>
            </div>
          </div>
        </div>

        <div class="row">

            <div class="col-lg-6">
                <div class="card">
                    <div class="card-body">
                        <div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
                    </div>
                </div>
            </div>

            <div class="col-lg-6">
                <div class="card">
                    <div class="card-body">
                        <div id="container1" style="max-width:800px;height:400px"></div>
                    </div>
                </div>
            </div>

        </div>

        <div class="row">

          <div class="col-lg-12">
            <div class="card">
              <div class="card-header">
                <h4>任务列表</h4>
              </div>
              <div class="card-body">
                <div class="table-responsive">
                  <table class="table table-hover">
                    <thead>
                      <tr>
                        <th>任务编号</th>
                        <th>任务名称</th>
                        <th>状态</th>
                        <th>进度</th>
                      </tr>
                    </thead>
                    <tbody>
                      <c:forEach items="${contractList}" var="contract">
                          <tr>
                              <td>${contract.contractId}</td>
                              <td>${contract.contractName}</td>
                              <td>
                                  <c:if test="${contract.flag==0||contract.flag==1}">
                                      <span class="label label-info">进行中</span></td>
                                  </c:if>
                                  <c:if test="${contract.flag==2||contract.flag==4}">
                                      <span class="label label-danger">审批结束(未通过)</span></td>
                                  </c:if>
                                  <c:if test="${contract.flag==3}">
                                      <span class="label label-success">已完成</span></td>
                                  </c:if>
                              <td>
                                  <c:if test="${contract.flag==0}">
                                      <c:if test="${employee.employeeId==contract.employee01Id}">
                                          <a href="ApprovalServlet?flag=1&status=1&employeeId=${employee.employeeId}&contractId=${contract.contractId}" class="label label-success">通过</a>
                                          <a href="ApprovalServlet?flag=2&status=1&employeeId=${employee.employeeId}&contractId=${contract.contractId}" class="label label-danger">不通过</a>
                                      </c:if>
                                      <c:if test="${employee.employeeId==contract.employee02Id}">
                                          <span class="label label-info">待其他审批人审批</span>
                                      </c:if>
                                  </c:if>
                                  <c:if test="${contract.flag==1}">
                                      <c:if test="${employee.employeeId==contract.employee02Id}">
                                          <a href="ApprovalServlet?flag=3&status=2&employeeId=${employee.employeeId}&contractId=${contract.contractId}" class="label label-success">通过</a>
                                          <a href="ApprovalServlet?flag=4&status=2&employeeId=${employee.employeeId}&contractId=${contract.contractId}" class="label label-danger">不通过</a>
                                      </c:if>
                                      <c:if test="${employee.employeeId==contract.employee01Id}">
                                          <span class="label label-info">待其他审批人审批</span>
                                      </c:if>
                                  </c:if>
                                  <c:if test="${contract.flag==3}">
                                      <span class="label label-info">审批通过</span>
                                  </c:if>
                                  <c:if test="${contract.flag==2||contract.flag==4}">
                                      <span class="label label-danger">审批未通过</span>
                                  </c:if>
                              </td>
                          </tr>
                      </c:forEach>


                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>

        </div>

      </div>

    </main>
    <!--End 页面主要内容-->
  </div>
</div>

<!-- 导入线索模态框 start -->
 <div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel" id="gridSystemModal">
  <div class="modal-dialog" role="document">
	<div class="modal-content">
	  <div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		<h4 class="modal-title" id="gridSystemModalLabel">线索导入</h4>
	  </div>
	  <div class="modal-body">
		<div class="row">
		  <div class="col-md-4 col-md-offset-4">
			  <a class="btn btn-info btn-w-lg" href="#">线索模板下载</a>
		  </div>
		</div>
		<hr>
		<div class="row">
		  <div class="col-md-6 	col-md-offset-3">
			  <form class="form-horizontal" action="#" method="post" enctype="multipart/form-data">
			  	<div class="form-group">
					<label class="col-md-4 control-label" for="example-hf-thread">文件</label>
					<div class="col-md-8">
					  <input class="form-control" type="file" id="example-hf-thread">
					</div>
			  	</div>
				<div class="form-group">
					<div class="col-md-4 col-md-offset-2">
					  <button class="btn btn-info btn-w-lg" type="submit">上传</button>
					</div>
				</div>
			  </form>
		  </div>
		</div>
	  </div>
	</div>
  </div>
</div>
<!-- 导入线索模态框 end -->



<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="js/main.min.js"></script>

<!--图表插件-->
<script type="text/javascript" src="js/Chart.js"></script>
<script type="text/javascript">

    $.getJSON("IndexDataServlet",function(d){
        console.log(d);


        Highcharts.chart('container', {
            chart: {
                type: 'column'
            },
            title: {
                text: '2019年各月份营收情况'
            },
            xAxis: {
                type: 'category'
            },
            yAxis: {
                title: {
                    text: ''
                }
            },
            legend: {
                enabled: false
            },
            plotOptions: {
                series: {
                    borderWidth: 0,
                    dataLabels: {
                        enabled: true,
                        format: '{point.y:f}'
                    }
                }
            },
            tooltip: {
                headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
                pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:f}</b> of total<br/>'
            },
            series: [{
                name: '',
                colorByPoint: true,
                data: d
            }]
        });

    });

    /* 折线图 */
    $.getJSON("IndexData2Servlet",function (d) {
        Highcharts.chart('container1', {
            title: {
                text: '2019年交易总额统计'
            },
            subtitle: {
                text: ''
            },
            yAxis: {
                title: {
                    text: ''
                }
            },
            legend: {
                layout: 'vertical',
                align: 'right',
                verticalAlign: 'middle'
            },
            plotOptions: {
                series: {
                    label: {
                        connectorAllowed: false
                    },
                    pointStart: 1
                }
            },
            series: [{
                name: '当年金额',
                data: d
            }],
            responsive: {
                rules: [{
                    condition: {
                        maxWidth: 500
                    },
                    chartOptions: {
                        legend: {
                            layout: 'horizontal',
                            align: 'center',
                            verticalAlign: 'bottom'
                        }
                    }
                }]
            }
        });
    });

    $.getJSON("StatisticsServlet",function (d) {
        console.log(d)
        $("#incomeMonth").html('￥'+d[0]);
        $("#incomeLastYear").html('￥'+d[1]);
        $("#customerIncrementLastYear").html(d[2]);
        $("#customerCount").html(d[3]);
    });
</script>
</body>
</html>