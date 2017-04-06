<%--
  Created by IntelliJ IDEA.
  User: 15
  Date: 06.04.2017
  Time: 0:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
</head>
<body>
<h1>Заполните следующие поля для вывода списка отчетов:</h1>
<form action="ReportOut" method="post">
    Start date: <input type="date" name="startDate" size="10"><br>
    End date: <input type="date" name="endDate" size="10"><br>
    Performer: <input type="text" name="performer" size="10"><br>
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

<%--<select name="performer" size="1" >--%>
    <%--<c:forEach items="${DatabaseList.list}" var="performer">--%>
        <%--<jsp:useBean id="user" class="ru.testScandJavaJsp.model.DatabaseList" scope="application"/>--%>

                <%--<td>Performer: <%= user.getPerformer()%> </td>--%>
            <%--<td>Performer:${performer.performer}</td>--%>
                <%--<td>Activity: <%= user.getActivity()%></td>--%>
            <%--<td>Activity: ${performer.activity}</td><br>--%>
                    <%--<option value="1более">performer.performer</option>--%>

    <%--</c:forEach>--%>
<%--</select><br />--%>
    Time period: <input type="datetime-local" name="address"><br>

    <p>
    <table>
        <tr>
            <th><small>
                <input type="submit" name="success" value="Submit">
            </small>

    </table>
</form>
</body>
</html>
