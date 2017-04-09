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
<form action="" method="post">
    <table>
   <td>
       Start date: <input type="date" name="startDate" size="10"> </td>
        <td>End date: <input type="date" name="endDate" size="10"></td>


        <td> Performer:<select name="performer" class="frmCmb1">
    <option value="">All performers</option>
    <c:forEach var="list" items="${list}">
        <option value="${list}">
                ${list}
               </option>
    </c:forEach>

    </select>
    </td>

   <td> Time period: <select name="comboBoxDate" class="frmCmb1">
    <option value=""></option>
    <c:forEach var="list2" items="${listComboBox}">
        <option value="${list2}">
                ${list2}
        </option>
    </c:forEach>
   </select></td>
    </table>

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

    <p>
    <table>
        <tr>
            <th><small>
                <input type="submit" name="success" value="Submit">
            </small>

    </table>
</form>

</body>

