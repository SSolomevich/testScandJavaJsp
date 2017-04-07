package ru.testScandJavaJsp.controller;

import ru.testScandJavaJsp.model.Database;
import ru.testScandJavaJsp.model.DatabaseList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.View;
import java.io.IOException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 15 on 03.04.2017.
 */
public class ReportOut extends Dispatcher {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String protocol = req.getProtocol();
        String msg = "421";
        RequestDispatcher view = req.getRequestDispatcher("/index.jsp");
        // don't add your web-app name to the path
        Set<Database> set = new HashSet<>();
        for (int i=0;i<DatabaseList.list.size(); i++)
        {
            set.add(DatabaseList.list.get(i));
        }

//        set.add(new Database(0,LocalDate.of(2015, Month.NOVEMBER, 8),"All performers","report111"));

        req.setAttribute("l", set);
        view.forward(req, resp);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.print("\"Hello\"");
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
        ArrayList<Database> newList = new ArrayList<>();

        Set<Database> set = new HashSet<>();
        for (int i=0;i<DatabaseList.list.size(); i++)
        {
            set.add(DatabaseList.list.get(i));
        }

//        set.add(new Database(0,LocalDate.of(2015, Month.NOVEMBER, 8),"All performers","report111"));

        request.setAttribute("l", set);
//        request.getRequestDispatcher("/index.jsp").forward(request, response);

        for (int i = 0; i < DatabaseList.list.size(); i++) {
            if
                    (DatabaseList.list.get(i).getDate().compareTo(LocalDate.parse(request.getParameter("startDate"))) >= 0
                    && DatabaseList.list.get(i).getDate().compareTo(LocalDate.parse(request.getParameter("endDate"))) <= 0
                    && DatabaseList.list.get(i).getPerformer().equals(request.getParameter("performer"))
                    ) {
                String performer = request.getParameter("performer");
//                String activity = request.getParameter("activity");
                Database newBase = new Database();

                newBase.setPerformer(performer);

                newBase.setActivity(DatabaseList.list.get(i).getActivity());
//                newBase.setActivity(activity);
                newList.add(newBase);
            }
        }
//            ctx.setAttribute("user", newBase);
            request.setAttribute("users", newList);

            if (newList.size()>0) {
              request.getRequestDispatcher("/success.jsp").forward(request, response);
            }
            else request.getRequestDispatcher("/error.jsp").forward(request, response);
            //                this.forward("/success.jsp", request, response);

        }


    //    }} else {
//                this.forward("/successLogin.jsp", request, response);
//            }
//}











}