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
    <style>
        .lyear-wrapper {
            position: relative;
        }

        .lyear-login {
            display: flex !important;
            min-height: 100vh;
            align-items: center !important;
            justify-content: center !important;
        }

        .login-center {
            background: #fff;
            min-width: 38.25rem;
            padding: 2.14286em 3.57143em;
            border-radius: 5px;
            margin: 2.85714em 0;
        }

        .login-header {
            margin-bottom: 1.5rem !important;
        }

        .login-center .has-feedback.feedback-left .form-control {
            padding-left: 38px;
            padding-right: 12px;
        }

        .login-center .has-feedback.feedback-left .form-control-feedback {
            left: 0;
            right: auto;
            width: 38px;
            height: 38px;
            line-height: 38px;
            z-index: 4;
            color: #dcdcdc;
        }

        .login-center .has-feedback.feedback-left.row .form-control-feedback {
            left: 15px;
        }
    </style>
</head>

<body>
<div class="row lyear-wrapper">
    <div class="lyear-login">
        <div class="login-center">
            <div class="login-header text-center">
                <a href="index.jsp"> <img alt="light year admin" src="images/logo-sidebar.png"> </a>
            </div>
            <form action="#" method="post" id="form">
                <div class="form-group has-feedback feedback-left">
                    <input type="text" placeholder="请输入您的用户名" class="form-control" name="email" id="username"/>
                    <span class="mdi mdi-account form-control-feedback" aria-hidden="true"></span>
                </div>
                <div class="form-group has-feedback feedback-left">
                    <input type="password" placeholder="请输入密码" class="form-control" id="password" name="password"/>
                    <span class="mdi mdi-lock form-control-feedback" aria-hidden="true"></span>
                </div>
                <div class="form-group has-feedback feedback-left row">
                    <div class="col-xs-7">
                        <label>
                            <input type="text" name="captcha" class="form-control" placeholder="验证码">
                        </label>
                        <span class="mdi mdi-check-all form-control-feedback" aria-hidden="true"></span>
                    </div>
                    <div class="col-xs-5">
                        <img src="VerifyCodeServlet" class="pull-right" id="captcha" style="cursor: pointer;"
                             onclick="this.src=this.src+'?d='+Math.random();" title="点击刷新" alt="captcha">
                    </div>
                </div>
                <div class="form-group">
                    <label for="rm">
                        <input type="checkbox" class="form-control" id="rm" name="rm" value="1"/>记住我
                    </label>
                </div>
                <div class="form-group">
                    <button class="btn btn-block btn-primary" type="button" onclick="toLogin()">立即登录</button>
                </div>
            </form>

            <hr>
            <footer class="col-sm-12 text-center">
                <p class="m-b-0">Copyright © 2020 <a target="_blank" href="http://ukoko.cn">枫桥夜泊</a>. All right reserved
                </p>
            </footer>
        </div>
    </div>
</div>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript">
    //从cookie中取数据
    var email = $.cookie("email");
    var password = $.cookie("password");

    if (email !== undefined && password !== undefined) {
        //使用Ajax进行自动登录
        $.post("AutoLoginServlet",{email:email,password:password},function (d) {
            if (d.code==1) {
                //登录成功
                window.location.href="ApprovalListServlet";
            }
        },"json");
    }

    function toLogin() {
        var formP = $("#form").serialize();
        $.getJSON("LoginServlet", formP, function (d) {
            if (d.code == 1) {
                window.location.href = "ApprovalListServlet";
            } else {
                alert(d.msg);
            }
        })
    }
</script>
</body>
</html>