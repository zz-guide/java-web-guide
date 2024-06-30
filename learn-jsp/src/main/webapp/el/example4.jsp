<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式，运算符</title>
</head>
<body>
<%
    request.setAttribute("num", 1234);
    request.setAttribute("empty_keyword", 1234);
%>
<div>num: ${requestScope.num}</div>
<div>
    <div>===============算数运算==================</div>
    <div>num+1: ${requestScope.num + 1}</div>
    <div>num-1: ${requestScope.num - 1}</div>
    <div>num*2: ${requestScope.num * 2}</div>
    <div>num/3: ${requestScope.num / 3}</div>
</div>
<div>
    <div>===============关系运算==================</div>
    <div>num == 1: ${requestScope.num == 1}</div>
    <div>num != 1: ${requestScope.num != 1}</div>
    <div>num > 1: ${requestScope.num > 1}</div>
    <div>num < 1: ${requestScope.num < 1}</div>
    <div>num >= 1: ${requestScope.num >= 1}</div>
    <div>num <= 1: ${requestScope.num >= 1}</div>
</div>
<div>
    <div>===============逻辑运算==================</div>
    <div>num / 2 == 1: ${requestScope.num % 2 == 0 || requestScope.num / 2 == 1}</div>
    <div>num % 2 == 1: ${requestScope.num % 2 == 0 && requestScope.num % 4 == 0}</div>
    <div>!(num > 1234): ${!(requestScope.num > 1234)}</div>
</div>
<div>
    <div>===============empty关键字==================</div>
    <div>empty "": ${empty "" }</div>true
    <div>empty null: ${empty null }</div>true
    <div>empty false: ${empty false }</div>false
    <div>empty 0: ${empty 0 }</div>false
    <div>empty "0": ${empty "0" }</div>false
</div>
</body>
</html>
