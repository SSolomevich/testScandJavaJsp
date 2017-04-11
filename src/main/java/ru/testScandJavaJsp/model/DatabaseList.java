package ru.testScandJavaJsp.model;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;

/**
 * Created by 15 on 02.04.2017.
 */
public class DatabaseList {

//    public static  List<Database> list = Arrays.asList(
//       new Database(1, LocalDate.of(2017, Month.APRIL, 8),"Anton","report1"),
//       new Database(2, LocalDate.of(2016, Month.FEBRUARY, 26),"Anton","report2"),
//       new Database(3, LocalDate.of(2016, Month.FEBRUARY, 29),"Sergey","report3"),
//       new Database(4, LocalDate.of(2017, Month.MAY, 3),"Sergey","report4"),
//       new Database(5, LocalDate.of(2015, Month.APRIL, 14),"Daria","report5"),
//       new Database(6, LocalDate.of(2016, Month.SEPTEMBER, 23),"Anton","report6"),
//       new Database(7, LocalDate.of(2016, Month.DECEMBER, 31),"Sergey","report7"),
//       new Database(8, LocalDate.of(2017, Month.FEBRUARY, 27),"Daria","report8"),
//       new Database(9, LocalDate.of(2014, Month.MAY, 4),"Daria","report9"),
//       new Database(10, LocalDate.of(2017, Month.MARCH, 17),"Daria","report10")
//    );

    public static  List<Database> list2 = new ArrayList<>();
    public static  List<Database> list = a(list2);
    // JDBC URL, username and password of MySQL server
    private static final String url = "jdbc:mysql://localhost:3306/test_scand";
    private static final String user = "root";
    private static final String password = "root";

    // JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

//    public static void main(String args[]) {
    public static List<Database>  a(List<Database> list) {
        String query = "select * from reports";

        try {
            // opening database connection to MySQL server
            DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
            con = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                Database database = new Database();
                database.setId(rs.getInt("id"));

                database.setDate(rs.getDate("date").toLocalDate());
                database.setPerformer(rs.getString("performer"));
                database.setActivity(rs.getString("activity"));
                list.add(database);
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try {
                con.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                rs.close();
            } catch (SQLException se) { /*can't do anything */ }
        }
//        for (int i=0; i<list.size();i++)
//        {
//            System.out.println(list.get(i).getActivity());
//        }
    return list;

    }


}
