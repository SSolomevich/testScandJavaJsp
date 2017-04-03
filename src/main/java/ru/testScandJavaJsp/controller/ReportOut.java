package ru.testScandJavaJsp.controller;

import ru.testScandJavaJsp.model.Database;
import ru.testScandJavaJsp.model.DatabaseList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by 15 on 03.04.2017.
 */
public class ReportOut extends Dispatcher {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        Database base = UserList.findUser(request.getParameter("user"));
//        if (user == null){
//            this.forward("/registration.html", request, response);
//        } else {
//            if
//                    (!user.getPassword().equals(request.getParameter("password"))){
//                this.forward("/registration.html", request, response);
//            } else {
//                this.forward("/successLogin.jsp", request, response);
//            }
        DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        ServletContext ctx = getServletContext();
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("yyyy-MM-dd");
        for (int i = 0; i < DatabaseList.list.size(); i++) {
            if
                    (DatabaseList.list.get(i).getDateTime().compareTo(LocalDate.parse(request.getParameter("startDate"))) >= 0
                    && DatabaseList.list.get(i).getDateTime().compareTo(LocalDate.parse(request.getParameter("endDate"))) <= 0) {
                this.forward("/success.jsp", request, response);
//            } else {
//                this.forward("/successLogin.jsp", request, response);
//            }
            }


        }
    }
}
