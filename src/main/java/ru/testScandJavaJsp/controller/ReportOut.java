package ru.testScandJavaJsp.controller;

//import org.hibernate.jpa.criteria.expression.function.AggregationFunction;
import ru.testScandJavaJsp.dao.ComboBoxDateList;
import ru.testScandJavaJsp.model.Database;
import ru.testScandJavaJsp.dao.DatabaseList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
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

                    if (comboBoxDate.equals("Last Qrt")) {
                        switch (LocalDate.now().getMonthValue())
                        {
                            case 1:
                            case 2:
                            case 3:
                                startDate = LocalDate.of(LocalDate.now().minusYears(1).getYear(), Month.OCTOBER, 1);
                                endDate = LocalDate.of(LocalDate.now().minusYears(1).getYear(), Month.DECEMBER, 31);
                                break;
                            case 4:
                            case 5:
                            case 6:
                                startDate = LocalDate.of(LocalDate.now().getYear(), Month.JANUARY, 1);
                                endDate = LocalDate.of(LocalDate.now().getYear(), Month.MARCH, 31);
                                break;
                            case 7:
                            case 8:
                            case 9:
                                startDate = LocalDate.of(LocalDate.now().getYear(), Month.APRIL, 1);
                                endDate = LocalDate.of(LocalDate.now().getYear(), Month.JUNE, 30);
                                break;
                            case 10:
                            case 11:
                            case 12:
                                startDate = LocalDate.of(LocalDate.now().getYear(), Month.JULY, 1);
                                endDate = LocalDate.of(LocalDate.now().getYear(), Month.SEPTEMBER, 30);
                                break;
                        }
                    }

                    if (comboBoxDate.equals("Last Month")) {
                        startDate = LocalDate.now().minusMonths(1).withDayOfMonth(1);

                        switch (LocalDate.now().minusMonths(1).getMonthValue())
                        {
                            case 1:
                            case 3:
                            case 5:
                            case 7:
                            case 8:
                            case 10:
                            case 12:
                                endDate = LocalDate.now().minusMonths(1).withDayOfMonth(31);
                                break;
                            case 2:
                                if (((Year.now().getValue()% 4==0)
                                        &&!(Year.now().getValue()%100==0))
                                        ||(Year.now().getValue()%400==0))
                                    endDate = LocalDate.now().minusMonths(1).withDayOfMonth(29);
                                else
                                    endDate = LocalDate.now().minusMonths(1).withDayOfMonth(28);
                                break;
                            case 4:
                            case 6:
                            case 9:
                            case 11:
                                endDate = LocalDate.now().minusMonths(1).withDayOfMonth(30);
                                break;
                        }
                    }

                    if (comboBoxDate.equals("Last Calendar Year")) {
                        startDate = LocalDate.now().withDayOfYear(1).minusYears(1);
                        if (((Year.now().minusYears(1).getValue()%4==0)
                                &&!(Year.now().minusYears(1).getValue()%100==0))
                                ||(Year.now().minusYears(1).getValue()%400==0))
                            endDate = LocalDate.now().minusYears(1).withDayOfYear(366);
                        else
                            endDate = LocalDate.now().minusYears(1).withDayOfYear(365);
                    }

                    if (comboBoxDate.equals("Current Year to Date")) {
                        startDate = LocalDate.now().withDayOfYear(1);
                        endDate = LocalDate.now();
                    }

                    if (comboBoxDate.equals("Current Qrt to Date")) {
                        endDate = LocalDate.now();
                        switch (LocalDate.now().getMonthValue())
                        {
                            case 1:
                            case 2:
                            case 3:
                                startDate = LocalDate.of(LocalDate.now().getYear(), Month.JANUARY, 1);
                                break;
                            case 4:
                            case 5:
                            case 6:
                                startDate = LocalDate.of(LocalDate.now().getYear(), Month.APRIL, 1);
                                break;
                            case 7:
                            case 8:
                            case 9:
                                startDate = LocalDate.of(LocalDate.now().getYear(), Month.JULY, 1);
                                break;
                            case 10:
                            case 11:
                            case 12:
                                startDate = LocalDate.of(LocalDate.now().getYear(), Month.OCTOBER, 1);
                                break;
                        }
                    }

                    if (comboBoxDate.equals("Current Month to Date")) {
                        startDate = LocalDate.now().withDayOfMonth(1);
                        endDate = LocalDate.now();
                    }


                    if
                            (
                            DatabaseList.list.get(i).getDate().compareTo(startDate) >= 0
                                    && DatabaseList.list.get(i).getDate().compareTo(endDate) <= 0
                                    &&
                                    DatabaseList.list.get(i).getPerformer().equals(request.getParameter("performer"))
                            ) {

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