<%--
  Created by IntelliJ IDEA.
  User: nguyenha
  Date: 30/7/26
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>Từ điển Anh - Việt</title>
</head>
<body>

<h2>Từ điển Anh - Việt</h2>
<form action="${pageContext.request.contextPath}/search" method="post">
  Nhập từ tiếng Anh:
  <input type="text" name="word">
  <input type="submit" value="Tra cứu">
</form>
<h3>Kết quả: ${result}</h3>
</body>
</html>