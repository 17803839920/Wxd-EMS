<%--
  Created by IntelliJ IDEA.
  User: 王旭东
  Date: 2019/4/5
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">
        body {
            text-align: center;
        }

        span {
            color: red;
            font-size: 200%
        }

        hr {
            margin-bottom: 30px
        }

        a {
            text-decoration: none;
            color: blue;
            margin-left: 30px
        }

        a:hover {
            text-decoration: underline;
            color: red
        }
    </style>
</head>
<body>
<span> 用户注册 </span>
<hr color="red"/>
<form action="registeAction" method="post">
    <table border="1" bordercolor="blue" width="40%" cellspacing="0" align="center">
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username"/></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr align="center">
            <td colspan="2">
                <input type="submit" value="保存"/> <input type="reset" value="重置"/>
                <a href="login.jsp">返回</a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
