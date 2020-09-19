<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <style type="text/css">
        body {
            text-align: center;
        }

        table {
            margin-left: 15%;
            min-width: 70%;
            border: 1px solid #CCC;
            border-collapse: collapse;
        }

        table tr {
            line-height: 30px;
        }

        table tr th {
            background: #000033;
            color: #FFF;
        }

        table tr td {
            border: 1px solid #CCC;
            margin: 5px;
        }

        input[type=text], input[type=email], input[type=tel] {
            min-width: 15%;
        }

        input[type=submit], a {
            background: green;
            padding: 5px;
            margin: 5px;
            color: #FFF;
        }

        a {
            text-decoration: none;
        }
    </style>

</head>
<body>
<form action="/leave/insertLeave">
    <table>
        <tr>
            <td>LeaveCondition:</td>
            <td> <input type="text" name="leaveCondition"></td>
        </tr>
        <tr>
            <td>FromDate:</td>
            <td> <input type="text" name="fromDate"></td>
        </tr>
        <tr>
            <td>UpToDate:</td>
            <td> <input type="text" name="upToDate"></td>
        </tr>
        <tr>
            <td><input type="submit" value="save"></td>
        </tr>


    </table>
</form>
<table border="1" style="width: 50%">
    <tr>
        <td>Id</td>
        <td>NAME</td>
        <td>Delete</td>
        <td>Update</td>

        <c:forEach items="${requestScope.list}" var="leave">
    <tr>
        <form action="/leave/updateLeave">
            <td><input style="width: 50%" type="text" readonly name="id" value="${leave.id}"/></td>
            <td><input style="width: 50%" type="text" name="leaveCondition" value="${leave.leaveCondition}"/></td>
            <td> <input style="width: 100%" type="text" name="fromDate" value="${leave.fromDate}"></td>
            <td> <input style="width: 100%" type="text" name="upToDate" value="${leave.upToDate}"></td>
            <td><input style="width: 50%" type="submit" value="Update"/></td>
            <td><input style="width: 50%" type="button" value="Delete" onclick="removeLeave(${leave.id})"/>
            </td>
        </form>
    </tr>
    </c:forEach>
</table>
<script>
    function removeLeave(id) {
        if (confirm("are you sure?")) {
            window.location = '/leave/removeLeave?id=' + id;
        }
    }
</script>
</body>
</html>
