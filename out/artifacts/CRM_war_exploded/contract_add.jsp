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
            <span class="navbar-page-title"> 合同 - 添加合同 </span>
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
			
			<form id="showProductId" class="form-horizontal" enctype="multipart/form-data" action="ContractAddServlet" method="post">
			  <div class="form-group">
				<label class="col-md-3 control-label" for="contractName">合同名称</label>
				<div class="col-md-4">
				  <input class="form-control" type="text" id="contractName" name="contractName"  placeholder="请输入合同名称..">
				</div>
			  </div>
			  <%--<div class="form-group">
				<label class="col-md-3 control-label" for="money">合同金额</label>
				<div class="col-md-4">
				  <input class="form-control" type="text" id="money" name="contractMoney"  placeholder="请输入合同金额..">
				</div>
			  </div>--%>
			  <div class="form-group">
					<label class="col-md-3 control-label" for="customerSigner">客户签约人</label>
					<div class="col-md-4">
					  <input class="form-control" type="text" id="customerSigner" name="customerSigner"  placeholder="请输入客户签约人..">
					</div>
			  </div>
			  <div class="form-group">
				<label class="col-md-3 control-label" for="employeeSigner">公司签约人</label>
				<div class="col-md-4">
					<select class="form-control" id="employeeSigner" name="employeeSignerId">
					    <c:forEach items="${employeeList}" var="emp">
						    <option value="${emp.employeeId}">${emp.employeeName}</option>
				        </c:forEach>
				  </select>
				</div>
			  </div>
			  <div class="form-group">
				<label class="col-md-3 control-label" for="customerName">客户名称</label>
				<div class="col-md-4">
				  <select class="form-control" id="customerName" name="customerId">
					  <c:forEach items="${customerList }" var="customer">
						  <option value="${customer.customerId }">${customer.customerName }</option>
					  </c:forEach>
				  </select>
				</div>
			  </div>
			  <div class="form-group">
				<label class="col-md-3 control-label" for="employeeResponsible">负责人</label>
				<div class="col-md-4">
				  <select class="form-control" id="employeeResponsible" name="employeeResponsibleId">
					  <c:forEach items="${employeeList }" var="emp">
						  <option value="${emp.employeeId }">${emp.employeeName }</option>
					  </c:forEach>
				  </select>
				</div>
			  </div>
			  <div class="form-group">
				<label class="col-md-3 control-label" for="employee01">审批人1</label>
				<div class="col-md-4">
				  <select class="form-control" id="employee01" name="employee01Id">
					  <c:forEach items="${employeeList }" var="emp">
						  <option value="${emp.employeeId }">${emp.employeeName }</option>
					  </c:forEach>
				  </select>
				</div>
			  </div>
			  <div class="form-group">
				<label class="col-md-3 control-label" for="employee02">审批人2</label>
				<div class="col-md-4">
				  <select class="form-control" id="employee02" name="employee02Id">
					  <c:forEach items="${employeeList }" var="emp">
						  <option value="${emp.employeeId }">${emp.employeeName }</option>
					  </c:forEach>
				  </select>
				</div>
			  </div>
			  
			  <div class="form-group">
				<label class="col-md-3 control-label" for="startTime">生效时间</label>
				<div class="col-md-4">
					<input class="form-control js-datepicker" id="startTime" name="startTime" type="text" data-date-format="yyyy-mm-dd" placeholder="年-月-日">
				</div>
			  </div>
			  
			  <div class="form-group">
				<label class="col-md-3 control-label" for="endTime">结束时间</label>
				<div class="col-md-4">
				  <input class="form-control js-datepicker" id="endTime" name="endTime" type="text" data-date-format="yyyy-mm-dd" placeholder="年-月-日">
				</div>
			  </div>
			  <div class="form-group">
				<label class="col-md-3 control-label" for="example-hf-thread">合同附件</label>
				<div class="col-md-4">
				  <input class="form-control" name="file" type="file" id="example-hf-thread">
				</div>
			  </div>
			  <!-- 添加产品-->
			  <div class="form-group">
				<label class="col-md-3 control-label">产品列表</label>
				<div class="col-md-4">
				  <div class="form-control" style="height: 100%;" id="showLabel">
					  <span style="display: inline-block ;height: 1.24375rem;width: 0px;padding-left: 0px;"></span>
				  </div>
				</div>
			  </div>
			  <div class="form-group">
				<label class="col-md-3 control-label" for="productEleId">合同产品</label>
				<div class="col-md-4">
					<div class="col-md-4" style="padding-left: 0px;">
					  <select class="form-control" id="productEleId">
						  <c:forEach items="${ productList}" var="product">
							  <option value="${product.productId }">${product.productName }</option>
						  </c:forEach>
					  </select>
					</div>
					<input class="form-control" id="productEleCount" style="display: inline-block; width: 31%;" type="text" placeholder="产品数量..">
					<button type="button" id="productBtn" class="form-control btn btn-brown" style="float: right; width: 25%;">添加</button>
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
<script type="text/javascript">
	
	//删除已添加标签
	var lcs = $(".labelClass");
	for(var i=0;i<lcs.length;i++){
		$(lcs[i]).click(function(){
			//删除展示标签
			$(this.parentNode).remove();
			//删除form表单中的隐藏input数据
			//获取ID
			var pid = this.parentNode.id;
			console.log(pid)
			var cccc = $("#showProductId input[class="+pid+"]:hidden");
			cccc.remove();
		});
	}
	//根据按钮添加标签
	$("#productBtn").click(function(){
		
		//获取选中参数
		var count = $("#productEleCount").val();//获取数量
		var productId = $("#productEleId option:selected").val(); //获取下拉框选中的参数
		var productName = $("#productEleId option:selected").html();//获取名称
		//拼接参数
		var productInfo = productId+"="+count;
		console.log(productInfo);
		console.log(productName);
		//拼接样式,并将其展示到指定位置
		
		var span1 = $("<span></span>");
		//设置类名
		span1.addClass("label label-primary");
		//设置属性值
		span1.attr("id","p"+productId);
		span1.attr("style","margin-right: 0.1875rem;");
		//创建子节点
		var pNEle = $("<span>"+productName+" "+count+"台</span>");
		
		var pNEle2 = ("<span class=\"labelClass\" style=\"padding-left: 0.25rem; padding-right: 0.25rem;cursor: pointer;font-weight: bold;\">x</span>")
		
		//子节点设置到父节点中
		span1.append(pNEle);
		span1.append(pNEle2);
		
		$("#showLabel").append(span1);
		
		//获取表单元素
		var spEle = $("#showProductId");
		//添加input控件
		//创建input控件 
		var pInfo = $("<input type=\"hidden\" class=p"+productId+" value="+productInfo+" name=\"productInfo\" />");
		//添加到form表单中,设置类型为隐藏
		spEle.prepend(pInfo);
		console.log(spEle[0]);
		//重新绑定事件
		
		var lcs = $(".labelClass");
		for(var i=0;i<lcs.length;i++){
			$(lcs[i]).click(function(){
				//删除展示标签
				$(this.parentNode).remove();
				//删除form表单中的隐藏input数据
				//获取ID
				var pid = this.parentNode.id;
				console.log(pid)
				var cccc = $("#showProductId input[class="+pid+"]:hidden");
				cccc.remove();
			});
		}
	});
	
</script>
</body>
</html>