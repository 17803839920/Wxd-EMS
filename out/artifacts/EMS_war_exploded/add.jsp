<%--
  Created by IntelliJ IDEA.
  User: 王旭东
  Date: 2019/4/5
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert title here</title>
</head>
<body>
<form action="addPersonAction">
    姓名：<input name="name"/><br/>
    手机：<input name="phoneNumber"/><br/>
    性别：<input name="sex"/><br/>
    邮箱：<input name="email"/><br/>
    城市：<input name="address"/><br/>
    生日：<input type="date" name="birthday"/><br/>
    <input type="submit" value="添加"/><input type="reset" value="重置"/>
</form>
<a href='list.jsp'>返回</a>
</body>
</html>
