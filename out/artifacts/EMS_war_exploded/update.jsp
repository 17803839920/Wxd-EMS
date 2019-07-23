<%--
  Created by IntelliJ IDEA.
  User: 王旭东
  Date: 2019/4/5
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert title here</title>
</head>
<body>
当前用户：<%=session.getAttribute("username")%> <a href='login.jsp'>退出</a><br/>
<hr/>
<form action="updatePerson" method="post">
    <input type="hidden" name="id" value="${requestScope.p.id}"/>
    姓名：<input name="name" value="${requestScope.p.name}"/><br/>
    性别：<input name="sex" value="${requestScope.p.sex}"/><br/>
    手机：<input name="phoneNumber" value="${requestScope.p.phoneNumber}"/><br/>
    邮箱：<input name="email" value="${requestScope.p.email}"/><br/>
    城市：<input name="address" value="${requestScope.p.address}"/><br/>
    生日：<input name="birthday" value="${requestScope.p.birthday}"/>
    <br/>
    <input type="submit" value="修改"/>
    <input type="reset" value="重置"/>
</form>
<a href='list.jsp'>返回</a>
</body>
</html>
