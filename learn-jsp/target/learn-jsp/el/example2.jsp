<%@ page import="org.zz.enitiy.Person" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式，Bean对象</title>
</head>
<body>
<%
    Person person = new Person();
    person.setName("仔仔");
    person.setAge(23);

    request.setAttribute("person", person);
%>

<div>
    <div>=================================</div>
    <div>requestScope.p.name: ${person.name}</div>
    <div style="color: red">其实是调用的getName()方法，不是直接访问属性</div>
    <div style="color: red">必须放在作用域里才能访问</div>
</div>

</body>
</html>
