<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式，隐式对象</title>
</head>
<body>
<%
    System.out.println("request.getContextPath():"+ request.getContextPath()); // /learn_jsp_war_exploded
%>

<div>
    <div>=================================</div>
    <div>pageContext.request.contextPath: ${pageContext.request.contextPath}</div>
    <div style="color: red">不包含协议，端口，域名等信息</div>
</div>
</body>
</html>
