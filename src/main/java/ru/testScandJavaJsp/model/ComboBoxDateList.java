package ru.testScandJavaJsp.model;

import java.util.Arrays;
import java.util.List;

/**
 * Created by 15 on 08.04.2017.
 */
public class ComboBoxDateList {


    public static List<ComboBoxDate> list = Arrays.asList(

            new ComboBoxDate("Last Calendar Year"),
            new ComboBoxDate("Next Calendar Year"),
            new ComboBoxDate("Last Qtr"),
            new ComboBoxDate("Next Qtr")
    );
}
