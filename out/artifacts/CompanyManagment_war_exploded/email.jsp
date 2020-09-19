<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="email/insertEmail">
    <input type="text" name="subject"/>
    <input type="text" name="content"/>
    <input type="submit" value="Save"/>
</form>
<table border="1" style="width: 100%">
    <tr>
        <td>ID</td>
        <td>SUBJECT</td>
        <td>CONTENT</td>
        <td>UPDATE</td>
        <td>DELETE</td>
    </tr>
    <c:forEach items="${requestScope.list}" var="email">
        <tr>
            <form action="/email/updateEmail">
                <td><input style="width: 100%" type="text" readonly name="id" value="${email.id}"/></td>
                <td><input style="width: 100%" type="text" name="subject" value="${email.name}"/></td>
                <td><input style="width: 100%" type="text" name="content" value="${email.family}"/></td>
                <td><input style="width: 100%" type="submit" value="Update"/></td>
                <td><input style="width: 100%" type="button" value="Delete" onclick="removeEmail(${email.id})"/></td>
            </form>
        </tr>
    </c:forEach>
</table>
<script>
    function removeEmployee(id) {
        if (confirm("are you sure?"))
        {
            window.location="/email/removeEmail?id="+id;
        }
    }
</script>
</body>
</html>
