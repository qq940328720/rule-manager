<%--
  Created by IntelliJ IDEA.
  User: neeke
  Date: 18-1-24
  Time: 上午10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>认证</title>
</head>
<body>
<form action="auth" method="post">
    账号：
    <input name="username" type="text" /><br/>
    密码：
    <input name="password" type="text" />
    <input name="redirect" type="hidden" value="<%=request.getParameter("redirect")%>" />
    <br/>
    <input type="submit"/>
</form>
</body>
</html>
