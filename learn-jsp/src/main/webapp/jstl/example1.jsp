<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL c标签</title>
</head>
<body>
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

</div>
<div>
    <div>===============迭代: foreach ==================</div>

</div>
</body>
</html>
