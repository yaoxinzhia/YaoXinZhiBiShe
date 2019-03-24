<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>跳转界面</title>
    <style>
        p{
            text-align: center;
        }
        span{
            color: red;
        }
    </style>


</head>
<body>
    <p>
        您已注册成功，将于<span id="time">5</span>秒之后，自动跳转至登录界面
    </p>

    <script>
        //定义函数
        function count()
             {    
         var myspan=document.getElementById("time");
         var number=myspan.innerHTML;
         number--;
         myspan.innerHTML=number;
                if(number==0)
                {
                    window.location.href="login.jsp"; 
                }
            }


        //设置定时器，调用函数
         setInterval("count()",1000);
    </script>



</body>
</html>
