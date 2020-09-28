<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html dir="rtl" lang="fa">
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
            <form action="/SendEmail" method="post">
                <table border="0" width="35%" align="center">
                    <div class="form-group">
                        <label for="user">فرستنده:</label>
                        <input type="text" class="form-control" id="user" name="user">
                    </div>
                    <div class="form-group">
                        <label for="pass"> رمز ایمیل:</label>
                        <input type="password" class="form-control" id="pass" name="pass">
                    </div>
                    <div class="form-group">
                        <label for="recipient"> گیرنده:</label>
                        <input type="text" class="form-control" id="recipient" name="recipient">
                    </div>
                    <div class="form-group">
                        <label for="subject">موضوع:</label>
                        <input type="text" class="form-control" id="subject" name="subject">
                    </div>
                    <div class="form-group">
                        <label for="content"> محتوا:</label>
                        <textarea class="form-control" rows="10" cols="40" id="content" name="content"></textarea>
                    </div>
                    <tr>
                        <div class="form-group">
                            <td colspan="2" align="center"><input type="submit" value="ارسال"/></td>
                        </div>
                    </tr>
                </table>

            </form>
            <table class="table table-hover" style="width: 100%">
                <tr>
                    <td>شناسه</td>
                    <td> فرستنده</td>
                    <td> رمز ایمیل</td>
                    <td> گیرنده</td>
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
                                <td><input class="form-control" style="width: 100%" type="text" name="user" value="${email.user}"/></td>
                            </div>
                            <div class="form-group">
                                <td><input class="form-control" style="width: 100%" type="text" name="pass" value="${email.pass}"/></td>
                            </div>
                            <div class="form-group">
                                <td><input class="form-control" style="width: 100%" type="text" name="recipient" value="${email.recipient}"/></td>
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
        if (confirm("آیا مطمئن هستید؟")) {
            window.location = '/email/removeEmail?id=' + id;
        }
    }
</script>
</body>
</html>
