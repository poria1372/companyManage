<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html dir="rtl" lang="fa">
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
<form action="/receiver/insertReceiver">
    <table>
        <tr>
            <td>دریافت کننده:</td>
            <td> <input type="text" name="receiver"></td>
        </tr>
        <tr>
            <td><input type="submit" value="ذخیره"></td>
        </tr>


    </table>
</form>
<table border="1" style="width: 50%">
    <tr>
        <td>Id</td>
        <td>NAME</td>
        <td>Delete</td>
        <td>Update</td>

        <c:forEach items="${requestScope.list}" var="receiver">
    <tr>
        <form action="/receiver/updateReceiver">
            <td><input style="width: 50%" type="text" readonly name="id" value="${receiver.id}"/></td>
            <td><input style="width: 50%" type="email" name="receiver" value="${receiver.email}"/></td>
            <td><input style="width: 50%" type="submit" value="Update"/></td>
            <td><input style="width: 50%" type="button" value="Delete" onclick="removeReceiver(${receiver.id})"/>
            </td>
        </form>
    </tr>
    </c:forEach>
</table>
<script>
    function removeReceiver(id) {
        if (confirm("are you sure?")) {
            window.location = '/receiver/removeReceiver=' + id;
        }
    }
</script>
</body>
</html>
