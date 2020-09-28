<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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
                        <span class="navbar-page-title"> 产品 - 产品列表 </span>
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
                                <form class="pull-right search-bar" method="get" action="#" role="form"
                                      onsubmit="return false">
                                    <div class="input-group">
                                        <input type="text" id="keyword" class="form-control" value="" name="keyword"
                                               placeholder="请输入产品名称">
                                        <div class="input-group-btn">
                                            <button class="btn btn-dark" onclick="getData(1,2,false,false)">搜索</button>
                                        </div>
                                    </div>
                                </form>
                                <div class="toolbar-btn-action">
                                    <a class="btn btn-primary m-r-5" href="ProductAddJumpServlet"><i
                                            class="mdi mdi-plus"></i>
                                        新增</a>
                                    <a class="btn btn-info m-r-5" href="ExcelProductDownLoadServlet"><i
                                            class="mdi mdi-check"></i> 导出</a>
                                    <a id="btnDel" class="btn btn-danger" href="#"><i class="mdi mdi-window-close"></i>
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
                                                    <input type="checkbox" id="check-all"><span>选择</span>
                                                </label>
                                            </th>
                                            <th>产品名称</th>
                                            <th>产品编号</th>
                                            <th>产品类别</th>
                                            <th>标准价格</th>
                                            <th>创建人</th>
                                            <th>创建时间</th>
                                            <th>更新时间</th>
                                            <th>是否上下架</th>
                                            <th>操作</th>
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

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="js/main.min.js"></script>
<!--图表插件-->
<script type="text/javascript" src="js/Chart.js"></script>
<script src="${pageContext.request.contextPath}/js/jconfirm/jquery-confirm.min.js"></script>
<script type="text/javascript">

    $(function () {
        /* 删除提示框生成 */
        $('#btnDel').on('click', function () {
            //获取被选中的多选框
            if (confirm("确定要删除吗?")) {
                var cks = $("input[type='checkbox']:checked").not($("#check-all"));
                for (var i = 0; i < cks.length; i++) {
                    $.get("ProductDeleteBatchServlet", {"productId": cks[i].value});
                    if (i == cks.length - 1) {
                        window.location.href = "ProductToListServlet";
                    }
                }
            }
        });
    });

    const pageNo = 1;
    const pageSize = 2;
    let pageCount = 1;
    const hasPre = false;
    const hasNext = false;

    getData(pageNo, pageSize, hasPre, hasNext);

    function getData(pageNo, pageSize, hasPre, hasNext) {
        let keyword = $("#keyword").val();
        $.getJSON("ProductGetPageServlet", {pageNo: pageNo, pageSize: pageSize, keyword: keyword}, function (d) {
            pageNo = d.pageNo;
            pageSize = d.pageSize;
            pageCount = d.pageCount;
            hasPre = d.hasPre;
            hasNext = d.hasNext;
            const list = d.obj;
            let content = "";
            for (let i = 0; i < list.length; i++) {
                content += "<tr>\n" +
                    "<td><label class='lyear-checkbox checkbox-primary'><input type='checkbox' name='ids[]' value='" + list[i].productId + "'><span></span></label></td>\n" +
                    "<td>" + list[i].productName + "</td>\n" +
                    "<td>" + list[i].productCode + "</td>\n" +
                    "<td>" + list[i].category.categoryName + "</td>\n" +
                    "<td>" + list[i].price + "</td>\n" +
                    "<td>" + list[i].founder.employeeName + "</td>\n" +
                    "<td>" + getYMD(list[i].createTime) + "</td>\n" +
                    "<td>" + getYMD(list[i].updateTime) + "</td>\n" +
                    "<td>" + (list[i].flag == 1 ? '上架' : '下架') + "</td>\n" +
                    "<td>\n" +
                    "<div class='btn-group'>\n" +
                    "<a class='btn btn-xs btn-default' href='ProductUpdateJumpServlet?productId=" + list[i].productId + "' title='编辑' data-toggle='tooltip'><i class='mdi mdi-pencil'></i></a>\n" +
                    "<a class='btn btn-xs btn-default' href='ProductDeleteServlet?productId=" + list[i].productId + "' title='删除' data-toggle='tooltip'><i class='mdi mdi-window-close'></i></a>\n" +
                    "</div>\n" +
                    "</td>\n" +
                    "</tr>";
            }
            $("#tbody").html(content);
            joinPages(pageNo, pageCount, hasPre, hasNext);
            bindPages(pageNo, pageSize, hasPre, hasNext);
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

    function getYMD(timestamp) {
        let time = new Date(timestamp)
        let year = time.getFullYear()
        let month = time.getMonth() + 1
        let date = time.getDate()

        if (month < 10) {
            month = '0' + month
        }
        if (date < 10) {
            date = '0' + date
        }
        return year + '-' + month + '-' + date
    }


</script>
</body>
</html>