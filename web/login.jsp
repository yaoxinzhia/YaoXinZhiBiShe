<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>登录界面</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>

    <script type="text/javascript">
        // 验证码
        function refreshCode(){
            // 获取图片对象
            var img = document.getElementById("vcode");

            //2.设置其src属性，加时间戳
            img.src =  "${pageContext.request.contextPath}/checkCodeServlet?time="+ new Date().getTime();
        }
    </script>
</head>
<body>

<!-- 注册界面 -->
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">用户登录</h3>
    <form action="${pageContext.request.contextPath}/loginServlet" method="post">
        <div class="form-group">
            <label for="user">用户名：</label>
            <input type="text" name="username" class="form-control" id="user" placeholder="请输入用户名"/>
        </div>

        <div class="form-group">
            <label for="password">密码：</label>
            <input type="password" name="password" class="form-control" id="password" placeholder="请输入密码"/>
        </div>

        <div class="form-inline">
            <label for="vcode">验证码：</label>
            <input type="text" name="verifycode" class="form-control" id="verifycode" placeholder="请输入验证码" style="width: 120px;"/>
            <a href="javascript:refreshCode();">
                <img src="${pageContext.request.contextPath}/checkCodeServlet" title="看不清点击刷新" id="vcode"/>
            </a>
        </div>
        <hr/>
        <div class="form-group" style="text-align: center;">
            <input id="login" class="btn btn btn-primary" type="submit" value="登录" style="margin-right: 100px">
            <!-- 点击注册跳转到注册界面 -->
            <a href="register.jsp"> <input id="register" class="btn btn btn-primary" type="button" value="注册"> </a>
        </div>
    </form>

    <!-- 出错显示的信息框 -->
    <div class="alert alert-warning alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert" >
            <span>&times;</span>
        </button>
        <strong>${login_msg}</strong>
    </div>
</div>

<script>

</script>
</body>
</html>