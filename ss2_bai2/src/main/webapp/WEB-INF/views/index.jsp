<%--
  Created by IntelliJ IDEA.
  User: nguyenha
  Date: 30/7/26
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Calculator</title>
</head>
<body>
<h1>Calculator</h1>
<form action="${pageContext.request.contextPath}/calculate" method="post">
  <input type="number" step="any" name="number1" required
         value="${param.number1}">
  <input type="number" step="any" name="number2" required
         value="${param.number2}">
  <br><br>
  <button type="submit" name="operator" value="+">Cộng(+)</button>
  <button type="submit" name="operator" value="-">Trừ(-)</button>
  <button type="submit" name="operator" value="*">Nhân(X)</button>
  <button type="submit" name="operator" value="/">Chia(/)</button>
</form>
<h2>Result: ${result}</h2>
<p style="color:red">
  ${message}
</p>
</body>
</html>