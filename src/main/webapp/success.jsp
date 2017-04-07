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
<form action="test" method="post">
    Start date: <input type="date" name="startDate" size="10"><br>
    End date: <input type="date" name="endDate" size="10"><br>
    <%--Performer: <input type="text" name="performer"><br>--%>
    Performer:<select name="performer" class="frmCmb1">
    <option value="">All performers</option>
    <c:forEach var="lists" items="${l}">
        <option value="${lists.performer}">
                ${lists.performer}
                <%--<option value="${lists}">--%>
                <%--${lists}--%>
        </option>
    </c:forEach>
</select>
    Time period: <input type="datetime-local" name="address"><br>

    <p>
    <table>
        <tr>
            <th><small>
                <input type="submit" name="success" value="Submit">
            </small>

<h1>По вашему запросу найдены следующие отчеты:</h1>


</form>
<c:forEach items="${users}" var="performer">
    <%--<jsp:useBean id="user" class="ru.testScandJavaJsp.model.Database" scope="application"/>--%>
    <tr>
            <%--<td>Performer: <%= user.getPerformer()%> </td>--%>
        <td>Performer:${performer.performer}</td>
            <%--<td>Activity: <%= user.getActivity()%></td>--%>
        <td>Activity: ${performer.activity}</td><br>
    </tr>
</c:forEach>
</body>
</html>
