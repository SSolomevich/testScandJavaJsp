package ru.testScandJavaJsp.controller;

import ru.testScandJavaJsp.model.ComboBoxDateList;
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
        Set<String> set1 = new HashSet<>();
        for (int i=0;i<DatabaseList.list.size(); i++)
        {
            set1.add(DatabaseList.list.get(i).getPerformer());
        }

        req.setAttribute("list", set1);
//        view.forward(req, resp);


        Set<String> set2 = new HashSet<>();
        for (int i = 0; i< ComboBoxDateList.list.size(); i++)
        {
            set2.add(ComboBoxDateList.list.get(i).getComboBoxDate());
        }

        req.setAttribute("listComboBox", set2);
        view.forward(req, resp);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        ServletContext ctx = getServletContext();
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("yyyy-MM-dd");
        ArrayList<Database> newList = new ArrayList<>();

        Set<String> set = new HashSet<>();
        for (int i=0;i<DatabaseList.list.size(); i++)
        {
            set.add(DatabaseList.list.get(i).getPerformer());
        }
        request.setAttribute("list", set);

        Set<String> set2 = new HashSet<>();
        for (int i = 0; i< ComboBoxDateList.list.size(); i++)
        {
            set2.add(ComboBoxDateList.list.get(i).getComboBoxDate());
        }
        request.setAttribute("listComboBox", set2);



        if (    request.getParameter("performer").isEmpty()

                || request.getParameter("startDate").isEmpty() && request.getParameter("comboBoxDate").isEmpty()
                || request.getParameter("endDate").isEmpty() && request.getParameter("comboBoxDate").isEmpty()
                ) {
            request.getRequestDispatcher("/errorDateOrPerformer.jsp").forward(request, response);
        }

        else {
            for (int i = 0; i < DatabaseList.list.size(); i++) {
                if (
                        !request.getParameter("startDate").isEmpty()
                                &&
                                !request.getParameter("endDate").isEmpty()) {

                    if
                            (DatabaseList.list.get(i).getDate().compareTo(LocalDate.parse(request.getParameter("startDate"))) >= 0
                            && DatabaseList.list.get(i).getDate().compareTo(LocalDate.parse(request.getParameter("endDate"))) <= 0
                            && DatabaseList.list.get(i).getPerformer().equals(request.getParameter("performer"))
                            ) {
//                        String performer = request.getParameter("performer");
                        Database newBase = new Database();
                        newBase.setId(DatabaseList.list.get(i).getId());
                        newBase.setActivity(DatabaseList.list.get(i).getActivity());
                        newBase.setDate(DatabaseList.list.get(i).getDate());
                        newList.add(newBase);
                    }

                } else if (!request.getParameter("comboBoxDate").isEmpty()) {
                    LocalDate startDate = LocalDate.now();
                    LocalDate endDate = LocalDate.now();
                    String comboBoxDate = request.getParameter("comboBoxDate");

//                Перебираем все варианты Time period
                    if (comboBoxDate.equals("Last Calendar Year")) {
                        startDate = LocalDate.now().withDayOfYear(1).minusYears(1);
                        endDate = LocalDate.now().withDayOfYear(365).minusYears(1);
                    }
                    if (comboBoxDate.equals("Next Calendar Year")) {
                        startDate = LocalDate.now().withDayOfYear(1).plusYears(1);
                        endDate = LocalDate.now().withDayOfYear(365).plusYears(1);
                    }
//                if (comboBoxDate.equals("Next Calendar Year")) {
//                    startDate = LocalDate.now().;
//                    endDate = LocalDate.now().withDayOfYear(365).plusYears(1);
//                }


                    if
                            (
                            DatabaseList.list.get(i).getDate().compareTo(startDate) >= 0
                                    && DatabaseList.list.get(i).getDate().compareTo(endDate) <= 0
                                    &&
                                    DatabaseList.list.get(i).getPerformer().equals(request.getParameter("performer"))
                            ) {
//                        String performer = request.getParameter("performer");
                        Database newBase = new Database();
                        newBase.setId(DatabaseList.list.get(i).getId());
                        newBase.setActivity(DatabaseList.list.get(i).getActivity());
                        newBase.setDate(DatabaseList.list.get(i).getDate());
                        newList.add(newBase);
                    }
                }
            }

            request.setAttribute("users", newList);
            if (newList.size() > 0) {
                request.getRequestDispatcher("/success.jsp").forward(request, response);
            } else request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
        }














}