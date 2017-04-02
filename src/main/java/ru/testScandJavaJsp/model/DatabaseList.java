package ru.testScandJavaJsp.model;

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

    public static final List<Database> list = Arrays.asList(
       new Database(1, LocalDateTime.of(2015, Month.MAY, 28, 10, 0),"Anton","report1"),
       new Database(1, LocalDateTime.of(2015, Month.MAY, 29, 10, 0),"Anton","report2"),
       new Database(1, LocalDateTime.of(2015, Month.MAY, 29, 10, 0),"Sergey","report1"),
       new Database(1, LocalDateTime.of(2015, Month.MAY, 29, 10, 0),"Sergey","report2"),
       new Database(1, LocalDateTime.of(2015, Month.MAY, 26, 10, 0),"Daria","report1")
    );

}
