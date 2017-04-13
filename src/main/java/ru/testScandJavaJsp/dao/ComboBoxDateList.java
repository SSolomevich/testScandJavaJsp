package ru.testScandJavaJsp.dao;

import ru.testScandJavaJsp.model.ComboBoxDate;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Sergey Solomevich on 08.04.2017.
 */
// лист для всех комбо боксов, можно точно так же создать и подключить БД как и для DatabaseList
public class ComboBoxDateList {
    public static List<ComboBoxDate> list = Arrays.asList(
            new ComboBoxDate("Last Qrt"),
            new ComboBoxDate("Last Month"),
            new ComboBoxDate("Last Calendar Year"),
            new ComboBoxDate("Current Year to Date"),
            new ComboBoxDate("Current Qrt to Date"),
            new ComboBoxDate("Current Month to Date")
    );
}
