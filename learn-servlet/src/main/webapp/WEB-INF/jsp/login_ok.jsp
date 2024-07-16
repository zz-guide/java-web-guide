<%@ page import="org.zz.web.guide.servlet.pojo.SessionUser" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
    Object sessionUserInfo = session.getAttribute("userInfo");
    if (sessionUserInfo == null) {
        return;
    }

    SessionUser sessionUser = (SessionUser)sessionUserInfo;
    request.setAttribute("sessionUser", sessionUser);
%>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
<h1>登录成功！！！</h1>
<div>用户信息：</div>
<div>用户id: ${sessionUser.getId()}</div>
<div>用户姓名: ${sessionUser.getName()}</div>
<div>用户角色: ${sessionUser.getRoleName()}</div>
</body>
</html>
