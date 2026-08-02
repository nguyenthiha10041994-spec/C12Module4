<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Email Settings</title>
</head>
<body>

<h2>Settings</h2>

<form:form method="post" action="/update" modelAttribute="setting">

    <table>

        <tr>
            <td>Language:</td>
            <td>
                <form:select path="language">
                    <form:options items="${languages}"/>
                </form:select>
            </td>
        </tr>

        <tr>
            <td>Page Size:</td>
            <td>
                Show
                <form:select path="pageSize">
                    <form:options items="${pageSizes}"/>
                </form:select>
                emails per page
            </td>
        </tr>

        <tr>
            <td>Spams Filter:</td>
            <td>
                <form:checkbox path="spamFilter"/>
                Enable spams filter
            </td>
        </tr>

        <tr>
            <td>Signature:</td>
            <td>
                <form:textarea path="signature" rows="5" cols="30"/>
            </td>
        </tr>

        <tr>
            <td></td>
            <td>
                <input type="submit" value="Update">
            </td>
        </tr>

    </table>

</form:form>

</body>
</html>