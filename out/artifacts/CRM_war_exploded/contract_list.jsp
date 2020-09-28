<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"/>
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
                        <span class="navbar-page-title"> 合同 - 合同列表 </span>
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
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-toolbar clearfix">
                                <form class="pull-right search-bar" method="get" action="#!" role="form" onsubmit="return false">
                                    <div class="input-group">
                                        <input type="text" id="keyword" class="form-control" value="" name="keyword"
                                               placeholder="请输入合同名称">
                                        <div class="input-group-btn">
                                            <button class="btn btn-dark" onclick="getData(1,2,false,false)">搜索</button>
                                        </div>
                                    </div>
                                </form>
                                <div class="toolbar-btn-action">
                                    <a class="btn btn-primary m-r-5" href="ContractAddJumpServlet"><i
                                            class="mdi mdi-plus"></i> 新增</a>
                                    <a id="btnDel" class="btn btn-danger" href="#!"><i class="mdi mdi-window-close"></i>
                                        删除</a>
                                </div>
                            </div>
                            <div class="card-body">

                                <div class="table-responsive">
                                    <table class="table table-hover">
                                        <thead>
                                        <tr>
                                            <th>
                                                <label class="lyear-checkbox checkbox-primary">
                                                    <input type="checkbox" id="check-all"><span></span>
                                                </label>
                                            </th>
                                            <th>合同编号</th>
                                            <th>合同名称</th>
                                            <th>客户名称</th>
                                            <th>合同金额</th>
                                            <th>生效时间</th>
                                            <th>结束时间</th>
                                            <th>客户签约人</th>
                                            <th>公司签约人</th>
                                            <th>负责人</th>
                                            <th>审批人1</th>
                                            <th>审批人2</th>
                                            <th>状态</th>
                                        </tr>
                                        </thead>
                                        <tbody id="tbody">

                                        </tbody>
                                    </table>
                                </div>
                                <ul class="pagination">

                                </ul>

                            </div>
                        </div>
                    </div>

                </div>


            </div>

        </main>
        <!--End 页面主要内容-->
    </div>
</div>

