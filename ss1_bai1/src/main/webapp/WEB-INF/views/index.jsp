<%--
  Created by IntelliJ IDEA.
  User: nguyenha
  Date: 30/7/26
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Currency Converter</title>
</head>
<body>
<h2>Chuyển đổi USD sang VND</h2>
<form action="${pageContext.request.contextPath}/convert" method="post">
    Tỷ giá:
    <input type="number" name="rate">
    <br><br>
    USD:
    <input type="number" name="usd">
    <br><br>
    <input type="submit" value="Convert">
</form>
<h3>Kết quả: ${result}</h3>
</body>
</html>