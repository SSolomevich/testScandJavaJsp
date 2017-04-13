<%--
  Created by IntelliJ IDEA.
  User: Sergey Solomevich
  Date: 02.04.2017
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="calendar" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Страница успешного входа в систему</title>
    <style type="text/css">
        .nameTable1
        {
            font-family: Arial, sans-serif;
            margin-left: 200px;
            margin-top: 20px;
        }
        .nameTable2
        {
            font-family: Arial, sans-serif;
            margin-left: 200px;
            margin-top: 50px;
        }
        .table1
        {
            margin-left: 300px;
            margin-top: 30px;
            border-collapse: collapse;
            font-family: Arial, sans-serif;
            color: #333;
            line-height: 2px;
            border: 3px;
        }
        .table2
        {
            margin-left: 300px;
            margin-top: 30px;
            border-collapse: collapse;
            font-family: Arial, sans-serif;
            color: #333;
            line-height: 2px;
            border-color: #333333;
            border-style: solid;
            border-width: 2px;
        }
        .input
        {
            font-family: Arial, sans-serif;
            font-size: 16px;
            padding: 10px ;
            height: 40px;
            width: 150px;
        }
        .noInput
        {
            font-family: Arial, sans-serif;
            font-size: 16px;
            padding: 10px ;
            color: blue;
            text-align: left;
            height: 40px;
            width: 150px;
        }
        .input2
        {
            font-family: Arial, sans-serif;
            font-size: 16px;
            padding: 10px ;
            height: 40px;
            border-color: slategray;
            border-style: solid;
            border-width: 2px;
            text-align: center;
        }
        .noInput2
        {
            font-family: Arial, sans-serif;
            font-size: 16px;
            padding: 10px ;
            color: blue;
            height: 40px;
            border-color: slategray;
            border-style: solid;
            border-width: 2px;
            text-align: center;
        }
        .buttomSubmit
        {
            margin-left: 400px;
            margin-top: 15px;
        }
    </style>
</head>
<body>

<h2 class="nameTable1">Заполните поля для вывода списка отчетов:</h2>
<form action="" method="post">
    <div class="table1">
        <table>
            <tr>
                <td class="noInput">Start date:</td>
                <td><input type="date" name="startDate"   class="input"></td>
            </tr>
            <tr>
                <td class="noInput">End date: </td>
                <td><input type="date" name="endDate"  class="input"></td>
            </tr>
            <tr>
                <td class="noInput">Performer:</td>
                <td><select name="performer" class="input">
                    <option value="" >  All performers  </option>
                    <c:forEach var="list" items="${list}">
                        <option value="${list}"> ${list} </option>
                    </c:forEach>
                </select></td>
            </tr>
            <tr>
                <td class="noInput">Time period:</td>
                <td><select name="comboBoxDate" class="input" >
                    <option value=""></option>
                    <c:forEach var="list2" items="${listComboBox}">
                        <option value="${list2}"> ${list2} </option>
                    </c:forEach>
                </select></td>
            </tr>
        </table>
    </div>

    <div class="buttomSubmit">
        <table >
            <tr>
                <td>
                    <input type="submit" name="success" value="Submit" class="input">
                </td>
            </tr>
        </table>
    </div>

    <div class="nameTable2"><h2>По вашему запросу найдены следующие отчеты:</h2></div>

    <div>
        <table class="table2">
            <tr>
                <td class="noInput2" width="50px">ID</td>
                <td class="noInput2" width="150px">Activity</td>
                 <td class="noInput2" width="50px">Date</td>
             </tr>
            <c:forEach items="${users}" var="performer">
            <tr>
                <td class="input2"> ${performer.id}</td>
                 <td class="input2">${performer.activity}</td>
                    <%--Вывод даты в формате, согласно условию задания--%>
                 <td class="input2">
                    <fmt:parseDate value="${performer.date}" pattern="yyyy-MM-dd"
                         var="parsedDate" type="date" />
                    <fmt:formatDate value="${parsedDate}" var="stdDatum"
                         type="date" pattern="MMM d, yyyy" />
                    ${stdDatum}</td>
            </tr>
            </c:forEach>
        </table>
    </div>
</form>
</body>
</html>
