<%--
  Created by IntelliJ IDEA.
  User: 王旭东
  Date: 2019/4/5
  Time: 16:49
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
姓名：${requestScope.person.name}<br/>
性别：${requestScope.person.sex}<br/>
手机：${requestScope.person.phoneNumber}<br/>
邮箱：${requestScope.person.email}<br/>
城市：${requestScope.person.address}<br/>
生日：${requestScope.person.birthday}<br/>
<a href='list.jsp'>返回</a>
</body>
</html>
