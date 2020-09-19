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
<form action="/categoryElement/insertCategoryElement">
    <table>
        <tr>
            <td>نام:</td>
            <td> <input type="text" name="name"></td>
        </tr>
        <tr>
            <td><input type="submit" value="ذخیره"></td>
        </tr>


    </table>
</form>
<table border="1" style="width: 50%">
    <tr>
        <td>Id</td>
        <td>نام</td>
        <td>حذف</td>
        <td>اصلاح</td>

        <c:forEach items="${requestScope.list}" var="categoryElement">
    <tr>
        <form action="/category/updateCategory">
            <td><input style="width: 50%" type="text" readonly name="id" value="${categoryElement.id}"/></td>
            <td><input style="width: 50%" type="text" name="name" value="${categoryElement.name}"/></td>
            <td><input style="width: 50%" type="submit" value="Update"/></td>
            <td><input style="width: 50%" type="button" value="Delete" onclick="removeCategoryElement(${categoryElement.id})"/>
            </td>
        </form>
    </tr>
    </c:forEach>
</table>
<script>
    function removeCategoryElement(id) {
        if (confirm("are you sure?")) {
            window.location = '/categoryElement/removeCategoryElement?id=' + id;
        }
    }
</script>
</body>
</html>
