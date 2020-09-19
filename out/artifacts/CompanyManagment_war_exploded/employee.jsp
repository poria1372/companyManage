<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/employee/insertEmployee">
    <input type="text" name="name"/>
    <input type="text" name="family"/>
    <input type="submit" value="Save"/>
</form>
<table border="1" style="width: 100%">
    <tr>
        <td>ID</td>
        <td>NAME</td>
        <td>FAMILY</td>
        <td>UPDATE</td>
        <td>DELETE</td>
    </tr>
    <c:forEach items="${requestScope.list}" var="employee">
        <tr>
            <form action="/employee/updateEmployee">
                <td><input style="width: 100%" type="text" readonly name="id" value="${employee.id}"/></td>
                <td><input style="width: 100%" type="text" name="name" value="${employee.name}"/></td>
                <td><input style="width: 100%" type="text" name="family" value="${employee.family}"/></td>
                <td><input style="width: 100%" type="submit" value="Update"/></td>
                <td><input style="width: 100%" type="button" value="Delete" onclick="removeEmployee(${employee.id})"/></td>
            </form>
        </tr>
    </c:forEach>
</table>
<script>
    function removeEmployee(id) {
        if (confirm("are you sure?"))
        {
            window.location="/employee/removeEmployee?id="+id;
        }
    }
</script>
</body>
</html>
