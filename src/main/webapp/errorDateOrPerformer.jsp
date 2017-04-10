<%--
  Created by IntelliJ IDEA.
  User: 15
  Date: 09.04.2017
  Time: 12:57
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Страница ошибки ввода даты или исполнителя</title>
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
        <table   >
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
                <td  ><select name="performer" class="input">
                    <option value="" >  All performers  </option>
                    <c:forEach var="list" items="${list}">
                        <option value="${list}"> ${list} </option>
                    </c:forEach>
                </select></td>
            </tr>
            <tr>
                <td class="noInput">Time period:</td>
                <td  ><select name="comboBoxDate" class="input" >
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

    <div class="nameTable2"><h2>Должны быть выбраны даты и исполнитель!</h2></div>

</form>

</body>
</html>
