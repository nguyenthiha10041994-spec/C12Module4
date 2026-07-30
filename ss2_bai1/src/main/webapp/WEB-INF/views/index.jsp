<%--
  Created by IntelliJ IDEA.
  User: nguyenha
  Date: 30/7/26
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Sandwich Condiments</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="${pageContext.request.contextPath}/save" method="post">
  <input type="checkbox" name="condiment" value="Lettuce"> Lettuce <br><br>
  <input type="checkbox" name="condiment" value="Tomato"> Tomato <br><br>
  <input type="checkbox" name="condiment" value="Mustard"> Mustard <br><br>
  <input type="checkbox" name="condiment" value="Sprouts"> Sprouts <br><br>
  <input type="submit" value="Save">
</form>
</body>
</html>