<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式基础</title>
</head>
<body>
<%
    request.setAttribute("name", "仔仔");

    pageContext.setAttribute("age", 23);
%>

<div>
    <div>=================================</div>
    <div>requestScope.name: ${requestScope.name}</div>
    <div>requestScope.age: ${requestScope.age}</div>
    <div style="color: red">从request作用于查找name的值，找到就返回，没找到就返回 ""</div>
</div>


<div>
    <div>=================================</div>
    <div>name: ${name}</div>
    <div>age: ${age}</div>
    <div style="color: red">从最小作用域逐级查找name的值，找到就返回，没找到就返回 ""</div>
</div>

</body>
</html>
