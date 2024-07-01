<%@ page import="java.util.List" %>
<%@ page import="org.zz.enitiy.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<style>
    table {
        width: 100%;
        border-collapse: collapse;
    }
    th, td {
        border: 1px solid black;
        padding: 8px;
        text-align: left;
    }
    caption {
        font-size: 24px;
        font-weight: bold;
        padding: 8px;
    }
</style>
<head>
    <title>JSTL c标签</title>
</head>
<body>
<%
    List<Student> students = new ArrayList<>();
    students.add(new Student("学生1", "001", 100L, "火箭班"));
    students.add(new Student("学生2", "002", 90L, "宏志班"));
    students.add(new Student("学生3", "003", 80L, "实验班"));
    students.add(new Student("学生4", "004", 70L, "普通班"));

    request.setAttribute("students", students);
%>
<div>
    <div>===============单条件: if ==================</div>
    <c:if test="${ 8 > 2 }">
        <div> 8 > 2 成立 </div>
    </c:if>
    <c:if test="${ 8 <= 2 }">
        <div> 8 <= 2 成立 </div>
    </c:if>
</div>
<div>
    <div>===============多条件: choose ==================</div>
    <c:set var="score" value="80" />
    <c:choose>
        <c:when test="${score >= 90}">优秀</c:when>
        <c:when test="${score >= 80}">良好</c:when>
        <c:when test="${score >= 70}">中等</c:when>
        <c:when test="${score >= 60}">及格</c:when>
        <c:otherwise>不及格</c:otherwise>
    </c:choose>
</div>
<div>
    <div>===============迭代: foreach ==================</div>
    <table>
        <caption>学生列表</caption>
        <tr>
            <th>学号</th>
            <th>姓名</th>
            <th>成绩</th>
            <th>班级</th>
            <th>是否第一个</th>
            <th>是否最后一个</th>
            <th>计数count</th>
            <th>索引index</th>
        </tr>
        <!--varStatus: 变量状态，遍历出每一项内容的状态
        first: 是不是第一行
        last: 是不是最后一行
        count: 当前行数
        index: 当前元素的下标
        -->
        <c:forEach var="stu" items="${requestScope.students}" varStatus="vs">
            <tr>
                <td>${stu.sn}</td>
                <td>${stu.name}</td>
                <td>${stu.score}</td>
                <td>${stu.classes}</td>
                <td>${vs.first}</td>
                <td>${vs.last}</td>
                <td>${vs.count}</td>
                <td>${vs.index}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
