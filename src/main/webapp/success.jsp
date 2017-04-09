<%--
  Created by IntelliJ IDEA.
  User: 15
  Date: 02.04.2017
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Страница успешного входа в систему</title>
</head>
<body>
<h1>Заполните следующие поля для вывода списка отчетов:</h1>
<form action="" method="post">
    Start date: <input type="date" name="startDate" size="10"><br>
    End date: <input type="date" name="endDate" size="10"><br>
    <%--Performer: <input type="text" name="performer"><br>--%>

    Performer:<select name="performer" class="frmCmb1">
    <option value="">All performers</option>
    <c:forEach var="list" items="${list}">
        <option value="${list}">
                ${list}
        </option>
    </c:forEach>
</select>

    <br>

    Time period: <select name="comboBoxDate" class="frmCmb1">
    <option value=""></option>
    <c:forEach var="list2" items="${listComboBox}">
        <option value="${list2}">
                ${list2}
        </option>
    </c:forEach>
</select><br>

    <p>
    <table>
        <tr>
            <th><small>
                <input type="submit" name="success" value="Submit">
            </small>

<h1>По вашему запросу найдены следующие отчеты:</h1>


</form>
<c:forEach items="${users}" var="performer">
<table border="3" align="center" width="700">
    <tr>
        <td>Performer: ${performer.performer}</td>
        <td>Activity: ${performer.activity}</td>
        <td>Date: ${performer.date}</td>
    </tr>
</table>
</c:forEach>
</body>
</html>
