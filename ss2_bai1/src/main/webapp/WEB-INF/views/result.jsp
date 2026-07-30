<%--
  Created by IntelliJ IDEA.
  User: nguyenha
  Date: 30/7/26
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Selected Condiments</title>
</head>
<body>
<h2>Gia vị đã chọn:</h2>
<c:choose>
    <c:when test="${not empty condiments}">
        <ul>
            <c:forEach var="item" items="${condiments}">
                <li>${item}</li>
            </c:forEach>
        </ul>
    </c:when>
    <c:otherwise>
        <p>Bạn chưa chọn gia vị nào.</p>
    </c:otherwise>
</c:choose>
<a href="/">Quay lại</a>
</body>
</html>