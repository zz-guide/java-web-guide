<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式，Array,List,Map</title>
</head>
<body>
<%
    int[] arr = new int[]{1, 2, 3, 4, 5};
    request.setAttribute("arr", arr);

    List<String> list = new ArrayList<>();
    list.add("hello");
    list.add("world");
    request.setAttribute("list", list);

    Map<String,String> map = new HashMap<>();
    map.put("name", "仔仔");
    map.put("age", "33");
    request.setAttribute("map", map);
%>

<div>
    <div>=================================</div>
    <div>requestScope.arr[]: ${requestScope.arr[0]}</div>
    <div style="color: red">数组array</div>
</div>

<div>
    <div>=================================</div>
    <div>requestScope.list[]: ${requestScope.list.get(0)}</div>
    <div style="color: red">List</div>
</div>

<div>
    <div>=================================</div>
    <div>requestScope.map[]: ${requestScope.map["name"]}</div>
    <div style="color: red">Map</div>
</div>
</body>
</html>
