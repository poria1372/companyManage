<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Email</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/assets/bootstrap.min.css">
    <script src="/assets/jquery.min.js"></script>
    <script src="/assets/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="menuEmail.jsp"/>
<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading"> ارسال ایمیل</div>
        <div class="panel-body">
            <form action="/email/insertEmail">
                <div class="form-group">
                    <label for="senderId"> شناسه فرستنده</label>
                   <input type="text" class="form-control" id="senderId" name="senderId">
                </div>
                <div class="form-group">
                    <label for="subject"> موضوع: </label>
                    <input type="text" class="form-control" id="subject" name="subject"/>
                </div>
                <div class="form-group">
                    <label for="content">محتوا:</label>
                    <input type="text" class="form-control" id="content" name="content"/>
                </div>


                <input style="width: 100%" type="submit" value="ارسال" class="btn btn-info"/>
            </form>
            <table class="table table-hover" style="width: 100%">
                <tr>
                    <td>شناسه</td>
                    <td>موضوع</td>
                    <td> محتوا</td>
                    <td>ویرایش</td>
                    <td>حذف</td>
                </tr>
                <c:forEach items="${requestScope.list}" var="email">
                    <tr>
                        <form action="/email/updateEmail">
                            <div class="form-group">
                                <td><input class="form-control" style="width: 100%" type="text" readonly name="id" value="${email.id}"/></td>
                            </div>
                            <div class="form-group">
                                <td><input class="form-control" style="width: 100%" type="text" name="senderId" value="${email.senderId}"/></td>
                            </div>
                            <div class="form-group">
                                <td><input class="form-control" style="width: 100%" type="text" name="subject" value="${email.subject}"/></td>
                            </div>
                            <div class="form-group">
                                <td><input class="form-control" style="width: 100%" type="text" name="content" value="${email.content}"/></td>
                            </div>
                            <td><input style="width: 100%" type="submit" value="ویرایش" class="btn btn-danger"/></td>
                            <td><input style="width: 100%" type="button" value="حذف" onclick="removeEmail(${email.id})" class="btn btn-danger"/></td>
                        </form>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<script>
    function removeEmail(id) {
        if (confirm("are you sure?")) {
            window.location = '/email/removeEmail?id=' + id;
        }
    }
</script>
</body>
</html>
