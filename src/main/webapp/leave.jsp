<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Leave</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/assets/bootstrap.min.css">
    <script src="/assets/jquery.min.js"></script>
    <script src="/assets/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="menuLeave.jsp"/>
<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading"> ثبت مرخصی</div>
        <div class="panel-body">
            <form action="/leave/insertLeave">
                <div class="form-group">
                    <label for="leaveCondition">نوع مرخصی:</label>
                    <input type="text" class="form-control" id="leaveCondition" name="leaveCondition">
                </div>
                <div class="form-group">
                    <label for="fromDate"> از تاریخ: </label>
                    <input type="date" class="form-control" id="fromDate" name="fromDate"/>
                </div>
                <div class="form-group">
                    <label for="upToDate">تا تاریخ:</label>
                    <input type="date" class="form-control" id="upToDate" name="upToDate"/>
                </div>

                <input style="width: 100%" type="submit" value="ثبت" class="btn btn-info"/>
            </form>
            <table class="table table-hover" style="width: 100%">
                <tr>
                    <td>نوع مرخصی</td>
                    <tdاز تاریخ:</td>
                    <td> تا تاریخ</td>
                    <td>ویرایش</td>
                    <td>حذف</td>
                </tr>
                <c:forEach items="${requestScope.list}" var="leave">
                    <tr>
                        <form action="/leave/updateLeave">
                            <div class="form-group">
                                <td><input class="form-control" style="width: 100%" type="text" readonly name="id" value="${leave.id}"/></td>
                            </div>
                            <div class="form-group">
                                <td><input class="form-control" style="width: 100%" type="text" name="leaveCondition" value="${leave.leaveCondition}"/></td>
                            </div>
                            <div class="form-group">
                                <td><input class="form-control" style="width: 100%" type="date" name="fromDate" value="${leave.fromDate}"/></td>
                            </div>
                            <div class="form-group">
                                <td><input class="form-control" style="width: 100%" type="date" name="upToDate" value="${leave.upToDate}"/></td>
                            </div>
                            <td><input style="width: 100%" type="submit" value="ویرایش" class="btn btn-danger"/></td>
                            <td><input style="width: 100%" type="button" value="حذف" onclick="removeLeave(${leave.id})" class="btn btn-danger"/></td>
                        </form>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<script>
    function removeLeave(id) {
        if (confirm("are you sure?")) {
            window.location = '/leave/removeLeave?id=' + id;
        }
    }
</script>
</body>
</html>
