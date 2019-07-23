<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Insert title here</title>
</head>
<body>

当前用户：<%=request.getSession().getAttribute("username")%> <a
        href="logoutAction">退出</a><br/>
<hr/>
<a href="add.jsp">添加</a>
<table width="80%" border="1" cellspacing="0" cellpadding="0">
    <tr>
        <th>姓名</th>
        <th>性别</th>
        <th>手机</th>
        <th>邮箱</th>
        <th>操作</th>
    </tr>
    <c:forEach var="person" items="${requestScope.persons}">
        <tr>
            <td><a href="queryPersonDetailAction?id=${person.id}">${person.name}</a></td>
            <td>${person.sex}</td>
            <td>${person.phoneNumber}</td>
            <td>${person.email}</td>
            <td align="center"><a href="updatePersonDetailAction?id=${person.id}">修改</a> <a
                    href="deleteAction?id=${person.id}">删除</a></td>
        </tr>
    </c:forEach>
    <%--<tr>--%>
    <%--<td>李四</td>--%>
    <%--<td>22222222222</td>--%>
    <%--<td>2222-2222222</td>--%>
    <%--<td>bb@bb.bb</td>--%>
    <%--<td align="center"><a href="#">修改</a> <a href="list.html">删除</a></td>--%>
    <%--</tr>--%>
</table>
</body>
</html>