<!-- 合同状态start -->
<div id="showModel"></div>
<!-- 合同状态end -->

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="js/main.min.js"></script>
<!--图表插件-->
<script type="text/javascript" src="js/Chart.js"></script>
<script src="${pageContext.request.contextPath}/js/jconfirm/jquery-confirm.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/pdfobject.min.js"></script>
<script type="text/javascript">

    /* 查看pdf文件 */
    $(".contractClass").click(function () {
        PDFObject.embed(this.href);
    });

    const pageNo = 1;
    const pageSize = 2;
    let pageCount = 1;
    const hasPre = false;
    const hasNext = false;

    getData(pageNo, pageSize, hasPre, hasNext);

    function getData(pageNo, pageSize, hasPre, hasNext) {
        var keyword = $("#keyword").val();
        $.getJSON("ContractGetPageServlet", {pageNo: pageNo, pageSize: pageSize,keyword:keyword}, function (d) {
            pageNo = d.pageNo;
            pageSize = d.pageSize;
            pageCount = d.pageCount;
            hasPre = d.hasPre;
            hasNext = d.hasNext;
            const list = d.obj;
            let content = "";
            for (let i = 0; i < list.length; i++) {
                content += "<tr>\n" +
                    "<td>\n" +
                    "<label class='lyear-checkbox checkbox-primary'>\n" +
                    "<input type='checkbox' name='ids[]' value='" + list[i].contractId + "'><span></span>\n" +
                    "</label>\n" +
                    "</td>\n" +
                    "<td><a class='showInformation' href='#' data-toggle='modal' data-target='#gridSystemModal'>" + list[i].contractId + "</a></td>\n" +
                    "<td><a class='contractClass' href='http://localhost:8090/CRM_war_exploded" + list[i].contractUrl + "'>" + list[i].contractName + "</a></td>\n" +
                    "<td>" + list[i].customer.customerName + "</td>\n" +
                    "<td>" + list[i].contractMoney + "</td>\n" +
                    "<td>" + list[i].startTime + "</td>\n" +
                    "<td>" + list[i].endTime + "</td>\n" +
                    "<td>" + list[i].customerSigner + "</td>\n" +
                    "<td>" + list[i].employeeSigner.employeeName + "</td>\n" +
                    "<td>" + list[i].employeeResponsible.employeeName + "</td>\n" +
                    "<td>" + list[i].employee01.employeeName + "</td>\n" +
                    "<td>" + list[i].employee02.employeeName + "</td>\n" +
                    "<td>" + traStatus(list[i].flag) + "</td>\n" +
                    "</tr>";
            }
            $("#tbody").html(content);
            joinPages(pageNo, pageCount, hasPre, hasNext);
            bindPages(pageNo, pageSize, hasPre, hasNext);
            showInformation();
        });
    }

    function joinPages(pageNo, pageCount, hasPre, hasNext) {
        let i;
        let content = "";
        if (!hasPre) {
            content += "<li class='disabled'><span>«</span></li>";
        } else {
            content += "<li><a id='pre' href='#'>«</a></li>";
        }
        if (pageCount <= 5) {
            for (i = 1; i <= pageCount; i++) {
                if (pageNo == i) {
                    content += "<li class='active'><span>" + i + "</span></li>";
                } else {
                    content += "<li><a class='middlePage' href='#'>" + i + "</a></li>";
                }
            }
        } else {
            if (pageNo <= 3) {
                for (i = 1; i <= 5; i++) {
                    if (pageNo == i) {
                        content += "<li class='active'><span>" + i + "</span></li>";
                    } else {
                        content += "<li><a class='middlePage' href='#'>" + i + "</a></li>";
                    }
                }
            } else if (pageNo >= pageCount - 2) {
                for (i = pageCount - 4; i <= pageCount; i++) {
                    if (pageNo == i) {
                        content += "<li class='active'><span>" + i + "</span></li>";
                    } else {
                        content += "<li><a class='middlePage' href='#'>" + i + "</a></li>";
                    }
                }
            } else {
                for (i = pageCount - 2; i <= pageCount + 2; i++) {
                    if (pageNo == i) {
                        content += "<li class='active'><span>" + i + "</span></li>";
                    } else {
                        content += "<li><a class='middlePage' href='#'>" + i + "</a></li>";
                    }
                }
            }
        }
        if (!hasNext) {
            content += "<li class='disabled'><span>»</span></li>";
        } else {
            content += "<li><a id='next' href='#'>»</a></li>";
        }
        $(".pagination").html(content);
    }

    function bindPages(pageNo, pageSize, hasPre, hasNext) {
        $("#pre").click(function () {
            pageNo -= 1;
            getData(pageNo, pageSize, hasPre, hasNext);
        });
        $("#next").click(function () {
            pageNo += 1;
            getData(pageNo, pageSize, hasPre, hasNext);
        });
        const mps = $(".middlePage");
        for (let i = 0; i <= mps.length; i++) {
            $(mps[i]).click(function () {
                pageNo = parseInt(this.innerHTML);
                getData(pageNo, pageSize, hasPre, hasNext);
            });
        }
    }

    function showInformation() {
        var info = $(".showInformation");

        for (var i = 0; i < info.length; i++) {
            $(info[i]).click(function () {
                $.getJSON("ContractGetInfoServlet", {contractId: this.innerHTML}, function (d) {
                    var content = "<div class=\"modal fade\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"gridSystemModalLabel\" id=\"gridSystemModal\">\n" +
                        "  <div class=\"modal-dialog\" role=\"document\">\n" +
                        "<div class=\"modal-content\">\n" +
                        "  <div class=\"modal-header\">\n" +
                        "<button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n" +
                        "<h4 class=\"modal-title\" id=\"contractInformation\">合同信息</h4>\n" +
                        "  </div>\n" +
                        "  <div class=\"modal-body\">\n" +
                        "<div class=\"row\">\n" +
                        "  <div class=\"col-md-12\">\n" +
                        "  <ul class=\"nav-step step-anchor\">\n" +
                        "<li class=\"nav-step-item complete\">\n" +
                        "  <a href=\"#step-1\">\n" +
                        "<h6>" + d.contract.employeeResponsible.employeeName + "</h6>\n" +
                        "<p class=\"m-0\">已提交</p>\n" +
                        "  </a>\n" +
                        "</li>\n" +
                        "<li class=\"nav-step-item active\">\n" +
                        "  <a href=\"#step-2\">\n" +
                        "<h6>" + d.contract.employee01.employeeName + "</h6>\n" +
                        "<p class=\"m-0\">" + judge1(d.contract.flag) + "</p>\n" +
                        "  </a>\n" +
                        "</li>\n" +
                        "<li class=\"nav-step-item\">\n" +
                        "  <a href=\"#step-3\">\n" +
                        "<h6>" + d.contract.employee02.employeeName + "</h6>\n" +
                        "<p class=\"m-0\">" + judge2(d.contract.flag) + "</p>\n" +
                        "  </a>\n" +
                        "</li>\n" +
                        "  </ul>\n" +
                        "  </div>\n" +
                        "</div>\n" +
                        "<div class=\"modal-header\">\n" +
                        "<h4 class=\"modal-title\" id=\"productList\">产品列表</h4>\n" +
                        "</div>\n" +
                        "<div class=\"row\">\n" +
                        "  <div class=\"col-md-12\">\n" +
                        "  <table class=\"table\">\n" +
                        "<thead>\n" +
                        "  <tr>\n" +
                        "<th>产品名称</th>\n" +
                        "<th>产品编号</th>\n" +
                        "<th>价格</th>\n" +
                        "<th>数量</th>\n" +
                        "<th>合计</th>\n" +
                        "  </tr>\n" +
                        "</thead>\n" +
                        "<tbody>" + showProductList(d.productResults) + "</tbody>\n" +
                        "  </table>\n" +
                        "  </div>\n" +
                        "</div>\n" +
                        "  </div>\n" +
                        "</div>\n" +
                        "  </div>\n" +
                        "</div>\n";

                    $("#showModel").html(content);
                    $("#gridSystemModal").modal('show');
                });
                return false;
            });
        }
    }

    function showProductList(list) {
        var content = "";
        for (var i = 0; i < list.length; i++) {
            content += "<tr>\n" +
                "<th>" + list[i].productName + "</th>+\n" +
                "<td>" + list[i].productCode + "</td>+\n" +
                "<td>" + list[i].price + "</td>+\n" +
                "<td>" + list[i].num + "</td>+\n" +
                "<td>" + list[i].total + "</td>+\n" +
                "</tr>";
        }
        return content;
    }

    function judge1(flag) {
        if (flag == 0) {
            return "待审批";
        } else if (flag == 2) {
            return "审批不通过";
        } else {
            return "审批通过";
        }
    }

    function judge2(flag) {
        if (flag == 3) {
            return "审批通过";
        } else if (flag == 4) {
            return "审批不通过";
        } else {
            return "待审批";
        }
    }

    function traStatus(flag) {
        if (flag == 0) {
            return "已提交";
        } else if (flag == 2 || flag == 4) {
            return "审批不通过";
        } else if (flag == 1) {
            return "审批人1通过";
        } else {
            return "审批人2通过";
        }
    }

    $(function () {
        /* 删除提示框生成 */
        $('#btnDel').on('click', function () {
            //获取被选中的多选框
            if (confirm("确定要删除吗?")) {
                var cks = $("input[type='checkbox']:checked").not($("#check-all"));
                for (var i = 0; i < cks.length; i++) {
                    console.log(cks[i].value);
                    $.get("ContractDeleteBatchServlet", {"contractId": cks[i].value});
                    if (i == cks.length - 1) {
                        window.location.href = "ContractToListServlet";
                    }
                }
            }
        });

    });
</script>
</body>
</html>