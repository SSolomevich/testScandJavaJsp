package ru.testScandJavaJsp.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 15 on 02.04.2017.
 */
public class DatabaseList {

    public static  List<Database> list = Arrays.asList(
       new Database(1, LocalDate.of(2015, Month.MAY, 28),"Anton","report1"),
       new Database(2, LocalDate.of(2016, Month.MAY, 29),"Anton","report2"),
       new Database(3, LocalDate.of(2015, Month.MAY, 29),"Sergey","report3"),
       new Database(4, LocalDate.of(2017, Month.MAY, 29),"Sergey","report4"),
       new Database(5, LocalDate.of(2015, Month.MAY, 26),"Daria","report5"),
       new Database(6, LocalDate.of(2019, Month.MAY, 28),"Anton","report6"),
       new Database(7, LocalDate.of(2011, Month.MAY, 29),"Sergey","report7")
    );

}
