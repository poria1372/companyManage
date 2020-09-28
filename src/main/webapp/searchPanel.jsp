<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html dir="rtl" lang="fa">
<head>
    <title>جستجو</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/assets/bootstrap.min.css">
    <script src="/assets/jquery.min.js"></script>
    <script src="/assets/bootstrap.min.js"></script>

</head>
<body>
<jsp:include page="menuSearchPanel.jsp"/>
<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading"> جستجوی کارمند</div>
        <div class="panel-body">
            <form action="/searchView.jsp">
                <div class="form-group">
                    <label for="name"> نام:</label>
                    <input type="text" class="form-control" id="name" name="name">
                </div>
                <div class="form-group">
                    <label for="family"> نام خانوادگی:</label>
                    <input type="text" class="form-control" id="family" name="family">
                </div>
                <div class="form-group">
                    <label for="idCode"> کد ملی:</label>
                    <input type="text" class="form-control" id="idCode" name="idCode">
                </div>
                <input style="width: 100%" type="submit" value="جستجو" class="btn btn-info"/>
            </form>
        </div>
    </div>
</div>
</body>
</html>
