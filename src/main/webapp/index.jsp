<%@ page import="java.util.List" %>
<%@ page import="ru.testScandJavaJsp.model.Database" %>
<%@ page import="ru.testScandJavaJsp.model.DatabaseList" %><%--
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
<form action="test" method="post">
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
    </c:forEach><br>

</select>
    <%--Performer:   <c:out value="${sessionScope.l}"/><br>--%>


    <%--<jsp:useBean id="user" class="ru.testScandJavaJsp.model.Database" scope="application"/>--%>

    <%--Performer:--%>
    <%--<%--%>
        <%--List linhas = (List)request.getAttribute("l");--%>
        <%--for(int i = 0; i < linhas.size(); i++) {--%>
            <%--Database baseLocal = linhas.get(i);--%>
    <%--%>--%>
    <%--<select name="linhas">--%>
        <%--<option value=<%=linhaLocal.getId()%>> <%=linhaLocal.getDescricao();%> </option>																</select>--%>
    <%--<% } //fecha for--%>
    <%--%>--%>


    <%--<select name="linhas">--%>
        <%--<%--%>
            <%--List linhas = (List)request.getAttribute("l");--%>
            <%--for(int i = 0; i < linhas.size(); i++) {--%>

                <%--Database linhaLocal = linhas.get(i);--%>
        <%--%>--%>
        <%--<option value=<%=linhaLocal.getId()%>> <%=linhaLocal.getPerformer()%> </option>--%>
        <%--<% } //fecha for--%>
        <%--%>--%>
    <%--</select>--%>

<%--</select>--%>

    <%--<br><br><br>--%>
    <%--<select>--%>
        <%--<c:forEach var="list" items="${Database.list}">--%>
            <%--<option value="${list.id}">${list.performer}</option>--%>
        <%--</c:forEach>--%>
    <%--</select>--%>



    Time period: <input type="datetime-local" name="address"><br>

    <p>
    <table>
        <tr>
            <th><small>
                <input type="submit" name="success" value="Submit">
            </small>

    </table>
</form>


</select>

</form>
<%--<jsp:useBean id="user" class="ru.testScandJavaJsp.model.Database" scope="application"/>--%>
<%--Пользователь: <%= user.getPerformer()%><br>--%>
<%--Email: <%= user.getActivity()%><br>--%>
</body>
</html>
