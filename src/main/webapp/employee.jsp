<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html dir="rtl" lang="fa">
<head>
    <title>Employee</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/assets/bootstrap.min.css">
    <script src="/assets/jquery.min.js"></script>
    <script src="/assets/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="menuEmployee.jsp"/>
<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading"> ایجاد کارمند</div>
        <div class="panel-body">
            <form action="/employee/insertEmployee">
                <div class="form-group">
                    <label for="name"> نام: </label>
                    <input type="text" class="form-control" id="name" name="name"/>
                </div>
                <div class="form-group">
                    <label for="family">نام خانوادگی:</label>
                    <input type="text" class="form-control" id="family" name="family"/>
                </div>
                <div class="form-group">
                    <label for="fatherName"> نام پدر:</label>
                    <input type="text" class="form-control" id="fatherName" name="fatherName">
                </div>
                <div class="form-group">
                    <label for="idCode">کد ملی: </label>
                    <input type="text" class="form-control" id="idCode" name="idCode">
                </div>
                <div class="form-group">
                    <label for="nationalCode"> شماره شناسنامه: </label>
                    <input type="text" class="form-control" id="nationalCode" name="nationalCode">
                </div>
                <div class="form-group">
                    <label for="address"> آدرس: </label>
                    <input type="text" class="form-control" id="address" name="address">
                </div>
                <div class="form-group">
                    <label for="phoneNumber"> تلفن همراه: </label>
                    <input type="tel" class="form-control" id="phoneNumber" name="phoneNumber">
                </div>
                <div class="form-group">
                    <label for="email"> ایمیل: </label>
                    <input type="email" class="form-control" id="email" name="email">
                </div>
                <div class="form-group">
                    <label for="field"> مدرک تحصیلی: </label>
                    <input type="text" class="form-control" id="field" name="field">
                </div>
                <div class="form-group">
                    <label for="certificate"> رشته تحصیلی: </label>
                    <input type="text" class="form-control" id="certificate" name="certificate">
                </div>
                <div class="form-group">
                    <label for="surface"> سطح: </label>
                    <input type="text" class="form-control" id="surface" name="surface">
                </div>
                <div class="form-group">
                    <label for="supervisor"> سرپرست: </label>
                    <input type="text" class="form-control" id="supervisor" name="supervisor">
                </div>

                <input style="width: 100%" type="submit" value="ثبت" class="btn btn-info"/>
            </form>
            <table class="table table-hover" style="width: 150%">
                <tr>
                    <td>شناسه</td>
                    <td>نام</td>
                    <td>نام خانوادگی</td>
                    <td>نام پدر</td>
                    <td>کد ملی</td>
                    <td> شماره شناسنامه</td>
                    <td> آدرس</td>
                    <td> تلفن همراه</td>
                    <td> ایمیل</td>
                    <td>مدرک تحصیلی</td>
                    <td> رشته تحصیلی</td>
                    <td> سطح</td>
                    <td> سرپرست</td>
                    <td>ویرایش</td>
                    <td>حذف</td>
                </tr>
                <c:forEach items="${requestScope.list}" var="employee">
                    <tr>
                        <form action="/employee/updateEmployee">
                            <div class="form-group">
                                <td><input class="form-control" style="width: 100%" type="text" readonly name="id"
                                           value="${employee.id}"/></td>
                            </div>
                            <div class="form-group">
                                <td><input class="form-control" style="width: 100%" type="text" name="name"
                                           value="${employee.name}"/></td>
                            </div>
                            <div class="form-group">
                                <td><input class="form-control" style="width: 100%" type="text" name="family"
                                           value="${employee.family}"/></td>
                            </div>
                            <div class="form-group">
                                <td><input class="form-control" style="width: 100%" type="text" name="fatherName"
                                           value="${employee.fatherName}"></td>
                            </div>
                            <div class="form-group">
                                <td><input class="form-control" style="width: 100%" type="text" name="idCode"
                                           value="${employee.idCode}"></td>
                            </div>
                            <div class="form-group">
                                <td><input class="form-control" style="width: 100%" type="text" name="nationalCode"
                                           value="${employee.nationalCode}"></td>
                            </div>
                            <div class="form-group">
                                <td><input class="form-control" style="width: 100%" type="text" name="address"
                                           value="${employee.address}"></td>
                            </div>
                            <div class="form-group">
                                <td><input class="form-control" style="width: 100%" type="tel" name="phoneNumber"
                                           value="${employee.phoneNumber}"></td>
                            </div>
                            <div class="form-group">
                                <td><input class="form-control" style="width: 100%" type="email" name="email"
                                           value="${employee.email}"></td>
                            </div>
                            <div class="form-group">
                                <td><input class="form-control" style="width: 100%" type="text" name="field"
                                           value="${employee.field}"></td>
                            </div>

                            <div class="form-group">
                                <td><input class="form-control" style="width: 100%" type="text" name="certificate"
                                           value="${employee.certificate}"></td>
                            </div>
                            <div class="form-group">
                                <td><input class="form-control" style="width: 100%" type="text" name="surface"
                                           value="${employee.surface}"></td>
                            </div>
                            <div class="form-group">
                                <td><input class="form-control" style="width: 100%" type="text" name="supervisor" value="${employee.supervisor}"></td>
                            </div>
                            <td><input style="width: 100%" type="submit" value="ویرایش" class="btn btn-danger"/></td>
                            <td><input style="width: 100%" type="button" value="حذف"
                                       onclick="removeEmployee(${employee.id})" class="btn btn-danger"/></td>
                        </form>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<script>
    function removeEmployee(id) {
        if (confirm("آیا مطمئن هستید؟")) {
            window.location = '/employee/removeEmployee?id=' + id;
        }
    }
</script>
</body>
</html>
