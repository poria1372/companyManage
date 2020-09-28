<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/assets/bootstrap.min.css">
    <script src="/assets/jquery.min.js"></script>
    <script src="/assets/bootstrap.min.js"></script>
    <title>جستجوی کارمندان</title>
</head>
<body>
<jsp:include page="menuSearch.jsp"/>
<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading"> لیست کارمند</div>
        <div class="panel-body">
            <table class="table table-hover" style="width: 200%">
                <tr>
                    <td> شناسه</td>
                    <td>نام</td>
                    <td>نام خانوادگی</td>
                    <td>نام پدر</td>
                    <td>کد ملی</td>
                    <td>شماره شناسنامه</td>
                    <td>آدرس</td>
                    <td>تلفن همراه</td>
                    <td>ایمیل</td>
                    <td>مدرک تحصیلی</td>
                    <td>رشته تحصیلی</td>
                    <td>سطح</td>
                    <td>سرپرست</td>

</tr>
<%
    try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "pouria", "myjava123");
        Statement statement = connection.createStatement();
        String name = request.getParameter("name");
        String family = request.getParameter("family");
        String idCode=request.getParameter("idCode");
        String sql = "select * from employee where name='" + name + "' and family='" + family + "'and idCode='"+idCode+"'";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
%>
<tr>
    <td><%=resultSet.getInt("id")%>
    </td>
    <td><%=resultSet.getString("name")%>
    </td>
    <td><%=resultSet.getString("family")%>
    </td>
    <td><%=resultSet.getString("fatherName")%>
    </td>
    <td><%=resultSet.getString("idCode")%>
    </td>
    <td><%=resultSet.getString("nationalCode")%>
    </td>
    <td><%=resultSet.getString("address")%>
    </td>
    <td><%=resultSet.getString("phoneNumber")%>
    </td>
    <td><%=resultSet.getString("email")%>
    </td>
    <td><%=resultSet.getString("field")%>
    </td>
    <td><%=resultSet.getString("certificate")%>
    </td>
    <td><%=resultSet.getString("surface")%>
    </td>
    <td><%=resultSet.getString("supervisor")%>
    </td>
    </div>
    </div>
    </div>
</tr>

<%
        }

    } catch (Exception e) {

    }
%>
</table>
</body>
</html>
