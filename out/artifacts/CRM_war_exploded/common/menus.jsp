<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/23
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<aside class="lyear-layout-sidebar">

    <!-- logo -->
    <div id="logo" class="sidebar-header">
        <a href="${pageContext.request.contextPath}/ApprovalListServlet"><img src="${pageContext.request.contextPath}/images/logo-sidebar.png" title="LightYear" alt="LightYear" /></a>
    </div>
    <div class="lyear-layout-sidebar-scroll">

        <nav class="sidebar-main">
            <ul class="nav nav-drawer">
                <li class="nav-item active"> <a href="${pageContext.request.contextPath}/ApprovalListServlet"><i class="mdi mdi-home"></i> 后台首页</a> </li>
                <li class="nav-item nav-item-has-subnav">
                    <a href="javascript:void(0)"><i class="mdi mdi-comment-text-outline"></i> 待办事项</a>
                    <ul class="nav nav-subnav">
                        <li> <a href="lyear_ui_buttons.html">分配给我的线索</a> </li>
                        <li> <a href="lyear_ui_cards.html">分配给我的客户</a> </li>
                        <li> <a href="lyear_ui_grid.html">待进入公海的客户</a> </li>
                    </ul>
                </li>
                <li class="nav-item nav-item-has-subnav">
                    <a href="javascript:void(0)"><i class="mdi mdi-all-inclusive"></i> 线索</a>
                    <ul class="nav nav-subnav">
                        <li> <a href="${pageContext.request.contextPath}/ThreadToListServlet">线索列表</a> </li>
                        <li> <a href="${pageContext.request.contextPath}/ThreadAddJumpServlet">添加线索</a> </li>
                        <li> <a href="#" data-toggle="modal" data-target="#gridSystemModal">线索导入</a> </li>
                    </ul>
                </li>
                <li class="nav-item nav-item-has-subnav">
                    <a href="javascript:void(0)"><i class="mdi mdi-account"></i> 客户</a>
                    <ul class="nav nav-subnav">
                        <li> <a href="${pageContext.request.contextPath}/CustomerToListServlet">客户列表</a> </li>
                        <li> <a href="${pageContext.request.contextPath}/CustomerAddJumpServlet">添加客户</a> </li>
                        <li> <a href="lyear_pages_config.html">客户导入</a> </li>
                    </ul>
                </li>
                <li class="nav-item nav-item-has-subnav">
                    <a href="javascript:void(0)"><i class="mdi mdi-dribbble"></i>公海</a>
                    <ul class="nav nav-subnav">
                        <li> <a href="${pageContext.request.contextPath}/international_waters.html">公海列表</a> </li>
                    </ul>
                </li>
                <li class="nav-item nav-item-has-subnav">
                    <a href="javascript:void(0)"><i class="mdi mdi mdi-dropbox"></i>合同</a>
                    <ul class="nav nav-subnav">
                        <li> <a href="${pageContext.request.contextPath}/ContractToListServlet">合同列表</a> </li>
                        <li> <a href="${pageContext.request.contextPath}/ContractAddJumpServlet">添加合同</a> </li>
                    </ul>
                </li>
                <li class="nav-item nav-item-has-subnav">
                    <a href="javascript:void(0)"><i class="mdi mdi-rotate-right"></i>回款</a>
                    <ul class="nav nav-subnav">
                        <li> <a href="${pageContext.request.contextPath}/return_money_list.jsp">回款列表</a> </li>
                        <li> <a href="${pageContext.request.contextPath}/lyear_js_sliders.html">添加回款</a> </li>
                    </ul>
                </li>
                <li class="nav-item nav-item-has-subnav">
                    <a href="javascript:void(0)"><i class="mdi mdi-chili-hot"></i>产品</a>
                    <ul class="nav nav-subnav">
                        <li> <a href="${pageContext.request.contextPath}/ProductToListServlet">产品列表</a> </li>
                        <li> <a href="${pageContext.request.contextPath}/ProductAddJumpServlet">添加产品</a> </li>
                        <li> <a href="${pageContext.request.contextPath}/ProductImportServlet">产品导入</a> </li>
                    </ul>
                </li>
            </ul>
        </nav>

        <div class="sidebar-footer">
            <p class="copyright">Copyright &copy; 2020. <img style="width: 25px;padding-bottom: 5px;" src="${pageContext.request.contextPath}/images/fy.png"  alt="#"/> <a target="_blank" href="https://hd1611756908.github.io/"> CRM</a>&nbsp; Powered By &nbsp;<a href="https://space.bilibili.com/16364623" target="_blank" title="半个橙子">半个橙子</a></p>
        </div>
    </div>

</aside>
